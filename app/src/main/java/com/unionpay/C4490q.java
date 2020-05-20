package com.unionpay;

import android.content.Context;
import com.unionpay.tsmservice.data.Constant;

/* renamed from: com.unionpay.q */
/* loaded from: classes2.dex */
final class C4490q implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23517a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4490q(UPPayWapActivity uPPayWapActivity) {
        this.f23517a = uPPayWapActivity;
    }

    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    public final void mo430a(String str, InterfaceC4125ad interfaceC4125ad) {
        String m1646b;
        String m1682a = UPPayAssistEx.m1682a((Context) this.f23517a, true);
        if (interfaceC4125ad != null) {
            m1646b = UPPayWapActivity.m1646b("0", Constant.CASH_LOAD_SUCCESS, m1682a);
            interfaceC4125ad.mo429a(m1646b);
        }
    }
}
