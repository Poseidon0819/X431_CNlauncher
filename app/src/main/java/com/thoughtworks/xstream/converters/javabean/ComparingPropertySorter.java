package com.thoughtworks.xstream.converters.javabean;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class ComparingPropertySorter implements PropertySorter {
    private final Comparator comparator;

    public ComparingPropertySorter(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override // com.thoughtworks.xstream.converters.javabean.PropertySorter
    public Map sort(Class cls, Map map) {
        TreeMap treeMap = new TreeMap(this.comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
