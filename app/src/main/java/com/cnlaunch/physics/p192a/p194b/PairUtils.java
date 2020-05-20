package com.cnlaunch.physics.p192a.p194b;

import android.bluetooth.BluetoothDevice;

/* renamed from: com.cnlaunch.physics.a.b.f */
/* loaded from: classes.dex */
public final class PairUtils {
    /* renamed from: a */
    public static boolean m8401a(Class cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("createBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    /* renamed from: a */
    public static boolean m8400a(Class cls, BluetoothDevice bluetoothDevice, String str) throws Exception {
        try {
            cls.getDeclaredMethod("setPin", byte[].class).invoke(bluetoothDevice, str.getBytes());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return true;
    }
}
