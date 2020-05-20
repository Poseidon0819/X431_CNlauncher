package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicHTMLDialogBean extends BasicBean {
    private String strTitle;
    private int btnType = -1;
    private ArrayList<String> arrayListContext = new ArrayList<>();

    public String getStrTitle() {
        return this.strTitle;
    }

    public void setStrTitle(String str) {
        this.strTitle = str;
    }

    public int getBtnType() {
        return this.btnType;
    }

    public void setBtnType(int i) {
        this.btnType = i;
    }

    public ArrayList<String> getArrayListContext() {
        return this.arrayListContext;
    }
}
