package com.cnlaunch.x431pro.activity.info;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.info.p227a.InfoFragmentCallback;
import com.cnlaunch.x431pro.widget.MyWebView;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.info.e */
/* loaded from: classes.dex */
public class InfoEuroFragment extends BaseFragment implements OnKeyDownListenter {

    /* renamed from: a */
    private MyWebView f12891a;

    /* renamed from: b */
    private WebSettings f12892b;

    /* renamed from: c */
    private C2279a f12893c;

    /* renamed from: d */
    private String f12894d = "http://www.workshopdata.com/touch/site/layout/wsdLogin";

    /* renamed from: e */
    private List<String> f12895e = new ArrayList();

    /* renamed from: f */
    private InfoFragmentCallback f12896f = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12896f = (InfoFragmentCallback) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.data_euro);
        this.f12893c = new C2279a();
        this.f12891a = (MyWebView) getActivity().findViewById(R.id.webview);
        this.f12891a.setWebViewClient(this.f12893c);
        this.f12891a.setListener(new C2280f(this));
        this.f12892b = this.f12891a.getSettings();
        this.f12892b.setSupportZoom(true);
        this.f12892b.setUseWideViewPort(true);
        this.f12892b.setLoadWithOverviewMode(true);
        this.f12892b.setBuiltInZoomControls(true);
        this.f12892b.setJavaScriptEnabled(true);
        LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.string_loading));
        this.f12891a.loadUrl(this.f12894d);
        this.f12895e.add(this.f12894d);
        this.f12896f.mo6859a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.info_fragment, viewGroup, false);
    }

    /* compiled from: InfoEuroFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.info.e$a */
    /* loaded from: classes.dex */
    class C2279a extends WebViewClient {
        C2279a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.endsWith(".pdf")) {
                Intent intent = new Intent(InfoEuroFragment.this.mContext, P_DFScanActivity.class);
                intent.putExtra(Annotation.URL, str);
                InfoEuroFragment.this.mContext.startActivity(intent);
                return true;
            }
            webView.loadUrl(str);
            InfoEuroFragment.this.f12895e.add(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LoadDialog.m4681b(InfoEuroFragment.this.mContext);
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f12896f.mo6858h();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebBackForwardList copyBackForwardList = this.f12891a.copyBackForwardList();
        if (this.f12891a.canGoBack() && keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && !copyBackForwardList.getCurrentItem().getUrl().equals(this.f12894d)) {
            Log.i("anqi", "mWebBackForwardList.getCurrentItem().getUrl()=" + copyBackForwardList.getCurrentItem().getUrl());
            this.f12891a.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
