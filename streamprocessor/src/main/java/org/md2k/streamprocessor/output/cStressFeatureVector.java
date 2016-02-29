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
 * - Timothy Hnat <twhnat@memphis.edu>
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
public class cStressFeatureVector extends Output {
    public cStressFeatureVector(Context context) {
        super(context, DataSourceType.CSTRESS_FEATURE_VECTOR);
    }

    ArrayList<HashMap<String, String>> createDataDescriptor() {
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> dataDescriptor;
        // (1)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Variance");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the variance of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (2)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Low_High_Frequency_Energy_Ratio");
        dataDescriptor.put(METADATA.UNIT, "ratio");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the ratio between low and high frequency energies");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (3)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_High_Frequency_Energy");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents high frequency energy");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (4)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Medium_Frequency_Energy");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents medium frequency energy");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (5)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Low_Frequency_Energy");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents low frequency energy");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (6)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the mean of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (7)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the median of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (8)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the quartile deviation of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (9)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the 80th percentile of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (10)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_20thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the 20th percentile of RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (11)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "ECG_RR_Interval_Heart_Rate");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the average heart rate based on RR-intervals");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (12)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Breath_Rate");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the breath rate from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (13)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Minute_Ventilation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the minute ventilation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (14)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Duration_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration duration quartile deviation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (15)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Duration_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration duration mean from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (16)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Duration_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration duration median from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (17)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Duration_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration duration 80th percentile from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (18)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Expiration_Duration_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the expiration duration quartile deviation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (19)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Expiration_Duration_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the expiration duration mean from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (20)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Expiration_Duration_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the expiration duration median from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (21)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Expiration_Duration_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the expiration duration 80th percentile from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (22)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Respiration_Duration_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the respiration duration quartile deviation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (23)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Respiration_Duration_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the respiration duration mean from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (24)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Respiration_Duration_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the respiration duration median from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (25)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Respiration_Duration_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the respiration duration 80th percentile from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (26)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Expiration_Duration_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration expiration duration quartile deviation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (27)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Expiration_Duration_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration expiration duration mean from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (28)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Expiration_Duration_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration expiration duration median from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (29)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Inspiration_Expiration_Duration_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the inspiration expiration duration 80th percentile from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (30)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Stretch_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch quartile deviation from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (31)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Stretch_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch mean from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (32)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Stretch_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch median from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (33)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RIP_Stretch_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the stretch 80th percentile from the RIP data source");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        // (34)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RSA_Quartile_Deviation");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the RSA quartile deviation from the RSA computation");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (35)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RSA_Mean");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the RSA mean from the RSA computation");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (36)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RSA_Median");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the RSA median from the RSA computation");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);

        // (37)
        dataDescriptor = new HashMap<>();
        dataDescriptor.put(METADATA.NAME, "RSA_80thPercentile");
        dataDescriptor.put(METADATA.UNIT, "double");
        dataDescriptor.put(METADATA.FREQUENCY, "0.0167 Hz");
        dataDescriptor.put(METADATA.DESCRIPTION, "Represents the RSA 80th percentile from the RSA computation");
        dataDescriptor.put(METADATA.DATA_TYPE, double.class.getName());
        result.add(dataDescriptor);


        return result;
    }

    public DataSourceBuilder createDataSourceBuilder() {
        DataSourceBuilder dataSourceBuilder = super.createDataSourceBuilder();
        if (dataSourceBuilder == null) return null;
        dataSourceBuilder = dataSourceBuilder.setDataDescriptors(createDataDescriptor());
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.FREQUENCY, "0.0167 Hz");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.NAME, "cStress Feature Vector");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.UNIT, "vector");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.DESCRIPTION, "Represents the 37 features used by the cStress algorithm");
        dataSourceBuilder = dataSourceBuilder.setMetadata(METADATA.DATA_TYPE, DataTypeDoubleArray.class.getName());
        return dataSourceBuilder;
    }
}
