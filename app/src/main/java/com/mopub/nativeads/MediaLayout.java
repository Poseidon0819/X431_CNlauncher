package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.DrawableConstants;

@TargetApi(16)
/* loaded from: classes2.dex */
public class MediaLayout extends RelativeLayout {

    /* renamed from: a */
    private volatile Mode f20780a;

    /* renamed from: b */
    private MuteState f20781b;

    /* renamed from: c */
    private ImageView f20782c;

    /* renamed from: d */
    private TextureView f20783d;

    /* renamed from: e */
    private ProgressBar f20784e;

    /* renamed from: f */
    private ImageView f20785f;

    /* renamed from: g */
    private ImageView f20786g;

    /* renamed from: h */
    private ImageView f20787h;

    /* renamed from: i */
    private VastVideoProgressBarWidget f20788i;

    /* renamed from: j */
    private ImageView f20789j;

    /* renamed from: k */
    private View f20790k;

    /* renamed from: l */
    private Drawable f20791l;

    /* renamed from: m */
    private Drawable f20792m;

    /* renamed from: n */
    private boolean f20793n;

    /* renamed from: o */
    private final int f20794o;

    /* renamed from: p */
    private final int f20795p;

    /* renamed from: q */
    private final int f20796q;

    /* renamed from: r */
    private final int f20797r;

    /* loaded from: classes2.dex */
    public enum Mode {
        IMAGE,
        PLAYING,
        LOADING,
        BUFFERING,
        PAUSED,
        FINISHED
    }

    /* loaded from: classes2.dex */
    public enum MuteState {
        MUTED,
        UNMUTED
    }

    public MediaLayout(Context context) {
        this(context, null);
    }

    public MediaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20780a = Mode.IMAGE;
        Preconditions.checkNotNull(context);
        this.f20781b = MuteState.MUTED;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f20782c = new ImageView(context);
        this.f20782c.setLayoutParams(layoutParams);
        this.f20782c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f20782c);
        this.f20794o = Dips.asIntPixels(40.0f, context);
        this.f20795p = Dips.asIntPixels(35.0f, context);
        this.f20796q = Dips.asIntPixels(36.0f, context);
        this.f20797r = Dips.asIntPixels(10.0f, context);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        TextureView textureView = this.f20783d;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(surfaceTextureListener);
            SurfaceTexture surfaceTexture = this.f20783d.getSurfaceTexture();
            if (surfaceTexture == null || surfaceTextureListener == null) {
                return;
            }
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.f20783d.getWidth(), this.f20783d.getHeight());
        }
    }

    public void initForVideo() {
        if (this.f20793n) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f20783d = new TextureView(getContext());
        this.f20783d.setLayoutParams(layoutParams);
        this.f20783d.setId((int) Utils.generateUniqueId());
        addView(this.f20783d);
        this.f20782c.bringToFront();
        int i = this.f20794o;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(10);
        layoutParams2.addRule(11);
        this.f20784e = new ProgressBar(getContext());
        this.f20784e.setLayoutParams(layoutParams2);
        ProgressBar progressBar = this.f20784e;
        int i2 = this.f20797r;
        progressBar.setPadding(0, i2, i2, 0);
        this.f20784e.setIndeterminate(true);
        addView(this.f20784e);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f20795p);
        layoutParams3.addRule(8, this.f20783d.getId());
        this.f20786g = new ImageView(getContext());
        this.f20786g.setLayoutParams(layoutParams3);
        this.f20786g.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f20786g);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.f20795p);
        layoutParams4.addRule(6, this.f20783d.getId());
        this.f20787h = new ImageView(getContext());
        this.f20787h.setLayoutParams(layoutParams4);
        this.f20787h.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f20787h);
        this.f20788i = new VastVideoProgressBarWidget(getContext());
        this.f20788i.setAnchorId(this.f20783d.getId());
        this.f20788i.calibrateAndMakeVisible(1000, 0);
        addView(this.f20788i);
        this.f20791l = Drawables.NATIVE_MUTED.createDrawable(getContext());
        this.f20792m = Drawables.NATIVE_UNMUTED.createDrawable(getContext());
        int i3 = this.f20796q;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams5.addRule(9);
        layoutParams5.addRule(2, this.f20788i.getId());
        this.f20789j = new ImageView(getContext());
        this.f20789j.setLayoutParams(layoutParams5);
        this.f20789j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView = this.f20789j;
        int i4 = this.f20797r;
        imageView.setPadding(i4, i4, i4, i4);
        this.f20789j.setImageDrawable(this.f20791l);
        addView(this.f20789j);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(13);
        this.f20790k = new View(getContext());
        this.f20790k.setLayoutParams(layoutParams6);
        this.f20790k.setBackgroundColor(0);
        addView(this.f20790k);
        int i5 = this.f20794o;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i5, i5);
        layoutParams7.addRule(13);
        this.f20785f = new ImageView(getContext());
        this.f20785f.setLayoutParams(layoutParams7);
        this.f20785f.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(getContext()));
        addView(this.f20785f);
        this.f20793n = true;
        m2191a();
    }

    public void reset() {
        setMode(Mode.IMAGE);
        setPlayButtonClickListener(null);
        setMuteControlClickListener(null);
        setVideoClickListener(null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, measuredWidth) : measuredWidth;
        }
        int i3 = (int) (size * 0.5625f);
        if (mode2 == 1073741824 && size2 < i3) {
            size = (int) (size2 * 1.7777778f);
            i3 = size2;
        }
        if (Math.abs(i3 - measuredHeight) >= 2 || Math.abs(size - measuredWidth) >= 2) {
            MoPubLog.m2492v(String.format("Resetting mediaLayout size to w: %d h: %d", Integer.valueOf(size), Integer.valueOf(i3)));
            getLayoutParams().width = size;
            getLayoutParams().height = i3;
        }
        super.onMeasure(i, i2);
    }

    public void setMainImageDrawable(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        this.f20782c.setImageDrawable(drawable);
    }

    public void resetProgress() {
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f20788i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.reset();
        }
    }

    public void updateProgress(int i) {
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f20788i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.updateProgress(i);
        }
    }

    public TextureView getTextureView() {
        return this.f20783d;
    }

    public void setMode(Mode mode) {
        Preconditions.checkNotNull(mode);
        this.f20780a = mode;
        post(new RunnableC3887e(this));
    }

    public ImageView getMainImageView() {
        return this.f20782c;
    }

    public void setMuteControlClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f20789j;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setPlayButtonClickListener(View.OnClickListener onClickListener) {
        View view;
        if (this.f20785f == null || (view = this.f20790k) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
        this.f20785f.setOnClickListener(onClickListener);
    }

    public void setVideoClickListener(View.OnClickListener onClickListener) {
        TextureView textureView = this.f20783d;
        if (textureView != null) {
            textureView.setOnClickListener(onClickListener);
        }
    }

    public void setMuteState(MuteState muteState) {
        Preconditions.checkNotNull(muteState);
        if (muteState == this.f20781b) {
            return;
        }
        this.f20781b = muteState;
        if (this.f20789j != null) {
            if (C38391.f20798a[this.f20781b.ordinal()] == 1) {
                this.f20789j.setImageDrawable(this.f20791l);
            } else {
                this.f20789j.setImageDrawable(this.f20792m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.MediaLayout$1 */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class C38391 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20798a;

        static {
            try {
                f20799b[Mode.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20799b[Mode.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20799b[Mode.BUFFERING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20799b[Mode.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20799b[Mode.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20799b[Mode.FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f20798a = new int[MuteState.values().length];
            try {
                f20798a[MuteState.MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20798a[MuteState.UNMUTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public void m2191a() {
        switch (this.f20780a) {
            case IMAGE:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case LOADING:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case BUFFERING:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                break;
            case PLAYING:
                break;
            case PAUSED:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(0);
                return;
            case FINISHED:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(0);
                return;
            default:
                return;
        }
        setMainImageVisibility(4);
        setLoadingSpinnerVisibility(4);
        setVideoControlVisibility(0);
        setPlayButtonVisibility(4);
    }

    private void setMainImageVisibility(int i) {
        this.f20782c.setVisibility(i);
    }

    private void setLoadingSpinnerVisibility(int i) {
        ProgressBar progressBar = this.f20784e;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        }
        ImageView imageView = this.f20787h;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    private void setVideoControlVisibility(int i) {
        ImageView imageView = this.f20786g;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f20788i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.setVisibility(i);
        }
        ImageView imageView2 = this.f20789j;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
    }

    private void setPlayButtonVisibility(int i) {
        ImageView imageView = this.f20785f;
        if (imageView == null || this.f20790k == null) {
            return;
        }
        imageView.setVisibility(i);
        this.f20790k.setVisibility(i);
    }
}
