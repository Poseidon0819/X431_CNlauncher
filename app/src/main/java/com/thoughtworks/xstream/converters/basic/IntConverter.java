package com.thoughtworks.xstream.converters.basic;

import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes2.dex */
public class IntConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Integer.TYPE) || cls.equals(Integer.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        long longValue = Long.decode(str).longValue();
        if (longValue < -2147483648L || longValue > 4294967295L) {
            throw new NumberFormatException("For input string: \"" + str + TokenParser.DQUOTE);
        }
        return new Integer((int) longValue);
    }
}
