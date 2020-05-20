package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.am */
/* loaded from: classes.dex */
public final class VastIconConfig implements Serializable {
    private static final long serialVersionUID = 0;
    private final String mClickThroughUri;
    private final List<VastTracker> mClickTrackingUris;
    private final Integer mDurationMS;
    private final int mHeight;
    private final int mOffsetMS;
    private final VastResource mVastResource;
    private final List<VastTracker> mViewTrackingUris;
    private final int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastIconConfig(int i, int i2, Integer num, Integer num2, VastResource vastResource, List<VastTracker> list, String str, List<VastTracker> list2) {
        Preconditions.checkNotNull(vastResource);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.mWidth = i;
        this.mHeight = i2;
        this.mOffsetMS = num == null ? 0 : num.intValue();
        this.mDurationMS = num2;
        this.mVastResource = vastResource;
        this.mClickTrackingUris = list;
        this.mClickThroughUri = str;
        this.mViewTrackingUris = list2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getWidth() {
        return this.mWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getHeight() {
        return this.mHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getOffsetMS() {
        return this.mOffsetMS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Integer getDurationMS() {
        return this.mDurationMS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final VastResource getVastResource() {
        return this.mVastResource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<VastTracker> getClickTrackingUris() {
        return this.mClickTrackingUris;
    }

    final String getClickThroughUri() {
        return this.mClickThroughUri;
    }

    final List<VastTracker> getViewTrackingUris() {
        return this.mViewTrackingUris;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void handleImpression(Context context, int i, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        TrackingRequest.makeVastTrackingHttpRequest(this.mViewTrackingUris, null, Integer.valueOf(i), str, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void handleClick(Context context, String str, String str2) {
        Preconditions.checkNotNull(context);
        String correctClickThroughUrl = this.mVastResource.getCorrectClickThroughUrl(this.mClickThroughUri, str);
        if (TextUtils.isEmpty(correctClickThroughUrl)) {
            return;
        }
        new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new C3750an(this, str2, context)).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
    }
}
