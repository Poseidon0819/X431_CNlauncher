package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.i */
/* loaded from: classes.dex */
public final class GoloAppraiseInfo extends AbstractC2709c {
    private static final long serialVersionUID = 281640331882754258L;
    private String appraise_id;
    private String attitude;
    private String car_logo;
    private String car_name;
    private String car_plate;
    private String car_series;
    private String content;
    private long created;
    private String face_ver;
    private String nick_name;
    private String public_id;
    private String reg_zone;
    private String serve;
    private String sex;
    private String signature;
    private String skill;
    private int total;
    private String type;
    private String user_id;

    public final String getAppraise_id() {
        return this.appraise_id;
    }

    public final void setAppraise_id(String str) {
        this.appraise_id = str;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final String getPublic_id() {
        return this.public_id;
    }

    public final void setPublic_id(String str) {
        this.public_id = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final void setNick_name(String str) {
        this.nick_name = str;
    }

    public final String getSex() {
        return this.sex;
    }

    public final void setSex(String str) {
        this.sex = str;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final void setSignature(String str) {
        this.signature = str;
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

    public final String getCar_plate() {
        return this.car_plate;
    }

    public final void setCar_plate(String str) {
        this.car_plate = str;
    }

    public final String getCar_logo() {
        return this.car_logo;
    }

    public final void setCar_logo(String str) {
        this.car_logo = str;
    }

    public final String getCar_series() {
        return this.car_series;
    }

    public final void setCar_series(String str) {
        this.car_series = str;
    }

    public final String getCar_name() {
        return this.car_name;
    }

    public final void setCar_name(String str) {
        this.car_name = str;
    }

    public final String getAttitude() {
        return this.attitude;
    }

    public final void setAttitude(String str) {
        this.attitude = str;
    }

    public final String getServe() {
        return this.serve;
    }

    public final void setServe(String str) {
        this.serve = str;
    }

    public final String getSkill() {
        return this.skill;
    }

    public final void setSkill(String str) {
        this.skill = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String toString() {
        return "GoloAppraiseInfo [appraise_id=" + this.appraise_id + ", user_id=" + this.user_id + ", public_id=" + this.public_id + ", type=" + this.type + ", nick_name=" + this.nick_name + ", sex=" + this.sex + ", signature=" + this.signature + ", face_ver=" + this.face_ver + ", reg_zone=" + this.reg_zone + ", car_plate=" + this.car_plate + ", car_logo=" + this.car_logo + ", car_series=" + this.car_series + ", car_name=" + this.car_name + ", total=" + getTotal() + ", attitude=" + this.attitude + ", serve=" + this.serve + ", skill=" + this.skill + ", content=" + this.content + ", created=" + getCreated() + "]";
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final long getCreated() {
        return this.created;
    }

    public final void setCreated(long j) {
        this.created = j;
    }
}
