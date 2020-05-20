package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MediaLayout;
import com.mopub.nativeads.NativeVideoController;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(16)
/* loaded from: classes2.dex */
public class MoPubCustomEventVideoNative extends CustomEventNative {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: a */
    public final void mo2174a(Context context, CustomEventNative.CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> map2) {
        Object obj = map.get(DataKeys.JSON_BODY_KEY);
        if (!(obj instanceof JSONObject)) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        Object obj2 = map.get(DataKeys.EVENT_DETAILS);
        EventDetails eventDetails = obj2 instanceof EventDetails ? (EventDetails) obj2 : null;
        C3848d c3848d = new C3848d(map2);
        if (!c3848d.f20861a) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        Object obj3 = map.get(DataKeys.CLICK_TRACKING_URL_KEY);
        if (obj3 instanceof String) {
            String str = (String) obj3;
            if (!TextUtils.isEmpty(str)) {
                MoPubVideoNativeAd moPubVideoNativeAd = new MoPubVideoNativeAd(context, (JSONObject) obj, customEventNativeListener, c3848d, eventDetails, str);
                try {
                    if (!MoPubVideoNativeAd.m2168a(moPubVideoNativeAd.f20833d)) {
                        throw new IllegalArgumentException("JSONObject did not contain required keys.");
                    }
                    Iterator<String> keys = moPubVideoNativeAd.f20833d.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        MoPubVideoNativeAd.EnumC3844a from = MoPubVideoNativeAd.EnumC3844a.from(next);
                        if (from != null) {
                            try {
                                moPubVideoNativeAd.m2171a(from, moPubVideoNativeAd.f20833d.opt(next));
                            } catch (ClassCastException unused) {
                                throw new IllegalArgumentException("JSONObject key (" + next + ") contained unexpected value.");
                            }
                        } else {
                            moPubVideoNativeAd.addExtra(next, moPubVideoNativeAd.f20833d.opt(next));
                        }
                    }
                    moPubVideoNativeAd.setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout/");
                    Context context2 = moPubVideoNativeAd.f20832c;
                    ArrayList arrayList = new ArrayList();
                    if (moPubVideoNativeAd.getMainImageUrl() != null) {
                        arrayList.add(moPubVideoNativeAd.getMainImageUrl());
                    }
                    if (moPubVideoNativeAd.getIconImageUrl() != null) {
                        arrayList.add(moPubVideoNativeAd.getIconImageUrl());
                    }
                    arrayList.addAll(moPubVideoNativeAd.m2165c());
                    NativeImageHelper.preCacheImages(context2, arrayList, new C3896o(moPubVideoNativeAd));
                    return;
                } catch (IllegalArgumentException unused2) {
                    customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    return;
                }
            }
        }
        customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
    }

    @TargetApi(16)
    /* loaded from: classes2.dex */
    public static class MoPubVideoNativeAd extends VideoNativeAd implements AudioManager.OnAudioFocusChangeListener, VastManager.VastManagerListener, NativeVideoController.NativeVideoProgressRunnable.ProgressListener {

        /* renamed from: c */
        final Context f20832c;

        /* renamed from: d */
        final JSONObject f20833d;

        /* renamed from: e */
        VastVideoConfig f20834e;

        /* renamed from: f */
        private VideoState f20835f;

        /* renamed from: g */
        private final VisibilityTracker f20836g;

        /* renamed from: h */
        private final String f20837h;

        /* renamed from: i */
        private final CustomEventNative.CustomEventNativeListener f20838i;

        /* renamed from: j */
        private final C3848d f20839j;

        /* renamed from: k */
        private final C3846b f20840k;

        /* renamed from: l */
        private NativeVideoController f20841l;

        /* renamed from: m */
        private final VastManager f20842m;

        /* renamed from: n */
        private MediaLayout f20843n;

        /* renamed from: o */
        private View f20844o;

        /* renamed from: p */
        private final EventDetails f20845p;

        /* renamed from: q */
        private final long f20846q;

        /* renamed from: r */
        private boolean f20847r;

        /* renamed from: s */
        private boolean f20848s;

        /* renamed from: t */
        private boolean f20849t;

        /* renamed from: u */
        private boolean f20850u;

        /* renamed from: v */
        private int f20851v;

        /* renamed from: w */
        private boolean f20852w;

        /* renamed from: x */
        private boolean f20853x;

        /* renamed from: y */
        private boolean f20854y;

        /* renamed from: z */
        private boolean f20855z;

        /* loaded from: classes2.dex */
        public enum VideoState {
            CREATED,
            LOADING,
            BUFFERING,
            PAUSED,
            PLAYING,
            PLAYING_MUTED,
            ENDED,
            FAILED_LOAD
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$MoPubVideoNativeAd$a */
        /* loaded from: classes2.dex */
        public enum EnumC3844a {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT("text", false),
            IMAGE_URL("mainimage", false),
            ICON_URL("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            VAST_VIDEO("video", false);
            
            @VisibleForTesting
            static final Set<String> requiredKeys = new HashSet();
            final String mName;
            final boolean mRequired;

            static {
                EnumC3844a[] values;
                for (EnumC3844a enumC3844a : values()) {
                    if (enumC3844a.mRequired) {
                        requiredKeys.add(enumC3844a.mName);
                    }
                }
            }

            EnumC3844a(String str, boolean z) {
                Preconditions.checkNotNull(str);
                this.mName = str;
                this.mRequired = z;
            }

            static EnumC3844a from(String str) {
                EnumC3844a[] values;
                Preconditions.checkNotNull(str);
                for (EnumC3844a enumC3844a : values()) {
                    if (enumC3844a.mName.equals(str)) {
                        return enumC3844a;
                    }
                }
                return null;
            }
        }

        public MoPubVideoNativeAd(Context context, JSONObject jSONObject, CustomEventNative.CustomEventNativeListener customEventNativeListener, C3848d c3848d, EventDetails eventDetails, String str) {
            this(context, jSONObject, customEventNativeListener, c3848d, new VisibilityTracker(context), new C3846b(), eventDetails, str, VastManagerFactory.create(context.getApplicationContext(), false));
        }

        @VisibleForTesting
        private MoPubVideoNativeAd(Context context, JSONObject jSONObject, CustomEventNative.CustomEventNativeListener customEventNativeListener, C3848d c3848d, VisibilityTracker visibilityTracker, C3846b c3846b, EventDetails eventDetails, String str, VastManager vastManager) {
            this.f20849t = false;
            this.f20850u = false;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(jSONObject);
            Preconditions.checkNotNull(customEventNativeListener);
            Preconditions.checkNotNull(c3848d);
            Preconditions.checkNotNull(visibilityTracker);
            Preconditions.checkNotNull(c3846b);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(vastManager);
            this.f20832c = context.getApplicationContext();
            this.f20833d = jSONObject;
            this.f20838i = customEventNativeListener;
            this.f20839j = c3848d;
            this.f20840k = c3846b;
            this.f20837h = str;
            this.f20845p = eventDetails;
            this.f20846q = Utils.generateUniqueId();
            this.f20847r = true;
            this.f20835f = VideoState.CREATED;
            this.f20848s = true;
            this.f20851v = 1;
            this.f20854y = true;
            this.f20836g = visibilityTracker;
            this.f20836g.f21125e = new C3895n(this);
            this.f20842m = vastManager;
        }

        @Override // com.mopub.mobileads.VastManager.VastManagerListener
        public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
            if (vastVideoConfig == null) {
                this.f20838i.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            ArrayList arrayList = new ArrayList();
            NativeVideoController.C3853b c3853b = new NativeVideoController.C3853b();
            c3853b.f20982a = new C3845a(this);
            c3853b.f20983b = this.f20839j.f20864d;
            c3853b.f20984c = this.f20839j.f20865e;
            arrayList.add(c3853b);
            this.f20834e = vastVideoConfig;
            VideoViewabilityTracker videoViewabilityTracker = this.f20834e.getVideoViewabilityTracker();
            if (videoViewabilityTracker != null) {
                NativeVideoController.C3853b c3853b2 = new NativeVideoController.C3853b();
                c3853b2.f20982a = new C3847c(this.f20832c, videoViewabilityTracker.getTrackingUrl());
                c3853b2.f20983b = videoViewabilityTracker.getPercentViewable();
                c3853b2.f20984c = videoViewabilityTracker.getViewablePlaytimeMS();
                arrayList.add(c3853b2);
            }
            HashSet<String> hashSet = new HashSet();
            hashSet.add(this.f20837h);
            hashSet.addAll(m2203b());
            ArrayList arrayList2 = new ArrayList();
            for (String str : hashSet) {
                arrayList2.add(new VastTracker(str, false));
            }
            this.f20834e.addClickTrackers(arrayList2);
            this.f20834e.setClickThroughUrl(getClickDestinationUrl());
            this.f20841l = this.f20840k.createForId(this.f20846q, this.f20832c, arrayList, this.f20834e, this.f20845p);
            this.f20838i.onNativeAdLoaded(this);
        }

        /* renamed from: a */
        static boolean m2168a(JSONObject jSONObject) {
            Preconditions.checkNotNull(jSONObject);
            HashSet hashSet = new HashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
            return hashSet.containsAll(EnumC3844a.requiredKeys);
        }

        /* renamed from: a */
        final void m2171a(EnumC3844a enumC3844a, Object obj) throws ClassCastException {
            Preconditions.checkNotNull(enumC3844a);
            Preconditions.checkNotNull(obj);
            try {
                switch (enumC3844a) {
                    case IMPRESSION_TRACKER:
                        m2204a(obj);
                        return;
                    case TITLE:
                        setTitle((String) obj);
                        return;
                    case TEXT:
                        setText((String) obj);
                        return;
                    case IMAGE_URL:
                        setMainImageUrl((String) obj);
                        return;
                    case ICON_URL:
                        setIconImageUrl((String) obj);
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
                    case VAST_VIDEO:
                        setVastVideo((String) obj);
                        return;
                    default:
                        MoPubLog.m2498d("Unable to add JSON key to internal mapping: " + enumC3844a.mName);
                        return;
                }
            } catch (ClassCastException e) {
                if (!enumC3844a.mRequired) {
                    MoPubLog.m2498d("Ignoring class cast exception for optional key: " + enumC3844a.mName);
                    return;
                }
                throw e;
            }
        }

        @Override // com.mopub.nativeads.VideoNativeAd
        public void render(MediaLayout mediaLayout) {
            Preconditions.checkNotNull(mediaLayout);
            this.f20836g.m2059a(this.f20844o, mediaLayout, this.f20839j.f20862b, this.f20839j.f20863c);
            this.f20843n = mediaLayout;
            this.f20843n.initForVideo();
            this.f20843n.setSurfaceTextureListener(new TextureView$SurfaceTextureListenerC3897p(this));
            this.f20843n.setPlayButtonClickListener(new View$OnClickListenerC3898q(this));
            this.f20843n.setMuteControlClickListener(new View$OnClickListenerC3899r(this));
            this.f20843n.setOnClickListener(new View$OnClickListenerC3900s(this));
            if (this.f20841l.getPlaybackState() == 6) {
                this.f20841l.prepare(this);
            }
            m2172a(VideoState.PAUSED, false);
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void prepare(View view) {
            Preconditions.checkNotNull(view);
            this.f20844o = view;
            this.f20844o.setOnClickListener(new View$OnClickListenerC3901t(this));
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void clear(View view) {
            Preconditions.checkNotNull(view);
            this.f20841l.clear();
            m2162d();
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void destroy() {
            m2162d();
            this.f20841l.setPlayWhenReady(false);
            this.f20841l.release(this);
            NativeVideoController.remove(this.f20846q);
            this.f20836g.m2058b();
        }

        @Override // com.mopub.nativeads.NativeVideoController.Listener
        public void onStateChanged(boolean z, int i) {
            this.f20851v = i;
            m2159e();
        }

        @Override // com.mopub.nativeads.NativeVideoController.Listener
        public void onError(Exception exc) {
            MoPubLog.m2489w("Error playing back video.", exc);
            this.f20852w = true;
            m2159e();
        }

        @Override // com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener
        public void updateProgress(int i) {
            this.f20843n.updateProgress(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1 || i == -2) {
                this.f20854y = true;
                m2159e();
            } else if (i == -3) {
                this.f20841l.setAudioVolume(0.3f);
            } else if (i == 1) {
                this.f20841l.setAudioVolume(1.0f);
                m2159e();
            }
        }

        /* renamed from: d */
        private void m2162d() {
            MediaLayout mediaLayout = this.f20843n;
            if (mediaLayout != null) {
                mediaLayout.setMode(MediaLayout.Mode.IMAGE);
                this.f20843n.setSurfaceTextureListener(null);
                this.f20843n.setPlayButtonClickListener(null);
                this.f20843n.setMuteControlClickListener(null);
                this.f20843n.setOnClickListener(null);
                this.f20836g.m2061a(this.f20843n);
                this.f20843n = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public void m2159e() {
            VideoState videoState = this.f20835f;
            if (this.f20852w) {
                videoState = VideoState.FAILED_LOAD;
            } else if (this.f20855z) {
                videoState = VideoState.ENDED;
            } else {
                int i = this.f20851v;
                if (i == 2 || i == 1) {
                    videoState = VideoState.LOADING;
                } else if (i == 3) {
                    videoState = VideoState.BUFFERING;
                } else if (i == 5) {
                    this.f20855z = true;
                    videoState = VideoState.ENDED;
                } else if (i == 4) {
                    if (this.f20853x) {
                        videoState = this.f20854y ? VideoState.PLAYING_MUTED : VideoState.PLAYING;
                    } else {
                        videoState = VideoState.PAUSED;
                    }
                }
            }
            m2172a(videoState, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @VisibleForTesting
        /* renamed from: a */
        public final void m2172a(VideoState videoState, boolean z) {
            VideoState videoState2;
            Preconditions.checkNotNull(videoState);
            if (this.f20834e == null || this.f20841l == null || this.f20843n == null || (videoState2 = this.f20835f) == videoState) {
                return;
            }
            this.f20835f = videoState;
            switch (videoState) {
                case FAILED_LOAD:
                    this.f20834e.handleError(this.f20832c, null, 0);
                    this.f20841l.setAppAudioEnabled(false);
                    this.f20843n.setMode(MediaLayout.Mode.IMAGE);
                    if (videoState2 == VideoState.PLAYING || videoState2 == VideoState.PLAYING_MUTED) {
                        return;
                    }
                    MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.ERROR_FAILED_TO_PLAY, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20845p));
                    return;
                case CREATED:
                case LOADING:
                    this.f20841l.setPlayWhenReady(true);
                    this.f20843n.setMode(MediaLayout.Mode.LOADING);
                    return;
                case BUFFERING:
                    this.f20841l.setPlayWhenReady(true);
                    this.f20843n.setMode(MediaLayout.Mode.BUFFERING);
                    return;
                case PAUSED:
                    if (z) {
                        this.f20850u = false;
                    }
                    if (!z) {
                        this.f20841l.setAppAudioEnabled(false);
                        if (this.f20849t) {
                            TrackingRequest.makeVastTrackingHttpRequest(this.f20834e.getPauseTrackers(), null, Integer.valueOf((int) this.f20841l.getCurrentPosition()), null, this.f20832c);
                            this.f20849t = false;
                            this.f20850u = true;
                        }
                    }
                    this.f20841l.setPlayWhenReady(false);
                    this.f20843n.setMode(MediaLayout.Mode.PAUSED);
                    return;
                case PLAYING:
                    m2173a(videoState2);
                    this.f20841l.setPlayWhenReady(true);
                    this.f20841l.setAudioEnabled(true);
                    this.f20841l.setAppAudioEnabled(true);
                    this.f20843n.setMode(MediaLayout.Mode.PLAYING);
                    this.f20843n.setMuteState(MediaLayout.MuteState.UNMUTED);
                    return;
                case PLAYING_MUTED:
                    m2173a(videoState2);
                    this.f20841l.setPlayWhenReady(true);
                    this.f20841l.setAudioEnabled(false);
                    this.f20841l.setAppAudioEnabled(false);
                    this.f20843n.setMode(MediaLayout.Mode.PLAYING);
                    this.f20843n.setMuteState(MediaLayout.MuteState.MUTED);
                    return;
                case ENDED:
                    if (this.f20841l.hasFinalFrame()) {
                        this.f20843n.setMainImageDrawable(this.f20841l.getFinalFrame());
                    }
                    this.f20849t = false;
                    this.f20850u = false;
                    this.f20834e.handleComplete(this.f20832c, 0);
                    this.f20841l.setAppAudioEnabled(false);
                    this.f20843n.setMode(MediaLayout.Mode.FINISHED);
                    this.f20843n.updateProgress(1000);
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        private void m2173a(VideoState videoState) {
            if (this.f20850u && videoState != VideoState.PLAYING && videoState != VideoState.PLAYING_MUTED) {
                TrackingRequest.makeVastTrackingHttpRequest(this.f20834e.getResumeTrackers(), null, Integer.valueOf((int) this.f20841l.getCurrentPosition()), null, this.f20832c);
                this.f20850u = false;
            }
            this.f20849t = true;
            if (this.f20847r) {
                this.f20847r = false;
                NativeVideoController nativeVideoController = this.f20841l;
                nativeVideoController.seekTo(nativeVideoController.getCurrentPosition());
            }
        }

        /* renamed from: c */
        final List<String> m2165c() {
            ArrayList arrayList = new ArrayList(getExtras().size());
            for (Map.Entry<String, Object> entry : getExtras().entrySet()) {
                String key = entry.getKey();
                if ((key != null && key.toLowerCase(Locale.US).endsWith("image")) && (entry.getValue() instanceof String)) {
                    arrayList.add((String) entry.getValue());
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: l */
        public static /* synthetic */ void m2150l(MoPubVideoNativeAd moPubVideoNativeAd) {
            moPubVideoNativeAd.f20847r = true;
            moPubVideoNativeAd.f20848s = true;
            moPubVideoNativeAd.f20841l.setListener(null);
            moPubVideoNativeAd.f20841l.setOnAudioFocusChangeListener(null);
            moPubVideoNativeAd.f20841l.setProgressListener(null);
            moPubVideoNativeAd.f20841l.clear();
            moPubVideoNativeAd.m2172a(VideoState.PAUSED, true);
        }
    }

    @TargetApi(16)
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$a */
    /* loaded from: classes2.dex */
    static class C3845a implements NativeVideoController.C3853b.InterfaceC3854a {

        /* renamed from: a */
        private final WeakReference<MoPubVideoNativeAd> f20858a;

        C3845a(MoPubVideoNativeAd moPubVideoNativeAd) {
            this.f20858a = new WeakReference<>(moPubVideoNativeAd);
        }

        @Override // com.mopub.nativeads.NativeVideoController.C3853b.InterfaceC3854a
        public final void execute() {
            MoPubVideoNativeAd moPubVideoNativeAd = this.f20858a.get();
            if (moPubVideoNativeAd != null) {
                moPubVideoNativeAd.m2205a();
            }
        }
    }

    @TargetApi(16)
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$c */
    /* loaded from: classes2.dex */
    static class C3847c implements NativeVideoController.C3853b.InterfaceC3854a {

        /* renamed from: a */
        private final Context f20859a;

        /* renamed from: b */
        private final String f20860b;

        C3847c(Context context, String str) {
            this.f20859a = context.getApplicationContext();
            this.f20860b = str;
        }

        @Override // com.mopub.nativeads.NativeVideoController.C3853b.InterfaceC3854a
        public final void execute() {
            TrackingRequest.makeTrackingHttpRequest(this.f20860b, this.f20859a);
        }
    }

    @TargetApi(16)
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$b */
    /* loaded from: classes2.dex */
    static class C3846b {
        C3846b() {
        }

        public final NativeVideoController createForId(long j, Context context, List<NativeVideoController.C3853b> list, VastVideoConfig vastVideoConfig, EventDetails eventDetails) {
            return NativeVideoController.createForId(j, context, list, vastVideoConfig, eventDetails);
        }
    }

    @TargetApi(16)
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$d */
    /* loaded from: classes2.dex */
    static class C3848d {

        /* renamed from: a */
        boolean f20861a;

        /* renamed from: b */
        int f20862b;

        /* renamed from: c */
        int f20863c;

        /* renamed from: d */
        int f20864d;

        /* renamed from: e */
        int f20865e;

        /* renamed from: f */
        private int f20866f;

        C3848d(Map<String, String> map) {
            try {
                this.f20862b = Integer.parseInt(map.get(DataKeys.PLAY_VISIBLE_PERCENT));
                this.f20863c = Integer.parseInt(map.get(DataKeys.PAUSE_VISIBLE_PERCENT));
                this.f20864d = Integer.parseInt(map.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT));
                this.f20865e = Integer.parseInt(map.get(DataKeys.IMPRESSION_VISIBLE_MS));
                this.f20866f = Integer.parseInt(map.get(DataKeys.MAX_BUFFER_MS));
                this.f20861a = true;
            } catch (NumberFormatException unused) {
                this.f20861a = false;
            }
        }
    }
}
