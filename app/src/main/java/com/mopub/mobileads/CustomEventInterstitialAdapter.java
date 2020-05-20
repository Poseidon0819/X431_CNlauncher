package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class CustomEventInterstitialAdapter implements CustomEventInterstitial.CustomEventInterstitialListener {
    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;

    /* renamed from: a */
    InterfaceC3721a f20318a;

    /* renamed from: b */
    private final MoPubInterstitial f20319b;

    /* renamed from: c */
    private boolean f20320c;

    /* renamed from: d */
    private CustomEventInterstitial f20321d;

    /* renamed from: e */
    private Context f20322e;

    /* renamed from: f */
    private Map<String, Object> f20323f;

    /* renamed from: g */
    private Map<String, String> f20324g;

    /* renamed from: h */
    private final Handler f20325h;

    /* renamed from: i */
    private final Runnable f20326i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.CustomEventInterstitialAdapter$a */
    /* loaded from: classes.dex */
    public interface InterfaceC3721a {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(MoPubInterstitial moPubInterstitial, String str, Map<String, String> map, long j, AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.f20325h = new Handler();
        this.f20319b = moPubInterstitial;
        this.f20322e = this.f20319b.getActivity();
        this.f20326i = new RunnableC3777h(this);
        MoPubLog.m2498d("Attempting to invoke custom event: ".concat(String.valueOf(str)));
        try {
            this.f20321d = CustomEventInterstitialFactory.create(str);
            this.f20324g = new TreeMap(map);
            this.f20323f = this.f20319b.getLocalExtras();
            if (this.f20319b.getLocation() != null) {
                this.f20323f.put("location", this.f20319b.getLocation());
            }
            this.f20323f.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.f20323f.put(DataKeys.AD_REPORT_KEY, adReport);
        } catch (Exception unused) {
            MoPubLog.m2498d("Couldn't locate or instantiate custom event: " + str + ".");
            this.f20319b.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m2443c() {
        CustomEventInterstitial customEventInterstitial = this.f20321d;
        if (customEventInterstitial != null) {
            try {
                customEventInterstitial.onInvalidate();
            } catch (Exception e) {
                MoPubLog.m2497d("Invalidating a custom event interstitial threw an exception.", e);
            }
        }
        this.f20321d = null;
        this.f20322e = null;
        this.f20324g = null;
        this.f20323f = null;
        this.f20318a = null;
        this.f20320c = true;
    }

    /* renamed from: d */
    private void m2442d() {
        this.f20325h.removeCallbacks(this.f20326i);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onLeaveApplication() {
        onInterstitialClicked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2445a() {
        if (this.f20320c || this.f20321d == null) {
            return;
        }
        Handler handler = this.f20325h;
        Runnable runnable = this.f20326i;
        MoPubInterstitial moPubInterstitial = this.f20319b;
        handler.postDelayed(runnable, (moPubInterstitial == null || moPubInterstitial.f20346a.getAdTimeoutDelay() == null || this.f20319b.f20346a.getAdTimeoutDelay().intValue() < 0) ? 30000 : this.f20319b.f20346a.getAdTimeoutDelay().intValue() * 1000);
        try {
            this.f20321d.loadInterstitial(this.f20322e, this, this.f20323f, this.f20324g);
        } catch (Exception e) {
            MoPubLog.m2497d("Loading a custom event interstitial threw an exception.", e);
            onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m2444b() {
        CustomEventInterstitial customEventInterstitial;
        if (this.f20320c || (customEventInterstitial = this.f20321d) == null) {
            return;
        }
        try {
            customEventInterstitial.showInterstitial();
        } catch (Exception e) {
            MoPubLog.m2497d("Showing a custom event interstitial threw an exception.", e);
            onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialLoaded() {
        if (this.f20320c) {
            return;
        }
        m2442d();
        InterfaceC3721a interfaceC3721a = this.f20318a;
        if (interfaceC3721a != null) {
            interfaceC3721a.onCustomEventInterstitialLoaded();
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (this.f20320c || this.f20318a == null) {
            return;
        }
        if (moPubErrorCode == null) {
            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
        }
        m2442d();
        this.f20318a.onCustomEventInterstitialFailed(moPubErrorCode);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialShown() {
        InterfaceC3721a interfaceC3721a;
        if (this.f20320c || (interfaceC3721a = this.f20318a) == null) {
            return;
        }
        interfaceC3721a.onCustomEventInterstitialShown();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialClicked() {
        InterfaceC3721a interfaceC3721a;
        if (this.f20320c || (interfaceC3721a = this.f20318a) == null) {
            return;
        }
        interfaceC3721a.onCustomEventInterstitialClicked();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialDismissed() {
        InterfaceC3721a interfaceC3721a;
        if (this.f20320c || (interfaceC3721a = this.f20318a) == null) {
            return;
        }
        interfaceC3721a.onCustomEventInterstitialDismissed();
    }
}
