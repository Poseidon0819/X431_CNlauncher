package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.HtmlBannerWebView;

/* loaded from: classes.dex */
public class HtmlBannerWebViewFactory {

    /* renamed from: a */
    protected static HtmlBannerWebViewFactory f20588a = new HtmlBannerWebViewFactory();

    public static HtmlBannerWebView create(Context context, AdReport adReport, CustomEventBanner.CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2) {
        return f20588a.internalCreate(context, adReport, customEventBannerListener, z, str, str2);
    }

    public HtmlBannerWebView internalCreate(Context context, AdReport adReport, CustomEventBanner.CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2) {
        HtmlBannerWebView htmlBannerWebView = new HtmlBannerWebView(context, adReport);
        htmlBannerWebView.init(customEventBannerListener, z, str, str2, adReport.getDspCreativeId());
        return htmlBannerWebView;
    }

    @Deprecated
    public static void setInstance(HtmlBannerWebViewFactory htmlBannerWebViewFactory) {
        f20588a = htmlBannerWebViewFactory;
    }
}
