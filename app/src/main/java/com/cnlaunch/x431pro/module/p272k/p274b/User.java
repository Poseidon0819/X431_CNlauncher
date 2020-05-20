package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.s */
/* loaded from: classes.dex */
public class User extends AbstractC2709c {
    private static final long serialVersionUID = -4463342326567570589L;
    private String email;
    private String face_url;
    private String mobile;
    private String nick_name;
    private String set_face_time;
    private String signature;
    private String token;
    private String user_id;
    private String user_name;

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getSet_face_time() {
        return this.set_face_time;
    }

    public void setSet_face_time(String str) {
        this.set_face_time = str;
    }

    public String getFace_url() {
        return this.face_url;
    }

    public void setFace_url(String str) {
        this.face_url = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "User [user_id=" + this.user_id + ", user_name=" + this.user_name + ", nick_name=" + this.nick_name + ", mobile=" + this.mobile + ", email=" + this.email + ", signature=" + this.signature + ", set_face_time=" + this.set_face_time + ", face_url=" + this.face_url + ", token=" + this.token + "]";
    }
}
