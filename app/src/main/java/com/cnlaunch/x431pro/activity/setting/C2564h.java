package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cnlaunch.p120d.p125c.p129d.NetworkObervable;

/* compiled from: CheckServerFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.h */
/* loaded from: classes.dex */
final class C2564h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CheckServerFragment f14798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2564h(CheckServerFragment checkServerFragment) {
        this.f14798a = checkServerFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkObervable networkObervable;
        NetworkObervable networkObervable2;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            networkObervable = this.f14798a.f14755ar;
            if (networkObervable != null) {
                networkObervable2 = this.f14798a.f14755ar;
                networkObervable2.m9474a(activeNetworkInfo);
            }
        }
    }
}
