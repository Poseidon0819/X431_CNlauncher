package com.cnlaunch.x431pro.module.p269j.p271b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.j.b.b */
/* loaded from: classes.dex */
public final class DownloadLog implements Serializable {
    private static final long serialVersionUID = -2128657153840228389L;
    private String currentConfigArea;
    private String currentNetworkSpeed;
    private String downloadDuration;
    private String downloadId;
    private String downloadedSize;
    private String state;

    public final String getDownloadId() {
        return this.downloadId;
    }

    public final void setDownloadId(String str) {
        this.downloadId = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getDownloadedSize() {
        return this.downloadedSize;
    }

    public final void setDownloadedSize(String str) {
        this.downloadedSize = str;
    }

    public final String getDownloadDuration() {
        return this.downloadDuration;
    }

    public final void setDownloadDuration(String str) {
        this.downloadDuration = str;
    }

    public final String getCurrentNetworkSpeed() {
        return this.currentNetworkSpeed;
    }

    public final void setCurrentNetworkSpeed(String str) {
        this.currentNetworkSpeed = str;
    }

    public final String getCurrentConfigArea() {
        return this.currentConfigArea;
    }

    public final void setCurrentConfigArea(String str) {
        this.currentConfigArea = str;
    }

    public final String toString() {
        return "DownloadLog [downloadId=" + this.downloadId + ", state=" + this.state + ", downloadedSize=" + this.downloadedSize + ", downloadDuration=" + this.downloadDuration + ", currentNetworkSpeed=" + this.currentNetworkSpeed + ", currentConfigArea=" + this.currentConfigArea + "]";
    }
}
