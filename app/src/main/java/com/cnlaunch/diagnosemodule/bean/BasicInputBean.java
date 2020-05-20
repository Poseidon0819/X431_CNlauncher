package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicInputBean extends BasicBean {
    private static final long serialVersionUID = 1;
    boolean canEdit;
    String inputType;
    String lastSetString;
    String prefix;
    String title;
    boolean isEditBeSet = false;
    int iposCombSN = -1;
    ArrayList<String> choiceData = new ArrayList<>();

    public boolean isEditBeSet() {
        return this.isEditBeSet;
    }

    public void setEditBeSet(boolean z) {
        this.isEditBeSet = z;
    }

    public int getIposCombSN() {
        return this.iposCombSN;
    }

    public void setIposCombSN(int i) {
        this.iposCombSN = i;
    }

    public ArrayList<String> getChoiceData() {
        return this.choiceData;
    }

    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String str) {
        this.inputType = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean getCanEdit() {
        return this.canEdit;
    }

    public void setCanEdit(boolean z) {
        this.canEdit = z;
    }
}
