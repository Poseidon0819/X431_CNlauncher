package com.launch.p353a.p358e;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterstitialAD.java */
/* renamed from: com.launch.a.e.h */
/* loaded from: classes.dex */
public final class RunnableC3645h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f19898a;

    /* renamed from: b */
    final /* synthetic */ String f19899b;

    /* renamed from: c */
    final /* synthetic */ InterstitialAD f19900c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3645h(InterstitialAD interstitialAD, String str, String str2) {
        this.f19900c = interstitialAD;
        this.f19898a = str;
        this.f19899b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f19900c.f19888b.getSharedPreferences("Lau", 0).edit();
        edit.putString(this.f19898a, this.f19899b);
        edit.commit();
    }
}
