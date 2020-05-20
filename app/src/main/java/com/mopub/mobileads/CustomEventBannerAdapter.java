package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class CustomEventBannerAdapter implements CustomEventBanner.CustomEventBannerListener {
    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;

    /* renamed from: a */
    private boolean f20309a;

    /* renamed from: b */
    private MoPubView f20310b;

    /* renamed from: c */
    private Context f20311c;

    /* renamed from: d */
    private CustomEventBanner f20312d;

    /* renamed from: e */
    private Map<String, Object> f20313e;

    /* renamed from: f */
    private Map<String, String> f20314f;

    /* renamed from: g */
    private final Handler f20315g;

    /* renamed from: h */
    private final Runnable f20316h;

    /* renamed from: i */
    private boolean f20317i;

    public CustomEventBannerAdapter(MoPubView moPubView, String str, Map<String, String> map, long j, AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.f20315g = new Handler();
        this.f20310b = moPubView;
        this.f20311c = moPubView.getContext();
        this.f20316h = new RunnableC3776g(this);
        MoPubLog.m2498d("Attempting to invoke custom event: ".concat(String.valueOf(str)));
        try {
            this.f20312d = CustomEventBannerFactory.create(str);
            this.f20314f = new TreeMap(map);
            this.f20313e = this.f20310b.getLocalExtras();
            if (this.f20310b.getLocation() != null) {
                this.f20313e.put("location", this.f20310b.getLocation());
            }
            this.f20313e.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.f20313e.put(DataKeys.AD_REPORT_KEY, adReport);
            this.f20313e.put(DataKeys.AD_WIDTH, Integer.valueOf(this.f20310b.getAdWidth()));
            this.f20313e.put(DataKeys.AD_HEIGHT, Integer.valueOf(this.f20310b.getAdHeight()));
        } catch (Exception unused) {
            MoPubLog.m2498d("Couldn't locate or instantiate custom event: " + str + ".");
            this.f20310b.m2394b(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ReflectionTarget
    /* renamed from: a */
    public final void m2447a() {
        CustomEventBanner customEventBanner = this.f20312d;
        if (customEventBanner != null) {
            try {
                customEventBanner.onInvalidate();
            } catch (Exception e) {
                MoPubLog.m2497d("Invalidating a custom event banner threw an exception", e);
            }
        }
        this.f20311c = null;
        this.f20312d = null;
        this.f20313e = null;
        this.f20314f = null;
        this.f20309a = true;
    }

    /* renamed from: b */
    private void m2446b() {
        this.f20315g.removeCallbacks(this.f20316h);
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onLeaveApplication() {
        onBannerClicked();
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerLoaded(View view) {
        if (this.f20309a) {
            return;
        }
        m2446b();
        MoPubView moPubView = this.f20310b;
        if (moPubView != null) {
            moPubView.m2392d();
            this.f20310b.setAdContentView(view);
            if (view instanceof HtmlBannerWebView) {
                return;
            }
            this.f20310b.m2393c();
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerFailed(MoPubErrorCode moPubErrorCode) {
        if (this.f20309a || this.f20310b == null) {
            return;
        }
        if (moPubErrorCode == null) {
            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
        }
        m2446b();
        this.f20310b.m2394b(moPubErrorCode);
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerExpanded() {
        if (this.f20309a) {
            return;
        }
        this.f20317i = this.f20310b.getAutorefreshEnabled();
        this.f20310b.setAutorefreshEnabled(false);
        MoPubView moPubView = this.f20310b;
        if (moPubView.f20378d != null) {
            moPubView.f20378d.onBannerExpanded(moPubView);
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerCollapsed() {
        if (this.f20309a) {
            return;
        }
        this.f20310b.setAutorefreshEnabled(this.f20317i);
        MoPubView moPubView = this.f20310b;
        if (moPubView.f20378d != null) {
            moPubView.f20378d.onBannerCollapsed(moPubView);
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerClicked() {
        MoPubView moPubView;
        if (this.f20309a || (moPubView = this.f20310b) == null) {
            return;
        }
        moPubView.m2395b();
    }
}
