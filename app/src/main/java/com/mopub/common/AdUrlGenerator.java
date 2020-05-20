package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.util.DateAndTime;

/* loaded from: classes.dex */
public abstract class AdUrlGenerator extends BaseUrlGenerator {

    /* renamed from: a */
    protected Context f19977a;

    /* renamed from: b */
    protected String f19978b;

    /* renamed from: c */
    protected String f19979c;

    /* renamed from: d */
    protected Location f19980d;

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean z) {
        return this;
    }

    public AdUrlGenerator(Context context) {
        this.f19977a = context;
    }

    public AdUrlGenerator withAdUnitId(String str) {
        this.f19978b = str;
        return this;
    }

    public AdUrlGenerator withKeywords(String str) {
        this.f19979c = str;
        return this;
    }

    public AdUrlGenerator withLocation(Location location) {
        this.f19980d = location;
        return this;
    }

    protected void setSdkVersion(String str) {
        m2604b("nv", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2614a() {
        m2604b("mr", "1");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2613a(ClientMetadata clientMetadata) {
        m2604b("id", this.f19978b);
        setSdkVersion(clientMetadata.getSdkVersion());
        m2607a(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        String appPackageName = clientMetadata.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            m2604b("bundle", appPackageName);
        }
        m2604b("q", this.f19979c);
        Location location = this.f19980d;
        Location lastKnownLocation = LocationService.getLastKnownLocation(this.f19977a, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        if (lastKnownLocation != null && (location == null || lastKnownLocation.getTime() >= location.getTime())) {
            location = lastKnownLocation;
        }
        if (location != null) {
            m2604b("ll", location.getLatitude() + "," + location.getLongitude());
            m2604b("lla", String.valueOf((int) location.getAccuracy()));
            Preconditions.checkNotNull(location);
            m2604b("llf", String.valueOf((int) (System.currentTimeMillis() - location.getTime())));
            if (location == lastKnownLocation) {
                m2604b("llsdk", "1");
            }
        }
        m2604b("z", DateAndTime.getTimeZoneOffsetString());
        m2604b("o", clientMetadata.getOrientationString());
        m2611a(clientMetadata.getDeviceDimensions());
        m2604b("sc_a", String.valueOf(clientMetadata.getDensity()));
        String networkOperatorForUrl = clientMetadata.getNetworkOperatorForUrl();
        m2604b("mcc", networkOperatorForUrl == null ? "" : networkOperatorForUrl.substring(0, m2612c(networkOperatorForUrl)));
        m2604b("mnc", networkOperatorForUrl == null ? "" : networkOperatorForUrl.substring(m2612c(networkOperatorForUrl)));
        m2604b("iso", clientMetadata.getIsoCountryCode());
        m2604b("cn", clientMetadata.getNetworkOperatorName());
        m2604b("ct", clientMetadata.getActiveNetworkType().toString());
        m2605b(clientMetadata.getAppVersion());
        m2606b();
    }

    /* renamed from: c */
    private static int m2612c(String str) {
        return Math.min(3, str.length());
    }
}
