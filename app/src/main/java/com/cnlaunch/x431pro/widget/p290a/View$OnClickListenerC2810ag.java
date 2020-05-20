package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;

/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ag */
/* loaded from: classes.dex */
final class View$OnClickListenerC2810ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2810ag(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16143a = view$OnClickListenerC2884z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f16143a.f16471b;
        ((DiagnoseActivity) context).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
    }
}
