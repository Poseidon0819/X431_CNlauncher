package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

/* loaded from: classes.dex */
public class MoPubInterstitial implements CustomEventInterstitialAdapter.InterfaceC3721a {

    /* renamed from: a */
    MoPubInterstitialView f20346a;

    /* renamed from: b */
    private CustomEventInterstitialAdapter f20347b;

    /* renamed from: c */
    private InterstitialAdListener f20348c;

    /* renamed from: d */
    private Activity f20349d;

    /* renamed from: e */
    private volatile EnumC3727a f20350e;

    /* loaded from: classes.dex */
    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.MoPubInterstitial$a */
    /* loaded from: classes.dex */
    public enum EnumC3727a {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MoPubInterstitial(Activity activity, String str) {
        this.f20349d = activity;
        this.f20346a = new MoPubInterstitialView(this.f20349d);
        this.f20346a.setAdUnitId(str);
        this.f20350e = EnumC3727a.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: a */
    public synchronized boolean m2433a(EnumC3727a enumC3727a, boolean z) {
        Preconditions.checkNotNull(enumC3727a);
        switch (this.f20350e) {
            case LOADING:
                switch (enumC3727a) {
                    case LOADING:
                        if (!z) {
                            MoPubLog.m2498d("Already loading an interstitial.");
                        }
                        return false;
                    case SHOWING:
                        MoPubLog.m2498d("Interstitial is not ready to be shown yet.");
                        return false;
                    case DESTROYED:
                        m2434a();
                        return true;
                    case IDLE:
                        m2427c();
                        this.f20350e = EnumC3727a.IDLE;
                        return true;
                    case READY:
                        this.f20350e = EnumC3727a.READY;
                        return true;
                    default:
                        return false;
                }
            case SHOWING:
                switch (enumC3727a) {
                    case LOADING:
                        if (!z) {
                            MoPubLog.m2498d("Interstitial already showing. Not loading another.");
                        }
                        return false;
                    case SHOWING:
                        MoPubLog.m2498d("Already showing an interstitial. Cannot show it again.");
                        return false;
                    case DESTROYED:
                        m2434a();
                        return true;
                    case IDLE:
                        if (z) {
                            MoPubLog.m2498d("Cannot force refresh while showing an interstitial.");
                            return false;
                        }
                        m2427c();
                        this.f20350e = EnumC3727a.IDLE;
                        return true;
                    default:
                        return false;
                }
            case DESTROYED:
                MoPubLog.m2498d("MoPubInterstitial destroyed. Ignoring all requests.");
                return false;
            case IDLE:
                switch (enumC3727a) {
                    case LOADING:
                        m2427c();
                        this.f20350e = EnumC3727a.LOADING;
                        if (z) {
                            this.f20346a.forceRefresh();
                        } else {
                            this.f20346a.loadAd();
                        }
                        return true;
                    case SHOWING:
                        MoPubLog.m2498d("No interstitial loading or loaded.");
                        return false;
                    case DESTROYED:
                        m2434a();
                        return true;
                    default:
                        return false;
                }
            case READY:
                switch (enumC3727a) {
                    case LOADING:
                        MoPubLog.m2498d("Interstitial already loaded. Not loading another.");
                        if (this.f20348c != null) {
                            this.f20348c.onInterstitialLoaded(this);
                        }
                        return false;
                    case SHOWING:
                        if (this.f20347b != null) {
                            this.f20347b.m2444b();
                        }
                        this.f20350e = EnumC3727a.SHOWING;
                        return true;
                    case DESTROYED:
                        m2434a();
                        return true;
                    case IDLE:
                        if (z) {
                            m2427c();
                            this.f20350e = EnumC3727a.IDLE;
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    /* renamed from: a */
    private void m2434a() {
        m2427c();
        this.f20346a.setBannerAdListener(null);
        this.f20346a.destroy();
        this.f20350e = EnumC3727a.DESTROYED;
    }

    public void load() {
        m2433a(EnumC3727a.LOADING, false);
    }

    public boolean show() {
        return m2433a(EnumC3727a.SHOWING, false);
    }

    public void forceRefresh() {
        m2433a(EnumC3727a.IDLE, true);
        m2433a(EnumC3727a.LOADING, true);
    }

    public boolean isReady() {
        return this.f20350e == EnumC3727a.READY;
    }

    /* renamed from: b */
    private boolean m2429b() {
        return this.f20350e == EnumC3727a.DESTROYED;
    }

    /* renamed from: c */
    private void m2427c() {
        CustomEventInterstitialAdapter customEventInterstitialAdapter = this.f20347b;
        if (customEventInterstitialAdapter != null) {
            customEventInterstitialAdapter.m2443c();
            this.f20347b = null;
        }
    }

    public void setKeywords(String str) {
        this.f20346a.setKeywords(str);
    }

    public String getKeywords() {
        return this.f20346a.getKeywords();
    }

    public Activity getActivity() {
        return this.f20349d;
    }

    public Location getLocation() {
        return this.f20346a.getLocation();
    }

    public void destroy() {
        m2433a(EnumC3727a.DESTROYED, false);
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        this.f20348c = interstitialAdListener;
    }

    public InterstitialAdListener getInterstitialAdListener() {
        return this.f20348c;
    }

    public void setTesting(boolean z) {
        this.f20346a.setTesting(z);
    }

    public boolean getTesting() {
        return this.f20346a.getTesting();
    }

    public void setLocalExtras(Map<String, Object> map) {
        this.f20346a.setLocalExtras(map);
    }

    public Map<String, Object> getLocalExtras() {
        return this.f20346a.getLocalExtras();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC3721a
    public void onCustomEventInterstitialLoaded() {
        if (m2429b()) {
            return;
        }
        m2433a(EnumC3727a.READY, false);
        InterstitialAdListener interstitialAdListener = this.f20348c;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialLoaded(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC3721a
    public void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (m2429b() || this.f20346a.m2394b(moPubErrorCode)) {
            return;
        }
        m2433a(EnumC3727a.IDLE, false);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC3721a
    public void onCustomEventInterstitialShown() {
        if (m2429b()) {
            return;
        }
        this.f20346a.m2426a();
        InterstitialAdListener interstitialAdListener = this.f20348c;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialShown(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC3721a
    public void onCustomEventInterstitialClicked() {
        if (m2429b()) {
            return;
        }
        this.f20346a.m2395b();
        InterstitialAdListener interstitialAdListener = this.f20348c;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialClicked(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC3721a
    public void onCustomEventInterstitialDismissed() {
        if (m2429b()) {
            return;
        }
        m2433a(EnumC3727a.IDLE, false);
        InterstitialAdListener interstitialAdListener = this.f20348c;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialDismissed(this);
        }
    }

    /* loaded from: classes.dex */
    public class MoPubInterstitialView extends MoPubView {
        public MoPubInterstitialView(Context context) {
            super(context);
            setAutorefreshEnabled(false);
        }

        @Override // com.mopub.mobileads.MoPubView
        public AdFormat getAdFormat() {
            return AdFormat.INTERSTITIAL;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mopub.mobileads.MoPubView
        /* renamed from: a */
        public final void mo2396a(String str, Map<String, String> map) {
            if (this.f20376b == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (MoPubInterstitial.this.f20347b != null) {
                    MoPubInterstitial.this.f20347b.m2443c();
                }
                MoPubLog.m2498d("Loading custom event interstitial adapter.");
                MoPubInterstitial moPubInterstitial = MoPubInterstitial.this;
                moPubInterstitial.f20347b = CustomEventInterstitialAdapterFactory.create(moPubInterstitial, str, map, this.f20376b.getBroadcastIdentifier(), this.f20376b.getAdReport());
                CustomEventInterstitialAdapter customEventInterstitialAdapter = MoPubInterstitial.this.f20347b;
                MoPubInterstitial moPubInterstitial2 = MoPubInterstitial.this;
                customEventInterstitialAdapter.f20318a = moPubInterstitial2;
                moPubInterstitial2.f20347b.m2445a();
                return;
            }
            MoPubLog.m2498d("Couldn't invoke custom event because the server did not specify one.");
            m2394b(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }

        /* renamed from: a */
        protected final void m2426a() {
            MoPubLog.m2498d("Tracking impression for interstitial.");
            if (this.f20376b != null) {
                this.f20376b.m2462b();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mopub.mobileads.MoPubView
        /* renamed from: a */
        public final void mo2399a(MoPubErrorCode moPubErrorCode) {
            MoPubInterstitial.this.m2433a(EnumC3727a.IDLE, false);
            if (MoPubInterstitial.this.f20348c != null) {
                MoPubInterstitial.this.f20348c.onInterstitialFailed(MoPubInterstitial.this, moPubErrorCode);
            }
        }
    }
}
