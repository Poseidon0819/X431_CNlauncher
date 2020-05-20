package com.cnlaunch.x431pro.widget.p290a;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnLineProgrammingDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bl */
/* loaded from: classes.dex */
public final class C2830bl extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ OnLineProgrammingDialog f16317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2830bl(OnLineProgrammingDialog onLineProgrammingDialog) {
        this.f16317a = onLineProgrammingDialog;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        IFragmentCallback iFragmentCallback;
        if ((!MainActivity.m7895b() && !MainActivity.m7881d()) || this.f16317a.f16288A) {
            iFragmentCallback = this.f16317a.f16290a;
            iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE, "00", 3);
        }
        this.f16317a.dismiss();
    }
}
