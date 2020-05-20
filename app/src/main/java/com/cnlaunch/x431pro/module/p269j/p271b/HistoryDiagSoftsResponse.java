package com.cnlaunch.x431pro.module.p269j.p271b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.j.b.e */
/* loaded from: classes.dex */
public class HistoryDiagSoftsResponse extends BaseResponse {
    private static final long serialVersionUID = -428283825531817592L;
    private List<X431PadDtoSoft> x431PadSoftList;

    public List<X431PadDtoSoft> getX431PadSoftList() {
        return this.x431PadSoftList;
    }

    public void setX431PadSoftList(List<X431PadDtoSoft> list) {
        this.x431PadSoftList = list;
    }
}
