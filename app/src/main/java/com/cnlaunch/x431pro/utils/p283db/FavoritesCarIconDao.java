package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.FavoritesCarIconDao */
/* loaded from: classes.dex */
public class FavoritesCarIconDao extends AbstractDao<CarIcon, Long> {
    public static final String TABLENAME = "FAVORITES_CAR_ICON";

    /* renamed from: com.cnlaunch.x431pro.utils.db.FavoritesCarIconDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15772Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property SoftPackageId = new Property(1, String.class, "softPackageId", false, "SOFT_PACKAGE_ID");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Name_zh = new Property(3, String.class, "name_zh", false, "NAME_ZH");
        public static final Property Icon = new Property(4, String.class, "icon", false, "ICON");
        public static final Property AreaId = new Property(5, String.class, "areaId", false, "AREA_ID");
        public static final Property Sname = new Property(6, String.class, "sname", false, "SNAME");
        public static final Property Sname_zh = new Property(7, String.class, "sname_zh", false, "SNAME_ZH");
        public static final Property Maxversion = new Property(8, String.class, "maxversion", false, "MAXVERSION");
        public static final Property Versionlist = new Property(9, String.class, "versionlist", false, "VERSIONLIST");
        public static final Property IsDownload = new Property(10, Boolean.class, "isDownload", false, "IS_DOWNLOAD");
        public static final Property Languagelist = new Property(11, String.class, "languageList", false, "LANGUAGELIST");
        public static final Property VehiclePath = new Property(12, String.class, "vehiclePath", false, "VEHICLEPATH");
        public static final Property SerialNo = new Property(13, String.class, "serialNo", false, "SERIALNO");
        public static final Property isFavorites = new Property(14, Boolean.class, "isFavorites", false, "IS_FAVORITES");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, CarIcon carIcon) {
        CarIcon carIcon2 = carIcon;
        sQLiteStatement.clearBindings();
        Long l = carIcon2.f15777a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindString(2, carIcon2.f15778b);
        sQLiteStatement.bindString(3, carIcon2.f15779c);
        sQLiteStatement.bindString(4, carIcon2.f15780d);
        sQLiteStatement.bindString(5, carIcon2.f15781e);
        sQLiteStatement.bindString(6, carIcon2.f15782f);
        sQLiteStatement.bindString(7, carIcon2.f15783g);
        sQLiteStatement.bindString(8, carIcon2.f15784h);
        String str = carIcon2.f15785i;
        if (str != null) {
            sQLiteStatement.bindString(9, str);
        }
        String str2 = carIcon2.f15786j;
        if (str2 != null) {
            sQLiteStatement.bindString(10, str2);
        }
        Boolean bool = carIcon2.f15787k;
        if (bool != null) {
            sQLiteStatement.bindLong(11, bool.booleanValue() ? 1L : 0L);
        }
        String str3 = carIcon2.f15788l;
        if (str3 != null) {
            sQLiteStatement.bindString(12, str3);
        }
        String str4 = carIcon2.f15789m;
        if (str4 != null) {
            sQLiteStatement.bindString(13, str4);
        }
        String str5 = carIcon2.f15790n;
        if (str5 != null) {
            sQLiteStatement.bindString(14, str5);
        }
        Boolean bool2 = carIcon2.f15791o;
        if (bool2 != null) {
            sQLiteStatement.bindLong(15, bool2.booleanValue() ? 1L : 0L);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(CarIcon carIcon) {
        CarIcon carIcon2 = carIcon;
        if (carIcon2 != null) {
            return carIcon2.f15777a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, CarIcon carIcon, int i) {
        Boolean valueOf;
        CarIcon carIcon2 = carIcon;
        int i2 = i + 0;
        Boolean bool = null;
        carIcon2.f15777a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        carIcon2.f15778b = cursor.getString(i + 1);
        carIcon2.f15779c = cursor.getString(i + 2);
        carIcon2.f15780d = cursor.getString(i + 3);
        carIcon2.f15781e = cursor.getString(i + 4);
        carIcon2.f15782f = cursor.getString(i + 5);
        carIcon2.f15783g = cursor.getString(i + 6);
        carIcon2.f15784h = cursor.getString(i + 7);
        int i3 = i + 8;
        carIcon2.f15785i = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 9;
        carIcon2.f15786j = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 10;
        if (cursor.isNull(i5)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i5) != 0);
        }
        carIcon2.f15787k = valueOf;
        int i6 = i + 11;
        carIcon2.f15788l = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 12;
        carIcon2.m5037a(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 13;
        carIcon2.f15790n = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 14;
        if (!cursor.isNull(i9)) {
            bool = Boolean.valueOf(cursor.getShort(i9) != 0);
        }
        carIcon2.f15791o = bool;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(CarIcon carIcon, long j) {
        carIcon.f15777a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public FavoritesCarIconDao(DaoConfig daoConfig, FavoritesDaoSession favoritesDaoSession) {
        super(daoConfig, favoritesDaoSession);
    }

    /* renamed from: a */
    public static void m5055a(SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'FAVORITES_CAR_ICON' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'SOFT_PACKAGE_ID' TEXT NOT NULL ,'NAME' TEXT NOT NULL ,'NAME_ZH' TEXT NOT NULL ,'ICON' TEXT NOT NULL ,'AREA_ID' TEXT NOT NULL ,'SNAME' TEXT NOT NULL ,'SNAME_ZH' TEXT NOT NULL ,'MAXVERSION' TEXT,'VERSIONLIST' TEXT,'IS_DOWNLOAD' INTEGER,'LANGUAGELIST' TEXT,'VEHICLEPATH' TEXT,'SERIALNO' TEXT,'IS_FAVORITES' INTEGER);");
    }

    /* renamed from: a */
    public static void m5056a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'FAVORITES_CAR_ICON'");
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
    public /* synthetic */ CarIcon readEntity(Cursor cursor, int i) {
        Boolean valueOf;
        Boolean valueOf2;
        int i2 = i + 0;
        Long valueOf3 = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        String string2 = cursor.getString(i + 2);
        String string3 = cursor.getString(i + 3);
        String string4 = cursor.getString(i + 4);
        String string5 = cursor.getString(i + 5);
        String string6 = cursor.getString(i + 6);
        String string7 = cursor.getString(i + 7);
        int i3 = i + 8;
        String string8 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 9;
        String string9 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 10;
        if (cursor.isNull(i5)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i5) != 0);
        }
        int i6 = i + 11;
        String string10 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 12;
        String string11 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 13;
        String string12 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 14;
        if (cursor.isNull(i9)) {
            valueOf2 = null;
        } else {
            valueOf2 = Boolean.valueOf(cursor.getShort(i9) != 0);
        }
        return new CarIcon(valueOf3, string, string2, string3, string4, string5, string6, string7, string8, string9, valueOf, string10, string11, string12, valueOf2);
    }
}
