package com.mopub.network;

import android.graphics.Bitmap;
import android.support.p012v4.p019d.LruCache;

/* compiled from: Networking.java */
/* renamed from: com.mopub.network.d */
/* loaded from: classes2.dex */
final class C3913d extends LruCache<String, Bitmap> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C3913d(int i) {
        super(i);
    }

    @Override // android.support.p012v4.p019d.LruCache
    public final /* synthetic */ int sizeOf(String str, Bitmap bitmap) {
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            return bitmap2.getRowBytes() * bitmap2.getHeight();
        }
        return super.sizeOf(str2, bitmap2);
    }
}
