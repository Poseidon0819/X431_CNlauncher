package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.C4652j;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebViewJavascriptBridge implements Serializable {
    InterfaceC4124ac _messageHandler;
    Map _messageHandlers = new HashMap();
    Map _responseCallbacks = new HashMap();
    long _uniqueId = 0;
    Activity mContext;
    WebView mWebView;

    public WebViewJavascriptBridge(Activity activity, WebView webView, InterfaceC4124ac interfaceC4124ac) {
        this.mContext = activity;
        this.mWebView = webView;
        this._messageHandler = interfaceC4124ac;
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
        this.mWebView.setWebViewClient(new C4123ab(this, (byte) 0));
        this.mWebView.setWebChromeClient(new C4122aa(this, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _callbackJs(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("responseId", str);
        hashMap.put(Constant.KEY_RESPONSE_DATA, str2);
        _dispatchMessage(hashMap);
    }

    private void _dispatchMessage(Map map) {
        String jSONObject = new JSONObject(map).toString();
        C4652j.m433a("test", "sending:".concat(String.valueOf(jSONObject)));
        this.mContext.runOnUiThread(new RunnableC4659y(this, String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", doubleEscapeString(jSONObject))));
    }

    private void _sendData(String str, InterfaceC4125ad interfaceC4125ad, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(DataPacketExtension.ELEMENT_NAME, str);
        if (interfaceC4125ad != null) {
            StringBuilder sb = new StringBuilder("java_cb_");
            long j = this._uniqueId + 1;
            this._uniqueId = j;
            sb.append(j);
            String sb2 = sb.toString();
            this._responseCallbacks.put(sb2, interfaceC4125ad);
            hashMap.put("callbackId", sb2);
        }
        if (str2 != null) {
            hashMap.put("handlerName", str2);
        }
        _dispatchMessage(hashMap);
    }

    public static String convertStreamToString(InputStream inputStream) {
        String str;
        str = "";
        try {
            Scanner useDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            str = useDelimiter.hasNext() ? useDelimiter.next() : "";
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String doubleEscapeString(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
    }

    private void loadWebViewJavascriptBridgeJs(WebView webView) {
        webView.loadUrl("javascript:".concat(String.valueOf(convertStreamToString(getClass().getResourceAsStream("res/webviewjavascriptbridge.js")))));
    }

    @JavascriptInterface
    public void _handleMessageFromJs(String str, String str2, String str3, String str4, String str5) {
        InterfaceC4124ac interfaceC4124ac;
        if (str2 != null) {
            ((InterfaceC4125ad) this._responseCallbacks.get(str2)).mo429a(str3);
            this._responseCallbacks.remove(str2);
            return;
        }
        C4660z c4660z = str4 != null ? new C4660z(this, str4) : null;
        if (str5 != null) {
            interfaceC4124ac = (InterfaceC4124ac) this._messageHandlers.get(str5);
            if (interfaceC4124ac == null) {
                C4652j.m432b("test", "WVJB Warning: No handler for ".concat(String.valueOf(str5)));
                return;
            }
        } else {
            interfaceC4124ac = this._messageHandler;
        }
        try {
            this.mContext.runOnUiThread(new RunnableC4658x(this, interfaceC4124ac, str, c4660z));
        } catch (Exception e) {
            C4652j.m432b("test", "WebViewJavascriptBridge: WARNING: java handler threw. " + e.getMessage());
        }
    }

    public void callHandler(String str) {
        callHandler(str, null, null);
    }

    public void callHandler(String str, String str2) {
        callHandler(str, str2, null);
    }

    public void callHandler(String str, String str2, InterfaceC4125ad interfaceC4125ad) {
        _sendData(str2, interfaceC4125ad, str);
    }

    public void registerHandler(String str, InterfaceC4124ac interfaceC4124ac) {
        this._messageHandlers.put(str, interfaceC4124ac);
    }

    public void send(String str) {
        send(str, null);
    }

    public void send(String str, InterfaceC4125ad interfaceC4125ad) {
        _sendData(str, interfaceC4125ad, null);
    }
}
