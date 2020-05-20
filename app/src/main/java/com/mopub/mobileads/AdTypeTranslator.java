package com.mopub.mobileads;

import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.util.ResponseHeader;
import com.mopub.network.HeaderUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class AdTypeTranslator {
    public static final String BANNER_SUFFIX = "_banner";
    public static final String INTERSTITIAL_SUFFIX = "_interstitial";

    /* loaded from: classes.dex */
    public enum CustomEventType {
        GOOGLE_PLAY_SERVICES_BANNER("admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner"),
        GOOGLE_PLAY_SERVICES_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial"),
        MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner"),
        MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial"),
        MRAID_BANNER("mraid_banner", "com.mopub.mraid.MraidBanner"),
        MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mraid.MraidInterstitial"),
        HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner"),
        HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial"),
        VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial"),
        MOPUB_NATIVE("mopub_native", "com.mopub.nativeads.MoPubCustomEventNative"),
        MOPUB_VIDEO_NATIVE("mopub_video_native", "com.mopub.nativeads.MoPubCustomEventVideoNative"),
        MOPUB_REWARDED_VIDEO(AdType.REWARDED_VIDEO, "com.mopub.mobileads.MoPubRewardedVideo"),
        UNSPECIFIED("", null);
        
        private final String mClassName;
        private final String mKey;

        CustomEventType(String str, String str2) {
            this.mKey = str;
            this.mClassName = str2;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.mClassName;
        }

        static /* synthetic */ CustomEventType access$000(String str) {
            CustomEventType[] values;
            for (CustomEventType customEventType : values()) {
                if (customEventType.mKey.equals(str)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }
    }

    public static String getCustomEventName(AdFormat adFormat, String str, String str2, Map<String, String> map) {
        StringBuilder sb;
        String str3;
        if (AdType.CUSTOM.equalsIgnoreCase(str)) {
            return HeaderUtils.extractHeader(map, ResponseHeader.CUSTOM_EVENT_NAME);
        }
        if (AdType.STATIC_NATIVE.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_NATIVE.toString();
        }
        if (AdType.VIDEO_NATIVE.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_VIDEO_NATIVE.toString();
        }
        if (AdType.REWARDED_VIDEO.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_REWARDED_VIDEO.toString();
        }
        if (AdType.HTML.equalsIgnoreCase(str) || AdType.MRAID.equalsIgnoreCase(str)) {
            if (AdFormat.INTERSTITIAL.equals(adFormat)) {
                sb = new StringBuilder();
                sb.append(str);
                str3 = INTERSTITIAL_SUFFIX;
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str3 = BANNER_SUFFIX;
            }
            sb.append(str3);
            return CustomEventType.access$000(sb.toString()).toString();
        } else if (AdType.INTERSTITIAL.equalsIgnoreCase(str)) {
            return CustomEventType.access$000(str2 + INTERSTITIAL_SUFFIX).toString();
        } else {
            return CustomEventType.access$000(str + BANNER_SUFFIX).toString();
        }
    }
}
