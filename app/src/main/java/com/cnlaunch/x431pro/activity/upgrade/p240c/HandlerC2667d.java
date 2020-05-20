package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.os.Looper;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.d */
/* loaded from: classes.dex */
public final class HandlerC2667d extends DownLoadCallback {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2667d(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, Looper looper) {
        super(looper);
        this.f15288a = apkUpgradeAndDownloadLogic;
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4520a(String str, int i, int i2) {
        super.mo4520a(str, i, i2);
        int round = (int) Math.round(Math.ceil((i / i2) * 100.0f));
        NLog.m9456a("yhx", "onLoading enter,fileName=" + str + ",pecentage=" + round);
        this.f15288a.f15254C = 1;
        if (this.f15288a.f15253B != null) {
            this.f15288a.f15253B.mo5614a(this.f15288a.f15256E, round);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4519a(String str, String str2) {
        boolean z;
        super.mo4519a(str, str2);
        NLog.m9456a("yhx", "download onSuccess, fileName:" + str + ", filePath:" + str2);
        this.f15288a.f15254C = 2;
        if (this.f15288a.f15253B != null) {
            this.f15288a.f15253B.mo4930b(this.f15288a.f15256E, 0);
        }
        z = this.f15288a.f15281z;
        if (z) {
            new Thread(new ApkUpgradeAndDownloadLogic.RunnableC2664a(str2)).start();
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: b */
    public final void mo4518b(String str, String str2) {
        DownloadManager downloadManager;
        DownloadManager downloadManager2;
        DownloadManager downloadManager3;
        super.mo4518b(str, str2);
        boolean z = true;
        NLog.m9451c("yhx", "onFailure: " + str + ", strMsg: " + str2);
        if (str2 == null || !str2.contains("ENOSPC")) {
            if (str2 != null && (str2.contains("ETIMEDOUT") || str2.contains("UnknownHostException"))) {
                downloadManager = this.f15288a.f15259c;
                downloadManager.f7053a = null;
                if (this.f15288a.f15277v != null) {
                    downloadManager2 = this.f15288a.f15259c;
                    if (downloadManager2.f7055c.booleanValue()) {
                        downloadManager3 = this.f15288a.f15259c;
                        downloadManager3.m9549c();
                    }
                }
            }
            z = false;
        }
        if (z) {
            this.f15288a.f15254C = 7;
        } else {
            this.f15288a.f15254C = 3;
        }
        if (this.f15288a.f15253B != null) {
            this.f15288a.f15253B.mo4930b(this.f15288a.f15256E, -1);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4521a(int i, int i2, String str, String str2) {
        super.mo4521a(i, i2, str, str2);
    }
}
