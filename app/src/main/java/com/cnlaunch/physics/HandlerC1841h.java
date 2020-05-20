package com.cnlaunch.physics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceFactoryManager.java */
/* renamed from: com.cnlaunch.physics.h */
/* loaded from: classes.dex */
public final class HandlerC1841h extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeviceFactoryManager f9932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1841h(DeviceFactoryManager deviceFactoryManager, Looper looper) {
        super(looper);
        this.f9932a = deviceFactoryManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        Context context2;
        if (message2.what == 20496) {
            context = this.f9932a.f9920u;
            if (context != null) {
                try {
                    context2 = this.f9932a.f9920u;
                    DeviceFactoryManager.m8276f(context2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
