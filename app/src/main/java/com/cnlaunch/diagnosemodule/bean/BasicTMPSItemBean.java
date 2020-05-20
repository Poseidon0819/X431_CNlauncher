package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicTMPSItemBean extends BasicBean {
    String title;
    String value;
    int pos = 0;
    private ArrayList<BasicTMPSActiveInfo> arrTMPSActiveInfo = new ArrayList<>();

    public int getPos() {
        return this.pos;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public ArrayList<BasicTMPSActiveInfo> getArrTMPSActiveInfo() {
        return this.arrTMPSActiveInfo;
    }
}
