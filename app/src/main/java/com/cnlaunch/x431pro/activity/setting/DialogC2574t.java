package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.widget.p290a.ProgressDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.t */
/* loaded from: classes.dex */
public final class DialogC2574t extends ProgressDialog {

    /* renamed from: a */
    final /* synthetic */ DiagnosticLogVehicleListFragment f14843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2574t(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment, Context context) {
        super(context);
        this.f14843a = diagnosticLogVehicleListFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.ProgressDialog
    /* renamed from: a */
    public final void mo4625a(boolean z) {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        SimpleOnDownloadListener unused;
        if (z) {
            unused = this.f14843a.f14833p;
            return;
        }
        progressDialog = this.f14843a.f14832o;
        if (progressDialog != null) {
            progressDialog2 = this.f14843a.f14832o;
            progressDialog2.show();
        }
    }
}
