package org.md2k.streamprocessor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.messagehandler.OnConnectionListener;
import org.md2k.utilities.Report.Log;

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

public class ServiceStreamProcessor extends Service {
    private static final String TAG = ServiceStreamProcessor.class.getSimpleName();
    protected DataKitAPI dataKitAPI;
    protected DataKitManager dataKitManager;

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        connectDataKit();
    }

    private void connectDataKit() {
        Log.d(TAG, "connectDataKit()...");
        dataKitAPI = DataKitAPI.getInstance(getApplicationContext());
        try {
            dataKitAPI.connect(new OnConnectionListener() {
                @Override
                public void onConnected() {
                    Log.d(TAG, "onConnected()...");
                    dataKitManager = new DataKitManager(ServiceStreamProcessor.this);
                    try {
                        dataKitManager.start();
                    } catch (DataKitException e) {
                        Toast.makeText(ServiceStreamProcessor.this, "Unable to start Service", Toast.LENGTH_SHORT).show();
                        dataKitManager.stop();
                        e.printStackTrace();
                    }
                }
            });
        } catch (DataKitException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        if(dataKitManager.isActive())
            dataKitManager.stop();
        if (dataKitAPI != null && dataKitAPI.isConnected()) dataKitAPI.disconnect();
        if (dataKitAPI != null)
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
