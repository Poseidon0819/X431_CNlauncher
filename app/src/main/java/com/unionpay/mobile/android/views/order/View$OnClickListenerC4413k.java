package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.k */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4413k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4411i f23272a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4413k(C4411i c4411i) {
        this.f23272a = c4411i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this.f23272a.f23216e != null) {
            AbstractMethod.InterfaceC4399b interfaceC4399b = this.f23272a.f23216e;
            jSONObject = this.f23272a.f23266h;
            String a = C4411i.m823a(jSONObject, "label");
            jSONObject2 = this.f23272a.f23266h;
            interfaceC4399b.mo817a(a, C4411i.m823a(jSONObject2, HtmlTags.HREF));
        }
    }
}
