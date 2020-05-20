package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.Bitmap;
import com.cnlaunch.golo3.p154a.p159e.C1595b;
import java.lang.ref.SoftReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SoftMemoryCacheImpl.java */
/* renamed from: com.cnlaunch.golo3.a.b.l */
/* loaded from: classes.dex */
public final class C1589l extends C1587j<String, SoftReference<Bitmap>> {

    /* renamed from: a */
    final /* synthetic */ C1588k f7789a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1589l(C1588k c1588k, int i) {
        super(i);
        this.f7789a = c1588k;
    }

    @Override // com.cnlaunch.golo3.p154a.p156b.C1587j
    /* renamed from: a */
    protected final /* synthetic */ int mo9192a(SoftReference<Bitmap> softReference) {
        SoftReference<Bitmap> softReference2 = softReference;
        Bitmap bitmap = softReference2 == null ? null : softReference2.get();
        if (bitmap == null) {
            return 1;
        }
        return C1595b.m9185a(bitmap);
    }
}
