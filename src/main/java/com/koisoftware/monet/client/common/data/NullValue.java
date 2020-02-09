package com.koisoftware.monet.client.common.data;

/**
 * The class serves to store null criteria values.
 */
public final class NullValue extends BaseValue {
    public static final NullValue INSTANCE = new NullValue();

    private NullValue() {

    }

    public java.io.Serializable getValue() {
        return null;
    }

}
