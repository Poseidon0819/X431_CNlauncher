package com.cnlaunch.diagnosemodule.diagnoselog;

import com.cnlaunch.physics.p205k.C1856n;

/* loaded from: classes.dex */
public final class OfflineFeedbackItem {
    private boolean checked;
    private final long createDate;
    private final String deviceSN;
    private final String diagnoseLogFullFilePath;
    private final String lang;
    private final String logType;
    private final String model;
    private final String remark;
    private final String subLogType;
    private final String vehicleType;
    private final String vin;
    private final String year;
    private final String zipFilename;

    public OfflineFeedbackItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j, String str10, String str11) {
        this.deviceSN = str;
        this.zipFilename = str2;
        this.vehicleType = str3;
        this.remark = str4;
        this.logType = str5;
        this.lang = str6;
        this.model = str7;
        this.year = str8;
        this.vin = str9;
        this.createDate = j;
        this.subLogType = str10;
        this.diagnoseLogFullFilePath = str11;
        if (C1856n.f10135a) {
            C1856n.m8130a("OfflineFeedbackItem", String.format("deviceSN = %s, zipFilename = %s, vehicleType = %s,remark = %s\\n logType = %s, lang = %s, model = %s, year = %s, vin = %s, createDate = %d, subLogType = %s ,diagnoseLogFullFilePathdiagnostic = %s", str, str2, str3, str4, str5, str6, str7, str8, str9, Long.valueOf(j), str10, str11));
        }
    }

    public final String getDeviceSN() {
        return this.deviceSN;
    }

    public final String getZipFilename() {
        return this.zipFilename;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getLogType() {
        return this.logType;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getVin() {
        return this.vin;
    }

    public final long getCreateDate() {
        return this.createDate;
    }

    public final String getSubLogType() {
        return this.subLogType;
    }

    public final String getVehicleType() {
        return this.vehicleType;
    }

    public final String getDiagnoseLogFullFilePath() {
        return this.diagnoseLogFullFilePath;
    }

    public final boolean isChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }
}
