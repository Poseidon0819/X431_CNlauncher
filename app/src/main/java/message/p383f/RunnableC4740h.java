package message.p383f;

import message.model.ChatMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendTask.java */
/* renamed from: message.f.h */
/* loaded from: classes2.dex */
public final class RunnableC4740h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f24012a;

    /* renamed from: b */
    final /* synthetic */ SendTask f24013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4740h(SendTask sendTask, ChatMessage chatMessage) {
        this.f24013b = sendTask;
        this.f24012a = chatMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f24012a.f24061f.equals(ChatMessage.EnumC4748b.done.name())) {
                return;
            }
            this.f24013b.m255f(this.f24012a);
            this.f24013b.m261a(this.f24012a, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
