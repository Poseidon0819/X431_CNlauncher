package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;
import com.thoughtworks.xstream.core.Caching;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class EnumMapper extends MapperWrapper implements Caching {
    private transient AttributeMapper attributeMapper;
    private transient Map<Class, SingleValueConverter> enumConverterMap;

    @Deprecated
    public EnumMapper(Mapper mapper, ConverterLookup converterLookup) {
        super(mapper);
        readResolve();
    }

    public EnumMapper(Mapper mapper) {
        super(mapper);
        readResolve();
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public String serializedClass(Class cls) {
        if (cls == null) {
            return super.serializedClass(cls);
        }
        if (Enum.class.isAssignableFrom(cls) && cls.getSuperclass() != Enum.class) {
            return super.serializedClass(cls.getSuperclass());
        }
        if (EnumSet.class.isAssignableFrom(cls)) {
            return super.serializedClass(EnumSet.class);
        }
        return super.serializedClass(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public boolean isImmutableValueType(Class cls) {
        return Enum.class.isAssignableFrom(cls) || super.isImmutableValueType(cls);
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        SingleValueConverter localConverter = getLocalConverter(str, cls, cls2);
        return localConverter == null ? super.getConverterFromItemType(str, cls, cls2) : localConverter;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        SingleValueConverter localConverter = getLocalConverter(str, cls2, cls);
        return localConverter == null ? super.getConverterFromAttribute(cls, str, cls2) : localConverter;
    }

    private SingleValueConverter getLocalConverter(String str, Class cls, Class cls2) {
        SingleValueConverter singleValueConverter;
        if (this.attributeMapper != null && Enum.class.isAssignableFrom(cls) && this.attributeMapper.shouldLookForSingleValueConverter(str, cls, cls2)) {
            synchronized (this.enumConverterMap) {
                singleValueConverter = this.enumConverterMap.get(cls);
                if (singleValueConverter == null) {
                    SingleValueConverter converterFromItemType = super.getConverterFromItemType(str, cls, cls2);
                    singleValueConverter = converterFromItemType == null ? new EnumSingleValueConverter(cls) : converterFromItemType;
                    this.enumConverterMap.put(cls, singleValueConverter);
                }
            }
            return singleValueConverter;
        }
        return null;
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
        if (this.enumConverterMap.size() > 0) {
            synchronized (this.enumConverterMap) {
                this.enumConverterMap.clear();
            }
        }
    }

    private Object readResolve() {
        this.enumConverterMap = new HashMap();
        this.attributeMapper = (AttributeMapper) lookupMapperOfType(AttributeMapper.class);
        return this;
    }
}
