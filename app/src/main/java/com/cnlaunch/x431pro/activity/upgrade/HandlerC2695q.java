package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.DownloadFragment;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadLog;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.q */
/* loaded from: classes.dex */
public final class HandlerC2695q extends DownLoadCallback {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2695q(DownloadFragment downloadFragment) {
        this.f15422a = downloadFragment;
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4520a(String str, int i, int i2) {
        DownloadAdapter downloadAdapter;
        super.mo4520a(str, i, i2);
        Iterator it = this.f15422a.f15352D.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadSoftDto downloadSoftDto = (DownloadSoftDto) it.next();
            if (str.equals(downloadSoftDto.f15580f)) {
                downloadSoftDto.f15578d = (int) Math.round(Math.ceil((i / i2) * 100.0f));
                downloadSoftDto.f15579e = 1;
                break;
            }
        }
        downloadAdapter = this.f15422a.f15402w;
        downloadAdapter.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4519a(String str, String str2) {
        DownloadAdapter downloadAdapter;
        ThreadPoolExecutor threadPoolExecutor;
        Map map;
        Map map2;
        Map map3;
        super.mo4519a(str, str2);
        for (DownloadSoftDto downloadSoftDto : this.f15422a.f15352D) {
            if (str.equals(downloadSoftDto.f15580f)) {
                downloadSoftDto.f15579e = 2;
                downloadAdapter = this.f15422a.f15402w;
                downloadAdapter.notifyDataSetChanged();
                try {
                    if (1 != downloadSoftDto.f15577c || ((!C2744aa.m5121t() && !this.f15422a.f15365Q) || !C2778n.m4899c(this.f15422a.f15363O, str2))) {
                        threadPoolExecutor = this.f15422a.f15362N;
                        threadPoolExecutor.submit(new DownloadFragment.RunnableC2684b(str, str2, downloadSoftDto.f15584j));
                        return;
                    }
                    String str3 = this.f15422a.f15386g;
                    NLog.m9456a(str3, "isMyselfAPK, fileName: " + str + ", softPackageID: " + downloadSoftDto.f15584j);
                    map = this.f15422a.f15378ac;
                    map.put("fileName", str);
                    map2 = this.f15422a.f15378ac;
                    map2.put("filePath", str2);
                    map3 = this.f15422a.f15378ac;
                    map3.put("softPackageID", downloadSoftDto.f15584j);
                    downloadSoftDto.f15579e = 9;
                    this.f15422a.m5487e();
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
        Context context;
        DownloadAdapter downloadAdapter;
        DownloadAdapter downloadAdapter2;
        Context context2;
        Context context3;
        super.mo4518b(str, str2);
        String str3 = this.f15422a.f15386g;
        boolean z = true;
        NLog.m9451c(str3, "onFailure: " + str + ", strMsg: " + str2);
        if (str2 == null || !str2.contains("ENOSPC")) {
            if (str2 != null && (str2.contains("ETIMEDOUT") || str2.contains("UnknownHostException"))) {
                this.f15422a.f15401v.f7053a = null;
                context = this.f15422a.mContext;
                if (context != null && this.f15422a.f15401v.f7055c.booleanValue()) {
                    this.f15422a.f15401v.m9549c();
                    this.f15422a.f15403x.sendMessage(this.f15422a.f15403x.obtainMessage(12, 0, 0));
                    for (DownloadSoftDto downloadSoftDto : this.f15422a.f15352D) {
                        if (str.equals(downloadSoftDto.f15580f)) {
                            downloadSoftDto.f15578d = 100;
                            downloadSoftDto.f15579e = 3;
                            downloadAdapter = this.f15422a.f15402w;
                            downloadAdapter.notifyDataSetChanged();
                            return;
                        }
                    }
                    return;
                }
            }
            z = false;
        }
        Iterator it = this.f15422a.f15352D.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadSoftDto downloadSoftDto2 = (DownloadSoftDto) it.next();
            if (str.equals(downloadSoftDto2.f15580f)) {
                downloadSoftDto2.f15578d = 100;
                if (z) {
                    downloadSoftDto2.f15579e = 7;
                } else {
                    downloadSoftDto2.f15579e = 3;
                }
            }
        }
        downloadAdapter2 = this.f15422a.f15402w;
        downloadAdapter2.notifyDataSetChanged();
        if (str2 != null && str2.equals("Token is invalid!") && this.f15422a.f15401v.f7055c.booleanValue()) {
            this.f15422a.f15401v.f7053a = null;
            this.f15422a.f15401v.m9549c();
            this.f15422a.f15403x.sendMessage(this.f15422a.f15403x.obtainMessage(7, 0, 0));
            this.f15422a.f15403x.sendMessage(this.f15422a.f15403x.obtainMessage(4, 0, 0));
            context3 = this.f15422a.mContext;
            if (PreferencesManager.m9595a(context3).m9583b("enable_upload_downloadlog", false)) {
                this.f15422a.m5475k();
            }
        } else if (!z) {
            this.f15422a.m5485f();
        } else {
            this.f15422a.f15401v.f7053a = null;
            this.f15422a.f15403x.sendMessage(this.f15422a.f15403x.obtainMessage(7, 0, 0));
            this.f15422a.f15403x.sendMessage(this.f15422a.f15403x.obtainMessage(11, 0, 0));
            context2 = this.f15422a.mContext;
            if (PreferencesManager.m9595a(context2).m9583b("enable_upload_downloadlog", false)) {
                this.f15422a.m5475k();
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p127b.DownLoadCallback
    /* renamed from: a */
    public final void mo4521a(int i, int i2, String str, String str2) {
        Context context;
        super.mo4521a(i, i2, str, str2);
        context = this.f15422a.mContext;
        if (PreferencesManager.m9595a(context).m9583b("enable_upload_downloadlog", false)) {
            for (DownloadSoftDto downloadSoftDto : this.f15422a.f15352D) {
                if (str2.equals(downloadSoftDto.f15580f)) {
                    if (str != null) {
                        downloadSoftDto.f15581g = str;
                        DownloadLog m5557a = this.f15422a.m5557a(i, i2, str, DownloadFragment.m5558a(downloadSoftDto.f15579e.intValue()));
                        QueryBuilder<UpdateDownloadLog> queryBuilder = this.f15422a.f15372X.queryBuilder();
                        queryBuilder.where(UpdateDownloadLogDao.Properties.DownloadId.m321eq(String.valueOf(str)), new WhereCondition[0]);
                        List<UpdateDownloadLog> list = queryBuilder.list();
                        UpdateDownloadLog m5549a = DownloadFragment.m5549a(m5557a);
                        m5549a.f15845h = str2;
                        if (list.size() <= 0) {
                            this.f15422a.f15372X.insert(m5549a);
                            return;
                        }
                        m5549a.f15838a = Long.valueOf(list.get(0).f15838a.longValue());
                        this.f15422a.f15372X.update(m5549a);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
