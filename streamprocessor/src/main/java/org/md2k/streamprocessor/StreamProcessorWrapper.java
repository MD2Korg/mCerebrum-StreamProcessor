package org.md2k.streamprocessor;

import android.content.Context;
import android.util.Log;

import org.md2k.datakitapi.datatype.DataTypeDouble;
import org.md2k.datakitapi.datatype.DataTypeDoubleArray;
import org.md2k.utilities.FileManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import md2k.mcerebrum.CSVDataPoint;
import md2k.mcerebrum.cstress.StreamProcessor;
import md2k.mcerebrum.cstress.library.Time;
import md2k.mcerebrum.cstress.library.datastream.DataPointInterface;
import md2k.mcerebrum.cstress.library.structs.DataPoint;
import md2k.mcerebrum.cstress.library.structs.DataPointArray;

import static org.md2k.streamprocessor.Constants.STREAM_PROCESSOR_STATE_FILE;

/*
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class StreamProcessorWrapper {
    private static final String TAG = StreamProcessorWrapper.class.getSimpleName();
    protected StreamProcessor streamProcessor;
    protected int windowSize = 60000;
    protected long windowStartTime = -1;
    protected OnReceiveListener onReceiveListener;
    private List<CSVDataPoint> dataBuffer;
    private Thread t;
    private String persistState = "";

    public StreamProcessorWrapper(Context context, final OnReceiveListener onReceiveListener) {
        streamProcessor = new StreamProcessor(windowSize);

        persistState = FileManager.getDirectory(context, FileManager.INTERNAL_SDCARD_PREFERRED) + STREAM_PROCESSOR_STATE_FILE;
        File file = new File(persistState);
        if(file.exists())
            streamProcessor.importDatastreams(persistState);

        InputStream ins = context.getResources().openRawResource(R.raw.cstress_model_ecg_rip);
        streamProcessor.loadModelFromString("cStressModel", readTextFile(ins));

        ins = context.getResources().openRawResource(R.raw.cstress_model_rip);
        streamProcessor.loadModelFromString("cStressRIPModel", readTextFile(ins));

        ins = context.getResources().openRawResource(R.raw.puffmarker_model);
        streamProcessor.loadModelFromString("puffMarkerModel", readTextFile(ins));


        this.onReceiveListener = onReceiveListener;

        dataBuffer = new ArrayList<>(25000);

        streamProcessor.dpInterface = new DataPointInterface() {
            @Override
            public void dataPointHandler(String stream, DataPoint dp) {
                DataTypeDouble dataTypeDouble = new DataTypeDouble(dp.timestamp, dp.value);
                onReceiveListener.onReceived(stream, dataTypeDouble);
                Log.d("Stream Processor", stream + " : " + dp.toString());
            }

            @Override
            public void dataPointArrayHandler(String stream, DataPointArray dp) {
                double[] value = new double[dp.value.size()];
                for (int i = 0; i < dp.value.size(); i++)
                    value[i] = dp.value.get(i);
                DataTypeDoubleArray dataTypeDoubleArray = new DataTypeDoubleArray(dp.timestamp, value);
                onReceiveListener.onReceived(stream, dataTypeDoubleArray);
                Log.d("Stream Processor", stream + " : " + dp.toString());
            }
        };
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    protected void addDataPoint(CSVDataPoint point) {

        dataBuffer.add(point);

        if (windowStartTime < 0)
            windowStartTime = Time.nextEpochTimestamp(point.timestamp, windowSize);

        if ((point.timestamp - windowStartTime) >= windowSize) { //Process the buffer every windowSize milliseconds
            Log.d(TAG, "Stream Processor Iteration Running: " + point.timestamp);
            Log.d(TAG, "Data buffer size: " + dataBuffer.size());
            for (CSVDataPoint ap : dataBuffer) {
                DataPoint dp = new DataPoint(ap.timestamp, ap.value);
                streamProcessor.add(ap.channel, dp);
            }
            dataBuffer.clear();

            if (t != null && t.isAlive()) {
                try {
                    t.join(); //Block until thread completes
                } catch (InterruptedException e) {
                    Log.e(TAG, "Error in waiting on Thread to stop");
                }
            }
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    long starttime = System.currentTimeMillis();
                    streamProcessor.go();
                    streamProcessor.exportDatastreams(persistState);
                    long endtime = System.currentTimeMillis();
                    Log.d(TAG, "Loop iteration in seconds: " + (endtime - starttime) / 1000.0);
                }
            });
            t.setPriority(1);
            t.start();
            windowStartTime += windowSize;
        }
    }
}
