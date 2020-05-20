package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.y */
/* loaded from: classes.dex */
public final class UserSettingInfo extends AbstractC2709c {
    private static final long serialVersionUID = 7344229553261862931L;
    private String email;
    private String vcode;
    private String tag = null;
    private String signature = null;
    private int sex = -1;
    private String nickname = null;
    private String pic = null;
    private String company = "";
    private String contact = "";
    private String address = "";

    /* renamed from: qq */
    private String f15614qq = "";
    private String weixin = "";
    private String mobile = "";
    private String zipcode = "";
    private String company_phone = "";

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getCompany() {
        return this.company;
    }

    public final void setCompany(String str) {
        this.company = str;
    }

    public final String getContact() {
        return this.contact;
    }

    public final void setContact(String str) {
        this.contact = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final String getQq() {
        return this.f15614qq;
    }

    public final void setQq(String str) {
        this.f15614qq = str;
    }

    public final String getWeixin() {
        return this.weixin;
    }

    public final void setWeixin(String str) {
        this.weixin = str;
    }

    public final String getVcode() {
        return this.vcode;
    }

    public final void setVcode(String str) {
        this.vcode = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final void setSignature(String str) {
        this.signature = str;
    }

    public final int getSex() {
        return this.sex;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final String getPic() {
        return this.pic;
    }

    public final void setPic(String str) {
        this.pic = str;
    }

    public final String getZipcode() {
        return this.zipcode;
    }

    public final void setZipcode(String str) {
        this.zipcode = str;
    }

    public final String getCompany_phone() {
        return this.company_phone;
    }

    public final void setCompany_phone(String str) {
        this.company_phone = str;
    }
}
