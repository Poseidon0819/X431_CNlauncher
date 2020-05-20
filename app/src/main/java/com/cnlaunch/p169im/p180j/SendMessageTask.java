package com.cnlaunch.p169im.p180j;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import com.cnlaunch.p169im.p176f.ChatManager;
import com.cnlaunch.p169im.p179i.MessageListenerProvider;
import java.util.Iterator;
import message.model.ChatMessage;
import message.p383f.SendTask;
import message.p384g.LogUtilMsg;

/* renamed from: com.cnlaunch.im.j.g */
/* loaded from: classes.dex */
public class SendMessageTask extends SendTask {
    @Override // message.p383f.SendTask
    /* renamed from: a */
    public final long mo262a(ChatMessage chatMessage) {
        LogUtilMsg.m227a("inertMsgToDb", "SendMessageTask");
        return ChatManager.m8741a(ApplicationConfig.f7802a).m8739a(chatMessage);
    }

    @Override // message.p383f.SendTask
    /* renamed from: b */
    public final void mo260b(ChatMessage chatMessage) {
        if (9 != chatMessage.m218a()) {
            ChatManager.m8741a(ApplicationConfig.f7802a).m8736b(chatMessage);
        }
    }

    @Override // message.p383f.SendTask
    /* renamed from: c */
    public final void mo258c(ChatMessage chatMessage) {
        LogUtilMsg.m227a("notifyMessageListenerAdd_for", "notifyMessageListenerAdd_for");
        Iterator<MessageDealHandlerCustom> it = MessageListenerProvider.m8715a().iterator();
        while (it.hasNext()) {
            it.next().m301a(0, 1, chatMessage);
        }
    }

    @Override // message.p383f.SendTask
    /* renamed from: d */
    public final void mo257d(ChatMessage chatMessage) {
        Iterator<MessageDealHandlerCustom> it = MessageListenerProvider.m8715a().iterator();
        while (it.hasNext()) {
            it.next().m301a(1, 0, chatMessage);
        }
    }
}
