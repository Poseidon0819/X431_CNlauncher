package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.j */
/* loaded from: classes.dex */
public class GoloAppraiseResponse extends BaseResponse {
    private static final long serialVersionUID = 7838498911545227933L;
    private List<GoloAppraiseInfo> data;

    public List<GoloAppraiseInfo> getData() {
        return this.data;
    }

    public void setData(List<GoloAppraiseInfo> list) {
        this.data = list;
    }
}
