package com.cnlaunch.physics.wifi;

import com.cnlaunch.physics.DPUDeviceType;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.wifi.Smartbox30DPUWiFiModeSettings;
import com.cnlaunch.physics.wifi.StandardDPUWiFiModeSettings;

/* renamed from: com.cnlaunch.physics.wifi.f */
/* loaded from: classes.dex */
public final class DPUWiFiModeSettings {

    /* renamed from: a */
    public OnWiFiModeListener f10227a;

    /* renamed from: b */
    public IPhysics f10228b;

    /* renamed from: c */
    public int f10229c;

    public DPUWiFiModeSettings(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener) {
        this(iPhysics, onWiFiModeListener, DPUDeviceType.f9691a);
    }

    private DPUWiFiModeSettings(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener, int i) {
        this.f10227a = onWiFiModeListener;
        this.f10228b = iPhysics;
        this.f10229c = i;
    }

    /* renamed from: a */
    public final void m8036a(DPUWiFiModeConfig dPUWiFiModeConfig) {
        if (this.f10229c == DPUDeviceType.f9692b) {
            new Thread(new Smartbox30DPUWiFiModeSettings.RunnableC1872b(this.f10228b, this.f10227a, dPUWiFiModeConfig)).start();
        } else {
            new Thread(new StandardDPUWiFiModeSettings.RunnableC1874b(this.f10228b, this.f10227a, dPUWiFiModeConfig)).start();
        }
    }
}
