package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.j */
/* loaded from: classes.dex */
public final class C2674j extends Thread {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2674j(DownloadLogic downloadLogic) {
        this.f15339a = downloadLogic;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        List list;
        int m5603b;
        String str;
        String str2;
        super.run();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        list = this.f15339a.f15322o;
        list.clear();
        this.f15339a.m5608a(new C2675k(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NLog.m9456a("DownloadLogic", "oneKeyDownloadSpecialSoft 1");
        m5603b = this.f15339a.m5603b();
        if (m5603b <= 0) {
            OnDownloadListener onDownloadListener = this.f15339a.f15310b;
            str2 = this.f15339a.f15307K;
            onDownloadListener.mo4930b(str2, -1);
            return;
        }
        this.f15339a.f15332z = new HandlerC2679o(r0, r0.f15329v.getLooper());
        DownloadLogic.m5596g(this.f15339a);
        DownloadLogic.m5595h(this.f15339a);
        OnDownloadListener onDownloadListener2 = this.f15339a.f15310b;
        str = this.f15339a.f15307K;
        onDownloadListener2.mo5615a(str);
    }
}
