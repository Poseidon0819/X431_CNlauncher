package message.p383f;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p134f.C1473a;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.List;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p383f.SendTask;
import org.json.JSONException;

/* compiled from: SendTask.java */
/* renamed from: message.f.k */
/* loaded from: classes2.dex */
public final class RunnableC4743k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f24021a;

    /* renamed from: b */
    final /* synthetic */ MessageParameters.EnumC4721a f24022b;

    /* renamed from: c */
    final /* synthetic */ String f24023c;

    /* renamed from: d */
    final /* synthetic */ SendTask.InterfaceC4739a f24024d;

    /* renamed from: e */
    final /* synthetic */ SendTask f24025e;

    public RunnableC4743k(SendTask sendTask, List list, MessageParameters.EnumC4721a enumC4721a, String str, SendTask.InterfaceC4739a interfaceC4739a) {
        this.f24025e = sendTask;
        this.f24021a = list;
        this.f24022b = enumC4721a;
        this.f24023c = str;
        this.f24024d = interfaceC4739a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            for (String str : this.f24021a) {
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.f24058c = this.f24022b.name();
                chatMessage.f24060e = ApplicationConfig.m9181a();
                chatMessage.f24061f = ChatMessage.EnumC4748b.init.name();
                chatMessage.f24059d = ChatMessage.EnumC4747a.read.name();
                chatMessage.m217a(1);
                chatMessage.m214a("text", (Object) ("[" + ApplicationConfig.f7802a.getString(C1473a.C1477d.new_face) + "]"));
                chatMessage.m214a(HtmlTags.FACE, (Object) this.f24023c);
                chatMessage.f24057b = str;
                chatMessage.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
                this.f24025e.m255f(chatMessage);
                this.f24025e.m259b(chatMessage, this.f24024d);
            }
        } catch (IOException unused) {
            this.f24024d.mo253b();
        } catch (JSONException unused2) {
            this.f24024d.mo253b();
        }
    }
}
