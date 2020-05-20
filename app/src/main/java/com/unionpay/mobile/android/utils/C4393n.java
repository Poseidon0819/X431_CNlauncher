package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.net.C4180c;
import com.unionpay.mobile.android.net.C4181d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.utils.n */
/* loaded from: classes2.dex */
public final class C4393n extends UPPayEngine implements InterfaceC4148a {

    /* renamed from: b */
    private Context f23197b;

    public C4393n(Context context) {
        super(context);
        this.f23197b = context;
    }

    @Override // com.unionpay.mobile.android.nocard.utils.UPPayEngine, com.unionpay.mobile.android.fully.InterfaceC4148a
    /* renamed from: a */
    public final String mo833a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("reqtm", m1495i());
            str = jSONObject.toString();
        } catch (JSONException unused) {
        }
        C4390k.m836c("uppay", "post message = ".concat(String.valueOf(str)));
        String e = m1502e(str);
        C4181d d = m1505d();
        if (d != null) {
            try {
                d.m1524a(e);
                HashMap<String, String> hashMap = new HashMap<>(1);
                hashMap.put("sid", m1501f());
                d.m1523a(hashMap);
                m1499g();
                if (this.f22509a == null) {
                    this.f22509a = new C4180c(d, this.f23197b);
                }
                int m1529a = this.f22509a.m1529a();
                String m1527c = this.f22509a.m1527c();
                if (m1529a == 0) {
                    String f = m1500f(m1527c);
                    C4390k.m838a("uppay", "[ response msg ] ".concat(String.valueOf(f)));
                    return f;
                }
                Handler e2 = m1503e();
                if (e2 != null) {
                    Message obtainMessage = e2.obtainMessage(2);
                    obtainMessage.arg1 = m1529a;
                    e2.sendMessage(obtainMessage);
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }
}
