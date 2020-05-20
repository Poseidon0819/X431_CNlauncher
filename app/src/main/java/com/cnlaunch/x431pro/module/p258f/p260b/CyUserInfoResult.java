package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.p */
/* loaded from: classes.dex */
public final class CyUserInfoResult extends CyResultBase {
    private String beginTime;
    private String endTime;
    private String password;
    private String token;
    private String tokenExpiryTime;
    private Integer userType;
    private String validSerialNo;

    public final String getValidSerialNo() {
        return this.validSerialNo;
    }

    public final void setValidSerialNo(String str) {
        this.validSerialNo = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final Integer getUserType() {
        return this.userType;
    }

    public final void setUserType(Integer num) {
        this.userType = num;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final String getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(String str) {
        this.beginTime = str;
    }

    public final String getTokenExpiryTime() {
        return this.tokenExpiryTime;
    }

    public final void setTokenExpiryTime(String str) {
        this.tokenExpiryTime = str;
    }

    public final String toString() {
        return "CyUserInfoResult{userType=" + this.userType + ", token='" + this.token + "', beginTime='" + this.beginTime + "', endTime='" + this.endTime + "', tokenExpiryTime='" + this.tokenExpiryTime + "', password='" + this.password + "'}";
    }
}
