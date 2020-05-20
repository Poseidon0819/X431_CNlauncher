package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.widget.p290a.OnLineProgrammingDialog;

/* compiled from: OnLineProgrammingDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bn */
/* loaded from: classes.dex */
final class DialogC2832bn extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ OnLineProgrammingDialog.AsyncTaskC2828a f16319a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2832bn(OnLineProgrammingDialog.AsyncTaskC2828a asyncTaskC2828a, Context context) {
        super(context);
        this.f16319a = asyncTaskC2828a;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        OnLineProgrammingDialog.this.f16290a.mo7093a(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
    }
}
