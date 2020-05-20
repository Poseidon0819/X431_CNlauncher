package com.unionpay.mobile.android.pro.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.o */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4328o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4328o(C4324k c4324k) {
        this.f22978a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f22978a.f22953P = str;
        C4324k.m1117k(this.f22978a);
        this.f22978a.m1126d(str, "");
    }
}
