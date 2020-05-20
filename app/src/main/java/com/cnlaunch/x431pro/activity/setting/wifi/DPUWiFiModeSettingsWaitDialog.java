package com.cnlaunch.x431pro.activity.setting.wifi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.physics.wifi.DPUWiFiModeSettings;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.l */
/* loaded from: classes.dex */
public final class DPUWiFiModeSettingsWaitDialog extends WaitDialog {

    /* renamed from: a */
    OnWiFiModeListener f14885a;

    /* renamed from: c */
    private DPUWiFiModeConfig f14886c;

    /* renamed from: d */
    private DPUWiFiLinkModeSettings.InterfaceC2579a f14887d;

    /* renamed from: e */
    private Handler f14888e;

    public DPUWiFiModeSettingsWaitDialog(Context context, String str, DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a) {
        super(context, str);
        this.f14885a = new C2589m(this);
        this.f14888e = new HandlerC2590n(this);
        this.f14887d = interfaceC2579a;
    }

    /* renamed from: a */
    public final void m5850a(IPhysics iPhysics, DPUWiFiModeConfig dPUWiFiModeConfig) {
        this.f14886c = dPUWiFiModeConfig;
        new DPUWiFiModeSettings(iPhysics, this.f14885a).m8036a(dPUWiFiModeConfig);
    }

    /* renamed from: a */
    public final void m5847a(String str) {
        TextView textView = (TextView) findViewById(16908299);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
