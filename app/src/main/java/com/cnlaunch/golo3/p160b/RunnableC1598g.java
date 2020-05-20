package com.cnlaunch.golo3.p160b;

import android.text.TextUtils;
import com.cnlaunch.golo3.p162d.InterfaceTable;
import com.cnlaunch.golo3.p164f.JSONMsg;
import com.p099c.p100a.p103c.ResponseInfo;
import org.json.JSONObject;

/* compiled from: InterfaceDao.java */
/* renamed from: com.cnlaunch.golo3.b.g */
/* loaded from: classes.dex */
final class RunnableC1598g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ResponseInfo f8403a;

    /* renamed from: b */
    final /* synthetic */ C1597f f8404b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1598g(C1597f c1597f, ResponseInfo responseInfo) {
        this.f8404b = c1597f;
        this.f8403a = responseInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceTable interfaceTable;
        InterfaceTable interfaceTable2;
        InterfaceTable interfaceTable3;
        JSONObject jSONObject;
        JSONMsg jSONMsg = new JSONMsg();
        try {
            jSONMsg.m9156a(new JSONObject((String) this.f8403a.f6665a));
            if (jSONMsg.f8441a == 0 && (jSONObject = jSONMsg.f8443c) != null) {
                InterfaceDao.m9173a(this.f8404b.f8402d, jSONObject, this.f8404b.f8399a);
            }
            if (!TextUtils.isEmpty(this.f8404b.f8400b)) {
                interfaceTable = this.f8404b.f8402d.f8398a;
                String m9166a = interfaceTable.m9166a(this.f8404b.f8400b);
                if (TextUtils.isEmpty(m9166a)) {
                    ApplicationConfig.f7805d.post(new RunnableC1599h(this));
                    return;
                }
                StringBuilder sb = new StringBuilder(m9166a);
                if (this.f8404b.f8400b.equals(InterfaceConfig.f7853Y)) {
                    interfaceTable2 = this.f8404b.f8402d.f8398a;
                    String m9166a2 = interfaceTable2.m9166a(InterfaceConfig.f7908b);
                    sb.append(",");
                    if (TextUtils.isEmpty(m9166a2)) {
                        m9166a2 = "";
                    }
                    sb.append(m9166a2);
                    interfaceTable3 = this.f8404b.f8402d.f8398a;
                    String m9166a3 = interfaceTable3.m9166a(InterfaceConfig.f7961c);
                    sb.append(",");
                    if (TextUtils.isEmpty(m9166a3)) {
                        m9166a3 = "";
                    }
                    sb.append(m9166a3);
                }
                ApplicationConfig.f7805d.post(new RunnableC1600i(this, sb));
                return;
            }
            ApplicationConfig.f7805d.post(new RunnableC1601j(this));
        } catch (Exception unused) {
            ApplicationConfig.f7805d.post(new RunnableC1602k(this));
        }
    }
}
