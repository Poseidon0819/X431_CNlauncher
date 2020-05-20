package message.p382e;

import android.os.Looper;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.AbstractC1613g;
import com.cnlaunch.golo3.p165g.AbstractC1614h;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p167h.C1673a;
import message.p378a.MessageParameters;
import message.p379b.XmppEvent;
import message.p383f.ReceiveTask;
import message.p384g.LogUtilMsg;
import message.p384g.MessageThreadPoolManager;
import message.p384g.MsgUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloService.java */
/* renamed from: message.e.d */
/* loaded from: classes2.dex */
public final class C4728d extends AbstractC1614h {

    /* renamed from: b */
    final /* synthetic */ GoloService f23990b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4728d(GoloService goloService, Looper looper) {
        super(looper);
        this.f23990b = goloService;
    }

    @Override // com.cnlaunch.golo3.p165g.AbstractC1614h
    /* renamed from: a */
    public final void mo270a(AbstractC1613g abstractC1613g) {
        if (abstractC1613g instanceof XmppEvent) {
            XmppEvent xmppEvent = (XmppEvent) abstractC1613g;
            switch (C4733i.f23997a[xmppEvent.f23966a.ordinal()]) {
                case 1:
                    GoloService.m277b(xmppEvent.f23967b);
                    return;
                case 2:
                    LogUtilMsg.m227a("connect_successfully", "connect_successfully");
                    GoloService.m286a(this.f23990b);
                    return;
                case 3:
                    ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2450, new Object[0]);
                    if (!MsgUtils.m222a(ApplicationConfig.f7802a, MessageParameters.f23953r)) {
                        LogUtilMsg.m227a("connect_failed", "!isServiceRunning");
                        new XmppEvent(XmppEvent.EnumC4723a.service_stop).m9144a();
                    }
                    LogUtilMsg.m227a("connect_failed", "connect_failed");
                    C1673a.m8965a().m8964a("EventListener connect_failed");
                    GoloService.m280b(this.f23990b);
                    return;
                case 4:
                    return;
                case 5:
                    return;
                case 6:
                case 7:
                    LogUtilMsg.m227a("golo_service_ping_failed", "ping_failed");
                    if (!MsgUtils.m222a(ApplicationConfig.f7802a, MessageParameters.f23953r)) {
                        LogUtilMsg.m227a("!isServiceRunning", "!isServiceRunning");
                        ((GoloService) Singlton.m9123a(GoloService.class)).mo281b();
                    }
                    C1673a.m8965a().m8964a("EventListener Send_Failed/Ping_Failed");
                    GoloService.m280b(this.f23990b);
                    return;
                case 8:
                    LogUtilMsg.m227a("receive_msg", "receive_msg");
                    GoloService.m284a(this.f23990b, xmppEvent.f23967b);
                    return;
                case 9:
                    GoloService.m275c(xmppEvent.f23967b);
                    return;
                case 10:
                    GoloService.m279b(this.f23990b, xmppEvent.f23967b);
                    return;
                case 11:
                    LogUtilMsg.m227a("receive_offline_msg_end", "receive_offline_msg_end");
                    if (this.f23990b.f23978e.size() > 0) {
                        int size = this.f23990b.f23979f.size();
                        try {
                            MessageThreadPoolManager.m225a(GoloService.class.getName()).m226a(new RunnableC4729e(this, this.f23990b.f23978e.size(), size));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    this.f23990b.mo276c();
                    MessageParameters.f23949n = true;
                    ReceiveTask.f23999c = true;
                    GoloService.f23972b = false;
                    MessageParameters.f23954s = true;
                    this.f23990b.mo289a();
                    return;
                default:
                    return;
            }
        }
    }
}
