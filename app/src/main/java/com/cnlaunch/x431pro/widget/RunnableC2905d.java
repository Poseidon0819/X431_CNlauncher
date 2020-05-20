package com.cnlaunch.x431pro.widget;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.d */
/* loaded from: classes.dex */
public final class RunnableC2905d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16576a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeProgressDialog f16577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2905d(ApkUpgradeProgressDialog apkUpgradeProgressDialog, int i) {
        this.f16577b = apkUpgradeProgressDialog;
        this.f16576a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressBar progressBar;
        progressBar = this.f16577b.f16119b;
        progressBar.setProgressDrawable(this.f16577b.getContext().getResources().getDrawable(this.f16576a));
    }
}
