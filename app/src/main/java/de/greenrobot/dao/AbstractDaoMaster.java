package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AbstractDaoMaster {
    protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap = new HashMap();

    /* renamed from: db */
    protected final SQLiteDatabase f23924db;
    protected final int schemaVersion;

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType identityScopeType);

    public AbstractDaoMaster(SQLiteDatabase sQLiteDatabase, int i) {
        this.f23924db = sQLiteDatabase;
        this.schemaVersion = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerDaoClass(Class<? extends AbstractDao<?, ?>> cls) {
        this.daoConfigMap.put(cls, new DaoConfig(this.f23924db, cls));
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public SQLiteDatabase getDatabase() {
        return this.f23924db;
    }
}
