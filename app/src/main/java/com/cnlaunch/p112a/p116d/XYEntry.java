package com.cnlaunch.p112a.p116d;

import java.util.Map;

/* renamed from: com.cnlaunch.a.d.c */
/* loaded from: classes.dex */
public final class XYEntry<K, V> implements Map.Entry<K, V> {

    /* renamed from: a */
    private final K f6730a;

    /* renamed from: b */
    private V f6731b;

    public XYEntry(K k, V v) {
        this.f6730a = k;
        this.f6731b = v;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f6730a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f6731b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f6731b = v;
        return this.f6731b;
    }
}
