package com.mopub.network;

import com.mopub.common.event.EventDetails;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AdResponse implements Serializable {
    private static final long serialVersionUID = 1;
    private final Integer mAdTimeoutDelayMillis;
    private final String mAdType;
    private final String mAdUnitId;
    private final String mClickTrackingUrl;
    private final String mCustomEventClassName;
    private final String mDspCreativeId;
    private final EventDetails mEventDetails;
    private final String mFailoverUrl;
    private final String mFullAdType;
    private final Integer mHeight;
    private final String mImpressionTrackingUrl;
    private final JSONObject mJsonBody;
    private final String mNetworkType;
    private final String mRedirectUrl;
    private final Integer mRefreshTimeMillis;
    private final String mRequestId;
    private final String mResponseBody;
    private final String mRewardedVideoCompletionUrl;
    private final String mRewardedVideoCurrencyAmount;
    private final String mRewardedVideoCurrencyName;
    private final boolean mScrollable;
    private final Map<String, String> mServerExtras;
    private final long mTimestamp;
    private final Integer mWidth;

    private AdResponse(Builder builder) {
        this.mAdType = builder.f21178a;
        this.mAdUnitId = builder.f21179b;
        this.mFullAdType = builder.f21180c;
        this.mNetworkType = builder.f21181d;
        this.mRewardedVideoCurrencyName = builder.f21182e;
        this.mRewardedVideoCurrencyAmount = builder.f21183f;
        this.mRewardedVideoCompletionUrl = builder.f21184g;
        this.mRedirectUrl = builder.f21185h;
        this.mClickTrackingUrl = builder.f21186i;
        this.mImpressionTrackingUrl = builder.f21187j;
        this.mFailoverUrl = builder.f21188k;
        this.mRequestId = builder.f21189l;
        this.mWidth = builder.f21190m;
        this.mHeight = builder.f21191n;
        this.mAdTimeoutDelayMillis = builder.f21192o;
        this.mRefreshTimeMillis = builder.f21193p;
        this.mDspCreativeId = builder.f21194q;
        this.mScrollable = builder.f21195r;
        this.mResponseBody = builder.f21196s;
        this.mJsonBody = builder.f21197t;
        this.mEventDetails = builder.f21198u;
        this.mCustomEventClassName = builder.f21199v;
        this.mServerExtras = builder.f21200w;
        this.mTimestamp = DateAndTime.now().getTime();
    }

    public boolean hasJson() {
        return this.mJsonBody != null;
    }

    public JSONObject getJsonBody() {
        return this.mJsonBody;
    }

    public EventDetails getEventDetails() {
        return this.mEventDetails;
    }

    public String getStringBody() {
        return this.mResponseBody;
    }

    public String getAdType() {
        return this.mAdType;
    }

    public String getFullAdType() {
        return this.mFullAdType;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public String getNetworkType() {
        return this.mNetworkType;
    }

    public String getRewardedVideoCurrencyName() {
        return this.mRewardedVideoCurrencyName;
    }

    public String getRewardedVideoCurrencyAmount() {
        return this.mRewardedVideoCurrencyAmount;
    }

    public String getRewardedVideoCompletionUrl() {
        return this.mRewardedVideoCompletionUrl;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getClickTrackingUrl() {
        return this.mClickTrackingUrl;
    }

    public String getImpressionTrackingUrl() {
        return this.mImpressionTrackingUrl;
    }

    public String getFailoverUrl() {
        return this.mFailoverUrl;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public boolean isScrollable() {
        return this.mScrollable;
    }

    public Integer getWidth() {
        return this.mWidth;
    }

    public Integer getHeight() {
        return this.mHeight;
    }

    public Integer getAdTimeoutMillis() {
        return this.mAdTimeoutDelayMillis;
    }

    public Integer getRefreshTimeMillis() {
        return this.mRefreshTimeMillis;
    }

    public String getDspCreativeId() {
        return this.mDspCreativeId;
    }

    public String getCustomEventClassName() {
        return this.mCustomEventClassName;
    }

    public Map<String, String> getServerExtras() {
        return new TreeMap(this.mServerExtras);
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public Builder toBuilder() {
        return new Builder().setAdType(this.mAdType).setNetworkType(this.mNetworkType).setRedirectUrl(this.mRedirectUrl).setClickTrackingUrl(this.mClickTrackingUrl).setImpressionTrackingUrl(this.mImpressionTrackingUrl).setFailoverUrl(this.mFailoverUrl).setDimensions(this.mWidth, this.mHeight).setAdTimeoutDelayMilliseconds(this.mAdTimeoutDelayMillis).setRefreshTimeMilliseconds(this.mRefreshTimeMillis).setDspCreativeId(this.mDspCreativeId).setScrollable(Boolean.valueOf(this.mScrollable)).setResponseBody(this.mResponseBody).setJsonBody(this.mJsonBody).setEventDetails(this.mEventDetails).setCustomEventClassName(this.mCustomEventClassName).setServerExtras(this.mServerExtras);
    }

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private String f21178a;

        /* renamed from: b */
        private String f21179b;

        /* renamed from: c */
        private String f21180c;

        /* renamed from: d */
        private String f21181d;

        /* renamed from: e */
        private String f21182e;

        /* renamed from: f */
        private String f21183f;

        /* renamed from: g */
        private String f21184g;

        /* renamed from: h */
        private String f21185h;

        /* renamed from: i */
        private String f21186i;

        /* renamed from: j */
        private String f21187j;

        /* renamed from: k */
        private String f21188k;

        /* renamed from: l */
        private String f21189l;

        /* renamed from: m */
        private Integer f21190m;

        /* renamed from: n */
        private Integer f21191n;

        /* renamed from: o */
        private Integer f21192o;

        /* renamed from: p */
        private Integer f21193p;

        /* renamed from: q */
        private String f21194q;

        /* renamed from: s */
        private String f21196s;

        /* renamed from: t */
        private JSONObject f21197t;

        /* renamed from: u */
        private EventDetails f21198u;

        /* renamed from: v */
        private String f21199v;

        /* renamed from: r */
        private boolean f21195r = false;

        /* renamed from: w */
        private Map<String, String> f21200w = new TreeMap();

        public Builder setAdType(String str) {
            this.f21178a = str;
            return this;
        }

        public Builder setAdUnitId(String str) {
            this.f21179b = str;
            return this;
        }

        public Builder setFullAdType(String str) {
            this.f21180c = str;
            return this;
        }

        public Builder setNetworkType(String str) {
            this.f21181d = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyName(String str) {
            this.f21182e = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyAmount(String str) {
            this.f21183f = str;
            return this;
        }

        public Builder setRewardedVideoCompletionUrl(String str) {
            this.f21184g = str;
            return this;
        }

        public Builder setRedirectUrl(String str) {
            this.f21185h = str;
            return this;
        }

        public Builder setClickTrackingUrl(String str) {
            this.f21186i = str;
            return this;
        }

        public Builder setImpressionTrackingUrl(String str) {
            this.f21187j = str;
            return this;
        }

        public Builder setFailoverUrl(String str) {
            this.f21188k = str;
            return this;
        }

        public Builder setRequestId(String str) {
            this.f21189l = str;
            return this;
        }

        public Builder setDimensions(Integer num, Integer num2) {
            this.f21190m = num;
            this.f21191n = num2;
            return this;
        }

        public Builder setAdTimeoutDelayMilliseconds(Integer num) {
            this.f21192o = num;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(Integer num) {
            this.f21193p = num;
            return this;
        }

        public Builder setScrollable(Boolean bool) {
            this.f21195r = bool == null ? this.f21195r : bool.booleanValue();
            return this;
        }

        public Builder setDspCreativeId(String str) {
            this.f21194q = str;
            return this;
        }

        public Builder setResponseBody(String str) {
            this.f21196s = str;
            return this;
        }

        public Builder setJsonBody(JSONObject jSONObject) {
            this.f21197t = jSONObject;
            return this;
        }

        public Builder setEventDetails(EventDetails eventDetails) {
            this.f21198u = eventDetails;
            return this;
        }

        public Builder setCustomEventClassName(String str) {
            this.f21199v = str;
            return this;
        }

        public Builder setServerExtras(Map<String, String> map) {
            if (map == null) {
                this.f21200w = new TreeMap();
            } else {
                this.f21200w = new TreeMap(map);
            }
            return this;
        }

        public AdResponse build() {
            return new AdResponse(this);
        }
    }
}
