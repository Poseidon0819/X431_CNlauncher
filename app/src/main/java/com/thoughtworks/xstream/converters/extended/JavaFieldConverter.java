package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class JavaFieldConverter implements Converter {
    private final SingleValueConverter javaClassConverter;
    private final Mapper mapper;

    public JavaFieldConverter(ClassLoaderReference classLoaderReference) {
        this(new JavaClassConverter(classLoaderReference), new DefaultMapper(classLoaderReference));
    }

    public JavaFieldConverter(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    protected JavaFieldConverter(SingleValueConverter singleValueConverter, Mapper mapper) {
        this.javaClassConverter = singleValueConverter;
        this.mapper = mapper;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Field.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Field field = (Field) obj;
        Class<?> declaringClass = field.getDeclaringClass();
        hierarchicalStreamWriter.startNode("name");
        hierarchicalStreamWriter.setValue(this.mapper.serializedMember(declaringClass, field.getName()));
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("clazz");
        hierarchicalStreamWriter.setValue(this.javaClassConverter.toString(declaringClass));
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String str = null;
        String str2 = null;
        while (true) {
            if ((str == null || str2 == null) && hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                if (hierarchicalStreamReader.getNodeName().equals("name")) {
                    str = hierarchicalStreamReader.getValue();
                } else if (hierarchicalStreamReader.getNodeName().equals("clazz")) {
                    str2 = hierarchicalStreamReader.getValue();
                }
                hierarchicalStreamReader.moveUp();
            }
        }
        Class cls = (Class) this.javaClassConverter.fromString(str2);
        try {
            return cls.getDeclaredField(this.mapper.realMember(cls, str));
        } catch (NoSuchFieldException e) {
            throw new ConversionException(e);
        }
    }
}
