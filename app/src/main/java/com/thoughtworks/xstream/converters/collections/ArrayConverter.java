package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ArrayConverter extends AbstractCollectionConverter {
    public ArrayConverter(Mapper mapper) {
        super(mapper);
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.isArray();
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            writeItem(Array.get(obj, i), marshallingContext, hierarchicalStreamWriter);
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        ArrayList<Object> arrayList = new ArrayList();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            arrayList.add(readItem(hierarchicalStreamReader, unmarshallingContext, null));
            hierarchicalStreamReader.moveUp();
        }
        Object newInstance = Array.newInstance(unmarshallingContext.getRequiredType().getComponentType(), arrayList.size());
        int i = 0;
        for (Object obj : arrayList) {
            Array.set(newInstance, i, obj);
            i++;
        }
        return newInstance;
    }
}
