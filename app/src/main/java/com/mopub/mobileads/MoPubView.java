package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.network.TrackingRequest;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MoPubView extends FrameLayout {

    /* renamed from: a */
    private final String f20375a;

    /* renamed from: b */
    protected AdViewController f20376b;

    /* renamed from: c */
    protected Object f20377c;

    /* renamed from: d */
    BannerAdListener f20378d;

    /* renamed from: e */
    private Context f20379e;

    /* renamed from: f */
    private int f20380f;

    /* renamed from: g */
    private BroadcastReceiver f20381g;

    /* loaded from: classes.dex */
    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    @Deprecated
    public String getClickTrackingUrl() {
        return null;
    }

    @Deprecated
    public String getResponseString() {
        return null;
    }

    @Deprecated
    public void setTimeout(int i) {
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20375a = "com.mopub.mobileads.factories.CustomEventBannerAdapterFactory";
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.f20379e = context;
        this.f20380f = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null) {
            MoPubLog.m2496e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:https://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        this.f20376b = AdViewControllerFactory.create(context, this);
        this.f20381g = new C3743ac(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f20379e.registerReceiver(this.f20381g, intentFilter);
    }

    public void loadAd() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.loadAd();
        }
    }

    /* renamed from: a */
    private void m2400a() {
        Object obj = this.f20377c;
        if (obj != null) {
            try {
                new Reflection.MethodBuilder(obj, "invalidate").setAccessible().execute();
            } catch (Exception e) {
                MoPubLog.m2495e("Error invalidating adapter", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getAdTimeoutDelay() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return Integer.valueOf(adViewController.f20287k);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m2394b(MoPubErrorCode moPubErrorCode) {
        AdViewController adViewController = this.f20376b;
        if (adViewController == null) {
            return false;
        }
        return adViewController.m2467a(moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2396a(String str, Map<String, String> map) {
        if (this.f20376b == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MoPubLog.m2498d("Couldn't invoke custom event because the server did not specify one.");
            m2394b(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (this.f20377c != null) {
            m2400a();
        }
        MoPubLog.m2498d("Loading custom event adapter.");
        if (Reflection.classFound("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")) {
            try {
                this.f20377c = new Reflection.MethodBuilder(null, "create").setStatic(Class.forName("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory")).addParam(MoPubView.class, this).addParam(String.class, str).addParam(Map.class, map).addParam(Long.TYPE, Long.valueOf(this.f20376b.getBroadcastIdentifier())).addParam(AdReport.class, this.f20376b.getAdReport()).execute();
                new Reflection.MethodBuilder(this.f20377c, "loadAd").setAccessible().execute();
                return;
            } catch (Exception e) {
                MoPubLog.m2495e("Error loading custom event", e);
                return;
            }
        }
        MoPubLog.m2496e("Could not load custom event -- missing banner module");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m2395b() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            if (adViewController.f20280d != null) {
                TrackingRequest.makeTrackingHttpRequest(adViewController.f20280d.getClickTrackingUrl(), adViewController.f20277a, BaseEvent.Name.CLICK_REQUEST);
            }
            BannerAdListener bannerAdListener = this.f20378d;
            if (bannerAdListener != null) {
                bannerAdListener.onBannerClicked(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m2393c() {
        MoPubLog.m2498d("Tracking impression for native adapter.");
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.m2462b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (Visibility.hasScreenVisibilityChanged(this.f20380f, i)) {
            this.f20380f = i;
            setAdVisibility(this.f20380f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdVisibility(int i) {
        if (this.f20376b == null) {
            return;
        }
        if (Visibility.isScreenVisible(i)) {
            AdViewController adViewController = this.f20376b;
            adViewController.m2463a(adViewController.f20286j);
            return;
        }
        AdViewController adViewController2 = this.f20376b;
        adViewController2.f20286j = adViewController2.f20285i;
        adViewController2.m2463a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2399a(MoPubErrorCode moPubErrorCode) {
        BannerAdListener bannerAdListener = this.f20378d;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerFailed(this, moPubErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m2392d() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.m2459c();
        }
        MoPubLog.m2498d("adLoaded");
        BannerAdListener bannerAdListener = this.f20378d;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerLoaded(this);
        }
    }

    public void setAdUnitId(String str) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.setAdUnitId(str);
        }
    }

    public String getAdUnitId() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getAdUnitId();
        }
        return null;
    }

    public void setKeywords(String str) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.setKeywords(str);
        }
    }

    public String getKeywords() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getKeywords();
        }
        return null;
    }

    public void setLocation(Location location) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.setLocation(location);
        }
    }

    public Location getLocation() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getLocation();
        }
        return null;
    }

    public int getAdWidth() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getAdWidth();
        }
        return 0;
    }

    public int getAdHeight() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getAdHeight();
        }
        return 0;
    }

    public Activity getActivity() {
        return (Activity) this.f20379e;
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.f20378d = bannerAdListener;
    }

    public BannerAdListener getBannerAdListener() {
        return this.f20378d;
    }

    public void setLocalExtras(Map<String, Object> map) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.f20284h = map != null ? new TreeMap(map) : new TreeMap();
        }
    }

    public Map<String, Object> getLocalExtras() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.f20284h != null ? new TreeMap(adViewController.f20284h) : new TreeMap();
        }
        return new TreeMap();
    }

    public void setAutorefreshEnabled(boolean z) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.f20286j = z;
            adViewController.m2463a(z);
        }
    }

    public boolean getAutorefreshEnabled() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getAutorefreshEnabled();
        }
        MoPubLog.m2498d("Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void setAdContentView(View view) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.f20282f.post(new RunnableC3772c(adViewController, view));
        }
    }

    public void setTesting(boolean z) {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.setTesting(z);
        }
    }

    public boolean getTesting() {
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            return adViewController.getTesting();
        }
        MoPubLog.m2498d("Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void forceRefresh() {
        if (this.f20377c != null) {
            m2400a();
            this.f20377c = null;
        }
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            adViewController.m2470a();
            adViewController.loadAd();
        }
    }

    AdViewController getAdViewController() {
        return this.f20376b;
    }

    public AdFormat getAdFormat() {
        return AdFormat.BANNER;
    }

    public void destroy() {
        try {
            this.f20379e.unregisterReceiver(this.f20381g);
        } catch (Exception unused) {
            MoPubLog.m2498d("Failed to unregister screen state broadcast receiver (never registered).");
        }
        removeAllViews();
        AdViewController adViewController = this.f20376b;
        if (adViewController != null) {
            if (!adViewController.f20281e) {
                if (adViewController.f20288l != null) {
                    adViewController.f20288l.cancel();
                    adViewController.f20288l = null;
                }
                adViewController.m2463a(false);
                adViewController.m2458d();
                adViewController.f20278b = null;
                adViewController.f20277a = null;
                adViewController.f20279c = null;
                adViewController.f20281e = true;
            }
            this.f20376b = null;
        }
        if (this.f20377c != null) {
            m2400a();
            this.f20377c = null;
        }
    }
}
