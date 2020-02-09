package com.koisoftware.monet.client.common.data;

import com.koisoftware.monet.client.common.type.DataType;

import java.io.Serializable;
import java.util.Date;

public class DataValue implements Serializable {
    public static final DataValue NULL = new DataValue();
    public static final DataValue TRUE = new DataValue(DataType.BOOLEAN, null, null, null, Boolean.TRUE);
    public static final DataValue FALSE = new DataValue(DataType.BOOLEAN, null, null, null, Boolean.FALSE);
    private String string;
    private Number number;
    private Date date;
    private Boolean boolenValue;
    private DataType dataType;

    private DataValue() {

    }

    private DataValue(DataType dataType, String string, Number number, Date date, Boolean boolenValue) {
        this.dataType = dataType;
        this.string = string;
        this.number = number;
        this.date = date;
        this.boolenValue = boolenValue;
    }

    public static DataValue valueOf(Date date) {
        return new DataValue(DataType.DATE, null, null, date, null);
    }

    public static DataValue valueOf(Number number) {
        return new DataValue(DataType.DOUBLE, null, number, null, null);
    }

    public static DataValue valueOf(String string) {
        return new DataValue(DataType.STRING, string, null, null, null);
    }

    public static DataValue valueOf(DataType dataType, Object value) {
        DataValue dataValue;
        switch (dataType) {
            case LONG:
                dataValue = new DataValue(dataType, null, (Number) value, null, null);
                break;
            case INTEGER:
                dataValue = new DataValue(dataType, null, (Number) value, null, null);
                break;
            case FLOAT:
                dataValue = new DataValue(dataType, null, (Number) value, null, null);
                break;
            case BIGDECIMAL:
                dataValue = new DataValue(dataType, null, (Number) value, null, null);
                break;
            case DOUBLE:
                dataValue = new DataValue(dataType, null, (Number) value, null, null);
                break;
            case DATE:
                dataValue = new DataValue(dataType, null, null, (Date) value, null);
                break;
            case TIMESTAMP:
                dataValue = new DataValue(dataType, null, null, (Date) value, null);
                break;
            case BOOLEAN:
                dataValue = new DataValue(dataType, null, null, null, (Boolean) value);
                break;
            case STRING:
                dataValue = new DataValue(dataType, (String) value, null, null, null);
                break;
            default:
                dataValue = new DataValue(dataType, (String) value, null, null, null);
                break;
        }
        return dataValue;
    }

    public String getString() {
        return string;
    }

    public Number getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getBoolenValue() {
        return boolenValue;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Object getValue() {
        if (string != null) {
            return string;
        }
        if (number != null) {
            return number;
        }
        if (date != null) {
            return date;
        }
        if (boolenValue != null) {
            return boolenValue;
        }
        return null;
    }
}
