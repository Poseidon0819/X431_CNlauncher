package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* compiled from: CloudHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.k */
/* loaded from: classes.dex */
final class C1959k extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CloudHistoryFragment f10672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1959k(CloudHistoryFragment cloudHistoryFragment) {
        this.f10672a = cloudHistoryFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        if (intent != null && intent.getAction().equalsIgnoreCase("com.cnlaunch.cloudreport.action.result")) {
            boolean booleanExtra = intent.getBooleanExtra("upload_result", false);
            NLog.m9456a("XEE", "cloud upload 返回结果 ".concat(String.valueOf(booleanExtra)));
            if (!booleanExtra) {
                context2 = this.f10672a.mContext;
                NToast.m9450a(context2, (int) R.string.cloud_report_upload_failed);
                return;
            }
            new Thread(new RunnableC1960l(this)).start();
        }
    }
}
