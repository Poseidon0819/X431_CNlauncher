package com.cnlaunch.wifiprinter;

import android.content.Intent;
import java.util.TimerTask;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.e */
/* loaded from: classes.dex */
final class C1917e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC1916d f10451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1917e(HandlerC1916d handlerC1916d) {
        this.f10451a = handlerC1916d;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Intent intent = new Intent();
        intent.setAction("WifiprinterStep");
        intent.putExtra("step", 2);
        this.f10451a.f10450a.f10432j.sendBroadcast(intent);
    }
}
