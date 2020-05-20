package com.cnlaunch.x431pro.module.p269j.p271b;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.j.b.l */
/* loaded from: classes.dex */
public final class X431PadDtoSoft implements Serializable {
    private static final long serialVersionUID = 6706044786739517801L;
    private List<DivisionSoftDto> carDivisionSoftDtoList;
    private String diagVehicleType;
    private String downloadId;
    private String fileName;
    private String freeUseEndTime;
    private boolean isChecked;
    private String lanId;
    private String mRemarks;
    private String maxAvailableVersion;
    private int progress;
    private int purchased;
    private String serverCurrentTime;
    private String softApplicableArea;
    private String softId;
    private String softName;
    private String softPackageID;
    private String softUpdateTime;
    private int type;
    private String url;
    private String versionDetailId;
    private String versionNo;
    private long fileSize = 0;
    private String maxOldVersion = "";
    private boolean isMust = false;
    private volatile Integer state = 0;
    private boolean isExpired = false;
    private boolean haveDivisions = false;

    public final String getMaxAvailableVersion() {
        return this.maxAvailableVersion;
    }

    public final void setMaxAvailableVersion(String str) {
        this.maxAvailableVersion = str;
    }

    public final String getDownloadId() {
        return this.downloadId;
    }

    public final void setDownloadId(String str) {
        this.downloadId = str;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final String getSoftName() {
        return this.softName;
    }

    public final void setSoftName(String str) {
        this.softName = str;
    }

    public final String getSoftId() {
        return this.softId;
    }

    public final void setSoftId(String str) {
        this.softId = str;
    }

    public final String getVersionDetailId() {
        return this.versionDetailId;
    }

    public final void setVersionDetailId(String str) {
        this.versionDetailId = str;
    }

    public final String getVersionNo() {
        return this.versionNo;
    }

    public final void setVersionNo(String str) {
        this.versionNo = str;
    }

    public final String getSoftUpdateTime() {
        return this.softUpdateTime;
    }

    public final void setSoftUpdateTime(String str) {
        this.softUpdateTime = str;
    }

    public final String getSoftApplicableArea() {
        return this.softApplicableArea;
    }

    public final void setSoftApplicableArea(String str) {
        this.softApplicableArea = str;
    }

    public final String getServerCurrentTime() {
        return this.serverCurrentTime;
    }

    public final void setServerCurrentTime(String str) {
        this.serverCurrentTime = str;
    }

    public final String getFreeUseEndTime() {
        return this.freeUseEndTime;
    }

    public final void setFreeUseEndTime(String str) {
        this.freeUseEndTime = str;
    }

    public final String getSoftPackageID() {
        return this.softPackageID;
    }

    public final void setSoftPackageID(String str) {
        this.softPackageID = str;
    }

    public final String getDiagVehicleType() {
        return this.diagVehicleType;
    }

    public final void setDiagVehicleType(String str) {
        this.diagVehicleType = str;
    }

    public final String getLanId() {
        return this.lanId;
    }

    public final void setLanId(String str) {
        this.lanId = str;
    }

    public final int getPurchased() {
        return this.purchased;
    }

    public final void setPurchased(int i) {
        this.purchased = i;
    }

    public final String getMaxOldVersion() {
        return this.maxOldVersion;
    }

    public final void setMaxOldVersion(String str) {
        this.maxOldVersion = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final boolean isMust() {
        return this.isMust;
    }

    public final void setMust(boolean z) {
        this.isMust = z;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final int getState() {
        int intValue;
        synchronized (this) {
            intValue = this.state.intValue();
        }
        return intValue;
    }

    public final void setState(int i) {
        synchronized (this) {
            this.state = Integer.valueOf(i);
        }
    }

    public final boolean getExpired() {
        return this.isExpired;
    }

    public final void setExpired(boolean z) {
        this.isExpired = z;
    }

    public final String getRemarks() {
        return this.mRemarks;
    }

    public final void setRemarks(String str) {
        this.mRemarks = str;
    }

    public final List<DivisionSoftDto> getCarDivisionSoftDtoList() {
        return this.carDivisionSoftDtoList;
    }

    public final void setCarDivisionSoftDtoList(List<DivisionSoftDto> list) {
        this.carDivisionSoftDtoList = list;
    }

    public final boolean isHaveDivisions() {
        return this.haveDivisions;
    }

    public final void setHaveDivisions(boolean z) {
        this.haveDivisions = z;
    }

    public final String toString() {
        return "X431PadDtoSoft [softName=" + this.softName + ", softId=" + this.softId + ", versionDetailId=" + this.versionDetailId + ", versionNo=" + this.versionNo + ", softUpdateTime=" + this.softUpdateTime + ", softApplicableArea=" + this.softApplicableArea + ", serverCurrentTime=" + this.serverCurrentTime + ", freeUseEndTime=" + this.freeUseEndTime + ", softPackageID=" + this.softPackageID + ", diagVehicleType=" + this.diagVehicleType + ", lanId=" + this.lanId + ", purchased=" + this.purchased + ", maxOldVersion=" + this.maxOldVersion + ", type=" + this.type + ", isChecked=" + this.isChecked + "]";
    }
}
