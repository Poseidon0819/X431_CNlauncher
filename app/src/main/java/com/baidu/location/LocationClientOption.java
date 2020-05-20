package com.baidu.location;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.mopub.nativeads.MoPubNativeAdPositioning;

/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;

    /* renamed from: a */
    protected LocationMode f3853a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public boolean openGps;
    public int priority;
    public String prodName;
    public int scanSpan;
    public String serviceName;
    public int timeOut;
    public int wifiCacheTimeOut;

    /* loaded from: classes.dex */
    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors
    }

    public LocationClientOption() {
        this.coorType = CoordinateType.GCJ02;
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = false;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.coorType = CoordinateType.GCJ02;
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = false;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.f3853a = locationClientOption.f3853a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
    }

    public final void SetIgnoreCacheException(boolean z) {
        this.isIgnoreCacheException = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m12263a() {
        return this.autoNotifyMaxInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final float m12262b() {
        return this.autoNotifyLocSensitivity;
    }

    public final void disableCache(boolean z) {
        this.disableLocCache = z;
    }

    public final String getAddrType() {
        return this.addrType;
    }

    public final int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public final int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public final String getCoorType() {
        return this.coorType;
    }

    public final LocationMode getLocationMode() {
        return this.f3853a;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getProdName() {
        return this.prodName;
    }

    public final int getScanSpan() {
        return this.scanSpan;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final boolean isDisableCache() {
        return this.disableLocCache;
    }

    public final boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public final boolean isOpenGps() {
        return this.openGps;
    }

    public final boolean optionEquals(LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.f3853a == locationClientOption.f3853a;
    }

    @Deprecated
    public final void setAddrType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress("all".equals(str));
    }

    public final void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals(CoordinateType.GCJ02) || lowerCase.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09) || lowerCase.equals("bd09ll")) {
            this.coorType = lowerCase;
        }
    }

    public final void setEnableSimulateGps(boolean z) {
        this.enableSimulateGps = z;
    }

    public final void setIgnoreKillProcess(boolean z) {
        this.isIgnoreKillProcess = z;
    }

    public final void setIsNeedAddress(boolean z) {
        this.addrType = z ? "all" : "noaddr";
    }

    public final void setIsNeedAltitude(boolean z) {
        this.isNeedAltitude = z;
    }

    public final void setIsNeedLocationDescribe(boolean z) {
        this.isNeedAptag = z;
    }

    public final void setIsNeedLocationPoiList(boolean z) {
        this.isNeedAptagd = z;
    }

    public final void setLocationMode(LocationMode locationMode) {
        switch (locationMode) {
            case Hight_Accuracy:
                this.openGps = true;
                this.priority = 1;
                break;
            case Battery_Saving:
                this.openGps = false;
                this.priority = 2;
                break;
            case Device_Sensors:
                this.priority = 3;
                this.openGps = true;
                break;
            default:
                throw new IllegalArgumentException("Illegal this mode : ".concat(String.valueOf(locationMode)));
        }
        this.f3853a = locationMode;
    }

    public final void setLocationNotify(boolean z) {
        this.location_change_notify = z;
    }

    public final void setNeedDeviceDirect(boolean z) {
        this.mIsNeedDeviceDirect = z;
    }

    public final void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public final void setOpenAutoNotifyMode(int i, int i2, int i3) {
        float f;
        int i4 = i > 180000 ? i + 1000 : 180000;
        if (i4 < 10000) {
            throw new IllegalArgumentException("Illegal this maxLocInterval : " + i4 + " , maxLocInterval must >= 10000");
        }
        switch (i3) {
            case 1:
                f = 0.5f;
                break;
            case 2:
                f = 0.3f;
                break;
            case 3:
                f = 0.1f;
                break;
            default:
                throw new IllegalArgumentException("Illegal this locSensitivity : ".concat(String.valueOf(i3)));
        }
        this.autoNotifyLocSensitivity = f;
        this.autoNotifyMaxInterval = i4;
        this.autoNotifyMinTimeInterval = i;
        this.autoNotifyMinDistance = i2;
    }

    public final void setOpenGps(boolean z) {
        this.openGps = z;
    }

    @Deprecated
    public final void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.priority = i;
        }
    }

    public final void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.prodName = str;
    }

    public final void setScanSpan(int i) {
        this.scanSpan = i;
    }

    @Deprecated
    public final void setSema(boolean z, boolean z2, boolean z3) {
        this.isNeedAptag = z;
        this.isNeedPoiRegion = z2;
        this.isNeedRegular = z3;
    }

    public final void setServiceName(String str) {
        this.serviceName = str;
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }

    public final void setWifiCacheTimeOut(int i) {
        if (i >= 10000) {
            this.wifiCacheTimeOut = i;
        }
    }
}
