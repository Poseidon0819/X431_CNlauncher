package com.mopub.mobileads;

import android.view.View;

/* loaded from: classes.dex */
public abstract class CustomEventBanner {

    /* loaded from: classes.dex */
    public interface CustomEventBannerListener {
        void onBannerClicked();

        void onBannerCollapsed();

        void onBannerExpanded();

        void onBannerFailed(MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(View view);

        void onLeaveApplication();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onInvalidate();
}
