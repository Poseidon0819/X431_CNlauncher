package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;

/* loaded from: classes.dex */
public class VastTracker implements Serializable {
    private static final long serialVersionUID = 0;
    private boolean mCalled;
    private boolean mIsRepeatable;
    protected final String mTrackingUrl;

    public VastTracker(String str) {
        Preconditions.checkNotNull(str);
        this.mTrackingUrl = str;
    }

    public VastTracker(String str, boolean z) {
        this(str);
        this.mIsRepeatable = z;
    }

    public String getTrackingUrl() {
        return this.mTrackingUrl;
    }

    public void setTracked() {
        this.mCalled = true;
    }

    public boolean isTracked() {
        return this.mCalled;
    }

    public boolean isRepeatable() {
        return this.mIsRepeatable;
    }
}
