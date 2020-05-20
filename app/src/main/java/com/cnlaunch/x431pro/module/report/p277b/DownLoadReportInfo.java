package com.cnlaunch.x431pro.module.report.p277b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.report.b.a */
/* loaded from: classes.dex */
public final class DownLoadReportInfo extends AbstractC2709c {
    private static final long serialVersionUID = -6126377956230015599L;
    private String diagnosis_time;

    /* renamed from: id */
    private String f15661id;
    private String theme;
    private int type;
    private String url;

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getDiagnosis_time() {
        return this.diagnosis_time;
    }

    public final void setDiagnosis_time(String str) {
        this.diagnosis_time = str;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final void setTheme(String str) {
        this.theme = str;
    }

    public final String getId() {
        return this.f15661id;
    }

    public final void setId(String str) {
        this.f15661id = str;
    }
}
