package com.cnlaunch.wifiprinter;

import com.cnlaunch.wifiprinter.MainActivity;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.k */
/* loaded from: classes.dex */
final class RunnableC1923k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MainActivity.C1915b f10458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1923k(MainActivity.C1915b c1915b) {
        this.f10458a = c1915b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.this.f10436n.post(new RunnableC1924l(this));
    }
}
