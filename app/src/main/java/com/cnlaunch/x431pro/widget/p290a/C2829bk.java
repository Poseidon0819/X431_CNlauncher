package com.cnlaunch.x431pro.widget.p290a;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import java.util.TimerTask;

/* compiled from: OnLineProgrammingDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bk */
/* loaded from: classes.dex */
final class C2829bk extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ IFragmentCallback f16315a;

    /* renamed from: b */
    final /* synthetic */ OnLineProgrammingDialog f16316b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2829bk(OnLineProgrammingDialog onLineProgrammingDialog, IFragmentCallback iFragmentCallback) {
        this.f16316b = onLineProgrammingDialog;
        this.f16315a = iFragmentCallback;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f16316b.dismiss();
        this.f16315a.mo7093a(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE, "00", 3);
    }
}
