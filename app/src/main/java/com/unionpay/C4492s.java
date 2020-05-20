package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;

/* renamed from: com.unionpay.s */
/* loaded from: classes2.dex */
final class C4492s implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4492s(UPPayWapActivity uPPayWapActivity) {
        this.f23519a = uPPayWapActivity;
    }

    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    public final void mo430a(String str, InterfaceC4125ad interfaceC4125ad) {
        String m1646b;
        String m473a = UPUtils.m473a(this.f23519a, str);
        if (interfaceC4125ad != null) {
            m1646b = UPPayWapActivity.m1646b("0", Constant.CASH_LOAD_SUCCESS, m473a);
            interfaceC4125ad.mo429a(m1646b);
        }
    }
}
