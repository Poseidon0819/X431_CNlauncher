package com.thoughtworks.xstream.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* loaded from: classes2.dex */
public class PresortedSet implements SortedSet {
    private final Comparator comparator;
    private final List list;

    public PresortedSet() {
        this(null);
    }

    public PresortedSet(Comparator comparator) {
        this(comparator, null);
    }

    public PresortedSet(Comparator comparator, Collection collection) {
        this.list = new ArrayList();
        this.comparator = comparator;
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.list.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.list.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.list.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.list.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.list.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.list.size();
    }

    public List subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.list.toArray(objArr);
    }

    @Override // java.util.SortedSet
    public Comparator comparator() {
        return this.comparator;
    }

    @Override // java.util.SortedSet
    public Object first() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.get(0);
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public Object last() {
        if (this.list.isEmpty()) {
            return null;
        }
        List list = this.list;
        return list.get(list.size() - 1);
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        throw new UnsupportedOperationException();
    }
}
