package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Strings;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class VastVideoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private String mClickThroughUrl;
    private String mCustomCloseIconUrl;
    private String mCustomCtaText;
    private String mCustomSkipText;
    private String mDiskMediaFileUrl;
    private String mDspCreativeId;
    private boolean mIsForceOrientationSet;
    private VastCompanionAdConfig mLandscapeVastCompanionAdConfig;
    private String mNetworkMediaFileUrl;
    private VastCompanionAdConfig mPortraitVastCompanionAdConfig;
    private String mSkipOffset;
    private VastIconConfig mVastIconConfig;
    private VideoViewabilityTracker mVideoViewabilityTracker;
    private DeviceUtils.ForceOrientation mCustomForceOrientation = DeviceUtils.ForceOrientation.FORCE_LANDSCAPE;
    private final ArrayList<VastTracker> mImpressionTrackers = new ArrayList<>();
    private final ArrayList<VastFractionalProgressTracker> mFractionalTrackers = new ArrayList<>();
    private final ArrayList<VastAbsoluteProgressTracker> mAbsoluteTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mPauseTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mResumeTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mCompleteTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mCloseTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mSkipTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mClickTrackers = new ArrayList<>();
    private final ArrayList<VastTracker> mErrorTrackers = new ArrayList<>();
    private Map<String, VastCompanionAdConfig> mSocialActionsCompanionAds = new HashMap();
    private boolean mIsRewardedVideo = false;

    public void setDspCreativeId(String str) {
        this.mDspCreativeId = str;
    }

    public String getDspCreativeId() {
        return this.mDspCreativeId;
    }

    public void addImpressionTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "impressionTrackers cannot be null");
        this.mImpressionTrackers.addAll(list);
    }

    public void addFractionalTrackers(List<VastFractionalProgressTracker> list) {
        Preconditions.checkNotNull(list, "fractionalTrackers cannot be null");
        this.mFractionalTrackers.addAll(list);
        Collections.sort(this.mFractionalTrackers);
    }

    public void addAbsoluteTrackers(List<VastAbsoluteProgressTracker> list) {
        Preconditions.checkNotNull(list, "absoluteTrackers cannot be null");
        this.mAbsoluteTrackers.addAll(list);
        Collections.sort(this.mAbsoluteTrackers);
    }

    public void addCompleteTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "completeTrackers cannot be null");
        this.mCompleteTrackers.addAll(list);
    }

    public void addPauseTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "pauseTrackers cannot be null");
        this.mPauseTrackers.addAll(list);
    }

    public void addResumeTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "resumeTrackers cannot be null");
        this.mResumeTrackers.addAll(list);
    }

    public void addCloseTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "closeTrackers cannot be null");
        this.mCloseTrackers.addAll(list);
    }

    public void addSkipTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "skipTrackers cannot be null");
        this.mSkipTrackers.addAll(list);
    }

    public void addClickTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.mClickTrackers.addAll(list);
    }

    public void addErrorTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        this.mErrorTrackers.addAll(list);
    }

    public void setClickThroughUrl(String str) {
        this.mClickThroughUrl = str;
    }

    public void setNetworkMediaFileUrl(String str) {
        this.mNetworkMediaFileUrl = str;
    }

    public void setDiskMediaFileUrl(String str) {
        this.mDiskMediaFileUrl = str;
    }

    public void setVastCompanionAd(VastCompanionAdConfig vastCompanionAdConfig, VastCompanionAdConfig vastCompanionAdConfig2) {
        this.mLandscapeVastCompanionAdConfig = vastCompanionAdConfig;
        this.mPortraitVastCompanionAdConfig = vastCompanionAdConfig2;
    }

    public void setSocialActionsCompanionAds(Map<String, VastCompanionAdConfig> map) {
        this.mSocialActionsCompanionAds = map;
    }

    public void setVastIconConfig(VastIconConfig vastIconConfig) {
        this.mVastIconConfig = vastIconConfig;
    }

    public void setCustomCtaText(String str) {
        if (str != null) {
            this.mCustomCtaText = str;
        }
    }

    public void setCustomSkipText(String str) {
        if (str != null) {
            this.mCustomSkipText = str;
        }
    }

    public void setCustomCloseIconUrl(String str) {
        if (str != null) {
            this.mCustomCloseIconUrl = str;
        }
    }

    public void setCustomForceOrientation(DeviceUtils.ForceOrientation forceOrientation) {
        if (forceOrientation == null || forceOrientation == DeviceUtils.ForceOrientation.UNDEFINED) {
            return;
        }
        this.mCustomForceOrientation = forceOrientation;
        this.mIsForceOrientationSet = true;
    }

    public void setSkipOffset(String str) {
        if (str != null) {
            this.mSkipOffset = str;
        }
    }

    public void setVideoViewabilityTracker(VideoViewabilityTracker videoViewabilityTracker) {
        if (videoViewabilityTracker != null) {
            this.mVideoViewabilityTracker = videoViewabilityTracker;
        }
    }

    public void setIsRewardedVideo(boolean z) {
        this.mIsRewardedVideo = z;
    }

    public List<VastTracker> getImpressionTrackers() {
        return this.mImpressionTrackers;
    }

    public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers() {
        return this.mAbsoluteTrackers;
    }

    public ArrayList<VastFractionalProgressTracker> getFractionalTrackers() {
        return this.mFractionalTrackers;
    }

    public List<VastTracker> getPauseTrackers() {
        return this.mPauseTrackers;
    }

    public List<VastTracker> getResumeTrackers() {
        return this.mResumeTrackers;
    }

    public List<VastTracker> getCompleteTrackers() {
        return this.mCompleteTrackers;
    }

    public List<VastTracker> getCloseTrackers() {
        return this.mCloseTrackers;
    }

    public List<VastTracker> getSkipTrackers() {
        return this.mSkipTrackers;
    }

    public List<VastTracker> getClickTrackers() {
        return this.mClickTrackers;
    }

    public List<VastTracker> getErrorTrackers() {
        return this.mErrorTrackers;
    }

    public String getClickThroughUrl() {
        return this.mClickThroughUrl;
    }

    public String getNetworkMediaFileUrl() {
        return this.mNetworkMediaFileUrl;
    }

    public String getDiskMediaFileUrl() {
        return this.mDiskMediaFileUrl;
    }

    public VastCompanionAdConfig getVastCompanionAd(int i) {
        switch (i) {
            case 1:
                return this.mPortraitVastCompanionAdConfig;
            case 2:
                return this.mLandscapeVastCompanionAdConfig;
            default:
                return this.mLandscapeVastCompanionAdConfig;
        }
    }

    public Map<String, VastCompanionAdConfig> getSocialActionsCompanionAds() {
        return this.mSocialActionsCompanionAds;
    }

    public VastIconConfig getVastIconConfig() {
        return this.mVastIconConfig;
    }

    public String getCustomCtaText() {
        return this.mCustomCtaText;
    }

    public String getCustomSkipText() {
        return this.mCustomSkipText;
    }

    public String getCustomCloseIconUrl() {
        return this.mCustomCloseIconUrl;
    }

    public VideoViewabilityTracker getVideoViewabilityTracker() {
        return this.mVideoViewabilityTracker;
    }

    public boolean isCustomForceOrientationSet() {
        return this.mIsForceOrientationSet;
    }

    public boolean hasCompanionAd() {
        return (this.mLandscapeVastCompanionAdConfig == null || this.mPortraitVastCompanionAdConfig == null) ? false : true;
    }

    public DeviceUtils.ForceOrientation getCustomForceOrientation() {
        return this.mCustomForceOrientation;
    }

    public String getSkipOffsetString() {
        return this.mSkipOffset;
    }

    public boolean isRewardedVideo() {
        return this.mIsRewardedVideo;
    }

    public void handleImpression(Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mImpressionTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public void handleClickForResult(Activity activity, int i, int i2) {
        m2372a(activity, i, Integer.valueOf(i2));
    }

    public void handleClickWithoutResult(Context context, int i) {
        m2372a(context.getApplicationContext(), i, null);
    }

    /* renamed from: a */
    private void m2372a(Context context, int i, Integer num) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mClickTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
        if (TextUtils.isEmpty(this.mClickThroughUrl)) {
            return;
        }
        new UrlHandler.Builder().withDspCreativeId(this.mDspCreativeId).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C3756av(this, context, num)).withoutMoPubBrowser().build().handleUrl(context, this.mClickThroughUrl);
    }

    public void handleResume(Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mResumeTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public void handlePause(Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mPauseTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public void handleClose(Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mCloseTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
        TrackingRequest.makeVastTrackingHttpRequest(this.mSkipTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public void handleComplete(Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mCompleteTrackers, null, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public void handleError(Context context, VastErrorCode vastErrorCode, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.mErrorTrackers, vastErrorCode, Integer.valueOf(i), this.mNetworkMediaFileUrl, context);
    }

    public List<VastTracker> getUntriggeredTrackersBefore(int i, int i2) {
        if (Preconditions.NoThrow.checkArgument(i2 > 0)) {
            float f = i / i2;
            ArrayList arrayList = new ArrayList();
            VastAbsoluteProgressTracker vastAbsoluteProgressTracker = new VastAbsoluteProgressTracker("", i);
            int size = this.mAbsoluteTrackers.size();
            for (int i3 = 0; i3 < size; i3++) {
                VastAbsoluteProgressTracker vastAbsoluteProgressTracker2 = this.mAbsoluteTrackers.get(i3);
                if (vastAbsoluteProgressTracker2.compareTo(vastAbsoluteProgressTracker) > 0) {
                    break;
                }
                if (!vastAbsoluteProgressTracker2.isTracked()) {
                    arrayList.add(vastAbsoluteProgressTracker2);
                }
            }
            VastFractionalProgressTracker vastFractionalProgressTracker = new VastFractionalProgressTracker("", f);
            int size2 = this.mFractionalTrackers.size();
            for (int i4 = 0; i4 < size2; i4++) {
                VastFractionalProgressTracker vastFractionalProgressTracker2 = this.mFractionalTrackers.get(i4);
                if (vastFractionalProgressTracker2.compareTo(vastFractionalProgressTracker) > 0) {
                    break;
                }
                if (!vastFractionalProgressTracker2.isTracked()) {
                    arrayList.add(vastFractionalProgressTracker2);
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public int getRemainingProgressTrackerCount() {
        return getUntriggeredTrackersBefore(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT, MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT).size();
    }

    public Integer getSkipOffsetMillis(int i) {
        Integer valueOf;
        String str = this.mSkipOffset;
        if (str != null) {
            try {
                if (Strings.isAbsoluteTracker(str)) {
                    valueOf = Strings.parseAbsoluteOffset(this.mSkipOffset);
                } else if (!Strings.isPercentageTracker(this.mSkipOffset)) {
                    MoPubLog.m2498d(String.format("Invalid VAST skipoffset format: %s", this.mSkipOffset));
                    return null;
                } else {
                    valueOf = Integer.valueOf(Math.round(i * (Float.parseFloat(this.mSkipOffset.replace("%", "")) / 100.0f)));
                }
                if (valueOf != null) {
                    return valueOf.intValue() < i ? valueOf : Integer.valueOf(i);
                }
            } catch (NumberFormatException unused) {
                MoPubLog.m2498d(String.format("Failed to parse skipoffset %s", this.mSkipOffset));
            }
        }
        return null;
    }
}
