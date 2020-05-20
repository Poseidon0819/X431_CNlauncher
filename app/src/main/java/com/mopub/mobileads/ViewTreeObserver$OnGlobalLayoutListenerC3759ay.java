package com.mopub.mobileads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.ay */
/* loaded from: classes.dex */
public final class ViewTreeObserver$OnGlobalLayoutListenerC3759ay implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ Activity f20551a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f20552b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC3759ay(VastVideoViewController vastVideoViewController, Activity activity) {
        this.f20552b = vastVideoViewController;
        this.f20551a = activity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        VastVideoViewController vastVideoViewController = this.f20552b;
        vastVideoViewController.f20475s = vastVideoViewController.m2364a(this.f20551a, vastVideoViewController.f20461e.get(VastXmlManagerAggregator.ADS_BY_AD_SLOT_ID), vastVideoViewController.f20462f.getHeight(), 1, vastVideoViewController.f20462f, 0, 6);
        view = this.f20552b.f20462f;
        view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
