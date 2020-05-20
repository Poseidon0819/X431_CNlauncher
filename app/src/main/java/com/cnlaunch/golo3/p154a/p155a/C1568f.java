package com.cnlaunch.golo3.p154a.p155a;

import android.os.Process;
import com.cnlaunch.golo3.p154a.p155a.AbstractC1561d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.golo3.a.a.f */
/* loaded from: classes.dex */
public final class C1568f<Params, Result> extends AbstractC1561d.AbstractCallableC1566e<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC1561d f7722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1568f(AbstractC1561d abstractC1561d) {
        super((byte) 0);
        this.f7722a = abstractC1561d;
    }

    @Override // java.util.concurrent.Callable
    public final Result call() throws Exception {
        AtomicBoolean atomicBoolean;
        Object m9234c;
        atomicBoolean = this.f7722a.f7714l;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        AbstractC1561d abstractC1561d = this.f7722a;
        m9234c = abstractC1561d.m9234c(abstractC1561d.mo9238a((Object[]) this.f7720b));
        return (Result) m9234c;
    }
}
