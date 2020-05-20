package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.j */
/* loaded from: classes.dex */
public final class CyOrderResult extends CyResultBase {
    private String launchOrderNo;
    private String orderCreateTime;
    private String serialNo;

    public final String getLaunchOrderNo() {
        return this.launchOrderNo;
    }

    public final void setLaunchOrderNo(String str) {
        this.launchOrderNo = str;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getOrderCreateTime() {
        return this.orderCreateTime;
    }

    public final void setOrderCreateTime(String str) {
        this.orderCreateTime = str;
    }

    public final String toString() {
        return "CyOrderResult{launchOrderNo='" + this.launchOrderNo + "', serialNo='" + this.serialNo + "', orderCreateTime='" + this.orderCreateTime + "'}";
    }
}
