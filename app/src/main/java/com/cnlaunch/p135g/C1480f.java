package com.cnlaunch.p135g;

import java.util.TimerTask;

/* compiled from: MobileLocationLogic.java */
/* renamed from: com.cnlaunch.g.f */
/* loaded from: classes.dex */
final class C1480f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ MobileLocationLogic f7310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1480f(MobileLocationLogic mobileLocationLogic) {
        this.f7310a = mobileLocationLogic;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f7310a.m9422a();
    }
}
