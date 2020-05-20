package message.p378a;

import android.content.Context;
import android.content.SharedPreferences;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.C1619q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: message.a.a */
/* loaded from: classes2.dex */
public class BasePushMsg<K, V> extends C1619q {

    /* renamed from: c */
    protected String f23934c;

    /* renamed from: b */
    Map<K, V> f23933b = new HashMap();

    /* renamed from: d */
    protected String f23935d = "push";

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m309a(K k, V v) {
        if (this.f23933b == null) {
            this.f23933b = new HashMap();
        }
        this.f23933b.put(k, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m310a() {
        Map<K, V> map = this.f23933b;
        return map == null || map.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m308a(Object... objArr) {
        JSONObject jSONObject = new JSONObject(this.f23933b);
        Context context = ApplicationConfig.f7802a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f23935d + "_" + ApplicationConfig.m9181a(), 0).edit();
        edit.putString(this.f23934c, jSONObject.toString());
        edit.commit();
        m9126a(1, objArr);
    }
}
