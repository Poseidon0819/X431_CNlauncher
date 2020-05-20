package com.thoughtworks.xstream.converters.collections;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.PresortedMap;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class TreeMapConverter extends MapConverter {
    private static final Comparator NULL_MARKER = new NullComparator();
    private static final Field comparatorField = Fields.locate(TreeMap.class, Comparator.class, false);

    /* loaded from: classes2.dex */
    static final class NullComparator extends Mapper.Null implements Comparator {
        private NullComparator() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public TreeMapConverter(Mapper mapper) {
        super(mapper, TreeMap.class);
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        marshalComparator(((SortedMap) obj).comparator(), hierarchicalStreamWriter, marshallingContext);
        super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void marshalComparator(Comparator comparator, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (comparator != null) {
            hierarchicalStreamWriter.startNode("comparator");
            hierarchicalStreamWriter.addAttribute(mapper().aliasForSystemAttribute(HtmlTags.CLASS), mapper().serializedClass(comparator.getClass()));
            marshallingContext.convertAnother(comparator);
            hierarchicalStreamWriter.endNode();
        }
    }

    @Override // com.thoughtworks.xstream.converters.collections.MapConverter, com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter, com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        TreeMap treeMap = comparatorField != null ? new TreeMap() : null;
        Comparator unmarshalComparator = unmarshalComparator(hierarchicalStreamReader, unmarshallingContext, treeMap);
        if (treeMap == null) {
            treeMap = unmarshalComparator == null ? new TreeMap() : new TreeMap(unmarshalComparator);
        }
        populateTreeMap(hierarchicalStreamReader, unmarshallingContext, treeMap, unmarshalComparator);
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Comparator unmarshalComparator(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, TreeMap treeMap) {
        Comparator comparator = null;
        if (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("comparator")) {
                comparator = (Comparator) unmarshallingContext.convertAnother(treeMap, HierarchicalStreams.readClassType(hierarchicalStreamReader, mapper()));
            } else if (!hierarchicalStreamReader.getNodeName().equals("no-comparator")) {
                return NULL_MARKER;
            }
            hierarchicalStreamReader.moveUp();
        }
        return comparator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateTreeMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, TreeMap treeMap, Comparator comparator) {
        boolean z = comparator == NULL_MARKER;
        Comparator comparator2 = null;
        if (z) {
            comparator = null;
        }
        if (comparator != null && JVM.hasOptimizedTreeMapPutAll()) {
            comparator2 = comparator;
        }
        PresortedMap presortedMap = new PresortedMap(comparator2);
        if (z) {
            putCurrentEntryIntoMap(hierarchicalStreamReader, unmarshallingContext, treeMap, presortedMap);
            hierarchicalStreamReader.moveUp();
        }
        populateMap(hierarchicalStreamReader, unmarshallingContext, treeMap, presortedMap);
        try {
            if (JVM.hasOptimizedTreeMapPutAll()) {
                if (comparator != null && comparatorField != null) {
                    comparatorField.set(treeMap, comparator);
                }
                treeMap.putAll(presortedMap);
            } else if (comparatorField != null) {
                comparatorField.set(treeMap, presortedMap.comparator());
                treeMap.putAll(presortedMap);
                comparatorField.set(treeMap, comparator);
            } else {
                treeMap.putAll(presortedMap);
            }
        } catch (IllegalAccessException e) {
            throw new ConversionException("Cannot set comparator of TreeMap", e);
        }
    }
}
