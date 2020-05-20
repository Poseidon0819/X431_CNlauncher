package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.f.b.k */
/* loaded from: classes.dex */
public final class CyOrderType extends AbstractC2709c {
    private int orderTypeId;
    private String orderTypeName;
    private Double orderTypePrice;
    private String remark;

    public final int getOrderTypeId() {
        return this.orderTypeId;
    }

    public final void setOrderTypeId(int i) {
        this.orderTypeId = i;
    }

    public final String getOrderTypeName() {
        return this.orderTypeName;
    }

    public final void setOrderTypeName(String str) {
        this.orderTypeName = str;
    }

    public final Double getOrderTypePrice() {
        return this.orderTypePrice;
    }

    public final void setOrderTypePrice(Double d) {
        this.orderTypePrice = d;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final String toString() {
        return "CyOrderType{orderTypeId=" + this.orderTypeId + ", orderTypeName='" + this.orderTypeName + "', orderTypePrice=" + this.orderTypePrice + ", remark='" + this.remark + "'}";
    }
}
