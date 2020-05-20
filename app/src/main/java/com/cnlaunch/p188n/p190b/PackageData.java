package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p191c.BaseModel;

/* renamed from: com.cnlaunch.n.b.g */
/* loaded from: classes.dex */
public final class PackageData extends BaseModel {
    private static final long serialVersionUID = 1;
    private int businessID;
    private int curPackage_Current_number;
    private int cutPackage_Total_number;
    private byte[] data;
    private int sendCounter;
    private boolean isResponsPackage = false;
    private boolean isCCCReportUpload = false;
    private boolean isCutPackage = false;

    public final boolean isCutPackage() {
        return this.isCutPackage;
    }

    public final int getCutPackage_Total_number() {
        return this.cutPackage_Total_number;
    }

    public final void setCutPackage_Total_number(int i) {
        this.cutPackage_Total_number = i;
    }

    public final int getCurPackage_Current_number() {
        return this.curPackage_Current_number;
    }

    public final void setCurPackage_Current_number(int i) {
        this.curPackage_Current_number = i;
    }

    public final void setCutPackage(boolean z) {
        this.isCutPackage = z;
    }

    public final boolean isCCCReportUpload() {
        return this.isCCCReportUpload;
    }

    public final void setCCCReportUpload(boolean z) {
        this.isCCCReportUpload = z;
    }

    public final boolean isResponsPackage() {
        return this.isResponsPackage;
    }

    public final void setResponsPackage(boolean z) {
        this.isResponsPackage = z;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final void setData(byte[] bArr) {
        this.data = bArr;
    }

    public final int getBusinessID() {
        return this.businessID;
    }

    public final void setBusinessID(int i) {
        this.businessID = i;
    }

    public final int getSendCounter() {
        return this.sendCounter;
    }

    public final void setSendCounter(int i) {
        this.sendCounter = i;
    }
}
