package com.launch.p353a.p358e;

import android.util.Log;
import com.launch.p353a.p362i.IHttpFinishedListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepDialog.java */
/* renamed from: com.launch.a.e.s */
/* loaded from: classes.dex */
public final class C3656s implements IHttpFinishedListener {

    /* renamed from: a */
    final /* synthetic */ StepDialog f19931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3656s(StepDialog stepDialog) {
        this.f19931a = stepDialog;
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2650a(Object obj) {
        AbstractInterstitialADListener abstractInterstitialADListener;
        AbstractInterstitialADListener unused;
        new StringBuilder("插屏displayevent").append(obj);
        abstractInterstitialADListener = this.f19931a.f19909f;
        if (abstractInterstitialADListener != null) {
            unused = this.f19931a.f19909f;
            Log.i("launch_ad_mob", "ON InterstitialAD Exposure");
        }
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2649a(String str, int i) {
        StringBuilder sb = new StringBuilder("插屏displayevent");
        sb.append(str);
        sb.append(i);
    }
}
