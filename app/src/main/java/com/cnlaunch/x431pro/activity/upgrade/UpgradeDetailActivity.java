package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;
import com.ifoer.expedition.pro.R;
import com.mopub.common.MoPubBrowser;
import org.apache.http.util.EncodingUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UpgradeDetailActivity extends ActivityC2004c {

    /* renamed from: G */
    private C2601a f14983G;

    /* renamed from: H */
    private Context f14984H;

    /* renamed from: J */
    private BroadcastReceiver f14986J;

    /* renamed from: n */
    private final String f14987n = UpgradeDetailActivity.class.getSimpleName();

    /* renamed from: C */
    private WebView f14979C = null;

    /* renamed from: D */
    private String f14980D = null;

    /* renamed from: E */
    private String f14981E = null;

    /* renamed from: F */
    private ProgressBarCircularIndeterminate f14982F = null;

    /* renamed from: I */
    private final Handler f14985I = new HandlerC2703z(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        WebView webView;
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.show_upgrade_detail_view);
        m7743b();
        this.f14984H = this;
        Bundle extras = getIntent().getExtras();
        this.f14980D = extras.getString(MoPubBrowser.DESTINATION_URL_KEY);
        this.f14981E = extras.getString("PostData");
        String str2 = this.f14987n;
        NLog.m9456a(str2, "URL:" + this.f14980D + ",PostData:" + this.f14981E);
        this.f14979C = (WebView) findViewById(R.id.WebViewUpgradeNotice);
        this.f14979C.setBackgroundColor(0);
        this.f14982F = (ProgressBarCircularIndeterminate) findViewById(R.id.loading_progress);
        this.f14983G = new C2601a();
        this.f14979C.getSettings().setJavaScriptEnabled(true);
        this.f14979C.getSettings().setDomStorageEnabled(true);
        this.f14979C.getSettings().supportMultipleWindows();
        this.f14979C.setWebViewClient(this.f14983G);
        this.f14979C.setWebChromeClient(new C2702y(this));
        this.f14979C.addJavascriptInterface(new C2602b(this, (byte) 0), "android");
        String str3 = this.f14980D;
        if (str3 == null || (str = this.f14981E) == null) {
            String str4 = this.f14980D;
            if (str4 != null && (webView = this.f14979C) != null) {
                webView.loadUrl(str4);
            }
        } else {
            WebView webView2 = this.f14979C;
            if (webView2 != null) {
                webView2.postUrl(str3, EncodingUtils.getBytes(str, "BASE64"));
            }
        }
        if (this.f14986J == null) {
            this.f14986J = new C2621aa(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("BROADCAST_ACTION_UPGRADE_SUCCESSFULLY");
            intentFilter.addAction("BROADCAST_ACTION_PIN_CARD_PAY_SUCCESSFULLY");
            this.f14984H.registerReceiver(this.f14986J, intentFilter);
        }
    }

    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.UpgradeDetailActivity$b */
    /* loaded from: classes.dex */
    class C2602b {
        private C2602b() {
        }

        /* synthetic */ C2602b(UpgradeDetailActivity upgradeDetailActivity, byte b) {
            this();
        }
    }

    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.UpgradeDetailActivity$a */
    /* loaded from: classes.dex */
    class C2601a extends WebViewClient {
        C2601a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            UpgradeDetailActivity.this.f14985I.obtainMessage(0).sendToTarget();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            UpgradeDetailActivity.this.f14985I.obtainMessage(1).sendToTarget();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && getFragmentManager().getBackStackEntryCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f14986J;
        if (broadcastReceiver != null) {
            this.f14984H.unregisterReceiver(broadcastReceiver);
            this.f14986J = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5817a(UpgradeDetailActivity upgradeDetailActivity, String str, String str2) {
        try {
            if (upgradeDetailActivity.isFinishing()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("name", str2);
            upgradeDetailActivity.f14979C.post(new RunnableC2622ab(upgradeDetailActivity, "javascript:removeItemForAndroid(" + jSONObject.toString() + ")"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
