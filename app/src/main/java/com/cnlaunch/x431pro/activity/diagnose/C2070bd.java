package com.cnlaunch.x431pro.activity.diagnose;

import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bd */
/* loaded from: classes.dex */
public final class C2070bd extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ MessageDialog f11533a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f11534b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2070bd(DiagnoseActivity diagnoseActivity, MessageDialog messageDialog) {
        this.f11534b = diagnoseActivity;
        this.f11533a = messageDialog;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        MessageDialog messageDialog = this.f11533a;
        if (messageDialog != null) {
            messageDialog.dismiss();
        }
    }
}
