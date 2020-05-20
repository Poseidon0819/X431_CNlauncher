package com.cnlaunch.physics;

import android.os.RemoteException;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceFactoryManager.java */
/* renamed from: com.cnlaunch.physics.g */
/* loaded from: classes.dex */
public final class BinderC1840g extends IRemoteDeviceFactoryManagerCallBack.AbstractBinderC1844a {

    /* renamed from: a */
    final /* synthetic */ DeviceFactoryManager f9931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC1840g(DeviceFactoryManager deviceFactoryManager) {
        this.f9931a = deviceFactoryManager;
    }

    @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack
    /* renamed from: a */
    public final void mo8264a(String str) throws RemoteException {
        this.f9931a.m8298a(str);
    }
}
