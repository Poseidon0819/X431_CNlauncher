package com.cnlaunch.physics.wifi;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import com.cnlaunch.physics.p205k.Tools;

/* compiled from: DPUWiFiManager.java */
/* renamed from: com.cnlaunch.physics.wifi.c */
/* loaded from: classes.dex */
final class HandlerC1869c extends Handler {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiManager f10222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1869c(DPUWiFiManager dPUWiFiManager, Looper looper) {
        super(looper);
        this.f10222a = dPUWiFiManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Intent intent = new Intent("DPUDeviceConnectSuccess");
        intent.putExtra("isFix", this.f10222a.f10198f);
        intent.putExtra(MessageDao.TABLENAME, this.f10222a.f10193a.getString(C1411a.C1412a.msg_wifi_connect_state_success));
        this.f10222a.f10193a.sendBroadcast(intent);
        DPUWiFiManager dPUWiFiManager = this.f10222a;
        IntentFilter intentFilter = new IntentFilter();
        if (Tools.m8113a(dPUWiFiManager.f10193a)) {
            intentFilter.addAction("CUSTOMWiFiConnectDisconnected");
        } else if (!NetworkUtil.m8117c(dPUWiFiManager.f10193a).booleanValue()) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        dPUWiFiManager.f10203k = false;
        dPUWiFiManager.f10193a.registerReceiver(dPUWiFiManager.f10205m, intentFilter);
        C1856n.m8127b("DPUWiFiManager", "wifi connected success,starting transfer data ");
        this.f10222a.f10193a.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
    }
}
