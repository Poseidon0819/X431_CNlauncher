package com.cnlaunch.p183l.p184a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.cnlaunch.p183l.p185b.ILaunchAidlService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AidlClient.java */
/* renamed from: com.cnlaunch.l.a.b */
/* loaded from: classes.dex */
public final class ServiceConnectionC1796b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AidlClient f9524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC1796b(AidlClient aidlClient) {
        this.f9524a = aidlClient;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f9524a.f9522d = ILaunchAidlService.AbstractBinderC1797a.m8632a(iBinder);
        AidlClient aidlClient = this.f9524a;
        aidlClient.f9521c = true;
        Log.i(aidlClient.f9519a, "onServiceConnected sucess!");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        AidlClient aidlClient = this.f9524a;
        aidlClient.f9522d = null;
        aidlClient.f9521c = false;
    }
}
