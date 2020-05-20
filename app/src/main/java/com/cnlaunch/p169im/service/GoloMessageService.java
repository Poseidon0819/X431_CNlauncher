package com.cnlaunch.p169im.service;

import android.content.Intent;
import android.util.Log;
import com.cnlaunch.defend.DefendTimer;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.golo3.p165g.ThreadPoolManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p167h.C1673a;
import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p173d.RunnableC1732f;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.p169im.p179i.MessageListenerProvider;
import com.cnlaunch.p169im.p180j.ReceiveMessageTask;
import com.cnlaunch.p169im.p180j.RunLastTask;
import com.cnlaunch.p169im.p180j.RunnableC1748d;
import com.cnlaunch.p181j.ChatMessageExplain;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.p181j.ExplainResult;
import java.util.Iterator;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p382e.GoloService;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.im.service.GoloMessageService */
/* loaded from: classes.dex */
public class GoloMessageService extends GoloService {

    /* renamed from: g */
    private DefendTimer f9316g = null;

    /* renamed from: a */
    final String f9315a = "com.cnlaunch.defend.DefendService";

    @Override // message.p382e.GoloService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f9316g = new DefendTimer(getApplicationContext(), "defend_is_enable", "com.cnlaunch.defend.DefendService", 1);
        this.f9316g.m9428a();
        C1673a.m8965a().m8964a("GoloMessageService Launch!");
    }

    @Override // message.p382e.GoloService
    /* renamed from: a */
    public final void mo289a() {
        Iterator<MessageDealHandlerCustom> it = MessageListenerProvider.m8715a().iterator();
        while (it.hasNext()) {
            it.next().m301a(0, 2, null);
        }
    }

    @Override // message.p382e.GoloService
    /* renamed from: a */
    public final void mo283a(ChatMessage chatMessage, boolean z) {
        Log.i("MEE", "Message=" + chatMessage.m192p());
        ReceiveMessageTask receiveMessageTask = new ReceiveMessageTask(chatMessage);
        if (z) {
            try {
                if (receiveMessageTask.f24000b.m218a() == 9) {
                    GoloDBManager.m8756a(ApplicationConfig.f7802a).m8753a(receiveMessageTask.f24000b, PreferencesManager.m9595a(ApplicationConfig.f7802a).m9591a("user_id"));
                    GoloOBManager m8721a = GoloOBManager.m8721a();
                    receiveMessageTask.f24000b.m192p();
                    m8721a.m8717b();
                    if (receiveMessageTask.f24000b.m199i() == 1) {
                        receiveMessageTask.m263d(new ChatMessage(receiveMessageTask.f24000b.m211b(), receiveMessageTask.f24000b.f24060e));
                        receiveMessageTask.m8708a();
                        ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(Opcodes.I2B, new Object[0]);
                    }
                } else {
                    if ((receiveMessageTask.f24000b.f24058c.equals(MessageParameters.EnumC4721a.single.name()) ? MessageParameters.EnumC4721a.single : MessageParameters.EnumC4721a.group).equals(MessageParameters.EnumC4721a.single)) {
                        receiveMessageTask.m264d();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ThreadPoolManager.m9117b(ReceiveMessageTask.class.getName()).m9120a(new RunnableC1748d(receiveMessageTask));
        }
        NoticeMessageHandler m8784a = NoticeMessageHandler.m8784a(this);
        int m8778a = m8784a.m8778a(chatMessage);
        if (m8778a != 0) {
            RunLastTask runLastTask = m8784a.f9199a;
            RunnableC1732f runnableC1732f = new RunnableC1732f(m8784a, m8778a, chatMessage);
            synchronized (runLastTask) {
                runLastTask.f9298a.clear();
                runLastTask.f9298a.offer(runnableC1732f);
            }
        }
        DealDiagMessageHandler m8673a = DealDiagMessageHandler.m8673a();
        if (chatMessage == null || chatMessage.m218a() != 10) {
            return;
        }
        ExplainResult m8675a = ChatMessageExplain.m8675a(chatMessage);
        if (m8673a.f9430f.m8683b() || m8673a.f9430f.f9419c.equalsIgnoreCase(m8675a.f9478id)) {
            m8673a.f9430f.m8682b(m8675a);
        } else {
            m8673a.f9430f.mo8653a(2, m8675a);
        }
    }

    @Override // message.p382e.GoloService
    /* renamed from: b */
    public final void mo281b() {
        ApplicationConfig.f7802a.startService(new Intent(ApplicationConfig.f7802a, GoloMessageService.class));
    }

    @Override // message.p382e.GoloService
    /* renamed from: c */
    public final void mo276c() {
        super.mo276c();
    }

    @Override // message.p382e.GoloService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1673a.m8965a().m8964a("GoloMessageService Destroy!");
        DefendTimer defendTimer = this.f9316g;
        if (defendTimer != null) {
            defendTimer.m9427b();
        }
    }
}
