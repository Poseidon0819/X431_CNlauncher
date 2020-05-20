package com.cnlaunch.diagnosemodule.bean.HealthDiagData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class BasicHealthDiagConditionDataStreamBean extends BasicBean {
    private String PID;
    private String dsAtt;
    private String goalMax;
    private String goalMin;
    private String maxValue = "0";
    private String minValue = "0";
    private long timestamp;
    private String title;
    private String unit;
    private String value;

    public String getGoalMax() {
        return this.goalMax;
    }

    public void setGoalMax(String str) {
        this.goalMax = str;
    }

    public String getGoalMin() {
        return this.goalMin;
    }

    public void setGoalMin(String str) {
        this.goalMin = str;
    }

    public String getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(String str) {
        this.maxValue = str;
    }

    public String getMinValue() {
        return this.minValue;
    }

    public void setMinValue(String str) {
        this.minValue = str;
    }

    public String getDsAtt() {
        return this.dsAtt;
    }

    public void setDsAtt(String str) {
        this.dsAtt = str;
    }

    public String getPID() {
        return this.PID;
    }

    public void setPID(String str) {
        this.PID = str;
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

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
