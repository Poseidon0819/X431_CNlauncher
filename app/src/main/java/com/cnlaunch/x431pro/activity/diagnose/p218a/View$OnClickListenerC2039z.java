package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SystemStatusCodeFragment;

/* compiled from: SystemStatusCodeListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.z */
/* loaded from: classes.dex */
final class View$OnClickListenerC2039z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11483a;

    /* renamed from: b */
    final /* synthetic */ SystemStatusCodeListAdapter f11484b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2039z(SystemStatusCodeListAdapter systemStatusCodeListAdapter, int i) {
        this.f11484b = systemStatusCodeListAdapter;
        this.f11483a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SystemStatusCodeFragment systemStatusCodeFragment;
        SystemStatusCodeFragment systemStatusCodeFragment2;
        systemStatusCodeFragment = this.f11484b.f11451a;
        if (systemStatusCodeFragment != null) {
            systemStatusCodeFragment2 = this.f11484b.f11451a;
            int i = this.f11483a;
            systemStatusCodeFragment2.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000204" + SystemStatusCodeFragment.m7151b(i), 3);
        }
    }
}
