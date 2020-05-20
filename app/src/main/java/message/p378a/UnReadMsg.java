package message.p378a;

import android.content.SharedPreferences;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.C1619q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.json.JSONObject;

/* renamed from: message.a.e */
/* loaded from: classes2.dex */
public class UnReadMsg extends C1619q {

    /* renamed from: g */
    public static String f23957g = "appid";

    /* renamed from: h */
    private Map<String, Integer> f23963h = new ConcurrentHashMap();

    /* renamed from: b */
    public Map<String, Integer> f23958b = new ConcurrentHashMap();

    /* renamed from: c */
    public Map<String, JSONObject> f23959c = new ConcurrentHashMap();

    /* renamed from: d */
    public String f23960d = "maintenance_msg_count";

    /* renamed from: i */
    private String f23964i = "chat_msg_count";

    /* renamed from: e */
    public String f23961e = "event_msg_count";

    /* renamed from: f */
    public SharedPreferences f23962f = ApplicationConfig.f7802a.getSharedPreferences("msg_count_file", 0);

    /* renamed from: a */
    public final void m303a(String str, Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(map);
        SharedPreferences.Editor edit = this.f23962f.edit();
        edit.putString(m304a(str), jSONObject.toString());
        edit.commit();
    }

    /* renamed from: a */
    public static String m304a(String str) {
        return ApplicationConfig.m9181a() + "_" + str;
    }

    /* renamed from: a */
    public final void m302a(String... strArr) {
        for (int i = 0; i <= 0; i++) {
            String str = strArr[0];
            if (this.f23963h.containsKey(str)) {
                this.f23963h.remove(str);
            }
        }
        m9126a(Opcodes.IFEQ, new Object[0]);
        m303a(this.f23964i, this.f23963h);
    }
}
