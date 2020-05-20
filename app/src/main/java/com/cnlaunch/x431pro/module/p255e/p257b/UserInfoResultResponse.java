package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.e.b.l */
/* loaded from: classes.dex */
public class UserInfoResultResponse extends BaseResponse {
    private static final long serialVersionUID = 1224386153294829009L;

    /* renamed from: cc */
    private String f15535cc;
    private String email;
    private String mobile;
    private String userName;

    public String getCc() {
        return this.f15535cc;
    }

    public void setCc(String str) {
        this.f15535cc = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "UserInfoResultResponse{cc='" + this.f15535cc + "', userName='" + this.userName + "', email='" + this.email + "', mobile='" + this.mobile + "'}";
    }
}
