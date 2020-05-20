package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;

/* loaded from: classes2.dex */
public interface Mapper {

    /* loaded from: classes2.dex */
    public interface ImplicitCollectionMapping {
        String getFieldName();

        String getItemFieldName();

        Class getItemType();

        String getKeyFieldName();
    }

    /* loaded from: classes2.dex */
    public static class Null {
    }

    String aliasForAttribute(Class cls, String str);

    String aliasForAttribute(String str);

    String aliasForSystemAttribute(String str);

    String attributeForAlias(Class cls, String str);

    String attributeForAlias(String str);

    Class defaultImplementationOf(Class cls);

    SingleValueConverter getConverterFromAttribute(Class cls, String str);

    SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2);

    SingleValueConverter getConverterFromAttribute(String str);

    SingleValueConverter getConverterFromItemType(Class cls);

    SingleValueConverter getConverterFromItemType(String str, Class cls);

    SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2);

    String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str);

    ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str);

    Class getItemTypeForItemFieldName(Class cls, String str);

    Converter getLocalConverter(Class cls, String str);

    boolean isImmutableValueType(Class cls);

    Mapper lookupMapperOfType(Class cls);

    Class realClass(String str);

    String realMember(Class cls, String str);

    String serializedClass(Class cls);

    String serializedMember(Class cls, String str);

    boolean shouldSerializeMember(Class cls, String str);
}
