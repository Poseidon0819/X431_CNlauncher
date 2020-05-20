package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicChannelSelectBean extends BasicBean {
    private boolean scanEnable;
    private String vin;
    private ArrayList<DropDownBean> arrStrChoice = new ArrayList<>();
    private ArrayList<BasicButtonBean> arrButton = new ArrayList<>();

    public String getVin() {
        return this.vin;
    }

    public void setVin(String str) {
        this.vin = str;
    }

    public boolean getScanEnable() {
        return this.scanEnable;
    }

    public void setScanEnable(boolean z) {
        this.scanEnable = z;
    }

    public ArrayList<DropDownBean> getStrChoice() {
        return this.arrStrChoice;
    }

    public void setStrChoice(ArrayList<DropDownBean> arrayList) {
        this.arrStrChoice = arrayList;
    }

    public ArrayList<BasicButtonBean> getArrButton() {
        return this.arrButton;
    }

    public void setArrButton(ArrayList<BasicButtonBean> arrayList) {
        this.arrButton = arrayList;
    }
}
