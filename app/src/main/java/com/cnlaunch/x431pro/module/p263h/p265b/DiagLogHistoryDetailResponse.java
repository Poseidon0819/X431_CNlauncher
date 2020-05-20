package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.h.b.b */
/* loaded from: classes.dex */
public class DiagLogHistoryDetailResponse extends BaseResponse {
    private static final long serialVersionUID = 3795332412073562483L;
    private DiagLogHistoryDetailInfo diagLogDetailDTO;

    public DiagLogHistoryDetailInfo getDiagLogDetailDTO() {
        return this.diagLogDetailDTO;
    }

    public void setDiagLogDetailDTO(DiagLogHistoryDetailInfo diagLogHistoryDetailInfo) {
        this.diagLogDetailDTO = diagLogHistoryDetailInfo;
    }
}
