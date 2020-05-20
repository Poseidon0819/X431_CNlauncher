package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.p283db.p284a.SDCardDaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.UserInfoDao */
/* loaded from: classes.dex */
public class UserInfoDao extends AbstractDao<UserInfoTable, Long> {
    public static final String TABLENAME = "USER_INFO";

    /* renamed from: com.cnlaunch.x431pro.utils.db.UserInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15776Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property UserName = new Property(1, String.class, "userName", false, "USER_NAME");
        public static final Property SerialNo = new Property(2, String.class, "serialNo", false, "SERIAL_NO");
        public static final Property UserId = new Property(3, String.class, "userId", false, "USER_ID");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, UserInfoTable userInfoTable) {
        UserInfoTable userInfoTable2 = userInfoTable;
        sQLiteStatement.clearBindings();
        Long l = userInfoTable2.f15846a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = userInfoTable2.f15847b;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        if (userInfoTable2.f15848c != null) {
            sQLiteStatement.bindString(3, userInfoTable2.f15848c);
        }
        if (userInfoTable2.f15849d != null) {
            sQLiteStatement.bindString(4, userInfoTable2.f15849d);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(UserInfoTable userInfoTable) {
        UserInfoTable userInfoTable2 = userInfoTable;
        if (userInfoTable2 != null) {
            return userInfoTable2.f15846a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, UserInfoTable userInfoTable, int i) {
        UserInfoTable userInfoTable2 = userInfoTable;
        int i2 = i + 0;
        userInfoTable2.f15846a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        userInfoTable2.f15847b = cursor.getString(i + 1);
        userInfoTable2.f15848c = cursor.getString(i + 2);
        userInfoTable2.f15849d = cursor.getString(i + 3);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(UserInfoTable userInfoTable, long j) {
        userInfoTable.f15846a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public UserInfoDao(DaoConfig daoConfig, SDCardDaoSession sDCardDaoSession) {
        super(daoConfig, sDCardDaoSession);
    }

    /* renamed from: a */
    public static void m5039a(SQLiteDatabase sQLiteDatabase, boolean z) {
        NLog.m9456a("greenDAO", "createTable enter.");
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'USER_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'USER_NAME' TEXT NOT NULL,'SERIAL_NO' TEXT NOT NULL ,'USER_ID' TEXT NOT NULL );");
        NLog.m9456a("greenDAO", "createTable exit.");
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
    public /* synthetic */ UserInfoTable readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        return new UserInfoTable(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getString(i + 1), cursor.getString(i + 2), cursor.getString(i + 3));
    }
}
