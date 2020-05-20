package com.cnlaunch.x431pro.widget;

import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC2908g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeProgressDialog f16581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2908g(ApkUpgradeProgressDialog apkUpgradeProgressDialog) {
        this.f16581a = apkUpgradeProgressDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageDialog messageDialog;
        messageDialog = this.f16581a.f16123i;
        messageDialog.dismiss();
        this.f16581a.m4726c();
    }
}
