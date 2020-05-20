package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.av */
/* loaded from: classes2.dex */
public final class C4446av extends AbstractC4420aa {
    public C4446av(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23323b.m608a(new InputFilter.LengthFilter(4));
        this.f23323b.m610a(2);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        return this.f23323b.m600b().trim();
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        String mo585a = mo585a();
        if (4 == mo585a.length()) {
            int parseInt = Integer.parseInt(mo585a.substring(0, 2));
            int parseInt2 = Integer.parseInt(mo585a.substring(2));
            int i = Calendar.getInstance().get(1) % 100;
            if (parseInt > 0 && parseInt <= 12 && (parseInt2 > i || (parseInt2 == i && parseInt >= Calendar.getInstance().get(2) + 1))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_select_availdata";
    }
}
