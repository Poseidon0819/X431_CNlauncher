package com.mopub.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.common.AdReport;
import com.mopub.common.AdType;
import com.mopub.common.CloseableLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.mobileads.resource.MraidJavascript;
import com.mopub.network.Networking;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.jivesoftware.smack.packet.PrivacyItem;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MraidBridge {

    /* renamed from: a */
    MraidBridgeListener f20645a;

    /* renamed from: b */
    MraidWebView f20646b;

    /* renamed from: c */
    boolean f20647c;

    /* renamed from: d */
    private final AdReport f20648d;

    /* renamed from: e */
    private final String f20649e;

    /* renamed from: f */
    private final PlacementType f20650f;

    /* renamed from: g */
    private final MraidNativeCommandHandler f20651g;

    /* renamed from: h */
    private boolean f20652h;

    /* renamed from: i */
    private final WebViewClient f20653i;

    /* loaded from: classes.dex */
    public interface MraidBridgeListener {
        void onClose();

        boolean onConsoleMessage(ConsoleMessage consoleMessage);

        void onExpand(URI uri, boolean z) throws MraidCommandException;

        boolean onJsAlert(String str, JsResult jsResult);

        void onOpen(URI uri);

        void onPageFailedToLoad();

        void onPageLoaded();

        void onPlayVideo(URI uri);

        void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException;

        void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException;

        void onUseCustomClose(boolean z);

        void onVisibilityChanged(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MraidBridge(AdReport adReport, PlacementType placementType) {
        this(adReport, placementType, new MraidNativeCommandHandler());
    }

    @VisibleForTesting
    private MraidBridge(AdReport adReport, PlacementType placementType, MraidNativeCommandHandler mraidNativeCommandHandler) {
        this.f20649e = MraidJavascript.JAVASCRIPT_SOURCE.replaceAll("(?m)^\\s+", "").replaceAll("(?m)^//.*(?=\\n)", "");
        this.f20653i = new C3819e(this);
        this.f20648d = adReport;
        this.f20650f = placementType;
        this.f20651g = mraidNativeCommandHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2273a(MraidWebView mraidWebView) {
        this.f20646b = mraidWebView;
        this.f20646b.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17 && this.f20650f == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        MraidWebView mraidWebView2 = this.f20646b;
        mraidWebView2.loadUrl("javascript:" + this.f20649e);
        this.f20646b.setScrollContainer(false);
        this.f20646b.setVerticalScrollBarEnabled(false);
        this.f20646b.setHorizontalScrollBarEnabled(false);
        this.f20646b.setBackgroundColor(-16777216);
        this.f20646b.setWebViewClient(this.f20653i);
        this.f20646b.setWebChromeClient(new C3812a(this));
        ViewGestureDetector viewGestureDetector = new ViewGestureDetector(this.f20646b.getContext(), this.f20646b, this.f20648d);
        viewGestureDetector.setUserClickListener(new C3816b(this));
        this.f20646b.setOnTouchListener(new View$OnTouchListenerC3817c(this, viewGestureDetector));
        this.f20646b.setVisibilityChangedListener(new C3818d(this));
    }

    public void setContentHtml(String str) {
        MraidWebView mraidWebView = this.f20646b;
        if (mraidWebView == null) {
            MoPubLog.m2498d("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.f20647c = false;
        mraidWebView.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://ads.mopub.com/", str, "text/html", "UTF-8", null);
    }

    public void setContentUrl(String str) {
        MraidWebView mraidWebView = this.f20646b;
        if (mraidWebView == null) {
            MoPubLog.m2498d("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.f20647c = false;
        mraidWebView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2266a(String str) {
        if (this.f20646b == null) {
            MoPubLog.m2498d("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t".concat(String.valueOf(str)));
            return;
        }
        MoPubLog.m2492v("Injecting Javascript into MRAID WebView:\n\t".concat(String.valueOf(str)));
        this.f20646b.loadUrl("javascript:".concat(String.valueOf(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2269a(MraidJavascriptCommand mraidJavascriptCommand, String str) {
        m2266a("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(mraidJavascriptCommand.toJavascriptString()) + ", " + JSONObject.quote(str) + ")");
    }

    /* loaded from: classes.dex */
    public static class MraidWebView extends BaseWebView {

        /* renamed from: b */
        private OnVisibilityChangedListener f20655b;

        /* renamed from: c */
        private boolean f20656c;

        /* loaded from: classes.dex */
        public interface OnVisibilityChangedListener {
            void onVisibilityChanged(boolean z);
        }

        public MraidWebView(Context context) {
            super(context);
            this.f20656c = getVisibility() == 0;
        }

        void setVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.f20655b = onVisibilityChangedListener;
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            boolean z = i == 0;
            if (z != this.f20656c) {
                this.f20656c = z;
                OnVisibilityChangedListener onVisibilityChangedListener = this.f20655b;
                if (onVisibilityChangedListener != null) {
                    onVisibilityChangedListener.onVisibilityChanged(this.f20656c);
                }
            }
        }

        public boolean isVisible() {
            return this.f20656c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final boolean m2259b(String str) {
        CloseableLayout.ClosePosition closePosition;
        MraidOrientation mraidOrientation;
        MraidBridgeListener mraidBridgeListener;
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if ("mopub".equals(scheme)) {
                if ("failLoad".equals(host) && this.f20650f == PlacementType.INLINE && (mraidBridgeListener = this.f20645a) != null) {
                    mraidBridgeListener.onPageFailedToLoad();
                }
                return true;
            } else if (AdType.MRAID.equals(scheme)) {
                HashMap hashMap = new HashMap();
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(uri, "UTF-8")) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
                MraidJavascriptCommand fromJavascriptString = MraidJavascriptCommand.fromJavascriptString(host);
                try {
                    if (fromJavascriptString.requiresClick(this.f20650f) && !this.f20652h) {
                        throw new MraidCommandException("Cannot execute this command unless the user clicks");
                    }
                } catch (MraidCommandException e) {
                    m2269a(fromJavascriptString, e.getMessage());
                }
                if (this.f20645a == null) {
                    throw new MraidCommandException("Invalid state to execute this command");
                }
                if (this.f20646b == null) {
                    throw new MraidCommandException("The current WebView is being destroyed");
                }
                URI uri2 = null;
                switch (C38041.f20654a[fromJavascriptString.ordinal()]) {
                    case 1:
                        this.f20645a.onClose();
                        break;
                    case 2:
                        int m2275a = m2275a(m2257c((String) hashMap.get("width")), 0);
                        int m2275a2 = m2275a(m2257c((String) hashMap.get("height")), 0);
                        int m2275a3 = m2275a(m2257c((String) hashMap.get("offsetX")), -100000);
                        int m2275a4 = m2275a(m2257c((String) hashMap.get("offsetY")), -100000);
                        String str2 = (String) hashMap.get("customClosePosition");
                        CloseableLayout.ClosePosition closePosition2 = CloseableLayout.ClosePosition.TOP_RIGHT;
                        if (TextUtils.isEmpty(str2)) {
                            closePosition = closePosition2;
                        } else if (str2.equals("top-left")) {
                            closePosition = CloseableLayout.ClosePosition.TOP_LEFT;
                        } else if (str2.equals("top-right")) {
                            closePosition = CloseableLayout.ClosePosition.TOP_RIGHT;
                        } else if (str2.equals(HtmlTags.ALIGN_CENTER)) {
                            closePosition = CloseableLayout.ClosePosition.CENTER;
                        } else if (str2.equals("bottom-left")) {
                            closePosition = CloseableLayout.ClosePosition.BOTTOM_LEFT;
                        } else if (str2.equals("bottom-right")) {
                            closePosition = CloseableLayout.ClosePosition.BOTTOM_RIGHT;
                        } else if (str2.equals("top-center")) {
                            closePosition = CloseableLayout.ClosePosition.TOP_CENTER;
                        } else if (str2.equals("bottom-center")) {
                            closePosition = CloseableLayout.ClosePosition.BOTTOM_CENTER;
                        } else {
                            throw new MraidCommandException("Invalid close position: ".concat(String.valueOf(str2)));
                        }
                        this.f20645a.onResize(m2275a, m2275a2, m2275a3, m2275a4, closePosition, m2265a((String) hashMap.get("allowOffscreen"), true));
                        break;
                    case 3:
                        String str3 = (String) hashMap.get(Annotation.URL);
                        if (str3 != null) {
                            uri2 = m2255e(str3);
                        }
                        this.f20645a.onExpand(uri2, m2265a((String) hashMap.get("shouldUseCustomClose"), false));
                        break;
                    case 4:
                        this.f20645a.onUseCustomClose(m2265a((String) hashMap.get("shouldUseCustomClose"), false));
                        break;
                    case 5:
                        this.f20645a.onOpen(m2255e((String) hashMap.get(Annotation.URL)));
                        break;
                    case 6:
                        boolean m2256d = m2256d((String) hashMap.get("allowOrientationChange"));
                        String str4 = (String) hashMap.get("forceOrientation");
                        if ("portrait".equals(str4)) {
                            mraidOrientation = MraidOrientation.PORTRAIT;
                        } else if ("landscape".equals(str4)) {
                            mraidOrientation = MraidOrientation.LANDSCAPE;
                        } else if (PrivacyItem.PrivacyRule.SUBSCRIPTION_NONE.equals(str4)) {
                            mraidOrientation = MraidOrientation.NONE;
                        } else {
                            throw new MraidCommandException("Invalid orientation: ".concat(String.valueOf(str4)));
                        }
                        this.f20645a.onSetOrientationProperties(m2256d, mraidOrientation);
                        break;
                    case 7:
                        this.f20645a.onPlayVideo(m2255e((String) hashMap.get("uri")));
                        break;
                    case 8:
                        URI m2255e = m2255e((String) hashMap.get("uri"));
                        MraidNativeCommandHandler mraidNativeCommandHandler = this.f20651g;
                        Context context = this.f20646b.getContext();
                        String uri3 = m2255e.toString();
                        C3820f c3820f = new C3820f(this, fromJavascriptString);
                        if (!MraidNativeCommandHandler.isStorePictureSupported(context)) {
                            MoPubLog.m2498d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
                            throw new MraidCommandException("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
                        } else if (!(context instanceof Activity)) {
                            Toast.makeText(context, "Downloading image to Picture gallery...", 0).show();
                            mraidNativeCommandHandler.m2220a(context, uri3, c3820f);
                            break;
                        } else {
                            new AlertDialog.Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterface$OnClickListenerC3837x(mraidNativeCommandHandler, context, uri3, c3820f)).setCancelable(true).show();
                            break;
                        }
                    case 9:
                        MraidNativeCommandHandler.m2219a(this.f20646b.getContext(), hashMap);
                        break;
                    case 10:
                        throw new MraidCommandException("Unspecified MRAID Javascript command");
                }
                m2266a("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(fromJavascriptString.toJavascriptString()) + ")");
                return true;
            } else if (this.f20652h) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                try {
                    if (this.f20646b == null) {
                        MoPubLog.m2498d("WebView was detached. Unable to load a URL");
                        return true;
                    }
                    this.f20646b.getContext().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    MoPubLog.m2498d("No activity found to handle this URL ".concat(String.valueOf(str)));
                    return false;
                }
            } else {
                return false;
            }
        } catch (URISyntaxException unused2) {
            MoPubLog.m2490w("Invalid MRAID URL: ".concat(String.valueOf(str)));
            m2269a(MraidJavascriptCommand.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    /* renamed from: com.mopub.mraid.MraidBridge$1 */
    /* loaded from: classes.dex */
    final /* synthetic */ class C38041 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20654a = new int[MraidJavascriptCommand.values().length];

        static {
            try {
                f20654a[MraidJavascriptCommand.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20654a[MraidJavascriptCommand.RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20654a[MraidJavascriptCommand.EXPAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20654a[MraidJavascriptCommand.USE_CUSTOM_CLOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20654a[MraidJavascriptCommand.OPEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20654a[MraidJavascriptCommand.SET_ORIENTATION_PROPERTIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20654a[MraidJavascriptCommand.PLAY_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20654a[MraidJavascriptCommand.STORE_PICTURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20654a[MraidJavascriptCommand.CREATE_CALENDAR_EVENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f20654a[MraidJavascriptCommand.UNSPECIFIED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: c */
    private static int m2257c(String str) throws MraidCommandException {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new MraidCommandException("Invalid numeric parameter: ".concat(String.valueOf(str)));
        }
    }

    /* renamed from: a */
    private static int m2275a(int i, int i2) throws MraidCommandException {
        if (i < i2 || i > 100000) {
            throw new MraidCommandException("Integer parameter out of range: ".concat(String.valueOf(i)));
        }
        return i;
    }

    /* renamed from: a */
    private static boolean m2265a(String str, boolean z) throws MraidCommandException {
        return str == null ? z : m2256d(str);
    }

    /* renamed from: d */
    private static boolean m2256d(String str) throws MraidCommandException {
        if (PdfBoolean.TRUE.equals(str)) {
            return true;
        }
        if (PdfBoolean.FALSE.equals(str)) {
            return false;
        }
        throw new MraidCommandException("Invalid boolean parameter: ".concat(String.valueOf(str)));
    }

    /* renamed from: e */
    private static URI m2255e(String str) throws MraidCommandException {
        if (str == null) {
            throw new MraidCommandException("Parameter cannot be null");
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            throw new MraidCommandException("Invalid URL parameter: ".concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2264a(boolean z) {
        m2266a("mraidbridge.setIsViewable(" + z + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2268a(PlacementType placementType) {
        m2266a("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2267a(ViewState viewState) {
        m2266a("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2263a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        m2266a("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + ")");
    }

    /* renamed from: a */
    private static String m2274a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    /* renamed from: b */
    private static String m2261b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    public void notifyScreenMetrics(MraidScreenMetrics mraidScreenMetrics) {
        m2266a("mraidbridge.setScreenSize(" + m2261b(mraidScreenMetrics.f20738b) + ");mraidbridge.setMaxSize(" + m2261b(mraidScreenMetrics.f20740d) + ");mraidbridge.setCurrentPosition(" + m2274a(mraidScreenMetrics.f20742f) + ");mraidbridge.setDefaultPosition(" + m2274a(mraidScreenMetrics.f20744h) + ")");
        StringBuilder sb = new StringBuilder("mraidbridge.notifySizeChangeEvent(");
        sb.append(m2261b(mraidScreenMetrics.f20741e));
        sb.append(")");
        m2266a(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2276a() {
        MraidWebView mraidWebView = this.f20646b;
        return mraidWebView != null && mraidWebView.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean m2262b() {
        return this.f20646b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m2258c(MraidBridge mraidBridge) {
        if (mraidBridge.f20647c) {
            return;
        }
        mraidBridge.f20647c = true;
        MraidBridgeListener mraidBridgeListener = mraidBridge.f20645a;
        if (mraidBridgeListener != null) {
            mraidBridgeListener.onPageLoaded();
        }
    }
}
