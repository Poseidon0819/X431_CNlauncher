package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p130d.NLog;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.e */
/* loaded from: classes.dex */
final class HandlerC2668e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2668e(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, Looper looper) {
        super(looper);
        this.f15289a = apkUpgradeAndDownloadLogic;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        DownloadManager downloadManager;
        DownloadManager downloadManager2;
        ThreadPoolExecutor threadPoolExecutor;
        DownloadManager downloadManager3;
        DownloadManager downloadManager4;
        ThreadPoolExecutor threadPoolExecutor2;
        switch (message2.what) {
            case 2:
                return;
            case 3:
                NLog.m9456a("yhx", "MSG_DOWNLOAD_FINISHED");
                ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic = this.f15289a;
                if (apkUpgradeAndDownloadLogic.f15259c != null) {
                    apkUpgradeAndDownloadLogic.f15259c.f7054b = null;
                    apkUpgradeAndDownloadLogic.f15259c.m9549c();
                    apkUpgradeAndDownloadLogic.f15259c = null;
                }
                if (apkUpgradeAndDownloadLogic.f15260d != null) {
                    apkUpgradeAndDownloadLogic.f15260d.shutdownNow();
                    return;
                }
                return;
            case 4:
            case 8:
            case 10:
            default:
                return;
            case 5:
                return;
            case 6:
                return;
            case 7:
                return;
            case 9:
                downloadManager = this.f15289a.f15259c;
                downloadManager.f7054b = null;
                downloadManager2 = this.f15289a.f15259c;
                downloadManager2.m9549c();
                threadPoolExecutor = this.f15289a.f15260d;
                threadPoolExecutor.shutdownNow();
                return;
            case 11:
                return;
            case 12:
                downloadManager3 = this.f15289a.f15259c;
                downloadManager3.f7054b = null;
                downloadManager4 = this.f15289a.f15259c;
                downloadManager4.m9549c();
                threadPoolExecutor2 = this.f15289a.f15260d;
                threadPoolExecutor2.shutdownNow();
                return;
        }
    }
}
