package com.cnlaunch.golo3.p154a.p155a;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.golo3.a.a.g */
/* loaded from: classes.dex */
public final class C1569g<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC1561d f7723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1569g(AbstractC1561d abstractC1561d, Callable callable) {
        super(callable);
        this.f7723a = abstractC1561d;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        try {
            AbstractC1561d.m9237b(this.f7723a, get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            AbstractC1561d.m9237b(this.f7723a, null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        }
    }
}
