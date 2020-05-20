package com.cnlaunch.wifiprinter;

import java.util.TimerTask;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.ai */
/* loaded from: classes.dex */
final class C1890ai extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC1889ah f10394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1890ai(HandlerC1889ah handlerC1889ah) {
        this.f10394a = handlerC1889ah;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        new C1897ap(this.f10394a.f10393a).start();
    }
}
