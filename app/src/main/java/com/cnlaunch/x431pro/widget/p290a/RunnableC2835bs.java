package com.cnlaunch.x431pro.widget.p290a;

import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bs */
/* loaded from: classes.dex */
public final class RunnableC2835bs implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16329a;

    /* renamed from: b */
    final /* synthetic */ ProgressDialog f16330b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2835bs(ProgressDialog progressDialog, int i) {
        this.f16330b = progressDialog;
        this.f16329a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        textView = this.f16330b.f16326g;
        textView.setText(this.f16329a);
    }
}
