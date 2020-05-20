package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.k.b.k */
/* loaded from: classes.dex */
public class ProvinceListResponse extends BaseResponse {
    private static final long serialVersionUID = 1784773097294448681L;
    private List<Province> data;

    public List<Province> getData() {
        return this.data;
    }

    public void setData(List<Province> list) {
        this.data = list;
    }
}
