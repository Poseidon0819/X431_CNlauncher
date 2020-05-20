package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicMenuBean extends BasicBean {

    /* renamed from: id */
    String f7273id;
    String title;
    String hasHelp = "";
    String hadChoiced = "";

    public String getId() {
        return this.f7273id;
    }

    public void setId(String str) {
        this.f7273id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setHasHelp(String str) {
        this.hasHelp = str;
    }

    public String getHasHelp() {
        return this.hasHelp;
    }

    public void setHadChoiced(String str) {
        this.hadChoiced = str;
    }

    public String getHadChoiced() {
        return this.hadChoiced;
    }
}
