package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import java.util.List;

/* loaded from: classes2.dex */
public class Query<T> extends AbstractQuery<T> {
    private final int limitPosition;
    private final int offsetPosition;
    private final ThreadLocalQuery<T> threadLocalQuery;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ThreadLocalQuery<T2> extends ThreadLocal<Query<T2>> {
        private final AbstractDao<T2, ?> dao;
        private final String[] initialValues;
        private final int limitPosition;
        private final int offsetPosition;
        private final String sql;

        private ThreadLocalQuery(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i, int i2) {
            this.dao = abstractDao;
            this.sql = str;
            this.initialValues = strArr;
            this.limitPosition = i;
            this.offsetPosition = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final Query<T2> initialValue() {
            return new Query<>(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T2> Query<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i, int i2) {
        return new ThreadLocalQuery(abstractDao, str, toStringArray(objArr), i, i2).get();
    }

    private Query(ThreadLocalQuery<T> threadLocalQuery, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr);
        this.threadLocalQuery = threadLocalQuery;
        this.limitPosition = i;
        this.offsetPosition = i2;
    }

    public Query<T> forCurrentThread() {
        Query<T> query = (Query) this.threadLocalQuery.get();
        String[] strArr = ((ThreadLocalQuery) this.threadLocalQuery).initialValues;
        System.arraycopy(strArr, 0, query.parameters, 0, strArr.length);
        return query;
    }

    @Override // de.greenrobot.dao.query.AbstractQuery
    public void setParameter(int i, Object obj) {
        if (i >= 0 && (i == this.limitPosition || i == this.offsetPosition)) {
            throw new IllegalArgumentException("Illegal parameter index: ".concat(String.valueOf(i)));
        }
        super.setParameter(i, obj);
    }

    public void setLimit(int i) {
        checkThread();
        if (this.limitPosition == -1) {
            throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        }
        this.parameters[this.limitPosition] = Integer.toString(i);
    }

    public void setOffset(int i) {
        checkThread();
        if (this.offsetPosition == -1) {
            throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        }
        this.parameters[this.offsetPosition] = Integer.toString(i);
    }

    public List<T> list() {
        checkThread();
        return this.daoAccess.loadAllAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public LazyList<T> listLazy() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), true);
    }

    public LazyList<T> listLazyUncached() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), false);
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public T unique() {
        checkThread();
        return this.daoAccess.loadUniqueAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }
}
