package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class IntHashtable implements Cloneable {
    private transient int count;
    private float loadFactor;
    private transient Entry[] table;
    private int threshold;

    public IntHashtable() {
        this(150, 0.75f);
    }

    public IntHashtable(int i) {
        this(i, 0.75f);
    }

    public IntHashtable(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.capacity.1", i));
        }
        if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.load.1", String.valueOf(f)));
        }
        i = i == 0 ? 1 : i;
        this.loadFactor = f;
        this.table = new Entry[i];
        this.threshold = (int) (i * f);
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean contains(int i) {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i2]; entry != null; entry = entry.next) {
                if (entry.value == i) {
                    return true;
                }
            }
            length = i2;
        }
    }

    public boolean containsValue(int i) {
        return contains(i);
    }

    public boolean containsKey(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                return true;
            }
        }
        return false;
    }

    public int get(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                return entry.value;
            }
        }
        return 0;
    }

    protected void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i];
        this.threshold = (int) (i * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Entry entry = entryArr[i2];
            while (entry != null) {
                Entry entry2 = entry.next;
                int i3 = (entry.hash & MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT) % i;
                entry.next = entryArr2[i3];
                entryArr2[i3] = entry;
                entry = entry2;
            }
            length = i2;
        }
    }

    public int put(int i, int i2) {
        Entry[] entryArr = this.table;
        int i3 = Integer.MAX_VALUE & i;
        int length = i3 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == i) {
                int i4 = entry.value;
                entry.value = i2;
                return i4;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i3 % entryArr.length;
        }
        entryArr[length] = new Entry(i, i, i2, entryArr[length]);
        this.count++;
        return 0;
    }

    public int remove(int i) {
        Entry[] entryArr = this.table;
        int length = (Integer.MAX_VALUE & i) % entryArr.length;
        Entry entry = entryArr[length];
        Entry entry2 = null;
        while (true) {
            Entry entry3 = entry2;
            entry2 = entry;
            if (entry2 == null) {
                return 0;
            }
            if (entry2.hash != i || entry2.key != i) {
                entry = entry2.next;
            } else {
                if (entry3 != null) {
                    entry3.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                int i2 = entry2.value;
                entry2.value = 0;
                return i2;
            }
        }
    }

    public void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                entryArr[length] = null;
            } else {
                this.count = 0;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Entry {
        int hash;
        int key;
        Entry next;
        int value;

        protected Entry(int i, int i2, int i3, Entry entry) {
            this.hash = i;
            this.key = i2;
            this.value = i3;
            this.next = entry;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        protected Object clone() {
            int i = this.hash;
            int i2 = this.key;
            int i3 = this.value;
            Entry entry = this.next;
            return new Entry(i, i2, i3, entry != null ? (Entry) entry.clone() : null);
        }
    }

    /* loaded from: classes.dex */
    static class IntHashtableIterator implements Iterator<Entry> {
        Entry entry;
        int index;
        Entry[] table;

        IntHashtableIterator(Entry[] entryArr) {
            this.table = entryArr;
            this.index = entryArr.length;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Entry entry;
            if (this.entry != null) {
                return true;
            }
            do {
                int i = this.index;
                this.index = i - 1;
                if (i <= 0) {
                    return false;
                }
                entry = this.table[this.index];
                this.entry = entry;
            } while (entry == null);
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Entry next() {
            Entry entry;
            if (this.entry == null) {
                do {
                    int i = this.index;
                    this.index = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    entry = this.table[this.index];
                    this.entry = entry;
                } while (entry == null);
            }
            Entry entry2 = this.entry;
            if (entry2 != null) {
                this.entry = entry2.next;
                return entry2;
            }
            throw new NoSuchElementException(MessageLocalization.getComposedMessage("inthashtableiterator", new Object[0]));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("remove.not.supported", new Object[0]));
        }
    }

    public Iterator<Entry> getEntryIterator() {
        return new IntHashtableIterator(this.table);
    }

    public int[] toOrderedKeys() {
        int[] keys = getKeys();
        Arrays.sort(keys);
        return keys;
    }

    public int[] getKeys() {
        int i;
        int[] iArr = new int[this.count];
        int length = this.table.length;
        int i2 = 0;
        Entry entry = null;
        while (true) {
            if (entry == null) {
                while (true) {
                    i = length - 1;
                    if (length <= 0 || (entry = this.table[i]) != null) {
                        break;
                    }
                    length = i;
                }
                length = i;
            }
            if (entry == null) {
                return iArr;
            }
            Entry entry2 = entry.next;
            iArr[i2] = entry.key;
            entry = entry2;
            i2++;
        }
    }

    public int getOneKey() {
        if (this.count == 0) {
            return 0;
        }
        int length = this.table.length;
        Entry entry = null;
        while (true) {
            int i = length - 1;
            if (length <= 0 || (entry = this.table[i]) != null) {
                break;
            }
            length = i;
        }
        if (entry == null) {
            return 0;
        }
        return entry.key;
    }

    public Object clone() {
        try {
            IntHashtable intHashtable = (IntHashtable) super.clone();
            intHashtable.table = new Entry[this.table.length];
            int length = this.table.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return intHashtable;
                }
                intHashtable.table[i] = this.table[i] != null ? (Entry) this.table[i].clone() : null;
                length = i;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
