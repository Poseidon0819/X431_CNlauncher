package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubNative.java */
/* renamed from: com.mopub.nativeads.v */
/* loaded from: classes2.dex */
public final class C3903v implements AdRequest.Listener {

    /* renamed from: a */
    final /* synthetic */ MoPubNative f21168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3903v(MoPubNative moPubNative) {
        this.f21168a = moPubNative;
    }

    @Override // com.mopub.network.AdRequest.Listener
    public final void onSuccess(AdResponse adResponse) {
        MoPubNative.m2146a(this.f21168a, adResponse);
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        MoPubNative moPubNative = this.f21168a;
        MoPubLog.m2497d("Native ad request failed.", volleyError);
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case BAD_BODY:
                    moPubNative.f20869c.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
                    return;
                case BAD_HEADER_DATA:
                    moPubNative.f20869c.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
                    return;
                case WARMING_UP:
                    MoPubLog.m2500c(MoPubErrorCode.WARMUP.toString());
                    moPubNative.f20869c.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                    return;
                case NO_FILL:
                    moPubNative.f20869c.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                    return;
                default:
                    moPubNative.f20869c.onNativeFail(NativeErrorCode.UNSPECIFIED);
                    return;
            }
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && networkResponse.statusCode >= 500 && networkResponse.statusCode < 600) {
            moPubNative.f20869c.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
        } else if (networkResponse == null && !DeviceUtils.isNetworkAvailable(moPubNative.f20868b.get())) {
            MoPubLog.m2500c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            moPubNative.f20869c.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
        } else {
            moPubNative.f20869c.onNativeFail(NativeErrorCode.UNSPECIFIED);
        }
    }
}
