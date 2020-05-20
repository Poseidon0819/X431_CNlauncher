package com.cnlaunch.physics.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.physics.p205k.NetworkUtil;

/* compiled from: DPUWiFiManager.java */
/* renamed from: com.cnlaunch.physics.wifi.d */
/* loaded from: classes.dex */
final class C1870d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiManager f10223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1870d(DPUWiFiManager dPUWiFiManager) {
        this.f10223a = dPUWiFiManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (NetworkUtil.m8123a(context) || this.f10223a.f10203k) {
                return;
            }
            DPUWiFiManager dPUWiFiManager = this.f10223a;
            dPUWiFiManager.f10203k = true;
            dPUWiFiManager.f10193a.sendBroadcast(new Intent("DPUDeviceConnectDisconnected"));
        } else if (intent.getAction().equals("CUSTOMWiFiConnectDisconnected")) {
            this.f10223a.f10193a.sendBroadcast(new Intent("DPUDeviceConnectDisconnected"));
        }
    }
}
