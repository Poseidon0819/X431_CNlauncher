package com.cnlaunch.x431pro.module.p269j.p271b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.j.b.a */
/* loaded from: classes.dex */
public final class DivisionSoftDto implements Serializable {
    private static final long serialVersionUID = 6706044786739517801L;
    private String fileName;
    private long fileSize;
    private boolean isChecked;
    private String mRemarks;
    private String maxOldVersion;
    private int progress;
    private String softDesc;
    private String softId;
    private String softPackageId;
    private String softSubPackKey;
    private String spfDesc;
    private String spfId;
    private String spfNameDesc;
    private int type;
    private String url;
    private String vNum;
    private boolean isMust = false;
    private volatile Integer state = 0;

    public final String getSpfId() {
        return this.spfId;
    }

    public final void setSpfId(String str) {
        this.spfId = str;
    }

    public final String getSoftSubPackKey() {
        return this.softSubPackKey;
    }

    public final void setSoftSubPackKey(String str) {
        this.softSubPackKey = str;
    }

    public final String getSpfNameDesc() {
        return this.spfNameDesc;
    }

    public final void setSpfNameDesc(String str) {
        this.spfNameDesc = str;
    }

    public final String getSpfDesc() {
        return this.spfDesc;
    }

    public final void setSpfDesc(String str) {
        this.spfDesc = str;
    }

    public final String getSoftPackageId() {
        return this.softPackageId;
    }

    public final void setSoftPackageId(String str) {
        this.softPackageId = str;
    }

    public final String getvNum() {
        return this.vNum;
    }

    public final void setvNum(String str) {
        this.vNum = str;
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

    public final Integer getState() {
        Integer num;
        synchronized (this) {
            num = this.state;
        }
        return num;
    }

    public final void setState(Integer num) {
        synchronized (this) {
            this.state = num;
        }
    }

    public final String getmRemarks() {
        return this.mRemarks;
    }

    public final void setmRemarks(String str) {
        this.mRemarks = str;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final String getSoftDesc() {
        return this.softDesc;
    }

    public final void setSoftDesc(String str) {
        this.softDesc = str;
    }

    public final String getSoftId() {
        return this.softId;
    }

    public final void setSoftId(String str) {
        this.softId = str;
    }

    public final String toString() {
        return "DivisionSoftDto{spfId='" + this.spfId + "', softSubPackKey='" + this.softSubPackKey + "', spfNameDesc='" + this.spfNameDesc + "', spfDesc='" + this.spfDesc + "', softPackageId='" + this.softPackageId + "', vNum='" + this.vNum + "', maxOldVersion='" + this.maxOldVersion + "', type=" + this.type + ", isChecked=" + this.isChecked + ", isMust=" + this.isMust + ", url='" + this.url + "', fileName='" + this.fileName + "', progress=" + this.progress + ", state=" + this.state + ", mRemarks='" + this.mRemarks + "', fileSize='" + this.fileSize + "', softDesc='" + this.softDesc + "', softId='" + this.softId + "'}";
    }
}
