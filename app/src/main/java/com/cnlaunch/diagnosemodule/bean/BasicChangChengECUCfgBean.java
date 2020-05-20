package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicChangChengECUCfgBean extends BasicBean {
    String ECUCode;
    String Vin;
    String cfgArgument;
    String secondECUCode;
    String status;

    public String getCfgArgument() {
        return this.cfgArgument;
    }

    public void setCfgArgument(String str) {
        this.cfgArgument = str;
    }

    public String getVin() {
        return this.Vin;
    }

    public void setVin(String str) {
        this.Vin = str;
    }

    public String getECUCode() {
        return this.ECUCode;
    }

    public void setECUCode(String str) {
        this.ECUCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getSecondECUCode() {
        return this.secondECUCode;
    }

    public void setSecondECUCode(String str) {
        this.secondECUCode = str;
    }
}
