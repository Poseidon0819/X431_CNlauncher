package com.cnlaunch.x431pro.module.config.p249a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p167h.C1673a;
import com.cnlaunch.x431pro.module.config.p250b.ConfigRespose;
import com.cnlaunch.x431pro.module.config.p250b.GetIpAreaResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.utils.C2744aa;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.config.a.a */
/* loaded from: classes.dex */
public class ConfigAction extends BaseAction {

    /* renamed from: s */
    private final String f15518s;

    public ConfigAction(Context context) {
        super(context);
        this.f15518s = ConfigAction.class.getSimpleName();
    }

    /* renamed from: a */
    public final GetIpAreaResponse m5392a(String str) throws C1425f {
        try {
            this.f15440b = new C1426i();
            this.f15440b.m9506a("ip", str);
            String m9477a = this.f15446f.m9477a("http://ip.taobao.com/service/getIpInfo.php", this.f15440b);
            if (TextUtils.isEmpty(m9477a)) {
                return null;
            }
            return (GetIpAreaResponse) m5438a(m9477a, GetIpAreaResponse.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final ConfigRespose m5391a(String str, String str2) throws C1425f {
        if (TextUtils.isEmpty(str)) {
            throw new C1425f("getConfigService url is not null.");
        }
        this.f15440b = m5452b();
        this.f15440b.m9506a("config_no", str2);
        String m9477a = this.f15446f.m9477a(str, this.f15440b);
        Log.d("Config", "---->配置下发地址请求:".concat(String.valueOf(m9477a)));
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        return (ConfigRespose) m5438a(m9477a, ConfigRespose.class);
    }

    /* renamed from: a */
    public final String m5393a() {
        String str = "";
        try {
            String m9477a = this.f15446f.m9477a("http://pv.sohu.com/cityjson?ie=utf-8", null);
            if (!TextUtils.isEmpty(m9477a)) {
                int indexOf = m9477a.indexOf("{");
                int indexOf2 = m9477a.indexOf("}");
                if (indexOf != -1 && indexOf2 != -1) {
                    String substring = m9477a.substring(indexOf, indexOf2 + 1);
                    NLog.m9451c("Sanda", "sohujsonStr=".concat(String.valueOf(substring)));
                    C1673a.m8965a().m8964a("SOHU:".concat(String.valueOf(substring)));
                    str = new JSONObject(substring).getString("cip");
                }
                str = "";
            }
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        } catch (Exception unused) {
            str = "";
        }
        if (C2744aa.m5169b(str)) {
            return str;
        }
        try {
            String m9477a2 = this.f15446f.m9477a("http://city.ip138.com/ip2city.asp", null);
            if (!TextUtils.isEmpty(m9477a2)) {
                int indexOf3 = m9477a2.indexOf("[");
                int indexOf4 = m9477a2.indexOf("]");
                String replace = m9477a2.replace("[", "").replace("]", "");
                str = replace.substring(indexOf3, indexOf4).trim();
                NLog.m9451c("Sanda", "city.ip138 ip : ".concat(String.valueOf(str)));
                C1673a.m8965a().m8964a("IP138:".concat(String.valueOf(replace)));
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (C2744aa.m5169b(str)) {
            return str;
        }
        try {
            String m9477a3 = this.f15446f.m9477a("http://20140507.ip138.com/ic.asp", null);
            if (TextUtils.isEmpty(m9477a3)) {
                return str;
            }
            int indexOf5 = m9477a3.indexOf("[");
            int indexOf6 = m9477a3.indexOf("]");
            if (indexOf5 != -1 && indexOf6 != -1) {
                String replace2 = m9477a3.replace("[", "").replace("]", "");
                String trim = replace2.substring(indexOf5, indexOf6).trim();
                NLog.m9451c("Sanda", "ip : ".concat(String.valueOf(trim)));
                C1673a.m8965a().m8964a("IP138:".concat(String.valueOf(replace2)));
                return trim;
            }
            return "";
        } catch (Exception unused3) {
            return "";
        }
    }
}
