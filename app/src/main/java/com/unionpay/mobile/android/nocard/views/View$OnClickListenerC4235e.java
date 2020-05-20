package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.e */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4235e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JSONObject f22639a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4219b f22640b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4235e(AbstractC4219b abstractC4219b, JSONObject jSONObject) {
        this.f22640b = abstractC4219b;
        this.f22639a = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22640b.m1407i();
        AbstractC4219b abstractC4219b = this.f22640b;
        abstractC4219b.mo1357b(abstractC4219b.f22590a.f22409aJ, this.f22639a);
    }
}
