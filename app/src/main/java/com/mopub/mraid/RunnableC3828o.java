package com.mopub.mraid;

import android.view.View;
import com.mopub.mraid.MraidController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.o */
/* loaded from: classes.dex */
public final class RunnableC3828o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MraidController.C3806b.C3807a f20726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3828o(MraidController.C3806b.C3807a c3807a) {
        this.f20726a = c3807a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View[] viewArr;
        for (View view : this.f20726a.f20687a) {
            if (view.getHeight() > 0 || view.getWidth() > 0) {
                MraidController.C3806b.C3807a.m2223a(this.f20726a);
            } else {
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC3829p(this, view));
            }
        }
    }
}
