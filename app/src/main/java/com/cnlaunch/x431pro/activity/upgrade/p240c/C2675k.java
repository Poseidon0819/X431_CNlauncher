package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener;
import java.util.concurrent.CountDownLatch;

/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.k */
/* loaded from: classes.dex */
final class C2675k implements OnQueryListener {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f15340a;

    /* renamed from: b */
    final /* synthetic */ C2674j f15341b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2675k(C2674j c2674j, CountDownLatch countDownLatch) {
        this.f15341b = c2674j;
        this.f15340a = countDownLatch;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener
    /* renamed from: a */
    public final void mo5586a(int i) {
        this.f15340a.countDown();
        NLog.m9456a("DownloadLogic", "getDiagSofts: state = ", Integer.valueOf(i));
        DownloadLogic.m5602b(this.f15341b.f15339a);
    }
}
