package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class VoltageBpsBean extends BasicBean {
    private int pinIndex;
    private String title;
    private String value;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public int getPinIndex() {
        return this.pinIndex;
    }

    public void setPinIndex(int i) {
        this.pinIndex = i;
    }
}
