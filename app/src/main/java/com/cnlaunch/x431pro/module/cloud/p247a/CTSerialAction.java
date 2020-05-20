package com.cnlaunch.x431pro.module.cloud.p247a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.cloud.model.AutoCode;
import com.cnlaunch.x431pro.module.cloud.model.AutoCodeResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.utils.C2786y;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jivesoftware.smackx.packet.MultipleAddresses;

/* renamed from: com.cnlaunch.x431pro.module.cloud.a.a */
/* loaded from: classes.dex */
public final class CTSerialAction extends BaseAction {
    public CTSerialAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final AutoCode m5424a(String str) throws C1425f {
        AutoCodeResponse autoCodeResponse;
        String b = m5451b(KeyConstant.f6894bo);
        NLog.m9452b("XEE", "getAutoCodeByVin 是否有配置下发 url:".concat(String.valueOf(b)));
        if (TextUtils.isEmpty(b)) {
            b = "http://mycar.x431.com/rest/ct/ctSystem/getAutoCodeByVin.json?";
        }
        C1426i c1426i = new C1426i();
        HashMap hashMap = new HashMap();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        hashMap.put("app_id", "6021");
        hashMap.put("ver", "5.3.0");
        hashMap.put("vin", str);
        hashMap.put("cvn", "");
        hashMap.put(VastExtensionXmlManager.TYPE, "2");
        String m4822a = C2786y.m4822a(m9591a2, hashMap);
        c1426i.m9506a("app_id", "6021");
        c1426i.m9506a("ver", "5.3.0");
        c1426i.m9506a("vin", str);
        c1426i.m9506a(VastExtensionXmlManager.TYPE, "2");
        c1426i.m9506a("cvn", "".replace("%", "%25").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "%20").replace("+", "%2B").replace("/", " %2F").replace("?", "%3F").replace("#", "%23").replace("&", "%26").replace("=", "%3D"));
        c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        c1426i.m9506a("sign", m4822a);
        String m9477a = this.f15446f.m9477a(b, c1426i);
        if (TextUtils.isEmpty(m9477a) || (autoCodeResponse = (AutoCodeResponse) m5438a(m9477a, AutoCodeResponse.class)) == null) {
            return null;
        }
        return autoCodeResponse.getCtAutoCodeResult();
    }
}
