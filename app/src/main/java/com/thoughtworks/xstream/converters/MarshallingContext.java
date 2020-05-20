package com.thoughtworks.xstream.converters;

/* loaded from: classes2.dex */
public interface MarshallingContext extends DataHolder {
    void convertAnother(Object obj);

    void convertAnother(Object obj, Converter converter);
}
