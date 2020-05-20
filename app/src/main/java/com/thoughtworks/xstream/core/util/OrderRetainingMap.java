package com.thoughtworks.xstream.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class OrderRetainingMap extends HashMap {
    private ArraySet keyOrder = new ArraySet();
    private List valueOrder = new ArrayList();

    public OrderRetainingMap() {
    }

    public OrderRetainingMap(Map map) {
        putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int lastIndexOf = this.keyOrder.lastIndexOf(obj);
        if (lastIndexOf < 0) {
            this.keyOrder.add(obj);
            this.valueOrder.add(obj2);
        } else {
            this.valueOrder.set(lastIndexOf, obj2);
        }
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        int lastIndexOf = this.keyOrder.lastIndexOf(obj);
        if (lastIndexOf != 0) {
            this.keyOrder.remove(lastIndexOf);
            this.valueOrder.remove(lastIndexOf);
        }
        return super.remove(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.keyOrder.clear();
        this.valueOrder.clear();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Collection values() {
        return Collections.unmodifiableList(this.valueOrder);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return Collections.unmodifiableSet(this.keyOrder);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Map.Entry[] entryArr = new Map.Entry[size()];
        for (Map.Entry entry : super.entrySet()) {
            entryArr[this.keyOrder.indexOf(entry.getKey())] = entry;
        }
        ArraySet arraySet = new ArraySet();
        arraySet.addAll(Arrays.asList(entryArr));
        return Collections.unmodifiableSet(arraySet);
    }

    /* loaded from: classes2.dex */
    static class ArraySet extends ArrayList implements Set {
        private ArraySet() {
        }
    }
}
