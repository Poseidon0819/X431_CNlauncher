package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes2.dex */
public class MapConverter extends AbstractCollectionConverter {
    private final Class type;

    public MapConverter(Mapper mapper) {
        this(mapper, null);
    }

    public MapConverter(Mapper mapper, Class cls) {
        super(mapper);
        this.type = cls;
        if (cls == null || Map.class.isAssignableFrom(cls)) {
            return;
        }
        throw new IllegalArgumentException(cls + " not of type " + Map.class);
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        if (cls2 != null) {
            return cls.equals(cls2);
        }
        return cls.equals(HashMap.class) || cls.equals(Hashtable.class) || cls.getName().equals("java.util.LinkedHashMap") || cls.getName().equals("java.util.concurrent.ConcurrentHashMap") || cls.getName().equals("sun.font.AttributeMap");
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        String serializedClass = mapper().serializedClass(Map.Entry.class);
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, serializedClass, entry.getClass());
            writeItem(entry.getKey(), marshallingContext, hierarchicalStreamWriter);
            writeItem(entry.getValue(), marshallingContext, hierarchicalStreamWriter);
            hierarchicalStreamWriter.endNode();
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Map map = (Map) createCollection(unmarshallingContext.getRequiredType());
        populateMap(hierarchicalStreamReader, unmarshallingContext, map);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map) {
        populateMap(hierarchicalStreamReader, unmarshallingContext, map, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, Map map2) {
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            putCurrentEntryIntoMap(hierarchicalStreamReader, unmarshallingContext, map, map2);
            hierarchicalStreamReader.moveUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putCurrentEntryIntoMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, Map map2) {
        hierarchicalStreamReader.moveDown();
        Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, map);
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        Object readItem2 = readItem(hierarchicalStreamReader, unmarshallingContext, map);
        hierarchicalStreamReader.moveUp();
        map2.put(readItem, readItem2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter
    public Object createCollection(Class cls) {
        Class cls2 = this.type;
        if (cls2 != null) {
            cls = cls2;
        }
        return super.createCollection(cls);
    }
}
