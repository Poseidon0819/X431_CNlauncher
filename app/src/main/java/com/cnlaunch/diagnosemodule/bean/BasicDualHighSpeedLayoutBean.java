package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicDualHighSpeedLayoutBean extends BasicBean {
    String help;
    String title;
    ArrayList<BasicButtonBean> arBtn = new ArrayList<>();
    ArrayList<String> arLayoutLineTitle = new ArrayList<>();
    ArrayList<Integer> arLayoutLineColor = new ArrayList<>();
    ArrayList<ArrayList<BasicEcuNetWorkLayoutBean>> arLayoutLineECUs = new ArrayList<>();
    ArrayList<BasicEcuNetWorkLayoutBean> arPublicECUs = new ArrayList<>();
    ArrayList<BasicEcuNetWorkLayoutBean> arEXECUs = new ArrayList<>();

    public ArrayList<BasicButtonBean> getArBtn() {
        return this.arBtn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String str) {
        this.help = str;
    }

    public ArrayList<String> getArLayoutLineTitle() {
        return this.arLayoutLineTitle;
    }

    public ArrayList<Integer> getArLayoutLineColor() {
        return this.arLayoutLineColor;
    }

    public ArrayList<ArrayList<BasicEcuNetWorkLayoutBean>> getArLayoutLineECUs() {
        return this.arLayoutLineECUs;
    }

    public ArrayList<BasicEcuNetWorkLayoutBean> getArPublicECUs() {
        return this.arPublicECUs;
    }

    public ArrayList<BasicEcuNetWorkLayoutBean> getArEXECUs() {
        return this.arEXECUs;
    }
}
