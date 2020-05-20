package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicDeviceBindBean extends BasicBean {
    private String adpterSN;
    private String chipId;
    private String deviceSN;
    private String randomCode;
    private int randomIndex;

    public String getDeviceSN() {
        return this.deviceSN;
    }

    public void setDeviceSN(String str) {
        this.deviceSN = str;
    }

    public String getAdpterSN() {
        return this.adpterSN;
    }

    public void setAdpterSN(String str) {
        this.adpterSN = str;
    }

    public String getRandomCode() {
        return this.randomCode;
    }

    public void setRandomCode(String str) {
        this.randomCode = str;
    }

    public int getRandomIndex() {
        return this.randomIndex;
    }

    public void setRandomIndex(int i) {
        this.randomIndex = i;
    }

    public String getChipId() {
        return this.chipId;
    }

    public void setChipId(String str) {
        this.chipId = str;
    }
}
