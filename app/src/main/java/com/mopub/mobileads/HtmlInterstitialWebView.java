package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial;

/* loaded from: classes.dex */
public class HtmlInterstitialWebView extends BaseHtmlWebView {

    /* renamed from: b */
    private Handler f20336b;

    public HtmlInterstitialWebView(Context context, AdReport adReport) {
        super(context, adReport);
        this.f20336b = new Handler();
    }

    public void init(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2, String str3) {
        super.init(z);
        setWebViewClient(new HtmlWebViewClient(new C3723a(customEventInterstitialListener), this, str2, str, str3));
    }

    /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView$a */
    /* loaded from: classes.dex */
    static class C3723a implements HtmlWebViewListener {

        /* renamed from: a */
        private final CustomEventInterstitial.CustomEventInterstitialListener f20337a;

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onCollapsed() {
        }

        public C3723a(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
            this.f20337a = customEventInterstitialListener;
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onLoaded(BaseHtmlWebView baseHtmlWebView) {
            this.f20337a.onInterstitialLoaded();
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onFailed(MoPubErrorCode moPubErrorCode) {
            this.f20337a.onInterstitialFailed(moPubErrorCode);
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public final void onClicked() {
            this.f20337a.onInterstitialClicked();
        }
    }
}
