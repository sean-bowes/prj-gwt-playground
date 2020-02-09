package com.koisoftware.monet.client.common.data;

import java.io.Serializable;

/**
 * The interface for criteria values.
 */
public interface IValue extends Serializable {
    Serializable getValue();

    Serializable getClientSideValue();

    Serializable getConstructor();
}
