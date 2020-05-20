package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/* loaded from: classes.dex */
public class MyWebView extends WebView {

    /* renamed from: a */
    public C2790a f16013a;

    /* renamed from: com.cnlaunch.x431pro.widget.MyWebView$a */
    /* loaded from: classes.dex */
    public static class C2790a {
        /* renamed from: a */
        public void mo4782a(boolean z) {
        }
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setListener(C2790a c2790a) {
        this.f16013a = c2790a;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f16013a.mo4782a(i == 0);
    }
}
