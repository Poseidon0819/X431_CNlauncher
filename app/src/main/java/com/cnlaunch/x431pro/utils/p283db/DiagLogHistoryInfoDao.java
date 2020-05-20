package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.DiagLogHistoryInfoDao */
/* loaded from: classes.dex */
public class DiagLogHistoryInfoDao extends AbstractDao<DiagLogHistoryInfo, Long> {
    public static final String TABLENAME = "DIAGLOG_HISTORY_INFO";

    /* renamed from: com.cnlaunch.x431pro.utils.db.DiagLogHistoryInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {
        public static final Property LogId = new Property(0, Long.class, "logId", true, "_id");
        public static final Property LogName = new Property(1, String.class, "logName", false, "LOG_NAME");
        public static final Property CurrentState = new Property(2, Integer.class, "currentState", false, "CURRENT_STATE");
        public static final Property FeedbackTime = new Property(3, String.class, "feedbackTime", false, "FEEDBACK_TIME");
        public static final Property InputContent = new Property(4, String.class, "inputContent", false, "INPUT_CONTENT");
        public static final Property SerialNo = new Property(5, String.class, "serialNo", false, "SERIAL_NO");
        public static final Property Readed = new Property(6, Integer.class, "readed", false, "READED");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, DiagLogHistoryInfo diagLogHistoryInfo) {
        DiagLogHistoryInfo diagLogHistoryInfo2 = diagLogHistoryInfo;
        sQLiteStatement.clearBindings();
        Long valueOf = Long.valueOf(Long.parseLong(diagLogHistoryInfo2.getLogId()));
        if (valueOf != null) {
            sQLiteStatement.bindLong(1, valueOf.longValue());
        }
        sQLiteStatement.bindString(2, diagLogHistoryInfo2.getLogName());
        sQLiteStatement.bindLong(3, diagLogHistoryInfo2.getCurrentState());
        sQLiteStatement.bindString(4, diagLogHistoryInfo2.getFeedbackTime());
        String inputContent = diagLogHistoryInfo2.getInputContent();
        if (inputContent != null) {
            sQLiteStatement.bindString(5, inputContent);
        }
        sQLiteStatement.bindString(6, diagLogHistoryInfo2.getSerialNo());
        sQLiteStatement.bindLong(7, diagLogHistoryInfo2.getReaded());
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(DiagLogHistoryInfo diagLogHistoryInfo) {
        DiagLogHistoryInfo diagLogHistoryInfo2 = diagLogHistoryInfo;
        if (diagLogHistoryInfo2 != null) {
            return Long.valueOf(Long.parseLong(diagLogHistoryInfo2.getLogId()));
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, DiagLogHistoryInfo diagLogHistoryInfo, int i) {
        DiagLogHistoryInfo diagLogHistoryInfo2 = diagLogHistoryInfo;
        int i2 = i + 0;
        diagLogHistoryInfo2.setLogId(cursor.isNull(i2) ? "" : String.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        diagLogHistoryInfo2.setLogName(cursor.isNull(i3) ? "" : cursor.getString(i3));
        int i4 = i + 2;
        diagLogHistoryInfo2.setCurrentState(cursor.isNull(i4) ? 0 : cursor.getInt(i4));
        int i5 = i + 3;
        diagLogHistoryInfo2.setFeedbackTime(cursor.isNull(i5) ? "" : cursor.getString(i5));
        int i6 = i + 4;
        diagLogHistoryInfo2.setInputContent(cursor.isNull(i6) ? "" : cursor.getString(i6));
        int i7 = i + 5;
        diagLogHistoryInfo2.setSerialNo(cursor.isNull(i7) ? "" : cursor.getString(i7));
        int i8 = i + 6;
        diagLogHistoryInfo2.setReaded(cursor.isNull(i8) ? 0 : cursor.getInt(i8));
    }

    public DiagLogHistoryInfoDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        super(daoConfig, abstractDaoSession);
    }

    /* renamed from: a */
    public static void m5058a(SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'DIAGLOG_HISTORY_INFO' ('_id' INTEGER PRIMARY KEY  ,'LOG_NAME' TEXT NOT NULL,'CURRENT_STATE' INTEGER,'FEEDBACK_TIME' TEXT NOT NULL ,'INPUT_CONTENT' TEXT  ,'SERIAL_NO' TEXT NOT NULL   ,'READED' INTEGER );");
    }

    /* renamed from: a */
    public static void m5059a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'DIAGLOG_HISTORY_INFO'");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(DiagLogHistoryInfo diagLogHistoryInfo, long j) {
        return Long.valueOf(j);
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
    public /* synthetic */ DiagLogHistoryInfo readEntity(Cursor cursor, int i) {
        DiagLogHistoryInfo diagLogHistoryInfo = new DiagLogHistoryInfo();
        int i2 = i + 0;
        diagLogHistoryInfo.setLogId(cursor.isNull(i2) ? "" : String.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        diagLogHistoryInfo.setLogName(cursor.isNull(i3) ? "" : cursor.getString(i3));
        int i4 = i + 2;
        diagLogHistoryInfo.setCurrentState(cursor.isNull(i4) ? 0 : cursor.getInt(i4));
        int i5 = i + 3;
        diagLogHistoryInfo.setFeedbackTime(cursor.isNull(i5) ? "" : cursor.getString(i5));
        int i6 = i + 4;
        diagLogHistoryInfo.setInputContent(cursor.isNull(i6) ? "" : cursor.getString(i6));
        int i7 = i + 5;
        diagLogHistoryInfo.setSerialNo(cursor.isNull(i7) ? "" : cursor.getString(i7));
        int i8 = i + 6;
        diagLogHistoryInfo.setReaded(cursor.isNull(i8) ? 0 : cursor.getInt(i8));
        return diagLogHistoryInfo;
    }
}
