package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;

/* renamed from: com.unionpay.t */
/* loaded from: classes2.dex */
final class C4493t implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4493t(UPPayWapActivity uPPayWapActivity) {
        this.f23520a = uPPayWapActivity;
    }

    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    public final void mo430a(String str, InterfaceC4125ad interfaceC4125ad) {
        String m1646b;
        UPUtils.m469b(this.f23520a, str);
        if (interfaceC4125ad != null) {
            m1646b = UPPayWapActivity.m1646b("0", Constant.CASH_LOAD_SUCCESS, null);
            interfaceC4125ad.mo429a(m1646b);
        }
    }
}
