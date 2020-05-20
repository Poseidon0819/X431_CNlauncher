package com.cnlaunch.x431pro.module.p241a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p263h.p265b.FormFile;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.io.File;
import java.util.Map;
import org.jivesoftware.smackx.packet.MultipleAddresses;
import org.p388a.p389a.SoapObject;
import org.p393b.p395b.C4920a;

/* renamed from: com.cnlaunch.x431pro.module.a.a */
/* loaded from: classes.dex */
public class BaseAction extends BusinessManager {

    /* renamed from: a */
    protected Context f15439a;

    /* renamed from: b */
    protected C1426i f15440b;

    /* renamed from: c */
    protected ConfigDBManager f15441c;

    /* renamed from: d */
    protected SoapObjectParams f15442d;

    /* renamed from: s */
    private final String f15443s;

    public BaseAction(Context context) {
        super(context);
        this.f15443s = BaseAction.class.getSimpleName();
        this.f15439a = context;
        this.f15441c = ConfigDBManager.m5398a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final String m5451b(String str) throws C1425f {
        return this.f15441c.m5396a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static C1426i m5452b() {
        C1426i c1426i = new C1426i();
        c1426i.m9506a("app_id", "6021");
        return c1426i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final String m5455a(String str, C1426i c1426i) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i2 = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("BaseManager getSignUrl method IllegalArgumentException.");
        }
        if (c1426i == null) {
            c1426i = new C1426i();
        }
        c1426i.m9506a("app_id", "6021");
        c1426i.m9506a("action", m5449c(str));
        c1426i.m9506a("user_id", m9591a);
        c1426i.m9506a("ver", "5.3.0");
        c1426i2.m9506a("sign", MD5Utils.m9460a(c1426i.m9505b() + m9591a2));
        c1426i2.m9506a("user_id", m9591a);
        c1426i2.m9506a("app_id", "6021");
        c1426i2.m9506a("ver", "5.3.0");
        sb.append("&");
        sb.append(c1426i2.m9505b());
        c1426i.m9504b("app_id");
        c1426i.m9504b("action");
        c1426i.m9504b("ver");
        c1426i.m9504b("user_id");
        String sb2 = sb.toString();
        NLog.m9456a("Action", "Url=".concat(String.valueOf(sb2)));
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final String m5450b(String str, C1426i c1426i) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i2 = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("BaseManager getSignUrl method IllegalArgumentException.");
        }
        c1426i.m9506a("app_id", "6021");
        c1426i.m9506a("action", m5449c(str));
        c1426i.m9506a("user_id", m9591a);
        c1426i.m9506a("ver", "5.3.0");
        c1426i2.m9506a("sign", MD5Utils.m9460a(c1426i.m9505b() + m9591a2));
        c1426i2.m9506a("user_id", m9591a);
        c1426i2.m9506a("app_id", "6021");
        c1426i2.m9506a("ver", "5.3.0");
        sb.append("&");
        sb.append(c1426i2.m9505b());
        c1426i.m9504b("action");
        c1426i.m9504b("ver");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final String m5449c(String str) {
        String[] split;
        String str2 = "";
        if (!TextUtils.isEmpty(str) && (split = str.split("action=")) != null && split.length >= 2) {
            str2 = split[1];
        }
        NLog.m9451c(this.f15443s, "getAction: ".concat(String.valueOf(str2)));
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public static SoapObjectParams m5447d(String str) {
        return new SoapObjectParams("http://www.x431.com", str);
    }

    /* renamed from: e */
    public static String m5445e(String str) {
        File file = new File(str);
        return MD5Utils.m9460a(file.getName().split("\\.")[0] + "dbh23foup88lo56ad7865log46ke89y");
    }

    /* renamed from: a */
    public final String m5454a(String str, Map<String, String> map, String str2) throws C1425f {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            NLog.m9456a(this.f15443s, "执行上传文件任务");
            File file = new File(str2);
            FormFile formFile = new FormFile(file.getName(), file, "attach", "application/octet-stream");
            String str3 = this.f15443s;
            NLog.m9456a(str3, "requestUrl==" + str + "params=" + map.toString() + formFile.toString());
            return FileUtils.m5011a(str, map, formFile);
        } catch (Exception e) {
            e.printStackTrace();
            NLog.m9456a(this.f15443s, "上传文件出现异常");
            throw new C1425f("Upload the log file to server error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final String m5448c(String str, C1426i c1426i) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i2 = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("BaseManager getSignUrl method IllegalArgumentException.");
        }
        c1426i.m9506a("app_id", C2744aa.m5136l(this.f15439a));
        c1426i.m9506a("action", m5449c(str));
        c1426i.m9506a("user_id", m9591a);
        c1426i.m9506a("ver", "5.3.0");
        c1426i2.m9506a("sign", MD5Utils.m9460a(c1426i.m9505b() + m9591a2));
        c1426i2.m9506a("user_id", m9591a);
        c1426i2.m9506a("app_id", C2744aa.m5136l(this.f15439a));
        c1426i2.m9506a("ver", "5.3.0");
        sb.append("&");
        sb.append(c1426i2.m9505b());
        c1426i.m9504b("app_id");
        c1426i.m9504b("action");
        c1426i.m9504b("ver");
        c1426i.m9504b("user_id");
        String sb2 = sb.toString();
        NLog.m9456a("Action", "Url=".concat(String.valueOf(sb2)));
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final String m5446d(String str, C1426i c1426i) throws C1425f {
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i2 = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (TextUtils.isEmpty(m9591a) || TextUtils.isEmpty(m9591a2)) {
            throw new C1425f("BaseManager getSignUrl method IllegalArgumentException.");
        }
        c1426i.m9506a("app_id", C2744aa.m5136l(this.f15439a));
        c1426i.m9506a("action", m5449c(str));
        c1426i.m9506a("user_id", m9591a);
        c1426i.m9506a("ver", "5.3.0");
        c1426i2.m9506a("sign", MD5Utils.m9460a(c1426i.m9505b() + m9591a2));
        c1426i2.m9506a("lan", LangManager.m9469a());
        c1426i2.m9506a("app_id", C2744aa.m5136l(this.f15439a));
        c1426i2.m9506a("ver", "5.3.0");
        sb.append("&");
        sb.append(c1426i2.m9505b());
        c1426i.m9504b("app_id");
        c1426i.m9504b("action");
        c1426i.m9504b("ver");
        c1426i.m9504b("user_id");
        String sb2 = sb.toString();
        NLog.m9456a("Action", "Url=".concat(String.valueOf(sb2)));
        return sb2;
    }

    /* renamed from: a */
    public final C4920a[] m5453a(SoapObject soapObject) {
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        C4920a[] c4920aArr = {new C4920a().mo99a("http://www.x431.com", "authenticate")};
        C4920a mo99a = new C4920a().mo99a("http://www.x431.com", MultipleAddresses.f24412CC);
        mo99a.m100a(4, m9591a);
        c4920aArr[0].m100a(2, mo99a);
        StringBuilder sb = new StringBuilder();
        if (soapObject != null) {
            int mo173a = soapObject.mo173a();
            for (int i = 0; i < mo173a; i++) {
                sb.append(String.valueOf(soapObject.mo172a(i)));
            }
        }
        sb.append(m9591a2);
        NLog.m9451c(this.f15443s, "sign: ".concat(String.valueOf(sb)));
        C4920a mo99a2 = new C4920a().mo99a("http://www.x431.com", "sign");
        mo99a2.m100a(4, MD5Utils.m9460a(sb.toString()));
        c4920aArr[0].m100a(2, mo99a2);
        return c4920aArr;
    }
}
