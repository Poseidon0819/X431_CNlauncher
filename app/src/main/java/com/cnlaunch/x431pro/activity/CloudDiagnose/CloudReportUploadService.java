package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* loaded from: classes.dex */
public class CloudReportUploadService extends Service {

    /* renamed from: a */
    private List<CloudData> f10606a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getAction().equalsIgnoreCase("com.cnlaunch.cloudreport.action.upload")) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.f10606a = extras.getParcelableArrayList("CloudData");
                if (!CommonTools.m7966b(this)) {
                    NLog.m9452b("XEE", "没有网络，开始保存诊断报告");
                    if (FileUtils.m5027a() > 5) {
                        FixedThreadPool.m4928a().m4927a(new CloudReportSaveTask(this.f10606a));
                    } else {
                        NToast.m9450a(this, (int) R.string.sd_no_storage_space);
                    }
                } else if (this.f10606a != null) {
                    new CloudDataUploadPrsenter(this).m7932a(this.f10606a, new C1965r(this));
                } else {
                    Log.e("XEE", "mListCloudData == null");
                }
            } else {
                Log.e("XEE", "bundle == null");
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7935a(CloudReportUploadService cloudReportUploadService, boolean z) {
        Intent intent = new Intent("com.cnlaunch.cloudreport.action.result");
        intent.putExtra("upload_result", z);
        cloudReportUploadService.sendBroadcast(intent);
    }
}
