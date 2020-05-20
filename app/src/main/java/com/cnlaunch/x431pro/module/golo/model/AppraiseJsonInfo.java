package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.d */
/* loaded from: classes.dex */
public class AppraiseJsonInfo extends AbstractC2709c {
    private static final long serialVersionUID = -1217452428871571511L;
    private String address;
    private String emergency;
    private String public_name;
    private String serve;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getPublic_name() {
        return this.public_name;
    }

    public void setPublic_name(String str) {
        this.public_name = str;
    }

    public String getEmergency() {
        return this.emergency;
    }

    public void setEmergency(String str) {
        this.emergency = str;
    }

    public String getServe() {
        return this.serve;
    }

    public void setServe(String str) {
        this.serve = str;
    }
}
