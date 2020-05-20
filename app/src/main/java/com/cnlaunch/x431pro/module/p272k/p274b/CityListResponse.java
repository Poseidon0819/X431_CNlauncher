package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.k.b.b */
/* loaded from: classes.dex */
public class CityListResponse extends BaseResponse {
    private static final long serialVersionUID = 1866613780308912119L;
    private List<City> data;

    public List<City> getData() {
        return this.data;
    }

    public void setData(List<City> list) {
        this.data = list;
    }
}
