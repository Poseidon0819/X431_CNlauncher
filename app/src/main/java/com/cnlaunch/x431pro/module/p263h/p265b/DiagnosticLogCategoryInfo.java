package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.h.b.g */
/* loaded from: classes.dex */
public final class DiagnosticLogCategoryInfo extends AbstractC2709c {
    private static final long serialVersionUID = 5383974431508879239L;
    private String logId;
    private String make;
    private String model;
    private String vin;
    private String year;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public final String getMake() {
        return this.make;
    }

    public final void setMake(String str) {
        this.make = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        this.year = str;
    }

    public final String getVin() {
        return this.vin;
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final String toString() {
        return "DiagnosticLogCategoryInfo{make='" + this.make + "', model='" + this.model + "', year='" + this.year + "', vin='" + this.vin + "', logId='" + this.logId + "'}";
    }
}
