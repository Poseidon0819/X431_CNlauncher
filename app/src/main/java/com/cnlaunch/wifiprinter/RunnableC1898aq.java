package com.cnlaunch.wifiprinter;

import com.cnlaunch.wifiprinter.PrinterLinkLocalNet;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.aq */
/* loaded from: classes.dex */
final class RunnableC1898aq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet.C1887c f10403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1898aq(PrinterLinkLocalNet.C1887c c1887c) {
        this.f10403a = c1887c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrinterLinkLocalNet.this.f10378s.post(new RunnableC1899ar(this));
    }
}
