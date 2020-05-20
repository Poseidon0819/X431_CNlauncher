package com.launch.p353a.p359f;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.launch.p353a.p355b.AbstractBannerADListener;
import com.launch.p353a.p358e.AbstractInterstitialADListener;
import com.launch.p353a.p360g.NativeExpressADListener;
import com.launch.p353a.p362i.IHttpFinishedListener;
import com.launch.p353a.p363j.SplashADListener;

/* compiled from: ClickManager.java */
/* renamed from: com.launch.a.f.b */
/* loaded from: classes.dex */
final class C3657b implements IHttpFinishedListener {

    /* renamed from: a */
    final /* synthetic */ ClickManager f19945a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3657b(ClickManager clickManager) {
        this.f19945a = clickManager;
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2650a(Object obj) {
        SplashADListener splashADListener;
        AbstractInterstitialADListener abstractInterstitialADListener;
        AbstractBannerADListener abstractBannerADListener;
        NativeExpressADListener nativeExpressADListener;
        String str;
        String str2;
        AbstractInterstitialADListener abstractInterstitialADListener2;
        String str3;
        String str4;
        AbstractInterstitialADListener abstractInterstitialADListener3;
        Handler handler;
        String str5;
        SplashADListener unused;
        SplashADListener unused2;
        String unused3;
        String unused4;
        AbstractBannerADListener unused5;
        AbstractBannerADListener unused6;
        String unused7;
        String unused8;
        NativeExpressADListener unused9;
        View unused10;
        new StringBuilder("clickevent===").append(obj);
        splashADListener = this.f19945a.f19937f;
        if (splashADListener != null) {
            handler = this.f19945a.f19944m;
            handler.sendEmptyMessage(0);
            str5 = this.f19945a.f19934c;
            if (str5.equals("01")) {
                unused = this.f19945a.f19937f;
            } else {
                unused2 = this.f19945a.f19937f;
                unused3 = this.f19945a.f19934c;
                unused4 = this.f19945a.f19940i;
            }
        }
        abstractInterstitialADListener = this.f19945a.f19932a;
        if (abstractInterstitialADListener != null) {
            str2 = this.f19945a.f19934c;
            if (str2.equals("01")) {
                abstractInterstitialADListener3 = this.f19945a.f19932a;
                abstractInterstitialADListener3.mo2699c();
            } else {
                abstractInterstitialADListener2 = this.f19945a.f19932a;
                str3 = this.f19945a.f19934c;
                str4 = this.f19945a.f19940i;
                abstractInterstitialADListener2.mo2700a(str3, str4);
            }
        }
        abstractBannerADListener = this.f19945a.f19943l;
        if (abstractBannerADListener != null) {
            str = this.f19945a.f19934c;
            if (str.equals("01")) {
                unused5 = this.f19945a.f19943l;
                Log.i("launch_ad_mob", "On BannerAD Clicked");
            } else {
                unused6 = this.f19945a.f19943l;
                unused7 = this.f19945a.f19934c;
                unused8 = this.f19945a.f19940i;
                Log.i("launch_ad_mob", "On BannerAD onADClickedByApp");
            }
        }
        nativeExpressADListener = this.f19945a.f19933b;
        if (nativeExpressADListener != null) {
            unused9 = this.f19945a.f19933b;
            unused10 = this.f19945a.f19938g;
        }
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2649a(String str, int i) {
        StringBuilder sb = new StringBuilder("clickevent===");
        sb.append(str);
        sb.append(i);
    }
}
