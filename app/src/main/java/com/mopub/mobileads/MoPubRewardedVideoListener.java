package com.mopub.mobileads;

import com.mopub.common.MoPubReward;
import java.util.Set;

/* loaded from: classes.dex */
public interface MoPubRewardedVideoListener {
    void onRewardedVideoClosed(String str);

    void onRewardedVideoCompleted(Set<String> set, MoPubReward moPubReward);

    void onRewardedVideoLoadFailure(String str, MoPubErrorCode moPubErrorCode);

    void onRewardedVideoLoadSuccess(String str);

    void onRewardedVideoPlaybackError(String str, MoPubErrorCode moPubErrorCode);

    void onRewardedVideoStarted(String str);
}
