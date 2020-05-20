package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.module.d.b.k */
/* loaded from: classes.dex */
public class OnLineFaultCodesWithSysQueryResponse extends BaseResponse {
    private ArrayList<OnLineFaultCodeQueryResponse> dtcs;

    public void setDtcs(ArrayList<OnLineFaultCodeQueryResponse> arrayList) {
        this.dtcs = arrayList;
    }

    public ArrayList<OnLineFaultCodeQueryResponse> getDtcs() {
        return this.dtcs;
    }
}
