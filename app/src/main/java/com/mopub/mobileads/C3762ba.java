package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import com.mopub.common.IntentActions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.ba */
/* loaded from: classes.dex */
public final class C3762ba implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoView f20556a;

    /* renamed from: b */
    final /* synthetic */ Context f20557b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f20558c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3762ba(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView, Context context) {
        this.f20558c = vastVideoViewController;
        this.f20556a = vastVideoView;
        this.f20557b = context;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        VastVideoConfig vastVideoConfig;
        boolean z;
        VastVideoProgressBarWidget vastVideoProgressBarWidget;
        boolean z2;
        View view;
        VastVideoGradientStripWidget vastVideoGradientStripWidget;
        VastVideoGradientStripWidget vastVideoGradientStripWidget2;
        VastVideoCtaButtonWidget vastVideoCtaButtonWidget;
        VastCompanionAdConfig vastCompanionAdConfig;
        ImageView imageView;
        ImageView imageView2;
        View view2;
        VastCompanionAdConfig vastCompanionAdConfig2;
        int i;
        View view3;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        VastVideoConfig vastVideoConfig2;
        VastVideoConfig vastVideoConfig3;
        this.f20558c.m2357c();
        this.f20558c.m2367a();
        this.f20558c.videoCompleted(false);
        VastVideoViewController.m2342q(this.f20558c);
        vastVideoConfig = this.f20558c.f20466j;
        if (vastVideoConfig.isRewardedVideo()) {
            this.f20558c.m2450a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        z = this.f20558c.f20482z;
        if (!z) {
            vastVideoConfig2 = this.f20558c.f20466j;
            if (vastVideoConfig2.getRemainingProgressTrackerCount() == 0) {
                vastVideoConfig3 = this.f20558c.f20466j;
                vastVideoConfig3.handleComplete(this.f20558c.mContext, this.f20558c.f20457a.getCurrentPosition());
            }
        }
        this.f20556a.setVisibility(4);
        vastVideoProgressBarWidget = this.f20558c.f20458b;
        vastVideoProgressBarWidget.setVisibility(8);
        z2 = this.f20558c.f20454B;
        if (z2) {
            imageView3 = this.f20558c.f20469m;
            if (imageView3.getDrawable() != null) {
                imageView4 = this.f20558c.f20469m;
                imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView5 = this.f20558c.f20469m;
                imageView5.setVisibility(0);
            }
        } else {
            view = this.f20558c.f20462f;
            view.setVisibility(8);
        }
        vastVideoGradientStripWidget = this.f20558c.f20467k;
        vastVideoGradientStripWidget.m2370a();
        vastVideoGradientStripWidget2 = this.f20558c.f20468l;
        vastVideoGradientStripWidget2.m2370a();
        vastVideoCtaButtonWidget = this.f20558c.f20470n;
        vastVideoCtaButtonWidget.f20431b = true;
        vastVideoCtaButtonWidget.f20432c = true;
        vastVideoCtaButtonWidget.m2371a();
        vastCompanionAdConfig = this.f20558c.f20472p;
        if (vastCompanionAdConfig == null) {
            imageView = this.f20558c.f20469m;
            if (imageView.getDrawable() != null) {
                imageView2 = this.f20558c.f20469m;
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f20557b.getResources().getConfiguration().orientation == 1) {
            view3 = this.f20558c.f20474r;
            view3.setVisibility(0);
        } else {
            view2 = this.f20558c.f20473q;
            view2.setVisibility(0);
        }
        vastCompanionAdConfig2 = this.f20558c.f20472p;
        Context context = this.f20557b;
        i = this.f20558c.f20455C;
        vastCompanionAdConfig2.handleImpression(context, i);
    }
}
