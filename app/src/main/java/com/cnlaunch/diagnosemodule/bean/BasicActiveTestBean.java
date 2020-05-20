package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicActiveTestBean extends BasicBean {

    /* renamed from: id */
    String f7266id;
    String title;
    String unit;
    String value;

    public String getId() {
        return this.f7266id;
    }

    public void setId(String str) {
        this.f7266id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str.replaceAll("\n", "");
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str.replaceAll("\n", "");
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
