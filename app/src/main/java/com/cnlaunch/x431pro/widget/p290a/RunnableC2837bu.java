package com.cnlaunch.x431pro.widget.p290a;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bu */
/* loaded from: classes.dex */
public final class RunnableC2837bu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16333a;

    /* renamed from: b */
    final /* synthetic */ ProgressDialog f16334b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2837bu(ProgressDialog progressDialog, int i) {
        this.f16334b = progressDialog;
        this.f16333a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressBar progressBar;
        progressBar = this.f16334b.f16325c;
        progressBar.setProgressDrawable(this.f16334b.getContext().getResources().getDrawable(this.f16333a));
    }
}
