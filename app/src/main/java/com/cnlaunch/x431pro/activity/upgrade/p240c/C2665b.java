package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestApkVersionInfo;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.google.gson.Gson;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.b */
/* loaded from: classes.dex */
public final class C2665b extends Thread {

    /* renamed from: a */
    final /* synthetic */ boolean f15284a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2665b(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, boolean z) {
        this.f15285b = apkUpgradeAndDownloadLogic;
        this.f15284a = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f15285b.m5634a(new C2666c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String m9591a = PreferencesManager.m9595a(this.f15285b.f15277v).m9591a("apk_soft_info");
        LatestApkVersionInfo latestApkVersionInfo = TextUtils.isEmpty(m9591a) ? null : (LatestApkVersionInfo) new Gson().fromJson(m9591a, (Class<Object>) LatestApkVersionInfo.class);
        NLog.m9456a("yhx", "begin download apk.latestApkVersionInfo=".concat(String.valueOf(latestApkVersionInfo)));
        if (latestApkVersionInfo == null) {
            if (this.f15285b.f15253B != null) {
                this.f15285b.f15253B.mo4930b(this.f15285b.f15256E, -1);
                return;
            }
            return;
        }
        boolean m9583b = PreferencesManager.m9595a(this.f15285b.f15277v).m9583b("has_new_apk_version", false);
        NLog.m9456a("yhx", "isHasNewVersion=".concat(String.valueOf(m9583b)));
        if (!m9583b) {
            if (this.f15285b.f15253B != null) {
                this.f15285b.f15253B.mo4930b(this.f15285b.f15256E, 0);
                return;
            }
            return;
        }
        String str = PathUtils.m4852e() + this.f15285b.m5625c(latestApkVersionInfo.getVersionNo());
        if (new File(str).exists()) {
            if (this.f15285b.f15253B != null) {
                this.f15285b.f15253B.mo4930b(this.f15285b.f15256E, 0);
            }
            if (this.f15284a) {
                new Thread(new ApkUpgradeAndDownloadLogic.RunnableC2664a(str)).start();
                return;
            }
            return;
        }
        this.f15285b.f15275s = new HandlerC2668e(r1, r1.f15276u.getLooper());
        ApkUpgradeAndDownloadLogic.m5622f(this.f15285b);
        ApkUpgradeAndDownloadLogic.m5631a(this.f15285b, latestApkVersionInfo);
        if (this.f15285b.f15253B != null) {
            this.f15285b.f15253B.mo5615a(this.f15285b.f15256E);
        }
    }
}
