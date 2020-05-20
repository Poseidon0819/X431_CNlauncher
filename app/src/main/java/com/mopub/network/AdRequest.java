package com.mopub.network;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AdRequest extends Request<AdResponse> {

    /* renamed from: a */
    private final Listener f21174a;

    /* renamed from: b */
    private final AdFormat f21175b;

    /* renamed from: c */
    private final String f21176c;

    /* renamed from: d */
    private final Context f21177d;

    /* loaded from: classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onSuccess(AdResponse adResponse);
    }

    @Override // com.mopub.volley.Request
    public /* synthetic */ void deliverResponse(AdResponse adResponse) {
        this.f21174a.onSuccess(adResponse);
    }

    public AdRequest(String str, AdFormat adFormat, String str2, Context context, Listener listener) {
        super(0, str, listener);
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(listener);
        this.f21176c = str2;
        this.f21174a = listener;
        this.f21175b = adFormat;
        this.f21177d = context.getApplicationContext();
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
    }

    public Listener getListener() {
        return this.f21174a;
    }

    @Override // com.mopub.volley.Request
    public Map<String, String> getHeaders() {
        TreeMap treeMap = new TreeMap();
        String language = Locale.getDefault().getLanguage();
        Locale locale = this.f21177d.getResources().getConfiguration().locale;
        if (locale != null && !locale.getLanguage().trim().isEmpty()) {
            language = locale.getLanguage().trim();
        }
        if (!language.isEmpty()) {
            treeMap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), language);
        }
        return treeMap;
    }

    @Override // com.mopub.volley.Request
    public final Response<AdResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        AdResponse.Builder builder;
        AdResponse.Builder builder2;
        Map<String, String> map = networkResponse.headers;
        if (HeaderUtils.extractBooleanHeader(map, ResponseHeader.WARMUP, false)) {
            return Response.error(new MoPubNetworkError("Ad Unit is warming up.", MoPubNetworkError.Reason.WARMING_UP));
        }
        Location lastKnownLocation = LocationService.getLastKnownLocation(this.f21177d, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        AdResponse.Builder builder3 = new AdResponse.Builder();
        builder3.setAdUnitId(this.f21176c);
        String extractHeader = HeaderUtils.extractHeader(map, ResponseHeader.AD_TYPE);
        String extractHeader2 = HeaderUtils.extractHeader(map, ResponseHeader.FULL_AD_TYPE);
        builder3.setAdType(extractHeader);
        builder3.setFullAdType(extractHeader2);
        Integer extractIntegerHeader = HeaderUtils.extractIntegerHeader(map, ResponseHeader.REFRESH_TIME);
        Integer valueOf = extractIntegerHeader == null ? null : Integer.valueOf(extractIntegerHeader.intValue() * 1000);
        builder3.setRefreshTimeMilliseconds(valueOf);
        if (AdType.CLEAR.equals(extractHeader)) {
            m2054a(builder3.build(), networkResponse, lastKnownLocation);
            return Response.error(new MoPubNetworkError("No ads found for ad unit.", MoPubNetworkError.Reason.NO_FILL, valueOf));
        }
        String extractHeader3 = HeaderUtils.extractHeader(map, ResponseHeader.DSP_CREATIVE_ID);
        builder3.setDspCreativeId(extractHeader3);
        String extractHeader4 = HeaderUtils.extractHeader(map, ResponseHeader.NETWORK_TYPE);
        builder3.setNetworkType(extractHeader4);
        String extractHeader5 = HeaderUtils.extractHeader(map, ResponseHeader.REDIRECT_URL);
        builder3.setRedirectUrl(extractHeader5);
        String extractHeader6 = HeaderUtils.extractHeader(map, ResponseHeader.CLICK_TRACKING_URL);
        builder3.setClickTrackingUrl(extractHeader6);
        builder3.setImpressionTrackingUrl(HeaderUtils.extractHeader(map, ResponseHeader.IMPRESSION_URL));
        String extractHeader7 = HeaderUtils.extractHeader(map, ResponseHeader.FAIL_URL);
        builder3.setFailoverUrl(extractHeader7);
        String m2052b = m2052b(extractHeader7);
        builder3.setRequestId(m2052b);
        boolean extractBooleanHeader = HeaderUtils.extractBooleanHeader(map, ResponseHeader.SCROLLABLE, false);
        builder3.setScrollable(Boolean.valueOf(extractBooleanHeader));
        Integer extractIntegerHeader2 = HeaderUtils.extractIntegerHeader(map, ResponseHeader.WIDTH);
        Integer extractIntegerHeader3 = HeaderUtils.extractIntegerHeader(map, ResponseHeader.HEIGHT);
        builder3.setDimensions(extractIntegerHeader2, extractIntegerHeader3);
        Integer extractIntegerHeader4 = HeaderUtils.extractIntegerHeader(map, ResponseHeader.AD_TIMEOUT);
        builder3.setAdTimeoutDelayMilliseconds(extractIntegerHeader4 == null ? null : Integer.valueOf(extractIntegerHeader4.intValue() * 1000));
        String m2053a = m2053a(networkResponse);
        builder3.setResponseBody(m2053a);
        if (AdType.STATIC_NATIVE.equals(extractHeader) || AdType.VIDEO_NATIVE.equals(extractHeader)) {
            try {
                builder3.setJsonBody(new JSONObject(m2053a));
            } catch (JSONException e) {
                return Response.error(new MoPubNetworkError("Failed to decode body JSON for native ad format", e, MoPubNetworkError.Reason.BAD_BODY));
            }
        }
        builder3.setCustomEventClassName(AdTypeTranslator.getCustomEventName(this.f21175b, extractHeader, extractHeader2, map));
        String extractHeader8 = HeaderUtils.extractHeader(map, ResponseHeader.CUSTOM_EVENT_DATA);
        if (TextUtils.isEmpty(extractHeader8)) {
            extractHeader8 = HeaderUtils.extractHeader(map, ResponseHeader.NATIVE_PARAMS);
        }
        try {
            Map<String, String> jsonStringToMap = Json.jsonStringToMap(extractHeader8);
            if (extractHeader5 != null) {
                builder = builder3;
                jsonStringToMap.put(DataKeys.REDIRECT_URL_KEY, extractHeader5);
            } else {
                builder = builder3;
            }
            if (extractHeader6 != null) {
                jsonStringToMap.put(DataKeys.CLICKTHROUGH_URL_KEY, extractHeader6);
            }
            if (AdType.MRAID.equals(extractHeader) || AdType.HTML.equals(extractHeader) || (AdType.INTERSTITIAL.equals(extractHeader) && FullAdType.VAST.equals(extractHeader2)) || (AdType.REWARDED_VIDEO.equals(extractHeader) && FullAdType.VAST.equals(extractHeader2))) {
                jsonStringToMap.put(DataKeys.HTML_RESPONSE_BODY_KEY, m2053a);
                jsonStringToMap.put(DataKeys.SCROLLABLE_KEY, Boolean.toString(extractBooleanHeader));
                jsonStringToMap.put(DataKeys.CREATIVE_ORIENTATION_KEY, HeaderUtils.extractHeader(map, ResponseHeader.ORIENTATION));
            }
            if (!AdType.VIDEO_NATIVE.equals(extractHeader)) {
                builder2 = builder;
            } else if (Build.VERSION.SDK_INT < 16) {
                return Response.error(new MoPubNetworkError("Native Video ads are only supported for Android API Level 16 (JellyBean) and above.", MoPubNetworkError.Reason.UNSPECIFIED));
            } else {
                jsonStringToMap.put(DataKeys.PLAY_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.PLAY_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.PAUSE_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.PAUSE_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.IMPRESSION_MIN_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.IMPRESSION_VISIBLE_MS, HeaderUtils.extractHeader(map, ResponseHeader.IMPRESSION_VISIBLE_MS));
                jsonStringToMap.put(DataKeys.MAX_BUFFER_MS, HeaderUtils.extractHeader(map, ResponseHeader.MAX_BUFFER_MS));
                builder2 = builder;
                builder2.setEventDetails(new EventDetails.Builder().adUnitId(this.f21176c).adType(extractHeader).adNetworkType(extractHeader4).adWidthPx(extractIntegerHeader2).adHeightPx(extractIntegerHeader3).dspCreativeId(extractHeader3).geoLatitude(lastKnownLocation == null ? null : Double.valueOf(lastKnownLocation.getLatitude())).geoLongitude(lastKnownLocation == null ? null : Double.valueOf(lastKnownLocation.getLongitude())).geoAccuracy(lastKnownLocation == null ? null : Float.valueOf(lastKnownLocation.getAccuracy())).performanceDurationMs(Long.valueOf(networkResponse.networkTimeMs)).requestId(m2052b).requestStatusCode(Integer.valueOf(networkResponse.statusCode)).requestUri(getUrl()).build());
            }
            builder2.setServerExtras(jsonStringToMap);
            if (AdType.REWARDED_VIDEO.equals(extractHeader) || AdType.CUSTOM.equals(extractHeader)) {
                String extractHeader9 = HeaderUtils.extractHeader(map, ResponseHeader.REWARDED_VIDEO_CURRENCY_NAME);
                String extractHeader10 = HeaderUtils.extractHeader(map, ResponseHeader.REWARDED_VIDEO_CURRENCY_AMOUNT);
                String extractHeader11 = HeaderUtils.extractHeader(map, ResponseHeader.REWARDED_VIDEO_COMPLETION_URL);
                builder2.setRewardedVideoCurrencyName(extractHeader9);
                builder2.setRewardedVideoCurrencyAmount(extractHeader10);
                builder2.setRewardedVideoCompletionUrl(extractHeader11);
            }
            m2054a(builder2.build(), networkResponse, lastKnownLocation);
            return Response.success(builder2.build(), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException e2) {
            return Response.error(new MoPubNetworkError("Failed to decode server extras for custom event data.", e2, MoPubNetworkError.Reason.BAD_HEADER_DATA));
        }
    }

    /* renamed from: a */
    private static String m2053a(NetworkResponse networkResponse) {
        try {
            return new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            return new String(networkResponse.data);
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    private static String m2052b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Uri.parse(str).getQueryParameter("request_id");
        } catch (UnsupportedOperationException unused) {
            MoPubLog.m2498d("Unable to obtain request id from fail url.");
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private void m2054a(AdResponse adResponse, NetworkResponse networkResponse, Location location) {
        Preconditions.checkNotNull(adResponse);
        Preconditions.checkNotNull(networkResponse);
        MoPubEvents.log(new Event.Builder(BaseEvent.Name.AD_REQUEST, BaseEvent.Category.REQUESTS, BaseEvent.SamplingRate.AD_REQUEST.getSamplingRate()).withAdUnitId(this.f21176c).withDspCreativeId(adResponse.getDspCreativeId()).withAdType(adResponse.getAdType()).withAdNetworkType(adResponse.getNetworkType()).withAdWidthPx(adResponse.getWidth() != null ? Double.valueOf(adResponse.getWidth().doubleValue()) : null).withAdHeightPx(adResponse.getHeight() != null ? Double.valueOf(adResponse.getHeight().doubleValue()) : null).withGeoLat(location != null ? Double.valueOf(location.getLatitude()) : null).withGeoLon(location != null ? Double.valueOf(location.getLongitude()) : null).withGeoAccuracy(location != null ? Double.valueOf(location.getAccuracy()) : null).withPerformanceDurationMs(Double.valueOf(networkResponse.networkTimeMs)).withRequestId(adResponse.getRequestId()).withRequestStatusCode(Integer.valueOf(networkResponse.statusCode)).withRequestUri(getUrl()).build());
    }
}
