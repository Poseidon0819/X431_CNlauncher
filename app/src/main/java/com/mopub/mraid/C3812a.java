package com.mopub.mraid;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.mraid.MraidBridge;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.a */
/* loaded from: classes.dex */
public final class C3812a extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f20706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3812a(MraidBridge mraidBridge) {
        this.f20706a = mraidBridge;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        MraidBridge.MraidBridgeListener mraidBridgeListener;
        MraidBridge.MraidBridgeListener mraidBridgeListener2;
        mraidBridgeListener = this.f20706a.f20645a;
        if (mraidBridgeListener != null) {
            mraidBridgeListener2 = this.f20706a.f20645a;
            return mraidBridgeListener2.onJsAlert(str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        MraidBridge.MraidBridgeListener mraidBridgeListener;
        MraidBridge.MraidBridgeListener mraidBridgeListener2;
        mraidBridgeListener = this.f20706a.f20645a;
        if (mraidBridgeListener != null) {
            mraidBridgeListener2 = this.f20706a.f20645a;
            return mraidBridgeListener2.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
