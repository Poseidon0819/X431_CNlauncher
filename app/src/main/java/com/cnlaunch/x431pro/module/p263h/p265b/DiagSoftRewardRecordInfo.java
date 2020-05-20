package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.h.b.e */
/* loaded from: classes.dex */
public final class DiagSoftRewardRecordInfo extends AbstractC2709c {
    private static final long serialVersionUID = -683115658909608465L;
    String activityDesc;
    String joinDate;
    Integer month;
    String rewardId;
    String serialNo;

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final Integer getMonth() {
        return this.month;
    }

    public final void setMonth(Integer num) {
        this.month = num;
    }

    public final String getActivityDesc() {
        return this.activityDesc;
    }

    public final void setActivityDesc(String str) {
        this.activityDesc = str;
    }

    public final String getJoinDate() {
        return this.joinDate;
    }

    public final void setJoinDate(String str) {
        this.joinDate = str;
    }

    public final String getRewardId() {
        return this.rewardId;
    }

    public final void setRewardId(String str) {
        this.rewardId = str;
    }

    public final String toString() {
        return "DiagSoftRewardRecordInfo{month=" + this.month + ", serialNo='" + this.serialNo + "', rewardId='" + this.rewardId + "', activityDesc='" + this.activityDesc + "', joinDate='" + this.joinDate + "'}";
    }
}
