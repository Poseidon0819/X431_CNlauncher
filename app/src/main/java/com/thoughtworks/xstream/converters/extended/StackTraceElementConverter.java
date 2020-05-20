package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class StackTraceElementConverter extends AbstractSingleValueConverter {
    private static final Pattern PATTERN = Pattern.compile("^(.+)\\.([^\\(]+)\\(([^:]*)(:(\\d+))?\\)$");
    private static final StackTraceElementFactory FACTORY = new StackTraceElementFactory();

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return StackTraceElement.class.equals(cls);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return super.toString(obj).replaceFirst(":\\?\\?\\?", "");
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            if (group3.equals("Unknown Source")) {
                return FACTORY.unknownSourceElement(group, group2);
            }
            if (group3.equals("Native Method")) {
                return FACTORY.nativeMethodElement(group, group2);
            }
            if (matcher.group(4) != null) {
                return FACTORY.element(group, group2, group3, Integer.parseInt(matcher.group(5)));
            }
            return FACTORY.element(group, group2, group3);
        }
        throw new ConversionException("Could not parse StackTraceElement : ".concat(String.valueOf(str)));
    }
}
