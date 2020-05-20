package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class AdViewController {

    /* renamed from: m */
    private static final FrameLayout.LayoutParams f20275m = new FrameLayout.LayoutParams(-2, -2, 17);

    /* renamed from: n */
    private static final WeakHashMap<View, Boolean> f20276n = new WeakHashMap<>();

    /* renamed from: a */
    Context f20277a;

    /* renamed from: b */
    MoPubView f20278b;

    /* renamed from: c */
    WebViewAdUrlGenerator f20279c;

    /* renamed from: d */
    AdResponse f20280d;

    /* renamed from: e */
    boolean f20281e;

    /* renamed from: l */
    AdRequest f20288l;

    /* renamed from: r */
    private boolean f20292r;

    /* renamed from: s */
    private String f20293s;

    /* renamed from: t */
    private String f20294t;

    /* renamed from: u */
    private Location f20295u;

    /* renamed from: v */
    private boolean f20296v;

    /* renamed from: w */
    private boolean f20297w;

    /* renamed from: x */
    private String f20298x;
    @VisibleForTesting

    /* renamed from: g */
    int f20283g = 1;

    /* renamed from: h */
    Map<String, Object> f20284h = new HashMap();

    /* renamed from: i */
    boolean f20285i = true;

    /* renamed from: j */
    boolean f20286j = true;

    /* renamed from: k */
    int f20287k = -1;

    /* renamed from: o */
    private final long f20289o = Utils.generateUniqueId();

    /* renamed from: q */
    private final AdRequest.Listener f20291q = new C3740a(this);

    /* renamed from: p */
    private final Runnable f20290p = new RunnableC3761b(this);

    /* renamed from: y */
    private Integer f20299y = 60000;

    /* renamed from: f */
    Handler f20282f = new Handler();

    public static void setShouldHonorServerDimensions(View view) {
        f20276n.put(view, Boolean.TRUE);
    }

    public AdViewController(Context context, MoPubView moPubView) {
        this.f20277a = context;
        this.f20278b = moPubView;
        this.f20279c = new WebViewAdUrlGenerator(this.f20277a.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(this.f20277a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2466a(AdResponse adResponse) {
        this.f20283g = 1;
        this.f20280d = adResponse;
        this.f20287k = this.f20280d.getAdTimeoutMillis() == null ? this.f20287k : this.f20280d.getAdTimeoutMillis().intValue();
        this.f20299y = this.f20280d.getRefreshTimeMillis();
        m2470a();
        MoPubView moPubView = this.f20278b;
        String customEventClassName = adResponse.getCustomEventClassName();
        Map<String, String> serverExtras = adResponse.getServerExtras();
        Preconditions.checkNotNull(serverExtras);
        if (moPubView == null) {
            MoPubLog.m2498d("Can't load an ad in this ad view because it was destroyed.");
        } else {
            moPubView.mo2396a(customEventClassName, serverExtras);
        }
        m2459c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2465a(VolleyError volleyError) {
        MoPubErrorCode moPubErrorCode;
        boolean z = volleyError instanceof MoPubNetworkError;
        if (z) {
            MoPubNetworkError moPubNetworkError = (MoPubNetworkError) volleyError;
            if (moPubNetworkError.getRefreshTimeMillis() != null) {
                this.f20299y = moPubNetworkError.getRefreshTimeMillis();
            }
        }
        Context context = this.f20277a;
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (z) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case WARMING_UP:
                    moPubErrorCode = MoPubErrorCode.WARMUP;
                    break;
                case NO_FILL:
                    moPubErrorCode = MoPubErrorCode.NO_FILL;
                    break;
                default:
                    moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                    break;
            }
        } else if (networkResponse == null) {
            if (!DeviceUtils.isNetworkAvailable(context)) {
                moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
            } else {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
        } else if (volleyError.networkResponse.statusCode >= 400) {
            moPubErrorCode = MoPubErrorCode.SERVER_ERROR;
        } else {
            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
        }
        if (moPubErrorCode == MoPubErrorCode.SERVER_ERROR) {
            this.f20283g++;
        }
        m2470a();
        m2461b(moPubErrorCode);
    }

    public MoPubView getMoPubView() {
        return this.f20278b;
    }

    public void loadAd() {
        this.f20283g = 1;
        m2457e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2457e() {
        this.f20297w = true;
        if (TextUtils.isEmpty(this.f20298x)) {
            MoPubLog.m2498d("Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
        } else if (!m2455g()) {
            MoPubLog.m2498d("Can't load an ad because there is no network connectivity.");
            m2459c();
        } else {
            m2464a(m2456f());
        }
    }

    /* renamed from: a */
    private void m2464a(String str) {
        if (str == null) {
            return;
        }
        MoPubLog.m2498d("Loading url: ".concat(String.valueOf(str)));
        if (this.f20292r) {
            if (TextUtils.isEmpty(this.f20298x)) {
                return;
            }
            MoPubLog.m2494i("Already loading an ad for " + this.f20298x + ", wait to finish.");
            return;
        }
        this.f20293s = str;
        this.f20292r = true;
        m2460b(this.f20293s);
    }

    public void reload() {
        MoPubLog.m2498d("Reload ad: " + this.f20293s);
        m2464a(this.f20293s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2467a(MoPubErrorCode moPubErrorCode) {
        this.f20292r = false;
        StringBuilder sb = new StringBuilder("MoPubErrorCode: ");
        sb.append(moPubErrorCode == null ? "" : moPubErrorCode.toString());
        Log.v("MoPub", sb.toString());
        AdResponse adResponse = this.f20280d;
        String failoverUrl = adResponse == null ? "" : adResponse.getFailoverUrl();
        if (!TextUtils.isEmpty(failoverUrl)) {
            MoPubLog.m2498d("Loading failover url: ".concat(String.valueOf(failoverUrl)));
            m2464a(failoverUrl);
            return true;
        }
        m2461b(MoPubErrorCode.NO_FILL);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2470a() {
        this.f20292r = false;
        AdRequest adRequest = this.f20288l;
        if (adRequest != null) {
            if (!adRequest.isCanceled()) {
                this.f20288l.cancel();
            }
            this.f20288l = null;
        }
    }

    public String getKeywords() {
        return this.f20294t;
    }

    public void setKeywords(String str) {
        this.f20294t = str;
    }

    public Location getLocation() {
        return this.f20295u;
    }

    public void setLocation(Location location) {
        this.f20295u = location;
    }

    public String getAdUnitId() {
        return this.f20298x;
    }

    public void setAdUnitId(String str) {
        this.f20298x = str;
    }

    public long getBroadcastIdentifier() {
        return this.f20289o;
    }

    public int getAdWidth() {
        AdResponse adResponse = this.f20280d;
        if (adResponse == null || adResponse.getWidth() == null) {
            return 0;
        }
        return this.f20280d.getWidth().intValue();
    }

    public int getAdHeight() {
        AdResponse adResponse = this.f20280d;
        if (adResponse == null || adResponse.getHeight() == null) {
            return 0;
        }
        return this.f20280d.getHeight().intValue();
    }

    public boolean getAutorefreshEnabled() {
        return this.f20285i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2463a(boolean z) {
        if (this.f20297w && this.f20285i != z) {
            String str = z ? "enabled" : "disabled";
            MoPubLog.m2498d("Refresh " + str + " for ad unit (" + this.f20298x + ").");
        }
        this.f20285i = z;
        if (this.f20297w && this.f20285i) {
            m2459c();
        } else if (this.f20285i) {
        } else {
            m2458d();
        }
    }

    public AdReport getAdReport() {
        String str = this.f20298x;
        if (str == null || this.f20280d == null) {
            return null;
        }
        return new AdReport(str, ClientMetadata.getInstance(this.f20277a), this.f20280d);
    }

    public boolean getTesting() {
        return this.f20296v;
    }

    public void setTesting(boolean z) {
        this.f20296v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m2462b() {
        AdResponse adResponse = this.f20280d;
        if (adResponse != null) {
            TrackingRequest.makeTrackingHttpRequest(adResponse.getImpressionTrackingUrl(), this.f20277a, BaseEvent.Name.IMPRESSION_REQUEST);
        }
    }

    /* renamed from: b */
    private void m2460b(String str) {
        MoPubView moPubView = getMoPubView();
        if (moPubView == null || this.f20277a == null) {
            MoPubLog.m2498d("Can't load an ad in this ad view because it was destroyed.");
            m2470a();
            return;
        }
        AdRequest adRequest = new AdRequest(str, moPubView.getAdFormat(), this.f20298x, this.f20277a, this.f20291q);
        Networking.getRequestQueue(this.f20277a).add(adRequest);
        this.f20288l = adRequest;
    }

    /* renamed from: f */
    private String m2456f() {
        WebViewAdUrlGenerator webViewAdUrlGenerator = this.f20279c;
        if (webViewAdUrlGenerator == null) {
            return null;
        }
        return webViewAdUrlGenerator.withAdUnitId(this.f20298x).withKeywords(this.f20294t).withLocation(this.f20295u).generateUrlString(Constants.HOST);
    }

    /* renamed from: b */
    private void m2461b(MoPubErrorCode moPubErrorCode) {
        MoPubLog.m2494i("Ad failed to load.");
        m2470a();
        MoPubView moPubView = getMoPubView();
        if (moPubView == null) {
            return;
        }
        m2459c();
        moPubView.mo2399a(moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m2459c() {
        Integer num;
        m2458d();
        if (!this.f20285i || (num = this.f20299y) == null || num.intValue() <= 0) {
            return;
        }
        this.f20282f.postDelayed(this.f20290p, Math.min(600000L, this.f20299y.intValue() * ((long) Math.pow(1.5d, this.f20283g))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m2458d() {
        this.f20282f.removeCallbacks(this.f20290p);
    }

    /* renamed from: g */
    private boolean m2455g() {
        Context context = this.f20277a;
        if (context == null) {
            return false;
        }
        if (DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f20277a.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ FrameLayout.LayoutParams m2468a(AdViewController adViewController, View view) {
        Integer num;
        AdResponse adResponse = adViewController.f20280d;
        Integer num2 = null;
        if (adResponse != null) {
            num2 = adResponse.getWidth();
            num = adViewController.f20280d.getHeight();
        } else {
            num = null;
        }
        if (num2 != null && num != null) {
            if ((f20276n.get(view) != null) && num2.intValue() > 0 && num.intValue() > 0) {
                return new FrameLayout.LayoutParams(Dips.asIntPixels(num2.intValue(), adViewController.f20277a), Dips.asIntPixels(num.intValue(), adViewController.f20277a), 17);
            }
        }
        return f20275m;
    }
}
