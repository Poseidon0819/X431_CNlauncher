package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.GpsHelper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class MoPubNative {

    /* renamed from: a */
    static final MoPubNativeNetworkListener f20867a = new C3902u();

    /* renamed from: b */
    final WeakReference<Context> f20868b;

    /* renamed from: c */
    MoPubNativeNetworkListener f20869c;

    /* renamed from: d */
    AdRendererRegistry f20870d;

    /* renamed from: e */
    private final String f20871e;

    /* renamed from: f */
    private Map<String, Object> f20872f;

    /* renamed from: g */
    private final AdRequest.Listener f20873g;

    /* renamed from: h */
    private AdRequest f20874h;

    /* loaded from: classes2.dex */
    public interface MoPubNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(NativeAd nativeAd);
    }

    public MoPubNative(Context context, String str, MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this(context, str, new AdRendererRegistry(), moPubNativeNetworkListener);
    }

    @VisibleForTesting
    public MoPubNative(Context context, String str, AdRendererRegistry adRendererRegistry, MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this.f20872f = new TreeMap();
        Preconditions.checkNotNull(context, "context may not be null.");
        Preconditions.checkNotNull(str, "AdUnitId may not be null.");
        Preconditions.checkNotNull(adRendererRegistry, "AdRendererRegistry may not be null.");
        Preconditions.checkNotNull(moPubNativeNetworkListener, "MoPubNativeNetworkListener may not be null.");
        ManifestUtils.checkNativeActivitiesDeclared(context);
        this.f20868b = new WeakReference<>(context);
        this.f20871e = str;
        this.f20869c = moPubNativeNetworkListener;
        this.f20870d = adRendererRegistry;
        this.f20873g = new C3903v(this);
        GpsHelper.fetchAdvertisingInfoAsync(context, null);
    }

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.f20870d.registerAdRenderer(moPubAdRenderer);
    }

    public void destroy() {
        this.f20868b.clear();
        AdRequest adRequest = this.f20874h;
        if (adRequest != null) {
            adRequest.cancel();
            this.f20874h = null;
        }
        this.f20869c = f20867a;
    }

    public void setLocalExtras(Map<String, Object> map) {
        if (map == null) {
            this.f20872f = new TreeMap();
        } else {
            this.f20872f = new TreeMap(map);
        }
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        makeRequest(requestParameters, null);
    }

    public void makeRequest(RequestParameters requestParameters, Integer num) {
        Context m2148a = m2148a();
        if (m2148a == null) {
            return;
        }
        if (!DeviceUtils.isNetworkAvailable(m2148a)) {
            this.f20869c.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            return;
        }
        Context m2148a2 = m2148a();
        if (m2148a2 != null) {
            NativeUrlGenerator m2082a = new NativeUrlGenerator(m2148a2).withAdUnitId(this.f20871e).m2082a(requestParameters);
            if (num != null) {
                m2082a.f21078f = String.valueOf(num.intValue());
            }
            String generateUrlString = m2082a.generateUrlString(Constants.HOST);
            if (generateUrlString != null) {
                MoPubLog.m2498d("Loading ad from: ".concat(String.valueOf(generateUrlString)));
            }
            m2145a(generateUrlString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2145a(String str) {
        Context m2148a = m2148a();
        if (m2148a == null) {
            return;
        }
        if (str == null) {
            this.f20869c.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
            return;
        }
        this.f20874h = new AdRequest(str, AdFormat.NATIVE, this.f20871e, m2148a, this.f20873g);
        Networking.getRequestQueue(m2148a).add(this.f20874h);
    }

    /* renamed from: com.mopub.nativeads.MoPubNative$1 */
    /* loaded from: classes2.dex */
    final /* synthetic */ class C38491 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20875a = new int[MoPubNetworkError.Reason.values().length];

        static {
            try {
                f20875a[MoPubNetworkError.Reason.BAD_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20875a[MoPubNetworkError.Reason.BAD_HEADER_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20875a[MoPubNetworkError.Reason.WARMING_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20875a[MoPubNetworkError.Reason.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20875a[MoPubNetworkError.Reason.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final Context m2148a() {
        Context context = this.f20868b.get();
        if (context == null) {
            destroy();
            MoPubLog.m2498d("Weak reference to Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2146a(MoPubNative moPubNative, AdResponse adResponse) {
        Context m2148a = moPubNative.m2148a();
        if (m2148a != null) {
            CustomEventNativeAdapter.loadNativeAd(m2148a, moPubNative.f20872f, adResponse, new C3904w(moPubNative, adResponse));
        }
    }
}
