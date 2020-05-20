package com.cnlaunch.x431pro.activity.info;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p012v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.MyWebView;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class InfoActivity extends ActivityC2004c {

    /* renamed from: C */
    private WebSettings f12844C;

    /* renamed from: D */
    private C2267a f12845D;

    /* renamed from: E */
    private SwipeRefreshLayout f12846E;

    /* renamed from: F */
    private String f12847F = "http://repairdata.cnlaunch.com/newmain/?source=app";

    /* renamed from: G */
    private List<String> f12848G = new ArrayList();

    /* renamed from: n */
    private MyWebView f12849n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.info_fragment);
        setTitle(R.string.tab_menu_info);
        if (C2744aa.m5123s()) {
            this.f12847F = "http://repairdata.cnlaunch.com/data/diagnosisAndRepair.action";
        }
        this.f12845D = new C2267a();
        this.f12849n = (MyWebView) findViewById(R.id.webview);
        this.f12849n.setWebViewClient(this.f12845D);
        this.f12849n.setListener(new C2277c(this));
        this.f12844C = this.f12849n.getSettings();
        this.f12844C.setSupportZoom(true);
        this.f12844C.setUseWideViewPort(true);
        this.f12844C.setLoadWithOverviewMode(true);
        this.f12844C.setBuiltInZoomControls(true);
        this.f12844C.setJavaScriptEnabled(true);
        LoadDialog.m4684a(this.f10981q, this.f10981q.getString(R.string.string_loading));
        this.f12849n.loadUrl(this.f12847F);
        this.f12848G.add(this.f12847F);
        this.f12846E = (SwipeRefreshLayout) findViewById(R.id.swipe_contain);
        this.f12846E.setOnRefreshListener(new C2278d(this));
        this.f12846E.setColorSchemeResources(17170454);
    }

    /* renamed from: com.cnlaunch.x431pro.activity.info.InfoActivity$a */
    /* loaded from: classes.dex */
    class C2267a extends WebViewClient {
        C2267a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.endsWith(".pdf")) {
                Intent intent = new Intent(InfoActivity.this.f10981q, P_DFScanActivity.class);
                intent.putExtra(Annotation.URL, str);
                InfoActivity.this.f10981q.startActivity(intent);
                return true;
            }
            webView.loadUrl(str);
            InfoActivity.this.f12848G.add(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LoadDialog.m4681b(InfoActivity.this.f10981q);
            InfoActivity.this.f12846E.setRefreshing(false);
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebBackForwardList copyBackForwardList = this.f12849n.copyBackForwardList();
        if (this.f12849n.canGoBack() && keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && !copyBackForwardList.getCurrentItem().getUrl().equals(this.f12847F)) {
            this.f12849n.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
