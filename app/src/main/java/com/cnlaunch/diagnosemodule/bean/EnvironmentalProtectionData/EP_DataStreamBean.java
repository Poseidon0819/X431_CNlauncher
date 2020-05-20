package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class EP_DataStreamBean extends BasicBean {
    private String PID;
    private String abbreviation;
    private String dsName;
    private String dsUnit;
    private String time;
    private String value;

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String str) {
        this.abbreviation = str;
    }

    public String getPID() {
        return this.PID;
    }

    public void setPID(String str) {
        this.PID = str;
    }

    public String getDsName() {
        return this.dsName;
    }

    public void setDsName(String str) {
        this.dsName = str;
    }

    public String getDsUnit() {
        return this.dsUnit;
    }

    public void setDsUnit(String str) {
        this.dsUnit = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
