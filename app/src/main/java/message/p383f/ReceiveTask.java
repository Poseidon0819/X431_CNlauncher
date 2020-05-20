package message.p383f;

import android.os.Handler;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.p099c.p100a.HttpUtils;
import java.util.HashMap;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p382e.GoloService;
import message.p384g.DateTool;
import message.p384g.LogUtilMsg;

/* renamed from: message.f.a */
/* loaded from: classes2.dex */
public abstract class ReceiveTask {

    /* renamed from: a */
    public static HashMap<String, Boolean> f23998a = new HashMap<>();

    /* renamed from: c */
    public static boolean f23999c = false;

    /* renamed from: b */
    public ChatMessage f24000b;

    /* renamed from: d */
    public HttpUtils f24001d = new HttpUtils();

    /* renamed from: e */
    private Handler f24002e = new HandlerC4734b(this, ApplicationConfig.f7802a.getMainLooper());

    /* renamed from: a */
    public abstract void mo269a(ChatMessage chatMessage);

    /* renamed from: b */
    public int mo267b(ChatMessage chatMessage) {
        return -1;
    }

    /* renamed from: b */
    public abstract void mo268b() throws Exception;

    /* renamed from: c */
    public abstract void mo266c();

    /* renamed from: c */
    public abstract void mo265c(ChatMessage chatMessage);

    /* renamed from: d */
    public final void m264d() throws Exception {
        switch (this.f24000b.m218a()) {
            case 1:
                mo268b();
                m263d(this.f24000b);
                break;
            case 2:
                this.f24002e.obtainMessage(1, this.f24000b).sendToTarget();
                break;
            case 3:
                if (this.f24000b.m204d() != null) {
                    if (this.f24000b.m211b() != null) {
                        HtmlTags.FACE.equals(this.f24000b.m211b());
                    }
                    this.f24000b.m214a(Annotation.MIMETYPE, (Object) "image/jpeg");
                    m263d(this.f24000b);
                    break;
                } else {
                    this.f24002e.obtainMessage(2, this.f24000b).sendToTarget();
                    break;
                }
            case 6:
                this.f24002e.obtainMessage(4, this.f24000b).sendToTarget();
                break;
            case 7:
                if (this.f24000b.m204d() == null || this.f24000b.m204d().equals("")) {
                    this.f24002e.obtainMessage(3, this.f24000b).sendToTarget();
                    break;
                } else {
                    this.f24000b.m214a(Annotation.MIMETYPE, (Object) "video/*");
                    m263d(this.f24000b);
                    break;
                }
                break;
        }
        if (this.f24000b.m218a() != 1) {
            mo268b();
        }
    }

    /* renamed from: d */
    public final void m263d(ChatMessage chatMessage) throws Exception {
        chatMessage.m210b(chatMessage.m199i());
        if (chatMessage.m218a() != 13) {
            chatMessage.f24056a = Long.valueOf(Long.parseLong(String.valueOf(mo267b(chatMessage))));
            StringBuilder sb = new StringBuilder();
            sb.append(chatMessage.f24056a);
            LogUtilMsg.m227a("inertMsgToDb", sb.toString());
        }
        if (chatMessage.f24056a.longValue() == -1) {
            if (chatMessage.f24057b.equals(MessageParameters.f23936a)) {
                Log.i("yzp", "Repeat_message-" + chatMessage.f24067l + "-" + DateTool.m241a().m239a(chatMessage.f24062g.longValue()));
            }
            LogUtilMsg.m227a("return", "return");
            return;
        }
        if (!MessageParameters.f23954s && SharePreferenceMsgUtils.m248a() != null) {
            GoloService.f23974d++;
            if (chatMessage.f24062g.longValue() > SharePreferenceMsgUtils.m248a().m243b().longValue()) {
                SharePreferenceMsgUtils.m248a().m247a(chatMessage.f24062g);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(chatMessage.m218a());
        LogUtilMsg.m227a("message.getType()", sb2.toString());
        if (chatMessage.m218a() != 13 && !this.f24000b.m192p().has("help")) {
            mo266c();
        }
        mo269a(chatMessage);
    }
}
