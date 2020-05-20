package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.p283db.FavoritesCarIconDao;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.e */
/* loaded from: classes.dex */
public final class FavoritesDaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m5031a(SQLiteDatabase sQLiteDatabase, boolean z) {
        FavoritesCarIconDao.m5055a(sQLiteDatabase, z);
    }

    /* compiled from: FavoritesDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.e$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2760b extends SQLiteOpenHelper {
        public AbstractC2760b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            NLog.m9452b("greenDAO", "Creating tables for schema version 3");
            FavoritesDaoMaster.m5031a(sQLiteDatabase, false);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            NLog.m9456a("greenDAO", "FavoritesDaoMaster download schema from version " + i + " to " + i2);
            FavoritesDaoMaster.m5031a(sQLiteDatabase, true);
        }
    }

    /* compiled from: FavoritesDaoMaster.java */
    /* renamed from: com.cnlaunch.x431pro.utils.db.a.e$a */
    /* loaded from: classes.dex */
    public static class C2759a extends AbstractC2760b {

        /* renamed from: a */
        private Context f15813a;

        public C2759a(Context context, String str) {
            super(context, str);
            this.f15813a = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            NLog.m9452b("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            FavoritesCarIconDao.m5056a(sQLiteDatabase);
            FavoritesCarIconDao.m5055a(sQLiteDatabase, true);
        }

        @Override // com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDaoMaster.AbstractC2760b, android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            super.onCreate(sQLiteDatabase);
            NLog.m9452b("greenDAO", "new Creating tables for schema version 3");
        }
    }

    public FavoritesDaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 3);
        registerDaoClass(FavoritesCarIconDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final FavoritesDaoSession newSession() {
        return new FavoritesDaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new FavoritesDaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
