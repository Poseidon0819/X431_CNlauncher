package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DataKeys;
import com.mopub.common.event.EventDetails;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.c */
/* loaded from: classes2.dex */
public final class CustomEventNativeAdapter {
    public static void loadNativeAd(Context context, Map<String, Object> map, AdResponse adResponse, CustomEventNative.CustomEventNativeListener customEventNativeListener) {
        String customEventClassName = adResponse.getCustomEventClassName();
        MoPubLog.m2498d("Attempting to invoke custom event: ".concat(String.valueOf(customEventClassName)));
        try {
            CustomEventNative create = CustomEventNativeFactory.create(customEventClassName);
            if (adResponse.hasJson()) {
                map.put(DataKeys.JSON_BODY_KEY, adResponse.getJsonBody());
            }
            EventDetails eventDetails = adResponse.getEventDetails();
            if (eventDetails != null) {
                map.put(DataKeys.EVENT_DETAILS, eventDetails);
            }
            map.put(DataKeys.CLICK_TRACKING_URL_KEY, adResponse.getClickTrackingUrl());
            try {
                create.mo2174a(context, customEventNativeListener, map, adResponse.getServerExtras());
            } catch (Exception e) {
                MoPubLog.m2489w("Loading custom event native threw an error.", e);
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            }
        } catch (Exception unused) {
            MoPubLog.m2490w("Failed to load Custom Event Native class: ".concat(String.valueOf(customEventClassName)));
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
        }
    }
}
