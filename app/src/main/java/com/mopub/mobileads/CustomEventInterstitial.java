package com.mopub.mobileads;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class CustomEventInterstitial {

    /* loaded from: classes.dex */
    public interface CustomEventInterstitialListener {
        void onInterstitialClicked();

        void onInterstitialDismissed();

        void onInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded();

        void onInterstitialShown();

        void onLeaveApplication();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onInvalidate();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void showInterstitial();
}
