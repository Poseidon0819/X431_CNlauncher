package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.WeakHashMap;

@Deprecated
/* renamed from: com.mopub.nativeads.ai */
/* loaded from: classes2.dex */
final class NativeAdViewHelper {

    /* renamed from: a */
    private static final WeakHashMap<View, NativeAd> f21063a = new WeakHashMap<>();

    /* compiled from: NativeAdViewHelper.java */
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ai$a */
    /* loaded from: classes2.dex */
    enum EnumC3865a {
        EMPTY,
        AD
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public static View m2084a(View view, ViewGroup viewGroup, Context context, NativeAd nativeAd) {
        NativeAd nativeAd2;
        if (view != null && (nativeAd2 = f21063a.get(view)) != null) {
            nativeAd2.clear(view);
        }
        if (nativeAd == null || nativeAd.isDestroyed()) {
            MoPubLog.m2498d("NativeAd null or invalid. Returning empty view");
            if (view == null || !EnumC3865a.EMPTY.equals(view.getTag())) {
                View view2 = new View(context);
                view2.setTag(EnumC3865a.EMPTY);
                view2.setVisibility(8);
                return view2;
            }
            return view;
        }
        if (view == null || !EnumC3865a.AD.equals(view.getTag())) {
            view = nativeAd.createAdView(context, viewGroup);
            view.setTag(EnumC3865a.AD);
        }
        f21063a.put(view, nativeAd);
        nativeAd.prepare(view);
        nativeAd.renderAdView(view);
        return view;
    }
}
