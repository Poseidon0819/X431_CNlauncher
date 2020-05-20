package com.cnlaunch.x431pro.module.history.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.history.model.a */
/* loaded from: classes.dex */
public final class HistoryActionModel extends AbstractC2709c {
    private static final long serialVersionUID = -8731926031098462505L;
    private int ActionID = 0;
    private String Name = "";
    private String Result = "";
    private int SystemID = 0;
    private String TimeStamp = "";
    private int VID = 0;

    public final void setActionID(int i) {
        this.ActionID = i;
    }

    public final int getActionID() {
        return this.ActionID;
    }

    public final void setName(String str) {
        if (str == null) {
            return;
        }
        this.Name = str;
    }

    public final String getName() {
        return this.Name;
    }

    public final void setResult(String str) {
        if (str == null) {
            return;
        }
        this.Result = str;
    }

    public final String getResult() {
        return this.Result;
    }

    public final void setSystemID(int i) {
        this.SystemID = i;
    }

    public final int getSystemID() {
        return this.SystemID;
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

    public final String toString() {
        return "HistoryDTCModel [ActionID=" + this.ActionID + ", Name=" + this.Name + ", Result=" + this.Result + ", SystemID=" + this.SystemID + ", TimeStamp=" + this.TimeStamp + ", VID=" + this.VID + "]";
    }
}
