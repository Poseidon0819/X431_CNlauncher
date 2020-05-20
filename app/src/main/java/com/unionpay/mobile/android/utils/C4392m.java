package com.unionpay.mobile.android.utils;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.nocard.views.C4242l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.utils.m */
/* loaded from: classes2.dex */
public final class C4392m implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4391l f23196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4392m(C4391l c4391l) {
        this.f23196a = c4391l;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        AbstractC4219b abstractC4219b;
        AbstractC4219b abstractC4219b2;
        AbstractC4219b abstractC4219b3;
        switch (message2.what) {
            case 1:
                abstractC4219b = this.f23196a.f23193b;
                if (abstractC4219b == null) {
                    return true;
                }
                break;
            case 2:
                abstractC4219b3 = this.f23196a.f23193b;
                if (abstractC4219b3 == null) {
                    return true;
                }
                break;
            default:
                return true;
        }
        abstractC4219b2 = this.f23196a.f23193b;
        ((C4242l) abstractC4219b2).m1371r();
        return true;
    }
}
