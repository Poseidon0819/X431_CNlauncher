package com.cnlaunch.x431pro.activity.bluetooth;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p192a.BluetoothScanManager;
import com.cnlaunch.physics.p197c.BluetoothListDto;
import com.cnlaunch.physics.p199e.IPhysics;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: BluetoothActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.c */
/* loaded from: classes.dex */
final class HandlerC1993c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BluetoothActivity f10938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1993c(BluetoothActivity bluetoothActivity) {
        this.f10938a = bluetoothActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        BluetoothScanManager bluetoothScanManager;
        String str;
        ArrayList m7798a;
        BluetoothListAdapter bluetoothListAdapter;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        boolean z;
        Button button5;
        Button button6;
        ArrayList arrayList3;
        ArrayList arrayList4;
        BluetoothScanManager bluetoothScanManager2;
        String str2;
        ArrayList m7798a2;
        BluetoothListAdapter bluetoothListAdapter2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i;
        Context context;
        boolean z2;
        try {
            int i2 = message2.what;
            if (i2 == 110) {
                arrayList = this.f10938a.f10900n;
                arrayList.clear();
                arrayList2 = this.f10938a.f10900n;
                BluetoothActivity bluetoothActivity = this.f10938a;
                bluetoothScanManager = this.f10938a.f10897k;
                ArrayList<BluetoothListDto> arrayList5 = bluetoothScanManager.f9792c;
                str = this.f10938a.f10902p;
                m7798a = bluetoothActivity.m7798a(arrayList5, str, ((Integer) message2.obj).intValue());
                arrayList2.addAll(m7798a);
                bluetoothListAdapter = this.f10938a.f10896j;
                bluetoothListAdapter.notifyDataSetChanged();
            } else if (i2 == 160) {
                button = this.f10938a.f10893g;
                if (button != null) {
                    button2 = this.f10938a.f10893g;
                    button2.setEnabled(false);
                    button3 = this.f10938a.f10893g;
                    button3.setText(R.string.bluetooth_scaning);
                }
            } else if (i2 == 170) {
                button4 = this.f10938a.f10893g;
                if (button4 != null) {
                    z = this.f10938a.f10905s;
                    if (!z) {
                        button6 = this.f10938a.f10893g;
                        button6.setEnabled(true);
                    }
                    button5 = this.f10938a.f10893g;
                    button5.setText(R.string.bluetooth_scan_start);
                }
            } else if (i2 == 180) {
                arrayList3 = this.f10938a.f10900n;
                arrayList3.clear();
                arrayList4 = this.f10938a.f10900n;
                BluetoothActivity bluetoothActivity2 = this.f10938a;
                bluetoothScanManager2 = this.f10938a.f10897k;
                ArrayList<BluetoothListDto> arrayList6 = bluetoothScanManager2.f9792c;
                str2 = this.f10938a.f10902p;
                m7798a2 = bluetoothActivity2.m7798a(arrayList6, str2, ((Integer) message2.obj).intValue());
                arrayList4.addAll(m7798a2);
                bluetoothListAdapter2 = this.f10938a.f10896j;
                bluetoothListAdapter2.notifyDataSetChanged();
                relativeLayout = this.f10938a.f10891e;
                if (relativeLayout != null) {
                    relativeLayout2 = this.f10938a.f10891e;
                    relativeLayout2.setVisibility(0);
                }
            } else if (i2 == 5632) {
                BluetoothListDto bluetoothListDto = (BluetoothListDto) message2.obj;
                if (bluetoothListDto != null) {
                    BluetoothActivity.m7801a(this.f10938a, bluetoothListDto);
                }
            } else if (i2 != 20502) {
            } else {
                BluetoothListDto bluetoothListDto2 = (BluetoothListDto) message2.obj;
                if (message2.arg1 <= 0) {
                    DeviceFactoryManager.m8305a().m8284d();
                }
                if (bluetoothListDto2 != null) {
                    DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
                    i = this.f10938a.f10904r;
                    m8305a.f9907g = i;
                    IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                    if (iPhysics == null) {
                        DeviceFactoryManager m8305a2 = DeviceFactoryManager.m8305a();
                        context = this.f10938a.f10889c;
                        z2 = this.f10938a.f10901o;
                        iPhysics = m8305a2.m8301a(context, z2, bluetoothListDto2.f9849f.getName());
                    }
                    this.f10938a.m7803a(iPhysics instanceof BluetoothManager ? (BluetoothManager) iPhysics : null, bluetoothListDto2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
