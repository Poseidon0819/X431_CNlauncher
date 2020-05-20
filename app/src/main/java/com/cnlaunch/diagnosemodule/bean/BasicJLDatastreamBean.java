package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicJLDatastreamBean extends BasicBean {
    private String dataStreamValue;
    private int dsID;
    private boolean hasRefresh;
    private int iHasRefresh;
    private int iVolWarning;
    private int totalNumber;
    private boolean volWarning;

    public int getTotalNumber() {
        return this.totalNumber;
    }

    public void setTotalNumber(int i) {
        this.totalNumber = i;
    }

    public int getiHasRefresh() {
        return this.iHasRefresh;
    }

    public void setiHasRefresh(int i) {
        this.iHasRefresh = i;
    }

    public int getiVolWarning() {
        return this.iVolWarning;
    }

    public void setiVolWarning(int i) {
        this.iVolWarning = i;
    }

    public int getDsID() {
        return this.dsID;
    }

    public void setDsID(int i) {
        this.dsID = i;
    }

    public boolean isHasRefresh() {
        return this.hasRefresh;
    }

    public void setHasRefresh(boolean z) {
        this.hasRefresh = z;
    }

    public boolean isVolWarning() {
        return this.volWarning;
    }

    public void setVolWarning(boolean z) {
        this.volWarning = z;
    }

    public String getDataStreamValue() {
        return this.dataStreamValue;
    }

    public void setDataStreamValue(String str) {
        this.dataStreamValue = str;
    }
}
