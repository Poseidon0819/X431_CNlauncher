package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.n */
/* loaded from: classes.dex */
final class DialogC2872n extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2870l f16458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2872n(HandlerC2870l handlerC2870l, Context context) {
        super(context);
        this.f16458a = handlerC2870l;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        r0.f16419I.sendMessage(this.f16458a.f16456a.f16419I.obtainMessage(1, 0, 0));
        ((DiagnoseActivity) this.f16458a.f16456a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
    }
}
