package message.p383f;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.golo3.p165g.FileTool;
import com.cnlaunch.golo3.p165g.SignatureTool;
import com.cnlaunch.p167h.C1673a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveTask.java */
/* renamed from: message.f.b */
/* loaded from: classes2.dex */
final class HandlerC4734b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReceiveTask f24003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4734b(ReceiveTask receiveTask, Looper looper) {
        super(looper);
        this.f24003a = receiveTask;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        File m9140b;
        switch (message2.what) {
            case 1:
                ChatMessage chatMessage = (ChatMessage) message2.obj;
                try {
                    FileTool.m9143a();
                    String uuid = UUID.randomUUID().toString();
                    File file = new File(Environment.getExternalStorageDirectory(), FileTool.m9139c("voice", chatMessage.f24057b));
                    if (!file.mkdirs() && !file.isDirectory()) {
                        throw new FileNotFoundException("SDCard not found!");
                    }
                    File file2 = new File(file, uuid);
                    LogUtilMsg.m227a("TYPE_VOICE", chatMessage.m207c() + "-");
                    this.f24003a.f24001d.m9760a(chatMessage.m207c(), file2.getAbsolutePath(), new C4735c(this, chatMessage));
                    return;
                } catch (Exception e) {
                    this.f24003a.mo265c(chatMessage);
                    C1673a m8965a = C1673a.m8965a();
                    m8965a.m8964a("XMPP DownLoad Voice Exception:[" + e.getMessage() + "]");
                    e.printStackTrace();
                    return;
                }
            case 2:
                ChatMessage chatMessage2 = (ChatMessage) message2.obj;
                LogUtilMsg.m227a("DOWNLOAD_PICTURE", chatMessage2.m192p().toString());
                try {
                    FileTool.m9143a();
                    String uuid2 = UUID.randomUUID().toString();
                    File file3 = new File(Environment.getExternalStorageDirectory(), FileTool.m9139c("picture", chatMessage2.f24057b));
                    if (!file3.mkdirs() && !file3.isDirectory()) {
                        throw new FileNotFoundException("SDCard not found!");
                    }
                    File file4 = new File(file3, uuid2);
                    if (chatMessage2.m207c() != null) {
                        this.f24003a.f24001d.m9760a(chatMessage2.m207c(), file4.getAbsolutePath(), new C4736d(this, chatMessage2));
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    this.f24003a.mo265c(chatMessage2);
                    C1673a m8965a2 = C1673a.m8965a();
                    m8965a2.m8964a("XMPP DownLoad Pic Exception:[" + e2.getMessage() + "]");
                    e2.printStackTrace();
                    return;
                }
            case 3:
                ChatMessage chatMessage3 = (ChatMessage) message2.obj;
                try {
                    FileTool.m9143a();
                    String uuid3 = UUID.randomUUID().toString();
                    File file5 = new File(Environment.getExternalStorageDirectory(), FileTool.m9139c("video", chatMessage3.f24057b));
                    if (!file5.mkdirs() && !file5.isDirectory()) {
                        throw new FileNotFoundException("SDCard not found!");
                    }
                    this.f24003a.f24001d.m9760a(chatMessage3.m207c(), new File(file5, uuid3).getAbsolutePath(), new C4737e(this, chatMessage3));
                    return;
                } catch (Exception e3) {
                    this.f24003a.mo265c(chatMessage3);
                    C1673a m8965a3 = C1673a.m8965a();
                    m8965a3.m8964a("XMPP DownLoad Video Exception:[" + e3.getMessage() + "]");
                    e3.printStackTrace();
                    return;
                }
            case 4:
                ChatMessage chatMessage4 = (ChatMessage) message2.obj;
                try {
                    if (chatMessage4.m203e() != null) {
                        int i = 1;
                        if (!chatMessage4.m203e().contains(".")) {
                            FileTool.m9143a();
                            m9140b = FileTool.m9140b(chatMessage4.m203e(), chatMessage4.f24057b);
                            while (m9140b.exists()) {
                                FileTool.m9143a();
                                m9140b = FileTool.m9140b(chatMessage4.m203e() + "(" + i + ")", chatMessage4.f24057b);
                                i++;
                            }
                        } else {
                            FileTool.m9143a();
                            m9140b = FileTool.m9140b(chatMessage4.m203e(), chatMessage4.f24057b);
                            while (m9140b.exists()) {
                                FileTool.m9143a();
                                m9140b = FileTool.m9140b(chatMessage4.m203e().substring(0, chatMessage4.m203e().lastIndexOf(".")) + "(" + i + ")" + chatMessage4.m203e().substring(chatMessage4.m203e().lastIndexOf(".")), chatMessage4.f24057b);
                                i++;
                            }
                        }
                    } else {
                        FileTool.m9143a();
                        m9140b = FileTool.m9140b(SignatureTool.m9124a(chatMessage4.m207c()), chatMessage4.f24057b);
                    }
                    this.f24003a.f24001d.m9760a(chatMessage4.m207c(), m9140b.getAbsolutePath(), new C4738f(this, chatMessage4));
                    return;
                } catch (FileNotFoundException e4) {
                    this.f24003a.mo265c(chatMessage4);
                    e4.printStackTrace();
                    C1673a m8965a4 = C1673a.m8965a();
                    m8965a4.m8964a("XMPP DownLoad File Exception:[" + e4.getMessage() + "]");
                    return;
                } catch (Exception e5) {
                    this.f24003a.mo265c(chatMessage4);
                    C1673a m8965a5 = C1673a.m8965a();
                    m8965a5.m8964a("XMPP DownLoad File Exception:[" + e5.getMessage() + "]");
                    e5.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }
}
