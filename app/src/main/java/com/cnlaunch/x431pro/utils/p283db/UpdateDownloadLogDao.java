package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.utils.p283db.p284a.DaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.UpdateDownloadLogDao */
/* loaded from: classes.dex */
public class UpdateDownloadLogDao extends AbstractDao<UpdateDownloadLog, Long> {
    public static final String TABLENAME = "DOWNLOAD_LOG";

    /* renamed from: com.cnlaunch.x431pro.utils.db.UpdateDownloadLogDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15775Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property DownloadId = new Property(1, String.class, "downloadId", false, "DOWNLOADID");
        public static final Property State = new Property(2, String.class, "state", false, "STATE");
        public static final Property Downloadsize = new Property(3, String.class, "downloadsize", false, "DOWNLOADSIZE");
        public static final Property DownloadDuration = new Property(4, String.class, "downloadDuration", false, "DOWNLOADDURATION");
        public static final Property CurrentNetworkSpeed = new Property(5, String.class, "currentNetworkSpeed", false, "CURRENTNETWORKSPEED");
        public static final Property CurrentConfigArea = new Property(6, String.class, "currentConfigArea", false, "CURRENTCONFIGAREA");
        public static final Property Sign = new Property(7, String.class, "sign", false, "SIGN");
        public static final Property FileName = new Property(8, String.class, "fileName", false, "FILENAME");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, UpdateDownloadLog updateDownloadLog) {
        UpdateDownloadLog updateDownloadLog2 = updateDownloadLog;
        sQLiteStatement.clearBindings();
        Long l = updateDownloadLog2.f15838a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindString(2, updateDownloadLog2.f15839b);
        sQLiteStatement.bindString(3, updateDownloadLog2.f15840c);
        sQLiteStatement.bindString(4, updateDownloadLog2.f15841d);
        sQLiteStatement.bindString(5, updateDownloadLog2.f15842e);
        sQLiteStatement.bindString(6, updateDownloadLog2.f15843f);
        sQLiteStatement.bindString(7, updateDownloadLog2.f15844g);
        sQLiteStatement.bindString(8, updateDownloadLog2.f15845h);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(UpdateDownloadLog updateDownloadLog) {
        UpdateDownloadLog updateDownloadLog2 = updateDownloadLog;
        if (updateDownloadLog2 != null) {
            return updateDownloadLog2.f15838a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, UpdateDownloadLog updateDownloadLog, int i) {
        UpdateDownloadLog updateDownloadLog2 = updateDownloadLog;
        int i2 = i + 0;
        updateDownloadLog2.f15838a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        updateDownloadLog2.f15839b = cursor.getString(i + 1);
        updateDownloadLog2.f15840c = cursor.getString(i + 2);
        updateDownloadLog2.f15841d = cursor.getString(i + 3);
        updateDownloadLog2.f15842e = cursor.getString(i + 4);
        updateDownloadLog2.f15843f = cursor.getString(i + 5);
        updateDownloadLog2.f15844g = cursor.getString(i + 6);
        updateDownloadLog2.f15845h = cursor.getString(i + 7);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(UpdateDownloadLog updateDownloadLog, long j) {
        updateDownloadLog.f15838a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public UpdateDownloadLogDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    /* renamed from: a */
    public static void m5040a(SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'DOWNLOAD_LOG' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'DOWNLOADID' TEXT NOT NULL ,'STATE' TEXT NOT NULL ,'DOWNLOADSIZE' TEXT  ,'DOWNLOADDURATION' TEXT  ,'CURRENTNETWORKSPEED' TEXT  ,'CURRENTCONFIGAREA' TEXT ,'SIGN' TEXT ,'FILENAME' TEXT);");
    }

    /* renamed from: a */
    public static void m5041a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'DOWNLOAD_LOG'");
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
    public /* synthetic */ UpdateDownloadLog readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        String string2 = cursor.getString(i + 2);
        String string3 = cursor.getString(i + 3);
        String string4 = cursor.getString(i + 4);
        String string5 = cursor.getString(i + 5);
        String string6 = cursor.getString(i + 6);
        String string7 = cursor.getString(i + 7);
        cursor.getString(i + 8);
        return new UpdateDownloadLog(valueOf, string, string2, string3, string4, string5, string6, string7);
    }
}
