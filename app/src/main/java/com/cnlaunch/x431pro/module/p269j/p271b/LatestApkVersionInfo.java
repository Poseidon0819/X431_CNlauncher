package com.cnlaunch.x431pro.module.p269j.p271b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.j.b.f */
/* loaded from: classes.dex */
public class LatestApkVersionInfo implements Serializable {
    private static final long serialVersionUID = -5394747854907447074L;
    private long fileSize;
    private String forceUpgrade;
    private String softDesc;
    private String versionDetailId;
    private String versionNo;

    public String getVersionNo() {
        return this.versionNo;
    }

    public void setVersionNo(String str) {
        this.versionNo = str;
    }

    public String getSoftDesc() {
        return this.softDesc;
    }

    public void setSoftDesc(String str) {
        this.softDesc = str;
    }

    public String getVersionDetailId() {
        return this.versionDetailId;
    }

    public void setVersionDetailId(String str) {
        this.versionDetailId = str;
    }

    public String getForceUpgrade() {
        return this.forceUpgrade;
    }

    public void setForceUpgrade(String str) {
        this.forceUpgrade = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public String toString() {
        return "LatestApkVersionInfo{versionNo='" + this.versionNo + "', softDesc='" + this.softDesc + "', versionDetailId=" + this.versionDetailId + ", forceUpgrade=" + this.forceUpgrade + ", fileSize=" + this.fileSize + '}';
    }
}
