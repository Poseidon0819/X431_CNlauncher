package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p199e.IPhysics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.aq */
/* loaded from: classes.dex */
public final class C2056aq extends Thread {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2056aq(DiagnoseActivity diagnoseActivity) {
        this.f11510a = diagnoseActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String m9591a = PreferencesManager.m9595a((Context) this.f11510a).m9591a("serialNo");
        String m9591a2 = m9591a.equals(PreferencesManager.m9595a((Context) this.f11510a).m9591a("bluetooth_name")) ? PreferencesManager.m9595a((Context) this.f11510a).m9591a("bluetooth_address") : "";
        IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
        BluetoothManager bluetoothManager = iPhysics instanceof BluetoothManager ? (BluetoothManager) iPhysics : null;
        if (bluetoothManager != null) {
            bluetoothManager.m8450a(m9591a, m9591a2);
        }
    }
}
