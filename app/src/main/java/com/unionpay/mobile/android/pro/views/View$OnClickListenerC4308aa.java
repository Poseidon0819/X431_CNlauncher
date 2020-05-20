package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.aa */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4308aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4338y f22916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4308aa(C4338y c4338y) {
        this.f22916a = c4338y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4173b c4173b;
        JSONObject jSONObject = (JSONObject) view.getTag();
        String m846a = C4389j.m846a(jSONObject, "errMsg");
        if (m846a != null && !TextUtils.isEmpty(m846a)) {
            this.f22916a.m1422a(m846a);
            return;
        }
        String m846a2 = C4389j.m846a(jSONObject, "action");
        String m846a3 = C4389j.m846a(jSONObject, "value");
        c4173b = this.f22916a.f22590a;
        String str = c4173b.f22464br ? DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH : "2";
        C4338y c4338y = this.f22916a;
        C4338y.m1079a(c4338y, m846a2, m846a3 + ",\"carrier_tp\":" + str);
    }
}
