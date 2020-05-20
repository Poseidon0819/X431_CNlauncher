package com.cnlaunch.diagnosemodule;

/* loaded from: classes.dex */
public class DiagnoseEdgeParameters {
    private String diagnoseLanguage;
    private String diagnosePath;
    private String serialNo;
    private String softPackageid;
    private String softVersion;

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String str) {
        this.serialNo = str;
    }

    public String getDiagnosePath() {
        return this.diagnosePath;
    }

    public void setDiagnosePath(String str) {
        this.diagnosePath = str;
    }

    public String getDiagnoseLanguage() {
        return this.diagnoseLanguage;
    }

    public void setDiagnoseLanguage(String str) {
        this.diagnoseLanguage = str;
    }

    public String getSoftPackageid() {
        return this.softPackageid;
    }

    public void setSoftPackageid(String str) {
        this.softPackageid = str;
    }

    public String getSoftVersion() {
        return this.softVersion;
    }

    public void setSoftVersion(String str) {
        this.softVersion = str;
    }
}
