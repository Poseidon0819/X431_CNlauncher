package com.cnlaunch.wifiprinter;

import android.content.Intent;
import java.util.TimerTask;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.aj */
/* loaded from: classes.dex */
final class C1891aj extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC1889ah f10395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1891aj(HandlerC1889ah handlerC1889ah) {
        this.f10395a = handlerC1889ah;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (Constant.f10349d) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("WifiprinterStep");
        intent.putExtra("step", 3);
        this.f10395a.f10393a.f10370k.sendBroadcast(intent);
    }
}
