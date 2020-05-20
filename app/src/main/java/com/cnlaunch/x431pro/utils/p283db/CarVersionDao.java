package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.utils.p283db.p284a.DaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.CarVersionDao */
/* loaded from: classes.dex */
public class CarVersionDao extends AbstractDao<CarVersion, Long> {
    public static final String TABLENAME = "CAR_VERSION";

    /* renamed from: com.cnlaunch.x431pro.utils.db.CarVersionDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15770Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property SerialNo = new Property(1, String.class, "serialNo", false, "SERIAL_NO");
        public static final Property SoftPackageId = new Property(2, String.class, "softPackageId", false, "SOFT_PACKAGE_ID");
        public static final Property VersionNo = new Property(3, String.class, "versionNo", false, "VERSIONNO");
        public static final Property IsExist = new Property(4, Boolean.class, "isExist", false, "IS_EXIST");
        public static final Property Languagelist = new Property(5, String.class, "languageList", false, "LANGUAGELIST");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, CarVersion carVersion) {
        CarVersion carVersion2 = carVersion;
        sQLiteStatement.clearBindings();
        Long l = carVersion2.f15825a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindString(2, carVersion2.f15826b);
        sQLiteStatement.bindString(3, carVersion2.f15827c);
        sQLiteStatement.bindString(4, carVersion2.f15828d);
        sQLiteStatement.bindLong(5, carVersion2.f15829e.booleanValue() ? 1L : 0L);
        String str = carVersion2.f15830f;
        if (str != null) {
            sQLiteStatement.bindString(6, str);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(CarVersion carVersion) {
        CarVersion carVersion2 = carVersion;
        if (carVersion2 != null) {
            return carVersion2.f15825a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, CarVersion carVersion, int i) {
        CarVersion carVersion2 = carVersion;
        int i2 = i + 0;
        carVersion2.f15825a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        carVersion2.f15826b = cursor.getString(i + 1);
        carVersion2.f15827c = cursor.getString(i + 2);
        carVersion2.f15828d = cursor.getString(i + 3);
        carVersion2.f15829e = Boolean.valueOf(cursor.getLong(i + 4) != 0);
        int i3 = i + 5;
        carVersion2.f15830f = cursor.isNull(i3) ? null : cursor.getString(i3);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(CarVersion carVersion, long j) {
        carVersion.f15825a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public CarVersionDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    /* renamed from: a */
    public static void m5060a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'CAR_VERSION' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'SERIAL_NO' TEXT NOT NULL ,'SOFT_PACKAGE_ID' TEXT NOT NULL ,'VERSIONNO' TEXT,'IS_EXIST' INTEGER,'LANGUAGELIST' TEXT);");
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
    public /* synthetic */ CarVersion readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        String string2 = cursor.getString(i + 2);
        String string3 = cursor.getString(i + 3);
        Boolean valueOf2 = Boolean.valueOf(cursor.getLong(i + 4) != 0);
        int i3 = i + 5;
        return new CarVersion(valueOf, string, string2, string3, valueOf2, cursor.isNull(i3) ? null : cursor.getString(i3));
    }
}
