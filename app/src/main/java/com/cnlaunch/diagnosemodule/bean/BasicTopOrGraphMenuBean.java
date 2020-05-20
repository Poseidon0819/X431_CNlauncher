package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicTopOrGraphMenuBean extends BasicMenuBean {
    String abbreviateTitle;
    String grapPath = "";
    String menuType;

    public void setAbbreviateTitle(String str) {
        this.abbreviateTitle = str;
    }

    public String getAbbreviateTitle() {
        return this.abbreviateTitle;
    }

    public void setGrapPath(String str) {
        this.grapPath = str;
    }

    public String getGrapPath() {
        return this.grapPath;
    }

    public void setMenuType(String str) {
        this.menuType = str;
    }

    public String getMenuType() {
        return this.menuType;
    }
}
