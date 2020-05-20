package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;

/* compiled from: SoftMemoryCacheImpl.java */
/* renamed from: com.cnlaunch.golo3.a.b.k */
/* loaded from: classes.dex */
public final class C1588k implements InterfaceC1586i {

    /* renamed from: a */
    private final C1587j<String, SoftReference<Bitmap>> f7788a;

    public C1588k(int i) {
        this.f7788a = new C1589l(this, i);
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final void mo9194a(String str, Bitmap bitmap) {
        this.f7788a.m9200a(str, new SoftReference<>(bitmap));
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final Bitmap mo9195a(String str) {
        SoftReference<Bitmap> m9199b = this.f7788a.m9199b(str);
        if (m9199b != null) {
            return m9199b.get();
        }
        return null;
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final void mo9196a() {
        this.f7788a.m9202a();
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: b */
    public final void mo9193b(String str) {
        this.f7788a.m9197c(str);
    }
}
