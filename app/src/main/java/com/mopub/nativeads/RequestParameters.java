package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import java.util.EnumSet;

/* loaded from: classes2.dex */
public class RequestParameters {

    /* renamed from: a */
    private final String f20997a;

    /* renamed from: b */
    private final Location f20998b;

    /* renamed from: c */
    private final EnumSet<NativeAdAsset> f20999c;

    /* synthetic */ RequestParameters(Builder builder, byte b) {
        this(builder);
    }

    /* loaded from: classes2.dex */
    public enum NativeAdAsset {
        TITLE("title"),
        TEXT("text"),
        ICON_IMAGE("iconimage"),
        MAIN_IMAGE("mainimage"),
        CALL_TO_ACTION_TEXT("ctatext"),
        STAR_RATING("starrating");
        
        private final String mAssetName;

        NativeAdAsset(String str) {
            this.mAssetName = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.mAssetName;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        private String f21000a;

        /* renamed from: b */
        private Location f21001b;

        /* renamed from: c */
        private EnumSet<NativeAdAsset> f21002c;

        public final Builder keywords(String str) {
            this.f21000a = str;
            return this;
        }

        public final Builder location(Location location) {
            this.f21001b = location;
            return this;
        }

        public final Builder desiredAssets(EnumSet<NativeAdAsset> enumSet) {
            this.f21002c = EnumSet.copyOf((EnumSet) enumSet);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this, (byte) 0);
        }
    }

    private RequestParameters(Builder builder) {
        this.f20997a = builder.f21000a;
        this.f20998b = builder.f21001b;
        this.f20999c = builder.f21002c;
    }

    public final String getKeywords() {
        return this.f20997a;
    }

    public final Location getLocation() {
        return this.f20998b;
    }

    public final String getDesiredAssets() {
        EnumSet<NativeAdAsset> enumSet = this.f20999c;
        return enumSet != null ? TextUtils.join(",", enumSet.toArray()) : "";
    }
}
