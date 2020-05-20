package com.cnlaunch.gmap.p138a.p139a;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.gmap.a.a.g */
/* loaded from: classes.dex */
public final class C1496g<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AsyncTask f7381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1496g(AsyncTask asyncTask, Callable callable) {
        super(callable);
        this.f7381a = asyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        try {
            AsyncTask.m9394b(this.f7381a, get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            AsyncTask.m9394b(this.f7381a, null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        }
    }
}
