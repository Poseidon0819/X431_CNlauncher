package com.cnlaunch.x431pro.activity.info;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.MyWebView;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.info.g */
/* loaded from: classes.dex */
public class InfoFragment extends BaseFragment implements OnKeyDownListenter {

    /* renamed from: a */
    private MyWebView f12899a;

    /* renamed from: b */
    private WebSettings f12900b;

    /* renamed from: c */
    private C2281a f12901c;

    /* renamed from: d */
    private String f12902d = "http://repairdata.cnlaunch.com/newmain/?source=app";

    /* renamed from: e */
    private final String f12903e = "http://repairdata.cnlaunch.com/data/vehicles.action";

    /* renamed from: f */
    private List<String> f12904f = new ArrayList();

    /* renamed from: g */
    private InfoFragmentCallback f12905g = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12905g = (InfoFragmentCallback) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.repair_help);
        if (C2744aa.m5123s()) {
            this.f12902d = "http://repairdata.cnlaunch.com/data/diagnosisAndRepair.action";
        }
        this.f12901c = new C2281a();
        this.f12899a = (MyWebView) getActivity().findViewById(R.id.webview);
        this.f12899a.setWebViewClient(this.f12901c);
        this.f12899a.setListener(new C2282h(this));
        this.f12900b = this.f12899a.getSettings();
        this.f12900b.setSupportZoom(true);
        this.f12900b.setUseWideViewPort(true);
        this.f12900b.setLoadWithOverviewMode(true);
        this.f12900b.setBuiltInZoomControls(true);
        this.f12900b.setJavaScriptEnabled(true);
        LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.string_loading));
        this.f12899a.loadUrl(this.f12902d);
        this.f12904f.add(this.f12902d);
        this.f12905g.mo6859a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.info_fragment, viewGroup, false);
    }

    /* compiled from: InfoFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.info.g$a */
    /* loaded from: classes.dex */
    class C2281a extends WebViewClient {
        C2281a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.endsWith(".pdf")) {
                Intent intent = new Intent(InfoFragment.this.mContext, P_DFScanActivity.class);
                intent.putExtra(Annotation.URL, str);
                InfoFragment.this.mContext.startActivity(intent);
                return true;
            }
            webView.loadUrl(str);
            InfoFragment.this.f12904f.add(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LoadDialog.m4681b(InfoFragment.this.mContext);
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f12905g.mo6858h();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebBackForwardList copyBackForwardList = this.f12899a.copyBackForwardList();
        if (this.f12899a.canGoBack() && keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && !copyBackForwardList.getCurrentItem().getUrl().equals(this.f12902d)) {
            this.f12899a.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
