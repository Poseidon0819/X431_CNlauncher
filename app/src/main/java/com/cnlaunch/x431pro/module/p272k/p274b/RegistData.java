package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.l */
/* loaded from: classes.dex */
public final class RegistData extends AbstractC2709c {
    private static final long serialVersionUID = -7819662502352444788L;
    private String email;
    private String is_bind_mobile;
    private String mobile;
    private String nick_name;
    private String reg_source;
    private String token;
    private String user_id;
    private String user_name;
    private String zipcode;

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final String getUser_name() {
        return this.user_name;
    }

    public final void setUser_name(String str) {
        this.user_name = str;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getIs_bind_mobile() {
        return this.is_bind_mobile;
    }

    public final void setIs_bind_mobile(String str) {
        this.is_bind_mobile = str;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final void setNick_name(String str) {
        this.nick_name = str;
    }

    public final String getReg_source() {
        return this.reg_source;
    }

    public final void setReg_source(String str) {
        this.reg_source = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getZipcode() {
        return this.zipcode;
    }

    public final void setZipcode(String str) {
        this.zipcode = str;
    }

    public final String toString() {
        return "RegistData [user_id=" + this.user_id + ", user_name=" + this.user_name + ", mobile=" + this.mobile + ", email=" + this.email + ", is_bind_mobile=" + this.is_bind_mobile + ", nick_name=" + this.nick_name + ", reg_source=" + this.reg_source + ", token=" + this.token + "]";
    }
}
