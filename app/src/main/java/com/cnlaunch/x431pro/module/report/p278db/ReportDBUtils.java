package com.cnlaunch.x431pro.module.report.p278db;

import android.content.Context;
import android.util.Log;
import com.cnlaunch.x431pro.module.report.p278db.ReportDaoMaster;

/* renamed from: com.cnlaunch.x431pro.module.report.db.a */
/* loaded from: classes.dex */
public final class ReportDBUtils {

    /* renamed from: a */
    public UpLoadReportInfoDao f15668a;

    /* renamed from: b */
    private ReportDaoSession f15669b;

    /* renamed from: c */
    private ReportDaoMaster f15670c;

    /* renamed from: d */
    private ReportDaoMaster.AbstractC2736b f15671d;

    public ReportDBUtils(Context context) {
        this.f15671d = new ReportDaoMaster.C2735a(context, "diag_report");
        this.f15670c = new ReportDaoMaster(this.f15671d.getWritableDatabase());
        this.f15669b = this.f15670c.newSession();
        this.f15668a = this.f15669b.f15672a;
    }

    /* renamed from: a */
    public final void m5217a() {
        try {
            this.f15671d.close();
            this.f15669b = null;
            this.f15670c = null;
        } catch (Exception e) {
            Log.e("Sanda", "ReportDBUtils close:" + e.toString());
            e.printStackTrace();
        }
    }
}
