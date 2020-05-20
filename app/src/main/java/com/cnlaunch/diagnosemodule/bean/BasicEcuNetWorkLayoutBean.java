package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicEcuNetWorkLayoutBean extends BasicBean {
    ArrayList<Integer> arSubColor = new ArrayList<>();
    int bgColor;
    String help;
    int pos;
    int retOpType;
    boolean showGrid;
    int textColor;
    String title;

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String str) {
        this.help = str;
    }

    public int getRetOpType() {
        return this.retOpType;
    }

    public void setRetOpType(int i) {
        this.retOpType = i;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(int i) {
        this.bgColor = i;
    }

    public boolean isShowGrid() {
        return this.showGrid;
    }

    public void setShowGrid(boolean z) {
        this.showGrid = z;
    }

    public ArrayList<Integer> getArSubColor() {
        return this.arSubColor;
    }
}
