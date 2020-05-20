package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.unionpay.r */
/* loaded from: classes2.dex */
final class C4491r implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23518a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4491r(UPPayWapActivity uPPayWapActivity) {
        this.f23518a = uPPayWapActivity;
    }

    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    public final void mo430a(String str, InterfaceC4125ad interfaceC4125ad) {
        String m1646b;
        String m1646b2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                UPUtils.m472a(this.f23518a, jSONObject.getString(next), next);
            }
            if (interfaceC4125ad != null) {
                m1646b2 = UPPayWapActivity.m1646b("0", Constant.CASH_LOAD_SUCCESS, null);
                interfaceC4125ad.mo429a(m1646b2);
            }
        } catch (Exception e) {
            if (interfaceC4125ad != null) {
                m1646b = UPPayWapActivity.m1646b("1", e.getMessage(), null);
                interfaceC4125ad.mo429a(m1646b);
            }
        }
    }
}
