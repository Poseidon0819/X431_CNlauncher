package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicSoftIDBean extends BasicBean {
    String SoftID;
    String softLan = "";

    public String getSoftLan() {
        return this.softLan;
    }

    public void setSoftLan(String str) {
        this.softLan = str;
    }

    public String getSoftID() {
        return this.SoftID;
    }

    public void setSoftID(String str) {
        this.SoftID = str;
    }
}
