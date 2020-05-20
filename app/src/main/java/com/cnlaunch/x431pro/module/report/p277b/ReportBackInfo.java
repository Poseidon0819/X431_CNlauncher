package com.cnlaunch.x431pro.module.report.p277b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.report.b.c */
/* loaded from: classes.dex */
public final class ReportBackInfo extends AbstractC2709c {
    private static final long serialVersionUID = 2195588262752674216L;

    /* renamed from: id */
    private String f15662id;
    private String url;

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getId() {
        return this.f15662id;
    }

    public final void setId(String str) {
        this.f15662id = str;
    }

    public final String toString() {
        return "id=" + this.f15662id + " url=" + this.url;
    }
}
