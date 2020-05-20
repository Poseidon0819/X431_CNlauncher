package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.h.b.c */
/* loaded from: classes.dex */
public class DiagLogHistoryInfo extends AbstractC2709c {
    private static final long serialVersionUID = 5383974431508879419L;
    private int currentState;
    private String feedbackTime;
    private String inputContent;
    private String logId;
    private String logName;
    private int readed;
    private String serialNo;

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String str) {
        this.serialNo = str;
    }

    public String getInputContent() {
        return this.inputContent;
    }

    public void setInputContent(String str) {
        this.inputContent = str;
    }

    public String getFeedbackTime() {
        return this.feedbackTime;
    }

    public void setFeedbackTime(String str) {
        this.feedbackTime = str;
    }

    public String getLogName() {
        return this.logName;
    }

    public void setLogName(String str) {
        this.logName = str;
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(int i) {
        this.currentState = i;
    }

    public String getLogId() {
        return this.logId;
    }

    public void setLogId(String str) {
        this.logId = str;
    }

    public int getReaded() {
        return this.readed;
    }

    public void setReaded(int i) {
        this.readed = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.logId.equals(((DiagLogHistoryInfo) obj).logId);
    }

    public int hashCode() {
        return this.logId.hashCode();
    }

    public String toString() {
        return "DiagLogHistoryInfo{serialNo='" + this.serialNo + "', inputContent='" + this.inputContent + "', feedbackTime='" + this.feedbackTime + "', logName='" + this.logName + "', currentState=" + this.currentState + ", logId='" + this.logId + "'}";
    }
}
