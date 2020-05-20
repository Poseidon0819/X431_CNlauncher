package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner;

/* loaded from: classes.dex */
public class HtmlBannerWebView extends BaseHtmlWebView {
    public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

    public HtmlBannerWebView(Context context, AdReport adReport) {
        super(context, adReport);
    }

    public void init(CustomEventBanner.CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2, String str3) {
        super.init(z);
        setWebViewClient(new HtmlWebViewClient(new C3722a(customEventBannerListener), this, str2, str, str3));
    }

    /* renamed from: com.mopub.mobileads.HtmlBannerWebView$a */
    /* loaded from: classes.dex */
    static class C3722a implements HtmlWebViewListener {

        /* renamed from: a */
        private final CustomEventBanner.CustomEventBannerListener f20330a;

        public C3722a(CustomEventBanner.CustomEventBannerListener customEventBannerListener) {
            this.f20330a = customEventBannerListener;
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onLoaded(BaseHtmlWebView baseHtmlWebView) {
            this.f20330a.onBannerLoaded(baseHtmlWebView);
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onFailed(MoPubErrorCode moPubErrorCode) {
            this.f20330a.onBannerFailed(moPubErrorCode);
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onClicked() {
            this.f20330a.onBannerClicked();
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onCollapsed() {
            this.f20330a.onBannerCollapsed();
        }
    }
}
