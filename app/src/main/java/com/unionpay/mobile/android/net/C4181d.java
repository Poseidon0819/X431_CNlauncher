package com.unionpay.mobile.android.net;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.utils.C4382c;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.unionpay.mobile.android.net.d */
/* loaded from: classes2.dex */
public final class C4181d {

    /* renamed from: a */
    private int f22503a;

    /* renamed from: b */
    private String f22504b;

    /* renamed from: c */
    private HashMap<String, String> f22505c;

    /* renamed from: d */
    private byte[] f22506d;

    /* renamed from: e */
    private String f22507e;

    /* renamed from: f */
    private String f22508f;

    public C4181d(int i, String str, byte[] bArr) {
        this.f22503a = i;
        this.f22504b = str;
        this.f22505c = null;
        this.f22506d = bArr;
    }

    public C4181d(String str) {
        this.f22503a = 1;
        this.f22504b = str;
        this.f22505c = null;
        this.f22506d = null;
    }

    /* renamed from: a */
    public final URL m1526a() {
        String str;
        try {
            if (TextUtils.isEmpty(this.f22508f)) {
                str = this.f22504b;
            } else {
                str = this.f22504b + this.f22508f;
            }
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final void m1525a(Context context, String str, String str2) {
        this.f22508f = "?" + C4382c.m879d(str) + "&0," + C4382c.m883b(context) + "&" + C4382c.m878e(str2);
    }

    /* renamed from: a */
    public final void m1524a(String str) {
        if (str != null) {
            this.f22507e = str;
            this.f22506d = str.getBytes();
        }
    }

    /* renamed from: a */
    public final void m1523a(HashMap<String, String> hashMap) {
        this.f22505c = hashMap;
    }

    /* renamed from: b */
    public final String m1522b() {
        return this.f22503a == 1 ? HttpPostHC4.METHOD_NAME : "GET";
    }

    /* renamed from: c */
    public final String m1521c() {
        return this.f22507e;
    }

    /* renamed from: d */
    public final HashMap<String, String> m1520d() {
        return this.f22505c;
    }
}
