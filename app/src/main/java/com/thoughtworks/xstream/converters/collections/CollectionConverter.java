package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

/* loaded from: classes2.dex */
public class CollectionConverter extends AbstractCollectionConverter {
    private final Class type;

    public CollectionConverter(Mapper mapper) {
        this(mapper, null);
    }

    public CollectionConverter(Mapper mapper, Class cls) {
        super(mapper);
        this.type = cls;
        if (cls == null || Collection.class.isAssignableFrom(cls)) {
            return;
        }
        throw new IllegalArgumentException(cls + " not of type " + Collection.class);
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        if (cls2 != null) {
            return cls.equals(cls2);
        }
        if (cls.equals(ArrayList.class) || cls.equals(HashSet.class) || cls.equals(LinkedList.class) || cls.equals(Vector.class)) {
            return true;
        }
        return JVM.is14() && cls.getName().equals("java.util.LinkedHashSet");
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        for (Object obj2 : (Collection) obj) {
            writeItem(obj2, marshallingContext, hierarchicalStreamWriter);
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Collection collection = (Collection) createCollection(unmarshallingContext.getRequiredType());
        populateCollection(hierarchicalStreamReader, unmarshallingContext, collection);
        return collection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection) {
        populateCollection(hierarchicalStreamReader, unmarshallingContext, collection, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection, Collection collection2) {
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            addCurrentElementToCollection(hierarchicalStreamReader, unmarshallingContext, collection, collection2);
            hierarchicalStreamReader.moveUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addCurrentElementToCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection, Collection collection2) {
        collection2.add(readItem(hierarchicalStreamReader, unmarshallingContext, collection));
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
