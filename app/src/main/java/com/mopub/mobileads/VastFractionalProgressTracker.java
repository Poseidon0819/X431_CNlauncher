package com.mopub.mobileads;

import com.itextpdf.text.pdf.ColumnText;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes.dex */
public class VastFractionalProgressTracker extends VastTracker implements Serializable, Comparable<VastFractionalProgressTracker> {
    private static final long serialVersionUID = 0;
    private final float mFraction;

    public VastFractionalProgressTracker(String str, float f) {
        super(str);
        Preconditions.checkArgument(f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.mFraction = f;
    }

    public float trackingFraction() {
        return this.mFraction;
    }

    @Override // java.lang.Comparable
    public int compareTo(VastFractionalProgressTracker vastFractionalProgressTracker) {
        return Double.compare(trackingFraction(), vastFractionalProgressTracker.trackingFraction());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.mFraction), this.mTrackingUrl);
    }
}
