package com.afollestad.materialdialogs.internal;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDRootLayout.java */
/* renamed from: com.afollestad.materialdialogs.internal.b */
/* loaded from: classes.dex */
public final class ViewTreeObserver$OnPreDrawListenerC0716b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ View f3467a;

    /* renamed from: b */
    final /* synthetic */ boolean f3468b;

    /* renamed from: c */
    final /* synthetic */ boolean f3469c;

    /* renamed from: d */
    final /* synthetic */ MDRootLayout f3470d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnPreDrawListenerC0716b(MDRootLayout mDRootLayout, View view, boolean z, boolean z2) {
        this.f3470d = mDRootLayout;
        this.f3467a = view;
        this.f3468b = z;
        this.f3469c = z2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f3467a.getMeasuredHeight() != 0) {
            if (MDRootLayout.m12568a((WebView) this.f3467a)) {
                this.f3470d.m12569a((ViewGroup) this.f3467a, this.f3468b, this.f3469c);
            } else {
                if (this.f3468b) {
                    MDRootLayout.m12565a(this.f3470d);
                }
                if (this.f3469c) {
                    MDRootLayout.m12560b(this.f3470d);
                }
            }
            this.f3467a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
        return true;
    }
}
