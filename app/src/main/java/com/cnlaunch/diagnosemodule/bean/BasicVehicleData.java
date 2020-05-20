package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicVehicleData extends BasicBean {
    int dtcCount;
    String ecuType;
    private String status;
    String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getEcuType() {
        return this.ecuType;
    }

    public void setEcuType(String str) {
        this.ecuType = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public int getDtcCount() {
        return this.dtcCount;
    }

    public void setDtcCount(int i) {
        this.dtcCount = i;
    }
}
