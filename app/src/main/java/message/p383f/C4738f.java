package message.p383f;

import com.cnlaunch.p167h.C1673a;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.io.File;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveTask.java */
/* renamed from: message.f.f */
/* loaded from: classes2.dex */
final class C4738f extends RequestCallBack<File> {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f24010a;

    /* renamed from: b */
    final /* synthetic */ HandlerC4734b f24011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4738f(HandlerC4734b handlerC4734b, ChatMessage chatMessage) {
        this.f24011b = handlerC4734b;
        this.f24010a = chatMessage;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<File> responseInfo) {
        try {
            this.f24010a.m209b("path", (Object) responseInfo.f6665a.getPath());
            this.f24011b.f24003a.m263d(this.f24010a);
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("XMPP DownLoad File Exception:[" + e.getMessage() + "]");
        }
        LogUtilMsg.m227a("onSuccess", "onSuccess");
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", "onFailure");
        this.f24011b.f24003a.mo265c(this.f24010a);
        C1673a m8965a = C1673a.m8965a();
        m8965a.m8964a("XMPP DownLoad File Faile:[" + str + "]");
    }
}
