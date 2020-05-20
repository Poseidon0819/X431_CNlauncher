package com.thoughtworks.xstream.persistence;

import java.util.AbstractList;

/* loaded from: classes2.dex */
public class XmlArrayList extends AbstractList {
    private final XmlMap map;

    public XmlArrayList(PersistenceStrategy persistenceStrategy) {
        this.map = new XmlMap(persistenceStrategy);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.map.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        rangeCheck(i);
        Object obj2 = get(i);
        this.map.put(Integer.valueOf(i), obj);
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int size = size();
        if (i >= size + 1 || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        int i2 = i != size ? i - 1 : i;
        while (size > i2) {
            this.map.put(new Integer(size + 1), this.map.get(Integer.valueOf(size)));
            size--;
        }
        this.map.put(Integer.valueOf(i), obj);
    }

    private void rangeCheck(int i) {
        int size = size();
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        rangeCheck(i);
        return this.map.get(Integer.valueOf(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        int size = size();
        rangeCheck(i);
        Object obj = this.map.get(Integer.valueOf(i));
        while (true) {
            int i2 = size - 1;
            if (i < i2) {
                XmlMap xmlMap = this.map;
                Integer valueOf = Integer.valueOf(i);
                i++;
                xmlMap.put(valueOf, this.map.get(new Integer(i)));
            } else {
                this.map.remove(new Integer(i2));
                return obj;
            }
        }
    }
}
