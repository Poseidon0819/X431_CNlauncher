package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class MraidController {

    /* renamed from: a */
    final Context f20657a;

    /* renamed from: b */
    final PlacementType f20658b;

    /* renamed from: c */
    final FrameLayout f20659c;

    /* renamed from: d */
    final CloseableLayout f20660d;

    /* renamed from: e */
    final MraidScreenMetrics f20661e;

    /* renamed from: f */
    ViewState f20662f;

    /* renamed from: g */
    MraidListener f20663g;

    /* renamed from: h */
    MraidBridge.MraidWebView f20664h;

    /* renamed from: i */
    MraidBridge.MraidWebView f20665i;

    /* renamed from: j */
    final MraidBridge f20666j;

    /* renamed from: k */
    private final AdReport f20667k;

    /* renamed from: l */
    private final WeakReference<Activity> f20668l;

    /* renamed from: m */
    private ViewGroup f20669m;

    /* renamed from: n */
    private final C3806b f20670n;

    /* renamed from: o */
    private UseCustomCloseListener f20671o;

    /* renamed from: p */
    private MraidWebViewDebugListener f20672p;

    /* renamed from: q */
    private final MraidBridge f20673q;

    /* renamed from: r */
    private C3805a f20674r;

    /* renamed from: s */
    private Integer f20675s;

    /* renamed from: t */
    private boolean f20676t;

    /* renamed from: u */
    private MraidOrientation f20677u;

    /* renamed from: v */
    private final MraidNativeCommandHandler f20678v;

    /* renamed from: w */
    private boolean f20679w;

    /* renamed from: x */
    private final MraidBridge.MraidBridgeListener f20680x;

    /* renamed from: y */
    private final MraidBridge.MraidBridgeListener f20681y;

    /* loaded from: classes.dex */
    public interface MraidListener {
        void onClose();

        void onExpand();

        void onFailedToLoad();

        void onLoaded(View view);

        void onOpen();
    }

    /* loaded from: classes.dex */
    public interface UseCustomCloseListener {
        void useCustomCloseChanged(boolean z);
    }

    public MraidController(Context context, AdReport adReport, PlacementType placementType) {
        this(context, adReport, placementType, new MraidBridge(adReport, placementType), new MraidBridge(adReport, PlacementType.INTERSTITIAL), new C3806b());
    }

    @VisibleForTesting
    private MraidController(Context context, AdReport adReport, PlacementType placementType, MraidBridge mraidBridge, MraidBridge mraidBridge2, C3806b c3806b) {
        this.f20662f = ViewState.LOADING;
        this.f20674r = new C3805a();
        this.f20676t = true;
        this.f20677u = MraidOrientation.NONE;
        this.f20680x = new C3823j(this);
        this.f20681y = new C3824k(this);
        this.f20657a = context.getApplicationContext();
        Preconditions.checkNotNull(this.f20657a);
        this.f20667k = adReport;
        if (context instanceof Activity) {
            this.f20668l = new WeakReference<>((Activity) context);
        } else {
            this.f20668l = new WeakReference<>(null);
        }
        this.f20658b = placementType;
        this.f20673q = mraidBridge;
        this.f20666j = mraidBridge2;
        this.f20670n = c3806b;
        this.f20662f = ViewState.LOADING;
        this.f20661e = new MraidScreenMetrics(this.f20657a, this.f20657a.getResources().getDisplayMetrics().density);
        this.f20659c = new FrameLayout(this.f20657a);
        this.f20660d = new CloseableLayout(this.f20657a);
        this.f20660d.setOnCloseListener(new C3821h(this));
        View view = new View(this.f20657a);
        view.setOnTouchListener(new View$OnTouchListenerC3822i(this));
        this.f20660d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.f20674r.register(this.f20657a);
        this.f20673q.f20645a = this.f20680x;
        this.f20666j.f20645a = this.f20681y;
        this.f20678v = new MraidNativeCommandHandler();
    }

    public void setMraidListener(MraidListener mraidListener) {
        this.f20663g = mraidListener;
    }

    public void setUseCustomCloseListener(UseCustomCloseListener useCustomCloseListener) {
        this.f20671o = useCustomCloseListener;
    }

    public void setDebugListener(MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f20672p = mraidWebViewDebugListener;
    }

    public void loadContent(String str) {
        Preconditions.checkState(this.f20664h == null, "loadContent should only be called once");
        this.f20664h = new MraidBridge.MraidWebView(this.f20657a);
        this.f20673q.m2273a(this.f20664h);
        this.f20659c.addView(this.f20664h, new FrameLayout.LayoutParams(-1, -1));
        this.f20673q.setContentHtml(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final boolean m2251a(ConsoleMessage consoleMessage) {
        MraidWebViewDebugListener mraidWebViewDebugListener = this.f20672p;
        if (mraidWebViewDebugListener != null) {
            return mraidWebViewDebugListener.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final boolean m2245a(String str, JsResult jsResult) {
        MraidWebViewDebugListener mraidWebViewDebugListener = this.f20672p;
        if (mraidWebViewDebugListener != null) {
            return mraidWebViewDebugListener.onJsAlert(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$b */
    /* loaded from: classes.dex */
    public static class C3806b {

        /* renamed from: a */
        final Handler f20685a = new Handler();

        /* renamed from: b */
        C3807a f20686b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.mraid.MraidController$b$a */
        /* loaded from: classes.dex */
        public static class C3807a {

            /* renamed from: a */
            final View[] f20687a;

            /* renamed from: b */
            final Handler f20688b;

            /* renamed from: c */
            Runnable f20689c;

            /* renamed from: d */
            int f20690d;

            /* renamed from: e */
            final Runnable f20691e;

            /* synthetic */ C3807a(Handler handler, View[] viewArr, byte b) {
                this(handler, viewArr);
            }

            private C3807a(Handler handler, View[] viewArr) {
                this.f20691e = new RunnableC3828o(this);
                this.f20688b = handler;
                this.f20687a = viewArr;
            }

            /* renamed from: a */
            final void m2224a() {
                this.f20688b.removeCallbacks(this.f20691e);
                this.f20689c = null;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: a */
            public static /* synthetic */ void m2223a(C3807a c3807a) {
                Runnable runnable;
                c3807a.f20690d--;
                if (c3807a.f20690d != 0 || (runnable = c3807a.f20689c) == null) {
                    return;
                }
                runnable.run();
                c3807a.f20689c = null;
            }
        }

        C3806b() {
        }

        /* renamed from: a */
        final void m2225a() {
            C3807a c3807a = this.f20686b;
            if (c3807a != null) {
                c3807a.m2224a();
                this.f20686b = null;
            }
        }
    }

    /* renamed from: d */
    private View m2237d() {
        return this.f20666j.m2262b() ? this.f20665i : this.f20664h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2247a(Runnable runnable) {
        this.f20670n.m2225a();
        View m2237d = m2237d();
        if (m2237d == null) {
            return;
        }
        C3806b c3806b = this.f20670n;
        c3806b.f20686b = new C3806b.C3807a(c3806b.f20685a, new View[]{this.f20659c, m2237d}, (byte) 0);
        C3806b.C3807a c3807a = c3806b.f20686b;
        c3807a.f20689c = new RunnableC3827n(this, m2237d, runnable);
        c3807a.f20690d = c3807a.f20687a.length;
        c3807a.f20688b.post(c3807a.f20691e);
    }

    public void pause(boolean z) {
        this.f20679w = true;
        MraidBridge.MraidWebView mraidWebView = this.f20664h;
        if (mraidWebView != null) {
            WebViews.onPause(mraidWebView, z);
        }
        MraidBridge.MraidWebView mraidWebView2 = this.f20665i;
        if (mraidWebView2 != null) {
            WebViews.onPause(mraidWebView2, z);
        }
    }

    public void resume() {
        this.f20679w = false;
        MraidBridge.MraidWebView mraidWebView = this.f20664h;
        if (mraidWebView != null) {
            WebViews.onResume(mraidWebView);
        }
        MraidBridge.MraidWebView mraidWebView2 = this.f20665i;
        if (mraidWebView2 != null) {
            WebViews.onResume(mraidWebView2);
        }
    }

    public void destroy() {
        this.f20670n.m2225a();
        try {
            this.f20674r.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.f20679w) {
            pause(true);
        }
        Views.removeFromParent(this.f20660d);
        this.f20673q.f20646b = null;
        MraidBridge.MraidWebView mraidWebView = this.f20664h;
        if (mraidWebView != null) {
            mraidWebView.destroy();
            this.f20664h = null;
        }
        this.f20666j.f20646b = null;
        MraidBridge.MraidWebView mraidWebView2 = this.f20665i;
        if (mraidWebView2 != null) {
            mraidWebView2.destroy();
            this.f20665i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2249a(ViewState viewState, Runnable runnable) {
        MoPubLog.m2498d("MRAID state set to ".concat(String.valueOf(viewState)));
        ViewState viewState2 = this.f20662f;
        this.f20662f = viewState;
        this.f20673q.m2267a(viewState);
        if (this.f20666j.f20647c) {
            this.f20666j.m2267a(viewState);
        }
        if (this.f20663g != null) {
            if (viewState == ViewState.EXPANDED) {
                this.f20663g.onExpand();
            } else if (viewState2 == ViewState.EXPANDED && viewState == ViewState.DEFAULT) {
                this.f20663g.onClose();
            } else if (viewState == ViewState.HIDDEN) {
                this.f20663g.onClose();
            }
        }
        m2247a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m2252a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2254a() {
        MraidBridge.MraidWebView mraidWebView;
        if (this.f20664h == null || this.f20662f == ViewState.LOADING || this.f20662f == ViewState.HIDDEN) {
            return;
        }
        if (this.f20662f == ViewState.EXPANDED || this.f20658b == PlacementType.INTERSTITIAL) {
            m2233f();
        }
        if (this.f20662f == ViewState.RESIZED || this.f20662f == ViewState.EXPANDED) {
            if (this.f20666j.m2262b() && (mraidWebView = this.f20665i) != null) {
                this.f20660d.removeView(mraidWebView);
                this.f20666j.f20646b = null;
            } else {
                this.f20660d.removeView(this.f20664h);
                this.f20659c.addView(this.f20664h, new FrameLayout.LayoutParams(-1, -1));
                this.f20659c.setVisibility(0);
            }
            Views.removeFromParent(this.f20660d);
            m2249a(ViewState.DEFAULT, (Runnable) null);
        } else if (this.f20662f == ViewState.DEFAULT) {
            this.f20659c.setVisibility(4);
            m2249a(ViewState.HIDDEN, (Runnable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public ViewGroup m2235e() {
        ViewGroup viewGroup = this.f20669m;
        if (viewGroup != null) {
            return viewGroup;
        }
        View topmostView = Views.getTopmostView(this.f20668l.get(), this.f20659c);
        return topmostView instanceof ViewGroup ? (ViewGroup) topmostView : this.f20659c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final ViewGroup m2242b() {
        if (this.f20669m == null) {
            this.f20669m = m2235e();
        }
        return this.f20669m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2246a(String str) {
        MraidVideoPlayerActivity.startMraid(this.f20657a, str);
    }

    @VisibleForTesting
    /* renamed from: a */
    private void m2253a(int i) throws MraidCommandException {
        Activity activity = this.f20668l.get();
        if (activity == null || !m2248a(this.f20677u)) {
            throw new MraidCommandException("Attempted to lock orientation to unsupported value: " + this.f20677u.name());
        }
        if (this.f20675s == null) {
            this.f20675s = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public final void m2239c() throws MraidCommandException {
        if (this.f20677u == MraidOrientation.NONE) {
            if (this.f20676t) {
                m2233f();
                return;
            }
            Activity activity = this.f20668l.get();
            if (activity == null) {
                throw new MraidCommandException("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            m2253a(DeviceUtils.getScreenOrientation(activity));
            return;
        }
        m2253a(this.f20677u.getActivityInfoOrientation());
    }

    @VisibleForTesting
    /* renamed from: f */
    private void m2233f() {
        Integer num;
        Activity activity = this.f20668l.get();
        if (activity != null && (num = this.f20675s) != null) {
            activity.setRequestedOrientation(num.intValue());
        }
        this.f20675s = null;
    }

    @TargetApi(13)
    @VisibleForTesting
    /* renamed from: a */
    private boolean m2248a(MraidOrientation mraidOrientation) {
        if (mraidOrientation == MraidOrientation.NONE) {
            return true;
        }
        Activity activity = this.f20668l.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int i = activityInfo.screenOrientation;
            if (i != -1) {
                return i == mraidOrientation.getActivityInfoOrientation();
            }
            boolean bitMaskContainsFlag = Utils.bitMaskContainsFlag(activityInfo.configChanges, 128);
            return Build.VERSION.SDK_INT >= 13 ? bitMaskContainsFlag && Utils.bitMaskContainsFlag(activityInfo.configChanges, 1024) : bitMaskContainsFlag;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2244a(boolean z) {
        if (z == (!this.f20660d.isCloseVisible())) {
            return;
        }
        this.f20660d.setCloseVisible(!z);
        UseCustomCloseListener useCustomCloseListener = this.f20671o;
        if (useCustomCloseListener != null) {
            useCustomCloseListener.useCustomCloseChanged(z);
        }
    }

    public FrameLayout getAdContainer() {
        return this.f20659c;
    }

    public void loadJavascript(String str) {
        this.f20673q.m2266a(str);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$a */
    /* loaded from: classes.dex */
    class C3805a extends BroadcastReceiver {

        /* renamed from: b */
        private Context f20683b;

        /* renamed from: c */
        private int f20684c = -1;

        C3805a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int m2226l;
            if (this.f20683b == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (m2226l = MraidController.m2226l(MraidController.this)) == this.f20684c) {
                return;
            }
            this.f20684c = m2226l;
            MraidController.this.m2247a((Runnable) null);
        }

        public final void register(Context context) {
            Preconditions.checkNotNull(context);
            this.f20683b = context.getApplicationContext();
            Context context2 = this.f20683b;
            if (context2 != null) {
                context2.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public final void unregister() {
            Context context = this.f20683b;
            if (context != null) {
                context.unregisterReceiver(this);
                this.f20683b = null;
            }
        }
    }

    public Context getContext() {
        return this.f20657a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2243a(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
        if (!m2248a(mraidOrientation)) {
            throw new MraidCommandException("Unable to force orientation to ".concat(String.valueOf(mraidOrientation)));
        }
        this.f20676t = z;
        this.f20677u = mraidOrientation;
        if (this.f20662f == ViewState.EXPANDED || this.f20658b == PlacementType.INTERSTITIAL) {
            m2239c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final void m2240b(String str) {
        MraidListener mraidListener = this.f20663g;
        if (mraidListener != null) {
            mraidListener.onOpen();
        }
        UrlHandler.Builder builder = new UrlHandler.Builder();
        AdReport adReport = this.f20667k;
        if (adReport != null) {
            builder.withDspCreativeId(adReport.getDspCreativeId());
        }
        builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.f20657a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ boolean m2232f(MraidController mraidController) {
        Activity activity = mraidController.f20668l.get();
        if (activity == null || mraidController.m2237d() == null) {
            return false;
        }
        return MraidNativeCommandHandler.m2222a(activity, mraidController.m2237d());
    }

    /* renamed from: l */
    static /* synthetic */ int m2226l(MraidController mraidController) {
        return ((WindowManager) mraidController.f20657a.getSystemService("window")).getDefaultDisplay().getRotation();
    }
}
