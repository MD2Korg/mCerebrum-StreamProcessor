package org.md2k.streamprocessor;

import android.util.Log;

import org.md2k.datakitapi.datatype.DataTypeDouble;
import org.md2k.datakitapi.datatype.DataTypeDoubleArray;

import md2k.mcerebrum.CSVDataPoint;
import md2k.mcerebrum.cstress.StreamProcessor;
import md2k.mcerebrum.cstress.library.Time;
import md2k.mcerebrum.cstress.library.datastream.DataPointInterface;
import md2k.mcerebrum.cstress.library.structs.DataPoint;
import md2k.mcerebrum.cstress.library.structs.DataPointArray;

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

    public StreamProcessorWrapper(final OnReceiveListener onReceiveListener) {
        streamProcessor = new StreamProcessor(windowSize);
        streamProcessor.loadModel("cStressModel", Constants.FILEPATH_MODEL);
        streamProcessor.loadModel("cStressRIPModel", Constants.FILEPATH_MODEL_RIP);
        this.onReceiveListener=onReceiveListener;

        streamProcessor.dpInterface = new DataPointInterface() {
            @Override
            public void dataPointHandler(String stream, DataPoint dp) {
                DataTypeDouble dataTypeDouble=new DataTypeDouble(dp.timestamp,dp.value);
                onReceiveListener.onReceived(stream, dataTypeDouble);
                Log.d("Stream Processor", stream + " : " + dp.toString());
            }

            @Override
            public void dataPointArrayHandler(String stream, DataPointArray dp) {
                double[] value=new double[dp.value.size()];
                for(int i=0;i<dp.value.size();i++)
                    value[i]=dp.value.get(i);
                DataTypeDoubleArray dataTypeDoubleArray=new DataTypeDoubleArray(dp.timestamp,value);
                onReceiveListener.onReceived(stream, dataTypeDoubleArray);
                Log.d("Stream Processor", stream + " : " + dp.toString());
            }
        };
    }

    protected void addDataPoint(CSVDataPoint ap) {
        DataPoint dp = new DataPoint(ap.timestamp, ap.value);
        streamProcessor.add(ap.channel, dp);
        if (windowStartTime < 0)
            windowStartTime = Time.nextEpochTimestamp(dp.timestamp, windowSize);

        if ((dp.timestamp - windowStartTime) >= windowSize) { //Process the buffer every windowSize milliseconds
            long starttime = System.currentTimeMillis();
            streamProcessor.go();
            long endtime = System.currentTimeMillis();
            Log.d(TAG, "Loop iteration in seconds: " + (endtime - starttime) / 1000.0);
            windowStartTime += windowSize;
        }
    }
}
