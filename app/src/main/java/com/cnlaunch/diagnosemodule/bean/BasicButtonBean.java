package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicButtonBean extends BasicBean {
    int btnAtt;
    String command;
    boolean enable = true;

    /* renamed from: id */
    String f7267id;
    String title;

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public int getBtnAtt() {
        return this.btnAtt;
    }

    public void setBtnAtt(int i) {
        this.btnAtt = i;
    }

    public String getId() {
        return this.f7267id;
    }

    public void setId(String str) {
        this.f7267id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }
}
