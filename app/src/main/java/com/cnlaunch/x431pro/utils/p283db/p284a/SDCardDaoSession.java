package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.database.sqlite.SQLiteDatabase;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.p283db.DiagReportOrHistoryDao;
import com.cnlaunch.x431pro.utils.p283db.UserInfoDao;
import com.cnlaunch.x431pro.utils.p283db.UserInfoTable;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.i */
/* loaded from: classes.dex */
public final class SDCardDaoSession extends AbstractDaoSession {

    /* renamed from: a */
    public final DiagReportOrHistoryDao f15821a;

    /* renamed from: b */
    private final DaoConfig f15822b;

    /* renamed from: c */
    private final DaoConfig f15823c;

    /* renamed from: d */
    private final UserInfoDao f15824d;

    public SDCardDaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f15822b = map.get(DiagReportOrHistoryDao.class).m15315clone();
        this.f15822b.initIdentityScope(identityScopeType);
        this.f15821a = new DiagReportOrHistoryDao(this.f15822b, this);
        registerDao(DiagReportOrHistoryInfo.class, this.f15821a);
        this.f15823c = map.get(UserInfoDao.class).m15315clone();
        this.f15823c.initIdentityScope(identityScopeType);
        this.f15824d = new UserInfoDao(this.f15823c, this);
        registerDao(UserInfoTable.class, this.f15824d);
    }
}
