package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.f */
/* loaded from: classes2.dex */
public final class C4464f extends AbstractC4420aa {
    public C4464f(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23323b.m608a(new InputFilter.LengthFilter(32));
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return mo585a().length() != 0 && mo585a().length() <= 32;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_certId";
    }
}
