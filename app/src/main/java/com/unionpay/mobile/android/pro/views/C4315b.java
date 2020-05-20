package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.hce.C4151a;
import com.unionpay.mobile.android.hce.C4153c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.b */
/* loaded from: classes2.dex */
public final class C4315b implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4307a f22927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4315b(C4307a c4307a) {
        this.f22927a = c4307a;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Handler handler;
        C4173b c4173b;
        C4153c c4153c;
        C4173b c4173b2;
        C4343a c4343a;
        C4173b c4173b3;
        C4173b c4173b4;
        int i = message2.what;
        if (i != 2004) {
            if (i != 2006) {
                return true;
            }
            C4307a c4307a = this.f22927a;
            c4173b4 = c4307a.f22590a;
            c4307a.mo1138a(c4173b4.f22441ap, false);
            return true;
        }
        handler = this.f22927a.f22901H;
        handler.removeMessages(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND);
        Bundle bundle = (Bundle) message2.obj;
        if (bundle != null) {
            if (!bundle.getBoolean(Constant.CASH_LOAD_SUCCESS)) {
                C4307a c4307a2 = this.f22927a;
                c4173b = c4307a2.f22590a;
                c4307a2.mo1138a(c4173b.f22441ap, false);
                return true;
            }
            String string = bundle.getString("result");
            c4153c = this.f22927a.f22896C;
            try {
                if (C4307a.m1186d(new JSONObject(C4151a.m1607a(string, c4153c.m1604f())))) {
                    C4307a c4307a3 = this.f22927a;
                    c4343a = c4307a3.f22913x;
                    C4307a.m1200a(c4307a3, c4343a.m1035a().f23028b, C4307a.m1182f(this.f22927a));
                    return true;
                }
                C4307a c4307a4 = this.f22927a;
                c4173b3 = c4307a4.f22590a;
                c4307a4.mo1138a(c4173b3.f22441ap, false);
                return false;
            } catch (Exception e) {
                C4307a c4307a5 = this.f22927a;
                c4173b2 = c4307a5.f22590a;
                c4307a5.mo1138a(c4173b2.f22441ap, false);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
