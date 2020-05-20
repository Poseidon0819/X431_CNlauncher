package com.cnlaunch.p120d.p125c.p129d;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.cnlaunch.d.c.d.b */
/* loaded from: classes.dex */
public abstract class NetworkObserver {

    /* renamed from: a */
    Handler f7179a;

    /* renamed from: a */
    public abstract void mo5917a();

    /* renamed from: b */
    public abstract void mo5916b();

    public NetworkObserver(Looper looper) {
        this.f7179a = new Handler(looper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9473a(NetworkInfo networkInfo) {
        this.f7179a.post(new RunnableC1433c(this, networkInfo));
    }
}
