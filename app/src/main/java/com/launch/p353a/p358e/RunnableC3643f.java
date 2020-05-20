package com.launch.p353a.p358e;

import android.app.FragmentManager;

/* compiled from: InterstitialAD.java */
/* renamed from: com.launch.a.e.f */
/* loaded from: classes.dex */
final class RunnableC3643f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3642e f19896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3643f(C3642e c3642e) {
        this.f19896a = c3642e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterstitialAD interstitialAD = this.f19896a.f19895a;
        StepDialog m2689a = StepDialog.m2689a();
        m2689a.f19908e = interstitialAD.f19889c;
        m2689a.f19909f = interstitialAD.f19887a;
        m2689a.f19906c = true;
        m2689a.f19905a = new DepthPageTransformer();
        m2689a.f19907d = new C3644g(interstitialAD);
        FragmentManager fragmentManager = interstitialAD.f19888b.getFragmentManager();
        if (StepDialog.f19904b != null) {
            StepDialog.f19904b.show(fragmentManager, "ZqgDialogFragment");
        }
    }
}
