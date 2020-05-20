package com.cnlaunch.x431pro.activity.mine;

import java.util.TimerTask;

/* compiled from: VehicleVoltageFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.db */
/* loaded from: classes.dex */
final class C2476db extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C2475da f14198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2476db(C2475da c2475da) {
        this.f14198a = c2475da;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        VehicleVoltageFragment.m6154f(this.f14198a.f14197a);
    }
}
