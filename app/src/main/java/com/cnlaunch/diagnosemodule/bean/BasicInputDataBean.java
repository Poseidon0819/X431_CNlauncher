package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicInputDataBean extends BasicBean {
    private ArrayList<String> arrStrChoice = new ArrayList<>();
    private int ctrLength;
    private String dislodge;
    private int splitLength;
    private int style;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getStyle() {
        return this.style;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public int getCtrLength() {
        return this.ctrLength;
    }

    public void setCtrLength(int i) {
        this.ctrLength = i;
    }

    public int getSplitLength() {
        return this.splitLength;
    }

    public void setSplitLength(int i) {
        this.splitLength = i;
    }

    public ArrayList<String> getArrStrChoice() {
        return this.arrStrChoice;
    }

    public String getDislodge() {
        return this.dislodge;
    }

    public void setDislodge(String str) {
        this.dislodge = str;
    }
}
