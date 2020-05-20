package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class AttributeMapper extends MapperWrapper {
    private ConverterLookup converterLookup;
    private final Map fieldNameToTypeMap;
    private final Set fieldToUseAsAttribute;
    private ReflectionProvider reflectionProvider;
    private final Set typeSet;

    public AttributeMapper(Mapper mapper) {
        this(mapper, null, null);
    }

    public AttributeMapper(Mapper mapper, ConverterLookup converterLookup, ReflectionProvider reflectionProvider) {
        super(mapper);
        this.fieldNameToTypeMap = new HashMap();
        this.typeSet = new HashSet();
        this.fieldToUseAsAttribute = new HashSet();
        this.converterLookup = converterLookup;
        this.reflectionProvider = reflectionProvider;
    }

    public void setConverterLookup(ConverterLookup converterLookup) {
        this.converterLookup = converterLookup;
    }

    public void addAttributeFor(String str, Class cls) {
        this.fieldNameToTypeMap.put(str, cls);
    }

    public void addAttributeFor(Class cls) {
        this.typeSet.add(cls);
    }

    private SingleValueConverter getLocalConverterFromItemType(Class cls) {
        Converter lookupConverterForType = this.converterLookup.lookupConverterForType(cls);
        if (lookupConverterForType == null || !(lookupConverterForType instanceof SingleValueConverter)) {
            return null;
        }
        return (SingleValueConverter) lookupConverterForType;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        if (this.fieldNameToTypeMap.get(str) == cls) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        SingleValueConverter localConverterFromItemType;
        return (!shouldLookForSingleValueConverter(str, cls, cls2) || (localConverterFromItemType = getLocalConverterFromItemType(cls)) == null) ? super.getConverterFromItemType(str, cls, cls2) : localConverterFromItemType;
    }

    public boolean shouldLookForSingleValueConverter(String str, Class cls, Class cls2) {
        if (this.typeSet.contains(cls) || this.fieldNameToTypeMap.get(str) == cls) {
            return true;
        }
        if (str == null || cls2 == null) {
            return false;
        }
        return this.fieldToUseAsAttribute.contains(this.reflectionProvider.getField(cls2, str));
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(Class cls) {
        if (this.typeSet.contains(cls)) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(String str) {
        Class cls = (Class) this.fieldNameToTypeMap.get(str);
        if (cls != null) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return getConverterFromAttribute(cls, str, this.reflectionProvider.getField(cls, str).getType());
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        SingleValueConverter localConverterFromItemType;
        return (!shouldLookForSingleValueConverter(str, cls2, cls) || (localConverterFromItemType = getLocalConverterFromItemType(cls2)) == null) ? super.getConverterFromAttribute(cls, str, cls2) : localConverterFromItemType;
    }

    public void addAttributeFor(Field field) {
        this.fieldToUseAsAttribute.add(field);
    }

    public void addAttributeFor(Class cls, String str) {
        this.fieldToUseAsAttribute.add(this.reflectionProvider.getField(cls, str));
    }
}
