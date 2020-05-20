package com.thoughtworks.xstream.converters.reflection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class XStream12FieldKeySorter implements FieldKeySorter {
    @Override // com.thoughtworks.xstream.converters.reflection.FieldKeySorter
    public Map sort(Class cls, Map map) {
        TreeMap treeMap = new TreeMap(new Comparator() { // from class: com.thoughtworks.xstream.converters.reflection.XStream12FieldKeySorter.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                FieldKey fieldKey = (FieldKey) obj;
                FieldKey fieldKey2 = (FieldKey) obj2;
                int depth = fieldKey2.getDepth() - fieldKey.getDepth();
                return depth == 0 ? fieldKey.getOrder() - fieldKey2.getOrder() : depth;
            }
        });
        treeMap.putAll(map);
        map.clear();
        map.putAll(treeMap);
        return map;
    }
}
