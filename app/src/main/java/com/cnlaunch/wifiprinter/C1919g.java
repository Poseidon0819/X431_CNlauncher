package com.cnlaunch.wifiprinter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.wifiprinter.C1900at;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.g */
/* loaded from: classes.dex */
final class C1919g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10453a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1919g(MainActivity mainActivity) {
        this.f10453a = mainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("Search_result") || this.f10453a.f10433k == null) {
            return;
        }
        this.f10453a.f10433k.notifyDataSetChanged();
        this.f10453a.f10435m.setEnabled(true);
        this.f10453a.f10435m.setTextColor(context.getResources().getColor(C1900at.C1902b.white));
    }
}
