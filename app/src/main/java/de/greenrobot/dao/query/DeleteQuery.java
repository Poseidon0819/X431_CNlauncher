package de.greenrobot.dao.query;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;

/* loaded from: classes2.dex */
public class DeleteQuery<T> extends AbstractQuery<T> {
    private SQLiteStatement compiledStatement;
    private final ThreadLocalQuery<T> threadLocalQuery;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ThreadLocalQuery<T2> extends ThreadLocal<DeleteQuery<T2>> {
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
        public final DeleteQuery<T2> initialValue() {
            return new DeleteQuery<>(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    @Override // de.greenrobot.dao.query.AbstractQuery
    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return new ThreadLocalQuery(abstractDao, str, toStringArray(objArr)).get();
    }

    private DeleteQuery(ThreadLocalQuery<T> threadLocalQuery, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.threadLocalQuery = threadLocalQuery;
    }

    public DeleteQuery<T> forCurrentThread() {
        DeleteQuery<T> deleteQuery = (DeleteQuery) this.threadLocalQuery.get();
        String[] strArr = ((ThreadLocalQuery) this.threadLocalQuery).initialValues;
        System.arraycopy(strArr, 0, deleteQuery.parameters, 0, strArr.length);
        return deleteQuery;
    }

    public void executeDeleteWithoutDetachingEntities() {
        checkThread();
        SQLiteDatabase database = this.dao.getDatabase();
        if (database.isDbLockedByCurrentThread()) {
            executeDeleteWithoutDetachingEntitiesInsideTx();
            return;
        }
        database.beginTransaction();
        try {
            executeDeleteWithoutDetachingEntitiesInsideTx();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private synchronized void executeDeleteWithoutDetachingEntitiesInsideTx() {
        if (this.compiledStatement != null) {
            this.compiledStatement.clearBindings();
        } else {
            this.compiledStatement = this.dao.getDatabase().compileStatement(this.sql);
        }
        for (int i = 0; i < this.parameters.length; i++) {
            String str = this.parameters[i];
            if (str != null) {
                this.compiledStatement.bindString(i + 1, str);
            } else {
                this.compiledStatement.bindNull(i + 1);
            }
        }
        this.compiledStatement.execute();
    }
}
