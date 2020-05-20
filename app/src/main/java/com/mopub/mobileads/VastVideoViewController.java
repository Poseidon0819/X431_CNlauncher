package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.baidu.mapapi.UIMsg;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.BaseVideoViewController;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public class VastVideoViewController extends BaseVideoViewController {
    public static final int WEBVIEW_PADDING = 16;

    /* renamed from: A */
    private boolean f20453A;

    /* renamed from: B */
    private boolean f20454B;

    /* renamed from: C */
    private int f20455C;

    /* renamed from: D */
    private boolean f20456D;

    /* renamed from: a */
    final VastVideoView f20457a;

    /* renamed from: b */
    VastVideoProgressBarWidget f20458b;

    /* renamed from: c */
    VastVideoRadialCountdownWidget f20459c;

    /* renamed from: d */
    final VastIconConfig f20460d;

    /* renamed from: e */
    final Map<String, VastCompanionAdConfig> f20461e;

    /* renamed from: f */
    final View f20462f;

    /* renamed from: g */
    int f20463g;

    /* renamed from: h */
    boolean f20464h;

    /* renamed from: i */
    boolean f20465i;

    /* renamed from: j */
    private final VastVideoConfig f20466j;

    /* renamed from: k */
    private VastVideoGradientStripWidget f20467k;

    /* renamed from: l */
    private VastVideoGradientStripWidget f20468l;

    /* renamed from: m */
    private ImageView f20469m;

    /* renamed from: n */
    private VastVideoCtaButtonWidget f20470n;

    /* renamed from: o */
    private VastVideoCloseButtonWidget f20471o;

    /* renamed from: p */
    private VastCompanionAdConfig f20472p;

    /* renamed from: q */
    private final View f20473q;

    /* renamed from: r */
    private final View f20474r;

    /* renamed from: s */
    private View f20475s;

    /* renamed from: t */
    private final View f20476t;

    /* renamed from: u */
    private final VastVideoViewProgressRunnable f20477u;

    /* renamed from: v */
    private final VastVideoViewCountdownRunnable f20478v;

    /* renamed from: w */
    private final View.OnTouchListener f20479w;

    /* renamed from: x */
    private int f20480x;

    /* renamed from: y */
    private boolean f20481y;

    /* renamed from: z */
    private boolean f20482z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m2358b(VastVideoViewController vastVideoViewController) {
        vastVideoViewController.f20456D = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ boolean m2344o(VastVideoViewController vastVideoViewController) {
        vastVideoViewController.f20465i = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static /* synthetic */ boolean m2342q(VastVideoViewController vastVideoViewController) {
        vastVideoViewController.f20481y = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static /* synthetic */ boolean m2335x(VastVideoViewController vastVideoViewController) {
        vastVideoViewController.f20482z = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastVideoViewController(Activity activity, Bundle bundle, Bundle bundle2, long j, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) throws IllegalStateException {
        super(activity, Long.valueOf(j), baseVideoViewControllerListener);
        View view;
        this.f20463g = UIMsg.m_AppUI.MSG_APP_GPS;
        this.f20453A = false;
        this.f20465i = false;
        this.f20454B = false;
        this.f20456D = false;
        this.f20480x = -1;
        Serializable serializable = bundle2 != null ? bundle2.getSerializable("resumed_vast_config") : null;
        Serializable serializable2 = bundle.getSerializable("vast_video_config");
        if (serializable != null && (serializable instanceof VastVideoConfig)) {
            this.f20466j = (VastVideoConfig) serializable;
            this.f20480x = bundle2.getInt("current_position", -1);
        } else if (serializable2 != null && (serializable2 instanceof VastVideoConfig)) {
            this.f20466j = (VastVideoConfig) serializable2;
        } else {
            throw new IllegalStateException("VastVideoConfig is invalid");
        }
        if (this.f20466j.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        this.f20472p = this.f20466j.getVastCompanionAd(activity.getResources().getConfiguration().orientation);
        this.f20461e = this.f20466j.getSocialActionsCompanionAds();
        this.f20460d = this.f20466j.getVastIconConfig();
        this.f20479w = new View$OnTouchListenerC3757aw(this, activity);
        getLayout().setBackgroundColor(-16777216);
        this.f20469m = new ImageView(activity);
        this.f20469m.setVisibility(4);
        getLayout().addView(this.f20469m, new RelativeLayout.LayoutParams(-1, -1));
        if (this.f20466j.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        VastVideoView vastVideoView = new VastVideoView(activity);
        vastVideoView.setId((int) Utils.generateUniqueId());
        vastVideoView.setOnPreparedListener(new C3760az(this, vastVideoView));
        vastVideoView.setOnTouchListener(this.f20479w);
        vastVideoView.setOnCompletionListener(new C3762ba(this, vastVideoView, activity));
        vastVideoView.setOnErrorListener(new C3765bb(this, vastVideoView));
        vastVideoView.setVideoPath(this.f20466j.getDiskMediaFileUrl());
        vastVideoView.setVisibility(0);
        this.f20457a = vastVideoView;
        this.f20457a.requestFocus();
        this.f20473q = m2365a(activity, this.f20466j.getVastCompanionAd(2));
        this.f20474r = m2365a(activity, this.f20466j.getVastCompanionAd(1));
        this.f20467k = new VastVideoGradientStripWidget(activity, GradientDrawable.Orientation.TOP_BOTTOM, this.f20466j.getCustomForceOrientation(), this.f20472p != null, 0, 6, getLayout().getId());
        getLayout().addView(this.f20467k);
        this.f20458b = new VastVideoProgressBarWidget(activity);
        this.f20458b.setAnchorId(this.f20457a.getId());
        this.f20458b.setVisibility(4);
        getLayout().addView(this.f20458b);
        this.f20468l = new VastVideoGradientStripWidget(activity, GradientDrawable.Orientation.BOTTOM_TOP, this.f20466j.getCustomForceOrientation(), this.f20472p != null, 8, 2, this.f20458b.getId());
        getLayout().addView(this.f20468l);
        this.f20459c = new VastVideoRadialCountdownWidget(activity);
        this.f20459c.setVisibility(4);
        getLayout().addView(this.f20459c);
        VastIconConfig vastIconConfig = this.f20460d;
        Preconditions.checkNotNull(activity);
        if (vastIconConfig == null) {
            view = new View(activity);
        } else {
            VastWebView m2291a = VastWebView.m2291a(activity, vastIconConfig.getVastResource());
            m2291a.f20570b = new C3767bd(this, vastIconConfig, activity);
            m2291a.setWebViewClient(new C3768be(this, vastIconConfig));
            m2291a.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.asIntPixels(vastIconConfig.getWidth(), activity), Dips.asIntPixels(vastIconConfig.getHeight(), activity));
            layoutParams.setMargins(Dips.dipsToIntPixels(12.0f, activity), Dips.dipsToIntPixels(12.0f, activity), 0, 0);
            getLayout().addView(m2291a, layoutParams);
            view = m2291a;
        }
        this.f20462f = view;
        this.f20462f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC3759ay(this, activity));
        this.f20470n = new VastVideoCtaButtonWidget(activity, this.f20457a.getId(), this.f20472p != null, !TextUtils.isEmpty(this.f20466j.getClickThroughUrl()));
        getLayout().addView(this.f20470n);
        this.f20470n.setOnTouchListener(this.f20479w);
        String customCtaText = this.f20466j.getCustomCtaText();
        if (customCtaText != null) {
            this.f20470n.f20430a.setCtaText(customCtaText);
        }
        this.f20476t = m2364a(activity, this.f20461e.get(VastXmlManagerAggregator.SOCIAL_ACTIONS_AD_SLOT_ID), Dips.dipsToIntPixels(38.0f, activity), 6, this.f20470n, 4, 16);
        this.f20471o = new VastVideoCloseButtonWidget(activity);
        this.f20471o.setVisibility(8);
        getLayout().addView(this.f20471o);
        this.f20471o.setOnTouchListenerToContent(new View$OnTouchListenerC3766bc(this));
        String customSkipText = this.f20466j.getCustomSkipText();
        if (customSkipText != null) {
            VastVideoCloseButtonWidget vastVideoCloseButtonWidget = this.f20471o;
            if (vastVideoCloseButtonWidget.f20422a != null) {
                vastVideoCloseButtonWidget.f20422a.setText(customSkipText);
            }
        }
        String customCloseIconUrl = this.f20466j.getCustomCloseIconUrl();
        if (customCloseIconUrl != null) {
            VastVideoCloseButtonWidget vastVideoCloseButtonWidget2 = this.f20471o;
            vastVideoCloseButtonWidget2.f20423b.get(customCloseIconUrl, new C3755au(vastVideoCloseButtonWidget2, customCloseIconUrl));
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.f20477u = new VastVideoViewProgressRunnable(this, this.f20466j, handler);
        this.f20478v = new VastVideoViewCountdownRunnable(this, handler);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    protected final VideoView getVideoView() {
        return this.f20457a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onCreate() {
        super.onCreate();
        switch (this.f20466j.getCustomForceOrientation()) {
            case FORCE_PORTRAIT:
                this.mBaseVideoViewControllerListener.onSetRequestedOrientation(1);
                break;
            case FORCE_LANDSCAPE:
                this.mBaseVideoViewControllerListener.onSetRequestedOrientation(0);
                break;
        }
        this.f20466j.handleImpression(this.mContext, this.f20457a.getCurrentPosition());
        m2450a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onPause() {
        m2357c();
        this.f20480x = this.f20457a.getCurrentPosition();
        this.f20457a.pause();
        if (this.f20481y || this.f20456D) {
            return;
        }
        this.f20466j.handlePause(this.mContext, this.f20480x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onDestroy() {
        m2357c();
        m2450a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        this.f20457a.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("current_position", this.f20480x);
        bundle.putSerializable("resumed_vast_config", this.f20466j);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public boolean backButtonEnabled() {
        return this.f20464h;
    }

    @VisibleForTesting
    /* renamed from: a */
    private View m2365a(Context context, VastCompanionAdConfig vastCompanionAdConfig) {
        Preconditions.checkNotNull(context);
        if (vastCompanionAdConfig == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        getLayout().addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        VastWebView m2359b = m2359b(context, vastCompanionAdConfig);
        m2359b.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(vastCompanionAdConfig.getWidth() + 16, context), Dips.dipsToIntPixels(vastCompanionAdConfig.getHeight() + 16, context));
        layoutParams.addRule(13, -1);
        relativeLayout.addView(m2359b, layoutParams);
        return m2359b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final View m2364a(Context context, VastCompanionAdConfig vastCompanionAdConfig, int i, int i2, View view, int i3, int i4) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(view);
        if (vastCompanionAdConfig == null) {
            View view2 = new View(context);
            view2.setVisibility(4);
            return view2;
        }
        this.f20454B = true;
        this.f20470n.setHasSocialActions(this.f20454B);
        VastWebView m2359b = m2359b(context, vastCompanionAdConfig);
        int dipsToIntPixels = Dips.dipsToIntPixels(vastCompanionAdConfig.getWidth(), context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(vastCompanionAdConfig.getHeight(), context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(i4, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        layoutParams.addRule(i2, view.getId());
        layoutParams.addRule(6, view.getId());
        layoutParams.setMargins(dipsToIntPixels3, (i - dipsToIntPixels2) / 2, 0, 0);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(16);
        relativeLayout.addView(m2359b, new RelativeLayout.LayoutParams(-2, -2));
        getLayout().addView(relativeLayout, layoutParams);
        m2359b.setVisibility(i3);
        return m2359b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2367a() {
        this.f20464h = true;
        this.f20459c.setVisibility(8);
        this.f20471o.setVisibility(0);
        VastVideoCtaButtonWidget vastVideoCtaButtonWidget = this.f20470n;
        vastVideoCtaButtonWidget.f20431b = true;
        vastVideoCtaButtonWidget.m2371a();
        this.f20476t.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final String m2360b() {
        VastVideoConfig vastVideoConfig = this.f20466j;
        if (vastVideoConfig == null) {
            return null;
        }
        return vastVideoConfig.getNetworkMediaFileUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2357c() {
        this.f20477u.stop();
        this.f20478v.stop();
    }

    /* renamed from: b */
    private VastWebView m2359b(Context context, VastCompanionAdConfig vastCompanionAdConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastCompanionAdConfig);
        VastWebView m2291a = VastWebView.m2291a(context, vastCompanionAdConfig.getVastResource());
        m2291a.f20570b = new C3769bf(this, vastCompanionAdConfig, context);
        m2291a.setWebViewClient(new C3758ax(this, vastCompanionAdConfig, context));
        return m2291a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onResume() {
        this.f20477u.startRepeating(50L);
        this.f20478v.startRepeating(250L);
        int i = this.f20480x;
        if (i > 0) {
            this.f20457a.seekTo(i);
        }
        if (!this.f20481y) {
            this.f20457a.start();
        }
        if (this.f20480x != -1) {
            this.f20466j.handleResume(this.mContext, this.f20480x);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onConfigurationChanged(Configuration configuration) {
        int i = this.mContext.getResources().getConfiguration().orientation;
        this.f20472p = this.f20466j.getVastCompanionAd(i);
        if (this.f20473q.getVisibility() == 0 || this.f20474r.getVisibility() == 0) {
            if (i == 1) {
                this.f20473q.setVisibility(4);
                this.f20474r.setVisibility(0);
            } else {
                this.f20474r.setVisibility(4);
                this.f20473q.setVisibility(0);
            }
            VastCompanionAdConfig vastCompanionAdConfig = this.f20472p;
            if (vastCompanionAdConfig != null) {
                vastCompanionAdConfig.handleImpression(this.mContext, this.f20455C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: a */
    public final void mo2366a(int i, int i2) {
        if (i == 1 && i2 == -1) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ void m2351h(VastVideoViewController vastVideoViewController) {
        int duration = vastVideoViewController.f20457a.getDuration();
        if (vastVideoViewController.f20466j.isRewardedVideo()) {
            vastVideoViewController.f20463g = duration;
            return;
        }
        if (duration < 16000) {
            vastVideoViewController.f20463g = duration;
        }
        Integer skipOffsetMillis = vastVideoViewController.f20466j.getSkipOffsetMillis(duration);
        if (skipOffsetMillis != null) {
            vastVideoViewController.f20463g = skipOffsetMillis.intValue();
            vastVideoViewController.f20453A = true;
        }
    }
}
