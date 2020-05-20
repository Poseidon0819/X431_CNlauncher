package com.cnlaunch.gmap.map.logic.p153a;

import com.itextpdf.text.pdf.PdfBoolean;
import java.io.Serializable;

/* renamed from: com.cnlaunch.gmap.map.logic.a.c */
/* loaded from: classes.dex */
public final class LcLatlng implements Serializable {
    public static String MAP_POINT_BD09 = "BD-09";
    public static String MAP_POINT_GCJ02 = "GCJ-02";
    public static String MAP_POINT_WGS = "WGS";
    private static final long serialVersionUID = 689107334554816975L;
    private String carSpeedValue;
    private String description;
    public boolean isError;
    public double latitude;
    public double longitude;
    public int time;
    public String type;

    public LcLatlng(double d, double d2) {
        this.carSpeedValue = "0";
        this.latitude = d;
        this.longitude = d2;
        this.description = null;
        this.type = null;
        this.carSpeedValue = "";
    }

    public LcLatlng() {
        this.carSpeedValue = "0";
    }

    public LcLatlng(LcLatlng lcLatlng) {
        this.carSpeedValue = "0";
        this.latitude = lcLatlng.latitude;
        this.longitude = lcLatlng.longitude;
        this.description = lcLatlng.description;
        this.type = lcLatlng.type;
        this.carSpeedValue = lcLatlng.carSpeedValue;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public LcLatlng(String str, String str2) {
        this.carSpeedValue = "0";
        String str3 = (isEmpty(str) || str.equals(PdfBoolean.TRUE) || str.equals(PdfBoolean.FALSE)) ? null : str;
        str2 = (isEmpty(str2) || str.equals(PdfBoolean.TRUE) || str.equals(PdfBoolean.FALSE)) ? null : str2;
        if (str3 != null && str2 != null) {
            this.isError = false;
            this.latitude = Double.valueOf(str3).doubleValue();
            this.longitude = Double.valueOf(str2).doubleValue();
            return;
        }
        this.isError = true;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    public final int getTime() {
        return this.time;
    }

    public final void setTime(int i) {
        this.time = i;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getCarSpeedValue() {
        return this.carSpeedValue;
    }

    public final void setCarSpeedValue(String str) {
        this.carSpeedValue = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String toString() {
        return "LcLatlng{latitude=" + this.latitude + ", longitude=" + this.longitude + ", isError=" + this.isError + ", time=" + this.time + ", type='" + this.type + "', carSpeedValue='" + this.carSpeedValue + "', description='" + this.description + "'}";
    }
}
