package com.mopub.mobileads.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
import com.mopub.common.util.Reflection;

/* loaded from: classes.dex */
public class WebViews {
    @TargetApi(11)
    public static void onResume(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onResume();
            return;
        }
        try {
            new Reflection.MethodBuilder(webView, "onResume").setAccessible().execute();
        } catch (Exception unused) {
        }
    }

    @TargetApi(11)
    public static void onPause(WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onPause();
            return;
        }
        try {
            new Reflection.MethodBuilder(webView, "onPause").setAccessible().execute();
        } catch (Exception unused) {
        }
    }

    public static void setDisableJSChromeClient(WebView webView) {
        webView.setWebChromeClient(new C3795a());
    }
}
