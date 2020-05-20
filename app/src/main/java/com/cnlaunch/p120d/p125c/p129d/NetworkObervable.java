package com.cnlaunch.p120d.p125c.p129d;

import android.net.NetworkInfo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.cnlaunch.d.c.d.a */
/* loaded from: classes.dex */
public final class NetworkObervable {

    /* renamed from: a */
    public List<NetworkObserver> f7178a = new LinkedList();

    /* renamed from: a */
    public final void m9474a(NetworkInfo networkInfo) {
        for (NetworkObserver networkObserver : this.f7178a) {
            if (networkObserver != null) {
                if (networkInfo != null) {
                    if (!networkInfo.isConnected() || !networkInfo.isAvailable()) {
                        networkObserver.m9473a(networkInfo);
                    } else {
                        networkObserver.f7179a.post(new RunnableC1434d(networkObserver, networkInfo));
                    }
                } else {
                    networkObserver.m9473a(networkInfo);
                }
            }
        }
    }
}
