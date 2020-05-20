package com.unionpay.mobile.android.pro.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.d */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4317d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4307a f22929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4317d(C4307a c4307a) {
        this.f22929a = c4307a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f22929a.f22898E = str;
        C4307a.m1177i(this.f22929a);
        this.f22929a.m1183e(str, "");
    }
}
