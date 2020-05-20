package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicCentralGateWayNetWorkLayoutBean extends BasicBean {
    BasicEcuNetWorkLayoutBean centralGateWayeEcu;
    String help;
    String title;
    ArrayList<BasicButtonBean> arBtn = new ArrayList<>();
    ArrayList<Integer> arLayoutLineColor = new ArrayList<>();
    ArrayList<ArrayList<BasicEcuNetWorkLayoutBean>> arrEcuData = new ArrayList<>();
    ArrayList<BasicEcuNetWorkLayoutBean> arEXEcudata = new ArrayList<>();

    public ArrayList<BasicButtonBean> getArBtn() {
        return this.arBtn;
    }

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String str) {
        this.help = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public BasicEcuNetWorkLayoutBean getCentralGateWayeEcu() {
        return this.centralGateWayeEcu;
    }

    public void setCentralGateWayeEcu(BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean) {
        this.centralGateWayeEcu = basicEcuNetWorkLayoutBean;
    }

    public ArrayList<Integer> getArLayoutLineColor() {
        return this.arLayoutLineColor;
    }

    public ArrayList<ArrayList<BasicEcuNetWorkLayoutBean>> getArrEcuData() {
        return this.arrEcuData;
    }

    public ArrayList<BasicEcuNetWorkLayoutBean> getArEXEcudata() {
        return this.arEXEcudata;
    }

    public String toString() {
        return "BasicCentralGateWayNetWorkLayoutBean{title='" + this.title + "', help='" + this.help + "', centralGateWayeEcu=" + this.centralGateWayeEcu + ", arLayoutLineColor=" + this.arLayoutLineColor + ", arrEcuData=" + this.arrEcuData + ", arEXEcudata=" + this.arEXEcudata + '}';
    }
}
