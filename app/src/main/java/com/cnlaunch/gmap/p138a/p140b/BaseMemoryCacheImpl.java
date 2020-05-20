package com.cnlaunch.gmap.p138a.p140b;

import android.graphics.Bitmap;

/* renamed from: com.cnlaunch.gmap.a.b.a */
/* loaded from: classes.dex */
public final class BaseMemoryCacheImpl implements IMemoryCache {

    /* renamed from: a */
    private final C1508j<String, Bitmap> f7386a;

    public BaseMemoryCacheImpl(int i) {
        this.f7386a = new C1502b(this, i);
    }

    @Override // com.cnlaunch.gmap.p138a.p140b.IMemoryCache
    /* renamed from: a */
    public final void mo9360a(String str, Bitmap bitmap) {
        this.f7386a.m9364a(str, bitmap);
    }

    @Override // com.cnlaunch.gmap.p138a.p140b.IMemoryCache
    /* renamed from: a */
    public final Bitmap mo9361a(String str) {
        return this.f7386a.m9363b(str);
    }
}
