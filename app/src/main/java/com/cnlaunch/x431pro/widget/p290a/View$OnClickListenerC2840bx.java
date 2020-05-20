package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bx */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2840bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialog f16338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2840bx(ProgressDialog progressDialog) {
        this.f16338a = progressDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageDialog messageDialog;
        messageDialog = this.f16338a.f16328i;
        messageDialog.dismiss();
        this.f16338a.m4621b(true);
    }
}
