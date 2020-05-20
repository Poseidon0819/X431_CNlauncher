package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import com.thoughtworks.xstream.mapper.AttributeMapper;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;

/* loaded from: classes2.dex */
class UseAttributeForEnumMapper extends AttributeMapper {
    @Override // com.thoughtworks.xstream.mapper.AttributeMapper, com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return null;
    }

    @Override // com.thoughtworks.xstream.mapper.AttributeMapper, com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return null;
    }

    public UseAttributeForEnumMapper(Mapper mapper) {
        super(mapper, null, null);
    }

    public static boolean isEnum(Class cls) {
        while (cls != null && cls != Object.class) {
            if (cls.getName().equals("java.lang.Enum")) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    @Override // com.thoughtworks.xstream.mapper.AttributeMapper
    public boolean shouldLookForSingleValueConverter(String str, Class cls, Class cls2) {
        return isEnum(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mapper createEnumMapper(Mapper mapper) {
        try {
            return (Mapper) DependencyInjectionFactory.newInstance(Class.forName("com.thoughtworks.xstream.mapper.EnumMapper", true, Mapper.class.getClassLoader()), new Object[]{new UseAttributeForEnumMapper(mapper.lookupMapperOfType(DefaultMapper.class))});
        } catch (Exception unused) {
            return null;
        }
    }
}
