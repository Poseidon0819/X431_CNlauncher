package com.mopub.mobileads;

import android.content.SharedPreferences;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;

/* compiled from: MoPubConversionTracker.java */
/* renamed from: com.mopub.mobileads.m */
/* loaded from: classes.dex */
final class C3782m implements TrackingRequest.Listener {

    /* renamed from: a */
    final /* synthetic */ MoPubConversionTracker f20605a;

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3782m(MoPubConversionTracker moPubConversionTracker) {
        this.f20605a = moPubConversionTracker;
    }

    @Override // com.mopub.network.TrackingRequest.Listener
    public final void onResponse(String str) {
        SharedPreferences sharedPreferences;
        String str2;
        sharedPreferences = this.f20605a.f20342c;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        str2 = this.f20605a.f20341b;
        edit.putBoolean(str2, true).commit();
    }
}
