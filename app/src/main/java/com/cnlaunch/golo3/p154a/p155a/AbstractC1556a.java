package com.cnlaunch.golo3.p154a.p155a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: AbstractCollection.java */
/* renamed from: com.cnlaunch.golo3.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1556a<E> implements Collection<E> {
    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public abstract int size();

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (E e : collection) {
            if (add(e)) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        Iterator<E> it = iterator();
        if (obj != null) {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        Iterator<E> it = iterator();
        if (obj != null) {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        int size = size();
        Iterator<E> it = iterator();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = it.next();
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (size > tArr.length) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            tArr[i] = it.next();
            i++;
        }
        if (i < tArr.length) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('[');
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (next != this) {
                sb.append(next);
            } else {
                sb.append("(this Collection)");
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
