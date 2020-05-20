package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.o */
/* loaded from: classes.dex */
public final class PidBytData extends AbstractC2709c {
    private static final long serialVersionUID = 4104546171610739391L;
    private String pub_id;
    private String pub_name;

    public final String getPub_name() {
        return this.pub_name;
    }

    public final void setPub_name(String str) {
        this.pub_name = str;
    }

    public final String getPub_id() {
        return this.pub_id;
    }

    public final void setPub_id(String str) {
        this.pub_id = str;
    }

    public final String toString() {
        return "PidBytData [pub_id=" + this.pub_id + ", pub_name=" + this.pub_name + "]";
    }
}
