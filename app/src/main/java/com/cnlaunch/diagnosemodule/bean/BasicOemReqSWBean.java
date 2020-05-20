package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicOemReqSWBean extends BasicBean {
    private int dataType;
    private String jsonData;
    private String refreshUrl;
    private int reqMode;
    private int serviceProviderType;
    private int tokePos;
    private int tokeValidTime;
    private String url;

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public int getReqMode() {
        return this.reqMode;
    }

    public void setReqMode(int i) {
        this.reqMode = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getRefreshUrl() {
        return this.refreshUrl;
    }

    public void setRefreshUrl(String str) {
        this.refreshUrl = str;
    }

    public int getTokeValidTime() {
        return this.tokeValidTime;
    }

    public void setTokeValidTime(int i) {
        this.tokeValidTime = i;
    }

    public int getServiceProviderType() {
        return this.serviceProviderType;
    }

    public void setServiceProviderType(int i) {
        this.serviceProviderType = i;
    }

    public int getTokePos() {
        return this.tokePos;
    }

    public void setTokePos(int i) {
        this.tokePos = i;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public void setJsonData(String str) {
        this.jsonData = str;
    }
}
