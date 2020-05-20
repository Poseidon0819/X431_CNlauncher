package com.cnlaunch.x431pro.activity.diagnose;

import android.media.SoundPool;
import android.view.View;
import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ab */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2041ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2041ab(DiagnoseActivity diagnoseActivity) {
        this.f11486a = diagnoseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        int i;
        SoundPool soundPool;
        int i2;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness2;
        DiagnoseActivity.m7603v(this.f11486a);
        diagnoseUIDataBusiness = this.f11486a.f11070ah;
        if (diagnoseUIDataBusiness != null) {
            diagnoseUIDataBusiness2 = this.f11486a.f11070ah;
            diagnoseUIDataBusiness2.setbCanShowDialog(true);
        }
        i = this.f11486a.f11098bJ;
        if (i > 0) {
            soundPool = this.f11486a.f11096bH;
            i2 = this.f11486a.f11098bJ;
            soundPool.pause(i2);
            this.f11486a.f11098bJ = 0;
        }
        DiagnoseActivity.m7597y(this.f11486a);
    }
}
