package com.unionpay.mobile.android.utils;

import android.os.Handler;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import org.simalliance.openmobileapi.SEService;

/* renamed from: com.unionpay.mobile.android.utils.l */
/* loaded from: classes2.dex */
public final class C4391l implements SEService.CallBack {

    /* renamed from: a */
    private static SEService f23192a;

    /* renamed from: b */
    private AbstractC4219b f23193b;

    /* renamed from: c */
    private Handler.Callback f23194c = new C4392m(this);

    /* renamed from: d */
    private Handler f23195d = new Handler(this.f23194c);

    /* renamed from: a */
    public static SEService m835a() {
        return f23192a;
    }

    public final void serviceConnected(SEService sEService) {
        C4390k.m836c("uppay", "se service connected");
        C4390k.m836c("uppay", "mSEService:" + f23192a);
        C4390k.m836c("uppay", "mSEService.isConnected:" + f23192a.isConnected());
        this.f23195d.sendEmptyMessage(1);
    }
}
