package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.o */
/* loaded from: classes.dex */
public class CyUserInfoResponse extends CyBaseResponse {
    CyUserInfoResult getCyUserResult;

    public CyUserInfoResult getGetCyUserResult() {
        return this.getCyUserResult;
    }

    public void setGetCyUserResult(CyUserInfoResult cyUserInfoResult) {
        this.getCyUserResult = cyUserInfoResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "CyUserInfoResponse{getCyUserResult=" + this.getCyUserResult + '}';
    }
}
