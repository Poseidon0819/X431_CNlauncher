package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class ToStringConverter extends AbstractSingleValueConverter {
    private final Class clazz;
    private final Constructor ctor;

    public ToStringConverter(Class cls) throws NoSuchMethodException {
        this.clazz = cls;
        this.ctor = cls.getConstructor(String.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(this.clazz);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        try {
            return this.ctor.newInstance(str);
        } catch (IllegalAccessException e) {
            throw new ConversionException("Unable to access single String param constructor", e);
        } catch (InstantiationException e2) {
            throw new ConversionException("Unable to instantiate single String param constructor", e2);
        } catch (InvocationTargetException e3) {
            throw new ConversionException("Unable to target single String param constructor", e3.getTargetException());
        }
    }
}
