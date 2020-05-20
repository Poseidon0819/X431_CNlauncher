package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.k.b.d */
/* loaded from: classes.dex */
public class CountryListResponse extends BaseResponse {
    private static final long serialVersionUID = -2469996449336636625L;
    private List<Country> data;

    public List<Country> getData() {
        return this.data;
    }

    public void setData(List<Country> list) {
        this.data = list;
    }
}
