package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

/* loaded from: classes.dex */
public class VastVideoRadialCountdownWidget extends ImageView {

    /* renamed from: a */
    RadialCountdownDrawable f20448a;

    /* renamed from: b */
    int f20449b;

    public VastVideoRadialCountdownWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(5.0f, context);
        this.f20448a = new RadialCountdownDrawable(context);
        setImageDrawable(this.f20448a);
        setPadding(dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels2, dipsToIntPixels3, 0);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    @VisibleForTesting
    @Deprecated
    RadialCountdownDrawable getImageViewDrawable() {
        return this.f20448a;
    }

    @VisibleForTesting
    @Deprecated
    void setImageViewDrawable(RadialCountdownDrawable radialCountdownDrawable) {
        this.f20448a = radialCountdownDrawable;
    }
}
