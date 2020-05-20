package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.core.util.PresortedSet;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class TreeSetConverter extends CollectionConverter {
    private static final Field sortedMapField;
    private transient TreeMapConverter treeMapConverter;

    static {
        sortedMapField = JVM.hasOptimizedTreeSetAddAll() ? Fields.locate(TreeSet.class, SortedMap.class, false) : null;
    }

    public TreeSetConverter(Mapper mapper) {
        super(mapper, TreeSet.class);
        readResolve();
    }

    @Override // com.thoughtworks.xstream.converters.collections.CollectionConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        this.treeMapConverter.marshalComparator(((SortedSet) obj).comparator(), hierarchicalStreamWriter, marshallingContext);
        super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
    }

    @Override // com.thoughtworks.xstream.converters.collections.CollectionConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        TreeSet treeSet;
        TreeMap treeMap = null;
        Comparator unmarshalComparator = this.treeMapConverter.unmarshalComparator(hierarchicalStreamReader, unmarshallingContext, null);
        boolean z = unmarshalComparator instanceof Mapper.Null;
        Comparator comparator = z ? null : unmarshalComparator;
        if (sortedMapField != null) {
            treeSet = comparator == null ? new TreeSet() : new TreeSet(comparator);
            try {
                Object obj = sortedMapField.get(treeSet);
                if (obj instanceof TreeMap) {
                    treeMap = (TreeMap) obj;
                } else {
                    treeSet = null;
                }
            } catch (IllegalAccessException e) {
                throw new ConversionException("Cannot get backing map of TreeSet", e);
            }
        } else {
            treeSet = null;
        }
        if (treeMap == null) {
            PresortedSet presortedSet = new PresortedSet(comparator);
            treeSet = comparator == null ? new TreeSet() : new TreeSet(comparator);
            if (z) {
                addCurrentElementToCollection(hierarchicalStreamReader, unmarshallingContext, treeSet, presortedSet);
                hierarchicalStreamReader.moveUp();
            }
            populateCollection(hierarchicalStreamReader, unmarshallingContext, treeSet, presortedSet);
            if (presortedSet.size() > 0) {
                treeSet.addAll(presortedSet);
            }
        } else {
            this.treeMapConverter.populateTreeMap(hierarchicalStreamReader, unmarshallingContext, treeMap, unmarshalComparator);
        }
        return treeSet;
    }

    private Object readResolve() {
        this.treeMapConverter = new TreeMapConverter(mapper()) { // from class: com.thoughtworks.xstream.converters.collections.TreeSetConverter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.thoughtworks.xstream.converters.collections.MapConverter
            public void populateMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, final Map map2) {
                TreeSetConverter.this.populateCollection(hierarchicalStreamReader, unmarshallingContext, new AbstractList() { // from class: com.thoughtworks.xstream.converters.collections.TreeSetConverter.1.1
                    @Override // java.util.AbstractList, java.util.List
                    public Object get(int i) {
                        return null;
                    }

                    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
                    public boolean add(Object obj) {
                        return map2.put(obj, obj) != null;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return map2.size();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.thoughtworks.xstream.converters.collections.MapConverter
            public void putCurrentEntryIntoMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, Map map2) {
                Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, map);
                map2.put(readItem, readItem);
            }
        };
        return this;
    }
}
