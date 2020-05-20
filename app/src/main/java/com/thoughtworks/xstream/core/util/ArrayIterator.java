package com.thoughtworks.xstream.core.util;

import java.lang.reflect.Array;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ArrayIterator implements Iterator {
    private final Object array;
    private int idx;
    private int length;

    public ArrayIterator(Object obj) {
        this.array = obj;
        this.length = Array.getLength(obj);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.idx < this.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.array;
        int i = this.idx;
        this.idx = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Remove from array");
    }
}
