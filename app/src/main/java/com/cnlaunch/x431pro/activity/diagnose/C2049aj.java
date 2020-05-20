package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p192a.BluetoothManager;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.aj */
/* loaded from: classes.dex */
final class C2049aj extends Thread {

    /* renamed from: a */
    final /* synthetic */ BluetoothManager f11500a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2048ai f11501b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2049aj(View$OnClickListenerC2048ai view$OnClickListenerC2048ai, BluetoothManager bluetoothManager) {
        this.f11501b = view$OnClickListenerC2048ai;
        this.f11500a = bluetoothManager;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String m9591a = PreferencesManager.m9595a((Context) this.f11501b.f11499d).m9591a("serialNo");
        this.f11500a.m8450a(m9591a, m9591a.equals(PreferencesManager.m9595a((Context) this.f11501b.f11499d).m9591a("bluetooth_name")) ? PreferencesManager.m9595a((Context) this.f11501b.f11499d).m9591a("bluetooth_address") : "");
    }
}
