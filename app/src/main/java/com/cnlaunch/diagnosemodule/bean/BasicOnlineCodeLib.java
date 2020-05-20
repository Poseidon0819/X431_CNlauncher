package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicOnlineCodeLib extends BasicBean {
    String codeID;
    String codeStatusID;
    String helpID;
    int helpType;
    String smallCode;
    String softID;
    String systemID;

    public String getSystemID() {
        return this.systemID;
    }

    public void setSystemID(String str) {
        this.systemID = str;
    }

    public String getSoftID() {
        return this.softID;
    }

    public void setSoftID(String str) {
        this.softID = str;
    }

    public String getCodeID() {
        return this.codeID;
    }

    public void setCodeID(String str) {
        this.codeID = str;
    }

    public String getCodeStatusID() {
        return this.codeStatusID;
    }

    public void setCodeStatusID(String str) {
        this.codeStatusID = str;
    }

    public String getSmallCode() {
        return this.smallCode;
    }

    public void setSmallCode(String str) {
        this.smallCode = str;
    }

    public String getHelpID() {
        return this.helpID;
    }

    public void setHelpID(String str) {
        this.helpID = str;
    }

    public int getHelpType() {
        return this.helpType;
    }

    public void setHelpType(int i) {
        this.helpType = i;
    }
}
