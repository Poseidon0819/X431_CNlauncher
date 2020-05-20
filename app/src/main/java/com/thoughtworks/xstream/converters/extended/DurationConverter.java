package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/* loaded from: classes2.dex */
public class DurationConverter extends AbstractSingleValueConverter {
    private final DatatypeFactory factory;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.thoughtworks.xstream.converters.extended.DurationConverter$1] */
    public DurationConverter() {
        this(new Object() { // from class: com.thoughtworks.xstream.converters.extended.DurationConverter.1
            DatatypeFactory getFactory() {
                try {
                    return DatatypeFactory.newInstance();
                } catch (DatatypeConfigurationException unused) {
                    return null;
                }
            }
        }.getFactory());
    }

    public DurationConverter(DatatypeFactory datatypeFactory) {
        this.factory = datatypeFactory;
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return this.factory != null && Duration.class.isAssignableFrom(cls);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return this.factory.newDuration(str);
    }
}
