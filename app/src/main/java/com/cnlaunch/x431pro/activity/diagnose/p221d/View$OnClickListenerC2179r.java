package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NLog;

/* compiled from: ChooseFileFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.r */
/* loaded from: classes.dex */
final class View$OnClickListenerC2179r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChooseFileFragment f12375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2179r(ChooseFileFragment chooseFileFragment) {
        this.f12375a = chooseFileFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NLog.m9456a("ChooseFileFragment", "cancel exit.");
        this.f12375a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG, "00", 3);
    }
}
