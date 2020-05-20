package message;

import message.xmpp.XConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XConnectionHelper.java */
/* renamed from: message.b */
/* loaded from: classes2.dex */
public final class RunnableC4722b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ XConnectionHelper f23965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4722b(XConnectionHelper xConnectionHelper) {
        this.f23965a = xConnectionHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        XConnection.getInstance().disConnect();
    }
}
