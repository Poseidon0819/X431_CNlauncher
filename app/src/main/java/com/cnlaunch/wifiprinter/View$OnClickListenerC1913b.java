package com.cnlaunch.wifiprinter;

import android.view.View;

/* compiled from: HelpActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC1913b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HelpActivity f10422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1913b(HelpActivity helpActivity) {
        this.f10422a = helpActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10422a.dismissAllowingStateLoss();
    }
}
