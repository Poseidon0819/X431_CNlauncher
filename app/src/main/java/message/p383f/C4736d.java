package message.p383f;

import android.graphics.Bitmap;
import com.cnlaunch.golo3.p165g.BitmapTool;
import com.cnlaunch.golo3.p165g.FileTool;
import com.cnlaunch.p167h.C1673a;
import com.itextpdf.text.Annotation;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.io.File;
import java.util.UUID;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveTask.java */
/* renamed from: message.f.d */
/* loaded from: classes2.dex */
final class C4736d extends RequestCallBack<File> {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f24006a;

    /* renamed from: b */
    final /* synthetic */ HandlerC4734b f24007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4736d(HandlerC4734b handlerC4734b, ChatMessage chatMessage) {
        this.f24007b = handlerC4734b;
        this.f24006a = chatMessage;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<File> responseInfo) {
        try {
            this.f24006a.m209b("path", (Object) responseInfo.f6665a.getPath());
            Bitmap m9152a = BitmapTool.m9152a(this.f24006a.m197k(), 1024);
            Bitmap m9155a = BitmapTool.m9155a(m9152a);
            FileTool.m9143a();
            File m9141a = FileTool.m9141a(UUID.randomUUID().toString(), this.f24006a.f24057b);
            BitmapTool.m9154a(m9155a, m9141a);
            this.f24006a.m209b("thumbPath", (Object) m9141a.getPath());
            this.f24006a.m209b("thumbPath", (Object) responseInfo.f6665a.getPath());
            this.f24006a.m214a(Annotation.MIMETYPE, (Object) "image/jpeg");
            m9152a.recycle();
            m9155a.recycle();
            this.f24007b.f24003a.m263d(this.f24006a);
        } catch (Exception e) {
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("XMPP DownLoad Pic Exception:[" + e.getMessage() + "]");
            e.printStackTrace();
        }
        LogUtilMsg.m227a("onSuccess", "onSuccess");
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", "onFailure");
        C1673a m8965a = C1673a.m8965a();
        m8965a.m8964a("XMPP DownLoad Pic Failed:[" + str + "]");
        this.f24007b.f24003a.mo265c(this.f24006a);
    }
}
