package com.mopub.nativeads;

import android.view.ViewTreeObserver;

/* compiled from: VisibilityTracker.java */
/* renamed from: com.mopub.nativeads.bf */
/* loaded from: classes2.dex */
final class ViewTreeObserver$OnPreDrawListenerC3885bf implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ VisibilityTracker f21139a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnPreDrawListenerC3885bf(VisibilityTracker visibilityTracker) {
        this.f21139a = visibilityTracker;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f21139a.m2057c();
        return true;
    }
}
