package com.cnlaunch.x431pro.widget.p290a;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog;
import com.ifoer.expedition.pro.R;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.v */
/* loaded from: classes.dex */
public final class HandlerC2880v extends DownLoadCallback {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDownloadDialog f16466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2880v(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        this.f16466a = divisionSoftDownloadDialog;
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4520a(String str, int i, int i2) {
        DownloadAdapter downloadAdapter;
        super.mo4520a(str, i, i2);
        for (DownloadSoftDto downloadSoftDto : this.f16466a.f16414D) {
            if (str.equals(downloadSoftDto.f15580f)) {
                downloadSoftDto.f15578d = (int) Math.round(Math.ceil((i / i2) * 100.0f));
                downloadSoftDto.f15579e = 1;
                downloadAdapter = this.f16466a.f16447z;
                downloadAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4519a(String str, String str2) {
        DownloadAdapter downloadAdapter;
        DownloadAdapter downloadAdapter2;
        ThreadPoolExecutor threadPoolExecutor;
        super.mo4519a(str, str2);
        for (DownloadSoftDto downloadSoftDto : this.f16466a.f16414D) {
            if (str.equals(downloadSoftDto.f15580f)) {
                downloadSoftDto.f15579e = 2;
                downloadAdapter = this.f16466a.f16447z;
                downloadAdapter.f15005a = this.f16466a.f16414D;
                downloadAdapter2 = this.f16466a.f16447z;
                downloadAdapter2.notifyDataSetChanged();
                try {
                    threadPoolExecutor = this.f16466a.f16413C;
                    threadPoolExecutor.submit(new DivisionSoftDownloadDialog.RunnableC2867b(str, str2, downloadSoftDto.f15584j));
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
        DownloadAdapter downloadAdapter;
        super.mo4518b(str, str2);
        boolean z = true;
        NLog.m9451c("yhx", "onFailure: " + str + ", strMsg: " + str2);
        if (str2 == null || !str2.contains("ENOSPC")) {
            if (str2 == null || (!str2.contains("ETIMEDOUT") && !str2.contains("UnknownHostException"))) {
                if (str2 == null || !str2.equals("Token is invalid!") || !this.f16466a.f16412B.f7055c.booleanValue()) {
                    if (str2 != null && str2.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
                        this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(15, R.string.divisiondownload_failure_900, 0));
                    } else if (str2 != null && str2.equals("901")) {
                        this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(15, R.string.divisiondownload_failure_901, 0));
                    } else if (str2 == null || !str2.equals("902")) {
                        this.f16466a.m4543l();
                    } else {
                        this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(15, R.string.divisiondownload_failure_902, 0));
                    }
                } else {
                    this.f16466a.f16412B.f7053a = null;
                    this.f16466a.f16412B.m9549c();
                    this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(7, 0, 0));
                    this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(4, 0, 0));
                }
            } else {
                this.f16466a.f16412B.f7053a = null;
                if (this.f16466a.f16441t != null && this.f16466a.f16412B.f7055c.booleanValue()) {
                    this.f16466a.f16412B.m9549c();
                    this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(12, 0, 0));
                }
            }
            z = false;
        } else {
            this.f16466a.f16412B.f7053a = null;
            this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(7, 0, 0));
            this.f16466a.f16419I.sendMessage(this.f16466a.f16419I.obtainMessage(11, 0, 0));
        }
        for (DownloadSoftDto downloadSoftDto : this.f16466a.f16414D) {
            if (str.equals(downloadSoftDto.f15580f)) {
                downloadSoftDto.f15578d = 100;
                if (z) {
                    downloadSoftDto.f15579e = 7;
                } else {
                    downloadSoftDto.f15579e = 3;
                }
                downloadAdapter = this.f16466a.f16447z;
                downloadAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4521a(int i, int i2, String str, String str2) {
        super.mo4521a(i, i2, str, str2);
    }
}
