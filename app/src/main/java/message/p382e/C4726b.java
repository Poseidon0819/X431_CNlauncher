package message.p382e;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p167h.C1673a;
import message.model.MessageLoginEntity;
import message.p378a.MessageLoginManager;
import message.p378a.MessageParameters;
import message.p384g.MsgUtils;
import message.xmpp.XConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloService.java */
/* renamed from: message.e.b */
/* loaded from: classes2.dex */
public final class C4726b implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ GoloService f23988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4726b(GoloService goloService) {
        this.f23988a = goloService;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        int i = message2.what;
        if (i == 256) {
            GoloService.f23974d = 0;
            GoloService.f23972b = false;
            MessageParameters.f23954s = true;
            this.f23988a.mo289a();
            if (this.f23988a.f23978e.size() > 0) {
                XConnection.getInstance().disConnect();
                GoloService.m271g();
            }
            this.f23988a.f23978e.clear();
            this.f23988a.f23979f.clear();
            this.f23988a.mo276c();
        } else if (i == 100001) {
            MessageLoginEntity m306b = MessageLoginManager.m306b(GoloService.m274d());
            if (m306b != null) {
                ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2454, new Object[0]);
                XConnection.getInstance().login(m306b.f24093c, m306b.f24094d, m306b.f24092b, MsgUtils.m220a(m306b.f24092b, m306b.f24091a), m306b.f24095e, "android");
            } else {
                C1673a.m8965a().m8964a("Login MessageLoginEntity is Null!");
            }
        }
        return true;
    }
}
