package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.config.p249a.ConfigAction;
import com.cnlaunch.x431pro.module.config.p250b.ConfigData;
import com.cnlaunch.x431pro.module.config.p250b.ConfigRespose;
import com.cnlaunch.x431pro.module.config.p250b.ConfigUrl;
import com.cnlaunch.x431pro.utils.C2744aa;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.a.g */
/* loaded from: classes.dex */
public final class ConfigUtils implements OnDataListener {

    /* renamed from: a */
    public static ConfigUtils f10546a;

    /* renamed from: b */
    private int f10547b = 0;

    /* renamed from: c */
    private Context f10548c;

    /* renamed from: d */
    private AsyncTaskManager f10549d;

    /* renamed from: a */
    public static synchronized ConfigUtils m7963a(Context context) {
        ConfigUtils configUtils;
        synchronized (ConfigUtils.class) {
            if (f10546a == null) {
                f10546a = new ConfigUtils(context);
            }
            configUtils = f10546a;
        }
        return configUtils;
    }

    private ConfigUtils(Context context) {
        this.f10548c = context;
        this.f10549d = AsyncTaskManager.m9574a(this.f10548c);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 1000001) {
            return null;
        }
        String str = PreferencesManager.m9595a(this.f10548c).m9583b("isRelease", true) ? "https://config.dbscar.com/?action=config_service.urls" : "http://golo.test.x431.com/dev/?action=config_service.urls";
        String m9584b = PreferencesManager.m9595a(this.f10548c).m9584b("config_no", "0");
        NLog.m9456a("yhx", "url=" + str + ",configNo=" + m9584b);
        return new ConfigAction(this.f10548c).m5391a(str, m9584b);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        ConfigData data;
        String str;
        if (i != 1000001) {
            return;
        }
        if (obj != null) {
            ConfigRespose configRespose = (ConfigRespose) obj;
            if (configRespose == null || !configRespose.isSuccess() || (data = configRespose.getData()) == null) {
                return;
            }
            List<ConfigUrl> urls = data.getUrls();
            String version = data.getVersion();
            String area = data.getArea();
            if (!TextUtils.isEmpty(area) && area.equals("1")) {
                str = "CN";
                ApplicationConfig.f7815n = false;
                ApplicationConfig.f7814m = "151";
            } else {
                ApplicationConfig.f7815n = true;
                ApplicationConfig.f7814m = "1522";
                str = "US";
            }
            ConfigDBManager.m5398a(this.f10548c).m5395a(urls, version, str);
            return;
        }
        int i2 = this.f10547b;
        if (i2 < 2) {
            this.f10547b = i2 + 1;
            m7962b();
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        int i3;
        if (i == 1000001 && (i3 = this.f10547b) < 2) {
            this.f10547b = i3 + 1;
            m7962b();
        }
    }

    /* renamed from: b */
    private void m7962b() {
        this.f10549d.m9575a(1000001, true, this);
    }

    /* renamed from: c */
    private synchronized void m7961c() {
        NLog.m9456a("yhx", "updateConfigInfo enter.");
        this.f10547b = 0;
        m7962b();
    }

    /* renamed from: a */
    public final synchronized void m7964a() {
        long m9586b = PreferencesManager.m9595a(this.f10548c).m9586b("configCacheTime");
        boolean z = true;
        NLog.m9456a("yhx", "checkLatestConfigInfo enter.lastUpdateTime=".concat(String.valueOf(m9586b)));
        if (ConfigDBManager.m5398a(this.f10548c).f15512a.count() != 0) {
            z = false;
        }
        if (z || C2744aa.m5174b(m9586b)) {
            m7961c();
        }
    }
}
