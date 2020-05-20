package com.mopub.mobileads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdViewController.java */
/* renamed from: com.mopub.mobileads.c */
/* loaded from: classes.dex */
public final class RunnableC3772c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f20574a;

    /* renamed from: b */
    final /* synthetic */ AdViewController f20575b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3772c(AdViewController adViewController, View view) {
        this.f20575b = adViewController;
        this.f20574a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubView moPubView = this.f20575b.getMoPubView();
        if (moPubView == null) {
            return;
        }
        moPubView.removeAllViews();
        View view = this.f20574a;
        moPubView.addView(view, AdViewController.m2468a(this.f20575b, view));
    }
}
