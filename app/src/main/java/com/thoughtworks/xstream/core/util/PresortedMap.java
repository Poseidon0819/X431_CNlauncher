package com.thoughtworks.xstream.core.util;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes2.dex */
public class PresortedMap implements SortedMap {
    private final Comparator comparator;
    private final ArraySet set;

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    /* loaded from: classes2.dex */
    static class ArraySet extends ArrayList implements Set {
        private ArraySet() {
        }
    }

    public PresortedMap() {
        this(null, new ArraySet());
    }

    public PresortedMap(Comparator comparator) {
        this(comparator, new ArraySet());
    }

    private PresortedMap(Comparator comparator, ArraySet arraySet) {
        this.comparator = comparator == null ? new ArraySetComparator(arraySet) : comparator;
        this.set = arraySet;
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return this.comparator;
    }

    @Override // java.util.SortedMap, java.util.Map
    public Set entrySet() {
        return this.set;
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap, java.util.Map
    public Set keySet() {
        ArraySet arraySet = new ArraySet();
        Iterator it = this.set.iterator();
        while (it.hasNext()) {
            arraySet.add(((Map.Entry) it.next()).getKey());
        }
        return arraySet;
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap, java.util.Map
    public Collection values() {
        ArraySet arraySet = new ArraySet();
        Iterator it = this.set.iterator();
        while (it.hasNext()) {
            arraySet.add(((Map.Entry) it.next()).getValue());
        }
        return arraySet;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    @Override // java.util.Map
    public Object put(final Object obj, final Object obj2) {
        this.set.add(new Map.Entry() { // from class: com.thoughtworks.xstream.core.util.PresortedMap.1
            @Override // java.util.Map.Entry
            public Object getKey() {
                return obj;
            }

            @Override // java.util.Map.Entry
            public Object getValue() {
                return obj2;
            }

            @Override // java.util.Map.Entry
            public Object setValue(Object obj3) {
                throw new UnsupportedOperationException();
            }
        });
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Object obj : map.entrySet()) {
            this.set.add(obj);
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.set.size();
    }

    /* loaded from: classes2.dex */
    static class ArraySetComparator implements Comparator {
        private Map.Entry[] array;
        private final ArrayList list;

        ArraySetComparator(ArrayList arrayList) {
            this.list = arrayList;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (this.array == null || this.list.size() != this.array.length) {
                Map.Entry[] entryArr = new Map.Entry[this.list.size()];
                Map.Entry[] entryArr2 = this.array;
                if (entryArr2 != null) {
                    System.arraycopy(entryArr2, 0, entryArr, 0, entryArr2.length);
                }
                Map.Entry[] entryArr3 = this.array;
                for (int length = entryArr3 == null ? 0 : entryArr3.length; length < this.list.size(); length++) {
                    entryArr[length] = (Map.Entry) this.list.get(length);
                }
                this.array = entryArr;
            }
            int i = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
            int i2 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
            for (int i3 = 0; i3 < this.array.length && (i >= Integer.MAX_VALUE || i2 >= Integer.MAX_VALUE); i3++) {
                if (i == Integer.MAX_VALUE && obj == this.array[i3].getKey()) {
                    i = i3;
                }
                if (i2 == Integer.MAX_VALUE && obj2 == this.array[i3].getKey()) {
                    i2 = i3;
                }
            }
            return i - i2;
        }
    }
}
