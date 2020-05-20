package com.cnlaunch.p120d.p121a;

import android.util.LruCache;

/* renamed from: com.cnlaunch.d.a.h */
/* loaded from: classes.dex */
public class LruCacheManager {

    /* renamed from: b */
    private static LruCacheManager f6970b = null;

    /* renamed from: c */
    private static int f6971c = 30;

    /* renamed from: a */
    LruCache<String, Object> f6972a;

    private LruCacheManager(int i) {
        this.f6972a = new LruCache<>(i);
    }

    /* renamed from: a */
    public static LruCacheManager m9599a() {
        return m9598a(f6971c);
    }

    /* renamed from: a */
    private static LruCacheManager m9598a(int i) {
        if (f6970b == null) {
            synchronized (LruCacheManager.class) {
                if (f6970b == null) {
                    f6970b = new LruCacheManager(i);
                }
            }
        }
        return f6970b;
    }

    /* renamed from: a */
    public final void m9596a(String str, Object obj) {
        this.f6972a.put(str, obj);
    }

    /* renamed from: a */
    public final Object m9597a(String str) {
        return this.f6972a.get(str);
    }
}
