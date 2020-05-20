package de.greenrobot.dao.query;

import android.database.Cursor;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

/* loaded from: classes2.dex */
public class CountQuery<T> extends AbstractQuery<T> {
    private final ThreadLocalQuery<T> threadLocalQuery;

    @Override // de.greenrobot.dao.query.AbstractQuery
    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ThreadLocalQuery<T2> extends ThreadLocal<CountQuery<T2>> {
        private final AbstractDao<T2, ?> dao;
        private final String[] initialValues;
        private final String sql;

        private ThreadLocalQuery(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            this.dao = abstractDao;
            this.sql = str;
            this.initialValues = strArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final CountQuery<T2> initialValue() {
            return new CountQuery<>(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return new ThreadLocalQuery(abstractDao, str, toStringArray(objArr)).get();
    }

    private CountQuery(ThreadLocalQuery<T> threadLocalQuery, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.threadLocalQuery = threadLocalQuery;
    }

    public CountQuery<T> forCurrentThread() {
        CountQuery<T> countQuery = (CountQuery) this.threadLocalQuery.get();
        String[] strArr = ((ThreadLocalQuery) this.threadLocalQuery).initialValues;
        System.arraycopy(strArr, 0, countQuery.parameters, 0, strArr.length);
        return countQuery;
    }

    public long count() {
        checkThread();
        Cursor rawQuery = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (!rawQuery.moveToNext()) {
                throw new DaoException("No result for count");
            }
            if (!rawQuery.isLast()) {
                throw new DaoException("Unexpected row count: " + rawQuery.getCount());
            } else if (rawQuery.getColumnCount() != 1) {
                throw new DaoException("Unexpected column count: " + rawQuery.getColumnCount());
            } else {
                return rawQuery.getLong(0);
            }
        } finally {
            rawQuery.close();
        }
    }
}
