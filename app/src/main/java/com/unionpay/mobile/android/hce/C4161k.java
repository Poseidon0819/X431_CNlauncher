package com.unionpay.mobile.android.hce;

import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.hce.k */
/* loaded from: classes2.dex */
public final class C4161k {

    /* renamed from: a */
    private String f22213a;

    /* renamed from: b */
    private String f22214b;

    /* renamed from: c */
    private String f22215c;

    /* renamed from: d */
    private String f22216d;

    /* renamed from: e */
    private String f22217e;

    /* renamed from: f */
    private String f22218f;

    /* renamed from: g */
    private JSONObject f22219g;

    public C4161k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f22219g = jSONObject;
            this.f22213a = C4389j.m846a(jSONObject, "package");
            this.f22214b = C4389j.m846a(jSONObject, "issuer");
            this.f22215c = C4389j.m846a(jSONObject, "syn_key");
            this.f22216d = C4389j.m846a(jSONObject, "pub_key");
            this.f22217e = C4389j.m846a(jSONObject, "status");
            this.f22218f = C4389j.m846a(jSONObject, "priority");
        }
    }

    /* renamed from: a */
    public final boolean m1565a() {
        return this.f22217e.equals("D");
    }

    /* renamed from: b */
    public final String m1564b() {
        return this.f22213a;
    }

    /* renamed from: c */
    public final String m1563c() {
        return this.f22214b;
    }

    /* renamed from: d */
    public final String m1562d() {
        return this.f22215c;
    }

    /* renamed from: e */
    public final String m1561e() {
        return this.f22216d;
    }

    /* renamed from: f */
    public final JSONObject m1560f() {
        return this.f22219g;
    }
}
