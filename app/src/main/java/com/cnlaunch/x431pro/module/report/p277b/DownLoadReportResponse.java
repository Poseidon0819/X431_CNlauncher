package com.cnlaunch.x431pro.module.report.p277b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.report.b.b */
/* loaded from: classes.dex */
public class DownLoadReportResponse extends BaseResponse {
    private static final long serialVersionUID = 477062300730463L;
    private List<DownLoadReportInfo> data;

    public List<DownLoadReportInfo> getData() {
        return this.data;
    }

    public void setData(List<DownLoadReportInfo> list) {
        this.data = list;
    }
}
