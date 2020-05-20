package com.cnlaunch.p169im.p180j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.golo3.p165g.FileTool;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiveMessageTask.java */
/* renamed from: com.cnlaunch.im.j.b */
/* loaded from: classes.dex */
public final class HandlerC1746b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReceiveMessageTask f9292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1746b(ReceiveMessageTask receiveMessageTask, Looper looper) {
        super(looper);
        this.f9292a = receiveMessageTask;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        int i = message2.what;
        if (i != 17) {
            if (i != 19) {
                return;
            }
            this.f9292a.mo265c((ChatMessage) message2.obj);
            return;
        }
        ChatMessage chatMessage = (ChatMessage) message2.obj;
        try {
            FileTool.m9143a();
            File m9141a = FileTool.m9141a(UUID.randomUUID().toString(), this.f9292a.f24000b.f24057b);
            LogUtilMsg.m227a("TYPE_VOICE", chatMessage.m207c());
            this.f9292a.f24001d.m9760a(chatMessage.m207c(), m9141a.getAbsolutePath(), new C1747c(this, chatMessage, m9141a));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
