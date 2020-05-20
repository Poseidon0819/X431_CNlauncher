package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.r */
/* loaded from: classes.dex */
public final class SearchFriednInfo extends AbstractC2709c implements InfaceItemInfo {
    private static final long serialVersionUID = -3855606959819899639L;
    private String car_logo;
    private String car_name;
    private Float dis;
    private String face_ver;

    /* renamed from: id */
    private Long f15543id;
    private Integer is_friend;
    private Float lat;
    private Float lon;
    private String nick_name;
    private String reg_zone;
    private Integer roles;
    private Integer sex;
    private String signature;
    private String sortKey;
    private String user_id;

    public final String getLastText() {
        return null;
    }

    public final Long getLastTime() {
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final int getSrcType() {
        return 2;
    }

    public SearchFriednInfo() {
    }

    public SearchFriednInfo(Long l) {
        this.f15543id = l;
    }

    public SearchFriednInfo(Long l, String str, Integer num, String str2, String str3, String str4, Integer num2, Integer num3, String str5, Float f, Float f2, Float f3, String str6, String str7, String str8) {
        this.f15543id = l;
        this.user_id = str;
        this.roles = num;
        this.face_ver = str2;
        this.reg_zone = str3;
        this.signature = str4;
        this.is_friend = num2;
        this.sex = num3;
        this.nick_name = str5;
        this.lon = f;
        this.lat = f2;
        this.dis = f3;
        this.car_logo = str6;
        this.car_name = str7;
        this.sortKey = str8;
    }

    public final Long getId() {
        return this.f15543id;
    }

    public final void setId(Long l) {
        this.f15543id = l;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final Integer getRoles() {
        return this.roles;
    }

    public final void setRoles(Integer num) {
        this.roles = num;
    }

    public final String getFace_ver() {
        return this.face_ver;
    }

    public final void setFace_ver(String str) {
        this.face_ver = str;
    }

    public final String getReg_zone() {
        return this.reg_zone;
    }

    public final void setReg_zone(String str) {
        this.reg_zone = str;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final String getSignature() {
        return this.signature;
    }

    public final void setSignature(String str) {
        this.signature = str;
    }

    public final Integer getIs_friend() {
        return this.is_friend;
    }

    public final void setIs_friend(Integer num) {
        this.is_friend = num;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final Integer getSex() {
        return this.sex;
    }

    public final void setSex(Integer num) {
        this.sex = num;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final void setNick_name(String str) {
        this.nick_name = str;
    }

    public final Float getLon() {
        return this.lon;
    }

    public final void setLon(Float f) {
        this.lon = f;
    }

    public final Float getLat() {
        return this.lat;
    }

    public final void setLat(Float f) {
        this.lat = f;
    }

    public final Float getDis() {
        return this.dis;
    }

    public final void setDis(Float f) {
        this.dis = f;
    }

    public final String getCar_logo() {
        return this.car_logo;
    }

    public final void setCar_logo(String str) {
        this.car_logo = str;
    }

    public final String getCar_name() {
        return this.car_name;
    }

    public final void setCar_name(String str) {
        this.car_name = str;
    }

    public final String getSortKey() {
        return this.sortKey;
    }

    public final void setSortKey(String str) {
        this.sortKey = str;
    }

    public final String getFaceUrl() {
        return UserFaceUtils.m9114a(this.user_id, this.face_ver, this.reg_zone);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final String getName() {
        return getNick_name();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final String getUserID() {
        return getUser_id();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final boolean isFriend() {
        return this.is_friend.intValue() == 1;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public final void setFriend(boolean z) {
        this.is_friend = Integer.valueOf(z ? 1 : 0);
    }
}
