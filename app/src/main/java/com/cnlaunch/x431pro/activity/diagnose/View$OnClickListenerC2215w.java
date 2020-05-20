package com.cnlaunch.x431pro.activity.diagnose;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.w */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2215w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f12491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2215w(DiagnoseActivity diagnoseActivity) {
        this.f12491a = diagnoseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f12491a.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
    }
}
