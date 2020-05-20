package com.cnlaunch.p169im.p172c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.o */
/* loaded from: classes.dex */
public final class C1719o extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ProMessageFragment f9151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1719o(ProMessageFragment proMessageFragment) {
        this.f9151a = proMessageFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                this.f9151a.f9126i.sendEmptyMessage(10015);
            } else {
                this.f9151a.f9126i.sendEmptyMessage(10016);
            }
        } else if ("add_friend".equals(intent.getAction()) && intent.getBooleanExtra("result", false)) {
            String stringExtra = intent.getStringExtra("target_id");
            str = this.f9151a.f9098E;
            if (stringExtra.equals(str)) {
                ProMessageFragment.m8819y(this.f9151a);
                this.f9151a.f9122e.f24078c = this.f9151a.f9099F;
            }
        }
    }
}
