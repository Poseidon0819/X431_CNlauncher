package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes.dex */
public class VastAbsoluteProgressTracker extends VastTracker implements Serializable, Comparable<VastAbsoluteProgressTracker> {
    private static final long serialVersionUID = 0;
    private final int mTrackingMilliseconds;

    public VastAbsoluteProgressTracker(String str, int i) {
        super(str);
        Preconditions.checkArgument(i >= 0);
        this.mTrackingMilliseconds = i;
    }

    public int getTrackingMilliseconds() {
        return this.mTrackingMilliseconds;
    }

    @Override // java.lang.Comparable
    public int compareTo(VastAbsoluteProgressTracker vastAbsoluteProgressTracker) {
        return getTrackingMilliseconds() - vastAbsoluteProgressTracker.getTrackingMilliseconds();
    }

    public String toString() {
        return String.format(Locale.US, "%dms: %s", Integer.valueOf(this.mTrackingMilliseconds), this.mTrackingUrl);
    }
}
