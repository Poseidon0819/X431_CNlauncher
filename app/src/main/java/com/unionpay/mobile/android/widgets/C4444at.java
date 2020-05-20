package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.at */
/* loaded from: classes2.dex */
public final class C4444at extends AbstractC4420aa {

    /* renamed from: c */
    private int f23378c;

    public C4444at(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23378c = 0;
        String m846a = C4389j.m846a(jSONObject, "maxLength");
        this.f23378c = (m846a == null || m846a.length() <= 0) ? 23 : Integer.getInteger(m846a).intValue();
        this.f23323b.m608a(new InputFilter.LengthFilter(this.f23378c));
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return this.f23402i || this.f23378c >= mo585a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_text";
    }
}
