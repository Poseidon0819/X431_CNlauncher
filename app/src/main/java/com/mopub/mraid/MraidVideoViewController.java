package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.BaseVideoViewController;

/* loaded from: classes.dex */
public class MraidVideoViewController extends BaseVideoViewController {

    /* renamed from: a */
    private final VideoView f20700a;

    /* renamed from: b */
    private ImageButton f20701b;

    /* renamed from: c */
    private int f20702c;

    /* renamed from: d */
    private int f20703d;

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onBackPressed() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onDestroy() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onPause() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onResume() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onSaveInstanceState(Bundle bundle) {
    }

    public MraidVideoViewController(Context context, Bundle bundle, Bundle bundle2, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, null, baseVideoViewControllerListener);
        this.f20700a = new VideoView(context);
        this.f20700a.setOnCompletionListener(new C3813aa(this));
        this.f20700a.setOnErrorListener(new C3814ab(this));
        this.f20700a.setVideoPath(bundle.getString(BaseVideoPlayerActivity.VIDEO_URL));
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onCreate() {
        super.onCreate();
        this.f20703d = Dips.asIntPixels(50.0f, this.mContext);
        this.f20702c = Dips.asIntPixels(8.0f, this.mContext);
        this.f20701b = new ImageButton(this.mContext);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(this.mContext));
        stateListDrawable.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(this.mContext));
        this.f20701b.setImageDrawable(stateListDrawable);
        this.f20701b.setBackgroundDrawable(null);
        this.f20701b.setOnClickListener(new View$OnClickListenerC3815ac(this));
        int i = this.f20703d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11);
        int i2 = this.f20702c;
        layoutParams.setMargins(i2, 0, i2, 0);
        getLayout().addView(this.f20701b, layoutParams);
        this.f20701b.setVisibility(8);
        this.f20700a.start();
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final VideoView getVideoView() {
        return this.f20700a;
    }
}
