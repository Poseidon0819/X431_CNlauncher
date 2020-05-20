package com.alipay.sdk.app.p071a;

import android.text.TextUtils;

/* renamed from: com.alipay.sdk.app.a.b */
/* loaded from: classes.dex */
public final class C0728b {

    /* renamed from: a */
    String f3498a;

    /* renamed from: a */
    public final void m12554a(String str, String str2, String str3) {
        String str4 = "";
        if (!TextUtils.isEmpty(this.f3498a)) {
            str4 = "^";
        }
        this.f3498a += (str4 + String.format("%s,%s,%s,-", str, str2, m12555a(str3)));
    }

    /* renamed from: a */
    private static String m12555a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
    }
}
