package com.cnlaunch.x431pro.module.history.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.history.model.c */
/* loaded from: classes.dex */
public final class HistorySystemModel extends AbstractC2709c {
    private static final long serialVersionUID = -22764003304442285L;
    private int SystemID = 0;
    private int SystemIndex = 0;
    private String NameID = "";
    private String SystemUID = "";
    private String SystemName = "";
    private String AvailableDatastream = "";
    private String AvailableAction = "";
    private int VID = 0;

    public final void setSystemID(int i) {
        this.SystemID = i;
    }

    public final int getSystemID() {
        return this.SystemID;
    }

    public final void setSystemIndex(int i) {
        this.SystemIndex = i;
    }

    public final int getSystemIndex() {
        return this.SystemIndex;
    }

    public final void setNameID(String str) {
        if (str == null) {
            return;
        }
        this.NameID = str;
    }

    public final String getNameID() {
        return this.NameID;
    }

    public final void setSystemUID(String str) {
        if (str == null) {
            return;
        }
        this.SystemUID = str;
    }

    public final String getSystemUID() {
        return this.SystemUID;
    }

    public final void setSystemName(String str) {
        if (str == null) {
            return;
        }
        this.SystemName = str;
    }

    public final String getSystemName() {
        return this.SystemName;
    }

    public final void setAvailableDatastream(String str) {
        if (str == null) {
            return;
        }
        this.AvailableDatastream = str;
    }

    public final String getAvailableDatastream() {
        return this.AvailableDatastream;
    }

    public final void setAvailableAction(String str) {
        if (str == null) {
            return;
        }
        this.AvailableAction = str;
    }

    public final String getAvailableAction() {
        return this.AvailableAction;
    }

    public final void setVID(int i) {
        this.VID = i;
    }

    public final int getVID() {
        return this.VID;
    }

    public final String toString() {
        return "HistoryDTCModel [SystemID=" + this.SystemID + ", SystemIndex=" + this.SystemIndex + ", NameID=" + this.NameID + ", SystemUID=" + this.SystemUID + ", SystemName=" + this.SystemName + ", AvailableDatastream=" + this.AvailableDatastream + ", AvailableAction=" + this.AvailableAction + ", VID=" + this.VID + "]";
    }
}
