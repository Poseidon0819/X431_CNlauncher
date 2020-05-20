package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.DataHolder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class MapBackedDataHolder implements DataHolder {
    private final Map map;

    public MapBackedDataHolder() {
        this(new HashMap());
    }

    public MapBackedDataHolder(Map map) {
        this.map = map;
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public void put(Object obj, Object obj2) {
        this.map.put(obj, obj2);
    }

    @Override // com.thoughtworks.xstream.converters.DataHolder
    public Iterator keys() {
        return Collections.unmodifiableCollection(this.map.keySet()).iterator();
    }
}
