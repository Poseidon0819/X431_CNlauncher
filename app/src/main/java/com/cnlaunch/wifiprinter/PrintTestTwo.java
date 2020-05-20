package com.cnlaunch.wifiprinter;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.cnlaunch.wifiprinter.aa */
/* loaded from: classes.dex */
public final class PrintTestTwo extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintTestTwo(FragmentC1934u fragmentC1934u) {
        this.f10352a = fragmentC1934u;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        FragmentC1934u fragmentC1934u = this.f10352a;
        fragmentC1934u.f10523q = true;
        new C1882ad(fragmentC1934u).start();
    }
}
