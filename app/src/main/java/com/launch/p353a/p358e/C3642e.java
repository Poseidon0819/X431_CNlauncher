package com.launch.p353a.p358e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.launch.p353a.p362i.ImageLoaderListener;

/* compiled from: InterstitialAD.java */
/* renamed from: com.launch.a.e.e */
/* loaded from: classes.dex */
final class C3642e implements ImageLoaderListener {

    /* renamed from: a */
    final /* synthetic */ InterstitialAD f19895a;

    @Override // com.launch.p353a.p362i.ImageLoaderListener
    /* renamed from: a */
    public final void mo2647a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3642e(InterstitialAD interstitialAD) {
        this.f19895a = interstitialAD;
    }

    @Override // com.launch.p353a.p362i.ImageLoaderListener
    /* renamed from: a */
    public final void mo2648a(Bitmap bitmap) {
        this.f19895a.f19890d++;
        if (this.f19895a.f19890d == this.f19895a.f19889c.length()) {
            InterstitialAD interstitialAD = this.f19895a;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() / 1000);
            interstitialAD.m2693a("exposureTime", sb.toString());
            new Handler(Looper.getMainLooper()).post(new RunnableC3643f(this));
        }
    }
}
