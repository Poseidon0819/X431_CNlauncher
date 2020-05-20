package com.cnlaunch.x431pro.module.config.p251db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.x431pro.module.config.db.a */
/* loaded from: classes.dex */
public final class ConfigDaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m5387a(SQLiteDatabase sQLiteDatabase) {
        ConfigInfoDao.m5390a(sQLiteDatabase);
    }

    /* renamed from: b */
    public static void m5386b(SQLiteDatabase sQLiteDatabase) {
        ConfigInfoDao.m5389b(sQLiteDatabase);
    }

    /* compiled from: ConfigDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.module.config.db.a$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2724b extends SQLiteOpenHelper {
        public AbstractC2724b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.i("greenDAO", "Creating tables for schema version 1");
            ConfigDaoMaster.m5387a(sQLiteDatabase);
        }
    }

    /* compiled from: ConfigDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.module.config.db.a$a */
    /* loaded from: classes.dex */
    public static class C2723a extends AbstractC2724b {
        public C2723a(Context context, String str) {
            super(context, str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            ConfigDaoMaster.m5386b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public ConfigDaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 1);
        registerDaoClass(ConfigInfoDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final ConfigDaoSession newSession() {
        return new ConfigDaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new ConfigDaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
