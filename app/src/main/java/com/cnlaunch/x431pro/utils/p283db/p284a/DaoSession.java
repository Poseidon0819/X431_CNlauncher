package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.database.sqlite.SQLiteDatabase;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p283db.CarVersionDao;
import com.cnlaunch.x431pro.utils.p283db.DiagLogHistoryInfoDao;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.c */
/* loaded from: classes.dex */
public final class DaoSession extends AbstractDaoSession {

    /* renamed from: a */
    public final SerialNumberDao f15798a;

    /* renamed from: b */
    public final CarIconDao f15799b;

    /* renamed from: c */
    public final CarVersionDao f15800c;

    /* renamed from: d */
    public final UpdateDownloadLogDao f15801d;

    /* renamed from: e */
    public final DiagLogHistoryInfoDao f15802e;

    /* renamed from: f */
    private final DaoConfig f15803f;

    /* renamed from: g */
    private final DaoConfig f15804g;

    /* renamed from: h */
    private final DaoConfig f15805h;

    /* renamed from: i */
    private final DaoConfig f15806i;

    /* renamed from: j */
    private final DaoConfig f15807j;

    public DaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f15803f = map.get(SerialNumberDao.class).m15315clone();
        this.f15803f.initIdentityScope(identityScopeType);
        this.f15804g = map.get(CarIconDao.class).m15315clone();
        this.f15804g.initIdentityScope(identityScopeType);
        this.f15805h = map.get(CarVersionDao.class).m15315clone();
        this.f15805h.initIdentityScope(identityScopeType);
        this.f15806i = map.get(UpdateDownloadLogDao.class).m15315clone();
        this.f15806i.initIdentityScope(identityScopeType);
        this.f15798a = new SerialNumberDao(this.f15803f, this);
        this.f15799b = new CarIconDao(this.f15804g, this);
        this.f15800c = new CarVersionDao(this.f15805h, this);
        this.f15801d = new UpdateDownloadLogDao(this.f15806i, this);
        this.f15807j = map.get(DiagLogHistoryInfoDao.class).m15315clone();
        this.f15807j.initIdentityScope(identityScopeType);
        this.f15802e = new DiagLogHistoryInfoDao(this.f15807j, this);
        registerDao(SerialNumber.class, this.f15798a);
        registerDao(CarIcon.class, this.f15799b);
        registerDao(CarVersion.class, this.f15800c);
        registerDao(UpdateDownloadLog.class, this.f15801d);
        registerDao(DiagLogHistoryInfo.class, this.f15802e);
    }
}
