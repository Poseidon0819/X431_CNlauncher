package com.cnlaunch.x431pro.module.report.p278db;

import android.database.sqlite.SQLiteDatabase;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.module.report.db.c */
/* loaded from: classes.dex */
public final class ReportDaoSession extends AbstractDaoSession {

    /* renamed from: a */
    final UpLoadReportInfoDao f15672a;

    /* renamed from: b */
    private final DaoConfig f15673b;

    public ReportDaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f15673b = map.get(UpLoadReportInfoDao.class).m15315clone();
        this.f15673b.initIdentityScope(identityScopeType);
        this.f15672a = new UpLoadReportInfoDao(this.f15673b, this);
        registerDao(UpLoadReportInfo.class, this.f15672a);
    }
}
