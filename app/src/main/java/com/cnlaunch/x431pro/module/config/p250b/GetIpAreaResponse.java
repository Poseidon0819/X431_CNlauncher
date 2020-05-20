package com.cnlaunch.x431pro.module.config.p250b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.config.b.d */
/* loaded from: classes.dex */
public class GetIpAreaResponse extends BaseResponse {
    private static final long serialVersionUID = 1661977668398668824L;
    private IpAreaData data;

    public IpAreaData getData() {
        return this.data;
    }

    public void setData(IpAreaData ipAreaData) {
        this.data = ipAreaData;
    }
}
