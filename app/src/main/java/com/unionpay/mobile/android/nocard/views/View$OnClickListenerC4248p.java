package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.p */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4248p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o f22709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4248p(C4245o c4245o) {
        this.f22709a = c4245o;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String m846a = C4389j.m846a(jSONObject, "errMsg");
        if (m846a != null && !TextUtils.isEmpty(m846a)) {
            this.f22709a.m1422a(m846a);
            return;
        }
        C4245o.m1361a(this.f22709a, C4389j.m846a(jSONObject, "action"), C4389j.m846a(jSONObject, "value"));
    }
}
