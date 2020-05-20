package com.thoughtworks.xstream.converters.basic;

import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes2.dex */
public class ShortConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Short.TYPE) || cls.equals(Short.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        int intValue = Integer.decode(str).intValue();
        if (intValue < -32768 || intValue > 65535) {
            throw new NumberFormatException("For input string: \"" + str + TokenParser.DQUOTE);
        }
        return new Short((short) intValue);
    }
}
