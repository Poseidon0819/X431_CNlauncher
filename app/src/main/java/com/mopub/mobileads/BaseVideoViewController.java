package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;

/* loaded from: classes.dex */
public abstract class BaseVideoViewController {

    /* renamed from: a */
    private final RelativeLayout f20305a;

    /* renamed from: b */
    private Long f20306b;
    public final BaseVideoViewControllerListener mBaseVideoViewControllerListener;
    public final Context mContext;

    /* loaded from: classes.dex */
    public interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2366a(int i, int i2) {
    }

    public boolean backButtonEnabled() {
        return true;
    }

    protected abstract VideoView getVideoView();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onBackPressed();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onConfigurationChanged(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onDestroy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onPause();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onResume();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onSaveInstanceState(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseVideoViewController(Context context, Long l, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this.mContext = context;
        this.f20306b = l;
        this.mBaseVideoViewControllerListener = baseVideoViewControllerListener;
        this.f20305a = new RelativeLayout(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f20305a.addView(getVideoView(), 0, layoutParams);
        this.mBaseVideoViewControllerListener.onSetContentView(this.f20305a);
    }

    public ViewGroup getLayout() {
        return this.f20305a;
    }

    public final void videoError(boolean z) {
        MoPubLog.m2496e("Video cannot be played.");
        m2450a(IntentActions.ACTION_INTERSTITIAL_FAIL);
        if (z) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    public final void videoCompleted(boolean z) {
        if (z) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2450a(String str) {
        Long l = this.f20306b;
        if (l != null) {
            BaseBroadcastReceiver.m2454a(this.mContext, l.longValue(), str);
        } else {
            MoPubLog.m2490w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }
}
