package com.mopub.mobileads;

/* loaded from: classes.dex */
public class VideoViewabilityTracker extends VastTracker {
    private final int mPercentViewable;
    private final int mViewablePlaytimeMS;

    public VideoViewabilityTracker(int i, int i2, String str) {
        super(str);
        this.mViewablePlaytimeMS = i;
        this.mPercentViewable = i2;
    }

    public int getViewablePlaytimeMS() {
        return this.mViewablePlaytimeMS;
    }

    public int getPercentViewable() {
        return this.mPercentViewable;
    }
}
