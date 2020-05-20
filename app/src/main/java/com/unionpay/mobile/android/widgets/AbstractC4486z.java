package com.unionpay.mobile.android.widgets;

import android.content.Context;
import com.unionpay.mobile.android.widgets.AbstractC4453ba;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.z */
/* loaded from: classes2.dex */
public abstract class AbstractC4486z extends AbstractC4453ba implements AbstractC4453ba.InterfaceC4454a {
    public AbstractC4486z(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo582a(String str) {
        return super.mo582a(str);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo581f() {
        return super.mo581f();
    }

    /* renamed from: h */
    public String mo580h() {
        StringBuffer stringBuffer = new StringBuffer();
        if (m674n() != null && mo585a() != null) {
            stringBuffer.append("\"");
            stringBuffer.append(m674n());
            stringBuffer.append("\":");
            stringBuffer.append("\"");
            stringBuffer.append(mo585a());
            stringBuffer.append("\"");
        }
        return stringBuffer.toString();
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: i */
    public final /* bridge */ /* synthetic */ String mo579i() {
        return super.mo579i();
    }
}
