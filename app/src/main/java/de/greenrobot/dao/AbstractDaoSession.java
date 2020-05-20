package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.async.AsyncSession;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class AbstractDaoSession {

    /* renamed from: db */
    private final SQLiteDatabase f23925db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao = new HashMap();

    public AbstractDaoSession(SQLiteDatabase sQLiteDatabase) {
        this.f23925db = sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(cls, abstractDao);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insert(T t) {
        return getDao(t.getClass()).insert(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insertOrReplace(T t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void refresh(T t) {
        getDao(t.getClass()).refresh(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void update(T t) {
        getDao(t.getClass()).update(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void delete(T t) {
        getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T, K> T load(Class<T> cls, K k) {
        return (T) getDao(cls).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return (List<T>) getDao(cls).loadAll();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return (List<T>) getDao(cls).queryRaw(str, strArr);
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return (QueryBuilder<T>) getDao(cls).queryBuilder();
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.entityToDao.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for ".concat(String.valueOf(cls)));
    }

    public void runInTx(Runnable runnable) {
        this.f23925db.beginTransaction();
        try {
            runnable.run();
            this.f23925db.setTransactionSuccessful();
        } finally {
            this.f23925db.endTransaction();
        }
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f23925db.beginTransaction();
        try {
            V call = callable.call();
            this.f23925db.setTransactionSuccessful();
            return call;
        } finally {
            this.f23925db.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f23925db.beginTransaction();
        try {
            try {
                V call = callable.call();
                this.f23925db.setTransactionSuccessful();
                return call;
            } catch (Exception e) {
                throw new DaoException("Callable failed", e);
            }
        } finally {
            this.f23925db.endTransaction();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.f23925db;
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }
}
