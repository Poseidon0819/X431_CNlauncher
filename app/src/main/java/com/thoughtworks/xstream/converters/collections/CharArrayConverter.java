package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;

/* loaded from: classes2.dex */
public class CharArrayConverter implements Converter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.isArray() && cls.getComponentType().equals(Character.TYPE);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(new String((char[]) obj));
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return hierarchicalStreamReader.getValue().toCharArray();
    }
}
