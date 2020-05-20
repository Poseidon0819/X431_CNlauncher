package com.cnlaunch.x431pro.activity.diagnose;

import android.view.View;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.aa */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2040aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2040aa(DiagnoseActivity diagnoseActivity) {
        this.f11485a = diagnoseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RemoteDiagHandler remoteDiagHandler;
        if (this.f11485a.mo7083i().getDiagnoseStatue() > 1) {
            this.f11485a.m7600x();
            if (this.f11485a.getFragmentManager().getBackStackEntryCount() > 0) {
                try {
                    this.f11485a.getFragmentManager().popBackStackImmediate((String) null, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                this.f11485a.m7596z();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        remoteDiagHandler = this.f11485a.f11015D;
        remoteDiagHandler.mo7050a(109);
    }
}
