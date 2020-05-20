package de.greenrobot.dao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.FastCursor;
import de.greenrobot.dao.internal.TableStatements;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;

    /* renamed from: db */
    protected final SQLiteDatabase f23923db;
    protected IdentityScope<K, T> identityScope;
    protected IdentityScopeLong<T> identityScopeLong;
    protected final int pkOrdinal;
    protected final AbstractDaoSession session;
    protected TableStatements statements;

    protected void attachEntity(T t) {
    }

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K getKey(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isEntityUpdateable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, T t, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K readKey(Cursor cursor, int i);

    protected abstract K updateKeyAfterInsert(T t, long j);

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        this.f23923db = daoConfig.f23926db;
        this.identityScope = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) identityScope;
        }
        this.statements = daoConfig.statements;
        this.pkOrdinal = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        return (identityScope == null || (t = identityScope.get(k)) == null) ? loadUniqueAndCloseCursor(this.f23923db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()})) : t;
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.f23923db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    protected T loadUnique(Cursor cursor) {
        if (cursor.moveToFirst()) {
            if (!cursor.isLast()) {
                throw new DaoException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrent(cursor, 0, true);
        }
        return null;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.f23923db.rawQuery(this.statements.getSelectAll(), null));
    }

    public boolean detach(T t) {
        if (this.identityScope != null) {
            return this.identityScope.detach(getKeyVerified(t), t);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    private void executeInsertInTx(SQLiteStatement sQLiteStatement, Iterable<T> iterable, boolean z) {
        this.f23923db.beginTransaction();
        try {
            synchronized (sQLiteStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    for (T t : iterable) {
                        bindValues(sQLiteStatement, t);
                        if (z) {
                            updateKeyAfterInsertAndAttach(t, sQLiteStatement.executeInsert(), false);
                        } else {
                            sQLiteStatement.execute();
                        }
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.f23923db.setTransactionSuccessful();
        } finally {
            this.f23923db.endTransaction();
        }
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement());
    }

    public long insertWithoutSettingPk(T t) {
        long executeInsert;
        SQLiteStatement insertStatement = this.statements.getInsertStatement();
        if (this.f23923db.isDbLockedByCurrentThread()) {
            synchronized (insertStatement) {
                bindValues(insertStatement, t);
                executeInsert = insertStatement.executeInsert();
            }
        } else {
            this.f23923db.beginTransaction();
            try {
                synchronized (insertStatement) {
                    bindValues(insertStatement, t);
                    executeInsert = insertStatement.executeInsert();
                }
                this.f23923db.setTransactionSuccessful();
            } finally {
                this.f23923db.endTransaction();
            }
        }
        return executeInsert;
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement());
    }

    private long executeInsert(T t, SQLiteStatement sQLiteStatement) {
        long executeInsert;
        if (this.f23923db.isDbLockedByCurrentThread()) {
            synchronized (sQLiteStatement) {
                bindValues(sQLiteStatement, t);
                executeInsert = sQLiteStatement.executeInsert();
            }
        } else {
            this.f23923db.beginTransaction();
            try {
                synchronized (sQLiteStatement) {
                    bindValues(sQLiteStatement, t);
                    executeInsert = sQLiteStatement.executeInsert();
                }
                this.f23923db.setTransactionSuccessful();
            } finally {
                this.f23923db.endTransaction();
            }
        }
        updateKeyAfterInsertAndAttach(t, executeInsert, true);
        return executeInsert;
    }

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.m324w("Could not insert row (executeInsert returned -1)");
        }
    }

    protected List<T> loadAllFromCursor(Cursor cursor) {
        CursorWindow window;
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList(count);
        if ((cursor instanceof CrossProcessCursor) && (window = ((CrossProcessCursor) cursor).getWindow()) != null) {
            if (window.getNumRows() == count) {
                cursor = new FastCursor(window);
            } else {
                DaoLog.m332d("Window vs. result size: " + window.getNumRows() + "/" + count);
            }
        }
        if (cursor.moveToFirst()) {
            IdentityScope<K, T> identityScope = this.identityScope;
            if (identityScope != null) {
                identityScope.lock();
                this.identityScope.reserveRoom(count);
            }
            do {
                try {
                    arrayList.add(loadCurrent(cursor, 0, false));
                } finally {
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                }
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i == 0 || !cursor.isNull(this.pkOrdinal + i)) {
                long j = cursor.getLong(this.pkOrdinal + i);
                T t = z ? this.identityScopeLong.get2(j) : this.identityScopeLong.get2NoLock(j);
                if (t != null) {
                    return t;
                }
                T readEntity = readEntity(cursor, i);
                if (z) {
                    this.identityScopeLong.put2(j, readEntity);
                } else {
                    this.identityScopeLong.put2NoLock(j, readEntity);
                }
                attachEntity(readEntity);
                return readEntity;
            }
            return null;
        } else if (this.identityScope != null) {
            K readKey = readKey(cursor, i);
            if (i == 0 || readKey != null) {
                T noLock = z ? this.identityScope.get(readKey) : this.identityScope.getNoLock(readKey);
                if (noLock != null) {
                    return noLock;
                }
                T readEntity2 = readEntity(cursor, i);
                attachEntity(readKey, readEntity2, z);
                return readEntity2;
            }
            return null;
        } else if (i == 0 || readKey(cursor, i) != null) {
            T readEntity3 = readEntity(cursor, i);
            attachEntity(readEntity3);
            return readEntity3;
        } else {
            return null;
        }
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    public List<T> queryRaw(String str, String... strArr) {
        SQLiteDatabase sQLiteDatabase = this.f23923db;
        return loadAllAndCloseCursor(sQLiteDatabase.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public void deleteAll() {
        SQLiteDatabase sQLiteDatabase = this.f23923db;
        sQLiteDatabase.execSQL("DELETE FROM '" + this.config.tablename + "'");
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        SQLiteStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.f23923db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.f23923db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.f23923db.setTransactionSuccessful();
            } finally {
                this.f23923db.endTransaction();
            }
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.remove((IdentityScope<K, T>) k);
        }
    }

    private void deleteByKeyInsideSynchronized(K k, SQLiteStatement sQLiteStatement) {
        if (k instanceof Long) {
            sQLiteStatement.bindLong(1, ((Long) k).longValue());
        } else if (k == null) {
            throw new DaoException("Cannot delete entity, key is null");
        } else {
            sQLiteStatement.bindString(1, k.toString());
        }
        sQLiteStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        assertSinglePk();
        SQLiteStatement deleteStatement = this.statements.getDeleteStatement();
        this.f23923db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    for (T t : iterable) {
                        K keyVerified = getKeyVerified(t);
                        deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(keyVerified);
                        }
                    }
                }
                if (iterable2 != null) {
                    for (K k : iterable2) {
                        deleteByKeyInsideSynchronized(k, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(k);
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.f23923db.setTransactionSuccessful();
            if (arrayList != null && this.identityScope != null) {
                this.identityScope.remove((Iterable) arrayList);
            }
        } finally {
            this.f23923db.endTransaction();
        }
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void refresh(T t) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.f23923db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            } else if (!rawQuery.isLast()) {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            } else {
                readEntity(rawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            }
        } finally {
            rawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        SQLiteStatement updateStatement = this.statements.getUpdateStatement();
        if (this.f23923db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            return;
        }
        this.f23923db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            this.f23923db.setTransactionSuccessful();
        } finally {
            this.f23923db.endTransaction();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, t);
        int length = this.config.allColumns.length + 1;
        K key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            sQLiteStatement.bindString(length, key.toString());
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    protected final void attachEntity(K k, T t, boolean z) {
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null && k != null) {
            if (z) {
                identityScope.put(k, t);
            } else {
                identityScope.putNoLock(k, t);
            }
        }
        attachEntity(t);
    }

    public void updateInTx(Iterable<T> iterable) {
        SQLiteStatement updateStatement = this.statements.getUpdateStatement();
        this.f23923db.beginTransaction();
        try {
            synchronized (updateStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                for (T t : iterable) {
                    updateInsideSynchronized(t, updateStatement, false);
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.f23923db.setTransactionSuccessful();
        } finally {
            this.f23923db.endTransaction();
        }
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length == 1) {
            return;
        }
        throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
    }

    public long count() {
        SQLiteDatabase sQLiteDatabase = this.f23923db;
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "'" + this.config.tablename + '\'');
    }

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key == null) {
            if (t == null) {
                throw new NullPointerException("Entity may not be null");
            }
            throw new DaoException("Entity has no key");
        }
        return key;
    }

    public SQLiteDatabase getDatabase() {
        return this.f23923db;
    }
}
