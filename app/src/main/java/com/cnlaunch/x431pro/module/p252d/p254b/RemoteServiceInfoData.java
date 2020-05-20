package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.d.b.o */
/* loaded from: classes.dex */
public final class RemoteServiceInfoData extends AbstractC2709c {
    private static final long serialVersionUID = -2202886706681504695L;
    private String domain;

    /* renamed from: ip */
    private String f15534ip;
    private int port;

    public final String getIp() {
        return this.f15534ip;
    }

    public final void setIp(String str) {
        this.f15534ip = str;
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int i) {
        this.port = i;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(String str) {
        this.domain = str;
    }
}
