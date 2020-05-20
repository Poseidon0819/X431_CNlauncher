package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;

/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ad */
/* loaded from: classes.dex */
final class View$OnClickListenerC2807ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2807ad(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16140a = view$OnClickListenerC2884z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f16140a.f16471b;
        ((DiagnoseActivity) context).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
    }
}
