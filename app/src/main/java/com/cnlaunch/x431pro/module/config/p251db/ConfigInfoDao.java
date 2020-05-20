package com.cnlaunch.x431pro.module.config.p251db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.module.config.db.ConfigInfoDao */
/* loaded from: classes.dex */
public class ConfigInfoDao extends AbstractDao<ConfigInfo, Long> {
    public static final String TABLENAME = "CONFIG_INFO";

    /* renamed from: com.cnlaunch.x431pro.module.config.db.ConfigInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15524Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Key = new Property(1, String.class, "key", false, "KEY");
        public static final Property Value = new Property(2, String.class, "value", false, "VALUE");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, ConfigInfo configInfo) {
        ConfigInfo configInfo2 = configInfo;
        sQLiteStatement.clearBindings();
        Long l = configInfo2.f15527a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindString(2, configInfo2.f15528b);
        sQLiteStatement.bindString(3, configInfo2.f15529c);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(ConfigInfo configInfo) {
        ConfigInfo configInfo2 = configInfo;
        if (configInfo2 != null) {
            return configInfo2.f15527a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, ConfigInfo configInfo, int i) {
        ConfigInfo configInfo2 = configInfo;
        int i2 = i + 0;
        configInfo2.f15527a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        configInfo2.f15528b = cursor.getString(i + 1);
        configInfo2.f15529c = cursor.getString(i + 2);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(ConfigInfo configInfo, long j) {
        configInfo.f15527a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public ConfigInfoDao(DaoConfig daoConfig, ConfigDaoSession configDaoSession) {
        super(daoConfig, configDaoSession);
    }

    /* renamed from: a */
    public static void m5390a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'CONFIG_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'KEY' TEXT NOT NULL ,'VALUE' TEXT NOT NULL );");
    }

    /* renamed from: b */
    public static void m5389b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'CONFIG_INFO'");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ ConfigInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        return new ConfigInfo(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getString(i + 1), cursor.getString(i + 2));
    }
}
