package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.mobile.android.utils.C4390k;

/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.d */
/* loaded from: classes2.dex */
final class ServiceConnectionC4281d implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C4279b f22779a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4281d(C4279b c4279b) {
        this.f22779a = c4279b;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        C4390k.m838a("plugin-clientV3", "startSamsungService onServiceConnected");
        try {
            this.f22779a.f22774c = ITsmConnection.Stub.asInterface(iBinder);
            handler = this.f22779a.f22777f;
            handler.removeMessages(1);
            this.f22779a.m1269a(true);
        } catch (Exception unused) {
            this.f22779a.m1269a(false);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        C4390k.m838a("plugin-clientV3", "startSamsungService onServiceDisconnected");
        this.f22779a.f22774c = null;
        handler = this.f22779a.f22777f;
        handler.removeMessages(1);
        this.f22779a.m1269a(false);
    }
}
