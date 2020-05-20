package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p192a.BluetoothManager;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.u */
/* loaded from: classes.dex */
final class C2213u extends Thread {

    /* renamed from: a */
    final /* synthetic */ BluetoothManager f12487a;

    /* renamed from: b */
    final /* synthetic */ HandlerC2212t f12488b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2213u(HandlerC2212t handlerC2212t, BluetoothManager bluetoothManager) {
        this.f12488b = handlerC2212t;
        this.f12487a = bluetoothManager;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String m9591a = PreferencesManager.m9595a((Context) this.f12488b.f12486a).m9591a("serialNo");
        this.f12487a.m8450a(m9591a, m9591a.equals(PreferencesManager.m9595a((Context) this.f12488b.f12486a).m9591a("bluetooth_name")) ? PreferencesManager.m9595a((Context) this.f12488b.f12486a).m9591a("bluetooth_address") : "");
    }
}
