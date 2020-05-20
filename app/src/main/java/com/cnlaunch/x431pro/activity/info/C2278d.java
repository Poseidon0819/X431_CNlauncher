package com.cnlaunch.x431pro.activity.info;

import android.support.p012v4.widget.SwipeRefreshLayout;
import com.cnlaunch.x431pro.widget.MyWebView;

/* compiled from: InfoActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.d */
/* loaded from: classes.dex */
final class C2278d implements SwipeRefreshLayout.InterfaceC0315b {

    /* renamed from: a */
    final /* synthetic */ InfoActivity f12890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2278d(InfoActivity infoActivity) {
        this.f12890a = infoActivity;
    }

    @Override // android.support.p012v4.widget.SwipeRefreshLayout.InterfaceC0315b
    /* renamed from: a */
    public final void mo6847a() {
        MyWebView myWebView;
        MyWebView myWebView2;
        myWebView = this.f12890a.f12849n;
        myWebView2 = this.f12890a.f12849n;
        myWebView.loadUrl(myWebView2.getUrl());
    }
}
