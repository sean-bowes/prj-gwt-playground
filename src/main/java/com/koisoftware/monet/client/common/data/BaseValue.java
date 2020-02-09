package com.koisoftware.monet.client.common.data;

import java.io.Serializable;

/**
 * The class serves as the base value for storing criteria values.
 */
public class BaseValue implements IValue {
    public Serializable getValue() {
        return null;
    }

    public Serializable getClientSideValue() {
        return getValue();
    }

    public Serializable getConstructor() {
        return null;
    }

}
