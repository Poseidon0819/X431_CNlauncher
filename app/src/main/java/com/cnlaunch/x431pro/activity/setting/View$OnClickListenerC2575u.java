package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.ProgressDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.u */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2575u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnosticLogVehicleListFragment f14844a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2575u(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        this.f14844a = diagnosticLogVehicleListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        String str;
        String str2;
        SimpleOnDownloadListener simpleOnDownloadListener;
        ProgressDialog progressDialog;
        String str3;
        Context context3;
        context = this.f14844a.mContext;
        if (!C2787z.m4821a(DownloadLogic.m5609a(context).f15309a)) {
            str3 = this.f14844a.f14821d;
            context3 = this.f14844a.mContext;
            if (!str3.equals(DownloadLogic.m5609a(context3).f15309a)) {
                DiagnosticLogVehicleListFragment.m5906d(this.f14844a);
                return;
            }
        }
        context2 = this.f14844a.mContext;
        DownloadLogic m5609a = DownloadLogic.m5609a(context2);
        str = this.f14844a.f14821d;
        str2 = this.f14844a.f14829l;
        simpleOnDownloadListener = this.f14844a.f14833p;
        m5609a.m5604a(str, str2, simpleOnDownloadListener);
        progressDialog = this.f14844a.f14832o;
        progressDialog.show();
    }
}
