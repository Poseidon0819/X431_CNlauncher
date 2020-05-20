package com.thoughtworks.xstream.persistence;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class XmlMap extends AbstractMap {
    private final PersistenceStrategy persistenceStrategy;

    public XmlMap(PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.persistenceStrategy.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.persistenceStrategy.get(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return this.persistenceStrategy.put(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return this.persistenceStrategy.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return new XmlMapEntries();
    }

    /* loaded from: classes2.dex */
    class XmlMapEntries extends AbstractSet {
        XmlMapEntries() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return XmlMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return XmlMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return XmlMap.this.persistenceStrategy.iterator();
        }
    }
}
