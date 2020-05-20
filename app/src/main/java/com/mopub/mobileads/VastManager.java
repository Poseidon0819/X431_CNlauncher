package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.mobileads.VastXmlManagerAggregator;

/* loaded from: classes.dex */
public class VastManager implements VastXmlManagerAggregator.InterfaceC3737b {

    /* renamed from: a */
    private VastManagerListener f20410a;

    /* renamed from: b */
    private VastXmlManagerAggregator f20411b;

    /* renamed from: c */
    private String f20412c;

    /* renamed from: d */
    private double f20413d;

    /* renamed from: e */
    private int f20414e;

    /* renamed from: f */
    private final boolean f20415f;

    /* loaded from: classes.dex */
    public interface VastManagerListener {
        void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig);
    }

    public VastManager(Context context, boolean z) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        float f = context.getResources().getDisplayMetrics().density;
        f = f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 1.0f : f;
        int max = Math.max(width, height);
        int min = Math.min(width, height);
        double d = max;
        double d2 = min;
        Double.isNaN(d);
        Double.isNaN(d2);
        this.f20413d = d / d2;
        this.f20414e = (int) ((max / f) * (min / f));
        this.f20415f = z;
    }

    public void prepareVastVideoConfiguration(String str, VastManagerListener vastManagerListener, String str2, Context context) {
        Preconditions.checkNotNull(vastManagerListener, "vastManagerListener cannot be null");
        Preconditions.checkNotNull(context, "context cannot be null");
        if (this.f20411b == null) {
            this.f20410a = vastManagerListener;
            this.f20411b = new VastXmlManagerAggregator(this, this.f20413d, this.f20414e, context.getApplicationContext());
            this.f20412c = str2;
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f20411b, str);
            } catch (Exception e) {
                MoPubLog.m2497d("Failed to aggregate vast xml", e);
                this.f20410a.onVastVideoConfigurationPrepared(null);
            }
        }
    }

    public void cancel() {
        VastXmlManagerAggregator vastXmlManagerAggregator = this.f20411b;
        if (vastXmlManagerAggregator != null) {
            vastXmlManagerAggregator.cancel(true);
            this.f20411b = null;
        }
    }

    @Override // com.mopub.mobileads.VastXmlManagerAggregator.InterfaceC3737b
    public void onAggregationComplete(VastVideoConfig vastVideoConfig) {
        VastManagerListener vastManagerListener = this.f20410a;
        if (vastManagerListener == null) {
            throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
        }
        if (vastVideoConfig == null) {
            vastManagerListener.onVastVideoConfigurationPrepared(null);
            return;
        }
        if (!TextUtils.isEmpty(this.f20412c)) {
            vastVideoConfig.setDspCreativeId(this.f20412c);
        }
        if (!this.f20415f || m2378b(vastVideoConfig)) {
            this.f20410a.onVastVideoConfigurationPrepared(vastVideoConfig);
            return;
        }
        VideoDownloader.cache(vastVideoConfig.getNetworkMediaFileUrl(), new C3751ar(this, vastVideoConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2378b(VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        String networkMediaFileUrl = vastVideoConfig.getNetworkMediaFileUrl();
        if (CacheService.containsKeyDiskCache(networkMediaFileUrl)) {
            vastVideoConfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(networkMediaFileUrl));
            return true;
        }
        return false;
    }
}
