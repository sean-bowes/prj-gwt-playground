package com.koisoftware.monet.client.common.data;

import java.io.Serializable;
import java.util.Date;

/**
 * The class serves as the value for storing date criteria values.
 */
public class DateValue extends BaseValue {
    private Date date;
    private String clientValue;
    private String constructor;

    private DateValue() {
    }

    public DateValue(Date value, String clientValue, String constructor) {
        this.date = value;
        this.clientValue = clientValue;
        this.constructor = constructor;
    }

    public DateValue(Date value) {
        this.date = value;
    }

    public Date getValue() {
        return date;

    }

    public Serializable getClientSideValue() {
//		if (SmartGwtConstants.TYPE_RELATIVE_DATE.equals(constructor))
//		{
//			return clientValue;
//		}
        return date;
    }

    public Serializable getConstructor() {
        return constructor;
    }

}
