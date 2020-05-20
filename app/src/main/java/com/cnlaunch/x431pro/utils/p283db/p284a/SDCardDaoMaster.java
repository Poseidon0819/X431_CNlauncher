package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.p283db.DiagReportOrHistoryDao;
import com.cnlaunch.x431pro.utils.p283db.UserInfoDao;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.h */
/* loaded from: classes.dex */
public final class SDCardDaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m5028a(SQLiteDatabase sQLiteDatabase, boolean z) {
        Log.i("msp", "CreateAllTables");
        DiagReportOrHistoryDao.m5057a(sQLiteDatabase, z);
        UserInfoDao.m5039a(sQLiteDatabase, z);
    }

    /* compiled from: SDCardDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.h$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2762b extends SQLiteOpenHelper {
        public AbstractC2762b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            NLog.m9452b("greenDAO", "SDCardDaoMaster Creating tables for schema version 2");
            SDCardDaoMaster.m5028a(sQLiteDatabase, false);
        }
    }

    /* compiled from: SDCardDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.h$a */
    /* loaded from: classes.dex */
    public static class C2761a extends AbstractC2762b {

        /* renamed from: a */
        private Context f15820a;

        public C2761a(Context context, String str) {
            super(context, str);
            this.f15820a = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            NLog.m9452b("greenDAO", "SDCardDaoMaster Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            SDCardDaoMaster.m5028a(sQLiteDatabase, true);
        }

        @Override // com.cnlaunch.x431pro.utils.p283db.p284a.SDCardDaoMaster.AbstractC2762b, android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            super.onCreate(sQLiteDatabase);
            NLog.m9452b("greenDAO", "SDCardDaoMaster new Creating tables for schema version 2");
        }
    }

    public SDCardDaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 2);
        registerDaoClass(DiagReportOrHistoryDao.class);
        registerDaoClass(UserInfoDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final SDCardDaoSession newSession() {
        return new SDCardDaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new SDCardDaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
