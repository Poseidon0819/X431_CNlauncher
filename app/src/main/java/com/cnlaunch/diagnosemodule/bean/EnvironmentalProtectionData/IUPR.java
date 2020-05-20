package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import java.util.List;

/* loaded from: classes.dex */
public class IUPR {
    private int fireCount;
    private List<IuprDataBean> iupr_data;
    private LocationBean location;

    /* renamed from: message  reason: collision with root package name */
    private String f24480message;
    private int obd_Count;
    private int sendTime;
    private String serial_num;
    private int type;

    public int getFireCount() {
        return this.fireCount;
    }

    public void setFireCount(int i) {
        this.fireCount = i;
    }

    public int getObd_Count() {
        return this.obd_Count;
    }

    public void setObd_Count(int i) {
        this.obd_Count = i;
    }

    public LocationBean getLocation() {
        return this.location;
    }

    public void setLocation(LocationBean locationBean) {
        this.location = locationBean;
    }

    public String getMessage() {
        return this.f24480message;
    }

    public void setMessage(String str) {
        this.f24480message = str;
    }

    public int getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(int i) {
        this.sendTime = i;
    }

    public String getSerial_num() {
        return this.serial_num;
    }

    public void setSerial_num(String str) {
        this.serial_num = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public List<IuprDataBean> getIupr_data() {
        return this.iupr_data;
    }

    public void setIupr_data(List<IuprDataBean> list) {
        this.iupr_data = list;
    }

    /* loaded from: classes.dex */
    public static class LocationBean {
        private String City;
        private String country;
        private String district;
        private double lat;
        private String locationAddress;
        private int locationTime;
        private String locationType;
        private double lon;
        private String province;
        private String street;
        private String streetNumber;

        public String getCity() {
            return this.City;
        }

        public void setCity(String str) {
            this.City = str;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public String getDistrict() {
            return this.district;
        }

        public void setDistrict(String str) {
            this.district = str;
        }

        public double getLat() {
            return this.lat;
        }

        public void setLat(double d) {
            this.lat = d;
        }

        public String getLocationAddress() {
            return this.locationAddress;
        }

        public void setLocationAddress(String str) {
            this.locationAddress = str;
        }

        public int getLocationTime() {
            return this.locationTime;
        }

        public void setLocationTime(int i) {
            this.locationTime = i;
        }

        public String getLocationType() {
            return this.locationType;
        }

        public void setLocationType(String str) {
            this.locationType = str;
        }

        public double getLon() {
            return this.lon;
        }

        public void setLon(double d) {
            this.lon = d;
        }

        public String getProvince() {
            return this.province;
        }

        public void setProvince(String str) {
            this.province = str;
        }

        public String getStreet() {
            return this.street;
        }

        public void setStreet(String str) {
            this.street = str;
        }

        public String getStreetNumber() {
            return this.streetNumber;
        }

        public void setStreetNumber(String str) {
            this.streetNumber = str;
        }
    }

    /* loaded from: classes.dex */
    public static class IuprDataBean {
        private String Abbreviation;
        private int CompletionTimes;
        private String Context;
        private int MatchConditionTimes;
        private String Ratio;

        public String getAbbreviation() {
            return this.Abbreviation;
        }

        public void setAbbreviation(String str) {
            this.Abbreviation = str;
        }

        public int getCompletionTimes() {
            return this.CompletionTimes;
        }

        public void setCompletionTimes(int i) {
            this.CompletionTimes = i;
        }

        public String getContext() {
            return this.Context;
        }

        public void setContext(String str) {
            this.Context = str;
        }

        public int getMatchConditionTimes() {
            return this.MatchConditionTimes;
        }

        public void setMatchConditionTimes(int i) {
            this.MatchConditionTimes = i;
        }

        public String getRatio() {
            return this.Ratio;
        }

        public void setRatio(String str) {
            this.Ratio = str;
        }
    }
}
