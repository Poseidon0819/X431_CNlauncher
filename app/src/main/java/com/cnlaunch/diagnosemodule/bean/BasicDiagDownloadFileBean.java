package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicDiagDownloadFileBean extends BasicBean {
    String fileVersion;
    String localpath;
    String softID;

    public void setFileVersion(String str) {
        this.fileVersion = str;
    }

    public String getFileVersion() {
        return this.fileVersion;
    }

    public void setSoftID(String str) {
        this.softID = str;
    }

    public String getSoftID() {
        return this.softID;
    }

    public void setLocalpath(String str) {
        this.localpath = str;
    }

    public String getLocalpath() {
        return this.localpath;
    }
}
