package com.cnlaunch.x431pro.module.p269j.p271b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.j.b.h */
/* loaded from: classes.dex */
public class LatestDivisionSoftsResponse extends BaseResponse {
    private static final long serialVersionUID = -5394747854907447074L;
    private List<DivisionSoftDto> diagSoftSubPackList;

    public List<DivisionSoftDto> getDiagSoftSubPackList() {
        return this.diagSoftSubPackList;
    }

    public void setDiagSoftSubPackList(List<DivisionSoftDto> list) {
        this.diagSoftSubPackList = list;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "LatestDivisionSoftsResponse{diagSoftSubPackList=" + this.diagSoftSubPackList + '}';
    }
}
