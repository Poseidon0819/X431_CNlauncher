package com.cnlaunch.physics.p192a;

import android.bluetooth.BluetoothDevice;
import com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager;
import com.cnlaunch.physics.p205k.C1856n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothScanManager.java */
/* renamed from: com.cnlaunch.physics.a.f */
/* loaded from: classes.dex */
public final class C1829f implements BluetoothLeScannerManager.InterfaceC1819a {

    /* renamed from: a */
    final /* synthetic */ BluetoothScanManager f9799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1829f(BluetoothScanManager bluetoothScanManager) {
        this.f9799a = bluetoothScanManager;
    }

    @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
    /* renamed from: a */
    public final void mo8391a() {
        C1856n.m8125d("BluetoothScanManager", "BLE_SCAN_STARTED");
        if (this.f9799a.f9791b != null) {
            this.f9799a.f9791b.mo7747b();
        }
    }

    @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
    /* renamed from: b */
    public final void mo8388b() {
        C1856n.m8125d("BluetoothScanManager", "BLE_SCAN_FINISHED");
        if (this.f9799a.f9791b != null) {
            this.f9799a.f9791b.mo7746c();
        }
    }

    @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
    /* renamed from: a */
    public final void mo8389a(BluetoothDevice bluetoothDevice) {
        C1856n.m8130a("BluetoothScanManager", "onScanResult =bluetoothDevice " + bluetoothDevice.getName());
        if (bluetoothDevice == null || !BluetoothScanManager.m8398a(bluetoothDevice)) {
            return;
        }
        this.f9799a.m8397a(bluetoothDevice, false);
        C1856n.m8125d("BluetoothScanManager", "no Bonded Devices name=" + bluetoothDevice.getName() + " address=" + bluetoothDevice.getAddress());
    }

    @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
    /* renamed from: a */
    public final void mo8390a(int i) {
        C1856n.m8130a("BluetoothScanManager", "BLE_SCAN_FINISHED WITH ERROR=".concat(String.valueOf(i)));
        if (this.f9799a.f9791b != null) {
            this.f9799a.f9791b.mo7746c();
        }
    }
}
