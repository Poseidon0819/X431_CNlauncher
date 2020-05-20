package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.im.db.GoloRemoteOrderInfoDao */
/* loaded from: classes.dex */
public class GoloRemoteOrderInfoDao extends AbstractDao<GoloRemoteOrderInfo, Long> {
    public static final String TABLENAME = "GOLO_REMOTE_ORDER_INFO";

    /* renamed from: com.cnlaunch.im.db.GoloRemoteOrderInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f9209Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Order_id = new Property(1, String.class, "order_id", false, "ORDER_ID");
        public static final Property Car_id = new Property(2, String.class, "car_id", false, "CAR_ID");
        public static final Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
        public static final Property Status = new Property(4, String.class, "status", false, "STATUS");
        public static final Property Created = new Property(5, Long.class, "created", false, "CREATED");
        public static final Property Auto_code = new Property(6, String.class, "auto_code", false, "AUTO_CODE");
        public static final Property Mine_car_plate_num = new Property(7, String.class, "mine_car_plate_num", false, "MINE_CAR_PLATE_NUM");
        public static final Property User_id = new Property(8, String.class, "user_id", false, "USER_ID");
        public static final Property User_name = new Property(9, String.class, "user_name", false, "USER_NAME");
        public static final Property Nick_name = new Property(10, String.class, "nick_name", false, "NICK_NAME");
        public static final Property Face_url = new Property(11, String.class, "face_url", false, "FACE_URL");
        public static final Property Face_thumb = new Property(12, String.class, "face_thumb", false, "FACE_THUMB");
        public static final Property Auto_logos = new Property(13, String.class, "auto_logos", false, "AUTO_LOGOS");
        public static final Property Online_status = new Property(14, String.class, "online_status", false, "ONLINE_STATUS");
        public static final Property Signature = new Property(15, String.class, "signature", false, "SIGNATURE");
        public static final Property SortKey = new Property(16, String.class, "sortKey", false, "SORT_KEY");
        public static final Property Serial_no = new Property(17, String.class, "serial_no", false, "SERIAL_NO");
        public static final Property IsRead = new Property(18, Boolean.class, "isRead", false, "IS_READ");
        public static final Property diagType = new Property(19, String.class, "diagType", false, "DIAG_TYPE");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, GoloRemoteOrderInfo goloRemoteOrderInfo) {
        GoloRemoteOrderInfo goloRemoteOrderInfo2 = goloRemoteOrderInfo;
        sQLiteStatement.clearBindings();
        Long db_id = goloRemoteOrderInfo2.getDb_id();
        if (db_id != null) {
            sQLiteStatement.bindLong(1, db_id.longValue());
        }
        String id = goloRemoteOrderInfo2.getId();
        if (id != null) {
            sQLiteStatement.bindString(2, id);
        }
        String car_id = goloRemoteOrderInfo2.getCar_id();
        if (car_id != null) {
            sQLiteStatement.bindString(3, car_id);
        }
        String description = goloRemoteOrderInfo2.getDescription();
        if (description != null) {
            sQLiteStatement.bindString(4, description);
        }
        String status = goloRemoteOrderInfo2.getStatus();
        if (status != null) {
            sQLiteStatement.bindString(5, status);
        }
        Long created = goloRemoteOrderInfo2.getCreated();
        if (created != null) {
            sQLiteStatement.bindLong(6, created.longValue());
        }
        String auto_code = goloRemoteOrderInfo2.getAuto_code();
        if (auto_code != null) {
            sQLiteStatement.bindString(7, auto_code);
        }
        String mine_car_plate_num = goloRemoteOrderInfo2.getMine_car_plate_num();
        if (mine_car_plate_num != null) {
            sQLiteStatement.bindString(8, mine_car_plate_num);
        }
        String user_id = goloRemoteOrderInfo2.getUser_id();
        if (user_id != null) {
            sQLiteStatement.bindString(9, user_id);
        }
        String user_name = goloRemoteOrderInfo2.getUser_name();
        if (user_name != null) {
            sQLiteStatement.bindString(10, user_name);
        }
        String nick_name = goloRemoteOrderInfo2.getNick_name();
        if (nick_name != null) {
            sQLiteStatement.bindString(11, nick_name);
        }
        String face_url = goloRemoteOrderInfo2.getFace_url();
        if (face_url != null) {
            sQLiteStatement.bindString(12, face_url);
        }
        String face_thumb = goloRemoteOrderInfo2.getFace_thumb();
        if (face_thumb != null) {
            sQLiteStatement.bindString(13, face_thumb);
        }
        String auto_logos = goloRemoteOrderInfo2.getAuto_logos();
        if (auto_logos != null) {
            sQLiteStatement.bindString(14, auto_logos);
        }
        String online_status = goloRemoteOrderInfo2.getOnline_status();
        if (online_status != null) {
            sQLiteStatement.bindString(15, online_status);
        }
        String signature = goloRemoteOrderInfo2.getSignature();
        if (signature != null) {
            sQLiteStatement.bindString(16, signature);
        }
        String sortKey = goloRemoteOrderInfo2.getSortKey();
        if (sortKey != null) {
            sQLiteStatement.bindString(17, sortKey);
        }
        String serial_no = goloRemoteOrderInfo2.getSerial_no();
        if (serial_no != null) {
            sQLiteStatement.bindString(18, serial_no);
        }
        Boolean isRead = goloRemoteOrderInfo2.getIsRead();
        if (isRead != null) {
            sQLiteStatement.bindLong(19, isRead.booleanValue() ? 1L : 0L);
        }
        String diagType = goloRemoteOrderInfo2.getDiagType();
        if (diagType != null) {
            sQLiteStatement.bindString(20, diagType);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(GoloRemoteOrderInfo goloRemoteOrderInfo) {
        GoloRemoteOrderInfo goloRemoteOrderInfo2 = goloRemoteOrderInfo;
        if (goloRemoteOrderInfo2 != null) {
            return goloRemoteOrderInfo2.getDb_id();
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, GoloRemoteOrderInfo goloRemoteOrderInfo, int i) {
        Boolean valueOf;
        GoloRemoteOrderInfo goloRemoteOrderInfo2 = goloRemoteOrderInfo;
        int i2 = i + 0;
        goloRemoteOrderInfo2.setDb_id(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        goloRemoteOrderInfo2.setId(cursor.getString(i + 1));
        int i3 = i + 2;
        goloRemoteOrderInfo2.setCar_id(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        goloRemoteOrderInfo2.setDescription(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        goloRemoteOrderInfo2.setStatus(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        goloRemoteOrderInfo2.setCreated(cursor.isNull(i6) ? null : Long.valueOf(cursor.getLong(i6)));
        int i7 = i + 6;
        goloRemoteOrderInfo2.setAuto_code(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 7;
        goloRemoteOrderInfo2.setMine_car_plate_num(cursor.isNull(i8) ? null : cursor.getString(i8));
        goloRemoteOrderInfo2.setUser_id(cursor.getString(i + 8));
        int i9 = i + 9;
        goloRemoteOrderInfo2.setUser_name(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 10;
        goloRemoteOrderInfo2.setNick_name(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 11;
        goloRemoteOrderInfo2.setFace_url(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 12;
        goloRemoteOrderInfo2.setFace_thumb(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 13;
        goloRemoteOrderInfo2.setAuto_logos(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 14;
        goloRemoteOrderInfo2.setOnline_status(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 15;
        goloRemoteOrderInfo2.setSignature(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 16;
        goloRemoteOrderInfo2.setSortKey(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 17;
        goloRemoteOrderInfo2.setSerial_no(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i + 18;
        if (cursor.isNull(i18)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i18) != 0);
        }
        goloRemoteOrderInfo2.setIsRead(valueOf);
        int i19 = i + 19;
        goloRemoteOrderInfo2.setDiagType(cursor.isNull(i19) ? null : cursor.getString(i19));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(GoloRemoteOrderInfo goloRemoteOrderInfo, long j) {
        goloRemoteOrderInfo.setDb_id(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public GoloRemoteOrderInfoDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8768a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'GOLO_REMOTE_ORDER_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'ORDER_ID' TEXT,'CAR_ID' TEXT,'DESCRIPTION' TEXT,'STATUS' TEXT,'CREATED' INTEGER,'AUTO_CODE' TEXT,'MINE_CAR_PLATE_NUM' TEXT,'USER_ID' TEXT,'USER_NAME' TEXT,'NICK_NAME' TEXT,'FACE_URL' TEXT,'FACE_THUMB' TEXT,'AUTO_LOGOS' TEXT,'ONLINE_STATUS' TEXT,'SIGNATURE' TEXT,'SORT_KEY' TEXT,'SERIAL_NO' TEXT,'IS_READ' INTEGER,'DIAG_TYPE' TEXT);");
    }

    /* renamed from: b */
    public static void m8767b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'GOLO_REMOTE_ORDER_INFO'");
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
    public /* synthetic */ GoloRemoteOrderInfo readEntity(Cursor cursor, int i) {
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
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        Long valueOf3 = cursor.isNull(i7) ? null : Long.valueOf(cursor.getLong(i7));
        int i8 = i + 6;
        String string5 = cursor.isNull(i8) ? null : cursor.getString(i8);
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
        String string14 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 16;
        String string15 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 17;
        String string16 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 18;
        if (cursor.isNull(i20)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i20) != 0);
        }
        int i21 = i + 19;
        return new GoloRemoteOrderInfo(valueOf2, string, string2, string3, string4, valueOf3, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, valueOf, cursor.isNull(i21) ? null : cursor.getString(i21));
    }
}
