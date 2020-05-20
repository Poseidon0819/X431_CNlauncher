package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.AdRequestStatusMapping;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MoPubRewardedVideoManager {
    public static final int API_VERSION = 1;

    /* renamed from: a */
    private static MoPubRewardedVideoManager f20360a;

    /* renamed from: c */
    private WeakReference<Activity> f20362c;

    /* renamed from: d */
    private final Context f20363d;

    /* renamed from: e */
    private final AdRequestStatusMapping f20364e;

    /* renamed from: g */
    private MoPubRewardedVideoListener f20366g;

    /* renamed from: i */
    private final Map<String, Set<MediationSettings>> f20368i;

    /* renamed from: j */
    private final Handler f20369j;

    /* renamed from: k */
    private final Map<String, Runnable> f20370k;

    /* renamed from: f */
    private final RewardedVideoData f20365f = new RewardedVideoData();

    /* renamed from: b */
    private final Handler f20361b = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    private final Set<MediationSettings> f20367h = new HashSet();

    /* loaded from: classes.dex */
    public static class RewardedVideoRequestListener implements AdRequest.Listener {

        /* renamed from: a */
        private final MoPubRewardedVideoManager f20372a;
        public final String adUnitId;

        public RewardedVideoRequestListener(MoPubRewardedVideoManager moPubRewardedVideoManager, String str) {
            this.adUnitId = str;
            this.f20372a = moPubRewardedVideoManager;
        }

        @Override // com.mopub.network.AdRequest.Listener
        public void onSuccess(AdResponse adResponse) {
            MoPubRewardedVideoManager.m2414a(this.f20372a, adResponse, this.adUnitId);
        }

        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            MoPubRewardedVideoManager.m2413a(this.f20372a, volleyError, this.adUnitId);
        }
    }

    /* loaded from: classes.dex */
    public static final class RequestParameters {
        public final String mCustomerId;
        public final String mKeywords;
        public final Location mLocation;

        public RequestParameters(String str) {
            this(str, null);
        }

        public RequestParameters(String str, Location location) {
            this(str, location, null);
        }

        public RequestParameters(String str, Location location, String str2) {
            this.mKeywords = str;
            this.mLocation = location;
            this.mCustomerId = str2;
        }
    }

    private MoPubRewardedVideoManager(Activity activity, MediationSettings... mediationSettingsArr) {
        this.f20362c = new WeakReference<>(activity);
        this.f20363d = activity.getApplicationContext();
        MoPubCollections.addAllNonNull(this.f20367h, mediationSettingsArr);
        this.f20368i = new HashMap();
        this.f20369j = new Handler();
        this.f20370k = new HashMap();
        this.f20364e = new AdRequestStatusMapping();
    }

    public static synchronized void init(Activity activity, MediationSettings... mediationSettingsArr) {
        synchronized (MoPubRewardedVideoManager.class) {
            if (f20360a == null) {
                f20360a = new MoPubRewardedVideoManager(activity, mediationSettingsArr);
            } else {
                MoPubLog.m2496e("Tried to call initializeRewardedVideo more than once. Only the first initialization call has any effect.");
            }
        }
    }

    @ReflectionTarget
    public static void updateActivity(Activity activity) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f20362c = new WeakReference<>(activity);
        } else {
            MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
        }
    }

    public static <T extends MediationSettings> T getGlobalMediationSettings(Class<T> cls) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            for (MediationSettings mediationSettings : moPubRewardedVideoManager.f20367h) {
                if (cls.equals(mediationSettings.getClass())) {
                    return cls.cast(mediationSettings);
                }
            }
            return null;
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
        return null;
    }

    public static <T extends MediationSettings> T getInstanceMediationSettings(Class<T> cls, String str) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            Set<MediationSettings> set = moPubRewardedVideoManager.f20368i.get(str);
            if (set == null) {
                return null;
            }
            for (MediationSettings mediationSettings : set) {
                if (cls.equals(mediationSettings.getClass())) {
                    return cls.cast(mediationSettings);
                }
            }
            return null;
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
        return null;
    }

    public static void setVideoListener(MoPubRewardedVideoListener moPubRewardedVideoListener) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f20366g = moPubRewardedVideoListener;
        } else {
            MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
        }
    }

    public static void loadVideo(String str, RequestParameters requestParameters, MediationSettings... mediationSettingsArr) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            if (!TextUtils.isEmpty(moPubRewardedVideoManager.f20365f.f20515f)) {
                MoPubLog.m2498d(String.format(Locale.US, "Did not queue rewarded video request for ad unit %s. The video is already showing.", str));
                return;
            } else if (f20360a.f20364e.m2473c(str)) {
                MoPubLog.m2498d(String.format(Locale.US, "Did not queue rewarded video request for ad unit %s. This ad unit already finished loading and is ready to show.", str));
                m2410a(new RunnableC3783n(str));
                return;
            } else {
                HashSet hashSet = new HashSet();
                MoPubCollections.addAllNonNull(hashSet, mediationSettingsArr);
                f20360a.f20368i.put(str, hashSet);
                String str2 = requestParameters == null ? null : requestParameters.mCustomerId;
                if (!TextUtils.isEmpty(str2)) {
                    f20360a.f20365f.f20516g = str2;
                }
                m2406a(str, new WebViewAdUrlGenerator(f20360a.f20363d, false).withAdUnitId(str).withKeywords(requestParameters == null ? null : requestParameters.mKeywords).withLocation(requestParameters != null ? requestParameters.mLocation : null).generateUrlString(Constants.HOST));
                return;
            }
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
    }

    /* renamed from: a */
    private static void m2406a(String str, String str2) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            if (moPubRewardedVideoManager.f20364e.m2472d(str)) {
                MoPubLog.m2498d(String.format(Locale.US, "Did not queue rewarded video request for ad unit %s. A request is already pending.", str));
                return;
            }
            AdFormat adFormat = AdFormat.REWARDED_VIDEO;
            MoPubRewardedVideoManager moPubRewardedVideoManager2 = f20360a;
            Networking.getRequestQueue(f20360a.f20363d).add(new AdRequest(str2, adFormat, str, moPubRewardedVideoManager2.f20363d, new RewardedVideoRequestListener(moPubRewardedVideoManager2, str)));
            f20360a.f20364e.m2474b(str);
            return;
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
    }

    public static boolean hasVideo(String str) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            return m2408a(str, moPubRewardedVideoManager.f20365f.m2313a(str));
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void showVideo(String str) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            CustomEventRewardedVideo m2313a = moPubRewardedVideoManager.f20365f.m2313a(str);
            if (m2408a(str, m2313a)) {
                RewardedVideoData rewardedVideoData = f20360a.f20365f;
                Class<?> cls = m2313a.getClass();
                Preconditions.checkNotNull(cls);
                rewardedVideoData.f20513d.put(cls, f20360a.f20365f.f20511b.get(str));
                MoPubRewardedVideoManager moPubRewardedVideoManager2 = f20360a;
                moPubRewardedVideoManager2.f20365f.f20515f = str;
                AdRequestStatusMapping adRequestStatusMapping = moPubRewardedVideoManager2.f20364e;
                if (adRequestStatusMapping.f20268a.containsKey(str)) {
                    adRequestStatusMapping.f20268a.get(str).f20269a = AdRequestStatusMapping.EnumC3719b.PLAYED;
                } else {
                    adRequestStatusMapping.f20268a.put(str, new AdRequestStatusMapping.C3718a(AdRequestStatusMapping.EnumC3719b.PLAYED));
                }
                m2313a.mo2418d();
                return;
            }
            f20360a.m2403b(str, MoPubErrorCode.VIDEO_NOT_AVAILABLE);
            return;
        }
        MoPubLog.m2496e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
    }

    /* renamed from: a */
    private static boolean m2408a(String str, CustomEventRewardedVideo customEventRewardedVideo) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        return moPubRewardedVideoManager != null && moPubRewardedVideoManager.f20364e.m2473c(str) && customEventRewardedVideo != null && customEventRewardedVideo.mo2420c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2403b(String str, MoPubErrorCode moPubErrorCode) {
        String m2471e = this.f20364e.m2471e(str);
        this.f20364e.m2475a(str);
        if (m2471e != null) {
            m2406a(str, m2471e);
            return;
        }
        MoPubRewardedVideoListener moPubRewardedVideoListener = this.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoLoadFailure(str, moPubErrorCode);
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoLoadSuccess(Class<T> cls, String str) {
        m2410a(new C3799v(cls, str));
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoLoadFailure(Class<T> cls, String str, MoPubErrorCode moPubErrorCode) {
        m2410a(new C3800w(cls, str, moPubErrorCode));
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoStarted(Class<T> cls, String str) {
        String str2 = f20360a.f20365f.f20515f;
        if (TextUtils.isEmpty(str2)) {
            m2410a(new C3801x(cls, str));
        } else {
            m2410a(new RunnableC3802y(str2));
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoPlaybackError(Class<T> cls, String str, MoPubErrorCode moPubErrorCode) {
        String str2 = f20360a.f20365f.f20515f;
        if (TextUtils.isEmpty(str2)) {
            m2410a(new C3803z(cls, str, moPubErrorCode));
        } else {
            m2410a(new RunnableC3741aa(str2, moPubErrorCode));
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoClicked(Class<T> cls, String str) {
        String str2 = f20360a.f20365f.f20515f;
        if (TextUtils.isEmpty(str2)) {
            m2410a(new C3742ab(cls, str));
        } else {
            m2410a(new RunnableC3788o(str2));
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoClosed(Class<T> cls, String str) {
        String str2 = f20360a.f20365f.f20515f;
        if (TextUtils.isEmpty(str2)) {
            m2410a(new C3789p(cls, str));
        } else {
            m2410a(new RunnableC3790q(str2));
        }
        f20360a.f20365f.f20515f = null;
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoCompleted(Class<T> cls, String str, MoPubReward moPubReward) {
        String str2 = f20360a.f20365f.f20515f;
        String str3 = TextUtils.isEmpty(str2) ? null : f20360a.f20365f.f20512c.get(str2);
        if (TextUtils.isEmpty(str3)) {
            m2410a(new RunnableC3792s(cls, moPubReward, str2, str));
        } else {
            m2410a(new RunnableC3793t(str3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public static MoPubReward m2416a(MoPubReward moPubReward, MoPubReward moPubReward2) {
        return (moPubReward2.isSuccessful() && moPubReward != null) ? moPubReward : moPubReward2;
    }

    /* renamed from: a */
    private static void m2410a(Runnable runnable) {
        MoPubRewardedVideoManager moPubRewardedVideoManager = f20360a;
        if (moPubRewardedVideoManager != null) {
            moPubRewardedVideoManager.f20361b.post(runnable);
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideoManager$a */
    /* loaded from: classes.dex */
    static abstract class AbstractRunnableC3731a implements Runnable {

        /* renamed from: a */
        private final Class<? extends CustomEventRewardedVideo> f20373a;

        /* renamed from: b */
        private final String f20374b;

        /* renamed from: a */
        protected abstract void mo2277a(String str);

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractRunnableC3731a(Class<? extends CustomEventRewardedVideo> cls, String str) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(str);
            this.f20373a = cls;
            this.f20374b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : MoPubRewardedVideoManager.f20360a.f20365f.m2315a(this.f20373a, this.f20374b)) {
                mo2277a(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    static /* synthetic */ void m2414a(MoPubRewardedVideoManager moPubRewardedVideoManager, AdResponse adResponse, String str) {
        moPubRewardedVideoManager.f20364e.f20268a.put(str, new AdRequestStatusMapping.C3718a(AdRequestStatusMapping.EnumC3719b.LOADED, adResponse.getFailoverUrl(), adResponse.getImpressionTrackingUrl(), adResponse.getClickTrackingUrl()));
        Integer adTimeoutMillis = adResponse.getAdTimeoutMillis();
        adTimeoutMillis = (adTimeoutMillis == null || adTimeoutMillis.intValue() <= 0) ? 30000 : 30000;
        String customEventClassName = adResponse.getCustomEventClassName();
        if (customEventClassName == null) {
            MoPubLog.m2496e("Couldn't create custom event, class name was null.");
            moPubRewardedVideoManager.m2403b(str, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        CustomEventRewardedVideo m2313a = moPubRewardedVideoManager.f20365f.m2313a(str);
        if (m2313a != null) {
            m2313a.mo2423b();
        }
        try {
            CustomEventRewardedVideo customEventRewardedVideo = (CustomEventRewardedVideo) Reflection.instantiateClassWithEmptyConstructor(customEventClassName, CustomEventRewardedVideo.class);
            TreeMap treeMap = new TreeMap();
            treeMap.put(DataKeys.AD_UNIT_ID_KEY, str);
            treeMap.put(DataKeys.REWARDED_VIDEO_CURRENCY_NAME_KEY, adResponse.getRewardedVideoCurrencyName());
            treeMap.put(DataKeys.REWARDED_VIDEO_CURRENCY_AMOUNT_STRING_KEY, adResponse.getRewardedVideoCurrencyAmount());
            treeMap.put(DataKeys.AD_REPORT_KEY, new AdReport(str, ClientMetadata.getInstance(moPubRewardedVideoManager.f20363d), adResponse));
            treeMap.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(Utils.generateUniqueId()));
            treeMap.put(DataKeys.REWARDED_VIDEO_CUSTOMER_ID, moPubRewardedVideoManager.f20365f.f20516g);
            RewardedVideoData rewardedVideoData = moPubRewardedVideoManager.f20365f;
            String rewardedVideoCurrencyName = adResponse.getRewardedVideoCurrencyName();
            String rewardedVideoCurrencyAmount = adResponse.getRewardedVideoCurrencyAmount();
            Preconditions.checkNotNull(str);
            if (rewardedVideoCurrencyName == null || rewardedVideoCurrencyAmount == null) {
                rewardedVideoData.f20511b.remove(str);
            } else {
                try {
                    int parseInt = Integer.parseInt(rewardedVideoCurrencyAmount);
                    if (parseInt >= 0) {
                        rewardedVideoData.f20511b.put(str, MoPubReward.success(rewardedVideoCurrencyName, parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
            RewardedVideoData rewardedVideoData2 = moPubRewardedVideoManager.f20365f;
            String rewardedVideoCompletionUrl = adResponse.getRewardedVideoCompletionUrl();
            Preconditions.checkNotNull(str);
            rewardedVideoData2.f20512c.put(str, rewardedVideoCompletionUrl);
            Activity activity = moPubRewardedVideoManager.f20362c.get();
            if (activity == null) {
                MoPubLog.m2498d("Could not load custom event because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded videos.");
                moPubRewardedVideoManager.f20364e.m2475a(str);
                return;
            }
            RunnableC3794u runnableC3794u = new RunnableC3794u(moPubRewardedVideoManager, customEventRewardedVideo);
            moPubRewardedVideoManager.f20369j.postDelayed(runnableC3794u, adTimeoutMillis.intValue());
            moPubRewardedVideoManager.f20370k.put(str, runnableC3794u);
            customEventRewardedVideo.m2441a(activity, treeMap, adResponse.getServerExtras());
            String mo2425a = customEventRewardedVideo.mo2425a();
            RewardedVideoData rewardedVideoData3 = moPubRewardedVideoManager.f20365f;
            rewardedVideoData3.f20510a.put(str, customEventRewardedVideo);
            rewardedVideoData3.f20514e.add(null);
            rewardedVideoData3.m2314a(customEventRewardedVideo.getClass(), mo2425a, str);
        } catch (Exception unused2) {
            MoPubLog.m2496e(String.format(Locale.US, "Couldn't create custom event with class name %s", customEventClassName));
            moPubRewardedVideoManager.m2403b(str, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2413a(MoPubRewardedVideoManager moPubRewardedVideoManager, VolleyError volleyError, String str) {
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case NO_FILL:
                case WARMING_UP:
                    moPubErrorCode = MoPubErrorCode.NO_FILL;
                    break;
                default:
                    moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                    break;
            }
        }
        if (volleyError instanceof NoConnectionError) {
            moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
        }
        moPubRewardedVideoManager.m2403b(str, moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2412a(MoPubRewardedVideoManager moPubRewardedVideoManager, String str) {
        Runnable remove = moPubRewardedVideoManager.f20370k.remove(str);
        if (remove != null) {
            moPubRewardedVideoManager.f20369j.removeCallbacks(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2409a(String str) {
        Preconditions.checkNotNull(str);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoStarted(str);
        }
        AdRequestStatusMapping adRequestStatusMapping = f20360a.f20364e;
        TrackingRequest.makeTrackingHttpRequest(!adRequestStatusMapping.f20268a.containsKey(str) ? null : adRequestStatusMapping.f20268a.get(str).f20271c, f20360a.f20363d);
        AdRequestStatusMapping adRequestStatusMapping2 = f20360a.f20364e;
        if (adRequestStatusMapping2.f20268a.containsKey(str)) {
            adRequestStatusMapping2.f20268a.get(str).f20271c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2407a(String str, MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoPlaybackError(str, moPubErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m2404b(String str) {
        Preconditions.checkNotNull(str);
        AdRequestStatusMapping adRequestStatusMapping = f20360a.f20364e;
        TrackingRequest.makeTrackingHttpRequest(!adRequestStatusMapping.f20268a.containsKey(str) ? null : adRequestStatusMapping.f20268a.get(str).f20272d, f20360a.f20363d);
        AdRequestStatusMapping adRequestStatusMapping2 = f20360a.f20364e;
        if (adRequestStatusMapping2.f20268a.containsKey(str)) {
            adRequestStatusMapping2.f20268a.get(str).f20272d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m2401c(String str) {
        Preconditions.checkNotNull(str);
        MoPubRewardedVideoListener moPubRewardedVideoListener = f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener.onRewardedVideoClosed(str);
        }
    }
}
