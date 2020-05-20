package com.cnlaunch.x431pro.module.cloud.model;

import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.k */
/* loaded from: classes.dex */
public class CloudReportListResponse extends CloudBaseResponse {
    private List<CloudReportListInfo> data;

    public List<CloudReportListInfo> getData() {
        return this.data;
    }

    public void setData(List<CloudReportListInfo> list) {
        this.data = list;
    }
}
