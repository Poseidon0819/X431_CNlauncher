package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest;

/* loaded from: classes.dex */
public class MoPubConversionTracker {

    /* renamed from: a */
    private Context f20340a;

    /* renamed from: b */
    private String f20341b;

    /* renamed from: c */
    private SharedPreferences f20342c;

    /* renamed from: d */
    private String f20343d;

    public void reportAppOpen(Context context) {
        if (context == null) {
            return;
        }
        this.f20340a = context;
        this.f20343d = this.f20340a.getPackageName();
        this.f20341b = this.f20343d + " tracked";
        this.f20342c = SharedPreferencesHelper.getSharedPreferences(this.f20340a);
        if (!this.f20342c.getBoolean(this.f20341b, false)) {
            TrackingRequest.makeTrackingHttpRequest(new C3725a(this, (byte) 0).generateUrlString(Constants.HOST), this.f20340a, new C3782m(this));
        } else {
            MoPubLog.m2498d("Conversion already tracked");
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubConversionTracker$a */
    /* loaded from: classes.dex */
    class C3725a extends BaseUrlGenerator {
        private C3725a() {
        }

        /* synthetic */ C3725a(MoPubConversionTracker moPubConversionTracker, byte b) {
            this();
        }

        @Override // com.mopub.common.BaseUrlGenerator
        public final String generateUrlString(String str) {
            m2609a(str, Constants.CONVERSION_TRACKING_HANDLER);
            m2610a("6");
            m2604b("id", MoPubConversionTracker.this.f20343d);
            m2605b(ClientMetadata.getInstance(MoPubConversionTracker.this.f20340a).getAppVersion());
            m2606b();
            return this.f19982e.toString();
        }
    }
}
