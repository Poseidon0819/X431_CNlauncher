package com.mopub.common;

/* loaded from: classes.dex */
public final class MoPubReward {
    public static final int DEFAULT_REWARD_AMOUNT = 0;
    public static final int NO_REWARD_AMOUNT = -123;
    public static final String NO_REWARD_LABEL = "";

    /* renamed from: a */
    private final boolean f20092a;

    /* renamed from: b */
    private final String f20093b;

    /* renamed from: c */
    private final int f20094c;

    private MoPubReward(boolean z, String str, int i) {
        this.f20092a = z;
        this.f20093b = str;
        this.f20094c = i;
    }

    public static MoPubReward failure() {
        return new MoPubReward(false, "", 0);
    }

    public static MoPubReward success(String str, int i) {
        return new MoPubReward(true, str, i);
    }

    public final boolean isSuccessful() {
        return this.f20092a;
    }

    public final String getLabel() {
        return this.f20093b;
    }

    public final int getAmount() {
        return this.f20094c;
    }
}
