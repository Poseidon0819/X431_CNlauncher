package com.cnlaunch.diagnosemodule.bean.SDefDSData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class BasicDefSubItemDataStreamBean extends BasicBean {
    private int dataLabel;
    private int dsAtt;

    /* renamed from: id */
    private String f7282id;
    private String standardvalue;
    private String title;
    private String unit;
    private String standardvalueStatus = "";
    private String value = "";

    public String getStandardvalueStatus() {
        return this.standardvalueStatus;
    }

    public void setStandardvalueStatus(String str) {
        this.standardvalueStatus = str;
    }

    public int getDsAtt() {
        return this.dsAtt;
    }

    public void setDsAtt(int i) {
        this.dsAtt = i;
    }

    public String getId() {
        return this.f7282id;
    }

    public void setId(String str) {
        this.f7282id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public int getDataLabel() {
        return this.dataLabel;
    }

    public void setDataLabel(int i) {
        this.dataLabel = i;
    }

    public String getStandardvalue() {
        return this.standardvalue;
    }

    public void setStandardvalue(String str) {
        this.standardvalue = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
