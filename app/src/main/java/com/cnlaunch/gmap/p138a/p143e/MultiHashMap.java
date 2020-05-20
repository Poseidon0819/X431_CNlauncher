package com.cnlaunch.gmap.p138a.p143e;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.cnlaunch.gmap.a.e.a */
/* loaded from: classes.dex */
public final class MultiHashMap<K, V> {

    /* renamed from: a */
    HashMap<K, ArrayList<V>> f7450a;

    public MultiHashMap() {
        this((byte) 0);
    }

    private MultiHashMap(byte b) {
        this.f7450a = new HashMap<>(8);
    }

    /* renamed from: a */
    public final ArrayList<V> m9353a(K k) {
        return this.f7450a.get(k);
    }
}
