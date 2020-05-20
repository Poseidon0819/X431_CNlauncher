package com.cnlaunch.wifiprinter;

import java.util.TimerTask;

/* compiled from: PrintTest.java */
/* renamed from: com.cnlaunch.wifiprinter.q */
/* loaded from: classes.dex */
final class C1930q extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC1929p f10500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1930q(HandlerC1929p handlerC1929p) {
        this.f10500a = handlerC1929p;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f10500a.f10499a.f10485u) {
            return;
        }
        this.f10500a.f10499a.m7992b();
    }
}
