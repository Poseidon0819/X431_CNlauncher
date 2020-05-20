package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class NativeAd {

    /* renamed from: a */
    final Context f20910a;

    /* renamed from: b */
    final Set<String> f20911b = new HashSet();

    /* renamed from: c */
    final Set<String> f20912c;

    /* renamed from: d */
    MoPubNativeEventListener f20913d;

    /* renamed from: e */
    boolean f20914e;

    /* renamed from: f */
    boolean f20915f;

    /* renamed from: g */
    boolean f20916g;

    /* renamed from: h */
    private final BaseNativeAd f20917h;

    /* renamed from: i */
    private final MoPubAdRenderer f20918i;

    /* renamed from: j */
    private final String f20919j;

    /* loaded from: classes2.dex */
    public interface MoPubNativeEventListener {
        void onClick(View view);

        void onImpression(View view);
    }

    public NativeAd(Context context, String str, String str2, String str3, BaseNativeAd baseNativeAd, MoPubAdRenderer moPubAdRenderer) {
        this.f20910a = context.getApplicationContext();
        this.f20919j = str3;
        this.f20911b.add(str);
        this.f20911b.addAll(new HashSet(baseNativeAd.f20752a));
        this.f20912c = new HashSet();
        this.f20912c.add(str2);
        this.f20912c.addAll(baseNativeAd.m2203b());
        this.f20917h = baseNativeAd;
        this.f20917h.setNativeEventListener(new C3861ae(this));
        this.f20918i = moPubAdRenderer;
    }

    public String toString() {
        return "\nimpressionTrackers:" + this.f20911b + "\nclickTrackers:" + this.f20912c + "\nrecordedImpression:" + this.f20914e + "\nisClicked:" + this.f20915f + "\nisDestroyed:" + this.f20916g + "\n";
    }

    public void setMoPubNativeEventListener(MoPubNativeEventListener moPubNativeEventListener) {
        this.f20913d = moPubNativeEventListener;
    }

    public String getAdUnitId() {
        return this.f20919j;
    }

    public boolean isDestroyed() {
        return this.f20916g;
    }

    public BaseNativeAd getBaseNativeAd() {
        return this.f20917h;
    }

    public View createAdView(Context context, ViewGroup viewGroup) {
        return this.f20918i.createAdView(context, viewGroup);
    }

    public void renderAdView(View view) {
        this.f20918i.renderAdView(view, this.f20917h);
    }

    public MoPubAdRenderer getMoPubAdRenderer() {
        return this.f20918i;
    }

    public void prepare(View view) {
        if (this.f20916g) {
            return;
        }
        this.f20917h.prepare(view);
    }

    public void clear(View view) {
        if (this.f20916g) {
            return;
        }
        this.f20917h.clear(view);
    }

    public void destroy() {
        if (this.f20916g) {
            return;
        }
        this.f20917h.destroy();
        this.f20916g = true;
    }
}
