package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.database.sqlite.SQLiteDatabase;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.FavoritesCarIconDao;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.f */
/* loaded from: classes.dex */
public final class FavoritesDaoSession extends AbstractDaoSession {

    /* renamed from: a */
    public final FavoritesCarIconDao f15814a;

    /* renamed from: b */
    private final DaoConfig f15815b;

    public FavoritesDaoSession(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.f15815b = map.get(FavoritesCarIconDao.class).m15315clone();
        this.f15815b.initIdentityScope(identityScopeType);
        this.f15814a = new FavoritesCarIconDao(this.f15815b, this);
        registerDao(CarIcon.class, this.f15814a);
    }
}
