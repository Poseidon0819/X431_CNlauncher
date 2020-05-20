package com.unionpay;

import com.unionpay.tsmservice.data.Constant;

/* renamed from: com.unionpay.u */
/* loaded from: classes2.dex */
final class C4642u implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4642u(UPPayWapActivity uPPayWapActivity) {
        this.f23750a = uPPayWapActivity;
    }

    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    public final void mo430a(String str, InterfaceC4125ad interfaceC4125ad) {
        String m1646b;
        Boolean.parseBoolean(str);
        this.f23750a.f22032a.setVisibility(r1 ? 0 : 8);
        if (interfaceC4125ad != null) {
            m1646b = UPPayWapActivity.m1646b("0", Constant.CASH_LOAD_SUCCESS, null);
            interfaceC4125ad.mo429a(m1646b);
        }
    }
}
