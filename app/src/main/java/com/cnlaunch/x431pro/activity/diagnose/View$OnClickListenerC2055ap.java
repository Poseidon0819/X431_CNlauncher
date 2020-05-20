package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import android.view.View;
import com.cnlaunch.physics.DPULinkSettingsInformation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ap */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2055ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f11508a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f11509b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2055ap(DiagnoseActivity diagnoseActivity, String str) {
        this.f11509b = diagnoseActivity;
        this.f11508a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler;
        DPULinkSettingsInformation.m8314a().m8312a(this.f11508a, true);
        handler = this.f11509b.f11103bO;
        handler.sendEmptyMessage(20512);
    }
}
