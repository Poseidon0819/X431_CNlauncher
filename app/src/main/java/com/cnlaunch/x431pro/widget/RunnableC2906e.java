package com.cnlaunch.x431pro.widget;

import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.e */
/* loaded from: classes.dex */
public final class RunnableC2906e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16578a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeProgressDialog f16579b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2906e(ApkUpgradeProgressDialog apkUpgradeProgressDialog, int i) {
        this.f16579b = apkUpgradeProgressDialog;
        this.f16578a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        textView = this.f16579b.f16120c;
        textView.setTextColor(this.f16579b.getContext().getResources().getColor(this.f16578a));
    }
}
