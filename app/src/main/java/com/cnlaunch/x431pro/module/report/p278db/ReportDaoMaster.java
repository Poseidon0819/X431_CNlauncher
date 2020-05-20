package com.cnlaunch.x431pro.module.report.p278db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.x431pro.module.report.db.b */
/* loaded from: classes.dex */
public final class ReportDaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m5215a(SQLiteDatabase sQLiteDatabase) {
        UpLoadReportInfoDao.m5219a(sQLiteDatabase);
    }

    /* renamed from: b */
    public static void m5214b(SQLiteDatabase sQLiteDatabase) {
        UpLoadReportInfoDao.m5218b(sQLiteDatabase);
    }

    /* compiled from: ReportDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.module.report.db.b$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2736b extends SQLiteOpenHelper {
        public AbstractC2736b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.i("greenDAO", "Creating tables for schema version 2");
            ReportDaoMaster.m5215a(sQLiteDatabase);
        }
    }

    /* compiled from: ReportDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.module.report.db.b$a */
    /* loaded from: classes.dex */
    public static class C2735a extends AbstractC2736b {
        public C2735a(Context context, String str) {
            super(context, str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            ReportDaoMaster.m5214b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public ReportDaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 2);
        registerDaoClass(UpLoadReportInfoDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final ReportDaoSession newSession() {
        return new ReportDaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new ReportDaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
