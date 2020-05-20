package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cnlaunch.golo3.p154a.p156b.C1582g;
import com.cnlaunch.golo3.p154a.p158d.InterfaceC1592a;

/* compiled from: BitmapProcess.java */
/* renamed from: com.cnlaunch.golo3.a.b.f */
/* loaded from: classes.dex */
public final class C1581f {

    /* renamed from: c */
    private static final C1582g f7746c = new C1582g();

    /* renamed from: a */
    public InterfaceC1592a f7747a;

    /* renamed from: b */
    public C1577c f7748b;

    public C1581f(InterfaceC1592a interfaceC1592a, C1577c c1577c) {
        this.f7747a = interfaceC1592a;
        this.f7748b = c1577c;
    }

    /* renamed from: a */
    public final Bitmap m9223a(String str, C1580e c1580e) {
        Bitmap bitmap;
        C1582g.C1583a m9222a = f7746c.m9222a();
        try {
            if (!this.f7748b.m9230a(str, m9222a) || m9222a.f7754c - m9222a.f7753b <= 0) {
                bitmap = null;
            } else if (c1580e != null) {
                bitmap = C1579d.m9224a(m9222a.f7752a, m9222a.f7753b, m9222a.f7754c, c1580e.f7740a, c1580e.f7741b);
            } else {
                bitmap = BitmapFactory.decodeByteArray(m9222a.f7752a, m9222a.f7753b, m9222a.f7754c);
            }
            return bitmap;
        } finally {
            f7746c.m9221a(m9222a);
        }
    }
}
