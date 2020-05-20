package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.CustomEventInterstitial;

/* loaded from: classes.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: b */
    private static IntentFilter f20327b;

    /* renamed from: a */
    private final CustomEventInterstitial.CustomEventInterstitialListener f20328a;

    public EventForwardingBroadcastReceiver(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, long j) {
        super(j);
        this.f20328a = customEventInterstitialListener;
        getIntentFilter();
    }

    @Override // com.mopub.mobileads.BaseBroadcastReceiver
    public IntentFilter getIntentFilter() {
        if (f20327b == null) {
            IntentFilter intentFilter = new IntentFilter();
            f20327b = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            f20327b.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            f20327b.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            f20327b.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
        return f20327b;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f20328a != null && shouldConsumeBroadcast(intent)) {
            String action = intent.getAction();
            if (IntentActions.ACTION_INTERSTITIAL_FAIL.equals(action)) {
                this.f20328a.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            } else if (IntentActions.ACTION_INTERSTITIAL_SHOW.equals(action)) {
                this.f20328a.onInterstitialShown();
            } else if (IntentActions.ACTION_INTERSTITIAL_DISMISS.equals(action)) {
                this.f20328a.onInterstitialDismissed();
                unregister(this);
            } else if (IntentActions.ACTION_INTERSTITIAL_CLICK.equals(action)) {
                this.f20328a.onInterstitialClicked();
            }
        }
    }
}
