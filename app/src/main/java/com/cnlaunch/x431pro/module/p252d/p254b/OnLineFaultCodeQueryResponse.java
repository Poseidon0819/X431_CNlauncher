package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b.j */
/* loaded from: classes.dex */
public class OnLineFaultCodeQueryResponse extends BaseResponse {
    String dtcCode = "";
    String dtcDesc = "";
    String dtcStatus = "";
    String dtcSmallDesc = "";

    public String getDtcCode() {
        return this.dtcCode;
    }

    public void setDtcCode(String str) {
        this.dtcCode = str;
    }

    public String getDtcDesc() {
        return this.dtcDesc;
    }

    public void setDtcDesc(String str) {
        this.dtcDesc = str;
    }

    public String getDtcStatus() {
        return this.dtcStatus;
    }

    public void setDtcStatus(String str) {
        this.dtcStatus = str;
    }

    public String getDtcSmallDesc() {
        return this.dtcSmallDesc;
    }

    public void setDtcSmallDesc(String str) {
        this.dtcSmallDesc = str;
    }
}
