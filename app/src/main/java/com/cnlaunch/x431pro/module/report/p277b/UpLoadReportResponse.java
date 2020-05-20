package com.cnlaunch.x431pro.module.report.p277b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.report.b.e */
/* loaded from: classes.dex */
public class UpLoadReportResponse extends BaseResponse {
    private static final long serialVersionUID = 7221454381256065137L;
    private ReportBackInfo data;

    public ReportBackInfo getData() {
        return this.data;
    }

    public void setData(ReportBackInfo reportBackInfo) {
        this.data = reportBackInfo;
    }
}
