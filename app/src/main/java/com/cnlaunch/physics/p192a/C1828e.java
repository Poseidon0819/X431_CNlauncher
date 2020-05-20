package com.cnlaunch.physics.p192a;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.physics.p205k.C1856n;
import com.mopub.mobileads.VastExtensionXmlManager;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothScanManager.java */
/* renamed from: com.cnlaunch.physics.a.e */
/* loaded from: classes.dex */
public final class C1828e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BluetoothScanManager f9798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1828e(BluetoothScanManager bluetoothScanManager) {
        this.f9798a = bluetoothScanManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C1856n.m8130a("BluetoothScanManager", "action=".concat(String.valueOf(action)));
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null || !BluetoothScanManager.m8398a(bluetoothDevice) || bluetoothDevice.getBondState() == 12) {
                return;
            }
            this.f9798a.m8397a(bluetoothDevice, false);
            C1856n.m8125d("BluetoothScanManager", "no Bonded Devices name=" + bluetoothDevice.getName() + " address=" + bluetoothDevice.getAddress());
        } else if ("android.bluetooth.device.action.NAME_CHANGED".equals(action)) {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            C1856n.m8125d("BluetoothScanManager", "ACTION_NAME_CHANGED Devices name=" + bluetoothDevice2.getName() + " address=" + bluetoothDevice2.getAddress());
            if (bluetoothDevice2 == null || !BluetoothScanManager.m8398a(bluetoothDevice2)) {
                return;
            }
            if (bluetoothDevice2.getBondState() != 12) {
                this.f9798a.m8397a(bluetoothDevice2, false);
            } else {
                this.f9798a.m8397a(bluetoothDevice2, true);
            }
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            C1856n.m8125d("BluetoothScanManager", "BluetoothAdapter ACTION_DISCOVERY_FINISHED");
            if (this.f9798a.f9791b != null) {
                this.f9798a.f9791b.mo7746c();
            }
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                if (C1856n.f10135a) {
                    C1856n.m8125d("BluetoothScanManager", "BluetoothAdapter ACTION_STATE_CHANGED STATE_ON and EXTRA_PREVIOUS_STATE=" + intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10));
                }
                this.f9798a.m8392c();
            }
        } else if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
            C1856n.m8125d("BluetoothScanManager", "BluetoothAdapter ACTION_DISCOVERY_STARTED");
            if (this.f9798a.f9791b != null) {
                this.f9798a.f9791b.mo7747b();
            }
        } else if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            C1856n.m8125d("BluetoothScanManager", "BluetoothAdapter ACTION_BOND_STATE_CHANGED");
            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            C1856n.m8125d("BluetoothScanManager", "ACTION_BOND_STATE_CHANGED name=" + bluetoothDevice3.getName() + " address=" + bluetoothDevice3.getAddress());
        } else if ("action.bt.device.con.coning".equals(action) || "action.bt.device.con.success".equals(action) || "action.bt.device.con.fail".equals(action) || "action.bt.device.con.lost".equals(action)) {
            Bundle bundleExtra = intent.getBundleExtra("customBluetoothBroadcastIntentExtraBundle");
            if (!"action.bt.device.con.fail".equals(action)) {
                BluetoothScanManager.m8396a(this.f9798a, (BluetoothDevice) bundleExtra.getParcelable("bluetoothDevice"), bundleExtra.getString("status"));
            }
            if (this.f9798a.f9791b != null) {
                this.f9798a.f9791b.mo7748a(bundleExtra.getInt(VastExtensionXmlManager.TYPE));
            }
            if (!"action.bt.device.con.success".equals(action)) {
                if ("action.bt.device.con.fail".equals(action) || "action.bt.device.con.lost".equals(action)) {
                    return;
                }
                "action.bt.device.con.coning".equals(action);
            } else if (this.f9798a.f9791b != null) {
                this.f9798a.f9791b.mo7749a();
            }
        } else if ("DPUDeviceConnectFail".equals(action)) {
            BluetoothScanManager.m8394a(this.f9798a, intent.getStringExtra("deviceName"), BluetoothScanManager.f9790a.getString(C1411a.C1412a.bluetooth_connect_fail));
            if (this.f9798a.f9791b != null) {
                this.f9798a.f9791b.mo7748a(Opcodes.GETFIELD);
            }
        }
    }
}
