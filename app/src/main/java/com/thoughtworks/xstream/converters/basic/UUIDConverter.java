package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import java.util.UUID;

/* loaded from: classes2.dex */
public class UUIDConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(UUID.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Cannot create UUID instance", e);
        }
    }
}
