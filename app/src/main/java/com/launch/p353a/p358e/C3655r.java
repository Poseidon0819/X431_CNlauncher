package com.launch.p353a.p358e;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.launch.p353a.p359f.ClickManager;
import com.launch.p353a.p362i.ImageLoaderListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepDialog.java */
/* renamed from: com.launch.a.e.r */
/* loaded from: classes.dex */
public final class C3655r implements ImageLoaderListener {

    /* renamed from: a */
    final /* synthetic */ ImageView f19926a;

    /* renamed from: b */
    final /* synthetic */ String f19927b;

    /* renamed from: c */
    final /* synthetic */ String f19928c;

    /* renamed from: d */
    final /* synthetic */ String f19929d;

    /* renamed from: e */
    final /* synthetic */ StepDialog f19930e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3655r(StepDialog stepDialog, ImageView imageView, String str, String str2, String str3) {
        this.f19930e = stepDialog;
        this.f19926a = imageView;
        this.f19927b = str;
        this.f19928c = str2;
        this.f19929d = str3;
    }

    @Override // com.launch.p353a.p362i.ImageLoaderListener
    /* renamed from: a */
    public final void mo2648a(Bitmap bitmap) {
        AbstractInterstitialADListener abstractInterstitialADListener;
        AbstractInterstitialADListener abstractInterstitialADListener2;
        int i;
        AbstractInterstitialADListener abstractInterstitialADListener3;
        abstractInterstitialADListener = this.f19930e.f19909f;
        if (abstractInterstitialADListener != null) {
            abstractInterstitialADListener3 = this.f19930e.f19909f;
            abstractInterstitialADListener3.mo2691a();
        }
        if (StepDialog.f19904b != null) {
            i = this.f19930e.f19917n;
            if (i == 0) {
                StepDialog.m2672k(this.f19930e);
            }
        }
        this.f19926a.setImageBitmap(bitmap);
        ClickManager clickManager = new ClickManager(this.f19930e.getActivity(), this.f19926a, this.f19927b, this.f19928c);
        abstractInterstitialADListener2 = this.f19930e.f19909f;
        clickManager.f19932a = abstractInterstitialADListener2;
        clickManager.f19934c = this.f19929d;
        this.f19926a.setOnTouchListener(this.f19930e);
    }

    @Override // com.launch.p353a.p362i.ImageLoaderListener
    /* renamed from: a */
    public final void mo2647a(String str, String str2) {
        AbstractInterstitialADListener abstractInterstitialADListener;
        AbstractInterstitialADListener abstractInterstitialADListener2;
        abstractInterstitialADListener = this.f19930e.f19909f;
        if (abstractInterstitialADListener != null) {
            abstractInterstitialADListener2 = this.f19930e.f19909f;
            StepDialog.m2682b(abstractInterstitialADListener2);
        }
        Log.e("Response onError:", str2 + ":" + str);
    }
}
