package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

/* loaded from: classes2.dex */
public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    private volatile boolean completed;
    final AbstractDao<Object, Object> dao;
    private final SQLiteDatabase database;
    final int flags;
    volatile int mergedOperationsCount;
    final Object parameter;
    volatile Object result;
    int sequenceNumber;
    volatile Throwable throwable;
    volatile long timeCompleted;
    volatile long timeStarted;
    final OperationType type;

    /* loaded from: classes2.dex */
    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Object obj, int i) {
        this.type = operationType;
        this.flags = i;
        this.dao = abstractDao;
        this.database = null;
        this.parameter = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncOperation(OperationType operationType, SQLiteDatabase sQLiteDatabase, Object obj, int i) {
        this.type = operationType;
        this.database = sQLiteDatabase;
        this.flags = i;
        this.dao = null;
        this.parameter = obj;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public OperationType getType() {
        return this.type;
    }

    public Object getParameter() {
        return this.parameter;
    }

    public synchronized Object getResult() {
        if (!this.completed) {
            waitForCompletion();
        }
        if (this.throwable != null) {
            throw new AsyncDaoException(this, this.throwable);
        }
        return this.result;
    }

    public boolean isMergeTx() {
        return (this.flags & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase = this.database;
        return sQLiteDatabase != null ? sQLiteDatabase : this.dao.getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMergeableWith(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && getDatabase() == asyncOperation.getDatabase();
    }

    public long getTimeStarted() {
        return this.timeStarted;
    }

    public long getTimeCompleted() {
        return this.timeCompleted;
    }

    public long getDuration() {
        if (this.timeCompleted == 0) {
            throw new DaoException("This operation did not yet complete");
        }
        return this.timeCompleted - this.timeStarted;
    }

    public boolean isFailed() {
        return this.throwable != null;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public synchronized Object waitForCompletion() {
        while (!this.completed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.result;
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!this.completed) {
            try {
                wait(i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.completed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setCompleted() {
        this.completed = true;
        notifyAll();
    }

    public boolean isCompletedSucessfully() {
        return this.completed && this.throwable == null;
    }

    public int getMergedOperationsCount() {
        return this.mergedOperationsCount;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.timeStarted = 0L;
        this.timeCompleted = 0L;
        this.completed = false;
        this.throwable = null;
        this.result = null;
        this.mergedOperationsCount = 0;
    }
}
