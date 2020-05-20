package message.p380c;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseHandler.java */
/* renamed from: message.c.b */
/* loaded from: classes2.dex */
public final class C4724b implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ BaseHandler f23971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4724b(BaseHandler baseHandler) {
        this.f23971a = baseHandler;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        return this.f23971a.mo300a(message2);
    }
}
