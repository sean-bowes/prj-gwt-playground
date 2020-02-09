package com.koisoftware.monet.client.common.type;

public interface ITypeConverter<T1, T2> {
    T2 convertFrom(T1 object);

    T1 convertTo(T2 object);
}
