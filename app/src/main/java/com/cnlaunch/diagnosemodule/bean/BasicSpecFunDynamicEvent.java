package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicSpecFunDynamicEvent extends BasicBean {
    int columsNumber;
    String title;
    String addInfo = "";
    ArrayList<BasicButtonBean> buttonList = new ArrayList<>();
    ArrayList<BasicSpeciaFunctionBean> titleList = new ArrayList<>();
    ArrayList<ArrayList<BasicSpeciaFunctionBean>> valueList = new ArrayList<>();

    public int getColumsNumber() {
        return this.columsNumber;
    }

    public void setColumsNumber(int i) {
        this.columsNumber = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getAddInfo() {
        return this.addInfo;
    }

    public void setAddInfo(String str) {
        this.addInfo = str;
    }

    public ArrayList<BasicButtonBean> getButtonList() {
        return this.buttonList;
    }

    public ArrayList<BasicSpeciaFunctionBean> getTitleList() {
        return this.titleList;
    }

    public ArrayList<ArrayList<BasicSpeciaFunctionBean>> getValueList() {
        return this.valueList;
    }
}
