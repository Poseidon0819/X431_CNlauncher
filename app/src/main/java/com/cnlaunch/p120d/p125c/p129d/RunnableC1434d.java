package com.cnlaunch.p120d.p125c.p129d;

import android.net.NetworkInfo;

/* compiled from: NetworkObserver.java */
/* renamed from: com.cnlaunch.d.c.d.d */
/* loaded from: classes.dex */
final class RunnableC1434d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetworkInfo f7182a;

    /* renamed from: b */
    final /* synthetic */ NetworkObserver f7183b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1434d(NetworkObserver networkObserver, NetworkInfo networkInfo) {
        this.f7183b = networkObserver;
        this.f7182a = networkInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7183b.mo5916b();
    }
}
