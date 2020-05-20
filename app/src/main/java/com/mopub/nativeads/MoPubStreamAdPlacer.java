package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class MoPubStreamAdPlacer {
    public static final int CONTENT_VIEW_TYPE = 0;

    /* renamed from: e */
    private static final MoPubNativeAdLoadedListener f20889e = new C3857aa();

    /* renamed from: a */
    boolean f20890a;

    /* renamed from: b */
    PlacementData f20891b;

    /* renamed from: c */
    boolean f20892c;

    /* renamed from: d */
    boolean f20893d;

    /* renamed from: f */
    private final Activity f20894f;

    /* renamed from: g */
    private final Handler f20895g;

    /* renamed from: h */
    private final Runnable f20896h;

    /* renamed from: i */
    private final PositioningSource f20897i;

    /* renamed from: j */
    private final NativeAdSource f20898j;

    /* renamed from: k */
    private final HashMap<NativeAd, WeakReference<View>> f20899k;

    /* renamed from: l */
    private final WeakHashMap<View, NativeAd> f20900l;

    /* renamed from: m */
    private PlacementData f20901m;

    /* renamed from: n */
    private String f20902n;

    /* renamed from: o */
    private MoPubNativeAdLoadedListener f20903o;

    /* renamed from: p */
    private int f20904p;

    /* renamed from: q */
    private int f20905q;

    /* renamed from: r */
    private int f20906r;

    /* renamed from: s */
    private boolean f20907s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m2127c(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        moPubStreamAdPlacer.f20907s = false;
        return false;
    }

    public MoPubStreamAdPlacer(Activity activity) {
        this(activity, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(Activity activity, MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(activity, new NativeAdSource(), new ServerPositioningSource(activity));
    }

    public MoPubStreamAdPlacer(Activity activity, MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(activity, new NativeAdSource(), new ClientPositioningSource(moPubClientPositioning));
    }

    @VisibleForTesting
    private MoPubStreamAdPlacer(Activity activity, NativeAdSource nativeAdSource, PositioningSource positioningSource) {
        this.f20903o = f20889e;
        Preconditions.checkNotNull(activity, "activity is not allowed to be null");
        Preconditions.checkNotNull(nativeAdSource, "adSource is not allowed to be null");
        Preconditions.checkNotNull(positioningSource, "positioningSource is not allowed to be null");
        this.f20894f = activity;
        this.f20897i = positioningSource;
        this.f20898j = nativeAdSource;
        this.f20901m = new PlacementData(new int[0]);
        this.f20900l = new WeakHashMap<>();
        this.f20899k = new HashMap<>();
        this.f20895g = new Handler();
        this.f20896h = new RunnableC3858ab(this);
        this.f20904p = 0;
        this.f20905q = 0;
    }

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            NativeAdSource nativeAdSource = this.f20898j;
            nativeAdSource.f21057j.registerAdRenderer(moPubAdRenderer);
            if (nativeAdSource.f21056i != null) {
                nativeAdSource.f21056i.registerAdRenderer(moPubAdRenderer);
            }
        }
    }

    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f20898j.getAdRendererForViewType(i);
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        if (moPubNativeAdLoadedListener == null) {
            moPubNativeAdLoadedListener = f20889e;
        }
        this.f20903o = moPubNativeAdLoadedListener;
    }

    public void loadAds(String str) {
        loadAds(str, null);
    }

    public void loadAds(String str, RequestParameters requestParameters) {
        if (Preconditions.NoThrow.checkNotNull(str, "Cannot load ads with a null ad unit ID")) {
            if (this.f20898j.f21057j.getAdRendererCount() == 0) {
                MoPubLog.m2490w("You must register at least 1 ad renderer by calling registerAdRenderer before loading ads");
                return;
            }
            this.f20902n = str;
            this.f20893d = false;
            this.f20890a = false;
            this.f20892c = false;
            this.f20897i.loadPositions(str, new C3859ac(this));
            this.f20898j.f21054g = new C3860ad(this);
            NativeAdSource nativeAdSource = this.f20898j;
            MoPubNative moPubNative = new MoPubNative(this.f20894f, str, nativeAdSource.f21049b);
            nativeAdSource.m2092a();
            for (MoPubAdRenderer moPubAdRenderer : nativeAdSource.f21057j.getRendererIterable()) {
                moPubNative.registerAdRenderer(moPubAdRenderer);
            }
            nativeAdSource.f21055h = requestParameters;
            nativeAdSource.f21056i = moPubNative;
            nativeAdSource.m2088c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2130a(PlacementData placementData) {
        removeAdsInRange(0, this.f20906r);
        this.f20901m = placementData;
        m2129b();
        this.f20893d = true;
    }

    public void placeAdsInRange(int i, int i2) {
        this.f20904p = i;
        this.f20905q = Math.min(i2, i + 100);
        m2135a();
    }

    public boolean isAd(int i) {
        PlacementData placementData = this.f20901m;
        return PlacementData.m2078a(placementData.f21085a, placementData.f21086b, i) >= 0;
    }

    public void clearAds() {
        removeAdsInRange(0, this.f20906r);
        this.f20898j.m2092a();
    }

    public void destroy() {
        this.f20895g.removeMessages(0);
        this.f20898j.m2092a();
        PlacementData placementData = this.f20901m;
        if (placementData.f21086b != 0) {
            placementData.m2080a(0, placementData.f21085a[placementData.f21086b - 1] + 1);
        }
    }

    public Object getAdData(int i) {
        return this.f20901m.m2075c(i);
    }

    public View getAdView(int i, View view, ViewGroup viewGroup) {
        NativeAd m2075c = this.f20901m.m2075c(i);
        if (m2075c == null) {
            return null;
        }
        if (view == null) {
            view = m2075c.createAdView(this.f20894f, viewGroup);
        }
        bindAdView(m2075c, view);
        return view;
    }

    public void bindAdView(NativeAd nativeAd, View view) {
        WeakReference<View> weakReference = this.f20899k.get(nativeAd);
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view.equals(view2)) {
            return;
        }
        m2132a(view2);
        m2132a(view);
        this.f20899k.put(nativeAd, new WeakReference<>(view));
        this.f20900l.put(view, nativeAd);
        nativeAd.prepare(view);
        nativeAd.renderAdView(view);
    }

    public int removeAdsInRange(int i, int i2) {
        PlacementData placementData = this.f20901m;
        int[] iArr = new int[placementData.f21086b];
        System.arraycopy(placementData.f21085a, 0, iArr, 0, placementData.f21086b);
        int m2072e = this.f20901m.m2072e(i);
        int m2072e2 = this.f20901m.m2072e(i2);
        ArrayList arrayList = new ArrayList();
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i3 = iArr[length];
            if (i3 >= m2072e && i3 < m2072e2) {
                arrayList.add(Integer.valueOf(i3));
                int i4 = this.f20904p;
                if (i3 < i4) {
                    this.f20904p = i4 - 1;
                }
                this.f20906r--;
            }
        }
        int m2080a = this.f20901m.m2080a(m2072e, m2072e2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f20903o.onAdRemoved(((Integer) it.next()).intValue());
        }
        return m2080a;
    }

    public int getAdViewTypeCount() {
        return this.f20898j.f21057j.getAdRendererCount();
    }

    public int getAdViewType(int i) {
        NativeAd m2075c = this.f20901m.m2075c(i);
        if (m2075c == null) {
            return 0;
        }
        return this.f20898j.getViewTypeForAd(m2075c);
    }

    public int getOriginalPosition(int i) {
        return this.f20901m.m2073d(i);
    }

    public int getAdjustedPosition(int i) {
        return this.f20901m.m2072e(i);
    }

    public int getOriginalCount(int i) {
        PlacementData placementData = this.f20901m;
        if (i == 0) {
            return 0;
        }
        int m2073d = placementData.m2073d(i - 1);
        if (m2073d == -1) {
            return -1;
        }
        return m2073d + 1;
    }

    public int getAdjustedCount(int i) {
        return this.f20901m.m2071f(i);
    }

    public void setItemCount(int i) {
        this.f20906r = this.f20901m.m2071f(i);
        if (this.f20893d) {
            m2135a();
        }
    }

    public void insertItem(int i) {
        this.f20901m.m2070g(i);
    }

    public void removeItem(int i) {
        this.f20901m.m2069h(i);
    }

    public void moveItem(int i, int i2) {
        PlacementData placementData = this.f20901m;
        placementData.m2069h(i);
        placementData.m2070g(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2135a() {
        if (this.f20907s) {
            return;
        }
        this.f20907s = true;
        this.f20895g.post(this.f20896h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2129b() {
        if (m2133a(this.f20904p, this.f20905q)) {
            int i = this.f20905q;
            m2133a(i, i + 6);
        }
    }

    /* renamed from: a */
    private boolean m2133a(int i, int i2) {
        int i3 = i2 - 1;
        while (i <= i3 && i != -1 && i < this.f20906r) {
            if (this.f20901m.m2081a(i)) {
                if (!m2134a(i)) {
                    return false;
                }
                i3++;
            }
            i = this.f20901m.m2077b(i);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2134a(int i) {
        NativeAd m2090b = this.f20898j.m2090b();
        if (m2090b == null) {
            return false;
        }
        this.f20901m.m2079a(i, m2090b);
        this.f20906r++;
        this.f20903o.onAdLoaded(i);
        return true;
    }

    /* renamed from: a */
    private void m2132a(View view) {
        NativeAd nativeAd;
        if (view == null || (nativeAd = this.f20900l.get(view)) == null) {
            return;
        }
        nativeAd.clear(view);
        this.f20900l.remove(view);
        this.f20899k.remove(nativeAd);
    }
}
