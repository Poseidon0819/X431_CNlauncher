package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/* loaded from: classes2.dex */
public abstract class AbstractSingleValueConverter implements SingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public abstract boolean canConvert(Class cls);

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public abstract Object fromString(String str);

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
