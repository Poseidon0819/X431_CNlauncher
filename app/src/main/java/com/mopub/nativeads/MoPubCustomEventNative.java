package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Numbers;
import com.mopub.nativeads.CustomEventNative;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MoPubCustomEventNative extends CustomEventNative {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: a */
    public final void mo2174a(Context context, CustomEventNative.CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> map2) {
        Object obj = map.get(DataKeys.JSON_BODY_KEY);
        if (!(obj instanceof JSONObject)) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        C3841a c3841a = new C3841a(context, (JSONObject) obj, new ImpressionTracker(context), new NativeClickHandler(context), customEventNativeListener);
        try {
            if (!C3841a.m2176a(c3841a.f20825d)) {
                throw new IllegalArgumentException("JSONObject did not contain required keys.");
            }
            Iterator<String> keys = c3841a.f20825d.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C3841a.EnumC3842a from = C3841a.EnumC3842a.from(next);
                if (from != null) {
                    try {
                        c3841a.m2178a(from, c3841a.f20825d.opt(next));
                    } catch (ClassCastException unused) {
                        throw new IllegalArgumentException("JSONObject key (" + next + ") contained unexpected value.");
                    }
                } else {
                    c3841a.addExtra(next, c3841a.f20825d.opt(next));
                }
            }
            c3841a.setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
            Context context2 = c3841a.f20824c;
            ArrayList arrayList = new ArrayList();
            if (c3841a.getMainImageUrl() != null) {
                arrayList.add(c3841a.getMainImageUrl());
            }
            if (c3841a.getIconImageUrl() != null) {
                arrayList.add(c3841a.getIconImageUrl());
            }
            arrayList.addAll(c3841a.m2175c());
            NativeImageHelper.preCacheImages(context2, arrayList, new C3894m(c3841a));
        } catch (IllegalArgumentException unused2) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        }
    }

    /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$a */
    /* loaded from: classes2.dex */
    static class C3841a extends StaticNativeAd {

        /* renamed from: c */
        final Context f20824c;

        /* renamed from: d */
        final JSONObject f20825d;

        /* renamed from: e */
        private final CustomEventNative.CustomEventNativeListener f20826e;

        /* renamed from: f */
        private final ImpressionTracker f20827f;

        /* renamed from: g */
        private final NativeClickHandler f20828g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.MoPubCustomEventNative$a$a */
        /* loaded from: classes2.dex */
        public enum EnumC3842a {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT("text", false),
            MAIN_IMAGE("mainimage", false),
            ICON_IMAGE("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            STAR_RATING("starrating", false);
            
            @VisibleForTesting
            static final Set<String> requiredKeys = new HashSet();
            final String name;
            final boolean required;

            static {
                EnumC3842a[] values;
                for (EnumC3842a enumC3842a : values()) {
                    if (enumC3842a.required) {
                        requiredKeys.add(enumC3842a.name);
                    }
                }
            }

            EnumC3842a(String str, boolean z) {
                this.name = str;
                this.required = z;
            }

            static EnumC3842a from(String str) {
                EnumC3842a[] values;
                for (EnumC3842a enumC3842a : values()) {
                    if (enumC3842a.name.equals(str)) {
                        return enumC3842a;
                    }
                }
                return null;
            }
        }

        C3841a(Context context, JSONObject jSONObject, ImpressionTracker impressionTracker, NativeClickHandler nativeClickHandler, CustomEventNative.CustomEventNativeListener customEventNativeListener) {
            this.f20825d = jSONObject;
            this.f20824c = context.getApplicationContext();
            this.f20827f = impressionTracker;
            this.f20828g = nativeClickHandler;
            this.f20826e = customEventNativeListener;
        }

        /* renamed from: a */
        static boolean m2176a(JSONObject jSONObject) {
            HashSet hashSet = new HashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
            return hashSet.containsAll(EnumC3842a.requiredKeys);
        }

        /* renamed from: a */
        final void m2178a(EnumC3842a enumC3842a, Object obj) throws ClassCastException {
            try {
                switch (enumC3842a) {
                    case MAIN_IMAGE:
                        setMainImageUrl((String) obj);
                        return;
                    case ICON_IMAGE:
                        setIconImageUrl((String) obj);
                        return;
                    case IMPRESSION_TRACKER:
                        m2204a(obj);
                        return;
                    case CLICK_DESTINATION:
                        setClickDestinationUrl((String) obj);
                        return;
                    case CLICK_TRACKER:
                        if (obj instanceof JSONArray) {
                            m2202b(obj);
                            return;
                        } else {
                            addClickTracker((String) obj);
                            return;
                        }
                    case CALL_TO_ACTION:
                        setCallToAction((String) obj);
                        return;
                    case TITLE:
                        setTitle((String) obj);
                        return;
                    case TEXT:
                        setText((String) obj);
                        return;
                    case STAR_RATING:
                        setStarRating(Numbers.parseDouble(obj));
                        return;
                    default:
                        MoPubLog.m2498d("Unable to add JSON key to internal mapping: " + enumC3842a.name);
                        return;
                }
            } catch (ClassCastException e) {
                if (!enumC3842a.required) {
                    MoPubLog.m2498d("Ignoring class cast exception for optional key: " + enumC3842a.name);
                    return;
                }
                throw e;
            }
        }

        /* renamed from: c */
        final List<String> m2175c() {
            ArrayList arrayList = new ArrayList(getExtras().size());
            for (Map.Entry<String, Object> entry : getExtras().entrySet()) {
                String key = entry.getKey();
                if ((key != null && key.toLowerCase(Locale.US).endsWith("image")) && (entry.getValue() instanceof String)) {
                    arrayList.add((String) entry.getValue());
                }
            }
            return arrayList;
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public final void prepare(View view) {
            this.f20827f.addView(view, this);
            this.f20828g.setOnClickListener(view, this);
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public final void clear(View view) {
            this.f20827f.removeView(view);
            this.f20828g.clearOnClickListener(view);
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.BaseNativeAd
        public final void destroy() {
            this.f20827f.destroy();
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.ImpressionInterface
        public final void recordImpression(View view) {
            m2205a();
        }

        @Override // com.mopub.nativeads.StaticNativeAd, com.mopub.nativeads.ClickInterface
        public final void handleClick(View view) {
            if (this.f20753b != null) {
                this.f20753b.onAdClicked();
            }
            this.f20828g.openClickDestinationUrl(getClickDestinationUrl(), view);
        }
    }
}
