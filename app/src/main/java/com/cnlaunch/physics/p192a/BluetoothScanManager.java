package com.cnlaunch.physics.p192a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager;
import com.cnlaunch.physics.p197c.BluetoothListDto;
import com.cnlaunch.physics.p201g.OnBluetoothListener;
import com.cnlaunch.physics.p205k.C1856n;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.cnlaunch.physics.a.d */
/* loaded from: classes.dex */
public final class BluetoothScanManager {

    /* renamed from: a */
    static Context f9790a;

    /* renamed from: b */
    public OnBluetoothListener f9791b;

    /* renamed from: c */
    public ArrayList<BluetoothListDto> f9792c;

    /* renamed from: d */
    private BluetoothAdapter f9793d;

    /* renamed from: e */
    private boolean f9794e;

    /* renamed from: f */
    private BluetoothLeScannerManager f9795f;

    /* renamed from: g */
    private final BroadcastReceiver f9796g;

    /* renamed from: h */
    private BluetoothLeScannerManager.InterfaceC1819a f9797h;

    public BluetoothScanManager(Context context) {
        this(context, (byte) 0);
    }

    private BluetoothScanManager(Context context, byte b) {
        this.f9796g = new C1828e(this);
        this.f9797h = new C1829f(this);
        this.f9794e = false;
        f9790a = context;
        this.f9793d = BluetoothAdapter.getDefaultAdapter();
        if (!this.f9793d.isEnabled()) {
            this.f9793d.enable();
        }
        this.f9792c = new ArrayList<>();
        if (this.f9794e) {
            this.f9795f = new BluetoothLeScannerManager(this.f9793d, this.f9797h);
        } else {
            this.f9795f = null;
        }
        C1856n.m8125d("BluetoothScanManager", "BluetoothScanManager register Receiver");
        IntentFilter intentFilter = new IntentFilter();
        if (!this.f9794e) {
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.NAME_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        }
        intentFilter.addAction("action.bt.device.con.coning");
        intentFilter.addAction("action.bt.device.con.success");
        intentFilter.addAction("action.bt.device.con.fail");
        intentFilter.addAction("action.bt.device.con.lost");
        intentFilter.addAction("DPUDeviceConnectFail");
        f9790a.registerReceiver(this.f9796g, intentFilter);
    }

    /* renamed from: a */
    public final void m8399a() {
        try {
            f9790a.unregisterReceiver(this.f9796g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f9794e) {
            this.f9795f.m8453b();
        } else if (this.f9793d.isDiscovering()) {
            this.f9793d.cancelDiscovery();
        }
        this.f9792c.clear();
    }

    /* renamed from: b */
    public final void m8393b() {
        if (this.f9794e) {
            this.f9795f.m8454a();
            return;
        }
        if (!this.f9793d.isEnabled()) {
            this.f9793d.enable();
        }
        m8392c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m8397a(BluetoothDevice bluetoothDevice, boolean z) {
        boolean z2;
        int i = 0;
        while (true) {
            if (i >= this.f9792c.size()) {
                z2 = false;
                break;
            } else if (bluetoothDevice.getAddress().equals(this.f9792c.get(i).f9845b)) {
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            return;
        }
        BluetoothListDto bluetoothListDto = new BluetoothListDto();
        bluetoothListDto.f9844a = bluetoothDevice.getName();
        bluetoothListDto.f9845b = bluetoothDevice.getAddress();
        bluetoothListDto.f9848e = z;
        bluetoothListDto.f9847d = false;
        bluetoothListDto.f9849f = bluetoothDevice;
        bluetoothListDto.f9846c = f9790a.getString(C1411a.C1412a.bluetooth_no_connected);
        this.f9792c.add(bluetoothListDto);
        OnBluetoothListener onBluetoothListener = this.f9791b;
        if (onBluetoothListener != null) {
            onBluetoothListener.mo7748a(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m8398a(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        return name != null && name.matches("([0-9]{12})");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void m8392c() {
        this.f9792c.clear();
        Set<BluetoothDevice> bondedDevices = this.f9793d.getBondedDevices();
        if (bondedDevices != null) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (bluetoothDevice != null && m8398a(bluetoothDevice)) {
                    C1856n.m8125d("BluetoothScanManager", "Bonded Devices name=" + bluetoothDevice.getName());
                    m8397a(bluetoothDevice, true);
                }
            }
        }
        C1856n.m8127b("BluetoothScanManager", "开始扫描蓝牙设备列表...");
        if (this.f9793d.isDiscovering()) {
            this.f9793d.cancelDiscovery();
        }
        this.f9793d.startDiscovery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8396a(BluetoothScanManager bluetoothScanManager, BluetoothDevice bluetoothDevice, String str) {
        if (bluetoothDevice != null) {
            for (int i = 0; i < bluetoothScanManager.f9792c.size(); i++) {
                BluetoothDevice bluetoothDevice2 = bluetoothScanManager.f9792c.get(i).f9849f;
                if (bluetoothDevice2 != null && bluetoothDevice2.getAddress().equals(bluetoothDevice.getAddress())) {
                    bluetoothScanManager.f9792c.get(i).f9848e = true;
                    bluetoothScanManager.f9792c.get(i).f9846c = str;
                } else {
                    bluetoothScanManager.f9792c.get(i).f9846c = f9790a.getString(C1411a.C1412a.bluetooth_no_connected);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8394a(BluetoothScanManager bluetoothScanManager, String str, String str2) {
        for (int i = 0; i < bluetoothScanManager.f9792c.size(); i++) {
            if (bluetoothScanManager.f9792c.get(i).f9849f.getAddress().equals(str)) {
                bluetoothScanManager.f9792c.get(i).f9848e = true;
                bluetoothScanManager.f9792c.get(i).f9846c = str2;
            } else {
                bluetoothScanManager.f9792c.get(i).f9846c = f9790a.getString(C1411a.C1412a.bluetooth_no_connected);
            }
        }
    }
}
