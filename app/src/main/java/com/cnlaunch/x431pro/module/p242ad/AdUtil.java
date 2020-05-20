package com.cnlaunch.x431pro.module.p242ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.launch.p353a.p358e.InterstitialAD;
import com.launch.p353a.p364k.LUAsdk;

/* renamed from: com.cnlaunch.x431pro.module.ad.d */
/* loaded from: classes.dex */
public final class AdUtil {

    /* renamed from: b */
    private static AdUtil f15475b;

    /* renamed from: a */
    boolean f15476a = false;

    /* renamed from: c */
    private InterfaceC2714a f15477c;

    /* compiled from: AdUtil.java */
    /* renamed from: com.cnlaunch.x431pro.module.ad.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2714a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m5429a(AdUtil adUtil) {
        adUtil.f15476a = false;
        return false;
    }

    /* renamed from: a */
    public static AdUtil m5431a() {
        if (f15475b == null) {
            f15475b = new AdUtil();
        }
        return f15475b;
    }

    /* renamed from: a */
    public static void m5428a(String str) {
        Log.e("lx", "AdUtil---".concat(String.valueOf(str)));
    }

    /* renamed from: a */
    public final void m5430a(Activity activity) {
        if (this.f15476a || TextUtils.isEmpty(LUAsdk.m2640a())) {
            return;
        }
        String m9584b = PreferencesManager.m9595a((Context) activity).m9584b("jiuzhang_interstitial_id", "");
        if (TextUtils.isEmpty(m9584b)) {
            return;
        }
        m5428a("showAd()");
        InterstitialAD interstitialAD = new InterstitialAD(activity, m9584b);
        this.f15476a = true;
        interstitialAD.f19887a = new C2715e(this, interstitialAD, activity);
    }
}
