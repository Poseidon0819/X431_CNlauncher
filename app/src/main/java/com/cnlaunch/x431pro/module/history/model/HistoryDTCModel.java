package com.cnlaunch.x431pro.module.history.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.history.model.b */
/* loaded from: classes.dex */
public final class HistoryDTCModel extends AbstractC2709c {
    private static final long serialVersionUID = -2466381216659021173L;
    private int DtcID = 0;
    private String DTC = "";
    private String Description = "";
    private String Status = "";
    private int SystemID = 0;
    private String SystemName = "";
    private String TimeStamp = "";
    private int VID = 0;
    private int IsShowSystem = 0;

    public final void setDtcID(int i) {
        this.DtcID = i;
    }

    public final int getDtcID() {
        return this.DtcID;
    }

    public final void setDTC(String str) {
        if (str == null) {
            return;
        }
        this.DTC = str;
    }

    public final String getDTC() {
        return this.DTC;
    }

    public final void setDescription(String str) {
        if (str == null) {
            return;
        }
        this.Description = str;
    }

    public final String getDescription() {
        return this.Description;
    }

    public final void setStatus(String str) {
        if (str == null) {
            return;
        }
        this.Status = str;
    }

    public final String getStatus() {
        return this.Status;
    }

    public final void setSystemID(int i) {
        this.SystemID = i;
    }

    public final int getSystemID() {
        return this.SystemID;
    }

    public final void setSystemName(String str) {
        this.SystemName = str;
    }

    public final String getSystemName() {
        return this.SystemName;
    }

    public final void setTimeStamp(String str) {
        if (str == null) {
            return;
        }
        this.TimeStamp = str;
    }

    public final String getTimeStamp() {
        return this.TimeStamp;
    }

    public final void setVID(int i) {
        this.VID = i;
    }

    public final int getVID() {
        return this.VID;
    }

    public final void setIsShowSystem(int i) {
        this.IsShowSystem = i;
    }

    public final int getIsShowSystem() {
        return this.IsShowSystem;
    }

    public final String toString() {
        return "HistoryDTCModel [DtcID=" + this.DtcID + ", DTC=" + this.DTC + ", Description=" + this.Description + ", Status=" + this.Status + ", SystemID=" + this.SystemID + ", SystemName=" + this.SystemName + ", TimeStamp=" + this.TimeStamp + ", VID=" + this.VID + ", IsShowSystem=" + this.IsShowSystem + "]";
    }
}
