package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class EnumSetConverter implements Converter {
    private static final Field typeField = Fields.locate(EnumSet.class, Class.class, false);
    private final Mapper mapper;

    public EnumSetConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return typeField != null && EnumSet.class.isAssignableFrom(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        EnumSet enumSet = (EnumSet) obj;
        Class cls = (Class) Fields.read(typeField, enumSet);
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(cls));
        }
        hierarchicalStreamWriter.setValue(joinEnumValues(enumSet));
    }

    private String joinEnumValues(EnumSet enumSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = enumSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Enum r2 = (Enum) it.next();
            if (z) {
                stringBuffer.append(',');
            } else {
                z = true;
            }
            stringBuffer.append(r2.name());
        }
        return stringBuffer.toString();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String[] split;
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute == null) {
            throw new ConversionException("No EnumType specified for EnumSet");
        }
        Class realClass = this.mapper.realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute));
        EnumSet noneOf = EnumSet.noneOf(realClass);
        for (String str : hierarchicalStreamReader.getValue().split(",")) {
            if (str.length() > 0) {
                noneOf.add(Enum.valueOf(realClass, str));
            }
        }
        return noneOf;
    }
}
