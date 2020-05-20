package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.e */
/* loaded from: classes2.dex */
public final class C4463e extends AbstractC4420aa {
    public C4463e(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23323b.m608a(new InputFilter.LengthFilter(3));
        this.f23323b.m610a(18);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return 3 == mo585a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_cvn2";
    }
}
