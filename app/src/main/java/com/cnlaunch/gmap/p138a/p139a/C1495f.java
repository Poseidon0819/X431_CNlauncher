package com.cnlaunch.gmap.p138a.p139a;

import android.os.Process;
import com.cnlaunch.gmap.p138a.p139a.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.gmap.a.a.f */
/* loaded from: classes.dex */
public final class C1495f<Params, Result> extends AsyncTask.AbstractCallableC1493e<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AsyncTask f7380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1495f(AsyncTask asyncTask) {
        super((byte) 0);
        this.f7380a = asyncTask;
    }

    @Override // java.util.concurrent.Callable
    public final Result call() throws Exception {
        AtomicBoolean atomicBoolean;
        Object m9391c;
        atomicBoolean = this.f7380a.f7372l;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        AsyncTask asyncTask = this.f7380a;
        m9391c = asyncTask.m9391c(asyncTask.mo9395a((Object[]) this.f7378b));
        return (Result) m9391c;
    }
}
