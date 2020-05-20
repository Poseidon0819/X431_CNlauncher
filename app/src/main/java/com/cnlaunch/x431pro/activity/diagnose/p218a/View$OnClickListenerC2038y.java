package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SystemStatusCodeFragment;

/* compiled from: SystemStatusCodeListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.y */
/* loaded from: classes.dex */
final class View$OnClickListenerC2038y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11480a;

    /* renamed from: b */
    final /* synthetic */ int f11481b;

    /* renamed from: c */
    final /* synthetic */ SystemStatusCodeListAdapter f11482c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2038y(SystemStatusCodeListAdapter systemStatusCodeListAdapter, int i, int i2) {
        this.f11482c = systemStatusCodeListAdapter;
        this.f11480a = i;
        this.f11481b = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SystemStatusCodeFragment systemStatusCodeFragment;
        SystemStatusCodeFragment systemStatusCodeFragment2;
        systemStatusCodeFragment = this.f11482c.f11451a;
        if (systemStatusCodeFragment != null) {
            systemStatusCodeFragment2 = this.f11482c.f11451a;
            int i = this.f11480a;
            int i2 = this.f11481b;
            int m7149b = systemStatusCodeFragment2.m7149b(systemStatusCodeFragment2.f12263a.get(i).getSystemName());
            systemStatusCodeFragment2.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000301" + SystemStatusCodeFragment.m7151b(m7149b) + SystemStatusCodeFragment.m7151b(i2), 3);
        }
    }
}
