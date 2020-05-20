package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.al */
/* loaded from: classes.dex */
final class View$OnClickListenerC2051al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2051al(DiagnoseActivity diagnoseActivity) {
        this.f11503a = diagnoseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f11503a.f11019H;
        LoadDialog.m4681b(context);
        if (this.f11503a.mo7083i().getDiagnoseStatue() == 1) {
            DiagnoseActivity.m7703S(this.f11503a);
        }
        this.f11503a.mo7085f(1);
    }
}
