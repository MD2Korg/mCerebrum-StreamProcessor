package org.md2k.streamprocessor.output;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.datatype.DataType;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.source.application.Application;
import org.md2k.datakitapi.source.application.ApplicationBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.source.platform.Platform;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.datakitapi.source.platform.PlatformType;
import org.md2k.streamprocessor.Constants;
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
public abstract class Output {
    Context context;
    String dataSourceType;
    DataKitAPI dataKitAPI;
    DataSourceClient dataSourceClient;

    Output(Context context, String dataSourceType){
        this.context=context;
        this.dataSourceType=dataSourceType;
        dataKitAPI = DataKitAPI.getInstance(context);
    }
    public DataSourceBuilder createDataSourceBuilder() {
        Platform platform = new PlatformBuilder().setType(PlatformType.PHONE).build();
        ApplicationBuilder applicationBuilder=new ApplicationBuilder();
        applicationBuilder.setId(context.getApplicationInfo().packageName);
        applicationBuilder.setType(context.getApplicationInfo().name);
        Application application=applicationBuilder.build();
        return new DataSourceBuilder().setId(null).setType(dataSourceType).setPlatform(platform).setApplication(application);
    }
    public void register() {
        try {
            dataSourceClient = dataKitAPI.register(createDataSourceBuilder());
        } catch (DataKitException e) {
            Toast.makeText(context, "Unable to register data source", Toast.LENGTH_SHORT).show();
            Log.d("md2k", "here 4");
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Constants.INTENT_STOP));
            e.printStackTrace();
        }

    }
    public void unregister(){
        try {
            dataKitAPI.unregister(dataSourceClient);
        } catch (DataKitException e) {
            Toast.makeText(context, "Unable to unregister data source", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void insert(DataType dataType) throws DataKitException {
        dataKitAPI.insert(dataSourceClient, dataType);
    }
}
