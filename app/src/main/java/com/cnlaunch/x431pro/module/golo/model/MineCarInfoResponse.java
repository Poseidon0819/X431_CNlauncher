package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.n */
/* loaded from: classes.dex */
public class MineCarInfoResponse extends BaseResponse {
    private static final long serialVersionUID = 2298299680229829394L;
    private List<MineCarInfoData> data;

    public List<MineCarInfoData> getData() {
        return this.data;
    }

    public void setData(List<MineCarInfoData> list) {
        this.data = list;
    }
}
