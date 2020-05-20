package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.DataKeys;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.RewardedVastVideoInterstitial;
import java.util.Map;

/* loaded from: classes.dex */
public class MoPubRewardedVideo extends CustomEventRewardedVideo {

    /* renamed from: a */
    private RewardedVastVideoInterstitial f20354a = new RewardedVastVideoInterstitial();

    /* renamed from: b */
    private String f20355b;

    /* renamed from: c */
    private int f20356c;

    /* renamed from: d */
    private boolean f20357d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    /* renamed from: a */
    public final String mo2425a() {
        return "mopub_rewarded_video_id";
    }

    /* renamed from: a */
    static /* synthetic */ boolean m2424a(MoPubRewardedVideo moPubRewardedVideo) {
        moPubRewardedVideo.f20357d = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    /* renamed from: b */
    public final void mo2423b() {
        this.f20354a.onInvalidate();
        this.f20357d = false;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    /* renamed from: b */
    protected final void mo2422b(Activity activity, Map<String, Object> map, Map<String, String> map2) throws Exception {
        Preconditions.checkNotNull(activity, "activity cannot be null");
        Preconditions.checkNotNull(map, "localExtras cannot be null");
        Preconditions.checkNotNull(map2, "serverExtras cannot be null");
        Object obj = map.get(DataKeys.REWARDED_VIDEO_CURRENCY_NAME_KEY);
        if (obj instanceof String) {
            this.f20355b = (String) obj;
        } else {
            MoPubLog.m2498d("No currency name specified for rewarded video. Using the default name.");
            this.f20355b = "";
        }
        Object obj2 = map.get(DataKeys.REWARDED_VIDEO_CURRENCY_AMOUNT_STRING_KEY);
        if (obj2 instanceof String) {
            try {
                this.f20356c = Integer.parseInt((String) obj2);
            } catch (NumberFormatException unused) {
                MoPubLog.m2498d("Unable to convert currency amount: " + obj2 + ". Using the default reward amount: 0");
                this.f20356c = 0;
            }
        } else {
            MoPubLog.m2498d("No currency amount specified for rewarded video. Using the default reward amount: 0");
            this.f20356c = 0;
        }
        if (this.f20356c < 0) {
            MoPubLog.m2498d("Negative currency amount specified for rewarded video. Using the default reward amount: 0");
            this.f20356c = 0;
        }
        this.f20354a.loadInterstitial(activity, new C3729a(this, (byte) 0), map, map2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    /* renamed from: c */
    public final boolean mo2420c() {
        return this.f20357d;
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideo$a */
    /* loaded from: classes.dex */
    class C3729a implements CustomEventInterstitial.CustomEventInterstitialListener, RewardedVastVideoInterstitial.InterfaceC3734a {
        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onLeaveApplication() {
        }

        private C3729a() {
        }

        /* synthetic */ C3729a(MoPubRewardedVideo moPubRewardedVideo, byte b) {
            this();
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialLoaded() {
            MoPubRewardedVideo.m2424a(MoPubRewardedVideo.this);
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
            if (C37281.f20358a[moPubErrorCode.ordinal()] == 1) {
                MoPubRewardedVideoManager.onRewardedVideoPlaybackError(MoPubRewardedVideo.class, "mopub_rewarded_video_id", moPubErrorCode);
            } else {
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(MoPubRewardedVideo.class, "mopub_rewarded_video_id", moPubErrorCode);
            }
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialShown() {
            MoPubRewardedVideoManager.onRewardedVideoStarted(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialClicked() {
            MoPubRewardedVideoManager.onRewardedVideoClicked(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialDismissed() {
            MoPubRewardedVideoManager.onRewardedVideoClosed(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
        }

        @Override // com.mopub.mobileads.RewardedVastVideoInterstitial.InterfaceC3734a
        public final void onVideoComplete() {
            if (MoPubRewardedVideo.this.f20355b == null) {
                MoPubLog.m2498d("No rewarded video was loaded, so no reward is possible");
            } else {
                MoPubRewardedVideoManager.onRewardedVideoCompleted(MoPubRewardedVideo.class, "mopub_rewarded_video_id", MoPubReward.success(MoPubRewardedVideo.this.f20355b, MoPubRewardedVideo.this.f20356c));
            }
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideo$1 */
    /* loaded from: classes.dex */
    final /* synthetic */ class C37281 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20358a = new int[MoPubErrorCode.values().length];

        static {
            try {
                f20358a[MoPubErrorCode.VIDEO_PLAYBACK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    /* renamed from: d */
    public final void mo2418d() {
        if (this.f20357d) {
            MoPubLog.m2498d("Showing MoPub rewarded video.");
            this.f20354a.showInterstitial();
            return;
        }
        MoPubLog.m2498d("Unable to show MoPub rewarded video");
    }
}
