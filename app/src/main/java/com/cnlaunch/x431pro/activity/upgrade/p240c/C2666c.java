package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener;
import java.util.concurrent.CountDownLatch;

/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.c */
/* loaded from: classes.dex */
final class C2666c implements OnQueryListener {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f15286a;

    /* renamed from: b */
    final /* synthetic */ C2665b f15287b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2666c(C2665b c2665b, CountDownLatch countDownLatch) {
        this.f15287b = c2665b;
        this.f15286a = countDownLatch;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener
    /* renamed from: a */
    public final void mo5586a(int i) {
        this.f15286a.countDown();
        NLog.m9456a("yhx", "getLatestApkVersion: state = ", Integer.valueOf(i));
        ApkUpgradeAndDownloadLogic.m5633a(this.f15287b.f15285b);
    }
}
