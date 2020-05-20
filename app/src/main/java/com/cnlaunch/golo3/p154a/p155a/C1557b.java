package com.cnlaunch.golo3.p154a.p155a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayDeque.java */
/* renamed from: com.cnlaunch.golo3.a.a.b */
/* loaded from: classes.dex */
public class C1557b<E> extends AbstractC1556a<E> implements InterfaceC1572j<E>, Serializable, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2340985798034038923L;

    /* renamed from: a */
    private transient E[] f7691a;

    /* renamed from: b */
    private transient int f7692b;

    /* renamed from: c */
    private transient int f7693c;

    /* renamed from: b */
    private void m9247b() {
    }

    /* renamed from: a */
    private void m9251a(int i) {
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
        this.f7691a = (E[]) new Object[i2];
    }

    /* renamed from: a */
    private void m9252a() {
        int i = this.f7692b;
        E[] eArr = this.f7691a;
        int length = eArr.length;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objArr = new Object[i3];
        System.arraycopy(eArr, i, objArr, 0, i2);
        System.arraycopy(this.f7691a, 0, objArr, i2, i);
        this.f7691a = (E[]) objArr;
        this.f7692b = 0;
        this.f7693c = length;
    }

    /* renamed from: a */
    private <T> T[] m9249a(T[] tArr) {
        int i = this.f7692b;
        int i2 = this.f7693c;
        if (i < i2) {
            System.arraycopy(this.f7691a, i, tArr, 0, size());
        } else if (i > i2) {
            E[] eArr = this.f7691a;
            int length = eArr.length - i;
            System.arraycopy(eArr, i, tArr, 0, length);
            System.arraycopy(this.f7691a, 0, tArr, length, this.f7693c);
        }
        return tArr;
    }

    public C1557b() {
        this.f7691a = (E[]) new Object[16];
    }

    public C1557b(int i) {
        m9251a(i);
    }

    public C1557b(Collection<? extends E> collection) {
        m9251a(collection.size());
        addAll(collection);
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        E[] eArr = this.f7691a;
        int length = (this.f7692b - 1) & (eArr.length - 1);
        this.f7692b = length;
        eArr[length] = e;
        if (this.f7692b == this.f7693c) {
            m9252a();
        }
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        E[] eArr = this.f7691a;
        int i = this.f7693c;
        eArr[i] = e;
        int length = (eArr.length - 1) & (i + 1);
        this.f7693c = length;
        if (length == this.f7692b) {
            m9252a();
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
        int i = this.f7692b;
        E[] eArr = this.f7691a;
        E e = eArr[i];
        if (e == null) {
            return null;
        }
        eArr[i] = null;
        this.f7692b = (i + 1) & (eArr.length - 1);
        return e;
    }

    public E pollLast() {
        E[] eArr = this.f7691a;
        int length = (this.f7693c - 1) & (eArr.length - 1);
        E e = eArr[length];
        if (e == null) {
            return null;
        }
        eArr[length] = null;
        this.f7693c = length;
        return e;
    }

    public E getFirst() {
        E e = this.f7691a[this.f7692b];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E[] eArr = this.f7691a;
        E e = eArr[(this.f7693c - 1) & (eArr.length - 1)];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E peekFirst() {
        return this.f7691a[this.f7692b];
    }

    public E peekLast() {
        E[] eArr = this.f7691a;
        return eArr[(this.f7693c - 1) & (eArr.length - 1)];
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7691a.length - 1;
        int i = this.f7692b;
        while (true) {
            E e = this.f7691a[i];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                m9246b(i);
                return true;
            }
            i = (i + 1) & length;
        }
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7691a.length - 1;
        int i = this.f7693c - 1;
        while (true) {
            int i2 = i & length;
            E e = this.f7691a[i2];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                m9246b(i2);
                return true;
            }
            i = i2 - 1;
        }
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
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
    public boolean m9246b(int i) {
        m9247b();
        E[] eArr = this.f7691a;
        int length = eArr.length - 1;
        int i2 = this.f7692b;
        int i3 = this.f7693c;
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
                this.f7692b = (i2 + 1) & length;
                return false;
            }
            if (i < i3) {
                System.arraycopy(eArr, i + 1, eArr, i, i5);
                this.f7693c = i3 - 1;
            } else {
                System.arraycopy(eArr, i + 1, eArr, i, length - i);
                eArr[length] = eArr[0];
                System.arraycopy(eArr, 1, eArr, 0, i3);
                this.f7693c = (i3 - 1) & length;
            }
            return true;
        }
        throw new ConcurrentModificationException();
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public int size() {
        return (this.f7693c - this.f7692b) & (this.f7691a.length - 1);
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public boolean isEmpty() {
        return this.f7692b == this.f7693c;
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1558a(this, (byte) 0);
    }

    public Iterator<E> descendingIterator() {
        return new C1559b(this, (byte) 0);
    }

    /* compiled from: ArrayDeque.java */
    /* renamed from: com.cnlaunch.golo3.a.a.b$a */
    /* loaded from: classes.dex */
    class C1558a implements Iterator<E> {

        /* renamed from: b */
        private int f7695b;

        /* renamed from: c */
        private int f7696c;

        /* renamed from: d */
        private int f7697d;

        private C1558a() {
            this.f7695b = C1557b.this.f7692b;
            this.f7696c = C1557b.this.f7693c;
            this.f7697d = -1;
        }

        /* synthetic */ C1558a(C1557b c1557b, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7695b != this.f7696c;
        }

        @Override // java.util.Iterator
        public final E next() {
            if (this.f7695b != this.f7696c) {
                E e = (E) C1557b.this.f7691a[this.f7695b];
                if (C1557b.this.f7693c != this.f7696c || e == null) {
                    throw new ConcurrentModificationException();
                }
                int i = this.f7695b;
                this.f7697d = i;
                this.f7695b = (i + 1) & (C1557b.this.f7691a.length - 1);
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.f7697d;
            if (i >= 0) {
                if (C1557b.this.m9246b(i)) {
                    this.f7695b = (this.f7695b - 1) & (C1557b.this.f7691a.length - 1);
                    this.f7696c = C1557b.this.f7693c;
                }
                this.f7697d = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: ArrayDeque.java */
    /* renamed from: com.cnlaunch.golo3.a.a.b$b */
    /* loaded from: classes.dex */
    class C1559b implements Iterator<E> {

        /* renamed from: b */
        private int f7699b;

        /* renamed from: c */
        private int f7700c;

        /* renamed from: d */
        private int f7701d;

        private C1559b() {
            this.f7699b = C1557b.this.f7693c;
            this.f7700c = C1557b.this.f7692b;
            this.f7701d = -1;
        }

        /* synthetic */ C1559b(C1557b c1557b, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7699b != this.f7700c;
        }

        @Override // java.util.Iterator
        public final E next() {
            int i = this.f7699b;
            if (i != this.f7700c) {
                this.f7699b = (i - 1) & (C1557b.this.f7691a.length - 1);
                E e = (E) C1557b.this.f7691a[this.f7699b];
                if (C1557b.this.f7692b != this.f7700c || e == null) {
                    throw new ConcurrentModificationException();
                }
                this.f7701d = this.f7699b;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.f7701d;
            if (i >= 0) {
                if (!C1557b.this.m9246b(i)) {
                    this.f7699b = (this.f7699b + 1) & (C1557b.this.f7691a.length - 1);
                    this.f7700c = C1557b.this.f7692b;
                }
                this.f7701d = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f7691a.length - 1;
        int i = this.f7692b;
        while (true) {
            E e = this.f7691a[i];
            if (e == null) {
                return false;
            }
            if (obj.equals(e)) {
                return true;
            }
            i = (i + 1) & length;
        }
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public void clear() {
        int i = this.f7692b;
        int i2 = this.f7693c;
        if (i != i2) {
            this.f7693c = 0;
            this.f7692b = 0;
            int length = this.f7691a.length - 1;
            do {
                this.f7691a[i] = null;
                i = (i + 1) & length;
            } while (i != i2);
        }
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public Object[] toArray() {
        return m9249a(new Object[size()]);
    }

    @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1556a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        m9249a(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    /* renamed from: clone */
    public C1557b<E> m15312clone() {
        try {
            C1557b<E> c1557b = (C1557b) super.clone();
            c1557b.f7691a = (E[]) C1560c.m9244a(this.f7691a, this.f7691a.length);
            return c1557b;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.f7691a.length - 1;
        for (int i = this.f7692b; i != this.f7693c; i = (i + 1) & length) {
            objectOutputStream.writeObject(this.f7691a[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        m9251a(readInt);
        this.f7692b = 0;
        this.f7693c = readInt;
        for (int i = 0; i < readInt; i++) {
            this.f7691a[i] = objectInputStream.readObject();
        }
    }
}
