package com.thoughtworks.xstream.converters.basic;

/* loaded from: classes2.dex */
public class LongConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Long.TYPE) || cls.equals(Long.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        long parseLong;
        long parseLong2;
        int length = str.length();
        if (length != 0) {
            if (length < 17) {
                return Long.decode(str);
            }
            char charAt = str.charAt(0);
            if (charAt != '0' && charAt != '#') {
                return Long.decode(str);
            }
            char charAt2 = str.charAt(1);
            if (charAt == '#' && length == 17) {
                parseLong2 = Long.parseLong(str.substring(1, 9), 16) << 32;
                parseLong = Long.parseLong(str.substring(9, 17), 16);
            } else if ((charAt2 == 'x' || charAt2 == 'X') && length == 18) {
                parseLong = Long.parseLong(str.substring(10, 18), 16);
                parseLong2 = Long.parseLong(str.substring(2, 10), 16) << 32;
            } else if (length == 23 && charAt2 == '1') {
                parseLong = Long.parseLong(str.substring(12, 23), 8);
                parseLong2 = Long.parseLong(str.substring(1, 12), 8) << 33;
            } else {
                return Long.decode(str);
            }
            return new Long(parseLong | parseLong2);
        }
        throw new NumberFormatException("For input string: \"\"");
    }
}
