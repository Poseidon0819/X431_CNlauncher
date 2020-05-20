package com.unionpay.mobile.android.pro.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.ab */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4309ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4338y f22917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4309ab(C4338y c4338y) {
        this.f22917a = c4338y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f22917a.f22989B = str;
        C4338y.m1053m(this.f22917a);
        this.f22917a.m1066d(str, "");
    }
}
