package com.cnlaunch.x431pro.module.config;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.config.p250b.ConfigUrl;
import com.cnlaunch.x431pro.module.config.p251db.ConfigInfo;
import com.cnlaunch.x431pro.module.config.p251db.ConfigInfoDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConfigDBManager.java */
/* renamed from: com.cnlaunch.x431pro.module.config.b */
/* loaded from: classes.dex */
public final class RunnableC2722b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f15519a;

    /* renamed from: b */
    final /* synthetic */ String f15520b;

    /* renamed from: c */
    final /* synthetic */ String f15521c;

    /* renamed from: d */
    final /* synthetic */ ConfigDBManager f15522d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2722b(ConfigDBManager configDBManager, List list, String str, String str2) {
        this.f15522d = configDBManager;
        this.f15519a = list;
        this.f15520b = str;
        this.f15521c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        ConfigInfoDao configInfoDao;
        ConfigInfoDao configInfoDao2;
        ConfigInfoDao configInfoDao3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ConfigUrl configUrl : this.f15519a) {
            configInfoDao3 = this.f15522d.f15512a;
            QueryBuilder<ConfigInfo> queryBuilder = configInfoDao3.queryBuilder();
            queryBuilder.where(ConfigInfoDao.Properties.Key.m321eq(configUrl.getKey()), new WhereCondition[0]);
            List<ConfigInfo> list = queryBuilder.list();
            if (!list.isEmpty()) {
                ConfigInfo configInfo = list.get(0);
                configInfo.f15528b = configUrl.getKey();
                configInfo.f15529c = configUrl.getValue();
                arrayList.add(configInfo);
            } else {
                ConfigInfo configInfo2 = new ConfigInfo();
                configInfo2.f15528b = configUrl.getKey();
                configInfo2.f15529c = configUrl.getValue();
                arrayList2.add(configInfo2);
            }
        }
        if (!arrayList.isEmpty()) {
            configInfoDao2 = this.f15522d.f15512a;
            configInfoDao2.updateInTx(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            configInfoDao = this.f15522d.f15512a;
            configInfoDao.insertInTx(arrayList2);
        }
        context = this.f15522d.f15514c;
        PreferencesManager.m9595a(context).m9589a("configCacheTime", System.currentTimeMillis());
        context2 = this.f15522d.f15514c;
        PreferencesManager.m9595a(context2).m9588a("current_country", this.f15520b);
        context3 = this.f15522d.f15514c;
        PreferencesManager.m9595a(context3).m9588a("config_no", this.f15521c);
        NLog.m9456a("yhx", "insertOrUpdateConfig OK!");
    }
}
