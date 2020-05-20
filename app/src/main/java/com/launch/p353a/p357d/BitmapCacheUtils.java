package com.launch.p353a.p357d;

import android.graphics.Bitmap;
import android.util.LruCache;

/* renamed from: com.launch.a.d.a */
/* loaded from: classes.dex */
public final class BitmapCacheUtils {

    /* renamed from: c */
    private static BitmapCacheUtils f19884c;

    /* renamed from: a */
    private int f19885a;

    /* renamed from: b */
    private LruCache<String, Bitmap> f19886b;

    private BitmapCacheUtils() {
        this.f19885a = ((int) (Runtime.getRuntime().freeMemory() / 2)) <= 0 ? 4096 : (int) (Runtime.getRuntime().freeMemory() / 2);
        this.f19886b = new LruCache<>(this.f19885a);
    }

    /* renamed from: a */
    public static BitmapCacheUtils m2703a() {
        if (f19884c == null) {
            f19884c = new BitmapCacheUtils();
        }
        return f19884c;
    }

    /* renamed from: a */
    public final void m2701a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        this.f19886b.put(str, bitmap);
    }

    /* renamed from: a */
    public final Bitmap m2702a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        return this.f19886b.get(str);
    }
}
