package com.cnlaunch.wifiprinter;

import java.util.TimerTask;

/* compiled from: PrintTest.java */
/* renamed from: com.cnlaunch.wifiprinter.r */
/* loaded from: classes.dex */
final class C1931r extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ PrintTest f10501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1931r(PrintTest printTest) {
        this.f10501a = printTest;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f10501a.f10485u) {
            return;
        }
        this.f10501a.m7992b();
    }
}
