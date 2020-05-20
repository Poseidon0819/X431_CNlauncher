package com.cnlaunch.wifiprinter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.wifiprinter.C1900at;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.x */
/* loaded from: classes.dex */
final class C1940x extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1940x(FragmentC1934u fragmentC1934u) {
        this.f10539a = fragmentC1934u;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("Search_WIFI") || this.f10539a.f10520n == null) {
            return;
        }
        this.f10539a.f10520n.notifyDataSetChanged();
        this.f10539a.f10522p.setEnabled(true);
        this.f10539a.f10522p.setTextColor(context.getResources().getColor(C1900at.C1902b.white));
    }
}
