package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.f */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4408f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4402b f23261a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4408f(C4402b c4402b) {
        this.f23261a = c4402b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this.f23261a.f23216e != null) {
            AbstractMethod.InterfaceC4399b interfaceC4399b = this.f23261a.f23216e;
            jSONObject = this.f23261a.f23235g;
            String a = C4402b.m823a(jSONObject, "title");
            jSONObject2 = this.f23261a.f23235g;
            interfaceC4399b.mo817a(a, C4402b.m823a(jSONObject2, HtmlTags.HREF));
        }
    }
}
