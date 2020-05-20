package com.mopub.nativeads;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNative;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.af */
/* loaded from: classes2.dex */
public final class NativeAdSource {
    @VisibleForTesting

    /* renamed from: a */
    static final int[] f21048a = {1000, SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY, UIMsg.m_AppUI.MSG_APP_GPS, 25000, 60000, 300000};

    /* renamed from: b */
    final MoPubNative.MoPubNativeNetworkListener f21049b;
    @VisibleForTesting

    /* renamed from: c */
    boolean f21050c;
    @VisibleForTesting

    /* renamed from: d */
    boolean f21051d;
    @VisibleForTesting

    /* renamed from: e */
    int f21052e;
    @VisibleForTesting

    /* renamed from: f */
    int f21053f;

    /* renamed from: g */
    InterfaceC3862a f21054g;

    /* renamed from: h */
    RequestParameters f21055h;

    /* renamed from: i */
    MoPubNative f21056i;

    /* renamed from: j */
    final AdRendererRegistry f21057j;

    /* renamed from: k */
    private final List<TimestampWrapper<NativeAd>> f21058k;

    /* renamed from: l */
    private final Handler f21059l;

    /* renamed from: m */
    private final Runnable f21060m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NativeAdSource.java */
    /* renamed from: com.mopub.nativeads.af$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3862a {
        void onAdsAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAdSource() {
        this(new ArrayList(1), new Handler(), new AdRendererRegistry());
    }

    @VisibleForTesting
    private NativeAdSource(List<TimestampWrapper<NativeAd>> list, Handler handler, AdRendererRegistry adRendererRegistry) {
        this.f21058k = list;
        this.f21059l = handler;
        this.f21060m = new RunnableC3863ag(this);
        this.f21057j = adRendererRegistry;
        this.f21049b = new C3864ah(this);
        this.f21052e = 0;
        this.f21053f = 0;
    }

    public final int getViewTypeForAd(NativeAd nativeAd) {
        return this.f21057j.getViewTypeForAd(nativeAd);
    }

    public final MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f21057j.getRendererForViewType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2092a() {
        MoPubNative moPubNative = this.f21056i;
        if (moPubNative != null) {
            moPubNative.destroy();
            this.f21056i = null;
        }
        this.f21055h = null;
        for (TimestampWrapper<NativeAd> timestampWrapper : this.f21058k) {
            timestampWrapper.f21119a.destroy();
        }
        this.f21058k.clear();
        this.f21059l.removeMessages(0);
        this.f21050c = false;
        this.f21052e = 0;
        this.f21053f = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final NativeAd m2090b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!this.f21050c && !this.f21051d) {
            this.f21059l.post(this.f21060m);
        }
        while (!this.f21058k.isEmpty()) {
            TimestampWrapper<NativeAd> remove = this.f21058k.remove(0);
            if (uptimeMillis - remove.f21120b < 900000) {
                return remove.f21119a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public final void m2088c() {
        if (this.f21050c || this.f21056i == null || this.f21058k.size() > 0) {
            return;
        }
        this.f21050c = true;
        this.f21056i.makeRequest(this.f21055h, Integer.valueOf(this.f21052e));
    }
}
