package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicDialogScanBarcodeBean extends BasicBean {
    private static final long serialVersionUID = 1;
    String context;
    String title;

    public String getTitle() {
        return this.title;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
