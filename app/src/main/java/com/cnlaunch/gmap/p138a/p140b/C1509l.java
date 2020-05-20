package com.cnlaunch.gmap.p138a.p140b;

import android.graphics.Bitmap;
import com.cnlaunch.gmap.p138a.p144f.Utils;
import java.lang.ref.SoftReference;

/* compiled from: SoftMemoryCacheImpl.java */
/* renamed from: com.cnlaunch.gmap.a.b.l */
/* loaded from: classes.dex */
final class C1509l extends C1508j<String, SoftReference<Bitmap>> {

    /* renamed from: a */
    final /* synthetic */ SoftMemoryCacheImpl f7447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1509l(SoftMemoryCacheImpl softMemoryCacheImpl, int i) {
        super(i);
        this.f7447a = softMemoryCacheImpl;
    }

    @Override // com.cnlaunch.gmap.p138a.p140b.C1508j
    /* renamed from: a */
    protected final /* synthetic */ int mo9359a(SoftReference<Bitmap> softReference) {
        SoftReference<Bitmap> softReference2 = softReference;
        Bitmap bitmap = softReference2 == null ? null : softReference2.get();
        if (bitmap == null) {
            return 1;
        }
        return Utils.m9347a(bitmap);
    }
}
