package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.h.b.a */
/* loaded from: classes.dex */
public final class DiagLogHistoryDetailInfo extends AbstractC2709c {
    private static final long serialVersionUID = -683115658989608465L;
    private int currentState;
    private String logName = "";
    private String userOperatePath = "";
    private String errorMessage = "";
    private String analysis = "";
    private String solution = "";

    public final String getLogName() {
        return this.logName;
    }

    public final void setLogName(String str) {
        this.logName = str;
    }

    public final String getUserOperatePath() {
        return this.userOperatePath;
    }

    public final void setUserOperatePath(String str) {
        this.userOperatePath = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final String getAnalysis() {
        return this.analysis;
    }

    public final void setAnalysis(String str) {
        this.analysis = str;
    }

    public final String getSolution() {
        return this.solution;
    }

    public final void setSolution(String str) {
        this.solution = str;
    }

    public final int getCurrentState() {
        return this.currentState;
    }

    public final void setCurrentState(int i) {
        this.currentState = i;
    }
}
