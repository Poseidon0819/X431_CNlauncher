package com.cnlaunch.physics.p192a.p193a;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothLeScannerManager.java */
/* renamed from: com.cnlaunch.physics.a.a.h */
/* loaded from: classes.dex */
public final class C1820h extends ScanCallback {

    /* renamed from: a */
    final /* synthetic */ BluetoothLeScannerManager f9745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1820h(BluetoothLeScannerManager bluetoothLeScannerManager) {
        this.f9745a = bluetoothLeScannerManager;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i, ScanResult scanResult) {
        if (this.f9745a.f9742a != null) {
            this.f9745a.f9742a.mo8389a(scanResult.getDevice());
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> list) {
        if (this.f9745a.f9742a != null) {
            for (ScanResult scanResult : list) {
                this.f9745a.f9742a.mo8389a(scanResult.getDevice());
            }
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i) {
        if (this.f9745a.f9742a != null) {
            this.f9745a.f9742a.mo8390a(i);
        }
    }
}
