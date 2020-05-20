package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bw */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2839bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialog f16337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2839bw(ProgressDialog progressDialog) {
        this.f16337a = progressDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageDialog messageDialog;
        messageDialog = this.f16337a.f16328i;
        messageDialog.dismiss();
        this.f16337a.m4621b(false);
    }
}
