package com.cnlaunch.x431pro.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.ifoer.expedition.pro.R;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.k */
/* loaded from: classes.dex */
public abstract class BaseWebFragment extends BaseFragment {

    /* renamed from: a */
    public WebView f12969a;

    /* renamed from: c */
    private WebSettings f12971c;

    /* renamed from: d */
    private C2298a f12972d;

    /* renamed from: e */
    private ProgressBar f12973e = null;

    /* renamed from: b */
    protected final Handler f12970b = new HandlerC2384m(this);

    /* renamed from: a */
    public static boolean m6809a(boolean z) {
        return z;
    }

    /* renamed from: a */
    public abstract void mo5836a(WebView webView);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_websearch, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12972d = new C2298a();
        this.f12969a = (WebView) getActivity().findViewById(R.id.webview);
        this.f12973e = (ProgressBar) getActivity().findViewById(R.id.webview_progressbar);
        this.f12973e.setMax(100);
        this.f12969a.setWebViewClient(this.f12972d);
        this.f12969a.setWebChromeClient(new C2299l(this));
        this.f12971c = this.f12969a.getSettings();
        this.f12971c.setSupportZoom(true);
        this.f12971c.setUseWideViewPort(true);
        this.f12971c.setLoadWithOverviewMode(true);
        this.f12971c.setBuiltInZoomControls(true);
        this.f12971c.setJavaScriptEnabled(true);
        mo5836a(this.f12969a);
    }

    /* compiled from: BaseWebFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.k$a */
    /* loaded from: classes.dex */
    class C2298a extends WebViewClient {
        C2298a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return BaseWebFragment.m6809a(super.shouldOverrideUrlLoading(webView, str));
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            BaseWebFragment.this.f12970b.obtainMessage(0).sendToTarget();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            BaseWebFragment.this.f12970b.obtainMessage(1).sendToTarget();
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }
}
