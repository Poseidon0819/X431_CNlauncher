package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class AbbreviationBean extends BasicBean {
    private String Abbreviation;
    private String name;
    private String status;
    private String value;

    public String getAbbreviation() {
        return this.Abbreviation;
    }

    public void setAbbreviation(String str) {
        this.Abbreviation = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
