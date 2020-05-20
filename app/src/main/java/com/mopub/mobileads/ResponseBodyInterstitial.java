package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ResponseBodyInterstitial extends CustomEventInterstitial {

    /* renamed from: a */
    protected Context f20389a;

    /* renamed from: b */
    protected AdReport f20390b;

    /* renamed from: c */
    protected long f20391c;

    /* renamed from: d */
    private EventForwardingBroadcastReceiver f20392d;

    protected abstract void extractExtras(Map<String, String> map);

    protected abstract void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener);

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public abstract void showInterstitial();

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        this.f20389a = context;
        if (map2.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY)) {
            extractExtras(map2);
            try {
                this.f20390b = (AdReport) map.get(DataKeys.AD_REPORT_KEY);
                Long l = (Long) map.get(DataKeys.BROADCAST_IDENTIFIER_KEY);
                if (l == null) {
                    MoPubLog.m2496e("Broadcast Identifier was not set in localExtras");
                    customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                    return;
                }
                this.f20391c = l.longValue();
                this.f20392d = new EventForwardingBroadcastReceiver(customEventInterstitialListener, this.f20391c);
                EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f20392d;
                eventForwardingBroadcastReceiver.register(eventForwardingBroadcastReceiver, context);
                preRenderHtml(customEventInterstitialListener);
                return;
            } catch (ClassCastException unused) {
                MoPubLog.m2496e("LocalExtras contained an incorrect type.");
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f20392d;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.unregister(eventForwardingBroadcastReceiver);
        }
    }
}
