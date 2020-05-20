package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicSpeciaFunctionBean extends BasicBean {
    boolean check = false;
    String model;
    String scale;
    String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getScale() {
        return this.scale;
    }

    public void setScale(String str) {
        this.scale = str;
    }

    public boolean isCheck() {
        return this.check;
    }

    public void setCheck(boolean z) {
        this.check = z;
    }
}
