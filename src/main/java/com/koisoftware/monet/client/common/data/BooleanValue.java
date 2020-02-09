package com.koisoftware.monet.client.common.data;

/**
 * The class serves as the base value for storing boolean criteria values.
 */
public class BooleanValue extends BaseValue {
    private Boolean booleanValue;

    private BooleanValue() {

    }

    public BooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public Boolean getValue() {
        return booleanValue;
    }


}
