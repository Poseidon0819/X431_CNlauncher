package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.cloud.model.CloudReportListInfo;
import com.ifoer.expedition.pro.R;

/* compiled from: CloudHistoryAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC1956g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CloudReportListInfo f10642a;

    /* renamed from: b */
    final /* synthetic */ CloudHistoryAdapter f10643b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1956g(CloudHistoryAdapter cloudHistoryAdapter, CloudReportListInfo cloudReportListInfo) {
        this.f10643b = cloudHistoryAdapter;
        this.f10642a = cloudReportListInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CloudHistoryFragment cloudHistoryFragment;
        CloudHistoryFragment cloudHistoryFragment2;
        cloudHistoryFragment = this.f10643b.f10621a;
        if (cloudHistoryFragment != null) {
            cloudHistoryFragment2 = this.f10643b.f10621a;
            CloudReportListInfo cloudReportListInfo = this.f10642a;
            if (!"X".equalsIgnoreCase(cloudReportListInfo.getReport_type()) && "0".equalsIgnoreCase(cloudReportListInfo.getIs_pay())) {
                NToast.m9447b(cloudHistoryFragment2.mContext, (int) R.string.cloud_get_history_detail_for_quick_test_tip);
                return;
            }
            cloudHistoryFragment2.f10649c = cloudReportListInfo.getReport_type();
            cloudHistoryFragment2.f10648b = cloudReportListInfo.getDiagnose_record_id();
            cloudHistoryFragment2.request(773, true);
        }
    }
}
