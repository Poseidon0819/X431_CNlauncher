package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.au */
/* loaded from: classes2.dex */
public final class C4445au extends AbstractC4420aa {
    public C4445au(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        if (this.f23402i) {
            return true;
        }
        String a = mo585a() != null ? mo585a() : "";
        return (this.f23403j == null || this.f23403j.length() <= 0) ? a.length() > 0 && a.length() <= 64 : a.matches(this.f23403j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "login_user";
    }
}
