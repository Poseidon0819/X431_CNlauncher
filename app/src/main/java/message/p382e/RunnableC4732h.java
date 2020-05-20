package message.p382e;

import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.Singlton;
import message.xmpp.XConnection;

/* compiled from: GoloService.java */
/* renamed from: message.e.h */
/* loaded from: classes2.dex */
final class RunnableC4732h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4731g f23996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4732h(C4731g c4731g) {
        this.f23996a = c4731g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (XConnection.getInstance() != null) {
            XConnection.getInstance().disConnect();
            ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2455, new Object[0]);
        }
    }
}
