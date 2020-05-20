package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;

/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.n */
/* loaded from: classes.dex */
final class View$OnClickListenerC2568n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC2567m f14837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2568n(RunnableC2567m runnableC2567m) {
        this.f14837a = runnableC2567m;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Intent intent = new Intent(DiagnoseConstants.DIAG_EXIT_BROADCAST);
        context = this.f14837a.f14836a.f14834a.mContext;
        context.sendBroadcast(intent);
        RemoteDiagObserve.m7940a();
    }
}
