package com.cnlaunch.gmap.map.logic.p153a;

import com.itextpdf.text.pdf.ColumnText;
import java.io.Serializable;

/* renamed from: com.cnlaunch.gmap.map.logic.a.d */
/* loaded from: classes.dex */
public final class LocationResult implements Serializable {
    private static final long serialVersionUID = -8816280164128210889L;
    private String address;
    private double altitude;
    private String cityCode;
    private String cityName;
    private int code;
    private float direction;
    private LcLatlng lclatlng;
    private String province;
    private int requestFlag;
    private float speed;
    private String time;
    private float radius = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private boolean isMove = true;

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final LcLatlng getLclatlng() {
        return this.lclatlng;
    }

    public final void setLclatlng(LcLatlng lcLatlng) {
        this.lclatlng = lcLatlng;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final void setCityCode(String str) {
        this.cityCode = str;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final void setCityName(String str) {
        this.cityName = str;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final float getDirection() {
        return this.direction;
    }

    public final void setDirection(float f) {
        this.direction = f;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final void setAltitude(double d) {
        this.altitude = d;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(float f) {
        this.speed = f;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final int getRequestFlag() {
        return this.requestFlag;
    }

    public final void setRequestFlag(int i) {
        this.requestFlag = i;
    }

    public final boolean isMove() {
        return this.isMove;
    }

    public final void setIsMove(boolean z) {
        this.isMove = z;
    }
}
