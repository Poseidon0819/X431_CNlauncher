package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.mopub.mobileads.VastExtensionXmlManager;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.im.db.MessageInfoDao */
/* loaded from: classes.dex */
public class MessageInfoDao extends AbstractDao<MessageInfo, Long> {
    public static final String TABLENAME = "MESSAGE_INFO";

    /* renamed from: com.cnlaunch.im.db.MessageInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f9211Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property User_id = new Property(1, String.class, "user_id", false, "USER_ID");
        public static final Property User_name = new Property(2, String.class, "user_name", false, "USER_NAME");
        public static final Property No_read = new Property(3, Integer.class, "no_read", false, "NO_READ");
        public static final Property Type = new Property(4, Integer.class, VastExtensionXmlManager.TYPE, false, "TYPE");
        public static final Property Face_url = new Property(5, String.class, "face_url", false, "FACE_URL");
        public static final Property Content = new Property(6, String.class, "content", false, "CONTENT");
        public static final Property Time = new Property(7, Long.class, "time", false, "TIME");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, MessageInfo messageInfo) {
        MessageInfo messageInfo2 = messageInfo;
        sQLiteStatement.clearBindings();
        Long l = messageInfo2.f9269a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = messageInfo2.f9270b;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        String str2 = messageInfo2.f9271c;
        if (str2 != null) {
            sQLiteStatement.bindString(3, str2);
        }
        Integer num = messageInfo2.f9272d;
        if (num != null) {
            sQLiteStatement.bindLong(4, num.intValue());
        }
        Integer num2 = messageInfo2.f9273e;
        if (num2 != null) {
            sQLiteStatement.bindLong(5, num2.intValue());
        }
        String str3 = messageInfo2.f9274f;
        if (str3 != null) {
            sQLiteStatement.bindString(6, str3);
        }
        String str4 = messageInfo2.f9275g;
        if (str4 != null) {
            sQLiteStatement.bindString(7, str4);
        }
        Long l2 = messageInfo2.f9276h;
        if (l2 != null) {
            sQLiteStatement.bindLong(8, l2.longValue());
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(MessageInfo messageInfo) {
        MessageInfo messageInfo2 = messageInfo;
        if (messageInfo2 != null) {
            return messageInfo2.f9269a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, MessageInfo messageInfo, int i) {
        MessageInfo messageInfo2 = messageInfo;
        int i2 = i + 0;
        messageInfo2.f9269a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        messageInfo2.f9270b = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        messageInfo2.f9271c = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        messageInfo2.f9272d = cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5));
        int i6 = i + 4;
        messageInfo2.f9273e = cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6));
        int i7 = i + 5;
        messageInfo2.f9274f = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        messageInfo2.f9275g = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        messageInfo2.f9276h = cursor.isNull(i9) ? null : Long.valueOf(cursor.getLong(i9));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(MessageInfo messageInfo, long j) {
        messageInfo.f9269a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public MessageInfoDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8764a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'MESSAGE_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'USER_ID' TEXT,'USER_NAME' TEXT,'NO_READ' INTEGER,'TYPE' INTEGER,'FACE_URL' TEXT,'CONTENT' TEXT,'TIME' INTEGER);");
    }

    /* renamed from: b */
    public static void m8763b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'MESSAGE_INFO'");
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
    public /* synthetic */ MessageInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        Integer valueOf2 = cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5));
        int i6 = i + 4;
        Integer valueOf3 = cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6));
        int i7 = i + 5;
        String string3 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        int i9 = i + 7;
        return new MessageInfo(valueOf, string, string2, valueOf2, valueOf3, string3, cursor.isNull(i8) ? null : cursor.getString(i8), cursor.isNull(i9) ? null : Long.valueOf(cursor.getLong(i9)));
    }
}
