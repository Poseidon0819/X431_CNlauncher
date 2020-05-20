package com.cnlaunch.x431pro.module.config.p251db;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.module.config.db.b */
/* loaded from: classes.dex */
public final class ConfigDaoSession extends AbstractDaoSession {

    /* renamed from: a */
    public final ConfigInfoDao f15525a;

    /* renamed from: b */
    private final DaoConfig f15526b;

    public ConfigDaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f15526b = map.get(ConfigInfoDao.class).m15315clone();
        this.f15526b.initIdentityScope(identityScopeType);
        this.f15525a = new ConfigInfoDao(this.f15526b, this);
        registerDao(ConfigInfo.class, this.f15525a);
    }
}
