package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;

/* loaded from: classes2.dex */
public class JavaClassConverter extends AbstractSingleValueConverter {
    private Mapper mapper;

    public JavaClassConverter(ClassLoaderReference classLoaderReference) {
        this(new DefaultMapper(classLoaderReference));
    }

    public JavaClassConverter(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    protected JavaClassConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return Class.class.equals(cls);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return this.mapper.serializedClass((Class) obj);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        try {
            return this.mapper.realClass(str);
        } catch (CannotResolveClassException e) {
            throw new ConversionException("Cannot load java class ".concat(String.valueOf(str)), e.getCause());
        }
    }
}
