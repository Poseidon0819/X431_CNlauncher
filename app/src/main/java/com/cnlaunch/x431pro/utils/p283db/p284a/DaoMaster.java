package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import com.cnlaunch.x431pro.utils.p283db.CarVersionDao;
import com.cnlaunch.x431pro.utils.p283db.DiagLogHistoryInfoDao;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.b */
/* loaded from: classes.dex */
public final class DaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m5034a(SQLiteDatabase sQLiteDatabase) {
        SerialNumberDao.m5052a(sQLiteDatabase, false);
        CarIconDao.m5061a(sQLiteDatabase, false);
        CarVersionDao.m5060a(sQLiteDatabase);
        UpdateDownloadLogDao.m5040a(sQLiteDatabase, false);
        DiagLogHistoryInfoDao.m5058a(sQLiteDatabase, false);
    }

    /* compiled from: DaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.b$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2758b extends SQLiteOpenHelper {
        public AbstractC2758b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 51);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            NLog.m9452b("greenDAO", "Creating tables for schema version 51");
            DaoMaster.m5034a(sQLiteDatabase);
        }
    }

    /* compiled from: DaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.b$a */
    /* loaded from: classes.dex */
    public static class C2757a extends AbstractC2758b {

        /* renamed from: a */
        private Context f15797a;

        public C2757a(Context context, String str) {
            super(context, str);
            this.f15797a = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            NLog.m9452b("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            CarIconDao.m5062a(sQLiteDatabase);
            CarIconDao.m5061a(sQLiteDatabase, true);
            UpdateDownloadLogDao.m5041a(sQLiteDatabase);
            UpdateDownloadLogDao.m5040a(sQLiteDatabase, true);
            DiagLogHistoryInfoDao.m5059a(sQLiteDatabase);
            DiagLogHistoryInfoDao.m5058a(sQLiteDatabase, true);
            SerialNumberDao.m5053a(sQLiteDatabase);
            SerialNumberDao.m5052a(sQLiteDatabase, true);
        }

        @Override // com.cnlaunch.x431pro.utils.p283db.p284a.DaoMaster.AbstractC2758b, android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            super.onCreate(sQLiteDatabase);
            NLog.m9452b("greenDAO", "new Creating tables for schema version 51");
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 51);
        registerDaoClass(SerialNumberDao.class);
        registerDaoClass(CarIconDao.class);
        registerDaoClass(CarVersionDao.class);
        registerDaoClass(UpdateDownloadLogDao.class);
        registerDaoClass(DiagLogHistoryInfoDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final DaoSession newSession() {
        return new DaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
