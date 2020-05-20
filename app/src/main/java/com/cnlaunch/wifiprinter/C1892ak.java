package com.cnlaunch.wifiprinter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.wifiprinter.C1900at;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.ak */
/* loaded from: classes.dex */
final class C1892ak extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1892ak(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10396a = printerLinkLocalNet;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("Search_WIFI") || this.f10396a.f10371l == null) {
            return;
        }
        this.f10396a.f10371l.notifyDataSetChanged();
        this.f10396a.f10373n.setEnabled(true);
        this.f10396a.f10373n.setTextColor(context.getResources().getColor(C1900at.C1902b.white));
    }
}
