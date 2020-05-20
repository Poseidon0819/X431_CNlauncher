package com.mopub.mraid;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.n */
/* loaded from: classes.dex */
public final class RunnableC3827n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f20723a;

    /* renamed from: b */
    final /* synthetic */ Runnable f20724b;

    /* renamed from: c */
    final /* synthetic */ MraidController f20725c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3827n(MraidController mraidController, View view, Runnable runnable) {
        this.f20725c = mraidController;
        this.f20723a = view;
        this.f20724b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        MraidScreenMetrics mraidScreenMetrics;
        ViewGroup m2235e;
        MraidScreenMetrics mraidScreenMetrics2;
        FrameLayout frameLayout;
        MraidScreenMetrics mraidScreenMetrics3;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        MraidScreenMetrics mraidScreenMetrics4;
        MraidBridge mraidBridge;
        MraidScreenMetrics mraidScreenMetrics5;
        MraidBridge mraidBridge2;
        MraidBridge mraidBridge3;
        MraidScreenMetrics mraidScreenMetrics6;
        context = this.f20725c.f20657a;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mraidScreenMetrics = this.f20725c.f20661e;
        mraidScreenMetrics.f20737a.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        mraidScreenMetrics.m2206a(mraidScreenMetrics.f20737a, mraidScreenMetrics.f20738b);
        int[] iArr = new int[2];
        m2235e = this.f20725c.m2235e();
        m2235e.getLocationOnScreen(iArr);
        mraidScreenMetrics2 = this.f20725c.f20661e;
        int i = iArr[0];
        int i2 = iArr[1];
        mraidScreenMetrics2.f20739c.set(i, i2, m2235e.getWidth() + i, m2235e.getHeight() + i2);
        mraidScreenMetrics2.m2206a(mraidScreenMetrics2.f20739c, mraidScreenMetrics2.f20740d);
        frameLayout = this.f20725c.f20659c;
        frameLayout.getLocationOnScreen(iArr);
        mraidScreenMetrics3 = this.f20725c.f20661e;
        int i3 = iArr[0];
        int i4 = iArr[1];
        frameLayout2 = this.f20725c.f20659c;
        int width = frameLayout2.getWidth();
        frameLayout3 = this.f20725c.f20659c;
        mraidScreenMetrics3.f20743g.set(i3, i4, width + i3, frameLayout3.getHeight() + i4);
        mraidScreenMetrics3.m2206a(mraidScreenMetrics3.f20743g, mraidScreenMetrics3.f20744h);
        this.f20723a.getLocationOnScreen(iArr);
        mraidScreenMetrics4 = this.f20725c.f20661e;
        int i5 = iArr[0];
        int i6 = iArr[1];
        mraidScreenMetrics4.f20741e.set(i5, i6, this.f20723a.getWidth() + i5, this.f20723a.getHeight() + i6);
        mraidScreenMetrics4.m2206a(mraidScreenMetrics4.f20741e, mraidScreenMetrics4.f20742f);
        mraidBridge = this.f20725c.f20673q;
        mraidScreenMetrics5 = this.f20725c.f20661e;
        mraidBridge.notifyScreenMetrics(mraidScreenMetrics5);
        mraidBridge2 = this.f20725c.f20666j;
        if (mraidBridge2.m2262b()) {
            mraidBridge3 = this.f20725c.f20666j;
            mraidScreenMetrics6 = this.f20725c.f20661e;
            mraidBridge3.notifyScreenMetrics(mraidScreenMetrics6);
        }
        Runnable runnable = this.f20724b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
