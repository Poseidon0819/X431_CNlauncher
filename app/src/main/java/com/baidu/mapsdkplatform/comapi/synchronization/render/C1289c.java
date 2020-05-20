package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.c */
/* loaded from: classes.dex */
public class C1289c {

    /* renamed from: a */
    private static final String f6355a = "c";

    /* renamed from: b */
    private C1290d f6356b = C1290d.m10133a();

    public C1289c(Context context, BaiduMap baiduMap) {
        this.f6356b.m10131a(baiduMap);
    }

    /* renamed from: a */
    public void m10145a() {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10119e();
        }
    }

    /* renamed from: a */
    public void m10144a(int i) {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10132a(i);
        }
    }

    /* renamed from: a */
    public void m10143a(InterfaceC1288b interfaceC1288b) {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10130a(interfaceC1288b);
        }
    }

    /* renamed from: b */
    public void m10142b() {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10117f();
        }
    }

    /* renamed from: b */
    public void m10141b(int i) {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10120d(i);
        }
    }

    /* renamed from: c */
    public Marker m10140c() {
        C1290d c1290d = this.f6356b;
        if (c1290d == null) {
            C1255a.m10453b(f6355a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return c1290d.m10127b();
    }

    /* renamed from: c */
    public void m10139c(int i) {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10126b(i);
        }
    }

    /* renamed from: d */
    public Marker m10138d() {
        C1290d c1290d = this.f6356b;
        if (c1290d == null) {
            C1255a.m10453b(f6355a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return c1290d.m10124c();
    }

    /* renamed from: d */
    public void m10137d(int i) {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10123c(i);
        }
    }

    /* renamed from: e */
    public Marker m10136e() {
        C1290d c1290d = this.f6356b;
        if (c1290d == null) {
            C1255a.m10453b(f6355a, "The mSyncRenderStrategic created failed");
            return null;
        }
        return c1290d.m10121d();
    }

    /* renamed from: f */
    public void m10135f() {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10115g();
            this.f6356b = null;
        }
    }

    /* renamed from: g */
    public void m10134g() {
        C1290d c1290d = this.f6356b;
        if (c1290d != null) {
            c1290d.m10114h();
        }
    }
}
