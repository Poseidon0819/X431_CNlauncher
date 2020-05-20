package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;
import com.mopub.network.Networking;
import com.mopub.volley.toolbox.ImageLoader;

/* loaded from: classes.dex */
public class VastVideoCloseButtonWidget extends RelativeLayout {

    /* renamed from: a */
    TextView f20422a;

    /* renamed from: b */
    final ImageLoader f20423b;

    /* renamed from: c */
    private ImageView f20424c;

    /* renamed from: d */
    private CloseButtonDrawable f20425d;

    /* renamed from: e */
    private final int f20426e;

    /* renamed from: f */
    private final int f20427f;

    /* renamed from: g */
    private final int f20428g;

    /* renamed from: h */
    private final int f20429h;

    public VastVideoCloseButtonWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f20426e = Dips.dipsToIntPixels(16.0f, context);
        this.f20428g = Dips.dipsToIntPixels(5.0f, context);
        this.f20429h = Dips.dipsToIntPixels(46.0f, context);
        this.f20427f = Dips.dipsToIntPixels(7.0f, context);
        this.f20425d = new CloseButtonDrawable();
        this.f20423b = Networking.getImageLoader(context);
        this.f20424c = new ImageView(getContext());
        this.f20424c.setId((int) Utils.generateUniqueId());
        int i = this.f20429h;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11);
        this.f20424c.setImageDrawable(this.f20425d);
        ImageView imageView = this.f20424c;
        int i2 = this.f20428g;
        int i3 = this.f20426e;
        imageView.setPadding(i2, i2 + i3, i3 + i2, i2);
        addView(this.f20424c, layoutParams);
        this.f20422a = new TextView(getContext());
        this.f20422a.setSingleLine();
        this.f20422a.setEllipsize(TextUtils.TruncateAt.END);
        this.f20422a.setTextColor(-1);
        this.f20422a.setTextSize(20.0f);
        this.f20422a.setTypeface(DrawableConstants.CloseButton.TEXT_TYPEFACE);
        this.f20422a.setText("");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f20424c.getId());
        this.f20422a.setPadding(0, this.f20426e, 0, 0);
        layoutParams2.setMargins(0, 0, this.f20427f, 0);
        addView(this.f20422a, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, this.f20429h);
        layoutParams3.addRule(11);
        setLayoutParams(layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnTouchListenerToContent(View.OnTouchListener onTouchListener) {
        this.f20424c.setOnTouchListener(onTouchListener);
        this.f20422a.setOnTouchListener(onTouchListener);
    }

    @VisibleForTesting
    @Deprecated
    ImageView getImageView() {
        return this.f20424c;
    }

    @VisibleForTesting
    @Deprecated
    void setImageView(ImageView imageView) {
        this.f20424c = imageView;
    }

    @VisibleForTesting
    @Deprecated
    TextView getTextView() {
        return this.f20422a;
    }
}
