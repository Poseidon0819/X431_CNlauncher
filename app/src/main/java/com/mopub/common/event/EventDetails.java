package com.mopub.common.event;

import com.mopub.common.Preconditions;
import com.mopub.common.util.Json;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EventDetails {

    /* renamed from: a */
    private final Map<String, String> f20192a;

    /* synthetic */ EventDetails(Map map, byte b) {
        this(map);
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private final Map<String, String> f20193a = new HashMap();

        public Builder adUnitId(String str) {
            if (str != null) {
                this.f20193a.put("ad_unit_id", str);
            }
            return this;
        }

        public Builder dspCreativeId(String str) {
            if (str != null) {
                this.f20193a.put("dsp_creative_id", str);
            }
            return this;
        }

        public Builder adType(String str) {
            if (str != null) {
                this.f20193a.put("ad_type", str);
            }
            return this;
        }

        public Builder adNetworkType(String str) {
            if (str != null) {
                this.f20193a.put("ad_network_type", str);
            }
            return this;
        }

        public Builder adWidthPx(Integer num) {
            if (num != null) {
                this.f20193a.put("ad_width_px", String.valueOf(num));
            }
            return this;
        }

        public Builder adHeightPx(Integer num) {
            if (num != null) {
                this.f20193a.put("ad_height_px_key", String.valueOf(num));
            }
            return this;
        }

        public Builder geoLatitude(Double d) {
            if (d != null) {
                this.f20193a.put("geo_latitude", String.valueOf(d));
            }
            return this;
        }

        public Builder geoLongitude(Double d) {
            if (d != null) {
                this.f20193a.put("geo_longitude", String.valueOf(d));
            }
            return this;
        }

        public Builder geoAccuracy(Float f) {
            if (f != null) {
                this.f20193a.put("geo_accuracy_key", String.valueOf(f.floatValue()));
            }
            return this;
        }

        public Builder performanceDurationMs(Long l) {
            if (l != null) {
                this.f20193a.put("performance_duration_ms", String.valueOf(l.longValue()));
            }
            return this;
        }

        public Builder requestId(String str) {
            if (str != null) {
                this.f20193a.put("request_id_key", str);
            }
            return this;
        }

        public Builder requestStatusCode(Integer num) {
            if (num != null) {
                this.f20193a.put("request_status_code", String.valueOf(num));
            }
            return this;
        }

        public Builder requestUri(String str) {
            if (str != null) {
                this.f20193a.put("request_uri_key", str);
            }
            return this;
        }

        public EventDetails build() {
            return new EventDetails(this.f20193a, (byte) 0);
        }
    }

    private EventDetails(Map<String, String> map) {
        Preconditions.checkNotNull(map);
        this.f20192a = map;
    }

    public String getAdUnitId() {
        return this.f20192a.get("ad_unit_id");
    }

    public String getDspCreativeId() {
        return this.f20192a.get("dsp_creative_id");
    }

    public String getAdType() {
        return this.f20192a.get("ad_type");
    }

    public String getAdNetworkType() {
        return this.f20192a.get("ad_network_type");
    }

    public Double getAdWidthPx() {
        return m2508a(this.f20192a, "ad_width_px");
    }

    public Double getAdHeightPx() {
        return m2508a(this.f20192a, "ad_height_px_key");
    }

    public Double getGeoLatitude() {
        return m2508a(this.f20192a, "geo_latitude");
    }

    public Double getGeoLongitude() {
        return m2508a(this.f20192a, "geo_longitude");
    }

    public Double getGeoAccuracy() {
        return m2508a(this.f20192a, "geo_accuracy_key");
    }

    public Double getPerformanceDurationMs() {
        return m2508a(this.f20192a, "performance_duration_ms");
    }

    public String getRequestId() {
        return this.f20192a.get("request_id_key");
    }

    public Integer getRequestStatusCode() {
        return m2507b(this.f20192a, "request_status_code");
    }

    public String getRequestUri() {
        return this.f20192a.get("request_uri_key");
    }

    public String toJsonString() {
        return Json.mapToJsonString(this.f20192a);
    }

    public String toString() {
        return toJsonString();
    }

    /* renamed from: a */
    private static Double m2508a(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static Integer m2507b(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
