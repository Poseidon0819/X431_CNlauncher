package com.cnlaunch.p188n.p190b;

import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;

/* compiled from: SendChecker.java */
/* renamed from: com.cnlaunch.n.b.q */
/* loaded from: classes.dex */
final class C1802q implements IoFutureListener<WriteFuture> {

    /* renamed from: a */
    final /* synthetic */ SendChecker f9628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1802q(SendChecker sendChecker) {
        this.f9628a = sendChecker;
    }

    @Override // org.apache.mina.core.future.IoFutureListener
    public final /* synthetic */ void operationComplete(WriteFuture writeFuture) {
        this.f9628a.f9620g.m8524a();
    }
}
