package com.cnlaunch.diagnosemodule.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class BasicBean implements Serializable {
    private static final long serialVersionUID = 3884573840591477260L;
    public String type;
    public String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
