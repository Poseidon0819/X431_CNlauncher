package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.av */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4214av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4212at f22585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4214av(C4212at c4212at) {
        this.f22585a = c4212at;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String m846a = C4389j.m846a(jSONObject, "errMsg");
        if (m846a != null && !TextUtils.isEmpty(m846a)) {
            this.f22585a.m1422a(m846a);
            return;
        }
        C4212at.m1447a(this.f22585a, C4389j.m846a(jSONObject, "action"), C4389j.m846a(jSONObject, "value"));
    }
}
