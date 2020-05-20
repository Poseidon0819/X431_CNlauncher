package com.cnlaunch.physics.p192a.p194b;

import java.util.TimerTask;

/* compiled from: BluetoothManagerImpl.java */
/* renamed from: com.cnlaunch.physics.a.b.c */
/* loaded from: classes.dex */
final class C1824c extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ BluetoothManagerImpl f9784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1824c(BluetoothManagerImpl bluetoothManagerImpl) {
        this.f9784a = bluetoothManagerImpl;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        BluetoothManagerImpl.m8440a(this.f9784a);
    }
}
