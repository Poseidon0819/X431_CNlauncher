package com.cnlaunch.wifiprinter;

import com.cnlaunch.wifiprinter.FragmentC1934u;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.ae */
/* loaded from: classes.dex */
final class RunnableC1883ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u.C1937c f10357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1883ae(FragmentC1934u.C1937c c1937c) {
        this.f10357a = c1937c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentC1934u.this.f10527u.post(new RunnableC1884af(this));
    }
}
