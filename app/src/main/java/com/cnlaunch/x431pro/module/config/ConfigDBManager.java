package com.cnlaunch.x431pro.module.config;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.config.p250b.ConfigUrl;
import com.cnlaunch.x431pro.module.config.p251db.ConfigDaoMaster;
import com.cnlaunch.x431pro.module.config.p251db.ConfigDaoSession;
import com.cnlaunch.x431pro.module.config.p251db.ConfigInfo;
import com.cnlaunch.x431pro.module.config.p251db.ConfigInfoDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.config.a */
/* loaded from: classes.dex */
public class ConfigDBManager {

    /* renamed from: e */
    private static ConfigDBManager f15511e;

    /* renamed from: a */
    public ConfigInfoDao f15512a;

    /* renamed from: c */
    private Context f15514c;

    /* renamed from: f */
    private ConfigDaoMaster f15516f;

    /* renamed from: g */
    private ConfigDaoSession f15517g;

    /* renamed from: b */
    private final String f15513b = ConfigDBManager.class.getSimpleName();

    /* renamed from: d */
    private String f15515d = "configCacheTime";

    /* renamed from: a */
    public static ConfigDBManager m5398a(Context context) {
        if (f15511e == null) {
            synchronized (ConfigDBManager.class) {
                if (f15511e == null) {
                    f15511e = new ConfigDBManager(context);
                }
            }
        }
        return f15511e;
    }

    private ConfigDBManager(Context context) {
        this.f15514c = context;
        this.f15516f = new ConfigDaoMaster(new ConfigDaoMaster.C2723a(context, "config.db").getWritableDatabase());
        this.f15517g = this.f15516f.newSession();
        this.f15512a = this.f15517g.f15525a;
    }

    /* renamed from: a */
    public final String m5396a(String str) throws C1425f {
        if (TextUtils.isEmpty(str)) {
            throw new C1425f("ConfigDBManager getUrlByKey key is not null.");
        }
        QueryBuilder<ConfigInfo> queryBuilder = this.f15512a.queryBuilder();
        queryBuilder.where(ConfigInfoDao.Properties.Key.m321eq(str), new WhereCondition[0]);
        List<ConfigInfo> list = queryBuilder.list();
        return !list.isEmpty() ? list.get(0).f15529c : "";
    }

    /* renamed from: a */
    public final synchronized void m5395a(List<ConfigUrl> list, String str, String str2) {
        NLog.m9456a("yhx", "insertOrUpdateConfig enter");
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.f15517g.runInTx(new RunnableC2722b(this, list, str2, str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
