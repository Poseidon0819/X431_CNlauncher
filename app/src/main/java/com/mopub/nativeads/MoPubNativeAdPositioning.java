package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class MoPubNativeAdPositioning {

    /* loaded from: classes2.dex */
    public static class MoPubServerPositioning {
    }

    /* loaded from: classes2.dex */
    public static class MoPubClientPositioning {
        public static final int NO_REPEAT = Integer.MAX_VALUE;

        /* renamed from: a */
        final ArrayList<Integer> f20876a = new ArrayList<>();

        /* renamed from: b */
        int f20877b = NO_REPEAT;

        public MoPubClientPositioning addFixedPosition(int i) {
            int binarySearch;
            if (Preconditions.NoThrow.checkArgument(i >= 0) && (binarySearch = Collections.binarySearch(this.f20876a, Integer.valueOf(i))) < 0) {
                this.f20876a.add(binarySearch ^ (-1), Integer.valueOf(i));
            }
            return this;
        }

        public MoPubClientPositioning enableRepeatingPositions(int i) {
            if (!Preconditions.NoThrow.checkArgument(i > 1, "Repeating interval must be greater than 1")) {
                this.f20877b = NO_REPEAT;
                return this;
            }
            this.f20877b = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MoPubClientPositioning m2143a(MoPubClientPositioning moPubClientPositioning) {
        Preconditions.checkNotNull(moPubClientPositioning);
        MoPubClientPositioning moPubClientPositioning2 = new MoPubClientPositioning();
        moPubClientPositioning2.f20876a.addAll(moPubClientPositioning.f20876a);
        moPubClientPositioning2.f20877b = moPubClientPositioning.f20877b;
        return moPubClientPositioning2;
    }

    public static MoPubClientPositioning clientPositioning() {
        return new MoPubClientPositioning();
    }

    public static MoPubServerPositioning serverPositioning() {
        return new MoPubServerPositioning();
    }
}
