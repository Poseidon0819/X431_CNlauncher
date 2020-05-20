package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.aa */
/* loaded from: classes.dex */
public final class Xmpp extends AbstractC2709c {
    private static final long serialVersionUID = 3380228491641321497L;
    private String domain;

    /* renamed from: ip */
    private String f15593ip;
    private String port;

    public final String getIp() {
        return this.f15593ip;
    }

    public final void setIp(String str) {
        this.f15593ip = str;
    }

    public final String getPort() {
        return this.port;
    }

    public final void setPort(String str) {
        this.port = str;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(String str) {
        this.domain = str;
    }

    public final String toString() {
        return "XmppInfo [ip=" + this.f15593ip + ", port=" + this.port + ", domain=" + this.domain + "]";
    }
}
