package com.cnlaunch.p120d.p125c.p129d;

import android.net.NetworkInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkObserver.java */
/* renamed from: com.cnlaunch.d.c.d.c */
/* loaded from: classes.dex */
public final class RunnableC1433c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetworkInfo f7180a;

    /* renamed from: b */
    final /* synthetic */ NetworkObserver f7181b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1433c(NetworkObserver networkObserver, NetworkInfo networkInfo) {
        this.f7181b = networkObserver;
        this.f7180a = networkInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7181b.mo5917a();
    }
}
