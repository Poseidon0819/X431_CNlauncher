package com.cnlaunch.x431pro.activity.diagnose;

import android.content.DialogInterface;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.y */
/* loaded from: classes.dex */
final class DialogInterface$OnCancelListenerC2217y implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f12493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC2217y(DiagnoseActivity diagnoseActivity) {
        this.f12493a = diagnoseActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        AsyncTaskManager.m9576a(60001);
        AsyncTaskManager.m9576a(60002);
        this.f12493a.mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
        DiagnoseActivity.m7611r(this.f12493a);
    }
}
