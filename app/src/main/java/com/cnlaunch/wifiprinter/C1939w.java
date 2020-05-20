package com.cnlaunch.wifiprinter;

import android.content.Intent;
import java.util.TimerTask;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.w */
/* loaded from: classes.dex */
final class C1939w extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC1938v f10538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1939w(HandlerC1938v handlerC1938v) {
        this.f10538a = handlerC1938v;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (Constant.f10349d) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("WifiprinterStep");
        intent.putExtra("step", 3);
        this.f10538a.f10537a.f10519m.sendBroadcast(intent);
    }
}
