package com.cnlaunch.x431pro.module.report;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.module.report.p276a.ReportAction;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportResponse;
import com.cnlaunch.x431pro.module.report.p278db.ReportDBUtils;
import com.cnlaunch.x431pro.module.report.p278db.UpLoadReportInfoDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.report.c */
/* loaded from: classes.dex */
public final class UpLoadSaveReportTask implements Runnable {

    /* renamed from: a */
    private Context f15664a;

    /* renamed from: b */
    private ReportAction f15665b;

    /* renamed from: c */
    private ReportDBUtils f15666c;

    public UpLoadSaveReportTask(Context context) {
        this.f15664a = context;
        this.f15665b = new ReportAction(this.f15664a);
        this.f15666c = new ReportDBUtils(this.f15664a.getApplicationContext());
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(PreferencesManager.m9595a(this.f15664a).m9591a("user_id"))) {
                return;
            }
            String m9591a = PreferencesManager.m9595a(this.f15664a).m9591a("serialNo");
            if (TextUtils.isEmpty(m9591a)) {
                return;
            }
            QueryBuilder<UpLoadReportInfo> queryBuilder = this.f15666c.f15668a.queryBuilder();
            queryBuilder.where(UpLoadReportInfoDao.Properties.Report_key.m321eq(m9591a), new WhereCondition[0]);
            List<UpLoadReportInfo> list = queryBuilder.list();
            if (list != null && list.size() > 0) {
                UpLoadReportResponse upLoadReportResponse = null;
                for (UpLoadReportInfo upLoadReportInfo : list) {
                    try {
                        upLoadReportResponse = this.f15665b.m5221a(upLoadReportInfo);
                    } catch (C1425f unused) {
                    }
                    if (upLoadReportResponse != null && upLoadReportResponse.getCode() == 0) {
                        this.f15666c.f15668a.delete(upLoadReportInfo);
                    }
                }
                this.f15666c.m5217a();
                list.clear();
                return;
            }
            Log.e("Sanda", "无需上传");
            this.f15666c.m5217a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
