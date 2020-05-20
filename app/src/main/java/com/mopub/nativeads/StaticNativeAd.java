package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class StaticNativeAd extends BaseNativeAd implements ClickInterface, ImpressionInterface {

    /* renamed from: c */
    private String f21004c;

    /* renamed from: d */
    private String f21005d;

    /* renamed from: e */
    private String f21006e;

    /* renamed from: f */
    private String f21007f;

    /* renamed from: g */
    private String f21008g;

    /* renamed from: h */
    private String f21009h;

    /* renamed from: i */
    private Double f21010i;

    /* renamed from: j */
    private String f21011j;

    /* renamed from: k */
    private String f21012k;

    /* renamed from: l */
    private boolean f21013l;

    /* renamed from: m */
    private int f21014m = 1000;

    /* renamed from: n */
    private final Map<String, Object> f21015n = new HashMap();

    @Override // com.mopub.nativeads.BaseNativeAd
    public void clear(View view) {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void destroy() {
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return 50;
    }

    public void handleClick(View view) {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void prepare(View view) {
    }

    public void recordImpression(View view) {
    }

    public final String getTitle() {
        return this.f21008g;
    }

    public final String getText() {
        return this.f21009h;
    }

    public final String getMainImageUrl() {
        return this.f21004c;
    }

    public final String getIconImageUrl() {
        return this.f21005d;
    }

    public final String getCallToAction() {
        return this.f21007f;
    }

    public final Double getStarRating() {
        return this.f21010i;
    }

    public final String getPrivacyInformationIconClickThroughUrl() {
        return this.f21011j;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.f21012k;
    }

    public final Object getExtra(String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "getExtra key is not allowed to be null")) {
            return this.f21015n.get(str);
        }
        return null;
    }

    public final Map<String, Object> getExtras() {
        return new HashMap(this.f21015n);
    }

    public final String getClickDestinationUrl() {
        return this.f21006e;
    }

    public final void setMainImageUrl(String str) {
        this.f21004c = str;
    }

    public final void setIconImageUrl(String str) {
        this.f21005d = str;
    }

    public final void setClickDestinationUrl(String str) {
        this.f21006e = str;
    }

    public final void setCallToAction(String str) {
        this.f21007f = str;
    }

    public final void setTitle(String str) {
        this.f21008g = str;
    }

    public final void setText(String str) {
        this.f21009h = str;
    }

    public final void setStarRating(Double d) {
        if (d == null) {
            this.f21010i = null;
        } else if (d.doubleValue() >= 0.0d && d.doubleValue() <= 5.0d) {
            this.f21010i = d;
        } else {
            MoPubLog.m2498d("Ignoring attempt to set invalid star rating (" + d + "). Must be between 0.0 and 5.0.");
        }
    }

    public final void setPrivacyInformationIconClickThroughUrl(String str) {
        this.f21011j = str;
    }

    public final void setPrivacyInformationIconImageUrl(String str) {
        this.f21012k = str;
    }

    public final void addExtra(String str, Object obj) {
        if (Preconditions.NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.f21015n.put(str, obj);
        }
    }

    public final void setImpressionMinTimeViewed(int i) {
        if (i >= 0) {
            this.f21014m = i;
        }
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.f21014m;
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.f21013l;
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final void setImpressionRecorded() {
        this.f21013l = true;
    }
}
