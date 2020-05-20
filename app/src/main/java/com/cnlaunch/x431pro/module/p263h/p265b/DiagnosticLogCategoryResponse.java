package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.h.b.h */
/* loaded from: classes.dex */
public class DiagnosticLogCategoryResponse extends BaseResponse {
    List<DiagnosticLogCategoryInfo> diagLogCategoryDTOList;

    public List<DiagnosticLogCategoryInfo> getDiagLogCategoryDTOList() {
        return this.diagLogCategoryDTOList;
    }

    public void setDiagLogCategoryDTOList(List<DiagnosticLogCategoryInfo> list) {
        this.diagLogCategoryDTOList = list;
    }
}
