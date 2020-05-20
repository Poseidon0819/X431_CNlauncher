package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p252d.p254b.SerialNoForbitFlag;
import com.cnlaunch.x431pro.utils.p283db.p284a.DaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.packet.MultipleAddresses;

/* renamed from: com.cnlaunch.x431pro.utils.db.SerialNumberDao */
/* loaded from: classes.dex */
public class SerialNumberDao extends AbstractDao<SerialNumber, Long> {
    public static final String TABLENAME = "SERIAL_NUMBER";

    /* renamed from: com.cnlaunch.x431pro.utils.db.SerialNumberDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15774Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property IsMine = new Property(1, Boolean.class, "isMine", false, "IS_MINE");
        public static final Property IsDefault = new Property(2, Boolean.class, "isDefault", false, "IS_DEFAULT");
        public static final Property SerialNo = new Property(3, String.class, "serialNo", false, "SERIAL_NO");

        /* renamed from: Cc */
        public static final Property f15773Cc = new Property(4, String.class, MultipleAddresses.f24412CC, false, "CC");
        public static final Property VciCategory = new Property(5, String.class, "vciCatogery", false, "VCI_CATEGORY");
        public static final Property State = new Property(6, String.class, "state", false, "STATE");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, SerialNumber serialNumber) {
        SerialNumber serialNumber2 = serialNumber;
        sQLiteStatement.clearBindings();
        Long l = serialNumber2.f15831a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        Boolean bool = serialNumber2.f15832b;
        if (bool != null) {
            sQLiteStatement.bindLong(2, bool.booleanValue() ? 1L : 0L);
        }
        Boolean bool2 = serialNumber2.f15833c;
        if (bool2 != null) {
            sQLiteStatement.bindLong(3, bool2.booleanValue() ? 1L : 0L);
        }
        String str = serialNumber2.f15834d;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(4, str);
        String str2 = serialNumber2.f15835e;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(5, str2);
        if (serialNumber2.f15836f != null) {
            sQLiteStatement.bindString(6, serialNumber2.f15836f);
        }
        if (serialNumber2.f15837g != null) {
            sQLiteStatement.bindString(7, serialNumber2.f15837g);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(SerialNumber serialNumber) {
        SerialNumber serialNumber2 = serialNumber;
        if (serialNumber2 != null) {
            return serialNumber2.f15831a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, SerialNumber serialNumber, int i) {
        Boolean valueOf;
        SerialNumber serialNumber2 = serialNumber;
        int i2 = i + 0;
        Boolean bool = null;
        serialNumber2.f15831a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        if (cursor.isNull(i3)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i3) != 0);
        }
        serialNumber2.f15832b = valueOf;
        int i4 = i + 2;
        if (!cursor.isNull(i4)) {
            bool = Boolean.valueOf(cursor.getShort(i4) != 0);
        }
        serialNumber2.f15833c = bool;
        serialNumber2.f15834d = cursor.getString(i + 3);
        serialNumber2.f15835e = cursor.getString(i + 4);
        serialNumber2.f15836f = cursor.getString(i + 5);
        serialNumber2.f15837g = cursor.getString(i + 6);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(SerialNumber serialNumber, long j) {
        serialNumber.f15831a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public SerialNumberDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    /* renamed from: a */
    public static void m5052a(SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'SERIAL_NUMBER' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'IS_MINE' INTEGER,'IS_DEFAULT' INTEGER,'SERIAL_NO' TEXT NOT NULL ,'CC' TEXT NOT NULL,'VCI_CATEGORY' TEXT,'STATE' TEXT);");
    }

    /* renamed from: a */
    public static void m5053a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'SERIAL_NUMBER'");
    }

    /* renamed from: a */
    public final SerialNumber m5050a(String str) {
        List<SerialNumber> list;
        try {
            if (TextUtils.isEmpty(str) || (list = queryBuilder().where(Properties.SerialNo.m321eq(str), new WhereCondition[0]).list()) == null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            Log.e("yhx", e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: a */
    public final synchronized void m5049a(List<String> list) {
        try {
            if (list.isEmpty()) {
                deleteAll();
                return;
            }
            List<SerialNumber> loadAll = loadAll();
            if (loadAll != null && !loadAll.isEmpty()) {
                for (SerialNumber serialNumber : loadAll) {
                    if (!list.contains(serialNumber.f15834d)) {
                        delete(serialNumber);
                    }
                }
            }
        } catch (Exception e) {
            NLog.m9451c("yhx", e);
        }
    }

    /* renamed from: a */
    public final synchronized void m5051a(SerialNumber serialNumber) {
        try {
            List<SerialNumber> list = queryBuilder().where(Properties.SerialNo.m321eq(serialNumber.f15834d), new WhereCondition[0]).list();
            if (list != null && !list.isEmpty()) {
                for (SerialNumber serialNumber2 : list) {
                    serialNumber2.f15835e = serialNumber.f15835e;
                    serialNumber2.f15833c = serialNumber.f15833c;
                    serialNumber2.f15832b = serialNumber.f15832b;
                }
                m5042d(list);
                return;
            }
            insert(serialNumber);
        } catch (Exception e) {
            NLog.m9451c("yhx", e);
        }
    }

    /* renamed from: b */
    public final synchronized void m5047b(String str) {
        try {
            QueryBuilder<SerialNumber> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.SerialNo.m321eq(str), new WhereCondition[0]);
            List<SerialNumber> list = queryBuilder.list();
            if (list != null && !list.isEmpty()) {
                for (SerialNumber serialNumber : list) {
                    serialNumber.f15833c = Boolean.TRUE;
                }
                m5042d(list);
            }
        } catch (Exception e) {
            NLog.m9451c("yhx", e);
        }
    }

    /* renamed from: d */
    private synchronized void m5042d(List<SerialNumber> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    updateInTx(list);
                }
            } catch (Exception e) {
                NLog.m9451c("yhx", e);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m5046b(List<SerialNumber> list) {
        try {
            if (!list.isEmpty()) {
                insertInTx(list);
            }
        } catch (Exception e) {
            NLog.m9451c("yhx", e);
        }
    }

    /* renamed from: a */
    public final List<SerialNumber> m5054a() {
        ArrayList arrayList = new ArrayList();
        try {
            return loadAll();
        } catch (Exception e) {
            NLog.m9451c("yhx", e);
            return arrayList;
        }
    }

    /* renamed from: b */
    public final boolean m5048b() {
        try {
            return count() <= 0;
        } catch (Exception e) {
            NLog.m9455a(e);
            return false;
        }
    }

    /* renamed from: c */
    public final synchronized void m5044c(List<SerialNoForbitFlag> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (SerialNoForbitFlag serialNoForbitFlag : list) {
                        List<SerialNumber> list2 = queryBuilder().where(Properties.SerialNo.m321eq(serialNoForbitFlag.getSerialNo()), new WhereCondition[0]).list();
                        if (list2 != null && !list2.isEmpty()) {
                            for (SerialNumber serialNumber : list2) {
                                serialNumber.f15837g = serialNoForbitFlag.getForbitFlag();
                            }
                            updateInTx(list2);
                        }
                    }
                }
            } catch (Exception e) {
                NLog.m9455a(e);
            }
        }
    }

    /* renamed from: c */
    public final String m5045c(String str) {
        List<SerialNumber> list;
        SerialNumber serialNumber;
        return (TextUtils.isEmpty(str) || (list = queryBuilder().where(Properties.SerialNo.m321eq(str), new WhereCondition[0]).list()) == null || list.isEmpty() || (serialNumber = list.get(0)) == null || TextUtils.isEmpty(serialNumber.f15837g)) ? "0" : serialNumber.f15837g;
    }

    /* renamed from: d */
    public final synchronized void m5043d(String str) {
        List<SerialNumber> list;
        try {
            if (!TextUtils.isEmpty(str) && (list = queryBuilder().where(Properties.SerialNo.m321eq(str), new WhereCondition[0]).list()) != null && !list.isEmpty()) {
                for (SerialNumber serialNumber : list) {
                    serialNumber.f15837g = "2";
                }
                updateInTx(list);
            }
        } catch (Exception e) {
            NLog.m9455a(e);
        }
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
    public /* synthetic */ SerialNumber readEntity(Cursor cursor, int i) {
        Boolean valueOf;
        Boolean valueOf2;
        int i2 = i + 0;
        Long valueOf3 = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        if (cursor.isNull(i3)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i3) != 0);
        }
        int i4 = i + 2;
        if (cursor.isNull(i4)) {
            valueOf2 = null;
        } else {
            valueOf2 = Boolean.valueOf(cursor.getShort(i4) != 0);
        }
        return new SerialNumber(valueOf3, valueOf, valueOf2, cursor.getString(i + 3), cursor.getString(i + 4), cursor.getString(i + 5), cursor.getString(i + 6));
    }
}
