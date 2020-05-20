package com.cnlaunch.x431pro.module.p269j.p271b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.j.b.i */
/* loaded from: classes.dex */
public class LatestPublicSoftsResponse extends BaseResponse {
    private static final long serialVersionUID = 238013042459863126L;
    private List<X431PadDtoSoft> x431PadSoftList;

    public List<X431PadDtoSoft> getX431PadSoftList() {
        return this.x431PadSoftList;
    }

    public void setX431PadSoftList(List<X431PadDtoSoft> list) {
        this.x431PadSoftList = list;
    }
}
