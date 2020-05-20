package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.Bitmap;

/* compiled from: BaseMemoryCacheImpl.java */
/* renamed from: com.cnlaunch.golo3.a.b.a */
/* loaded from: classes.dex */
public final class C1575a implements InterfaceC1586i {

    /* renamed from: a */
    private final C1587j<String, Bitmap> f7728a;

    public C1575a(int i) {
        this.f7728a = new C1576b(this, i);
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final void mo9194a(String str, Bitmap bitmap) {
        this.f7728a.m9200a(str, bitmap);
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final Bitmap mo9195a(String str) {
        return this.f7728a.m9199b(str);
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: a */
    public final void mo9196a() {
        this.f7728a.m9202a();
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.InterfaceC1586i
    /* renamed from: b */
    public final void mo9193b(String str) {
        this.f7728a.m9197c(str);
    }
}
