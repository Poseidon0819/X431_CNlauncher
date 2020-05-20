package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicSelectMenuBean extends BasicBean {
    private static final long serialVersionUID = 3779940643081635150L;

    /* renamed from: id */
    String f7276id;
    String title;
    int num = 0;
    boolean check = false;
    int diagSn = -1;

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public int getDiagSn() {
        return this.diagSn;
    }

    public void setDiagSn(int i) {
        this.diagSn = i;
    }

    public String getId() {
        return this.f7276id;
    }

    public void setId(String str) {
        this.f7276id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isCheck() {
        return this.check;
    }

    public void setCheck(boolean z) {
        this.check = z;
    }
}
