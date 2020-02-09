package com.koisoftware.monet.client.common.type;

import java.io.Serializable;
import java.util.EnumSet;

public enum DataType implements Serializable {
    INTEGER, LONG, FLOAT, DOUBLE, BIGDECIMAL, DATE, TIMESTAMP, STRING, BOOLEAN;

    public final static EnumSet<DataType> NUMBERS = EnumSet.of(DataType.INTEGER, DataType.LONG, DataType.FLOAT, DataType.DOUBLE,
            DataType.BIGDECIMAL);
    public final static EnumSet<DataType> DATES = EnumSet.of(DataType.DATE, DataType.TIMESTAMP);

    public static boolean isNumber(DataType dataType) {
        return NUMBERS.contains(dataType);
    }

    public static boolean isDateType(DataType dataType) {
        return DATES.contains(dataType);
    }
}
