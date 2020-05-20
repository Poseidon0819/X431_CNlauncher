package com.mopub.common;

import android.os.Build;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class AdReport implements Serializable {
    private static final long serialVersionUID = 1;
    private final AdResponse mAdResponse;
    private final String mAdUnitId;
    private final Locale mDeviceLocale;
    private final String mDeviceModel;
    private final String mSdkVersion;
    private final String mUdid;

    public AdReport(String str, ClientMetadata clientMetadata, AdResponse adResponse) {
        this.mAdUnitId = str;
        this.mSdkVersion = clientMetadata.getSdkVersion();
        this.mDeviceModel = clientMetadata.getDeviceModel();
        this.mDeviceLocale = clientMetadata.getDeviceLocale();
        this.mUdid = clientMetadata.getDeviceId();
        this.mAdResponse = adResponse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m2615a(sb, "sdk_version", this.mSdkVersion);
        m2615a(sb, "creative_id", this.mAdResponse.getDspCreativeId());
        m2615a(sb, "platform_version", Integer.toString(Build.VERSION.SDK_INT));
        m2615a(sb, "device_model", this.mDeviceModel);
        m2615a(sb, "ad_unit_id", this.mAdUnitId);
        Locale locale = this.mDeviceLocale;
        m2615a(sb, "device_locale", locale == null ? null : locale.toString());
        m2615a(sb, "device_id", this.mUdid);
        m2615a(sb, "network_type", this.mAdResponse.getNetworkType());
        m2615a(sb, "platform", "android");
        long timestamp = this.mAdResponse.getTimestamp();
        m2615a(sb, "timestamp", timestamp != -1 ? new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(new Date(timestamp)) : null);
        m2615a(sb, "ad_type", this.mAdResponse.getAdType());
        Object width = this.mAdResponse.getWidth();
        Object height = this.mAdResponse.getHeight();
        StringBuilder sb2 = new StringBuilder("{");
        if (width == null) {
            width = "0";
        }
        sb2.append(width);
        sb2.append(", ");
        if (height == null) {
            height = "0";
        }
        sb2.append(height);
        sb2.append("}");
        m2615a(sb, "ad_size", sb2.toString());
        return sb.toString();
    }

    public String getResponseString() {
        return this.mAdResponse.getStringBody();
    }

    public String getDspCreativeId() {
        return this.mAdResponse.getDspCreativeId();
    }

    /* renamed from: a */
    private static void m2615a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        sb.append("\n");
    }
}
