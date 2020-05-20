package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class EnumConverter implements Converter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.isEnum() || Enum.class.isAssignableFrom(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(((Enum) obj).name());
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Enum[] enumArr;
        Class requiredType = unmarshallingContext.getRequiredType();
        if (requiredType.getSuperclass() != Enum.class) {
            requiredType = requiredType.getSuperclass();
        }
        String value = hierarchicalStreamReader.getValue();
        try {
            return Enum.valueOf(requiredType, value);
        } catch (IllegalArgumentException e) {
            for (Enum r3 : (Enum[]) requiredType.getEnumConstants()) {
                if (r3.name().equalsIgnoreCase(value)) {
                    return r3;
                }
            }
            throw e;
        }
    }
}
