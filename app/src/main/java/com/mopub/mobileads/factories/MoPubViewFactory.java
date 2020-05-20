package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.MoPubView;

/* loaded from: classes.dex */
public class MoPubViewFactory {

    /* renamed from: a */
    protected static MoPubViewFactory f20590a = new MoPubViewFactory();

    @VisibleForTesting
    @Deprecated
    public static void setInstance(MoPubViewFactory moPubViewFactory) {
        f20590a = moPubViewFactory;
    }

    public static MoPubView create(Context context) {
        return new MoPubView(context);
    }
}
