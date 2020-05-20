package com.thoughtworks.xstream.converters.javabean;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.javabean.JavaBeanProvider;
import com.thoughtworks.xstream.converters.reflection.MissingFieldException;
import com.thoughtworks.xstream.core.util.FastField;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class JavaBeanConverter implements Converter {
    protected final JavaBeanProvider beanProvider;
    private String classAttributeIdentifier;
    protected final Mapper mapper;
    private final Class type;

    public JavaBeanConverter(Mapper mapper) {
        this(mapper, (Class) null);
    }

    public JavaBeanConverter(Mapper mapper, Class cls) {
        this(mapper, new BeanProvider(), cls);
    }

    public JavaBeanConverter(Mapper mapper, JavaBeanProvider javaBeanProvider) {
        this(mapper, javaBeanProvider, null);
    }

    public JavaBeanConverter(Mapper mapper, JavaBeanProvider javaBeanProvider, Class cls) {
        this.mapper = mapper;
        this.beanProvider = javaBeanProvider;
        this.type = cls;
    }

    public JavaBeanConverter(Mapper mapper, String str) {
        this(mapper, new BeanProvider());
        this.classAttributeIdentifier = str;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        return (cls2 == null || cls2 == cls) && this.beanProvider.canInstantiate(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(final Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, final MarshallingContext marshallingContext) {
        String str = this.classAttributeIdentifier;
        if (str == null) {
            str = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS);
        }
        final String str2 = str;
        this.beanProvider.visitSerializableProperties(obj, new JavaBeanProvider.Visitor() { // from class: com.thoughtworks.xstream.converters.javabean.JavaBeanConverter.1
            @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider.Visitor
            public boolean shouldVisit(String str3, Class cls) {
                return JavaBeanConverter.this.mapper.shouldSerializeMember(cls, str3);
            }

            @Override // com.thoughtworks.xstream.converters.javabean.JavaBeanProvider.Visitor
            public void visit(String str3, Class cls, Class cls2, Object obj2) {
                if (obj2 != null) {
                    writeField(str3, cls, obj2, cls2);
                }
            }

            private void writeField(String str3, Class cls, Object obj2, Class cls2) {
                String str4;
                Class<?> cls3 = obj2.getClass();
                Class defaultImplementationOf = JavaBeanConverter.this.mapper.defaultImplementationOf(cls);
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, JavaBeanConverter.this.mapper.serializedMember(obj.getClass(), str3), cls3);
                if (!cls3.equals(defaultImplementationOf) && (str4 = str2) != null) {
                    hierarchicalStreamWriter.addAttribute(str4, JavaBeanConverter.this.mapper.serializedClass(cls3));
                }
                marshallingContext.convertAnother(obj2);
                hierarchicalStreamWriter.endNode();
            }
        });
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Object instantiateNewInstance = instantiateNewInstance(unmarshallingContext);
        HashSet hashSet = new HashSet() { // from class: com.thoughtworks.xstream.converters.javabean.JavaBeanConverter.2
            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean add(Object obj) {
                if (super.add(obj)) {
                    return true;
                }
                throw new DuplicatePropertyException(((FastField) obj).getName());
            }
        };
        Class<?> cls = instantiateNewInstance.getClass();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            String realMember = this.mapper.realMember(cls, hierarchicalStreamReader.getNodeName());
            if (this.mapper.shouldSerializeMember(cls, realMember)) {
                if (this.beanProvider.propertyDefinedInClass(realMember, cls)) {
                    this.beanProvider.writeProperty(instantiateNewInstance, realMember, unmarshallingContext.convertAnother(instantiateNewInstance, determineType(hierarchicalStreamReader, instantiateNewInstance, realMember)));
                    hashSet.add(new FastField(cls, realMember));
                } else {
                    throw new MissingFieldException(cls.getName(), realMember);
                }
            }
            hierarchicalStreamReader.moveUp();
        }
        return instantiateNewInstance;
    }

    private Object instantiateNewInstance(UnmarshallingContext unmarshallingContext) {
        Object currentObject = unmarshallingContext.currentObject();
        return currentObject == null ? this.beanProvider.newInstance(unmarshallingContext.getRequiredType()) : currentObject;
    }

    private Class determineType(HierarchicalStreamReader hierarchicalStreamReader, Object obj, String str) {
        String str2 = this.classAttributeIdentifier;
        if (str2 == null) {
            str2 = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS);
        }
        String attribute = str2 == null ? null : hierarchicalStreamReader.getAttribute(str2);
        if (attribute != null) {
            return this.mapper.realClass(attribute);
        }
        return this.mapper.defaultImplementationOf(this.beanProvider.getPropertyType(obj, str));
    }

    /* loaded from: classes2.dex */
    public static class DuplicateFieldException extends ConversionException {
        public DuplicateFieldException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class DuplicatePropertyException extends ConversionException {
        public DuplicatePropertyException(String str) {
            super("Duplicate property ".concat(String.valueOf(str)));
            add("property", str);
        }
    }
}
