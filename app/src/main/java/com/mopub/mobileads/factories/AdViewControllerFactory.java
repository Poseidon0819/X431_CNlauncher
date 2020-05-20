package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

/* loaded from: classes.dex */
public class AdViewControllerFactory {

    /* renamed from: a */
    protected static AdViewControllerFactory f20583a = new AdViewControllerFactory();

    @Deprecated
    public static void setInstance(AdViewControllerFactory adViewControllerFactory) {
        f20583a = adViewControllerFactory;
    }

    public static AdViewController create(Context context, MoPubView moPubView) {
        return new AdViewController(context, moPubView);
    }
}
