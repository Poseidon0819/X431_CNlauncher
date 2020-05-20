package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.app.p071a.C0727a;
import com.alipay.sdk.p070a.C0720a;
import com.alipay.sdk.p070a.C0723c;
import com.alipay.sdk.p070a.RunnableC0724d;
import com.alipay.sdk.p073c.C0748b;
import com.alipay.sdk.p074d.C0752a;
import com.unionpay.tsmservice.data.Constant;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
/* loaded from: classes.dex */
public class AuthActivity extends Activity {

    /* renamed from: a */
    private WebView f3521a;

    /* renamed from: b */
    private String f3522b;

    /* renamed from: c */
    private C0752a f3523c;

    /* renamed from: d */
    private Handler f3524d;

    /* renamed from: e */
    private boolean f3525e;

    /* renamed from: f */
    private boolean f3526f;

    /* renamed from: g */
    private Runnable f3527g = new RunnableC0741d(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m12543a(AuthActivity authActivity, C0720a c0720a) {
        if (authActivity.f3521a != null && c0720a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientId", c0720a.f3480a);
                jSONObject.put("func", c0720a.f3482c);
                jSONObject.put("param", c0720a.f3484e);
                jSONObject.put("msgType", c0720a.f3483d);
                authActivity.runOnUiThread(new RunnableC0740c(authActivity, String.format("AlipayJSBridge._invokeJS(%s)", jSONObject.toString())));
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m12544a(AuthActivity authActivity) {
        authActivity.f3526f = true;
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m12542a(AuthActivity authActivity, String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, authActivity.f3522b)) {
                str = str + "?resultCode=150";
            }
            C0745h.m12531a(authActivity, str);
        }
        authActivity.finish();
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ void m12539b(AuthActivity authActivity, String str) {
        C0723c c0723c = new C0723c(authActivity.getApplicationContext(), new C0739b(authActivity));
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("clientId");
            try {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                JSONObject jSONObject3 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                String string2 = jSONObject.getString("func");
                String string3 = jSONObject.getString("bundleName");
                C0720a c0720a = new C0720a("call");
                c0720a.f3481b = string3;
                c0720a.f3482c = string2;
                c0720a.f3484e = jSONObject3;
                c0720a.f3480a = string;
                if (TextUtils.isEmpty(c0720a.f3482c)) {
                    c0723c.m12557a(c0720a.f3480a, C0720a.EnumC0721a.c$15e826fb);
                    return;
                }
                RunnableC0724d runnableC0724d = new RunnableC0724d(c0723c, c0720a);
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    runnableC0724d.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(runnableC0724d);
                }
            } catch (Exception unused) {
                str2 = string;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    c0723c.m12557a(str2, C0720a.EnumC0721a.d$15e826fb);
                } catch (JSONException unused2) {
                }
            }
        } catch (Exception unused3) {
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m12537d(AuthActivity authActivity) {
        try {
            if (authActivity.f3523c == null) {
                authActivity.f3523c = new C0752a(authActivity, "正在加载");
            }
            authActivity.f3523c.m12516a();
        } catch (Exception unused) {
            authActivity.f3523c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m12534g(AuthActivity authActivity) {
        C0752a c0752a = authActivity.f3523c;
        if (c0752a != null) {
            c0752a.m12513b();
        }
        authActivity.f3523c = null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            try {
                this.f3522b = extras.getString("redirectUri");
                String string = extras.getString(Constant.KEY_PARAMS);
                if (!C0748b.m12522a(string)) {
                    finish();
                    return;
                }
                super.requestWindowFeature(1);
                this.f3524d = new Handler(getMainLooper());
                LinearLayout linearLayout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                linearLayout.setOrientation(1);
                setContentView(linearLayout, layoutParams);
                this.f3521a = new WebView(this);
                layoutParams.weight = 1.0f;
                this.f3521a.setVisibility(0);
                linearLayout.addView(this.f3521a, layoutParams);
                WebSettings settings = this.f3521a.getSettings();
                settings.setUserAgentString(settings.getUserAgentString() + C0748b.m12525a(getApplicationContext()));
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                settings.setSupportMultipleWindows(true);
                settings.setJavaScriptEnabled(true);
                settings.setSavePassword(false);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                settings.setAllowFileAccess(false);
                settings.setTextSize(WebSettings.TextSize.NORMAL);
                this.f3521a.setVerticalScrollbarOverlay(true);
                this.f3521a.setWebViewClient(new C0737b(this, (byte) 0));
                this.f3521a.setWebChromeClient(new C0736a(this, (byte) 0));
                this.f3521a.setDownloadListener(new C0738a(this));
                this.f3521a.loadUrl(string);
                if (Build.VERSION.SDK_INT >= 7) {
                    try {
                        Method method = this.f3521a.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                        if (method != null) {
                            method.invoke(this.f3521a.getSettings(), Boolean.TRUE);
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    try {
                        this.f3521a.removeJavascriptInterface("searchBoxJavaBridge_");
                        this.f3521a.removeJavascriptInterface("accessibility");
                        this.f3521a.removeJavascriptInterface("accessibilityTraversal");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    Method method2 = this.f3521a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                    if (method2 != null) {
                        method2.invoke(this.f3521a, "searchBoxJavaBridge_");
                        method2.invoke(this.f3521a, "accessibility");
                        method2.invoke(this.f3521a, "accessibilityTraversal");
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f3521a.getSettings().setCacheMode(1);
                }
            } catch (Exception unused4) {
                finish();
            }
        } catch (Exception unused5) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f3521a.canGoBack()) {
            if (this.f3526f) {
                C0745h.m12531a(this, this.f3522b + "?resultCode=150");
                finish();
                return;
            }
            return;
        }
        C0745h.m12531a(this, this.f3522b + "?resultCode=150");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.sdk.auth.AuthActivity$b */
    /* loaded from: classes.dex */
    public class C0737b extends WebViewClient {
        private C0737b() {
        }

        /* synthetic */ C0737b(AuthActivity authActivity, byte b) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            AuthActivity.m12544a(AuthActivity.this);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (AuthActivity.this.f3525e) {
                sslErrorHandler.proceed();
                AuthActivity.this.f3525e = false;
                return;
            }
            AuthActivity.this.runOnUiThread(new RunnableC0742e(this, sslErrorHandler));
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C0748b.C0749a m12524a;
            if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
                try {
                    m12524a = C0748b.m12524a(AuthActivity.this, "com.eg.android.AlipayGphone");
                } catch (Throwable unused) {
                }
                if (m12524a != null) {
                    String m12521a = C0748b.m12521a(m12524a.f3543a);
                    if (m12521a != null && !TextUtils.equals(m12521a, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
                        C0727a.m12556a("biz", "ClientSignError", m12521a);
                        return true;
                    }
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
                    }
                    AuthActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                return true;
            } else if (AuthActivity.m12542a(AuthActivity.this, str)) {
                webView.stopLoading();
                return true;
            } else {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthActivity.m12537d(AuthActivity.this);
            AuthActivity.this.f3524d.postDelayed(AuthActivity.this.f3527g, 30000L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            AuthActivity.m12534g(AuthActivity.this);
            AuthActivity.this.f3524d.removeCallbacks(AuthActivity.this.f3527g);
        }
    }

    /* renamed from: com.alipay.sdk.auth.AuthActivity$a */
    /* loaded from: classes.dex */
    class C0736a extends WebChromeClient {
        private C0736a() {
        }

        /* synthetic */ C0736a(AuthActivity authActivity, byte b) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message2 = consoleMessage.message();
            if (TextUtils.isEmpty(message2)) {
                return super.onConsoleMessage(consoleMessage);
            }
            String replaceFirst = message2.startsWith("h5container.message: ") ? message2.replaceFirst("h5container.message: ", "") : null;
            if (TextUtils.isEmpty(replaceFirst)) {
                return super.onConsoleMessage(consoleMessage);
            }
            AuthActivity.m12539b(AuthActivity.this, replaceFirst);
            return super.onConsoleMessage(consoleMessage);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.f3521a;
        if (webView != null) {
            webView.removeAllViews();
            try {
                this.f3521a.destroy();
            } catch (Throwable unused) {
            }
            this.f3521a = null;
        }
    }
}
