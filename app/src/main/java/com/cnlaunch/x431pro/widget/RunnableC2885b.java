package com.cnlaunch.x431pro.widget;

import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.b */
/* loaded from: classes.dex */
public final class RunnableC2885b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16489a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeProgressDialog f16490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2885b(ApkUpgradeProgressDialog apkUpgradeProgressDialog, int i) {
        this.f16490b = apkUpgradeProgressDialog;
        this.f16489a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        textView = this.f16490b.f16120c;
        textView.setText(this.f16489a);
    }
}
