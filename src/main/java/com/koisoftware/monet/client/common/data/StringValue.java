package com.koisoftware.monet.client.common.data;

/**
 * The class serves to store string criteria values.
 */
public class StringValue extends BaseValue {
    private String string;

    private StringValue() {
    }

    public StringValue(String value) {
        this.string = value;
    }

    public String getValue() {
        return string;
    }

}
