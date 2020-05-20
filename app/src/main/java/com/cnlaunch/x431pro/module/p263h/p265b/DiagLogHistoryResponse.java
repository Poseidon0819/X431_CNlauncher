package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.h.b.d */
/* loaded from: classes.dex */
public class DiagLogHistoryResponse extends BaseResponse {
    private static final long serialVersionUID = 1797434073924686611L;
    private List<DiagLogHistoryInfo> diagLogBasicDTOList;

    public List<DiagLogHistoryInfo> getDiagLogBasicDTOList() {
        return this.diagLogBasicDTOList;
    }

    public void setDiagLogBasicDTOList(List<DiagLogHistoryInfo> list) {
        this.diagLogBasicDTOList = list;
    }
}
