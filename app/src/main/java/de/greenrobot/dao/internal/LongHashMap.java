package de.greenrobot.dao.internal;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import de.greenrobot.dao.DaoLog;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        Entry(long j, T t, Entry<T> entry) {
            this.key = j;
            this.value = t;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.capacity = i;
        this.threshold = (i * 4) / 3;
        this.table = new Entry[i];
    }

    public final boolean containsKey(long j) {
        for (Entry<T> entry = this.table[((((int) j) ^ ((int) (j >>> 32))) & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public final T get(long j) {
        for (Entry<T> entry = this.table[((((int) j) ^ ((int) (j >>> 32))) & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return entry.value;
            }
        }
        return null;
    }

    public final T put(long j, T t) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % this.capacity;
        Entry<T> entry = this.table[i];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j) {
                T t2 = entry2.value;
                entry2.value = t;
                return t2;
            }
        }
        this.table[i] = new Entry<>(j, t, entry);
        this.size++;
        if (this.size > this.threshold) {
            setCapacity(this.capacity * 2);
            return null;
        }
        return null;
    }

    public final T remove(long j) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % this.capacity;
        Entry<T> entry = this.table[i];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j) {
                if (entry2 == null) {
                    this.table[i] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public final void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public final int size() {
        return this.size;
    }

    public final void setCapacity(int i) {
        Entry<T>[] entryArr = new Entry[i];
        int length = this.table.length;
        for (int i2 = 0; i2 < length; i2++) {
            Entry<T> entry = this.table[i2];
            while (entry != null) {
                long j = entry.key;
                int i3 = ((((int) (j >>> 32)) ^ ((int) j)) & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % i;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i3];
                entryArr[i3] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i;
        this.threshold = (i * 4) / 3;
    }

    public final void reserveRoom(int i) {
        setCapacity((i * 5) / 3);
    }

    public final void logStats() {
        Entry<T>[] entryArr;
        int i = 0;
        for (Entry<T> entry : this.table) {
            for (; entry != null && entry.next != null; entry = entry.next) {
                i++;
            }
        }
        DaoLog.m332d("load: " + (this.size / this.capacity) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i + ", collision ratio: " + (i / this.size));
    }
}
