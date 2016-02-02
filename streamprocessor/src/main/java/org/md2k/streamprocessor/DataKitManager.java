package org.md2k.streamprocessor;

import android.content.Context;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.datatype.DataType;
import org.md2k.datakitapi.datatype.DataTypeInt;
import org.md2k.datakitapi.messagehandler.OnReceiveListener;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.datakitapi.source.platform.PlatformType;
import org.md2k.streamprocessor.output.Output;
import org.md2k.streamprocessor.output.StressLabel;
import org.md2k.streamprocessor.output.StressProbability;

import java.util.ArrayList;
import java.util.HashMap;

import md2k.mCerebrum.CSVDataPoint;
import md2k.mCerebrum.cStress.StreamConstants;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p/>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
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
public class DataKitManager {
    Context context;
    DataKitAPI dataKitAPI;
    StreamProcessorWrapper streamProcessorWrapper;
    HashMap<String,Integer> dataSourceTypeTOChannel;
    boolean active;
    HashMap<String,Output> outputHashMap;

    void createDataSourceTypeTOChannel(){
        dataSourceTypeTOChannel=new HashMap<>();
        dataSourceTypeTOChannel.put(DataSourceType.RESPIRATION,7);
        dataSourceTypeTOChannel.put(DataSourceType.ECG,0);
        dataSourceTypeTOChannel.put(DataSourceType.ACCELEROMETER_X, 1);
        dataSourceTypeTOChannel.put(DataSourceType.ACCELEROMETER_Y,2);
        dataSourceTypeTOChannel.put(DataSourceType.ACCELEROMETER_Z,3);
    }

    DataKitManager(Context context){
        this.context=context;
        dataKitAPI=DataKitAPI.getInstance(context);
        createDataSourceTypeTOChannel();
        streamProcessorWrapper=new StreamProcessorWrapper(new org.md2k.streamprocessor.OnReceiveListener() {
            @Override
            public void onReceived(String s, DataType value) {
                outputHashMap.get(s).insert(value);
            }
        });
        active=false;
    }
    void start(){
        outputHashMap=new HashMap<>();
        active=true;
        subscribe(PlatformType.AUTOSENSE_CHEST,DataSourceType.RESPIRATION);
        subscribe(PlatformType.AUTOSENSE_CHEST,DataSourceType.ECG);
        subscribe(PlatformType.AUTOSENSE_CHEST,DataSourceType.ACCELEROMETER_X);
        subscribe(PlatformType.AUTOSENSE_CHEST,DataSourceType.ACCELEROMETER_Y);
        subscribe(PlatformType.AUTOSENSE_CHEST,DataSourceType.ACCELEROMETER_Z);

        addListener(DataSourceType.STRESS_PROBABILITY);
        addListener(DataSourceType.STRESS_LABEL);
    }
    public boolean isActive(){
        return active;
    }
    void stop(){
        active=false;
    }
    public void addListener(String dataSourceType){
        Output output;
        switch (dataSourceType){
            case DataSourceType.STRESS_PROBABILITY:
                output=new StressProbability(context);
                output.register();
                streamProcessorWrapper.streamProcessor.registerCallbackDataStream(StreamConstants.ORG_MD2K_CSTRESS_PROBABILITY);

                break;
            case DataSourceType.STRESS_LABEL:
                output=new StressLabel(context);
                output.register();
                streamProcessorWrapper.streamProcessor.registerCallbackDataStream(StreamConstants.ORG_MD2K_CSTRESS_STRESSLABEL);
        }
    }
    public void subscribe(String platformType,final String dataSourceType){
        DataSourceClient dataSourceClient=findDataSourceClient(platformType,dataSourceType);
        dataKitAPI.subscribe(dataSourceClient, new OnReceiveListener() {
            @Override
            public void onReceived(DataType dataType) {
                DataTypeInt dataTypeInt=(DataTypeInt) dataType;
                CSVDataPoint csvDataPoint=new CSVDataPoint(dataSourceTypeTOChannel.get(dataSourceType),dataTypeInt.getDateTime(),dataTypeInt.getSample());
                streamProcessorWrapper.addDataPoint(csvDataPoint);
            }
        });

    }

    DataSourceClient findDataSourceClient(String platformType,String dataSourceType){
        PlatformBuilder platformBuilder=new PlatformBuilder().setType(platformType);
        DataSourceBuilder dataSourceBuilder=new DataSourceBuilder();
        dataSourceBuilder.setType(dataSourceType).setPlatform(platformBuilder.build());
        ArrayList<DataSourceClient> dataSourceClientArrayList=dataKitAPI.find(dataSourceBuilder);
        if(dataSourceClientArrayList.size()!=1) return null;
        return dataSourceClientArrayList.get(0);
    }
}
