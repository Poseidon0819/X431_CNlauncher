package com.unionpay.mobile.android.nocard.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.aw */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4215aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4212at f22586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4215aw(C4212at c4212at) {
        this.f22586a = c4212at;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f22586a.f22569E = str;
        C4212at.m1434f(this.f22586a);
        this.f22586a.m1439d(str, "");
    }
}
