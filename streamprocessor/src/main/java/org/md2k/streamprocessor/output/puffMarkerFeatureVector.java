package org.md2k.streamprocessor.output;

import android.content.Context;

import org.md2k.datakitapi.datatype.DataTypeDoubleArray;
import org.md2k.datakitapi.source.METADATA;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceType;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Nazir Saleheen <nsleheen@memphis.edu>
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
public class puffMarkerFeatureVector extends Output {
    public puffMarkerFeatureVector(Context context) {
        super(context, DataSourceType.PUFFMARKER_FEATURE_VECTOR);
    }

    ArrayList<HashMap<String, String>> createDataDescriptor() {
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> dataDescriptor;

        // (1)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration duration from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (2)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Expiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the expiration duration from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (3)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Respiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the respiration duration from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (4)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Expiration_ratio");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration expiration ratio from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (5)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (6)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Upper_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch in upward direction from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (7)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Lower_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch in downward direction from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (8)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Backward_Inspiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the inspiration duration values from their previous from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (9)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Backward_Expiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the expiration duration values from their previous from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (10)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Backward_Respiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the respiration duration values from their previous from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (11)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Backward_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents first order differences of the stretch values from their previous from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (12)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Forward_Inspiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the inspiration duration values from their next from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (13)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Forward_Expiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the expiration duration values from their next from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (14)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Forward_Respiration_Duration");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the first order differences of the respiration duration values from their next from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (15)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Forward_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents first order differences of the stretch values from their next from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (16)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_d5_Expiration");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the ratio of its expiration duration to the average expiration duration value in a window of five cycles from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (17)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_d5_Stretch");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the ratio of its stretch to the average stretch value in a window of five cycles from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (18)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Max_Rate_of_Change");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the maximum rate of change of signal from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (19)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Min_Rate_of_Change");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the minimum rate of change of signal from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (20)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_Gyro_Magnitude");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "average");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the mean of magnitude of gyroscope of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (21)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_Gyro_Magnitude");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "median");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the median of magnitude of gyroscope of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (22)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_Gyro_Magnitude");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "standard deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the standard deviation of magnitude of gyroscope of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (23)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_Gyro_Magnitude");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "quartile deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the quartile deviation of magnitude of gyroscope of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (25)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_pitch");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "average");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the mean of pitch  of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (26)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_pitch");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "median");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the median of pitch of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (27)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_pitch");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "standard deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the standard deviation of pitch of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (28)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_pitch");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "quartile deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the quartile deviation of pitch of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (29)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_roll");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "average");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the mean of roll of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (30)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_roll");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "median");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the median of roll of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (31)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_roll");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "standard deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the standard deviation of roll of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (32)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "WRIST_roll");
        dataDescriptor.put(METADATA.UNIT, "degree");
        dataDescriptor.put(METADATA.DESCRIPTIVESTATISTICS, "quartile deviation");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the quartile deviation of roll of Autosense wrist");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (33)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "rStime - wStime");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the time difference between respiration starttime and wrist segment starttime");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (34)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "rEtime - wStime");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the time difference between respiration endtime and wrist segment starttime");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (35)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "rStime - wEtime");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the time difference between respiration starttime and wrist segment endtime");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (36)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "rEtime - wEtime");
        dataDescriptor.put(METADATA.UNIT, "ms");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the time difference between respiration endtime and wrist segment endtime");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        return result;
    }

    public DataSourceBuilder createDataSourceBuilder() {
        DataSourceBuilder dataSourceBuilder = super.createDataSourceBuilder();
        if (dataSourceBuilder == null) return null;
        dataSourceBuilder = dataSourceBuilder.setDataDescriptors(createDataDescriptor());
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.FREQUENCY, "0.0167 Hz");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.NAME, "puffMarker Feature Vector");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.DESCRIPTION, "Represents the 36 features used by the puffMarker algorithm");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.DATA_TYPE, DataTypeDoubleArray.class.getName());
        return dataSourceBuilder;
    }
}
