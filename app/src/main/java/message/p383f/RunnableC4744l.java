package message.p383f;

import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p383f.SendTask;

/* compiled from: SendTask.java */
/* renamed from: message.f.l */
/* loaded from: classes2.dex */
public final class RunnableC4744l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f24026a;

    /* renamed from: b */
    final /* synthetic */ ChatMessage f24027b;

    /* renamed from: c */
    final /* synthetic */ boolean f24028c = false;

    /* renamed from: d */
    final /* synthetic */ SendTask.InterfaceC4739a f24029d;

    /* renamed from: e */
    final /* synthetic */ SendTask f24030e;

    public RunnableC4744l(SendTask sendTask, String str, ChatMessage chatMessage, SendTask.InterfaceC4739a interfaceC4739a) {
        this.f24030e = sendTask;
        this.f24026a = str;
        this.f24027b = chatMessage;
        this.f24029d = interfaceC4739a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String[] split;
        for (String str : this.f24026a.split(",")) {
            try {
                this.f24027b.f24058c = (this.f24027b.f24058c.equals(MessageParameters.EnumC4721a.single.name()) ? MessageParameters.EnumC4721a.single : MessageParameters.EnumC4721a.group).name();
                this.f24027b.f24060e = ApplicationConfig.m9181a();
                this.f24027b.f24061f = ChatMessage.EnumC4748b.init.name();
                this.f24027b.f24059d = ChatMessage.EnumC4747a.read.name();
                this.f24027b.f24057b = str;
                this.f24027b.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
                if (this.f24028c) {
                    this.f24030e.m255f(this.f24027b);
                    this.f24030e.m261a(this.f24027b, this.f24029d);
                } else {
                    this.f24027b.f24056a = Long.valueOf(this.f24030e.mo262a(this.f24027b));
                    this.f24030e.m259b(this.f24027b, this.f24029d);
                    this.f24030e.mo258c(this.f24027b);
                }
            } catch (Exception e) {
                Log.e("SendTask", "send message failed", e);
                this.f24029d.mo253b();
            }
        }
    }
}
