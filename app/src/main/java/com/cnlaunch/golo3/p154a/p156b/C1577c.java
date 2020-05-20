package com.cnlaunch.golo3.p154a.p156b;

import android.app.ActivityManager;
import android.content.Context;
import com.cnlaunch.golo3.p154a.p156b.C1582g;
import com.cnlaunch.golo3.p154a.p156b.C1584h;
import com.cnlaunch.golo3.p154a.p159e.C1595b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: BitmapCache.java */
/* renamed from: com.cnlaunch.golo3.a.b.c */
/* loaded from: classes.dex */
public final class C1577c {

    /* renamed from: a */
    public C1584h f7730a;

    /* renamed from: b */
    public InterfaceC1586i f7731b;

    /* renamed from: c */
    private C1578a f7732c;

    public C1577c(C1578a c1578a) {
        this.f7732c = c1578a;
        if (this.f7732c.f7737e) {
            if (this.f7732c.f7739g) {
                this.f7731b = new C1588k(this.f7732c.f7733a);
            } else {
                this.f7731b = new C1575a(this.f7732c.f7733a);
            }
        }
        if (c1578a.f7738f) {
            try {
                this.f7730a = new C1584h(this.f7732c.f7736d.getAbsolutePath(), this.f7732c.f7735c, this.f7732c.f7734b);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public final void m9229a(String str, byte[] bArr) {
        C1584h c1584h;
        byte[] array;
        if (this.f7730a == null || str == null || bArr == null) {
            return;
        }
        byte[] m9184a = C1595b.m9184a(str);
        long m9183a = C1595b.m9183a(m9184a);
        ByteBuffer allocate = ByteBuffer.allocate(m9184a.length + bArr.length);
        allocate.put(m9184a);
        allocate.put(bArr);
        synchronized (this.f7730a) {
            try {
                c1584h = this.f7730a;
                array = allocate.array();
            } catch (IOException unused) {
            }
            if (array.length + 24 > c1584h.f7757b) {
                throw new RuntimeException("blob is too large!");
            }
            if (c1584h.f7760e + 20 + array.length > c1584h.f7757b || c1584h.f7759d * 2 >= c1584h.f7756a) {
                c1584h.f7758c = 1 - c1584h.f7758c;
                c1584h.f7759d = 0;
                c1584h.f7760e = 4;
                C1584h.m9210a(c1584h.f7762g, 12, c1584h.f7758c);
                C1584h.m9210a(c1584h.f7762g, 16, c1584h.f7759d);
                C1584h.m9210a(c1584h.f7762g, 20, c1584h.f7760e);
                c1584h.m9206c();
                c1584h.m9208b();
                c1584h.m9219a(c1584h.f7761f);
                c1584h.m9205d();
            }
            if (!c1584h.m9218a(m9183a, c1584h.f7761f)) {
                c1584h.f7759d++;
                C1584h.m9210a(c1584h.f7762g, 16, c1584h.f7759d);
            }
            c1584h.m9217a(m9183a, array, array.length);
            c1584h.m9206c();
        }
    }

    /* renamed from: a */
    public final boolean m9230a(String str, C1582g.C1583a c1583a) {
        C1584h.C1585a c1585a;
        if (this.f7730a == null) {
            return false;
        }
        byte[] m9184a = C1595b.m9184a(str);
        long m9183a = C1595b.m9183a(m9184a);
        try {
            c1585a = new C1584h.C1585a();
            c1585a.f7778a = m9183a;
            c1585a.f7779b = c1583a.f7752a;
        } catch (IOException unused) {
        }
        synchronized (this.f7730a) {
            if (this.f7730a.m9216a(c1585a)) {
                if (C1595b.m9182a(m9184a, c1585a.f7779b)) {
                    c1583a.f7752a = c1585a.f7779b;
                    c1583a.f7753b = m9184a.length;
                    c1583a.f7754c = c1585a.f7780c - c1583a.f7753b;
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public final void m9232a() {
        C1584h c1584h = this.f7730a;
        if (c1584h != null) {
            c1584h.m9220a();
        }
    }

    /* renamed from: b */
    public final void m9228b() {
        InterfaceC1586i interfaceC1586i = this.f7731b;
        if (interfaceC1586i != null) {
            interfaceC1586i.mo9196a();
        }
    }

    /* renamed from: a */
    public final void m9231a(String str) {
        m9229a(str, new byte[0]);
    }

    /* compiled from: BitmapCache.java */
    /* renamed from: com.cnlaunch.golo3.a.b.c$a */
    /* loaded from: classes.dex */
    public static class C1578a {

        /* renamed from: d */
        public File f7736d;

        /* renamed from: a */
        public int f7733a = 8388608;

        /* renamed from: b */
        public int f7734b = 52428800;

        /* renamed from: c */
        public int f7735c = 10000;

        /* renamed from: e */
        public boolean f7737e = true;

        /* renamed from: f */
        public boolean f7738f = true;

        /* renamed from: g */
        public boolean f7739g = true;

        public C1578a(String str) {
            this.f7736d = new File(str);
        }

        /* renamed from: a */
        public final void m9226a(Context context, float f) {
            if (f < 0.05f || f > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.f7733a = Math.round(f * m9227a(context) * 1024.0f * 1024.0f);
        }

        /* renamed from: a */
        private static int m9227a(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }
    }
}
