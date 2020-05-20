package com.cnlaunch.x431pro.module.p242ad;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.x431pro.module.p242ad.AdUtil;
import com.itextpdf.text.Annotation;
import com.launch.p353a.p358e.AbstractInterstitialADListener;
import com.launch.p353a.p358e.InterstitialAD;
import com.launch.p353a.p358e.StepDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdUtil.java */
/* renamed from: com.cnlaunch.x431pro.module.ad.e */
/* loaded from: classes.dex */
public final class C2715e extends AbstractInterstitialADListener {

    /* renamed from: a */
    final /* synthetic */ InterstitialAD f15478a;

    /* renamed from: b */
    final /* synthetic */ Activity f15479b;

    /* renamed from: c */
    final /* synthetic */ AdUtil f15480c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2715e(AdUtil adUtil, InterstitialAD interstitialAD, Activity activity) {
        this.f15480c = adUtil;
        this.f15478a = interstitialAD;
        this.f15479b = activity;
    }

    @Override // com.launch.p353a.p358e.InterstitialADListener
    /* renamed from: a */
    public final void mo2691a() {
        AdUtil.m5428a("onADReceive()");
    }

    @Override // com.launch.p353a.p358e.InterstitialADListener
    /* renamed from: b */
    public final void mo2690b() {
        AdUtil.m5428a("onNoAD()");
        AdUtil.m5429a(this.f15480c);
    }

    @Override // com.launch.p353a.p358e.AbstractInterstitialADListener
    /* renamed from: d */
    public final void mo2698d() {
        AdUtil.m5429a(this.f15480c);
        AdUtil.m5428a("onADClosed()");
    }

    @Override // com.launch.p353a.p358e.AbstractInterstitialADListener
    /* renamed from: c */
    public final void mo2699c() {
        Log.i("launch_ad_mob", "ON InterstitialAD Clicked");
        StepDialog.m2689a().m2683b();
    }

    @Override // com.launch.p353a.p358e.AbstractInterstitialADListener
    /* renamed from: a */
    public final void mo2700a(String str, String str2) {
        AdUtil.InterfaceC2714a interfaceC2714a;
        AdUtil.InterfaceC2714a unused;
        Log.i("launch_ad_mob", "ON InterstitialAD Clicked");
        AdUtil.m5428a("InterstitialAD onADClickedByApp type=" + str + ",url=" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        switch (Integer.valueOf(str).intValue()) {
            case 2:
                StepDialog.m2689a().m2683b();
                Intent intent = new Intent(this.f15479b, ADShowActivity.class);
                intent.putExtra(Annotation.URL, str2);
                this.f15479b.startActivity(intent);
                return;
            case 3:
                if ("start_denso_ai_diag".equalsIgnoreCase(str2)) {
                    interfaceC2714a = this.f15480c.f15477c;
                    if (interfaceC2714a != null) {
                        unused = this.f15480c.f15477c;
                        return;
                    }
                    return;
                }
                return;
            case 4:
                this.f15479b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                StepDialog.m2689a().m2683b();
                return;
            default:
                return;
        }
    }
}
