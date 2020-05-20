package message.p380c;

import android.os.Looper;
import android.os.Message;
import message.model.ChatMessage;

/* renamed from: message.c.c */
/* loaded from: classes2.dex */
public abstract class MessageDealHandler extends BaseHandler {
    /* renamed from: a */
    public abstract void mo299a(ChatMessage chatMessage);

    /* renamed from: b */
    public abstract void mo298b(ChatMessage chatMessage);

    public MessageDealHandler(Looper looper) {
        super(looper);
    }

    @Override // message.p380c.BaseHandler
    /* renamed from: a */
    public final boolean mo300a(Message message2) {
        switch (message2.what) {
            case 0:
                int i = message2.arg1;
                mo299a((ChatMessage) message2.obj);
                return true;
            case 1:
                mo298b((ChatMessage) message2.obj);
                return true;
            default:
                return true;
        }
    }
}
