package com.cnlaunch.gmap.p138a.p139a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.cnlaunch.gmap.a.a.b */
/* loaded from: classes.dex */
public class ArrayDeque<E> extends AbstractCollection<E> implements InterfaceC1499j<E>, Serializable, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2340985798034038923L;

    /* renamed from: a */
    private transient E[] f7349a;

    /* renamed from: b */
    private transient int f7350b;

    /* renamed from: c */
    private transient int f7351c;

    /* renamed from: b */
    private void m9402b() {
    }

    /* renamed from: a */
    private void m9405a(int i) {
        int i2 = 8;
        if (i >= 8) {
            int i3 = i | (i >>> 1);
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            i2 = (i6 | (i6 >>> 16)) + 1;
            if (i2 < 0) {
                i2 >>>= 1;
            }
        }
        this.f7349a = (E[]) new Object[i2];
    }

    /* renamed from: a */
    private void m9406a() {
        int i = this.f7350b;
        E[] eArr = this.f7349a;
        int length = eArr.length;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objArr = new Object[i3];
        System.arraycopy(eArr, i, objArr, 0, i2);
        System.arraycopy(this.f7349a, 0, objArr, i2, i);
        this.f7349a = (E[]) objArr;
        this.f7350b = 0;
        this.f7351c = length;
    }

    /* renamed from: a */
    private <T> T[] m9403a(T[] tArr) {
        int i = this.f7350b;
        int i2 = this.f7351c;
        if (i < i2) {
            System.arraycopy(this.f7349a, i, tArr, 0, size());
        } else if (i > i2) {
            E[] eArr = this.f7349a;
            int length = eArr.length - i;
            System.arraycopy(eArr, i, tArr, 0, length);
            System.arraycopy(this.f7349a, 0, tArr, length, this.f7351c);
        }
        return tArr;
    }

    public ArrayDeque() {
        this.f7349a = (E[]) new Object[16];
    }

    public ArrayDeque(int i) {
        m9405a(i);
    }

    public ArrayDeque(Collection<? extends E> collection) {
        m9405a(collection.size());
        addAll(collection);
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        E[] eArr = this.f7349a;
        int length = (this.f7350b - 1) & (eArr.length - 1);
        this.f7350b = length;
        eArr[length] = e;
        if (this.f7350b == this.f7351c) {
            m9406a();
        }
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        E[] eArr = this.f7349a;
        int i = this.f7351c;
        eArr[i] = e;
        int length = (eArr.length - 1) & (i + 1);
        this.f7351c = length;
        if (length == this.f7350b) {
            m9406a();
        }
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public E pollFirst() {
        int i = this.f7350b;
        E[] eArr = this.f7349a;
        E e = eArr[i];
        if (e == null) {
            return null;
        }
        eArr[i] = null;
        this.f7350b = (i + 1) & (eArr.length - 1);
        return e;
    }

    public E pollLast() {
        E[] eArr = this.f7349a;
        int length = (this.f7351c - 1) & (eArr.length - 1);
        E e = eArr[length];
        if (e == null) {
            return null;
        }
        eArr[length] = null;
        this.f7351c = length;
        return e;
    }

    public E getFirst() {
        E e = this.f7349a[this.f7350b];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E[] eArr = this.f7349a;
        E e = eArr[(this.f7351c - 1) & (eArr.length - 1)];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E peekFirst() {
        return this.f7349a[this.f7350b];
    }

    public E peekLast() {
        E[] eArr = this.f7349a;
        return eArr[(this.f7351c - 1) & (eArr.length - 1)];
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7349a.length - 1;
        int i = this.f7350b;
        while (true) {
            E e = this.f7349a[i];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                m9401b(i);
                return true;
            }
            i = (i + 1) & length;
        }
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7349a.length - 1;
        int i = this.f7351c - 1;
        while (true) {
            int i2 = i & length;
            E e = this.f7349a[i2];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                m9401b(i2);
                return true;
            }
            i = i2 - 1;
        }
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public E remove() {
        return removeFirst();
    }

    public E poll() {
        return pollFirst();
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        return peekFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m9401b(int i) {
        m9402b();
        E[] eArr = this.f7349a;
        int length = eArr.length - 1;
        int i2 = this.f7350b;
        int i3 = this.f7351c;
        int i4 = (i - i2) & length;
        int i5 = (i3 - i) & length;
        if (i4 < ((i3 - i2) & length)) {
            if (i4 < i5) {
                if (i2 <= i) {
                    System.arraycopy(eArr, i2, eArr, i2 + 1, i4);
                } else {
                    System.arraycopy(eArr, 0, eArr, 1, i);
                    eArr[0] = eArr[length];
                    System.arraycopy(eArr, i2, eArr, i2 + 1, length - i2);
                }
                eArr[i2] = null;
                this.f7350b = (i2 + 1) & length;
                return false;
            }
            if (i < i3) {
                System.arraycopy(eArr, i + 1, eArr, i, i5);
                this.f7351c = i3 - 1;
            } else {
                System.arraycopy(eArr, i + 1, eArr, i, length - i);
                eArr[length] = eArr[0];
                System.arraycopy(eArr, 1, eArr, 0, i3);
                this.f7351c = (i3 - 1) & length;
            }
            return true;
        }
        throw new ConcurrentModificationException();
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public int size() {
        return (this.f7351c - this.f7350b) & (this.f7349a.length - 1);
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f7350b == this.f7351c;
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1487a(this, (byte) 0);
    }

    public Iterator<E> descendingIterator() {
        return new C1488b(this, (byte) 0);
    }

    /* compiled from: ArrayDeque.java */
    /* renamed from: com.cnlaunch.gmap.a.a.b$a */
    /* loaded from: classes.dex */
    class C1487a implements Iterator<E> {

        /* renamed from: b */
        private int f7353b;

        /* renamed from: c */
        private int f7354c;

        /* renamed from: d */
        private int f7355d;

        private C1487a() {
            this.f7353b = ArrayDeque.this.f7350b;
            this.f7354c = ArrayDeque.this.f7351c;
            this.f7355d = -1;
        }

        /* synthetic */ C1487a(ArrayDeque arrayDeque, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7353b != this.f7354c;
        }

        @Override // java.util.Iterator
        public final E next() {
            if (this.f7353b != this.f7354c) {
                E e = (E) ArrayDeque.this.f7349a[this.f7353b];
                if (ArrayDeque.this.f7351c != this.f7354c || e == null) {
                    throw new ConcurrentModificationException();
                }
                int i = this.f7353b;
                this.f7355d = i;
                this.f7353b = (i + 1) & (ArrayDeque.this.f7349a.length - 1);
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.f7355d;
            if (i >= 0) {
                if (ArrayDeque.this.m9401b(i)) {
                    this.f7353b = (this.f7353b - 1) & (ArrayDeque.this.f7349a.length - 1);
                    this.f7354c = ArrayDeque.this.f7351c;
                }
                this.f7355d = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: ArrayDeque.java */
    /* renamed from: com.cnlaunch.gmap.a.a.b$b */
    /* loaded from: classes.dex */
    class C1488b implements Iterator<E> {

        /* renamed from: b */
        private int f7357b;

        /* renamed from: c */
        private int f7358c;

        /* renamed from: d */
        private int f7359d;

        private C1488b() {
            this.f7357b = ArrayDeque.this.f7351c;
            this.f7358c = ArrayDeque.this.f7350b;
            this.f7359d = -1;
        }

        /* synthetic */ C1488b(ArrayDeque arrayDeque, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7357b != this.f7358c;
        }

        @Override // java.util.Iterator
        public final E next() {
            int i = this.f7357b;
            if (i != this.f7358c) {
                this.f7357b = (i - 1) & (ArrayDeque.this.f7349a.length - 1);
                E e = (E) ArrayDeque.this.f7349a[this.f7357b];
                if (ArrayDeque.this.f7350b != this.f7358c || e == null) {
                    throw new ConcurrentModificationException();
                }
                this.f7359d = this.f7357b;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.f7359d;
            if (i >= 0) {
                if (!ArrayDeque.this.m9401b(i)) {
                    this.f7357b = (this.f7357b + 1) & (ArrayDeque.this.f7349a.length - 1);
                    this.f7358c = ArrayDeque.this.f7350b;
                }
                this.f7359d = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7349a.length - 1;
        int i = this.f7350b;
        while (true) {
            E e = this.f7349a[i];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                return true;
            }
            i = (i + 1) & length;
        }
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public void clear() {
        int i = this.f7350b;
        int i2 = this.f7351c;
        if (i != i2) {
            this.f7351c = 0;
            this.f7350b = 0;
            int length = this.f7349a.length - 1;
            do {
                this.f7349a[i] = null;
                i = (i + 1) & length;
            } while (i != i2);
        }
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return m9403a(new Object[size()]);
    }

    @Override // com.cnlaunch.gmap.p138a.p139a.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        m9403a(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    /* renamed from: clone */
    public ArrayDeque<E> m15311clone() {
        try {
            ArrayDeque<E> arrayDeque = (ArrayDeque) super.clone();
            arrayDeque.f7349a = (E[]) Arrays.m9399a(this.f7349a, this.f7349a.length);
            return arrayDeque;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.f7349a.length - 1;
        for (int i = this.f7350b; i != this.f7351c; i = (i + 1) & length) {
            objectOutputStream.writeObject(this.f7349a[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        m9405a(readInt);
        this.f7350b = 0;
        this.f7351c = readInt;
        for (int i = 0; i < readInt; i++) {
            this.f7349a[i] = objectInputStream.readObject();
        }
    }
}
