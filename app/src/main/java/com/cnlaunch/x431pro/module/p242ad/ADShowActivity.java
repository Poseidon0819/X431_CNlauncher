package com.cnlaunch.x431pro.module.p242ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.cnlaunch.x431pro.utils.C2778n;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;

/* renamed from: com.cnlaunch.x431pro.module.ad.ADShowActivity */
/* loaded from: classes.dex */
public class ADShowActivity extends BaseDialogActivity {

    /* renamed from: a */
    public WebView f15463a;

    /* renamed from: e */
    private WebSettings f15467e;

    /* renamed from: f */
    private C2710a f15468f;

    /* renamed from: h */
    private ImageView f15470h;

    /* renamed from: d */
    private String f15466d = "";

    /* renamed from: g */
    private ProgressBar f15469g = null;

    /* renamed from: b */
    protected int f15464b = 0;

    /* renamed from: c */
    public final Handler f15465c = new HandlerC2713c(this);

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdUtil.m5431a().f15476a = true;
        setContentView(R.layout.layout_ad_show);
        Log.i("anqi", "ADSHowActivity onCreate");
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(7);
        } else {
            setRequestedOrientation(6);
        }
        getWindow().setFlags(16777216, 16777216);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f15466d = extras.getString(Annotation.URL, "");
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        int width = (window.getWindowManager().getDefaultDisplay().getWidth() * 90) / 100;
        int height = (window.getWindowManager().getDefaultDisplay().getHeight() * 90) / 100;
        if (this.f15466d.toLowerCase().endsWith("avi") || this.f15466d.toLowerCase().endsWith("wmv") || this.f15466d.toLowerCase().endsWith("rm") || this.f15466d.toLowerCase().endsWith("rmvb") || this.f15466d.toLowerCase().endsWith("mpeg1") || this.f15466d.toLowerCase().endsWith("mpeg2") || this.f15466d.toLowerCase().endsWith("mpeg4") || this.f15466d.toLowerCase().endsWith("mp4") || this.f15466d.toLowerCase().endsWith("3gp") || this.f15466d.toLowerCase().endsWith("asf") || this.f15466d.toLowerCase().endsWith("swf") || this.f15466d.toLowerCase().endsWith("dat") || this.f15466d.toLowerCase().endsWith("mov") || this.f15466d.toLowerCase().endsWith("m4v") || this.f15466d.toLowerCase().endsWith("flv") || this.f15466d.toLowerCase().endsWith("f4v") || this.f15466d.toLowerCase().endsWith("mkv") || this.f15466d.toLowerCase().endsWith("mts") || this.f15466d.toLowerCase().endsWith("ts")) {
            height = (width * 9) / 16;
        }
        window.setLayout(width, height);
        this.f15470h = (ImageView) findViewById(R.id.close);
        this.f15470h.setOnClickListener(new View$OnClickListenerC2711a(this));
        this.f15468f = new C2710a();
        this.f15463a = (WebView) findViewById(R.id.webview);
        this.f15469g = (ProgressBar) findViewById(R.id.webview_progressbar);
        this.f15469g.setMax(100);
        this.f15463a.setWebViewClient(this.f15468f);
        this.f15463a.setWebChromeClient(new C2712b(this));
        this.f15467e = this.f15463a.getSettings();
        this.f15467e.setSupportZoom(true);
        this.f15467e.setUseWideViewPort(true);
        this.f15467e.setLoadWithOverviewMode(true);
        this.f15467e.setBuiltInZoomControls(true);
        this.f15467e.setJavaScriptEnabled(true);
        this.f15467e.setPluginState(WebSettings.PluginState.ON);
        this.f15467e.setUserAgentString("电脑");
        if (Build.VERSION.SDK_INT >= 21) {
            this.f15467e.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f15467e.setMediaPlaybackRequiresUserGesture(false);
        }
        this.f15467e.setAllowFileAccess(true);
        this.f15467e.setAllowFileAccessFromFileURLs(true);
        WebView webView = this.f15463a;
        if (!C2778n.m4917a((Context) this)) {
            this.f15465c.obtainMessage(1).sendToTarget();
            NToast.m9450a(this, (int) R.string.common_network_unavailable);
            return;
        }
        webView.loadUrl(this.f15466d);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f15463a.destroy();
        AdUtil.m5431a().f15476a = false;
    }

    /* renamed from: com.cnlaunch.x431pro.module.ad.ADShowActivity$a */
    /* loaded from: classes.dex */
    class C2710a extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        C2710a() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ADShowActivity.this.f15465c.obtainMessage(0).sendToTarget();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ADShowActivity.this.f15465c.obtainMessage(1).sendToTarget();
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.f15463a.canGoBack()) {
            this.f15463a.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
