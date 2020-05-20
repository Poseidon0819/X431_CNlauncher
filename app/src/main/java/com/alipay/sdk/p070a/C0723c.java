package com.alipay.sdk.p070a;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.a.c */
/* loaded from: classes.dex */
public final class C0723c {

    /* renamed from: a */
    InterfaceC0722b f3487a;

    /* renamed from: b */
    Context f3488b;

    public C0723c(Context context, InterfaceC0722b interfaceC0722b) {
        this.f3488b = context;
        this.f3487a = interfaceC0722b;
    }

    /* renamed from: a */
    public final void m12557a(String str, int i) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", i - 1);
        C0720a c0720a = new C0720a("callback");
        c0720a.f3484e = jSONObject;
        c0720a.f3480a = str;
        this.f3487a.mo12532a(c0720a);
    }
}
