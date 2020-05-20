package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.j */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4412j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4411i f23271a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4412j(C4411i c4411i) {
        this.f23271a = c4411i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this.f23271a.f23216e != null) {
            AbstractMethod.InterfaceC4399b interfaceC4399b = this.f23271a.f23216e;
            jSONObject = this.f23271a.f23265g;
            String a = C4411i.m823a(jSONObject, "label");
            jSONObject2 = this.f23271a.f23265g;
            interfaceC4399b.mo817a(a, C4411i.m823a(jSONObject2, HtmlTags.HREF));
        }
    }
}
