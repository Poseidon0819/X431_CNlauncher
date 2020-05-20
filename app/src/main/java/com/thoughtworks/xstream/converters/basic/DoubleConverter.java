package com.thoughtworks.xstream.converters.basic;

/* loaded from: classes2.dex */
public class DoubleConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Double.TYPE) || cls.equals(Double.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return Double.valueOf(str);
    }
}
