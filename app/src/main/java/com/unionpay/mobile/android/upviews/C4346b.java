package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.Timer;

/* renamed from: com.unionpay.mobile.android.upviews.b */
/* loaded from: classes2.dex */
public final class C4346b extends WebView implements Handler.Callback {

    /* renamed from: a */
    private WebSettings f23030a;

    /* renamed from: b */
    private Handler f23031b;

    /* renamed from: c */
    private InterfaceC4347a f23032c;

    /* renamed from: d */
    private Timer f23033d;

    /* renamed from: e */
    private boolean f23034e;

    /* renamed from: f */
    private ArrayList<String> f23035f;

    /* renamed from: com.unionpay.mobile.android.upviews.b$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4347a {
        /* renamed from: r */
        void mo1003r();

        /* renamed from: s */
        void mo1002s();
    }

    /* renamed from: com.unionpay.mobile.android.upviews.b$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC4348b extends InterfaceC4347a {
        /* renamed from: c */
        void mo1001c(String str);
    }

    /* renamed from: com.unionpay.mobile.android.upviews.b$c */
    /* loaded from: classes2.dex */
    class C4349c extends WebChromeClient {
        private C4349c() {
        }

        /* synthetic */ C4349c(C4346b c4346b, byte b) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                C4346b.this.f23031b.sendEmptyMessage(1);
            }
        }
    }

    /* renamed from: com.unionpay.mobile.android.upviews.b$d */
    /* loaded from: classes2.dex */
    class C4350d extends WebViewClient {
        private C4350d() {
        }

        /* synthetic */ C4350d(C4346b c4346b, byte b) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C4346b.this.f23033d.cancel();
            C4346b.this.f23033d.purge();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C4346b.this.f23033d = new Timer();
            C4346b.this.f23033d.schedule(new C4351c(this), 30000L);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            C4346b.this.m1012a();
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = null;
            if (C4346b.this.f23035f != null && C4346b.this.f23035f.size() != 0 && str != null && str.length() > 0) {
                int i = 0;
                while (true) {
                    if (C4346b.this.f23035f == null || i >= C4346b.this.f23035f.size()) {
                        break;
                    } else if (str.startsWith((String) C4346b.this.f23035f.get(i))) {
                        str2 = (String) C4346b.this.f23035f.get(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (str2 == null) {
                webView.loadUrl(str);
                return true;
            }
            Message obtainMessage = C4346b.this.f23031b.obtainMessage(4);
            obtainMessage.obj = str;
            C4346b.this.f23031b.sendMessage(obtainMessage);
            return true;
        }
    }

    public C4346b(Context context, InterfaceC4347a interfaceC4347a) {
        super(context);
        this.f23030a = null;
        this.f23031b = null;
        this.f23032c = null;
        this.f23033d = new Timer();
        this.f23034e = false;
        this.f23035f = null;
        this.f23031b = new Handler(this);
        this.f23032c = interfaceC4347a;
        setScrollBarStyle(33554432);
        this.f23030a = getSettings();
        this.f23030a.setJavaScriptEnabled(true);
        setWebChromeClient(new C4349c(this, (byte) 0));
        setWebViewClient(new C4350d(this, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public final void m1012a() {
        loadData(String.format("<div align=\"center\">%s</div>", "&#x7F51;&#x9875;&#x52A0;&#x8F7D;&#x5931;&#x8D25;&#xFF0C;&#x8BF7;&#x91CD;&#x8BD5;"), "text/html", "utf-8");
    }

    /* renamed from: a */
    public final void m1009a(String str) {
        if (this.f23035f == null) {
            this.f23035f = new ArrayList<>();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        this.f23035f.add(str);
    }

    /* renamed from: b */
    public final void m1007b(String str) {
        Message obtainMessage = this.f23031b.obtainMessage(0);
        obtainMessage.obj = str;
        this.f23031b.sendMessage(obtainMessage);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        switch (message2.what) {
            case 0:
                InterfaceC4347a interfaceC4347a = this.f23032c;
                if (interfaceC4347a != null) {
                    interfaceC4347a.mo1003r();
                }
                String str = message2.obj != null ? (String) message2.obj : "";
                Log.e("uppay", "url = ".concat(String.valueOf(str)));
                loadUrl(str);
                break;
            case 3:
                m1012a();
            case 1:
            case 2:
                if (message2.what == 1) {
                    this.f23034e = true;
                }
                InterfaceC4347a interfaceC4347a2 = this.f23032c;
                if (interfaceC4347a2 != null) {
                    interfaceC4347a2.mo1002s();
                    break;
                }
                break;
            case 4:
                InterfaceC4347a interfaceC4347a3 = this.f23032c;
                if (interfaceC4347a3 != null && (interfaceC4347a3 instanceof InterfaceC4348b)) {
                    ((InterfaceC4348b) interfaceC4347a3).mo1001c((String) message2.obj);
                    break;
                }
                break;
        }
        return true;
    }
}
