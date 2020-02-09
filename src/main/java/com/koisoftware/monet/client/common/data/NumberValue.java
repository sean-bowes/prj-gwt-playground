package com.koisoftware.monet.client.common.data;

/**
 * The class serves to store number criteria values.
 */
public class NumberValue extends BaseValue {
    private Number number;

    private NumberValue() {
    }

    public NumberValue(Number value) {
        this.number = value;
    }

    public Number getValue() {
        return number;
    }

}
