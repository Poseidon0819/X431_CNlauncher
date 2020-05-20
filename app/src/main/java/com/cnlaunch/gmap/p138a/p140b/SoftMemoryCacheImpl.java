package com.cnlaunch.gmap.p138a.p140b;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;

/* renamed from: com.cnlaunch.gmap.a.b.k */
/* loaded from: classes.dex */
public final class SoftMemoryCacheImpl implements IMemoryCache {

    /* renamed from: a */
    private final C1508j<String, SoftReference<Bitmap>> f7446a;

    public SoftMemoryCacheImpl(int i) {
        this.f7446a = new C1509l(this, i);
    }

    @Override // com.cnlaunch.gmap.p138a.p140b.IMemoryCache
    /* renamed from: a */
    public final void mo9360a(String str, Bitmap bitmap) {
        this.f7446a.m9364a(str, new SoftReference<>(bitmap));
    }

    @Override // com.cnlaunch.gmap.p138a.p140b.IMemoryCache
    /* renamed from: a */
    public final Bitmap mo9361a(String str) {
        SoftReference<Bitmap> m9363b = this.f7446a.m9363b(str);
        if (m9363b != null) {
            return m9363b.get();
        }
        return null;
    }
}
