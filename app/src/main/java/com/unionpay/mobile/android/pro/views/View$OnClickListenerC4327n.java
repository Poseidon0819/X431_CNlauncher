package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.n */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4327n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22977a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4327n(C4324k c4324k) {
        this.f22977a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String m846a = C4389j.m846a(jSONObject, "errMsg");
        if (m846a != null && !TextUtils.isEmpty(m846a)) {
            this.f22977a.m1422a(m846a);
            return;
        }
        String m846a2 = C4389j.m846a(jSONObject, "action");
        String m846a3 = C4389j.m846a(jSONObject, "value");
        C4324k c4324k = this.f22977a;
        C4324k.m1142a(c4324k, m846a2, m846a3 + ",\"carrier_tp\":\"7\"");
    }
}
