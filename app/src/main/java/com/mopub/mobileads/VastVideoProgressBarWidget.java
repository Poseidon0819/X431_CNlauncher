package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;

/* loaded from: classes.dex */
public class VastVideoProgressBarWidget extends ImageView {

    /* renamed from: a */
    private ProgressBarDrawable f20446a;

    /* renamed from: b */
    private final int f20447b;

    public VastVideoProgressBarWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f20446a = new ProgressBarDrawable(context);
        setImageDrawable(this.f20446a);
        this.f20447b = Dips.dipsToIntPixels(4.0f, context);
    }

    public void setAnchorId(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f20447b);
        layoutParams.addRule(8, i);
        setLayoutParams(layoutParams);
    }

    public void calibrateAndMakeVisible(int i, int i2) {
        this.f20446a.setDurationAndSkipOffset(i, i2);
        setVisibility(0);
    }

    public void updateProgress(int i) {
        this.f20446a.setProgress(i);
    }

    public void reset() {
        this.f20446a.reset();
        this.f20446a.setProgress(0);
    }

    @VisibleForTesting
    @Deprecated
    ProgressBarDrawable getImageViewDrawable() {
        return this.f20446a;
    }

    @VisibleForTesting
    @Deprecated
    void setImageViewDrawable(ProgressBarDrawable progressBarDrawable) {
        this.f20446a = progressBarDrawable;
    }
}
