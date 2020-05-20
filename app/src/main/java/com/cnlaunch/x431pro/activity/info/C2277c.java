package com.cnlaunch.x431pro.activity.info;

import com.cnlaunch.x431pro.widget.MyWebView;

/* compiled from: InfoActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.c */
/* loaded from: classes.dex */
final class C2277c extends MyWebView.C2790a {

    /* renamed from: a */
    final /* synthetic */ InfoActivity f12889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2277c(InfoActivity infoActivity) {
        this.f12889a = infoActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.MyWebView.C2790a
    /* renamed from: a */
    public final void mo4782a(boolean z) {
        if (z) {
            this.f12889a.m7732g().setTouchModeAbove(1);
        } else {
            this.f12889a.m7732g().setTouchModeAbove(2);
        }
    }
}
