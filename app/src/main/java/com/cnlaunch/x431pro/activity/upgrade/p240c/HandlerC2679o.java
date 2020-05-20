package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p120d.p130d.NLog;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.o */
/* loaded from: classes.dex */
final class HandlerC2679o extends Handler {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2679o(DownloadLogic downloadLogic, Looper looper) {
        super(looper);
        this.f15345a = downloadLogic;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        switch (message2.what) {
            case 2:
                return;
            case 3:
                NLog.m9456a("DownloadLogic", "MSG_DOWNLOAD_FINISHED");
                DownloadLogic downloadLogic = this.f15345a;
                downloadLogic.f15309a = null;
                if (downloadLogic.f15311c != null) {
                    downloadLogic.f15311c.f7053a = null;
                    downloadLogic.f15311c.m9549c();
                    downloadLogic.f15311c = null;
                }
                if (downloadLogic.f15312d != null) {
                    downloadLogic.f15312d.shutdownNow();
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
                DownloadLogic.m5596g(this.f15345a);
                DownloadLogic.m5595h(this.f15345a);
                return;
            case 7:
                return;
            case 9:
                this.f15345a.f15311c.f7053a = null;
                this.f15345a.f15311c.m9549c();
                threadPoolExecutor = this.f15345a.f15312d;
                threadPoolExecutor.shutdownNow();
                return;
            case 11:
                return;
            case 12:
                this.f15345a.f15311c.f7053a = null;
                this.f15345a.f15311c.m9549c();
                threadPoolExecutor2 = this.f15345a.f15312d;
                threadPoolExecutor2.shutdownNow();
                return;
        }
    }
}
