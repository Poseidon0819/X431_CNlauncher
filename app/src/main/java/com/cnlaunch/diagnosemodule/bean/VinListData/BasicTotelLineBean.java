package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class BasicTotelLineBean extends BasicBean {
    private String baud_rate;
    private String communicatePin;
    private String data;
    private String dataDiamonLength;

    /* renamed from: id */
    private String f7283id;
    private String protocolType;
    private String reshTime;

    public String getProtocolType() {
        return this.protocolType;
    }

    public void setProtocolType(String str) {
        this.protocolType = str;
    }

    public String getCommunicatePin() {
        return this.communicatePin;
    }

    public void setCommunicatePin(String str) {
        this.communicatePin = str;
    }

    public String getBaud_rate() {
        return this.baud_rate;
    }

    public void setBaud_rate(String str) {
        this.baud_rate = str;
    }

    public String getId() {
        return this.f7283id;
    }

    public void setId(String str) {
        this.f7283id = str;
    }

    public String getDataDiamonLength() {
        return this.dataDiamonLength;
    }

    public void setDataDiamonLength(String str) {
        this.dataDiamonLength = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getReshTime() {
        return this.reshTime;
    }

    public void setReshTime(String str) {
        this.reshTime = str;
    }
}
