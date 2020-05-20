package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.g */
/* loaded from: classes.dex */
public final class CloudDiagSystemInfo extends AbstractC2709c {
    private String system = "";
    private String name_id = "";
    private String system_uid = "";
    private String is_new_sys = "";

    public final String getSystem() {
        return this.system;
    }

    public final void setSystem(String str) {
        this.system = str;
    }

    public final String getName_id() {
        return this.name_id;
    }

    public final void setName_id(String str) {
        this.name_id = str;
    }

    public final String getSystem_uid() {
        return this.system_uid;
    }

    public final void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public final String getIs_new_sys() {
        return this.is_new_sys;
    }

    public final void setIs_new_sys(String str) {
        this.is_new_sys = str;
    }

    public final String toString() {
        return "CloudDiagSystemInfo{system='" + this.system + "', name_id='" + this.name_id + "', system_uid='" + this.system_uid + "', is_new_sys='" + this.is_new_sys + "'}";
    }
}
