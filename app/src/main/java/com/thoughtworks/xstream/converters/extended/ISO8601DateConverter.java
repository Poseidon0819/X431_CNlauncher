package com.thoughtworks.xstream.converters.extended;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class ISO8601DateConverter extends ISO8601GregorianCalendarConverter {
    @Override // com.thoughtworks.xstream.converters.extended.ISO8601GregorianCalendarConverter, com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Date.class);
    }

    @Override // com.thoughtworks.xstream.converters.extended.ISO8601GregorianCalendarConverter, com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return ((Calendar) super.fromString(str)).getTime();
    }

    @Override // com.thoughtworks.xstream.converters.extended.ISO8601GregorianCalendarConverter, com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) obj);
        return super.toString(calendar);
    }
}
