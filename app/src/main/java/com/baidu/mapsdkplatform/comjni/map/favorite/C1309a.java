package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;

/* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a */
/* loaded from: classes.dex */
public class C1309a {

    /* renamed from: a */
    private long f6442a = 0;

    /* renamed from: b */
    private JNIFavorite f6443b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a */
    /* loaded from: classes.dex */
    public static class C1310a {

        /* renamed from: a */
        public static boolean f6444a = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m9967b() {
            f6444a = true;
        }
    }

    public C1309a() {
        this.f6443b = null;
        this.f6443b = new JNIFavorite();
    }

    /* renamed from: a */
    public int m9978a(Bundle bundle) {
        try {
            return this.f6443b.GetAll(this.f6442a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public long m9980a() {
        this.f6442a = this.f6443b.Create();
        return this.f6442a;
    }

    /* renamed from: a */
    public boolean m9979a(int i) {
        return this.f6443b.SetType(this.f6442a, i);
    }

    /* renamed from: a */
    public boolean m9977a(String str) {
        return this.f6443b.Remove(this.f6442a, str);
    }

    /* renamed from: a */
    public boolean m9976a(String str, String str2) {
        C1310a.m9967b();
        return this.f6443b.Add(this.f6442a, str, str2);
    }

    /* renamed from: a */
    public boolean m9975a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.f6443b.Load(this.f6442a, str, str2, str3, i, i2, i3);
    }

    /* renamed from: b */
    public int m9974b() {
        return this.f6443b.Release(this.f6442a);
    }

    /* renamed from: b */
    public String m9973b(String str) {
        try {
            return this.f6443b.GetValue(this.f6442a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public boolean m9972b(String str, String str2) {
        C1310a.m9967b();
        return this.f6443b.Update(this.f6442a, str, str2);
    }

    /* renamed from: c */
    public boolean m9971c() {
        return this.f6443b.Clear(this.f6442a);
    }

    /* renamed from: c */
    public boolean m9970c(String str) {
        try {
            return this.f6443b.IsExist(this.f6442a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    public boolean m9969d() {
        return this.f6443b.SaveCache(this.f6442a);
    }
}
