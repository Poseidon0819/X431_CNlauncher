package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.MediationSettings;
import com.mopub.common.Preconditions;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.MoPubRewardedVideoManager;

/* loaded from: classes.dex */
public class MoPubRewardedVideos {
    @ReflectionTarget
    public static void initializeRewardedVideo(Activity activity, MediationSettings... mediationSettingsArr) {
        Preconditions.checkNotNull(activity);
        MoPubRewardedVideoManager.init(activity, mediationSettingsArr);
    }

    @ReflectionTarget
    public static void setRewardedVideoListener(MoPubRewardedVideoListener moPubRewardedVideoListener) {
        MoPubRewardedVideoManager.setVideoListener(moPubRewardedVideoListener);
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String str, MediationSettings... mediationSettingsArr) {
        Preconditions.checkNotNull(str);
        MoPubRewardedVideoManager.loadVideo(str, null, mediationSettingsArr);
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String str, MoPubRewardedVideoManager.RequestParameters requestParameters, MediationSettings... mediationSettingsArr) {
        Preconditions.checkNotNull(str);
        MoPubRewardedVideoManager.loadVideo(str, requestParameters, mediationSettingsArr);
    }

    @ReflectionTarget
    public static boolean hasRewardedVideo(String str) {
        Preconditions.checkNotNull(str);
        return MoPubRewardedVideoManager.hasVideo(str);
    }

    @ReflectionTarget
    public static void showRewardedVideo(String str) {
        Preconditions.checkNotNull(str);
        MoPubRewardedVideoManager.showVideo(str);
    }
}
