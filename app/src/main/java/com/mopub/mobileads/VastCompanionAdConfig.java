package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VastCompanionAdConfig implements Serializable {
    private static final long serialVersionUID = 0;
    private final String mClickThroughUrl;
    private final List<VastTracker> mClickTrackers;
    private final List<VastTracker> mCreativeViewTrackers;
    private final int mHeight;
    private final VastResource mVastResource;
    private final int mWidth;

    public VastCompanionAdConfig(int i, int i2, VastResource vastResource, String str, List<VastTracker> list, List<VastTracker> list2) {
        Preconditions.checkNotNull(vastResource);
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        Preconditions.checkNotNull(list2, "creativeViewTrackers cannot be null");
        this.mWidth = i;
        this.mHeight = i2;
        this.mVastResource = vastResource;
        this.mClickThroughUrl = str;
        this.mClickTrackers = list;
        this.mCreativeViewTrackers = list2;
    }

    public void addClickTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.mClickTrackers.addAll(list);
    }

    public void addCreativeViewTrackers(List<VastTracker> list) {
        Preconditions.checkNotNull(list, "creativeViewTrackers cannot be null");
        this.mCreativeViewTrackers.addAll(list);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public VastResource getVastResource() {
        return this.mVastResource;
    }

    public String getClickThroughUrl() {
        return this.mClickThroughUrl;
    }

    public List<VastTracker> getClickTrackers() {
        return this.mClickTrackers;
    }

    public List<VastTracker> getCreativeViewTrackers() {
        return this.mCreativeViewTrackers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleImpression(Context context, int i) {
        Preconditions.checkNotNull(context);
        TrackingRequest.makeVastTrackingHttpRequest(this.mCreativeViewTrackers, null, Integer.valueOf(i), null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleClick(Context context, int i, String str, String str2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(context instanceof Activity, "context must be an activity");
        String correctClickThroughUrl = this.mVastResource.getCorrectClickThroughUrl(this.mClickThroughUrl, str);
        if (TextUtils.isEmpty(correctClickThroughUrl)) {
            return;
        }
        new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C3749ak(this, str2, context, i)).withDspCreativeId(str2).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
    }
}
