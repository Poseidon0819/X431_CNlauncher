package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.mapper.Mapper;

/* loaded from: classes2.dex */
public abstract class MapperWrapper implements Mapper {
    private final Mapper wrapped;

    public MapperWrapper(Mapper mapper) {
        this.wrapped = mapper;
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        return this.wrapped.serializedClass(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class realClass(String str) {
        return this.wrapped.realClass(str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String serializedMember(Class cls, String str) {
        return this.wrapped.serializedMember(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String realMember(Class cls, String str) {
        return this.wrapped.realMember(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public boolean isImmutableValueType(Class cls) {
        return this.wrapped.isImmutableValueType(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class defaultImplementationOf(Class cls) {
        return this.wrapped.defaultImplementationOf(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForAttribute(String str) {
        return this.wrapped.aliasForAttribute(str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String attributeForAlias(String str) {
        return this.wrapped.attributeForAlias(str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForSystemAttribute(String str) {
        return this.wrapped.aliasForSystemAttribute(str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        return this.wrapped.getFieldNameForItemTypeAndName(cls, cls2, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Class getItemTypeForItemFieldName(Class cls, String str) {
        return this.wrapped.getItemTypeForItemFieldName(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        return this.wrapped.getImplicitCollectionDefForFieldName(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public boolean shouldSerializeMember(Class cls, String str) {
        return this.wrapped.shouldSerializeMember(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        return this.wrapped.getConverterFromItemType(str, cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(Class cls) {
        return this.wrapped.getConverterFromItemType(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(String str) {
        return this.wrapped.getConverterFromAttribute(str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Converter getLocalConverter(Class cls, String str) {
        return this.wrapped.getLocalConverter(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public Mapper lookupMapperOfType(Class cls) {
        return cls.isAssignableFrom(getClass()) ? this : this.wrapped.lookupMapperOfType(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return this.wrapped.getConverterFromItemType(str, cls, cls2);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String aliasForAttribute(Class cls, String str) {
        return this.wrapped.aliasForAttribute(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public String attributeForAlias(Class cls, String str) {
        return this.wrapped.attributeForAlias(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return this.wrapped.getConverterFromAttribute(cls, str);
    }

    @Override // com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return this.wrapped.getConverterFromAttribute(cls, str, cls2);
    }
}
