package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.query.Query;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AsyncOperationExecutor implements Handler.Callback, Runnable {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
    private volatile int maxOperationCountToMerge = 50;
    private volatile int waitForMergeMillis = 50;

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i = this.lastSequenceNumber + 1;
            this.lastSequenceNumber = i;
            asyncOperation.sequenceNumber = i;
            this.queue.add(asyncOperation);
            this.countOperationsEnqueued++;
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public void setMaxOperationCountToMerge(int i) {
        this.maxOperationCountToMerge = i;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    public void setWaitForMergeMillis(int i) {
        this.waitForMergeMillis = i;
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public synchronized boolean isCompleted() {
        return this.countOperationsEnqueued == this.countOperationsCompleted;
    }

    public synchronized void waitForCompletion() {
        while (!isCompleted()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!isCompleted()) {
            try {
                wait(i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
        return isCompleted();
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.queue.poll(1L, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = this.queue.poll();
                        if (poll2 == null) {
                            return;
                        }
                    }
                }
                if (poll2 != null) {
                    if (poll2.isMergeTx() && (poll = this.queue.poll(this.waitForMergeMillis, TimeUnit.MILLISECONDS)) != null) {
                        if (poll2.isMergeableWith(poll)) {
                            mergeTxAndExecute(poll2, poll);
                        } else {
                            executeOperationAndPostCompleted(poll2);
                            executeOperationAndPostCompleted(poll);
                        }
                    } else {
                        executeOperationAndPostCompleted(poll2);
                    }
                }
            } catch (InterruptedException e) {
                DaoLog.m323w(Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.executorRunning = false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        throw new de.greenrobot.dao.DaoException("Internal error: peeked op did not match removed op");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeTxAndExecute(de.greenrobot.dao.async.AsyncOperation r6, de.greenrobot.dao.async.AsyncOperation r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r6)
            r0.add(r7)
            android.database.sqlite.SQLiteDatabase r6 = r6.getDatabase()
            r6.beginTransaction()
            r7 = 0
            r1 = 0
        L14:
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L9e
            r3 = 1
            if (r1 >= r2) goto L61
            java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L9e
            de.greenrobot.dao.async.AsyncOperation r2 = (de.greenrobot.dao.async.AsyncOperation) r2     // Catch: java.lang.Throwable -> L9e
            r5.executeOperation(r2)     // Catch: java.lang.Throwable -> L9e
            boolean r4 = r2.isFailed()     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L2c
            r7 = 1
            goto L61
        L2c:
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L9e
            int r4 = r4 - r3
            if (r1 != r4) goto L5e
            java.util.concurrent.BlockingQueue<de.greenrobot.dao.async.AsyncOperation> r3 = r5.queue     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r3 = r3.peek()     // Catch: java.lang.Throwable -> L9e
            de.greenrobot.dao.async.AsyncOperation r3 = (de.greenrobot.dao.async.AsyncOperation) r3     // Catch: java.lang.Throwable -> L9e
            int r4 = r5.maxOperationCountToMerge     // Catch: java.lang.Throwable -> L9e
            if (r1 >= r4) goto L5b
            boolean r2 = r2.isMergeableWith(r3)     // Catch: java.lang.Throwable -> L9e
            if (r2 == 0) goto L5b
            java.util.concurrent.BlockingQueue<de.greenrobot.dao.async.AsyncOperation> r2 = r5.queue     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r2 = r2.remove()     // Catch: java.lang.Throwable -> L9e
            de.greenrobot.dao.async.AsyncOperation r2 = (de.greenrobot.dao.async.AsyncOperation) r2     // Catch: java.lang.Throwable -> L9e
            if (r2 != r3) goto L53
            r0.add(r2)     // Catch: java.lang.Throwable -> L9e
            goto L5e
        L53:
            de.greenrobot.dao.DaoException r7 = new de.greenrobot.dao.DaoException     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = "Internal error: peeked op did not match removed op"
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L9e
            throw r7     // Catch: java.lang.Throwable -> L9e
        L5b:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9e
        L5e:
            int r1 = r1 + 1
            goto L14
        L61:
            r6.endTransaction()
            if (r7 == 0) goto L83
            java.lang.String r6 = "Revered merged transaction because one of the operations failed. Executing operations one by one instead..."
            de.greenrobot.dao.DaoLog.m328i(r6)
            java.util.Iterator r6 = r0.iterator()
        L6f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L82
            java.lang.Object r7 = r6.next()
            de.greenrobot.dao.async.AsyncOperation r7 = (de.greenrobot.dao.async.AsyncOperation) r7
            r7.reset()
            r5.executeOperationAndPostCompleted(r7)
            goto L6f
        L82:
            return
        L83:
            int r6 = r0.size()
            java.util.Iterator r7 = r0.iterator()
        L8b:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L9d
            java.lang.Object r0 = r7.next()
            de.greenrobot.dao.async.AsyncOperation r0 = (de.greenrobot.dao.async.AsyncOperation) r0
            r0.mergedOperationsCount = r6
            r5.handleOperationCompleted(r0)
            goto L8b
        L9d:
            return
        L9e:
            r7 = move-exception
            r6.endTransaction()
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.dao.async.AsyncOperationExecutor.mergeTxAndExecute(de.greenrobot.dao.async.AsyncOperation, de.greenrobot.dao.async.AsyncOperation):void");
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.setCompleted();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            this.handlerMainThread.sendMessage(this.handlerMainThread.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            this.countOperationsCompleted++;
            if (this.countOperationsCompleted == this.countOperationsEnqueued) {
                notifyAll();
            }
        }
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        executeOperation(asyncOperation);
        handleOperationCompleted(asyncOperation);
    }

    private void executeOperation(AsyncOperation asyncOperation) {
        asyncOperation.timeStarted = System.currentTimeMillis();
        try {
            switch (asyncOperation.type) {
                case Delete:
                    asyncOperation.dao.delete(asyncOperation.parameter);
                    break;
                case DeleteInTxIterable:
                    asyncOperation.dao.deleteInTx((Iterable) asyncOperation.parameter);
                    break;
                case DeleteInTxArray:
                    asyncOperation.dao.deleteInTx((Object[]) asyncOperation.parameter);
                    break;
                case Insert:
                    asyncOperation.dao.insert(asyncOperation.parameter);
                    break;
                case InsertInTxIterable:
                    asyncOperation.dao.insertInTx((Iterable) asyncOperation.parameter);
                    break;
                case InsertInTxArray:
                    asyncOperation.dao.insertInTx((Object[]) asyncOperation.parameter);
                    break;
                case InsertOrReplace:
                    asyncOperation.dao.insertOrReplace(asyncOperation.parameter);
                    break;
                case InsertOrReplaceInTxIterable:
                    asyncOperation.dao.insertOrReplaceInTx((Iterable) asyncOperation.parameter);
                    break;
                case InsertOrReplaceInTxArray:
                    asyncOperation.dao.insertOrReplaceInTx((Object[]) asyncOperation.parameter);
                    break;
                case Update:
                    asyncOperation.dao.update(asyncOperation.parameter);
                    break;
                case UpdateInTxIterable:
                    asyncOperation.dao.updateInTx((Iterable) asyncOperation.parameter);
                    break;
                case UpdateInTxArray:
                    asyncOperation.dao.updateInTx((Object[]) asyncOperation.parameter);
                    break;
                case TransactionRunnable:
                    executeTransactionRunnable(asyncOperation);
                    break;
                case TransactionCallable:
                    executeTransactionCallable(asyncOperation);
                    break;
                case QueryList:
                    asyncOperation.result = ((Query) asyncOperation.parameter).list();
                    break;
                case QueryUnique:
                    asyncOperation.result = ((Query) asyncOperation.parameter).unique();
                    break;
                case DeleteByKey:
                    asyncOperation.dao.deleteByKey(asyncOperation.parameter);
                    break;
                case DeleteAll:
                    asyncOperation.dao.deleteAll();
                    break;
                case Load:
                    asyncOperation.result = asyncOperation.dao.load(asyncOperation.parameter);
                    break;
                case LoadAll:
                    asyncOperation.result = asyncOperation.dao.loadAll();
                    break;
                case Count:
                    asyncOperation.result = Long.valueOf(asyncOperation.dao.count());
                    break;
                case Refresh:
                    asyncOperation.dao.refresh(asyncOperation.parameter);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.type);
            }
        } catch (Throwable th) {
            asyncOperation.throwable = th;
        }
        asyncOperation.timeCompleted = System.currentTimeMillis();
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        SQLiteDatabase database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            ((Runnable) asyncOperation.parameter).run();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        SQLiteDatabase database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            asyncOperation.result = ((Callable) asyncOperation.parameter).call();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message2) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message2.obj);
            return false;
        }
        return false;
    }
}
