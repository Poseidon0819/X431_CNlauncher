package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p192a.BluetoothManager;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ae */
/* loaded from: classes.dex */
final class C2044ae extends Thread {

    /* renamed from: a */
    final /* synthetic */ BluetoothManager f11489a;

    /* renamed from: b */
    final /* synthetic */ C2043ad f11490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2044ae(C2043ad c2043ad, BluetoothManager bluetoothManager) {
        this.f11490b = c2043ad;
        this.f11489a = bluetoothManager;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f11490b.f11488a.f11110bg = true;
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f11490b.f11488a.f11110bg = false;
        String m9591a = PreferencesManager.m9595a((Context) this.f11490b.f11488a).m9591a("serialNo");
        this.f11489a.m8450a(m9591a, m9591a.equals(PreferencesManager.m9595a((Context) this.f11490b.f11488a).m9591a("bluetooth_name")) ? PreferencesManager.m9595a((Context) this.f11490b.f11488a).m9591a("bluetooth_address") : "");
    }
}
