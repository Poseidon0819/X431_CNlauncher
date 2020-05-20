package com.unionpay.p371a;

import com.unionpay.utils.C4652j;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.unionpay.a.d */
/* loaded from: classes2.dex */
public final class C4121d {

    /* renamed from: b */
    private String f22048b;

    /* renamed from: e */
    private String f22051e;

    /* renamed from: a */
    private int f22047a = 1;

    /* renamed from: c */
    private HashMap f22049c = null;

    /* renamed from: d */
    private byte[] f22050d = null;

    public C4121d(String str) {
        this.f22048b = str;
    }

    /* renamed from: a */
    public final URL m1641a() {
        try {
            return new URL(this.f22048b);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final void m1640a(String str) {
        C4652j.m432b("uppay", "encrypt postData: ".concat(String.valueOf(str)));
        if (str != null) {
            this.f22050d = str.getBytes();
            this.f22051e = str;
        }
    }

    /* renamed from: b */
    public final String m1639b() {
        return this.f22047a == 1 ? HttpPostHC4.METHOD_NAME : "GET";
    }

    /* renamed from: c */
    public final String m1638c() {
        return this.f22051e;
    }

    /* renamed from: d */
    public final HashMap m1637d() {
        return this.f22049c;
    }
}
