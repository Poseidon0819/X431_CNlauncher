package com.cnlaunch.x431pro.widget;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.c */
/* loaded from: classes.dex */
public final class RunnableC2899c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16548a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeProgressDialog f16549b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2899c(ApkUpgradeProgressDialog apkUpgradeProgressDialog, int i) {
        this.f16549b = apkUpgradeProgressDialog;
        this.f16548a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressBar progressBar;
        progressBar = this.f16549b.f16119b;
        progressBar.setProgress(this.f16548a);
    }
}
