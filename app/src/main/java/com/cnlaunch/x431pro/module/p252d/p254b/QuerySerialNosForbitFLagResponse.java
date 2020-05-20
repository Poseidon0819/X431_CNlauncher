package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.d.b.m */
/* loaded from: classes.dex */
public class QuerySerialNosForbitFLagResponse extends BaseResponse {
    private static final long serialVersionUID = -5394747854907447074L;
    private List<SerialNoForbitFlag> sysPdtForbitBlackList;

    public List<SerialNoForbitFlag> getSysPdtForbitBlackList() {
        return this.sysPdtForbitBlackList;
    }

    public void setSysPdtForbitBlackList(List<SerialNoForbitFlag> list) {
        this.sysPdtForbitBlackList = list;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "QuerySerialNosForbitFLagResponse{sysPdtForbitBlackList=" + this.sysPdtForbitBlackList + '}';
    }
}
