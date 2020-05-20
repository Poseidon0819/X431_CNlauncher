package com.thoughtworks.xstream.core.util;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class PrioritizedList {
    private final Set set = new TreeSet();
    private int lowestPriority = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
    private int lastId = 0;

    public void add(Object obj, int i) {
        if (this.lowestPriority > i) {
            this.lowestPriority = i;
        }
        Set set = this.set;
        int i2 = this.lastId + 1;
        this.lastId = i2;
        set.add(new PrioritizedItem(obj, i, i2));
    }

    public Iterator iterator() {
        return new PrioritizedItemIterator(this.set.iterator());
    }

    /* loaded from: classes2.dex */
    static class PrioritizedItem implements Comparable {

        /* renamed from: id */
        final int f21371id;
        final int priority;
        final Object value;

        public PrioritizedItem(Object obj, int i, int i2) {
            this.value = obj;
            this.priority = i;
            this.f21371id = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            PrioritizedItem prioritizedItem = (PrioritizedItem) obj;
            int i = this.priority;
            int i2 = prioritizedItem.priority;
            return i != i2 ? i2 - i : prioritizedItem.f21371id - this.f21371id;
        }

        public boolean equals(Object obj) {
            return this.f21371id == ((PrioritizedItem) obj).f21371id;
        }
    }

    /* loaded from: classes2.dex */
    static class PrioritizedItemIterator implements Iterator {
        private Iterator iterator;

        public PrioritizedItemIterator(Iterator it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((PrioritizedItem) this.iterator.next()).value;
        }
    }
}
