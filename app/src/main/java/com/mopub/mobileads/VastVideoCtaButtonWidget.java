package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;

/* loaded from: classes.dex */
public class VastVideoCtaButtonWidget extends ImageView {

    /* renamed from: a */
    CtaButtonDrawable f20430a;

    /* renamed from: b */
    boolean f20431b;

    /* renamed from: c */
    boolean f20432c;

    /* renamed from: d */
    private final RelativeLayout.LayoutParams f20433d;

    /* renamed from: e */
    private final RelativeLayout.LayoutParams f20434e;

    /* renamed from: f */
    private boolean f20435f;

    /* renamed from: g */
    private boolean f20436g;

    /* renamed from: h */
    private boolean f20437h;

    public VastVideoCtaButtonWidget(Context context, int i, boolean z, boolean z2) {
        super(context);
        this.f20435f = z;
        this.f20436g = z2;
        this.f20437h = false;
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(150.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(38.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        this.f20430a = new CtaButtonDrawable(context);
        setImageDrawable(this.f20430a);
        this.f20433d = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.f20433d.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.f20433d.addRule(8, i);
        this.f20433d.addRule(7, i);
        this.f20434e = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.f20434e.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.f20434e.addRule(12);
        this.f20434e.addRule(11);
        m2371a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2371a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHasSocialActions(boolean z) {
        this.f20437h = z;
    }

    boolean getHasSocialActions() {
        return this.f20437h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2371a() {
        if (!this.f20436g) {
            setVisibility(8);
        } else if (!this.f20431b) {
            setVisibility(4);
        } else if (this.f20432c && this.f20435f && !this.f20437h) {
            setVisibility(8);
        } else {
            switch (getResources().getConfiguration().orientation) {
                case 0:
                    MoPubLog.m2498d("Screen orientation undefined: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.f20434e);
                    break;
                case 1:
                    setLayoutParams(this.f20434e);
                    break;
                case 2:
                    setLayoutParams(this.f20433d);
                    break;
                case 3:
                    MoPubLog.m2498d("Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.f20434e);
                    break;
                default:
                    MoPubLog.m2498d("Unrecognized screen orientation: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.f20434e);
                    break;
            }
            setVisibility(0);
        }
    }

    @VisibleForTesting
    @Deprecated
    String getCtaText() {
        return this.f20430a.getCtaText();
    }
}
