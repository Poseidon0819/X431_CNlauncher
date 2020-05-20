package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.mapapi.UIMsg;
import com.google.android.p328a.ExoPlaybackException;
import com.google.android.p328a.ExoPlayer;
import com.google.android.p328a.ExoPlayerImpl;
import com.google.android.p328a.MediaCodecAudioTrackRenderer;
import com.google.android.p328a.MediaCodecSelector;
import com.google.android.p328a.MediaCodecVideoTrackRenderer;
import com.google.android.p328a.p331c.ExtractorSampleSource;
import com.google.android.p328a.p331c.p334c.Mp4Extractor;
import com.google.android.p328a.p339e.DefaultAllocator;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.nativeads.VisibilityTracker;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(16)
/* loaded from: classes2.dex */
public class NativeVideoController implements AudioManager.OnAudioFocusChangeListener, ExoPlayer.InterfaceC3156b {
    public static final long RESUME_FINISHED_THRESHOLD = 750;
    public static final int STATE_BUFFERING = 3;
    public static final int STATE_CLEARED = 6;
    public static final int STATE_ENDED = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_PREPARING = 2;
    public static final int STATE_READY = 4;

    /* renamed from: a */
    private static final Map<Long, NativeVideoController> f20950a = new HashMap(4);

    /* renamed from: b */
    private final Context f20951b;

    /* renamed from: c */
    private final Handler f20952c;

    /* renamed from: d */
    private final C3852a f20953d;

    /* renamed from: e */
    private VastVideoConfig f20954e;

    /* renamed from: f */
    private NativeVideoProgressRunnable f20955f;

    /* renamed from: g */
    private AudioManager f20956g;

    /* renamed from: h */
    private Listener f20957h;

    /* renamed from: i */
    private AudioManager.OnAudioFocusChangeListener f20958i;

    /* renamed from: j */
    private Surface f20959j;

    /* renamed from: k */
    private TextureView f20960k;

    /* renamed from: l */
    private WeakReference<Object> f20961l;

    /* renamed from: m */
    private volatile ExoPlayer f20962m;

    /* renamed from: n */
    private BitmapDrawable f20963n;

    /* renamed from: o */
    private MediaCodecAudioTrackRenderer f20964o;

    /* renamed from: p */
    private MediaCodecVideoTrackRenderer f20965p;

    /* renamed from: q */
    private EventDetails f20966q;

    /* renamed from: r */
    private boolean f20967r;

    /* renamed from: s */
    private boolean f20968s;

    /* renamed from: t */
    private boolean f20969t;

    /* renamed from: u */
    private int f20970u;

    /* renamed from: v */
    private boolean f20971v;

    /* loaded from: classes2.dex */
    public interface Listener {
        void onError(Exception exc);

        void onStateChanged(boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.NativeVideoController$b */
    /* loaded from: classes2.dex */
    public static class C3853b {

        /* renamed from: a */
        InterfaceC3854a f20982a;

        /* renamed from: b */
        int f20983b;

        /* renamed from: c */
        int f20984c;

        /* renamed from: d */
        int f20985d;

        /* renamed from: e */
        boolean f20986e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.NativeVideoController$b$a */
        /* loaded from: classes2.dex */
        public interface InterfaceC3854a {
            void execute();
        }
    }

    @Override // com.google.android.p328a.ExoPlayer.InterfaceC3156b
    public void onPlayWhenReadyCommitted() {
    }

    public static NativeVideoController createForId(long j, Context context, List<C3853b> list, VastVideoConfig vastVideoConfig, EventDetails eventDetails) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, list, vastVideoConfig, eventDetails);
        f20950a.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    @VisibleForTesting
    public static NativeVideoController createForId(long j, Context context, VastVideoConfig vastVideoConfig, NativeVideoProgressRunnable nativeVideoProgressRunnable, C3852a c3852a, EventDetails eventDetails, AudioManager audioManager) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, vastVideoConfig, nativeVideoProgressRunnable, c3852a, eventDetails, audioManager);
        f20950a.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    @VisibleForTesting
    public static void setForId(long j, NativeVideoController nativeVideoController) {
        f20950a.put(Long.valueOf(j), nativeVideoController);
    }

    public static NativeVideoController getForId(long j) {
        return f20950a.get(Long.valueOf(j));
    }

    public static NativeVideoController remove(long j) {
        return f20950a.remove(Long.valueOf(j));
    }

    private NativeVideoController(Context context, List<C3853b> list, VastVideoConfig vastVideoConfig, EventDetails eventDetails) {
        this(context, vastVideoConfig, new NativeVideoProgressRunnable(context, new Handler(Looper.getMainLooper()), list, vastVideoConfig), new C3852a(), eventDetails, (AudioManager) context.getSystemService("audio"));
    }

    private NativeVideoController(Context context, VastVideoConfig vastVideoConfig, NativeVideoProgressRunnable nativeVideoProgressRunnable, C3852a c3852a, EventDetails eventDetails, AudioManager audioManager) {
        this.f20970u = 1;
        this.f20971v = true;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastVideoConfig);
        Preconditions.checkNotNull(c3852a);
        Preconditions.checkNotNull(audioManager);
        this.f20951b = context.getApplicationContext();
        this.f20952c = new Handler(Looper.getMainLooper());
        this.f20954e = vastVideoConfig;
        this.f20955f = nativeVideoProgressRunnable;
        this.f20953d = c3852a;
        this.f20966q = eventDetails;
        this.f20956g = audioManager;
    }

    public void setListener(Listener listener) {
        this.f20957h = listener;
    }

    public void setProgressListener(NativeVideoProgressRunnable.ProgressListener progressListener) {
        this.f20955f.f20974e = progressListener;
    }

    public void setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.f20958i = onAudioFocusChangeListener;
    }

    public void setPlayWhenReady(boolean z) {
        if (this.f20967r == z) {
            return;
        }
        this.f20967r = z;
        m2117c();
    }

    public int getPlaybackState() {
        if (this.f20962m == null) {
            return 6;
        }
        return this.f20962m.mo3574a();
    }

    public void setAudioEnabled(boolean z) {
        this.f20968s = z;
        m2116d();
    }

    public void setAppAudioEnabled(boolean z) {
        if (this.f20969t == z) {
            return;
        }
        this.f20969t = z;
        if (this.f20969t) {
            this.f20956g.requestAudioFocus(this, 3, 1);
        } else {
            this.f20956g.abandonAudioFocus(this);
        }
    }

    public void setAudioVolume(float f) {
        if (this.f20968s) {
            m2120a(f);
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f20958i;
        if (onAudioFocusChangeListener == null) {
            return;
        }
        onAudioFocusChangeListener.onAudioFocusChange(i);
    }

    public void setTextureView(TextureView textureView) {
        Preconditions.checkNotNull(textureView);
        this.f20959j = new Surface(textureView.getSurfaceTexture());
        this.f20960k = textureView;
        this.f20955f.f20973d = this.f20960k;
        m2119a(this.f20959j);
    }

    public void prepare(Object obj) {
        Preconditions.checkNotNull(obj);
        this.f20961l = new WeakReference<>(obj);
        m2118b();
        if (this.f20962m == null) {
            this.f20962m = this.f20953d.newInstance(2, 1000, UIMsg.m_AppUI.MSG_APP_GPS);
            this.f20955f.f20972c = this.f20962m;
            this.f20962m.mo3571a(this);
            DefaultAllocator defaultAllocator = new DefaultAllocator();
            Mp4Extractor mp4Extractor = new Mp4Extractor();
            ExtractorSampleSource extractorSampleSource = new ExtractorSampleSource(Uri.parse(this.f20954e.getNetworkMediaFileUrl()), new HttpDiskCompositeDataSource(this.f20951b, "exo_demo", this.f20966q), defaultAllocator, mp4Extractor);
            this.f20965p = new MediaCodecVideoTrackRenderer(this.f20951b, extractorSampleSource, MediaCodecSelector.f18542a, this.f20952c);
            this.f20964o = new MediaCodecAudioTrackRenderer(extractorSampleSource, MediaCodecSelector.f18542a);
            this.f20962m.mo3569a(this.f20964o, this.f20965p);
            this.f20955f.startRepeating(50L);
        }
        m2116d();
        m2117c();
        m2119a(this.f20959j);
    }

    public void clear() {
        setPlayWhenReady(false);
        this.f20959j = null;
        m2118b();
    }

    public void release(Object obj) {
        Preconditions.checkNotNull(obj);
        WeakReference<Object> weakReference = this.f20961l;
        if ((weakReference == null ? null : weakReference.get()) == obj) {
            m2118b();
        }
    }

    @Override // com.google.android.p328a.ExoPlayer.InterfaceC3156b
    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 5 && this.f20963n == null) {
            this.f20963n = new BitmapDrawable(this.f20951b.getResources(), this.f20960k.getBitmap());
            this.f20955f.f20977h = true;
        }
        if (this.f20970u == 4 && i == 3) {
            MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.DOWNLOAD_BUFFERING, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20966q));
        }
        if (this.f20971v && this.f20970u == 3 && i == 4) {
            MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.DOWNLOAD_VIDEO_READY, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20966q));
        }
        this.f20970u = i;
        if (i == 4) {
            this.f20971v = false;
        } else if (i == 1) {
            this.f20971v = true;
        }
        Listener listener = this.f20957h;
        if (listener != null) {
            listener.onStateChanged(z, i);
        }
    }

    public void seekTo(long j) {
        if (this.f20962m == null) {
            return;
        }
        this.f20962m.mo3573a(j);
        this.f20955f.f20975f = j;
    }

    public long getCurrentPosition() {
        return this.f20955f.f20975f;
    }

    public long getDuration() {
        return this.f20955f.f20976g;
    }

    @Override // com.google.android.p328a.ExoPlayer.InterfaceC3156b
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        if (this.f20957h == null) {
            return;
        }
        MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.ERROR_DURING_PLAYBACK, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20966q));
        this.f20957h.onError(exoPlaybackException);
        this.f20955f.f20977h = true;
    }

    public void handleCtaClick(Context context) {
        m2121a();
        this.f20954e.handleClickWithoutResult(context, 0);
    }

    public boolean hasFinalFrame() {
        return this.f20963n != null;
    }

    public Drawable getFinalFrame() {
        return this.f20963n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2121a() {
        this.f20955f.m2115a(true);
    }

    /* renamed from: b */
    private void m2118b() {
        if (this.f20962m == null) {
            return;
        }
        m2119a((Surface) null);
        this.f20962m.mo3567c();
        this.f20962m.mo3566d();
        this.f20962m = null;
        this.f20955f.stop();
        this.f20955f.f20972c = null;
    }

    /* renamed from: c */
    private void m2117c() {
        if (this.f20962m == null) {
            return;
        }
        this.f20962m.mo3570a(this.f20967r);
    }

    /* renamed from: d */
    private void m2116d() {
        m2120a(this.f20968s ? 1.0f : ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    /* renamed from: a */
    private void m2120a(float f) {
        Preconditions.checkArgument(f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && f <= 1.0f);
        if (this.f20962m == null) {
            return;
        }
        this.f20962m.mo3572a(this.f20964o, Float.valueOf(f));
    }

    /* renamed from: a */
    private void m2119a(Surface surface) {
        if (this.f20962m == null) {
            return;
        }
        this.f20962m.mo3572a(this.f20965p, surface);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeVideoController$a */
    /* loaded from: classes2.dex */
    static class C3852a {
        C3852a() {
        }

        public final ExoPlayer newInstance(int i, int i2, int i3) {
            return new ExoPlayerImpl(i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class NativeVideoProgressRunnable extends RepeatingHandlerRunnable {

        /* renamed from: c */
        ExoPlayer f20972c;

        /* renamed from: d */
        TextureView f20973d;

        /* renamed from: e */
        ProgressListener f20974e;

        /* renamed from: f */
        long f20975f;

        /* renamed from: g */
        long f20976g;

        /* renamed from: h */
        boolean f20977h;

        /* renamed from: i */
        private final Context f20978i;

        /* renamed from: j */
        private final VisibilityTracker.C3882b f20979j;

        /* renamed from: k */
        private final List<C3853b> f20980k;

        /* renamed from: l */
        private final VastVideoConfig f20981l;

        /* loaded from: classes2.dex */
        public interface ProgressListener {
            void updateProgress(int i);
        }

        NativeVideoProgressRunnable(Context context, Handler handler, List<C3853b> list, VastVideoConfig vastVideoConfig) {
            this(context, handler, list, new VisibilityTracker.C3882b(), vastVideoConfig);
        }

        @VisibleForTesting
        private NativeVideoProgressRunnable(Context context, Handler handler, List<C3853b> list, VisibilityTracker.C3882b c3882b, VastVideoConfig vastVideoConfig) {
            super(handler);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(vastVideoConfig);
            this.f20978i = context.getApplicationContext();
            this.f20980k = list;
            this.f20979j = c3882b;
            this.f20981l = vastVideoConfig;
            this.f20976g = -1L;
            this.f20977h = false;
        }

        /* renamed from: a */
        final void m2115a(boolean z) {
            int i = 0;
            for (C3853b c3853b : this.f20980k) {
                if (c3853b.f20986e) {
                    i++;
                } else {
                    if (!z) {
                        VisibilityTracker.C3882b c3882b = this.f20979j;
                        TextureView textureView = this.f20973d;
                        if (c3882b.m2056a(textureView, textureView, c3853b.f20983b)) {
                        }
                    }
                    c3853b.f20985d = (int) (c3853b.f20985d + this.f20387b);
                    if (z || c3853b.f20985d >= c3853b.f20984c) {
                        c3853b.f20982a.execute();
                        c3853b.f20986e = true;
                        i++;
                    }
                }
            }
            if (i == this.f20980k.size() && this.f20977h) {
                stop();
            }
        }

        @Override // com.mopub.mobileads.RepeatingHandlerRunnable
        public final void doWork() {
            ExoPlayer exoPlayer = this.f20972c;
            if (exoPlayer == null || !exoPlayer.mo3568b()) {
                return;
            }
            this.f20975f = this.f20972c.mo3564f();
            this.f20976g = this.f20972c.mo3565e();
            m2115a(false);
            ProgressListener progressListener = this.f20974e;
            if (progressListener != null) {
                progressListener.updateProgress((int) ((((float) this.f20975f) / ((float) this.f20976g)) * 1000.0f));
            }
            List<VastTracker> untriggeredTrackersBefore = this.f20981l.getUntriggeredTrackersBefore((int) this.f20975f, (int) this.f20976g);
            if (untriggeredTrackersBefore.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (VastTracker vastTracker : untriggeredTrackersBefore) {
                if (!vastTracker.isTracked()) {
                    arrayList.add(vastTracker.getTrackingUrl());
                    vastTracker.setTracked();
                }
            }
            TrackingRequest.makeTrackingHttpRequest(arrayList, this.f20978i);
        }
    }
}
