package message.p383f;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p160b.C1597f;
import com.cnlaunch.golo3.p160b.InterfaceConfig;
import com.cnlaunch.golo3.p160b.InterfaceDao;
import com.cnlaunch.golo3.p163e.C1609a;
import com.cnlaunch.golo3.p163e.C1610b;
import com.cnlaunch.golo3.p165g.BitmapTool;
import com.cnlaunch.golo3.p165g.FileTool;
import com.cnlaunch.golo3.p165g.MimeTool;
import com.cnlaunch.p134f.C1473a;
import com.cnlaunch.p167h.C1673a;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.p099c.p100a.HttpUtils;
import com.p099c.p100a.p103c.RequestParams;
import com.p099c.p100a.p103c.p105b.HttpRequest;
import com.p099c.p100a.p103c.p105b.p107b.p108a.InputStreamBody;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.UUID;
import message.model.ChatMessage;
import message.p378a.MessageLoginManager;
import message.p378a.MessageParameters;
import message.p384g.LogUtilMsg;
import message.p384g.MessageThreadPoolManager;
import message.xmpp.XConnection;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONException;

/* renamed from: message.f.g */
/* loaded from: classes2.dex */
public abstract class SendTask {

    /* compiled from: SendTask.java */
    /* renamed from: message.f.g$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4739a {
        /* renamed from: a */
        void mo254a();

        /* renamed from: b */
        void mo253b();
    }

    /* renamed from: b */
    public abstract void mo260b(ChatMessage chatMessage);

    /* renamed from: c */
    public abstract void mo258c(ChatMessage chatMessage);

    /* renamed from: d */
    public abstract void mo257d(ChatMessage chatMessage);

    /* renamed from: e */
    public final void m256e(ChatMessage chatMessage) {
        MessageThreadPoolManager.m225a(SendTask.class.getName()).m226a(new RunnableC4740h(this, chatMessage));
    }

    /* renamed from: f */
    public final void m255f(ChatMessage chatMessage) throws IOException, JSONException {
        switch (chatMessage.m218a()) {
            case 2:
                MediaPlayer create = MediaPlayer.create(ApplicationConfig.f7802a, Uri.fromFile(new File(chatMessage.m197k())));
                String format = new DecimalFormat("#0.0").format(create.getDuration() / 1000.0f);
                chatMessage.m214a("text", format + "''");
                chatMessage.m214a(Annotation.MIMETYPE, "audio/*");
                create.release();
                break;
            case 3:
                String m197k = chatMessage.m197k();
                if (m197k == null) {
                    m197k = chatMessage.m196l();
                } else {
                    chatMessage.m214a("name", (Object) chatMessage.m197k().substring(chatMessage.m197k().lastIndexOf("/") + 1));
                }
                Bitmap m9152a = BitmapTool.m9152a(m197k, 100);
                if (m9152a != null) {
                    if (chatMessage.m211b() == null || !HtmlTags.FACE.equals(chatMessage.m211b())) {
                        FileTool.m9143a();
                        File m9141a = FileTool.m9141a(UUID.randomUUID().toString(), chatMessage.f24057b);
                        BitmapTool.m9154a(m9152a, m9141a);
                        chatMessage.m209b("thumbPath", m9141a.getPath());
                        chatMessage.m214a(Annotation.MIMETYPE, "image/jpeg");
                        m9152a.recycle();
                        break;
                    } else {
                        chatMessage.m209b("thumbPath", (Object) m197k);
                        chatMessage.m214a(Annotation.MIMETYPE, "image/jpeg");
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 6:
                Log.i("sendTask_path", chatMessage.m197k().toString());
                File file = new File(chatMessage.m197k());
                String[] split = file.getName().split("\\.");
                chatMessage.m214a("name", file.getName());
                Log.i("sendTask_extension", split[split.length - 1]);
                chatMessage.m214a(Annotation.MIMETYPE, MimeTool.m9129a().m9128a(split[split.length + (-1)], C1473a.C1476c.mime));
                break;
            case 7:
                Bitmap m9150b = BitmapTool.m9150b(chatMessage.m197k(), C1473a.C1475b.video_thumb_logo);
                FileTool.m9143a();
                File m9141a2 = FileTool.m9141a(UUID.randomUUID().toString(), chatMessage.f24057b);
                BitmapTool.m9154a(m9150b, m9141a2);
                File file2 = new File(chatMessage.m197k());
                long length = file2.length();
                MediaPlayer create2 = MediaPlayer.create(ApplicationConfig.f7802a, Uri.fromFile(file2));
                int duration = create2.getDuration();
                create2.release();
                chatMessage.m209b("thumbPath", m9141a2.getPath());
                chatMessage.m216a(length);
                chatMessage.m206c(duration / 1000);
                chatMessage.m214a(Annotation.MIMETYPE, "video/*");
                m9150b.recycle();
                break;
        }
        if (9 != chatMessage.m218a()) {
            if (ChatMessage.EnumC4748b.failed.name().equals(chatMessage.f24061f)) {
                chatMessage.f24061f = ChatMessage.EnumC4748b.init.name();
                mo257d(chatMessage);
                return;
            }
            chatMessage.f24056a = Long.valueOf(mo262a(chatMessage));
            LogUtilMsg.m227a("notifyMessageListenerAdd", chatMessage.m211b());
            mo258c(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m261a(ChatMessage chatMessage, Object... objArr) throws Exception {
        String str;
        String str2;
        LogUtilMsg.m227a("upload", "upload");
        RequestParams requestParams = new RequestParams();
        switch (chatMessage.m218a()) {
            case 2:
                str = InterfaceConfig.f7899ar;
                requestParams.m9702a(VastExtensionXmlManager.TYPE, "2");
                requestParams.m9703a(Annotation.FILE, new File(chatMessage.m197k()));
                str2 = "2";
                break;
            case 3:
                str = InterfaceConfig.f7899ar;
                String m197k = chatMessage.m197k();
                if (m197k == null) {
                    m197k = chatMessage.m196l();
                }
                Bitmap m9152a = BitmapTool.m9152a(m197k, 300);
                if (m9152a != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    m9152a.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    requestParams.m9702a(VastExtensionXmlManager.TYPE, "1");
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    long available = byteArrayInputStream.available();
                    if (requestParams.f6659d == null) {
                        requestParams.f6659d = new HashMap<>();
                    }
                    requestParams.f6659d.put(Annotation.FILE, new InputStreamBody(byteArrayInputStream, available));
                    byteArrayOutputStream.close();
                    str2 = "1";
                    break;
                } else {
                    return;
                }
            case 4:
            case 5:
            default:
                m259b(chatMessage, objArr);
                return;
            case 6:
                str = InterfaceConfig.f7899ar;
                requestParams.m9702a(VastExtensionXmlManager.TYPE, "0");
                requestParams.m9703a(Annotation.FILE, new File(chatMessage.m197k()));
                str2 = "0";
                break;
            case 7:
                str = "file.video";
                requestParams.m9702a(VastExtensionXmlManager.TYPE, "0");
                requestParams.m9703a(Annotation.FILE, new File(chatMessage.m197k()));
                requestParams.m9703a("thumb", new File(chatMessage.m196l()));
                str2 = "0";
                break;
        }
        LogUtilMsg.m227a("Singlton", "Singlton");
        HttpUtils httpUtils = new HttpUtils();
        InterfaceDao interfaceDao = new InterfaceDao();
        C4741i c4741i = new C4741i(this, str2, httpUtils, requestParams, chatMessage, objArr);
        long currentTimeMillis = System.currentTimeMillis();
        String m9166a = interfaceDao.f8398a.m9166a(str);
        if (TextUtils.isEmpty(m9166a)) {
            Long valueOf = Long.valueOf(currentTimeMillis);
            HttpUtils httpUtils2 = C1609a.m9164a(ApplicationConfig.f7802a).f8435a;
            HttpRequest.EnumC1391a enumC1391a = HttpRequest.EnumC1391a.GET;
            String m9166a2 = interfaceDao.f8398a.m9166a(InterfaceConfig.f7908b);
            String m9166a3 = interfaceDao.f8398a.m9166a(InterfaceConfig.f7961c);
            m9166a2 = (m9166a2 == null || ApplicationConfig.f7807f) ? "0.0.0" : "0.0.0";
            m9166a3 = (m9166a3 == null || ApplicationConfig.f7807f) ? "1" : "1";
            HashMap hashMap = new HashMap();
            hashMap.put(InterfaceConfig.f7908b, m9166a2);
            hashMap.put("area", m9166a3);
            if (!TextUtils.isEmpty(ApplicationConfig.m9181a())) {
                hashMap.put("user_id", ApplicationConfig.m9181a());
            }
            StringBuffer stringBuffer = new StringBuffer(ApplicationConfig.f7812k);
            stringBuffer.append("/?action=");
            stringBuffer.append(InterfaceConfig.f7855a);
            httpUtils2.m9763a(enumC1391a, C1610b.m9162a(0, stringBuffer.toString(), hashMap), (RequestParams) null, new C1597f(interfaceDao, valueOf, str, c4741i));
            return;
        }
        StringBuilder sb = new StringBuilder(m9166a);
        if (str.equals(InterfaceConfig.f7853Y)) {
            String m9166a4 = interfaceDao.f8398a.m9166a(InterfaceConfig.f7908b);
            sb.append(",");
            if (TextUtils.isEmpty(m9166a4)) {
                m9166a4 = "";
            }
            sb.append(m9166a4);
            String m9166a5 = interfaceDao.f8398a.m9166a(InterfaceConfig.f7961c);
            sb.append(",");
            if (TextUtils.isEmpty(m9166a5)) {
                m9166a5 = "";
            }
            sb.append(m9166a5);
        }
        c4741i.mo252a();
    }

    /* renamed from: a */
    public long mo262a(ChatMessage chatMessage) {
        LogUtilMsg.m227a("inertMsgToDb", "SendTask");
        return -1L;
    }

    /* renamed from: b */
    public final void m259b(ChatMessage chatMessage, Object... objArr) {
        Message.Type type;
        String str;
        try {
            if (chatMessage.f24058c.equals(MessageParameters.EnumC4721a.single.name())) {
                type = Message.Type.chat;
                str = chatMessage.f24057b + "@" + MessageLoginManager.m306b(ApplicationConfig.m9181a()).f24095e;
            } else {
                type = Message.Type.groupchat;
                str = chatMessage.f24057b + "@grouptalk." + MessageLoginManager.m306b(ApplicationConfig.m9181a()).f24095e;
            }
            Message message2 = new Message(str, type);
            message2.setBody(chatMessage.f24063h);
            if (!XConnection.getInstance().sendPacket(message2)) {
                Thread.sleep(5000L);
                if (!XConnection.getInstance().sendPacket(message2)) {
                    C1673a.m8965a().m8964a("XMPP SendPacket Failed:[" + type.name() + "_" + str + "]");
                    chatMessage.f24061f = ChatMessage.EnumC4748b.failed.name();
                    if (objArr.length > 0) {
                        ((InterfaceC4739a) objArr[0]).mo253b();
                    }
                } else {
                    chatMessage.f24061f = ChatMessage.EnumC4748b.done.name();
                    if (objArr.length > 0) {
                        ((InterfaceC4739a) objArr[0]).mo254a();
                    }
                }
            } else {
                chatMessage.f24061f = ChatMessage.EnumC4748b.done.name();
                if (objArr.length > 0) {
                    ((InterfaceC4739a) objArr[0]).mo254a();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1673a.m8965a().m8964a("XMPP SendPacket Exception:[" + e.getMessage() + "]");
            chatMessage.f24061f = ChatMessage.EnumC4748b.failed.name();
            if (objArr.length > 0) {
                ((InterfaceC4739a) objArr[0]).mo253b();
            }
        }
        mo260b(chatMessage);
        mo257d(chatMessage);
    }
}
