package com.cnlaunch.p169im.p174db;

import android.database.sqlite.SQLiteDatabase;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;
import message.model.ChatMessage;

/* renamed from: com.cnlaunch.im.db.d */
/* loaded from: classes.dex */
public final class GoloDaoSession extends AbstractDaoSession {

    /* renamed from: a */
    public final MessageDao f9224a;

    /* renamed from: b */
    public final GoloRemoteOrderInfoDao f9225b;

    /* renamed from: c */
    public final FriendInfoDao f9226c;

    /* renamed from: d */
    public final VerificationInfoDao f9227d;

    /* renamed from: e */
    public final MessageInfoDao f9228e;

    /* renamed from: f */
    public final UserBaseInfoDao f9229f;

    /* renamed from: g */
    private final DaoConfig f9230g;

    /* renamed from: h */
    private final DaoConfig f9231h;

    /* renamed from: i */
    private final DaoConfig f9232i;

    /* renamed from: j */
    private final DaoConfig f9233j;

    /* renamed from: k */
    private final DaoConfig f9234k;

    /* renamed from: l */
    private final DaoConfig f9235l;

    public GoloDaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f9230g = map.get(MessageDao.class).m15315clone();
        this.f9230g.initIdentityScope(identityScopeType);
        this.f9224a = new MessageDao(this.f9230g, this);
        registerDao(ChatMessage.class, this.f9224a);
        this.f9231h = map.get(GoloRemoteOrderInfoDao.class).m15315clone();
        this.f9231h.initIdentityScope(identityScopeType);
        this.f9225b = new GoloRemoteOrderInfoDao(this.f9231h, this);
        registerDao(GoloRemoteOrderInfo.class, this.f9225b);
        this.f9232i = map.get(FriendInfoDao.class).m15315clone();
        this.f9232i.initIdentityScope(identityScopeType);
        this.f9226c = new FriendInfoDao(this.f9232i, this);
        registerDao(FriendInfo.class, this.f9226c);
        this.f9233j = map.get(VerificationInfoDao.class).m15315clone();
        this.f9233j.initIdentityScope(identityScopeType);
        this.f9227d = new VerificationInfoDao(this.f9233j, this);
        registerDao(VerificationInfo.class, this.f9227d);
        this.f9234k = map.get(MessageInfoDao.class).m15315clone();
        this.f9234k.initIdentityScope(identityScopeType);
        this.f9228e = new MessageInfoDao(this.f9234k, this);
        registerDao(MessageInfo.class, this.f9228e);
        this.f9235l = map.get(UserBaseInfoDao.class).m15315clone();
        this.f9235l.initIdentityScope(identityScopeType);
        this.f9229f = new UserBaseInfoDao(this.f9235l, this);
        registerDao(UserBaseInfo.class, this.f9229f);
    }
}
