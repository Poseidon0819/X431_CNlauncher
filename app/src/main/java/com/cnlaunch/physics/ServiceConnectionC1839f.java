package com.cnlaunch.physics;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager;
import com.cnlaunch.physics.p205k.C1856n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceFactoryManager.java */
/* renamed from: com.cnlaunch.physics.f */
/* loaded from: classes.dex */
public final class ServiceConnectionC1839f implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ DeviceFactoryManager f9927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC1839f(DeviceFactoryManager deviceFactoryManager) {
        this.f9927a = deviceFactoryManager;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IRemoteDeviceFactoryManager iRemoteDeviceFactoryManager;
        Handler handler;
        this.f9927a.f9914n = IRemoteDeviceFactoryManager.AbstractBinderC1842a.m8269a(iBinder);
        this.f9927a.m8289b(true);
        try {
            iRemoteDeviceFactoryManager = this.f9927a.f9914n;
            if (iRemoteDeviceFactoryManager.mo8268a() < 2) {
                handler = this.f9927a.f9899D;
                handler.sendEmptyMessage(20496);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1856n.m8130a("DeviceFactoryManager", "onServiceConnected sucess!");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f9927a.f9914n = null;
    }
}
