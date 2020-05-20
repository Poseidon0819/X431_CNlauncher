package com.mopub.mobileads;

/* loaded from: classes.dex */
public enum MoPubErrorCode {
    NO_FILL("No ads found."),
    WARMUP("Ad unit is warming up. Try again in a few minutes."),
    SERVER_ERROR("Unable to connect to MoPub adserver."),
    INTERNAL_ERROR("Unable to serve ad due to invalid internal state."),
    CANCELLED("Ad request was cancelled."),
    NO_CONNECTION("No internet connection detected."),
    ADAPTER_NOT_FOUND("Unable to find Native Network or Custom Event adapter."),
    ADAPTER_CONFIGURATION_ERROR("Native Network or Custom Event adapter was configured incorrectly."),
    NETWORK_TIMEOUT("Third-party network failed to respond in a timely manner."),
    NETWORK_NO_FILL("Third-party network failed to provide an ad."),
    NETWORK_INVALID_STATE("Third-party network failed due to invalid internal state."),
    MRAID_LOAD_ERROR("Error loading MRAID ad."),
    VIDEO_CACHE_ERROR("Error creating a cache to store downloaded videos."),
    VIDEO_DOWNLOAD_ERROR("Error downloading video."),
    VIDEO_NOT_AVAILABLE("No video loaded for ad unit."),
    VIDEO_PLAYBACK_ERROR("Error playing a video."),
    UNSPECIFIED("Unspecified error.");
    

    /* renamed from: message  reason: collision with root package name */
    private final String f24488message;

    MoPubErrorCode(String str) {
        this.f24488message = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f24488message;
    }
}
