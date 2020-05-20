package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicRealTimeDataBean extends BasicBean {
    private String data = "";
    private boolean isAsk = false;
    private int pid;

    public boolean isAsk() {
        return this.isAsk;
    }

    public void setAsk(boolean z) {
        this.isAsk = z;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
