package com.cnlaunch.x431pro.module.p252d.p254b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.d.b.r */
/* loaded from: classes.dex */
public final class SerialNoForbitFlag implements Serializable {
    private String forbitFlag;
    private String serialNo;

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getForbitFlag() {
        return this.forbitFlag;
    }

    public final void setForbitFlag(String str) {
        this.forbitFlag = str;
    }

    public final boolean isUnForbidden() {
        return "1".equals(this.forbitFlag);
    }

    public final boolean isInBlackList() {
        return "1".equals(this.forbitFlag) || "2".equals(this.forbitFlag);
    }

    public final String toString() {
        return "SerialNoForbitFlag{serialNo='" + this.serialNo + "', forbitFlag='" + this.forbitFlag + "'}";
    }
}
