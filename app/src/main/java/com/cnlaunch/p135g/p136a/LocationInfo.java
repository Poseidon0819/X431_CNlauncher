package com.cnlaunch.p135g.p136a;

import java.io.Serializable;

/* renamed from: com.cnlaunch.g.a.a */
/* loaded from: classes.dex */
public final class LocationInfo implements Serializable {
    public static final String LOCATION_TYPE_BAIDU = "BD";
    public static final String LOCATION_TYPE_ST = "ST";
    private static final long serialVersionUID = 3997679667558101627L;
    private String City;
    private String country;
    private String district;
    private long locationTime;
    private String province;
    private String street;
    private String streetNumber;
    private double lat = 0.0d;
    private double lon = 0.0d;
    private String locationAddress = "";
    private String locationType = LOCATION_TYPE_ST;

    public final double getLat() {
        return this.lat;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final double getLon() {
        return this.lon;
    }

    public final void setLon(double d) {
        this.lon = d;
    }

    public final String getLocationType() {
        return this.locationType;
    }

    public final void setLocationType(String str) {
        this.locationType = str;
    }

    public final String getLocationAddress() {
        return this.locationAddress;
    }

    public final void setLocationAddress(String str) {
        this.locationAddress = str;
    }

    public final String getCity() {
        return this.City;
    }

    public final void setCity(String str) {
        this.City = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict(String str) {
        this.district = str;
    }

    public final String getStreet() {
        return this.street;
    }

    public final void setStreet(String str) {
        this.street = str;
    }

    public final String getStreetNumber() {
        return this.streetNumber;
    }

    public final void setStreetNumber(String str) {
        this.streetNumber = str;
    }

    public final long getLocationTime() {
        return this.locationTime;
    }

    public final void setLocationTime(long j) {
        this.locationTime = j;
    }

    public final String toString() {
        return "LocationInfo{locationType='" + this.locationType + "', lat=" + this.lat + ", lon=" + this.lon + ", locationAddress='" + this.locationAddress + "', City='" + this.City + "', country='" + this.country + "', province='" + this.province + "', district='" + this.district + "', street='" + this.street + "', streetNumber='" + this.streetNumber + "', locationTime=" + this.locationTime + '}';
    }
}
