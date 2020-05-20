package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b.a */
/* loaded from: classes.dex */
public class AdvertiseResponse extends BaseResponse {
    private String linkUrl;
    private String picName;
    private String picSize;
    private String picUrl;
    private String updateDate;

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public String getPicSize() {
        return this.picSize;
    }

    public void setPicSize(String str) {
        this.picSize = str;
    }

    public String getPicName() {
        return this.picName;
    }

    public void setPicName(String str) {
        this.picName = str;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String str) {
        this.updateDate = str;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "AdvertiseResponse{linkUrl='" + this.linkUrl + "', picUrl='" + this.picUrl + "', picSize='" + this.picSize + "', picName='" + this.picName + "', updateDate='" + this.updateDate + "'}";
    }
}
