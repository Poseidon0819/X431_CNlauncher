package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.remoteapdu.c */
/* loaded from: classes2.dex */
public final class ServiceConnectionC4276c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C4274a f22770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4276c(C4274a c4274a) {
        this.f22770a = c4274a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        Handler handler2;
        IRemoteApdu iRemoteApdu;
        IInitCallback.Stub stub;
        IRemoteApdu iRemoteApdu2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        C4390k.m838a("plugin-tsm", "mConnection.onServiceConnected()");
        handler = this.f22770a.f22764e;
        if (handler != null) {
            handler5 = this.f22770a.f22764e;
            handler5.removeMessages(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
        }
        try {
            C4274a.m1276b(this.f22770a);
            this.f22770a.f22761b = IRemoteApdu.Stub.asInterface(iBinder);
            handler2 = this.f22770a.f22764e;
            if (handler2 != null) {
                handler3 = this.f22770a.f22764e;
                handler4 = this.f22770a.f22764e;
                handler3.sendMessageDelayed(Message.obtain(handler4, (int) SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY), 8000L);
            }
            iRemoteApdu = this.f22770a.f22761b;
            stub = this.f22770a.f22768i;
            iRemoteApdu.registerCallback(stub);
            iRemoteApdu2 = this.f22770a.f22761b;
            iRemoteApdu2.init();
        } catch (Exception unused) {
            if (this.f22770a.f22760a != null) {
                this.f22770a.f22760a.mo1205b();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        Handler handler2;
        C4390k.m838a("plugin-tsm", "mConnection.onServiceDisconnected()");
        handler = this.f22770a.f22764e;
        if (handler != null) {
            handler2 = this.f22770a.f22764e;
            handler2.removeMessages(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
        }
        this.f22770a.f22761b = null;
        if (this.f22770a.f22760a != null) {
            this.f22770a.f22760a.mo1205b();
        }
    }
}
