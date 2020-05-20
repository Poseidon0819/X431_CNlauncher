package com.cnlaunch.physics.p192a.p193a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;

/* renamed from: com.cnlaunch.physics.a.a.g */
/* loaded from: classes.dex */
public final class BluetoothLeScannerManager {

    /* renamed from: a */
    InterfaceC1819a f9742a;

    /* renamed from: b */
    private BluetoothLeScanner f9743b;

    /* renamed from: c */
    private ScanCallback f9744c = new C1820h(this);

    /* compiled from: BluetoothLeScannerManager.java */
    /* renamed from: com.cnlaunch.physics.a.a.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1819a {
        /* renamed from: a */
        void mo8391a();

        /* renamed from: a */
        void mo8390a(int i);

        /* renamed from: a */
        void mo8389a(BluetoothDevice bluetoothDevice);

        /* renamed from: b */
        void mo8388b();
    }

    public BluetoothLeScannerManager(BluetoothAdapter bluetoothAdapter, InterfaceC1819a interfaceC1819a) {
        this.f9743b = bluetoothAdapter.getBluetoothLeScanner();
        this.f9742a = interfaceC1819a;
    }

    /* renamed from: a */
    public final void m8454a() {
        BluetoothLeScanner bluetoothLeScanner = this.f9743b;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.startScan(this.f9744c);
            InterfaceC1819a interfaceC1819a = this.f9742a;
            if (interfaceC1819a != null) {
                interfaceC1819a.mo8391a();
                return;
            }
            return;
        }
        m8453b();
    }

    /* renamed from: b */
    public final void m8453b() {
        BluetoothLeScanner bluetoothLeScanner = this.f9743b;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f9744c);
        }
        InterfaceC1819a interfaceC1819a = this.f9742a;
        if (interfaceC1819a != null) {
            interfaceC1819a.mo8388b();
        }
    }
}
