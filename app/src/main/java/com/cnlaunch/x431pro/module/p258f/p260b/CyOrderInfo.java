package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.f.b.d */
/* loaded from: classes.dex */
public final class CyOrderInfo extends AbstractC2709c {
    private String cyOrderNo;
    private String endTime;
    private String launchOrderNo;
    private String orderCreateTime;
    private String orderPayTime;
    private int orderPayType;
    private double orderPrice;
    private int orderState;
    private String orderTypeName;
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

    public final int getOrderState() {
        return this.orderState;
    }

    public final void setOrderState(int i) {
        this.orderState = i;
    }

    public final String getOrderTypeName() {
        return this.orderTypeName;
    }

    public final void setOrderTypeName(String str) {
        this.orderTypeName = str;
    }

    public final double getOrderPrice() {
        return this.orderPrice;
    }

    public final void setOrderPrice(double d) {
        this.orderPrice = d;
    }

    public final String getCyOrderNo() {
        return this.cyOrderNo;
    }

    public final void setCyOrderNo(String str) {
        this.cyOrderNo = str;
    }

    public final String getOrderCreateTime() {
        return this.orderCreateTime;
    }

    public final void setOrderCreateTime(String str) {
        this.orderCreateTime = str;
    }

    public final String getOrderPayTime() {
        return this.orderPayTime;
    }

    public final void setOrderPayTime(String str) {
        this.orderPayTime = str;
    }

    public final int getOrderPayType() {
        return this.orderPayType;
    }

    public final void setOrderPayType(int i) {
        this.orderPayType = i;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final String toString() {
        return "CyOrderInfo{launchOrderNo='" + this.launchOrderNo + "', serialNo='" + this.serialNo + "', orderState=" + this.orderState + ", orderTypeName='" + this.orderTypeName + "', orderPrice=" + this.orderPrice + '}';
    }
}
