package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicTMPSProgrammingBeam extends BasicBean {
    private int defultPos;
    private int defultTab;
    private String strTitle;
    private String strTopShow;
    private ArrayList<BasicButtonBean> arrBtn = new ArrayList<>();
    private ArrayList<BasicButtonBean> arrTab = new ArrayList<>();
    private ArrayList<BasicButtonBean> arrMenu = new ArrayList<>();
    private ArrayList<BasicTMPSItemBean> arrItem = new ArrayList<>();

    public int getDefultPos() {
        return this.defultPos;
    }

    public void setDefultPos(int i) {
        this.defultPos = i;
    }

    public int getDefultTab() {
        return this.defultTab;
    }

    public void setDefultTab(int i) {
        this.defultTab = i;
    }

    public String getStrTopShow() {
        return this.strTopShow;
    }

    public void setStrTopShow(String str) {
        this.strTopShow = str;
    }

    public void setTitle(String str) {
        this.strTitle = str;
    }

    public String getTitle() {
        return this.strTitle;
    }

    public ArrayList<BasicButtonBean> getTMPSMenu() {
        return this.arrMenu;
    }

    public ArrayList<BasicButtonBean> getTMPSBtn() {
        return this.arrBtn;
    }

    public ArrayList<BasicButtonBean> getTMPSTab() {
        return this.arrTab;
    }

    public ArrayList<BasicTMPSItemBean> getTMPSItem() {
        return this.arrItem;
    }
}
