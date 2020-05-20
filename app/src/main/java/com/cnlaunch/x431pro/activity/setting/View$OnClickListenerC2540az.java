package com.cnlaunch.x431pro.activity.setting;

import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: SendDiagnosticLogActivity1.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.az */
/* loaded from: classes.dex */
final class View$OnClickListenerC2540az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageDialog f14633a;

    /* renamed from: b */
    final /* synthetic */ SendDiagnosticLogActivity1 f14634b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2540az(SendDiagnosticLogActivity1 sendDiagnosticLogActivity1, MessageDialog messageDialog) {
        this.f14634b = sendDiagnosticLogActivity1;
        this.f14633a = messageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f14633a.dismiss();
    }
}
