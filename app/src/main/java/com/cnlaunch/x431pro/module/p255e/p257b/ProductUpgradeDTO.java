package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.utils.CardUtil;
import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.e.b.d */
/* loaded from: classes.dex */
public final class ProductUpgradeDTO implements Serializable {
    private static final long serialVersionUID = -3913090890107357819L;
    private String freeEndTime;
    private int needRenew;
    private String oldFreeEndTime;
    private String serialNo;
    private String updateDate;

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getUpdateDate() {
        return this.updateDate;
    }

    public final void setUpdateDate(String str) {
        this.updateDate = str;
    }

    public final String getOldFreeEndTime() {
        return this.oldFreeEndTime;
    }

    public final void setOldFreeEndTime(String str) {
        this.oldFreeEndTime = str;
    }

    public final String getFreeEndTime() {
        return CardUtil.m4921a(this.freeEndTime);
    }

    public final void setFreeEndTime(String str) {
        this.freeEndTime = str;
    }

    public final int getNeedRenew() {
        return this.needRenew;
    }

    public final void setNeedRenew(int i) {
        this.needRenew = i;
    }
}
