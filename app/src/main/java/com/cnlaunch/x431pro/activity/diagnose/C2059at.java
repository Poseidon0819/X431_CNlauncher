package com.cnlaunch.x431pro.activity.diagnose;

import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.at */
/* loaded from: classes.dex */
public final class C2059at extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2059at(DiagnoseActivity diagnoseActivity) {
        this.f11513a = diagnoseActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        boolean z;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        boolean z2;
        RemoteDiagHandler remoteDiagHandler;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness2;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness3;
        z = this.f11513a.f11042aF;
        if (z) {
            return;
        }
        DiagnoseActivity.m7700V(this.f11513a);
        diagnoseUIDataBusiness = this.f11513a.f11070ah;
        if (diagnoseUIDataBusiness != null) {
            diagnoseUIDataBusiness2 = this.f11513a.f11070ah;
            diagnoseUIDataBusiness2.setbCanShowDialog(false);
            diagnoseUIDataBusiness3 = this.f11513a.f11070ah;
            diagnoseUIDataBusiness3.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
        }
        if (this.f11513a.mo7083i().getDiagnoseStatue() < 2) {
            remoteDiagHandler = this.f11513a.f11015D;
            remoteDiagHandler.mo7050a(109);
        } else {
            if (C2744aa.m5166c() && !C1947h.f10551c) {
                this.f11513a.m7602w();
                C1947h.f10552d = false;
            }
            z2 = this.f11513a.f11024N;
            this.f11513a.m7620n();
            this.f11513a.m7598y();
            this.f11513a.m7632f(z2);
            DeviceFactoryManager.m8305a().f9906f = false;
        }
        DiagnoseConstants.SHOW_EXIT_DIALOG = false;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness2;
        DiagnoseConstants.SHOW_EXIT_DIALOG = false;
        DiagnoseActivity.m7603v(this.f11513a);
        diagnoseUIDataBusiness = this.f11513a.f11070ah;
        if (diagnoseUIDataBusiness != null) {
            diagnoseUIDataBusiness2 = this.f11513a.f11070ah;
            diagnoseUIDataBusiness2.setbCanShowDialog(true);
        }
    }
}
