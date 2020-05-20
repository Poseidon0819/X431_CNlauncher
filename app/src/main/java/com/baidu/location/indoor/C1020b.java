package com.baidu.location.indoor;

import java.util.ArrayList;

/* renamed from: com.baidu.location.indoor.b */
/* loaded from: classes.dex */
public class C1020b<T> extends ArrayList<T> {

    /* renamed from: a */
    private int f4629a;

    public C1020b(int i) {
        this.f4629a = 0;
        this.f4629a = i;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        synchronized (this) {
            if (size() == this.f4629a) {
                remove(0);
            }
            add(size(), t);
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        synchronized (this) {
            if (size() <= 3) {
                return;
            }
            int size = size() / 2;
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                remove(0);
                size = i;
            }
        }
    }
}
