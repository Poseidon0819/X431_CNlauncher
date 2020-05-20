package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.im.db.FriendInfoDao */
/* loaded from: classes.dex */
public class FriendInfoDao extends AbstractDao<FriendInfo, Long> {
    public static final String TABLENAME = "FRIEND_INFO";

    /* renamed from: com.cnlaunch.im.db.FriendInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f9208Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property User_id = new Property(1, String.class, "user_id", false, "USER_ID");
        public static final Property User_name = new Property(2, String.class, "user_name", false, "USER_NAME");
        public static final Property Nick_name = new Property(3, String.class, "nick_name", false, "NICK_NAME");
        public static final Property Rename = new Property(4, String.class, "rename", false, "RENAME");
        public static final Property Signature = new Property(5, String.class, "signature", false, "SIGNATURE");
        public static final Property Sex = new Property(6, Integer.class, "sex", false, "SEX");
        public static final Property SortKey = new Property(7, String.class, "sortKey", false, "SORT_KEY");
        public static final Property Public_id = new Property(8, String.class, "public_id", false, "PUBLIC_ID");
        public static final Property Public_name = new Property(9, String.class, "public_name", false, "PUBLIC_NAME");
        public static final Property R_type = new Property(10, String.class, "r_type", false, "R_TYPE");
        public static final Property Roles = new Property(11, String.class, "roles", false, "ROLES");
        public static final Property Face_url = new Property(12, String.class, "face_url", false, "FACE_URL");
        public static final Property Face_thumb = new Property(13, String.class, "face_thumb", false, "FACE_THUMB");
        public static final Property LastText = new Property(14, String.class, "last_text", false, "LAST_TEXT");
        public static final Property LastTime = new Property(15, Long.class, "last_time", false, "LAST_TIME");
        public static final Property NoRead = new Property(16, Integer.class, "no_read", false, "NO_READ");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, FriendInfo friendInfo) {
        FriendInfo friendInfo2 = friendInfo;
        sQLiteStatement.clearBindings();
        Long id = friendInfo2.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String user_id = friendInfo2.getUser_id();
        if (user_id != null) {
            sQLiteStatement.bindString(2, user_id);
        }
        String user_name = friendInfo2.getUser_name();
        if (user_name != null) {
            sQLiteStatement.bindString(3, user_name);
        }
        String nick_name = friendInfo2.getNick_name();
        if (nick_name != null) {
            sQLiteStatement.bindString(4, nick_name);
        }
        String rename = friendInfo2.getRename();
        if (rename != null) {
            sQLiteStatement.bindString(5, rename);
        }
        String signature = friendInfo2.getSignature();
        if (signature != null) {
            sQLiteStatement.bindString(6, signature);
        }
        Integer sex = friendInfo2.getSex();
        if (sex != null) {
            sQLiteStatement.bindLong(7, sex.intValue());
        }
        String sortKey = friendInfo2.getSortKey();
        if (sortKey != null) {
            sQLiteStatement.bindString(8, sortKey);
        }
        String public_id = friendInfo2.getPublic_id();
        if (public_id != null) {
            sQLiteStatement.bindString(9, public_id);
        }
        String public_name = friendInfo2.getPublic_name();
        if (public_name != null) {
            sQLiteStatement.bindString(10, public_name);
        }
        String r_type = friendInfo2.getR_type();
        if (r_type != null) {
            sQLiteStatement.bindString(11, r_type);
        }
        String roles = friendInfo2.getRoles();
        if (roles != null) {
            sQLiteStatement.bindString(12, roles);
        }
        String face_url = friendInfo2.getFace_url();
        if (face_url != null) {
            sQLiteStatement.bindString(13, face_url);
        }
        String face_thumb = friendInfo2.getFace_thumb();
        if (face_thumb != null) {
            sQLiteStatement.bindString(14, face_thumb);
        }
        String lastText = friendInfo2.getLastText();
        if (lastText != null) {
            sQLiteStatement.bindString(15, lastText);
        }
        Long lastTime = friendInfo2.getLastTime();
        if (lastTime != null) {
            sQLiteStatement.bindLong(16, lastTime.longValue());
        }
        Integer valueOf = Integer.valueOf(friendInfo2.getNoRead());
        if (valueOf != null) {
            sQLiteStatement.bindLong(17, valueOf.intValue());
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(FriendInfo friendInfo) {
        FriendInfo friendInfo2 = friendInfo;
        if (friendInfo2 != null) {
            return friendInfo2.getId();
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, FriendInfo friendInfo, int i) {
        FriendInfo friendInfo2 = friendInfo;
        int i2 = i + 0;
        friendInfo2.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        friendInfo2.setUser_id(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        friendInfo2.setUser_name(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        friendInfo2.setNick_name(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        friendInfo2.setRename(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        friendInfo2.setSignature(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        friendInfo2.setSex(cursor.isNull(i8) ? null : Integer.valueOf(cursor.getInt(i8)));
        int i9 = i + 7;
        friendInfo2.setSortKey(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 8;
        friendInfo2.setPublic_id(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 9;
        friendInfo2.setPublic_name(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 10;
        friendInfo2.setR_type(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 11;
        friendInfo2.setRoles(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 12;
        friendInfo2.setFace_url(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 13;
        friendInfo2.setFace_thumb(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 14;
        friendInfo2.setLastText(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 15;
        friendInfo2.setLastTime(cursor.isNull(i17) ? null : Long.valueOf(cursor.getLong(i17)));
        int i18 = i + 16;
        friendInfo2.setNoRead((cursor.isNull(i18) ? null : Integer.valueOf(cursor.getInt(i18))).intValue());
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(FriendInfo friendInfo, long j) {
        friendInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public FriendInfoDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8770a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'FRIEND_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'USER_ID' TEXT,'USER_NAME' TEXT,'NICK_NAME' TEXT,'RENAME' TEXT,'SIGNATURE' TEXT,'SEX' INTEGER,'SORT_KEY' TEXT,'PUBLIC_ID' TEXT,'PUBLIC_NAME' TEXT,'R_TYPE' TEXT,'ROLES' TEXT,'FACE_URL' TEXT,'FACE_THUMB' TEXT,'LAST_TEXT' TEXT,'LAST_TIME' INTEGER,'NO_READ' INTEGER);");
    }

    /* renamed from: b */
    public static void m8769b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'FRIEND_INFO'");
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
    public /* synthetic */ FriendInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        Integer valueOf2 = cursor.isNull(i8) ? null : Integer.valueOf(cursor.getInt(i8));
        int i9 = i + 7;
        String string6 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 8;
        String string7 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 9;
        String string8 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 10;
        String string9 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 11;
        String string10 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 12;
        String string11 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 13;
        String string12 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 14;
        String string13 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 15;
        Long valueOf3 = cursor.isNull(i17) ? null : Long.valueOf(cursor.getLong(i17));
        int i18 = i + 16;
        return new FriendInfo(valueOf, string, string2, string3, string4, string5, valueOf2, string6, string7, string8, string9, string10, string11, string12, string13, valueOf3, (cursor.isNull(i18) ? null : Integer.valueOf(cursor.getInt(i18))).intValue());
    }
}
