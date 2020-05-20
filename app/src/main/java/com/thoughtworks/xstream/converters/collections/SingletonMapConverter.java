package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import java.util.Collections;

/* loaded from: classes2.dex */
public class SingletonMapConverter extends MapConverter {
    private static final Class MAP = Collections.singletonMap(Boolean.TRUE, null).getClass();

    public SingletonMapConverter(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return MAP == cls;
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        hierarchicalStreamReader.moveDown();
        hierarchicalStreamReader.moveDown();
        Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, null);
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        Object readItem2 = readItem(hierarchicalStreamReader, unmarshallingContext, null);
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveUp();
        return Collections.singletonMap(readItem, readItem2);
    }
}
