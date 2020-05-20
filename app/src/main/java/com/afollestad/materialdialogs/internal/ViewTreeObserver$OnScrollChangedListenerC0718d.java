package com.afollestad.materialdialogs.internal;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDRootLayout.java */
/* renamed from: com.afollestad.materialdialogs.internal.d */
/* loaded from: classes.dex */
public final class ViewTreeObserver$OnScrollChangedListenerC0718d implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f3475a;

    /* renamed from: b */
    final /* synthetic */ boolean f3476b;

    /* renamed from: c */
    final /* synthetic */ boolean f3477c;

    /* renamed from: d */
    final /* synthetic */ MDRootLayout f3478d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnScrollChangedListenerC0718d(MDRootLayout mDRootLayout, ViewGroup viewGroup, boolean z, boolean z2) {
        this.f3478d = mDRootLayout;
        this.f3475a = viewGroup;
        this.f3476b = z;
        this.f3477c = z2;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        MDButton[] mDButtonArr;
        mDButtonArr = this.f3478d.f3446a;
        int length = mDButtonArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < length) {
                MDButton mDButton = mDButtonArr[i];
                if (mDButton != null && mDButton.getVisibility() != 8) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        ViewGroup viewGroup = this.f3475a;
        if (viewGroup instanceof WebView) {
            MDRootLayout.m12562a(this.f3478d, (WebView) viewGroup, this.f3476b, this.f3477c, z);
        } else {
            MDRootLayout.m12563a(this.f3478d, viewGroup, this.f3476b, this.f3477c, z);
        }
        this.f3478d.invalidate();
    }
}
