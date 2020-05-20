package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.os.Looper;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.p */
/* loaded from: classes.dex */
public final class HandlerC2680p extends DownLoadCallback {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2680p(DownloadLogic downloadLogic, Looper looper) {
        super(looper);
        this.f15346a = downloadLogic;
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4520a(String str, int i, int i2) {
        super.mo4520a(str, i, i2);
        Iterator it = this.f15346a.f15330w.iterator();
        while (it.hasNext()) {
            X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) it.next();
            if (str.equals(x431PadDtoSoft.getFileName())) {
                int round = (int) Math.round(Math.ceil((i / i2) * 100.0f));
                x431PadDtoSoft.setProgress(round);
                x431PadDtoSoft.setState(1);
                if (this.f15346a.f15310b != null) {
                    this.f15346a.f15310b.mo5614a(x431PadDtoSoft.getSoftPackageID(), round);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4519a(String str, String str2) {
        super.mo4519a(str, str2);
        NLog.m9456a("DownloadLogic", "download onSuccess, fileName:" + str + ", filePath:" + str2);
        Iterator it = this.f15346a.f15330w.iterator();
        while (it.hasNext()) {
            X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) it.next();
            if (str.equals(x431PadDtoSoft.getFileName())) {
                x431PadDtoSoft.setState(2);
                if (this.f15346a.f15310b != null) {
                    this.f15346a.f15310b.mo4930b(x431PadDtoSoft.getSoftPackageID(), 0);
                }
                try {
                    new Thread(new DownloadLogic.RunnableC2673b(str, str2, x431PadDtoSoft.getSoftPackageID())).start();
                    return;
                } catch (RejectedExecutionException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: b */
    public final void mo4518b(String str, String str2) {
        super.mo4518b(str, str2);
        boolean z = true;
        NLog.m9451c("DownloadLogic", "onFailure: " + str + ", strMsg: " + str2);
        String str3 = "";
        if (str2 == null || !str2.contains("ENOSPC")) {
            if (str2 != null && (str2.contains("ETIMEDOUT") || str2.contains("UnknownHostException"))) {
                this.f15346a.f15311c.f7053a = null;
                if (this.f15346a.f15313e != null && this.f15346a.f15311c.f7055c.booleanValue()) {
                    this.f15346a.f15311c.m9549c();
                    this.f15346a.f15332z.sendMessage(this.f15346a.f15332z.obtainMessage(12, 0, 0));
                    this.f15346a.f15330w.clear();
                    Iterator it = this.f15346a.f15330w.iterator();
                    while (it.hasNext()) {
                        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) it.next();
                        if (str.equals(x431PadDtoSoft.getFileName())) {
                            x431PadDtoSoft.setProgress(100);
                            x431PadDtoSoft.setState(3);
                            return;
                        }
                    }
                    return;
                }
            }
            z = false;
        }
        Iterator it2 = this.f15346a.f15330w.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) it2.next();
            if (str.equals(x431PadDtoSoft2.getFileName())) {
                x431PadDtoSoft2.setProgress(100);
                str3 = x431PadDtoSoft2.getSoftPackageID();
                if (z) {
                    x431PadDtoSoft2.setState(7);
                } else {
                    x431PadDtoSoft2.setState(3);
                }
                this.f15346a.m5601b(x431PadDtoSoft2.getSoftPackageID());
            }
        }
        if (str2 != null && str2.equals("Token is invalid!") && this.f15346a.f15311c.f7055c.booleanValue()) {
            this.f15346a.f15311c.f7053a = null;
            this.f15346a.f15311c.m9549c();
            this.f15346a.f15332z.sendMessage(this.f15346a.f15332z.obtainMessage(9, 0, 0));
            this.f15346a.f15332z.sendMessage(this.f15346a.f15332z.obtainMessage(5, 0, 0));
        } else if (!z) {
            if (this.f15346a.f15310b != null) {
                this.f15346a.f15310b.mo4930b(str3, -1);
            }
        } else {
            this.f15346a.f15311c.f7053a = null;
            this.f15346a.f15311c.m9549c();
            this.f15346a.f15332z.sendMessage(this.f15346a.f15332z.obtainMessage(9, 0, 0));
            this.f15346a.f15332z.sendMessage(this.f15346a.f15332z.obtainMessage(11, 0, 0));
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4521a(int i, int i2, String str, String str2) {
        super.mo4521a(i, i2, str, str2);
    }
}
