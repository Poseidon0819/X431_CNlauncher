package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicGetFTSysCfg extends BasicBean {
    int mode = -1;
    int romNum = -1;
    String strHexValue;

    public String getStrHexValue() {
        return this.strHexValue;
    }

    public void setStrHexValue(String str) {
        this.strHexValue = str;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getRomNum() {
        return this.romNum;
    }

    public void setRomNum(int i) {
        this.romNum = i;
    }
}
