package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ae */
/* loaded from: classes2.dex */
public final class C4425ae extends AbstractC4420aa {
    public C4425ae(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return this.f23402i || mo585a().length() != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_name";
    }
}
