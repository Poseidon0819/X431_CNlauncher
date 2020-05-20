package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ao */
/* loaded from: classes2.dex */
public final class C4438ao extends AbstractC4420aa {
    public C4438ao(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23323b.m610a(129);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        String a = mo585a();
        return a != null && a.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "login_pwd";
    }
}
