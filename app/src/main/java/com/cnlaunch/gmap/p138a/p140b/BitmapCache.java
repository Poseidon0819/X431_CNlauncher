package com.cnlaunch.gmap.p138a.p140b;

import android.app.ActivityManager;
import android.content.Context;
import com.cnlaunch.gmap.p138a.p140b.BytesBufferPool;
import com.cnlaunch.gmap.p138a.p140b.C1506h;
import com.cnlaunch.gmap.p138a.p144f.Utils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.cnlaunch.gmap.a.b.c */
/* loaded from: classes.dex */
public final class BitmapCache {

    /* renamed from: a */
    public C1506h f7388a;

    /* renamed from: b */
    public IMemoryCache f7389b;

    /* renamed from: c */
    private C1503a f7390c;

    public BitmapCache(C1503a c1503a) {
        this.f7390c = c1503a;
        if (this.f7390c.f7395e) {
            if (this.f7390c.f7397g) {
                this.f7389b = new SoftMemoryCacheImpl(this.f7390c.f7391a);
            } else {
                this.f7389b = new BaseMemoryCacheImpl(this.f7390c.f7391a);
            }
        }
        if (c1503a.f7396f) {
            try {
                this.f7388a = new C1506h(this.f7390c.f7394d.getAbsolutePath(), this.f7390c.f7393c, this.f7390c.f7392b);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public final boolean m9389a(String str, BytesBufferPool.C1505a c1505a) {
        C1506h.C1507a c1507a;
        if (this.f7388a == null) {
            return false;
        }
        byte[] m9346a = Utils.m9346a(str);
        long m9345a = Utils.m9345a(m9346a);
        try {
            c1507a = new C1506h.C1507a();
            c1507a.f7436a = m9345a;
            c1507a.f7437b = c1505a.f7410a;
        } catch (IOException unused) {
        }
        synchronized (this.f7388a) {
            if (this.f7388a.m9377a(c1507a)) {
                if (Utils.m9344a(m9346a, c1507a.f7437b)) {
                    c1505a.f7410a = c1507a.f7437b;
                    c1505a.f7411b = m9346a.length;
                    c1505a.f7412c = c1507a.f7438c - c1505a.f7411b;
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: BitmapCache.java */
    /* renamed from: com.cnlaunch.gmap.a.b.c$a */
    /* loaded from: classes.dex */
    public static class C1503a {

        /* renamed from: d */
        public File f7394d;

        /* renamed from: a */
        public int f7391a = 8388608;

        /* renamed from: b */
        public int f7392b = 52428800;

        /* renamed from: c */
        public int f7393c = 10000;

        /* renamed from: e */
        public boolean f7395e = true;

        /* renamed from: f */
        public boolean f7396f = true;

        /* renamed from: g */
        public boolean f7397g = true;

        public C1503a(String str) {
            this.f7394d = new File(str);
        }

        /* renamed from: a */
        public final void m9387a(Context context, float f) {
            if (f < 0.05f || f > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.f7391a = Math.round(f * m9388a(context) * 1024.0f * 1024.0f);
        }

        /* renamed from: a */
        private static int m9388a(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }
    }
}
