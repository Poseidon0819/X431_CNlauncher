package com.cnlaunch.gmap.p138a.p140b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cnlaunch.gmap.p138a.p140b.BytesBufferPool;
import com.cnlaunch.gmap.p138a.p142d.Downloader;

/* renamed from: com.cnlaunch.gmap.a.b.f */
/* loaded from: classes.dex */
public final class BitmapProcess {

    /* renamed from: c */
    private static final BytesBufferPool f7404c = new BytesBufferPool();

    /* renamed from: a */
    public Downloader f7405a;

    /* renamed from: b */
    public BitmapCache f7406b;

    public BitmapProcess(Downloader downloader, BitmapCache bitmapCache) {
        this.f7405a = downloader;
        this.f7406b = bitmapCache;
    }

    /* renamed from: a */
    public final Bitmap m9384a(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        Bitmap bitmap;
        BytesBufferPool.C1505a m9383a = f7404c.m9383a();
        try {
            if (!this.f7406b.m9389a(str, m9383a) || m9383a.f7412c - m9383a.f7411b <= 0) {
                bitmap = null;
            } else if (bitmapDisplayConfig != null) {
                bitmap = C1504d.m9385a(m9383a.f7410a, m9383a.f7411b, m9383a.f7412c, bitmapDisplayConfig.f7398a, bitmapDisplayConfig.f7399b);
            } else {
                bitmap = BitmapFactory.decodeByteArray(m9383a.f7410a, m9383a.f7411b, m9383a.f7412c);
            }
            return bitmap;
        } finally {
            f7404c.m9382a(m9383a);
        }
    }
}
