package com.unionpay;

/* renamed from: com.unionpay.z */
/* loaded from: classes2.dex */
final class C4660z implements InterfaceC4125ad {

    /* renamed from: a */
    final /* synthetic */ WebViewJavascriptBridge f23776a;

    /* renamed from: b */
    private final String f23777b;

    public C4660z(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.f23776a = webViewJavascriptBridge;
        this.f23777b = str;
    }

    @Override // com.unionpay.InterfaceC4125ad
    /* renamed from: a */
    public final void mo429a(String str) {
        this.f23776a._callbackJs(this.f23777b, str);
    }
}
