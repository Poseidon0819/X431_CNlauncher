package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.v */
/* loaded from: classes.dex */
public class UserBaseInfo extends AbstractC2709c {
    private static final long serialVersionUID = 8940705740713334716L;
    private String address;
    private String city;
    private String company;
    private String company_address;
    private String company_fax;
    private String company_logo;
    private String company_name;
    private String company_phone;
    private String contact;
    private String country;
    private String email;

    /* renamed from: id */
    private Long f15603id;
    private String identity_tag;
    private Integer is_bind_email;
    private Integer is_bind_mobile;
    private String mobile;
    private String nick_name;
    private String province;

    /* renamed from: qq */
    private String f15604qq;
    private Integer sex;
    private String signature;
    private String url;
    private String user_id;
    private String user_name;
    private String weixin;
    private String zipcode;

    public UserBaseInfo() {
    }

    public UserBaseInfo(Long l) {
        this.f15603id = l;
    }

    public UserBaseInfo(Long l, Integer num, String str, Integer num2, String str2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        this.f15603id = l;
        this.is_bind_mobile = num;
        this.mobile = str;
        this.is_bind_email = num2;
        this.email = str2;
        this.sex = num3;
        this.user_id = str3;
        this.nick_name = str4;
        this.signature = str5;
        this.url = str6;
        this.country = str7;
        this.province = str8;
        this.city = str9;
        this.user_name = str10;
        this.identity_tag = str11;
        this.company_name = str12;
        this.company_logo = str13;
        this.company_fax = str14;
        this.company_address = str15;
        this.company = str16;
        this.contact = str17;
        this.address = str18;
        this.f15604qq = str19;
        this.weixin = str20;
    }

    public Long getId() {
        return this.f15603id;
    }

    public void setId(Long l) {
        this.f15603id = l;
    }

    public Integer getIs_bind_mobile() {
        return this.is_bind_mobile;
    }

    public void setIs_bind_mobile(Integer num) {
        this.is_bind_mobile = num;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public Integer getIs_bind_email() {
        return this.is_bind_email;
    }

    public void setIs_bind_email(Integer num) {
        this.is_bind_email = num;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer num) {
        this.sex = num;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public String getIdentity_tag() {
        return this.identity_tag;
    }

    public void setIdentity_tag(String str) {
        this.identity_tag = str;
    }

    public String getCompany_name() {
        return this.company_name;
    }

    public void setCompany_name(String str) {
        this.company_name = str;
    }

    public String getCompany_logo() {
        return this.company_logo;
    }

    public void setCompany_logo(String str) {
        this.company_logo = str;
    }

    public String getCompany_fax() {
        return this.company_fax;
    }

    public void setCompany_fax(String str) {
        this.company_fax = str;
    }

    public String getCompany_address() {
        return this.company_address;
    }

    public void setCompany_address(String str) {
        this.company_address = str;
    }

    public String getCompany_phone() {
        return this.company_phone;
    }

    public void setCompany_phone(String str) {
        this.company_phone = str;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getQq() {
        return this.f15604qq;
    }

    public void setQq(String str) {
        this.f15604qq = str;
    }

    public String getWeixin() {
        return this.weixin;
    }

    public void setWeixin(String str) {
        this.weixin = str;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String str) {
        this.zipcode = str;
    }
}
