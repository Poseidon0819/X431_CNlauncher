package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.d.b.q */
/* loaded from: classes.dex */
public class SellerRemoteDiagInfo extends AbstractC2709c {
    public static SellerRemoteDiagInfo instance = null;
    private static final long serialVersionUID = 1;
    private int indetify = 1;
    private String otherUseID = "";
    private String otherUseName = "";
    private String otherUserSN = "";
    private String otherCarName = "";
    private String reqId = "";
    private String pubId = "";

    public static SellerRemoteDiagInfo getInstance() {
        if (instance == null) {
            synchronized (SellerRemoteDiagInfo.class) {
                if (instance == null) {
                    instance = new SellerRemoteDiagInfo();
                }
            }
        }
        return instance;
    }

    public void clear() {
        this.indetify = 1;
        this.otherUseID = "";
        this.otherUseName = "";
        this.otherUserSN = "";
        this.otherCarName = "";
        this.reqId = "";
        this.pubId = "";
    }

    public int getIndetify() {
        return this.indetify;
    }

    public void setIndetify(int i) {
        this.indetify = i;
    }

    public String getOtherUseID() {
        return this.otherUseID;
    }

    public void setOtherUseID(String str) {
        this.otherUseID = str;
    }

    public String getOtherUseName() {
        return this.otherUseName;
    }

    public void setOtherUseName(String str) {
        this.otherUseName = str;
    }

    public String getOtherUserSN() {
        return this.otherUserSN;
    }

    public void setOtherUserSN(String str) {
        this.otherUserSN = str;
    }

    public String getOtherCarName() {
        return this.otherCarName;
    }

    public void setOtherCarName(String str) {
        this.otherCarName = str;
    }

    public String getReqId() {
        return this.reqId;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public String getPubId() {
        return this.pubId;
    }

    public void setPubId(String str) {
        this.pubId = str;
    }
}
