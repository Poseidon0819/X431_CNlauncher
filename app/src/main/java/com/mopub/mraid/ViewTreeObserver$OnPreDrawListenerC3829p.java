package com.mopub.mraid;

import android.view.View;
import android.view.ViewTreeObserver;
import com.mopub.mraid.MraidController;

/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.p */
/* loaded from: classes.dex */
final class ViewTreeObserver$OnPreDrawListenerC3829p implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ View f20727a;

    /* renamed from: b */
    final /* synthetic */ RunnableC3828o f20728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnPreDrawListenerC3829p(RunnableC3828o runnableC3828o, View view) {
        this.f20728b = runnableC3828o;
        this.f20727a = view;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f20727a.getViewTreeObserver().removeOnPreDrawListener(this);
        MraidController.C3806b.C3807a.m2223a(this.f20728b.f20726a);
        return true;
    }
}
