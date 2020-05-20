package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import java.util.Collections;

/* loaded from: classes2.dex */
public class SingletonCollectionConverter extends CollectionConverter {
    private static final Class LIST = Collections.singletonList(Boolean.TRUE).getClass();
    private static final Class SET = Collections.singleton(Boolean.TRUE).getClass();

    public SingletonCollectionConverter(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.converters.collections.CollectionConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return LIST == cls || SET == cls;
    }

    @Override // com.thoughtworks.xstream.converters.collections.CollectionConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        hierarchicalStreamReader.moveDown();
        Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, null);
        hierarchicalStreamReader.moveUp();
        return unmarshallingContext.getRequiredType() == LIST ? Collections.singletonList(readItem) : Collections.singleton(readItem);
    }
}
