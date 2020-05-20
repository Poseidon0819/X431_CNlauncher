package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.HtmlInterstitialWebView;

/* loaded from: classes.dex */
public class HtmlInterstitialWebViewFactory {

    /* renamed from: a */
    protected static HtmlInterstitialWebViewFactory f20589a = new HtmlInterstitialWebViewFactory();

    public static HtmlInterstitialWebView create(Context context, AdReport adReport, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2) {
        return f20589a.internalCreate(context, adReport, customEventInterstitialListener, z, str, str2);
    }

    public HtmlInterstitialWebView internalCreate(Context context, AdReport adReport, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2) {
        HtmlInterstitialWebView htmlInterstitialWebView = new HtmlInterstitialWebView(context, adReport);
        htmlInterstitialWebView.init(customEventInterstitialListener, z, str, str2, adReport.getDspCreativeId());
        return htmlInterstitialWebView;
    }

    @Deprecated
    public static void setInstance(HtmlInterstitialWebViewFactory htmlInterstitialWebViewFactory) {
        f20589a = htmlInterstitialWebViewFactory;
    }
}
