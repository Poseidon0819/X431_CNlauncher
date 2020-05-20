package com.cnlaunch.x431pro.widget;

import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: ApkUpgradeProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC2907f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeProgressDialog f16580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2907f(ApkUpgradeProgressDialog apkUpgradeProgressDialog) {
        this.f16580a = apkUpgradeProgressDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageDialog messageDialog;
        messageDialog = this.f16580a.f16123i;
        messageDialog.dismiss();
    }
}
