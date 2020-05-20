package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicTMPSTestBean extends BasicBean {
    private ArrayList<BasicButtonBean> arrBtn = new ArrayList<>();
    private ArrayList<BasicTMPSItemBean> arrItem = new ArrayList<>();
    private String strTitle;

    public void setTitle(String str) {
        this.strTitle = str;
    }

    public String getTitle() {
        return this.strTitle;
    }

    public ArrayList<BasicButtonBean> getTMPSBtn() {
        return this.arrBtn;
    }

    public ArrayList<BasicTMPSItemBean> getTMPSItem() {
        return this.arrItem;
    }
}
