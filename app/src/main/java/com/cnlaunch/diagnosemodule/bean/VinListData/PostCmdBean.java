package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;

/* loaded from: classes.dex */
public class PostCmdBean implements Serializable {
    private String calc_id;
    private String data;
    private String property;
    private String soft_id;
    private String type;

    public String getSoft_id() {
        return this.soft_id;
    }

    public void setSoft_id(String str) {
        this.soft_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getCalc_id() {
        return this.calc_id;
    }

    public void setCalc_id(String str) {
        this.calc_id = str;
    }
}
