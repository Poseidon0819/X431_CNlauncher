package com.mopub.common.event;

import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class BaseEvent {

    /* renamed from: A */
    private final String f20121A;

    /* renamed from: B */
    private final Integer f20122B;

    /* renamed from: C */
    private final long f20123C;

    /* renamed from: D */
    private ClientMetadata f20124D;

    /* renamed from: E */
    private final double f20125E;

    /* renamed from: a */
    private final ScribeCategory f20126a;

    /* renamed from: b */
    private final Name f20127b;

    /* renamed from: c */
    private final Category f20128c;

    /* renamed from: d */
    private final SdkProduct f20129d;

    /* renamed from: e */
    private final String f20130e;

    /* renamed from: f */
    private final String f20131f;

    /* renamed from: g */
    private final String f20132g;

    /* renamed from: h */
    private final String f20133h;

    /* renamed from: i */
    private final Double f20134i;

    /* renamed from: j */
    private final Double f20135j;

    /* renamed from: k */
    private final String f20136k;

    /* renamed from: l */
    private final Integer f20137l;

    /* renamed from: m */
    private final Integer f20138m;

    /* renamed from: n */
    private final Double f20139n;

    /* renamed from: o */
    private final Double f20140o;

    /* renamed from: p */
    private final Double f20141p;

    /* renamed from: q */
    private final ClientMetadata.MoPubNetworkType f20142q;

    /* renamed from: r */
    private final String f20143r;

    /* renamed from: s */
    private final String f20144s;

    /* renamed from: t */
    private final String f20145t;

    /* renamed from: u */
    private final String f20146u;

    /* renamed from: v */
    private final String f20147v;

    /* renamed from: w */
    private final String f20148w;

    /* renamed from: x */
    private final Double f20149x;

    /* renamed from: y */
    private final String f20150y;

    /* renamed from: z */
    private final Integer f20151z;

    public String getObfuscatedClientAdvertisingId() {
        return "ifa:XXXX";
    }

    /* loaded from: classes.dex */
    public enum ScribeCategory {
        EXCHANGE_CLIENT_EVENT("exchange_client_event"),
        EXCHANGE_CLIENT_ERROR("exchange_client_error");
        
        private final String mScribeCategory;

        ScribeCategory(String str) {
            this.mScribeCategory = str;
        }

        public final String getCategory() {
            return this.mScribeCategory;
        }
    }

    /* loaded from: classes.dex */
    public enum SdkProduct {
        NONE(0),
        WEB_VIEW(1),
        NATIVE(2);
        
        private final int mType;

        SdkProduct(int i) {
            this.mType = i;
        }

        public final int getType() {
            return this.mType;
        }
    }

    /* loaded from: classes.dex */
    public enum AppPlatform {
        NONE(0),
        IOS(1),
        ANDROID(2),
        MOBILE_WEB(3);
        
        private final int mType;

        AppPlatform(int i) {
            this.mType = i;
        }

        public final int getType() {
            return this.mType;
        }
    }

    /* loaded from: classes.dex */
    public enum Name {
        AD_REQUEST("ad_request"),
        IMPRESSION_REQUEST("impression_request"),
        CLICK_REQUEST("click_request"),
        DOWNLOAD_START("download_start"),
        DOWNLOAD_VIDEO_READY("download_video_ready"),
        DOWNLOAD_BUFFERING("download_video_buffering"),
        DOWNLOAD_FINISHED("download_finished"),
        ERROR_DURING_PLAYBACK("error_during_playback"),
        ERROR_FAILED_TO_PLAY("error_failed_to_play"),
        AD_DWELL_TIME("clickthrough_dwell_time");
        
        private final String mName;

        Name(String str) {
            this.mName = str;
        }

        public final String getName() {
            return this.mName;
        }
    }

    /* loaded from: classes.dex */
    public enum Category {
        REQUESTS("requests"),
        NATIVE_VIDEO("native_video"),
        AD_INTERACTIONS("ad_interactions");
        
        private final String mCategory;

        Category(String str) {
            this.mCategory = str;
        }

        public final String getCategory() {
            return this.mCategory;
        }
    }

    /* loaded from: classes.dex */
    public enum SamplingRate {
        AD_REQUEST,
        NATIVE_VIDEO,
        AD_INTERACTIONS;
        
        private final double mSamplingRate = 0.1d;

        SamplingRate() {
        }

        public final double getSamplingRate() {
            return this.mSamplingRate;
        }
    }

    public BaseEvent(Builder builder) {
        Preconditions.checkNotNull(builder);
        this.f20126a = builder.f20153a;
        this.f20127b = builder.f20154b;
        this.f20128c = builder.f20155c;
        this.f20129d = builder.f20156d;
        this.f20130e = builder.f20157e;
        this.f20131f = builder.f20158f;
        this.f20132g = builder.f20159g;
        this.f20133h = builder.f20160h;
        this.f20134i = builder.f20161i;
        this.f20135j = builder.f20162j;
        this.f20136k = builder.f20163k;
        this.f20139n = builder.f20164l;
        this.f20140o = builder.f20165m;
        this.f20141p = builder.f20166n;
        this.f20149x = builder.f20167o;
        this.f20150y = builder.f20168p;
        this.f20151z = builder.f20169q;
        this.f20121A = builder.f20170r;
        this.f20122B = builder.f20171s;
        this.f20125E = builder.f20172t;
        this.f20123C = System.currentTimeMillis();
        this.f20124D = ClientMetadata.getInstance();
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata != null) {
            this.f20137l = Integer.valueOf(clientMetadata.getDeviceScreenWidthDip());
            this.f20138m = Integer.valueOf(this.f20124D.getDeviceScreenHeightDip());
            this.f20142q = this.f20124D.getActiveNetworkType();
            this.f20143r = this.f20124D.getNetworkOperator();
            this.f20144s = this.f20124D.getNetworkOperatorName();
            this.f20145t = this.f20124D.getIsoCountryCode();
            this.f20146u = this.f20124D.getSimOperator();
            this.f20147v = this.f20124D.getSimOperatorName();
            this.f20148w = this.f20124D.getSimIsoCountryCode();
            return;
        }
        this.f20137l = null;
        this.f20138m = null;
        this.f20142q = null;
        this.f20143r = null;
        this.f20144s = null;
        this.f20145t = null;
        this.f20146u = null;
        this.f20147v = null;
        this.f20148w = null;
    }

    public ScribeCategory getScribeCategory() {
        return this.f20126a;
    }

    public Name getName() {
        return this.f20127b;
    }

    public Category getCategory() {
        return this.f20128c;
    }

    public SdkProduct getSdkProduct() {
        return this.f20129d;
    }

    public String getSdkVersion() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getSdkVersion();
    }

    public String getAdUnitId() {
        return this.f20130e;
    }

    public String getAdCreativeId() {
        return this.f20131f;
    }

    public String getDspCreativeId() {
        return this.f20136k;
    }

    public String getAdType() {
        return this.f20132g;
    }

    public String getAdNetworkType() {
        return this.f20133h;
    }

    public Double getAdWidthPx() {
        return this.f20134i;
    }

    public Double getAdHeightPx() {
        return this.f20135j;
    }

    public AppPlatform getAppPlatform() {
        return AppPlatform.ANDROID;
    }

    public String getAppName() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getAppName();
    }

    public String getAppPackageName() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getAppPackageName();
    }

    public String getAppVersion() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getAppVersion();
    }

    public String getClientAdvertisingId() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getDeviceId();
    }

    public Boolean getClientDoNotTrack() {
        ClientMetadata clientMetadata = this.f20124D;
        return Boolean.valueOf(clientMetadata == null || clientMetadata.isDoNotTrackSet());
    }

    public String getDeviceManufacturer() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getDeviceManufacturer();
    }

    public String getDeviceModel() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getDeviceModel();
    }

    public String getDeviceProduct() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getDeviceProduct();
    }

    public String getDeviceOsVersion() {
        ClientMetadata clientMetadata = this.f20124D;
        if (clientMetadata == null) {
            return null;
        }
        return clientMetadata.getDeviceOsVersion();
    }

    public Integer getDeviceScreenWidthDip() {
        return this.f20137l;
    }

    public Integer getDeviceScreenHeightDip() {
        return this.f20138m;
    }

    public Double getGeoLat() {
        return this.f20139n;
    }

    public Double getGeoLon() {
        return this.f20140o;
    }

    public Double getGeoAccuracy() {
        return this.f20141p;
    }

    public Double getPerformanceDurationMs() {
        return this.f20149x;
    }

    public ClientMetadata.MoPubNetworkType getNetworkType() {
        return this.f20142q;
    }

    public String getNetworkOperatorCode() {
        return this.f20143r;
    }

    public String getNetworkOperatorName() {
        return this.f20144s;
    }

    public String getNetworkIsoCountryCode() {
        return this.f20145t;
    }

    public String getNetworkSimCode() {
        return this.f20146u;
    }

    public String getNetworkSimOperatorName() {
        return this.f20147v;
    }

    public String getNetworkSimIsoCountryCode() {
        return this.f20148w;
    }

    public String getRequestId() {
        return this.f20150y;
    }

    public Integer getRequestStatusCode() {
        return this.f20151z;
    }

    public String getRequestUri() {
        return this.f20121A;
    }

    public Integer getRequestRetries() {
        return this.f20122B;
    }

    public double getSamplingRate() {
        return this.f20125E;
    }

    public Long getTimestampUtcMs() {
        return Long.valueOf(this.f20123C);
    }

    public String toString() {
        return "BaseEvent\nScribeCategory: " + getScribeCategory() + "\nName: " + getName() + "\nCategory: " + getCategory() + "\nSdkProduct: " + getSdkProduct() + "\nSdkVersion: " + getSdkVersion() + "\nAdUnitId: " + getAdUnitId() + "\nAdCreativeId: " + getAdCreativeId() + "\nAdType: " + getAdType() + "\nAdNetworkType: " + getAdNetworkType() + "\nAdWidthPx: " + getAdWidthPx() + "\nAdHeightPx: " + getAdHeightPx() + "\nDspCreativeId: " + getDspCreativeId() + "\nAppPlatform: " + getAppPlatform() + "\nAppName: " + getAppName() + "\nAppPackageName: " + getAppPackageName() + "\nAppVersion: " + getAppVersion() + "\nDeviceManufacturer: " + getDeviceManufacturer() + "\nDeviceModel: " + getDeviceModel() + "\nDeviceProduct: " + getDeviceProduct() + "\nDeviceOsVersion: " + getDeviceOsVersion() + "\nDeviceScreenWidth: " + getDeviceScreenWidthDip() + "\nDeviceScreenHeight: " + getDeviceScreenHeightDip() + "\nGeoLat: " + getGeoLat() + "\nGeoLon: " + getGeoLon() + "\nGeoAccuracy: " + getGeoAccuracy() + "\nPerformanceDurationMs: " + getPerformanceDurationMs() + "\nNetworkType: " + getNetworkType() + "\nNetworkOperatorCode: " + getNetworkOperatorCode() + "\nNetworkOperatorName: " + getNetworkOperatorName() + "\nNetworkIsoCountryCode: " + getNetworkIsoCountryCode() + "\nNetworkSimCode: " + getNetworkSimCode() + "\nNetworkSimOperatorName: " + getNetworkSimOperatorName() + "\nNetworkSimIsoCountryCode: " + getNetworkSimIsoCountryCode() + "\nRequestId: " + getRequestId() + "\nRequestStatusCode: " + getRequestStatusCode() + "\nRequestUri: " + getRequestUri() + "\nRequestRetries: " + getRequestRetries() + "\nSamplingRate: " + getSamplingRate() + "\nTimestampUtcMs: " + new SimpleDateFormat().format(new Date(getTimestampUtcMs().longValue())) + "\n";
    }

    /* loaded from: classes.dex */
    public static abstract class Builder {

        /* renamed from: a */
        private ScribeCategory f20153a;

        /* renamed from: b */
        private Name f20154b;

        /* renamed from: c */
        private Category f20155c;

        /* renamed from: d */
        private SdkProduct f20156d;

        /* renamed from: e */
        private String f20157e;

        /* renamed from: f */
        private String f20158f;

        /* renamed from: g */
        private String f20159g;

        /* renamed from: h */
        private String f20160h;

        /* renamed from: i */
        private Double f20161i;

        /* renamed from: j */
        private Double f20162j;

        /* renamed from: k */
        private String f20163k;

        /* renamed from: l */
        private Double f20164l;

        /* renamed from: m */
        private Double f20165m;

        /* renamed from: n */
        private Double f20166n;

        /* renamed from: o */
        private Double f20167o;

        /* renamed from: p */
        private String f20168p;

        /* renamed from: q */
        private Integer f20169q;

        /* renamed from: r */
        private String f20170r;

        /* renamed from: s */
        private Integer f20171s;

        /* renamed from: t */
        private double f20172t;

        public abstract BaseEvent build();

        public Builder(ScribeCategory scribeCategory, Name name, Category category, double d) {
            Preconditions.checkNotNull(scribeCategory);
            Preconditions.checkNotNull(name);
            Preconditions.checkNotNull(category);
            Preconditions.checkArgument(d >= 0.0d && d <= 1.0d);
            this.f20153a = scribeCategory;
            this.f20154b = name;
            this.f20155c = category;
            this.f20172t = d;
        }

        public Builder withSdkProduct(SdkProduct sdkProduct) {
            this.f20156d = sdkProduct;
            return this;
        }

        public Builder withAdUnitId(String str) {
            this.f20157e = str;
            return this;
        }

        public Builder withAdCreativeId(String str) {
            this.f20158f = str;
            return this;
        }

        public Builder withAdType(String str) {
            this.f20159g = str;
            return this;
        }

        public Builder withAdNetworkType(String str) {
            this.f20160h = str;
            return this;
        }

        public Builder withAdWidthPx(Double d) {
            this.f20161i = d;
            return this;
        }

        public Builder withAdHeightPx(Double d) {
            this.f20162j = d;
            return this;
        }

        public Builder withDspCreativeId(String str) {
            this.f20163k = str;
            return this;
        }

        public Builder withGeoLat(Double d) {
            this.f20164l = d;
            return this;
        }

        public Builder withGeoLon(Double d) {
            this.f20165m = d;
            return this;
        }

        public Builder withGeoAccuracy(Double d) {
            this.f20166n = d;
            return this;
        }

        public Builder withPerformanceDurationMs(Double d) {
            this.f20167o = d;
            return this;
        }

        public Builder withRequestId(String str) {
            this.f20168p = str;
            return this;
        }

        public Builder withRequestStatusCode(Integer num) {
            this.f20169q = num;
            return this;
        }

        public Builder withRequestUri(String str) {
            this.f20170r = str;
            return this;
        }

        public Builder withRequestRetries(Integer num) {
            this.f20171s = num;
            return this;
        }
    }
}
