package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.mapapi.UIMsg;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.VersionCode;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

/* loaded from: classes.dex */
public class BaseWebView extends WebView {

    /* renamed from: b */
    private static boolean f20307b = false;

    /* renamed from: a */
    protected boolean f20308a;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        m2448a(false);
        getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 11) {
            getSettings().setAllowContentAccess(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        WebViews.setDisableJSChromeClient(this);
        if (f20307b) {
            return;
        }
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context2.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = UIMsg.m_AppUI.MSG_APP_VERSION_FORCE;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            ((WindowManager) context2.getSystemService("window")).addView(webView, layoutParams);
        }
        f20307b = true;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f20308a = true;
        Views.removeFromParent(this);
        removeAllViews();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2448a(boolean z) {
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2)) {
            return;
        }
        if (z) {
            getSettings().setPluginState(WebSettings.PluginState.ON);
        } else {
            getSettings().setPluginState(WebSettings.PluginState.OFF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    public final void m2449a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        getSettings().setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    }

    @VisibleForTesting
    @Deprecated
    void setIsDestroyed(boolean z) {
        this.f20308a = z;
    }
}
