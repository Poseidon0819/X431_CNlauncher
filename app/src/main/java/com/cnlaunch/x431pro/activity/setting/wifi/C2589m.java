package com.cnlaunch.x431pro.activity.setting.wifi;

import android.os.Handler;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DPUWiFiModeSettingsWaitDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.m */
/* loaded from: classes.dex */
public final class C2589m implements OnWiFiModeListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiModeSettingsWaitDialog f14889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2589m(DPUWiFiModeSettingsWaitDialog dPUWiFiModeSettingsWaitDialog) {
        this.f14889a = dPUWiFiModeSettingsWaitDialog;
    }

    @Override // com.cnlaunch.physics.p201g.OnWiFiModeListener
    /* renamed from: a */
    public final void mo5844a(int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (i == 0) {
            handler = this.f14889a.f14888e;
            handler.sendEmptyMessage(0);
        } else if (i != 7) {
            handler3 = this.f14889a.f14888e;
            handler3.sendEmptyMessage(1);
        } else {
            handler2 = this.f14889a.f14888e;
            handler2.sendEmptyMessage(4);
        }
    }

    @Override // com.cnlaunch.physics.p201g.OnWiFiModeListener
    /* renamed from: a */
    public final void mo5843a(int i, DPUWiFiModeConfig dPUWiFiModeConfig) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f14889a.f14886c = dPUWiFiModeConfig;
        if (i == 0) {
            handler = this.f14889a.f14888e;
            handler.sendEmptyMessage(2);
        } else if (i != 7) {
            handler3 = this.f14889a.f14888e;
            handler3.sendEmptyMessage(3);
        } else {
            handler2 = this.f14889a.f14888e;
            handler2.sendEmptyMessage(4);
        }
    }
}
