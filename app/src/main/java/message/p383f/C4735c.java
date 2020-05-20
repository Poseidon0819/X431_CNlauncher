package message.p383f;

import com.cnlaunch.p167h.C1673a;
import com.itextpdf.text.Annotation;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.io.File;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveTask.java */
/* renamed from: message.f.c */
/* loaded from: classes2.dex */
final class C4735c extends RequestCallBack<File> {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f24004a;

    /* renamed from: b */
    final /* synthetic */ HandlerC4734b f24005b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4735c(HandlerC4734b handlerC4734b, ChatMessage chatMessage) {
        this.f24005b = handlerC4734b;
        this.f24004a = chatMessage;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<File> responseInfo) {
        try {
            this.f24004a.m209b("path", (Object) responseInfo.f6665a.getPath());
            this.f24004a.m214a("text", (Object) this.f24004a.m211b());
            this.f24004a.m214a(Annotation.MIMETYPE, (Object) "audio/*");
            this.f24005b.f24003a.m263d(this.f24004a);
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("XMPP DownLoad Voice Exception:[" + e.getMessage() + "]");
        }
        LogUtilMsg.m227a("onSuccess", "onSuccess");
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", "onFailure");
        C1673a m8965a = C1673a.m8965a();
        m8965a.m8964a("XMPP DownLoad Voice Failed:[" + str + "]");
        this.f24005b.f24003a.mo265c(this.f24004a);
    }
}
