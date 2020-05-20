package message.p382e;

import message.p384g.LogUtilMsg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloService.java */
/* renamed from: message.e.c */
/* loaded from: classes2.dex */
public final class RunnableC4727c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GoloService f23989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4727c(GoloService goloService) {
        this.f23989a = goloService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogUtilMsg.m227a("login>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", "schedule");
        GoloService.m271g();
    }
}
