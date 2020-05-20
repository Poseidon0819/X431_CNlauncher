package com.cnlaunch.diagnosemodule.bean.SysListTopViewData;

import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;

/* loaded from: classes.dex */
public class BasicSysListTopSystemInfoBean extends BasicSystemStatusBean {
    public static int STATUS_FINISH_ABNORMAL = 0;
    public static int STATUS_FINISH_NORMAL = 1;
    public static int STATUS_NOT_EQUIP = 2;
    public static int STATUS_NOT_SCAN = 4;
    public static int STATUS_SCANNING = 3;
    private String abbrSystem;
    private int colorType;
    private boolean isRoot;
    private String topLineName;
    private boolean bChoice = false;
    private int scanStatus = STATUS_NOT_SCAN;
    private boolean isADASSytem = false;

    public boolean isADASSytem() {
        return this.isADASSytem;
    }

    public void setADASSytem(boolean z) {
        this.isADASSytem = z;
    }

    public int getScanStatus() {
        return this.scanStatus;
    }

    public void setScanStatus(int i) {
        this.scanStatus = i;
    }

    public boolean isRoot() {
        return this.isRoot;
    }

    public void setRoot(boolean z) {
        this.isRoot = z;
    }

    public int getColorType() {
        return this.colorType;
    }

    public void setColorType(int i) {
        this.colorType = i;
    }

    public String getTopLineName() {
        return this.topLineName;
    }

    public void setTopLineName(String str) {
        this.topLineName = str;
    }

    public String getAbbrSystem() {
        return this.abbrSystem;
    }

    public boolean isbChoice() {
        return this.bChoice;
    }

    public void setbChoice(boolean z) {
        this.bChoice = z;
    }

    public void setAbbrSystem(String str) {
        this.abbrSystem = str;
    }
}
