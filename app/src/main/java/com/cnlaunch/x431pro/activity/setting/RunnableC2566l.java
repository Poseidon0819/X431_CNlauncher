package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.l */
/* loaded from: classes.dex */
final class RunnableC2566l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2565k f14835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2566l(C2565k c2565k) {
        this.f14835a = c2565k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        context = this.f14835a.f14834a.mContext;
        DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment = this.f14835a.f14834a;
        str = this.f14835a.f14834a.f14828k;
        NToast.m9446b(context, diagnosticLogVehicleListFragment.getString(R.string.soft_download_tip, new Object[]{str}));
    }
}
