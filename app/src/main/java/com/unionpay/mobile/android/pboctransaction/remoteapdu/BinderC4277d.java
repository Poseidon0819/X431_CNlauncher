package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.Handler;
import android.os.RemoteException;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.tsm.connect.IInitCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.remoteapdu.d */
/* loaded from: classes2.dex */
public final class BinderC4277d extends IInitCallback.Stub {

    /* renamed from: a */
    final /* synthetic */ C4274a f22771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC4277d(C4274a c4274a) {
        this.f22771a = c4274a;
    }

    @Override // com.unionpay.mobile.tsm.connect.IInitCallback
    public final void initFailed() throws RemoteException {
        Handler handler;
        Handler handler2;
        C4390k.m838a("plugin-tsm", "mInitCallback.initFailed()");
        handler = this.f22771a.f22764e;
        if (handler != null) {
            handler2 = this.f22771a.f22764e;
            handler2.removeMessages(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
        }
        if (this.f22771a.f22760a != null) {
            this.f22771a.f22760a.mo1205b();
        }
    }

    @Override // com.unionpay.mobile.tsm.connect.IInitCallback
    public final void initSucceed() throws RemoteException {
        Handler handler;
        Handler handler2;
        C4390k.m838a("plugin-tsm", "mInitCallback.initSucceed()");
        handler = this.f22771a.f22764e;
        if (handler != null) {
            handler2 = this.f22771a.f22764e;
            handler2.removeMessages(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
        }
        if (this.f22771a.f22760a != null) {
            this.f22771a.f22760a.mo1206a();
        }
    }
}
