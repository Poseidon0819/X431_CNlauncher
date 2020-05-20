package com.cnlaunch.x431pro.widget.p290a;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bt */
/* loaded from: classes.dex */
public final class RunnableC2836bt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16331a;

    /* renamed from: b */
    final /* synthetic */ ProgressDialog f16332b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2836bt(ProgressDialog progressDialog, int i) {
        this.f16332b = progressDialog;
        this.f16331a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressBar progressBar;
        progressBar = this.f16332b.f16325c;
        progressBar.setProgress(this.f16331a);
    }
}
