package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;

/* loaded from: classes.dex */
public class VastVideoGradientStripWidget extends ImageView {

    /* renamed from: a */
    DeviceUtils.ForceOrientation f20438a;

    /* renamed from: b */
    private int f20439b;

    /* renamed from: c */
    private boolean f20440c;

    /* renamed from: d */
    private boolean f20441d;

    public VastVideoGradientStripWidget(Context context, GradientDrawable.Orientation orientation, DeviceUtils.ForceOrientation forceOrientation, boolean z, int i, int i2, int i3) {
        super(context);
        this.f20438a = forceOrientation;
        this.f20439b = i;
        this.f20440c = z;
        setImageDrawable(new GradientDrawable(orientation, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(72.0f, context));
        layoutParams.addRule(i2, i3);
        setLayoutParams(layoutParams);
        m2369b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2370a() {
        this.f20441d = true;
        m2369b();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2369b();
    }

    /* renamed from: b */
    private void m2369b() {
        if (this.f20441d) {
            if (this.f20440c) {
                setVisibility(this.f20439b);
            } else {
                setVisibility(8);
            }
        } else if (this.f20438a == DeviceUtils.ForceOrientation.FORCE_PORTRAIT) {
            setVisibility(4);
        } else if (this.f20438a == DeviceUtils.ForceOrientation.FORCE_LANDSCAPE) {
            setVisibility(0);
        } else {
            switch (getResources().getConfiguration().orientation) {
                case 0:
                    MoPubLog.m2498d("Screen orientation undefined: do not show gradient strip widget");
                    setVisibility(4);
                    return;
                case 1:
                    setVisibility(4);
                    return;
                case 2:
                    setVisibility(0);
                    return;
                case 3:
                    MoPubLog.m2498d("Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget");
                    setVisibility(4);
                    return;
                default:
                    MoPubLog.m2498d("Unrecognized screen orientation: do not show gradient strip widget");
                    setVisibility(4);
                    return;
            }
        }
    }
}
