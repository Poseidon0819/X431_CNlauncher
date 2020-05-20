package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.h */
/* loaded from: classes.dex */
public final class LoginData extends AbstractC2709c {
    private static final long serialVersionUID = 1037492000737111829L;
    private String token;
    private User user;
    private Xmpp xmpp;

    public final Xmpp getXmpp() {
        return this.xmpp;
    }

    public final void setXmpp(Xmpp xmpp) {
        this.xmpp = xmpp;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user) {
        this.user = user;
    }

    public final String toString() {
        return "LoginData [xmpp=" + this.xmpp + ", token=" + this.token + ", user=" + this.user + "]";
    }
}
