package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.GpsHelper;
import com.mopub.volley.toolbox.HurlStack;

/* loaded from: classes2.dex */
public class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {
    public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
    public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";

    /* renamed from: a */
    private final String f21219a;

    /* renamed from: b */
    private final Context f21220b;

    public PlayServicesUrlRewriter(String str, Context context) {
        this.f21219a = str;
        this.f21220b = context.getApplicationContext();
    }

    @Override // com.mopub.volley.toolbox.HurlStack.UrlRewriter
    public String rewriteUrl(String str) {
        GpsHelper.AdvertisingInfo fetchAdvertisingInfoSync;
        if (str.contains(UDID_TEMPLATE) || str.contains(DO_NOT_TRACK_TEMPLATE)) {
            String str2 = "";
            GpsHelper.AdvertisingInfo advertisingInfo = new GpsHelper.AdvertisingInfo(this.f21219a, false);
            if (GpsHelper.isPlayServicesAvailable(this.f21220b) && (fetchAdvertisingInfoSync = GpsHelper.fetchAdvertisingInfoSync(this.f21220b)) != null) {
                str2 = "ifa:";
                advertisingInfo = fetchAdvertisingInfoSync;
            }
            return str.replace(UDID_TEMPLATE, Uri.encode(str2 + advertisingInfo.advertisingId)).replace(DO_NOT_TRACK_TEMPLATE, advertisingInfo.limitAdTracking ? "1" : "0");
        }
        return str;
    }
}
