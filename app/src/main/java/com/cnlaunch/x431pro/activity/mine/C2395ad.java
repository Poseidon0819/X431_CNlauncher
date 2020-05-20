package com.cnlaunch.x431pro.activity.mine;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: DPULinkManagerFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ad */
/* loaded from: classes.dex */
final class C2395ad extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DPULinkManagerFragment f13626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2395ad(DPULinkManagerFragment dPULinkManagerFragment) {
        this.f13626a = dPULinkManagerFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C1856n.m8130a("DPULinkManagerFragment", "device name: ".concat(String.valueOf(((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getName())));
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (intExtra == 10) {
            C1856n.m8130a("DPULinkManagerFragment", "BOND_NONE");
            this.f13626a.m6499a();
        } else if (intExtra != 12) {
        } else {
            C1856n.m8130a("DPULinkManagerFragment", "BOND_BONDED");
            this.f13626a.m6499a();
        }
    }
}
