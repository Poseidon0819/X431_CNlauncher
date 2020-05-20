package com.thoughtworks.xstream.converters.basic;

import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes2.dex */
public class ByteConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Byte.TYPE) || cls.equals(Byte.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        int intValue = Integer.decode(str).intValue();
        if (intValue < -128 || intValue > 255) {
            throw new NumberFormatException("For input string: \"" + str + TokenParser.DQUOTE);
        }
        return new Byte((byte) intValue);
    }
}
