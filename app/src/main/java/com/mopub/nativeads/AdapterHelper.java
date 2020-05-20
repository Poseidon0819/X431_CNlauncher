package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

@Deprecated
/* loaded from: classes2.dex */
public final class AdapterHelper {

    /* renamed from: a */
    private final WeakReference<Context> f20748a;

    /* renamed from: b */
    private final Context f20749b;

    /* renamed from: c */
    private final int f20750c;

    /* renamed from: d */
    private final int f20751d;

    @Deprecated
    public AdapterHelper(Context context, int i, int i2) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkArgument(i >= 0, "start position must be non-negative");
        Preconditions.checkArgument(i2 >= 2, "interval must be at least 2");
        this.f20748a = new WeakReference<>(context);
        this.f20749b = context.getApplicationContext();
        this.f20750c = i;
        this.f20751d = i2;
    }

    @Deprecated
    public final View getAdView(View view, ViewGroup viewGroup, NativeAd nativeAd, ViewBinder viewBinder) {
        Context context = this.f20748a.get();
        if (context == null) {
            MoPubLog.m2490w("Weak reference to Context in AdapterHelper became null. Returning empty view.");
            return new View(this.f20749b);
        }
        return NativeAdViewHelper.m2084a(view, viewGroup, context, nativeAd);
    }

    @Deprecated
    public final View getAdView(View view, ViewGroup viewGroup, NativeAd nativeAd) {
        return getAdView(view, viewGroup, nativeAd, null);
    }

    @Deprecated
    public final boolean isAdPosition(int i) {
        int i2 = this.f20750c;
        return i >= i2 && (i - i2) % this.f20751d == 0;
    }

    @Deprecated
    public final int shiftedCount(int i) {
        int floor;
        int i2 = this.f20750c;
        if (i <= i2) {
            floor = 0;
        } else {
            int i3 = this.f20751d - 1;
            if ((i - i2) % i3 == 0) {
                floor = (i - i2) / i3;
            } else {
                double d = i - i2;
                double d2 = i3;
                Double.isNaN(d);
                Double.isNaN(d2);
                floor = ((int) Math.floor(d / d2)) + 1;
            }
        }
        return i + floor;
    }

    @Deprecated
    public final int shiftedPosition(int i) {
        int floor;
        int i2 = this.f20750c;
        if (i <= i2) {
            floor = 0;
        } else {
            double d = i - i2;
            double d2 = this.f20751d;
            Double.isNaN(d);
            Double.isNaN(d2);
            floor = ((int) Math.floor(d / d2)) + 1;
        }
        return i - floor;
    }
}
