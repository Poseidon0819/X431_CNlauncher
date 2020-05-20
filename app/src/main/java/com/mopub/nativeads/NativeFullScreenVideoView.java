package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CtaButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;

@TargetApi(16)
/* loaded from: classes2.dex */
public class NativeFullScreenVideoView extends RelativeLayout {
    @VisibleForTesting

    /* renamed from: a */
    Mode f20924a;
    @VisibleForTesting

    /* renamed from: b */
    final int f20925b;
    @VisibleForTesting

    /* renamed from: c */
    final int f20926c;
    @VisibleForTesting

    /* renamed from: d */
    final int f20927d;
    @VisibleForTesting

    /* renamed from: e */
    final int f20928e;
    @VisibleForTesting

    /* renamed from: f */
    final int f20929f;
    @VisibleForTesting

    /* renamed from: g */
    final int f20930g;
    @VisibleForTesting

    /* renamed from: h */
    final int f20931h;
    @VisibleForTesting

    /* renamed from: i */
    final int f20932i;

    /* renamed from: j */
    private int f20933j;

    /* renamed from: k */
    private final ImageView f20934k;

    /* renamed from: l */
    private final TextureView f20935l;

    /* renamed from: m */
    private final ProgressBar f20936m;

    /* renamed from: n */
    private final ImageView f20937n;

    /* renamed from: o */
    private final ImageView f20938o;

    /* renamed from: p */
    private final VastVideoProgressBarWidget f20939p;

    /* renamed from: q */
    private final View f20940q;

    /* renamed from: r */
    private final ImageView f20941r;

    /* renamed from: s */
    private final ImageView f20942s;

    /* renamed from: t */
    private final ImageView f20943t;

    /* renamed from: u */
    private final ImageView f20944u;

    /* loaded from: classes2.dex */
    public enum Mode {
        LOADING,
        PLAYING,
        PAUSED,
        FINISHED
    }

    public NativeFullScreenVideoView(Context context, int i, String str) {
        this(context, i, str, new ImageView(context), new TextureView(context), new ProgressBar(context), new ImageView(context), new ImageView(context), new VastVideoProgressBarWidget(context), new View(context), new ImageView(context), new ImageView(context), new ImageView(context), new ImageView(context));
    }

    @VisibleForTesting
    private NativeFullScreenVideoView(Context context, int i, String str, ImageView imageView, TextureView textureView, ProgressBar progressBar, ImageView imageView2, ImageView imageView3, VastVideoProgressBarWidget vastVideoProgressBarWidget, View view, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7) {
        super(context);
        ImageView imageView8;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(imageView);
        Preconditions.checkNotNull(textureView);
        Preconditions.checkNotNull(progressBar);
        Preconditions.checkNotNull(imageView2);
        Preconditions.checkNotNull(imageView3);
        Preconditions.checkNotNull(vastVideoProgressBarWidget);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(imageView4);
        Preconditions.checkNotNull(imageView5);
        Preconditions.checkNotNull(imageView6);
        Preconditions.checkNotNull(imageView7);
        this.f20933j = i;
        this.f20924a = Mode.LOADING;
        this.f20925b = Dips.asIntPixels(200.0f, context);
        this.f20926c = Dips.asIntPixels(42.0f, context);
        this.f20927d = Dips.asIntPixels(10.0f, context);
        this.f20928e = Dips.asIntPixels(50.0f, context);
        this.f20929f = Dips.asIntPixels(8.0f, context);
        this.f20930g = Dips.asIntPixels(44.0f, context);
        this.f20931h = Dips.asIntPixels(50.0f, context);
        this.f20932i = Dips.asIntPixels(45.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f20935l = textureView;
        this.f20935l.setId((int) Utils.generateUniqueId());
        this.f20935l.setLayoutParams(layoutParams);
        addView(this.f20935l);
        this.f20934k = imageView;
        this.f20934k.setId((int) Utils.generateUniqueId());
        this.f20934k.setLayoutParams(layoutParams);
        this.f20934k.setBackgroundColor(0);
        addView(this.f20934k);
        int i2 = this.f20931h;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(13);
        this.f20936m = progressBar;
        this.f20936m.setId((int) Utils.generateUniqueId());
        this.f20936m.setBackground(new C3851a(context));
        this.f20936m.setLayoutParams(layoutParams2);
        this.f20936m.setIndeterminate(true);
        addView(this.f20936m);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f20932i);
        layoutParams3.addRule(8, this.f20935l.getId());
        this.f20937n = imageView2;
        this.f20937n.setId((int) Utils.generateUniqueId());
        this.f20937n.setLayoutParams(layoutParams3);
        this.f20937n.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f20937n);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.f20932i);
        layoutParams4.addRule(10);
        this.f20938o = imageView3;
        this.f20938o.setId((int) Utils.generateUniqueId());
        this.f20938o.setLayoutParams(layoutParams4);
        this.f20938o.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f20938o);
        this.f20939p = vastVideoProgressBarWidget;
        this.f20939p.setId((int) Utils.generateUniqueId());
        this.f20939p.setAnchorId(this.f20935l.getId());
        this.f20939p.calibrateAndMakeVisible(1000, 0);
        addView(this.f20939p);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(13);
        this.f20940q = view;
        this.f20940q.setId((int) Utils.generateUniqueId());
        this.f20940q.setLayoutParams(layoutParams5);
        this.f20940q.setBackgroundColor(DrawableConstants.TRANSPARENT_GRAY);
        addView(this.f20940q);
        int i3 = this.f20931h;
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams6.addRule(13);
        this.f20941r = imageView4;
        this.f20941r.setId((int) Utils.generateUniqueId());
        this.f20941r.setLayoutParams(layoutParams6);
        this.f20941r.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(context));
        addView(this.f20941r);
        this.f20942s = imageView5;
        this.f20942s.setId((int) Utils.generateUniqueId());
        this.f20942s.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
        ImageView imageView9 = this.f20942s;
        int i4 = this.f20929f;
        imageView9.setPadding(i4, i4, i4 * 2, i4 * 2);
        addView(this.f20942s);
        CtaButtonDrawable ctaButtonDrawable = new CtaButtonDrawable(context);
        if (TextUtils.isEmpty(str)) {
            imageView8 = imageView6;
        } else {
            ctaButtonDrawable.setCtaText(str);
            imageView8 = imageView6;
        }
        this.f20943t = imageView8;
        this.f20943t.setId((int) Utils.generateUniqueId());
        this.f20943t.setImageDrawable(ctaButtonDrawable);
        addView(this.f20943t);
        this.f20944u = imageView7;
        this.f20944u.setId((int) Utils.generateUniqueId());
        this.f20944u.setImageDrawable(new CloseButtonDrawable());
        ImageView imageView10 = this.f20944u;
        int i5 = this.f20929f;
        imageView10.setPadding(i5 * 3, i5, i5, i5 * 3);
        addView(this.f20944u);
        m2124a();
    }

    public void resetProgress() {
        this.f20939p.reset();
    }

    public void setMode(Mode mode) {
        Preconditions.checkNotNull(mode);
        if (this.f20924a == mode) {
            return;
        }
        this.f20924a = mode;
        m2124a();
    }

    public TextureView getTextureView() {
        return this.f20935l;
    }

    public void setOrientation(int i) {
        if (this.f20933j == i) {
            return;
        }
        this.f20933j = i;
        m2124a();
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f20935l.setSurfaceTextureListener(surfaceTextureListener);
        SurfaceTexture surfaceTexture = this.f20935l.getSurfaceTexture();
        if (surfaceTexture == null || surfaceTextureListener == null) {
            return;
        }
        surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.f20935l.getWidth(), this.f20935l.getHeight());
    }

    public void setCloseControlListener(View.OnClickListener onClickListener) {
        this.f20944u.setOnClickListener(onClickListener);
    }

    public void setPrivacyInformationClickListener(View.OnClickListener onClickListener) {
        this.f20942s.setOnClickListener(onClickListener);
    }

    public void setCtaClickListener(View.OnClickListener onClickListener) {
        this.f20943t.setOnClickListener(onClickListener);
    }

    public void setPlayControlClickListener(View.OnClickListener onClickListener) {
        this.f20941r.setOnClickListener(onClickListener);
        this.f20940q.setOnClickListener(onClickListener);
    }

    public void updateProgress(int i) {
        this.f20939p.updateProgress(i);
    }

    public void setCachedVideoFrame(Bitmap bitmap) {
        this.f20934k.setImageBitmap(bitmap);
    }

    /* renamed from: a */
    private void m2124a() {
        switch (this.f20924a) {
            case LOADING:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(4);
                break;
            case PLAYING:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(4);
                break;
            case PAUSED:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(0);
                break;
            case FINISHED:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(0);
                break;
        }
        m2123b();
        m2122c();
    }

    private void setCachedImageVisibility(int i) {
        this.f20934k.setVisibility(i);
    }

    private void setLoadingSpinnerVisibility(int i) {
        this.f20936m.setVisibility(i);
    }

    private void setVideoProgressVisibility(int i) {
        this.f20939p.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i) {
        this.f20941r.setVisibility(i);
        this.f20940q.setVisibility(i);
    }

    /* renamed from: b */
    private void m2123b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        ViewGroup.LayoutParams layoutParams = this.f20935l.getLayoutParams();
        int dipsToIntPixels = Dips.dipsToIntPixels(configuration.screenWidthDp, getContext());
        if (dipsToIntPixels != layoutParams.width) {
            layoutParams.width = dipsToIntPixels;
        }
        int dipsToIntPixels2 = Dips.dipsToIntPixels((configuration.screenWidthDp * 9.0f) / 16.0f, getContext());
        if (dipsToIntPixels2 != layoutParams.height) {
            layoutParams.height = dipsToIntPixels2;
        }
    }

    /* renamed from: c */
    private void m2122c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f20925b, this.f20926c);
        int i = this.f20927d;
        layoutParams.setMargins(i, i, i, i);
        int i2 = this.f20930g;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        int i3 = this.f20928e;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, i3);
        switch (this.f20933j) {
            case 1:
                layoutParams.addRule(3, this.f20935l.getId());
                layoutParams.addRule(14);
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
                layoutParams3.addRule(10);
                layoutParams3.addRule(11);
                break;
            case 2:
                layoutParams.addRule(2, this.f20939p.getId());
                layoutParams.addRule(11);
                layoutParams2.addRule(6, this.f20935l.getId());
                layoutParams2.addRule(5, this.f20935l.getId());
                layoutParams3.addRule(6, this.f20935l.getId());
                layoutParams3.addRule(7, this.f20935l.getId());
                break;
        }
        this.f20943t.setLayoutParams(layoutParams);
        this.f20942s.setLayoutParams(layoutParams2);
        this.f20944u.setLayoutParams(layoutParams3);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeFullScreenVideoView$a */
    /* loaded from: classes2.dex */
    static class C3851a extends Drawable {
        @VisibleForTesting

        /* renamed from: a */
        final int f20947a;

        /* renamed from: b */
        private final RectF f20948b;

        /* renamed from: c */
        private final Paint f20949c;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }

        C3851a(Context context) {
            this(context, new RectF(), new Paint());
        }

        private C3851a(Context context, RectF rectF, Paint paint) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(rectF);
            Preconditions.checkNotNull(paint);
            this.f20948b = rectF;
            this.f20949c = paint;
            this.f20949c.setColor(-16777216);
            this.f20949c.setAlpha(128);
            this.f20949c.setAntiAlias(true);
            this.f20947a = Dips.asIntPixels(5.0f, context);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            this.f20948b.set(getBounds());
            RectF rectF = this.f20948b;
            int i = this.f20947a;
            canvas.drawRoundRect(rectF, i, i, this.f20949c);
        }
    }

    @VisibleForTesting
    @Deprecated
    ImageView getCtaButton() {
        return this.f20943t;
    }
}
