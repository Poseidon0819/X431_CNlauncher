package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import com.mopub.mobileads.VastExtensionXmlManager;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.im.db.VerificationInfoDao */
/* loaded from: classes.dex */
public class VerificationInfoDao extends AbstractDao<VerificationInfo, Long> {
    public static final String TABLENAME = "VERIFICATION_INFO";

    /* renamed from: com.cnlaunch.im.db.VerificationInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f9214Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property User_id = new Property(1, String.class, "user_id", false, "USER_ID");
        public static final Property Nick_name = new Property(2, String.class, "nick_name", false, "NICK_NAME");
        public static final Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public static final Property Time = new Property(4, Long.class, "time", false, "TIME");
        public static final Property Type = new Property(5, Integer.class, VastExtensionXmlManager.TYPE, false, "TYPE");
        public static final Property Face_url = new Property(6, String.class, "face_url", false, "FACE_URL");
        public static final Property IsRead = new Property(7, Boolean.class, "is_read", false, "IS_READ");
        public static final Property Bind_ID = new Property(8, String.class, "bind_id", false, "BIND_ID");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, VerificationInfo verificationInfo) {
        VerificationInfo verificationInfo2 = verificationInfo;
        sQLiteStatement.clearBindings();
        Long l = verificationInfo2.f15544a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = verificationInfo2.f15545b;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        String str2 = verificationInfo2.f15546c;
        if (str2 != null) {
            sQLiteStatement.bindString(3, str2);
        }
        String str3 = verificationInfo2.f15547d;
        if (str3 != null) {
            sQLiteStatement.bindString(4, str3);
        }
        Long valueOf = Long.valueOf(verificationInfo2.f15548e);
        if (valueOf != null) {
            sQLiteStatement.bindLong(5, valueOf.longValue());
        }
        Integer num = verificationInfo2.f15549f;
        if (num != null) {
            sQLiteStatement.bindLong(6, num.intValue());
        }
        String str4 = verificationInfo2.f15550g;
        if (str4 != null) {
            sQLiteStatement.bindString(7, str4);
        }
        Boolean valueOf2 = Boolean.valueOf(verificationInfo2.f15551h);
        if (valueOf2 != null) {
            sQLiteStatement.bindLong(8, valueOf2.booleanValue() ? 1L : 0L);
        }
        String str5 = verificationInfo2.f15552i;
        if (str5 != null) {
            sQLiteStatement.bindString(9, str5);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(VerificationInfo verificationInfo) {
        VerificationInfo verificationInfo2 = verificationInfo;
        if (verificationInfo2 != null) {
            return verificationInfo2.f15544a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, VerificationInfo verificationInfo, int i) {
        Boolean valueOf;
        VerificationInfo verificationInfo2 = verificationInfo;
        int i2 = i + 0;
        verificationInfo2.f15544a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        verificationInfo2.f15545b = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        verificationInfo2.f15546c = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        verificationInfo2.f15547d = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        verificationInfo2.m5310a(cursor.isNull(i6) ? null : Long.valueOf(cursor.getLong(i6)));
        int i7 = i + 5;
        verificationInfo2.f15549f = cursor.isNull(i7) ? null : Integer.valueOf(cursor.getInt(i7));
        int i8 = i + 6;
        verificationInfo2.f15550g = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        if (cursor.isNull(i9)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i9) != 0);
        }
        verificationInfo2.f15551h = valueOf.booleanValue();
        int i10 = i + 8;
        verificationInfo2.f15552i = cursor.isNull(i10) ? null : cursor.getString(i10);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(VerificationInfo verificationInfo, long j) {
        verificationInfo.f15544a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public VerificationInfoDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8760a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'VERIFICATION_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'USER_ID' TEXT,'NICK_NAME' TEXT,'CONTENT' TEXT,'TIME' INTEGER,'TYPE' INTEGER,'FACE_URL' TEXT,'IS_READ' INTEGER,'BIND_ID' TEXT);");
    }

    /* renamed from: b */
    public static void m8759b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'VERIFICATION_INFO'");
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
    public /* synthetic */ VerificationInfo readEntity(Cursor cursor, int i) {
        Boolean valueOf;
        int i2 = i + 0;
        Long valueOf2 = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        Long valueOf3 = cursor.isNull(i6) ? null : Long.valueOf(cursor.getLong(i6));
        int i7 = i + 5;
        Integer valueOf4 = cursor.isNull(i7) ? null : Integer.valueOf(cursor.getInt(i7));
        int i8 = i + 6;
        String string4 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        if (cursor.isNull(i9)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getInt(i9) != 0);
        }
        int i10 = i + 8;
        return new VerificationInfo(valueOf2, string, string2, string3, valueOf3, valueOf4, string4, valueOf.booleanValue(), cursor.isNull(i10) ? null : cursor.getString(i10));
    }
}
