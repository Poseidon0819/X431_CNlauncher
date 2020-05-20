package message.p378a;

import android.text.TextUtils;

/* renamed from: message.a.d */
/* loaded from: classes2.dex */
public class ReportPushMsg extends BasePushMsg<String, Integer> {

    /* renamed from: e */
    private String f23956e = "status";

    public ReportPushMsg() {
        this.f23934c = "report";
    }

    /* renamed from: a */
    public final void m305a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (super.m310a() ? false : this.f23933b.containsKey(str)) {
            m309a((ReportPushMsg) str, (String) Integer.valueOf(((Integer) (super.m310a() ? null : this.f23933b.get(str))).intValue() + 1));
        } else {
            m309a((ReportPushMsg) str, (String) 1);
        }
        m308a(new Object[0]);
    }
}
