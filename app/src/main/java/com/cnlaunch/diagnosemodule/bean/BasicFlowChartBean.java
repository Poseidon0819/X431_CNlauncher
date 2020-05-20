package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicFlowChartBean extends BasicBean {
    private ArrayList<BasicFlowChartData> arrBtn = new ArrayList<>();
    private ArrayList<BasicFlowChartData> arrFlowPoint = new ArrayList<>();
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public ArrayList<BasicFlowChartData> getArrBtn() {
        return this.arrBtn;
    }

    public ArrayList<BasicFlowChartData> getArrFlowPoint() {
        return this.arrFlowPoint;
    }
}
