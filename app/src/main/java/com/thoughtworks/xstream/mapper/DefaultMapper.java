package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.mapper.Mapper;

/* loaded from: classes2.dex */
public class DefaultMapper implements Mapper {
    private static String XSTREAM_PACKAGE_ROOT;
    private final ClassLoaderReference classLoaderReference;

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForAttribute(Class cls, String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForAttribute(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForSystemAttribute(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String attributeForAlias(Class cls, String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String attributeForAlias(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class defaultImplementationOf(Class cls) {
        return cls;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(Class cls) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class getItemTypeForItemFieldName(Class cls, String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Converter getLocalConverter(Class cls, String str) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public boolean isImmutableValueType(Class cls) {
        return false;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Mapper lookupMapperOfType(Class cls) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String serializedMember(Class cls, String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public boolean shouldSerializeMember(Class cls, String str) {
        return true;
    }

    static {
        String name = DefaultMapper.class.getName();
        int indexOf = name.indexOf(".xstream.");
        XSTREAM_PACKAGE_ROOT = indexOf > 0 ? name.substring(0, indexOf + 9) : ".N/A";
    }

    public DefaultMapper(ClassLoaderReference classLoaderReference) {
        this.classLoaderReference = classLoaderReference;
    }

    public DefaultMapper(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        return cls.getName();
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        ClassLoader reference;
        Class primitiveType = Primitives.primitiveType(str);
        if (primitiveType != null) {
            return primitiveType;
        }
        try {
            boolean z = true;
            if (str.startsWith(XSTREAM_PACKAGE_ROOT)) {
                reference = DefaultMapper.class.getClassLoader();
            } else {
                reference = this.classLoaderReference.getReference();
                if (str.charAt(0) != '[') {
                    z = false;
                }
            }
            return Class.forName(str, z, reference);
        } catch (ClassNotFoundException unused) {
            throw new CannotResolveClassException(str);
        }
    }

    public String lookupName(Class cls) {
        return serializedClass(cls);
    }

    public Class lookupType(String str) {
        return realClass(str);
    }
}
