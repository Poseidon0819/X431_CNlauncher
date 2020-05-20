package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.f */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4236f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JSONObject f22641a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4219b f22642b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4236f(AbstractC4219b abstractC4219b, JSONObject jSONObject) {
        this.f22642b = abstractC4219b;
        this.f22641a = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22642b.m1407i();
        AbstractC4219b abstractC4219b = this.f22642b;
        abstractC4219b.mo1357b(abstractC4219b.f22590a.f22411aL, this.f22641a);
    }
}
