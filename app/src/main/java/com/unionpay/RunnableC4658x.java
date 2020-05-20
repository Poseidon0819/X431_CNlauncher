package com.unionpay;

/* renamed from: com.unionpay.x */
/* loaded from: classes2.dex */
final class RunnableC4658x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4124ac f23770a;

    /* renamed from: b */
    final /* synthetic */ String f23771b;

    /* renamed from: c */
    final /* synthetic */ InterfaceC4125ad f23772c;

    /* renamed from: d */
    final /* synthetic */ WebViewJavascriptBridge f23773d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4658x(WebViewJavascriptBridge webViewJavascriptBridge, InterfaceC4124ac interfaceC4124ac, String str, InterfaceC4125ad interfaceC4125ad) {
        this.f23773d = webViewJavascriptBridge;
        this.f23770a = interfaceC4124ac;
        this.f23771b = str;
        this.f23772c = interfaceC4125ad;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC4124ac interfaceC4124ac = this.f23770a;
        if (interfaceC4124ac != null) {
            interfaceC4124ac.mo430a(this.f23771b, this.f23772c);
        }
    }
}
