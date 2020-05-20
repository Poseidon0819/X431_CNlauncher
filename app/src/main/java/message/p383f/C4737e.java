package message.p383f;

import android.graphics.Bitmap;
import com.cnlaunch.golo3.p165g.BitmapTool;
import com.cnlaunch.golo3.p165g.FileTool;
import com.cnlaunch.p134f.C1473a;
import com.cnlaunch.p167h.C1673a;
import com.itextpdf.text.Annotation;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.io.File;
import java.util.UUID;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveTask.java */
/* renamed from: message.f.e */
/* loaded from: classes2.dex */
final class C4737e extends RequestCallBack<File> {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f24008a;

    /* renamed from: b */
    final /* synthetic */ HandlerC4734b f24009b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4737e(HandlerC4734b handlerC4734b, ChatMessage chatMessage) {
        this.f24009b = handlerC4734b;
        this.f24008a = chatMessage;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<File> responseInfo) {
        try {
            this.f24008a.m209b("path", (Object) responseInfo.f6665a.getPath());
            Bitmap m9150b = BitmapTool.m9150b(this.f24008a.m197k(), C1473a.C1475b.video_thumb_logo);
            FileTool.m9143a();
            File m9141a = FileTool.m9141a(UUID.randomUUID().toString(), this.f24008a.f24057b);
            BitmapTool.m9154a(m9150b, m9141a);
            this.f24008a.m209b("thumbPath", (Object) m9141a.getPath());
            this.f24008a.m214a(Annotation.MIMETYPE, (Object) "video/*");
            m9150b.recycle();
            this.f24009b.f24003a.m263d(this.f24008a);
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("XMPP DownLoad Video Exception:[" + e.getMessage() + "]");
        }
        LogUtilMsg.m227a("onSuccess", "onSuccess");
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", "onFailure");
        C1673a m8965a = C1673a.m8965a();
        m8965a.m8964a("XMPP DownLoad Video Failed:[" + str + "]");
        this.f24009b.f24003a.mo265c(this.f24008a);
    }
}
