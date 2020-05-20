package com.cnlaunch.p169im.p180j;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import com.cnlaunch.p169im.p176f.ChatManager;
import com.cnlaunch.p169im.p179i.MessageListenerProvider;
import com.cnlaunch.p181j.ExplainResult;
import com.cnlaunch.x431pro.module.golo.p262a.FriendAction;
import com.itextpdf.text.Annotation;
import java.util.Iterator;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p383f.ReceiveTask;
import message.p383f.SharePreferenceMsgUtils;
import message.p384g.LogUtilMsg;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.json.JSONArray;

/* renamed from: com.cnlaunch.im.j.a */
/* loaded from: classes.dex */
public class ReceiveMessageTask extends ReceiveTask {

    /* renamed from: e */
    private Handler f9291e = new HandlerC1746b(this, ApplicationConfig.f7802a.getMainLooper());

    public ReceiveMessageTask(ChatMessage chatMessage) {
        Log.i("Sanda", "Message.content" + chatMessage.f24063h);
        this.f24000b = chatMessage;
    }

    /* renamed from: a */
    public final void m8708a() {
        new FriendAction(ApplicationConfig.f7802a).m5326a(this.f24000b.f24060e, new C1749e(this));
    }

    @Override // message.p383f.ReceiveTask
    /* renamed from: c */
    public final void mo266c() {
        LogUtilMsg.m227a("onReceiveMessageEnd", "onReceiveMessageEnd");
    }

    @Override // message.p383f.ReceiveTask
    /* renamed from: a */
    public final void mo269a(ChatMessage chatMessage) {
        if (MessageParameters.f23954s) {
            Iterator<MessageDealHandlerCustom> it = MessageListenerProvider.m8715a().iterator();
            while (it.hasNext()) {
                it.next().m301a(0, 0, chatMessage);
            }
        }
    }

    @Override // message.p383f.ReceiveTask
    /* renamed from: b */
    public final int mo267b(ChatMessage chatMessage) {
        return Integer.parseInt(String.valueOf(ChatManager.m8741a(ApplicationConfig.f7802a).m8739a(chatMessage)));
    }

    @Override // message.p383f.ReceiveTask
    /* renamed from: c */
    public final void mo265c(ChatMessage chatMessage) {
        chatMessage.f24061f = ChatMessage.EnumC4748b.failed.name();
        mo267b(chatMessage);
        mo269a(chatMessage);
    }

    @Override // message.p383f.ReceiveTask
    /* renamed from: b */
    public final void mo268b() throws Exception {
        try {
            int m218a = this.f24000b.m218a();
            int i = 0;
            if (m218a == 1) {
                if (this.f24000b.m192p().has("news")) {
                    this.f24000b.m217a(12);
                    if (this.f24000b.m192p().getString("news") != null && !"null".equals(this.f24000b.m192p().getString("news"))) {
                        JSONArray jSONArray = new JSONArray(this.f24000b.m192p().getString("news"));
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            jSONArray2.put(i2, jSONArray.getJSONObject(i2).getString("pic_url"));
                        }
                        this.f24000b.m209b("path", (Object) jSONArray2.toString());
                        m263d(this.f24000b);
                    }
                    return;
                }
                if (this.f24000b.m192p().has("help") && MessageParameters.f23954s) {
                    ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(Opcodes.DCMPL, this.f24000b);
                }
            } else if (m218a == 8) {
                int m199i = this.f24000b.m199i();
                if (m199i != -1) {
                    LogUtilMsg.m227a("updateGroup", this.f24000b.m192p().toString());
                    switch (m199i) {
                        case 4:
                            ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2453, new Object[0]);
                            return;
                    }
                    long m8739a = ChatManager.m8741a(ApplicationConfig.f7802a).m8739a(this.f24000b);
                    if (m8739a != -1) {
                        this.f24000b.f24056a = Long.valueOf(m8739a);
                        LogUtilMsg.m227a("onReceiveMessageEnd", "onReceiveMessageEnd");
                        mo269a(this.f24000b);
                    }
                }
            } else if (m218a == 10) {
                if (this.f24000b.m191q().contains(ExplainResult.ASKFOR)) {
                    String[] split = this.f24000b.m191q().split("-");
                    String str = split[split.length - 1];
                    SharePreferenceMsgUtils m248a = SharePreferenceMsgUtils.m248a();
                    m248a.m245a(ApplicationConfig.m9181a() + this.f24000b.f24057b, str);
                    SharePreferenceMsgUtils.m248a().m245a("carName", ChatMessage.m213a(this.f24000b.f24063h, "carname"));
                }
                if (this.f24000b.m191q().contains(ExplainResult.STOP) || this.f24000b.m191q().contains("fail") || this.f24000b.m191q().equals(ExplainResult.REFUSE)) {
                    SharePreferenceMsgUtils m248a2 = SharePreferenceMsgUtils.m248a();
                    m248a2.m245a(ApplicationConfig.m9181a() + this.f24000b.f24057b, "");
                    ApplicationConfig.f7802a.sendBroadcast(new Intent("remote_refuse_stop_dismiss_dialog"));
                }
                if (this.f24000b.m191q().equals("invite") && !C1621v.m9121a(this.f24000b.f24057b)) {
                    String m195m = C1621v.m9121a(this.f24000b.m195m()) ? "null" : this.f24000b.m195m();
                    SharePreferenceMsgUtils m248a3 = SharePreferenceMsgUtils.m248a();
                    m248a3.m245a(ApplicationConfig.m9181a() + this.f24000b.f24057b, m195m);
                }
                m263d(this.f24000b);
            } else if (m218a != 12) {
                switch (m218a) {
                    case 4:
                        m263d(this.f24000b);
                        return;
                    case 5:
                        if (this.f24000b.m192p().has(Annotation.URL)) {
                            LogUtilMsg.m227a("card", "has_url");
                            this.f24000b.m209b("thumbPath", (Object) this.f24000b.m207c());
                            m263d(this.f24000b);
                            return;
                        }
                        LogUtilMsg.m227a("card", "no_has_url");
                        m263d(this.f24000b);
                        return;
                    default:
                        return;
                }
            } else {
                if (this.f24000b.m192p().has("news")) {
                    this.f24000b.m217a(12);
                    JSONArray jSONArray3 = new JSONArray(this.f24000b.m192p().getString("news"));
                    JSONArray jSONArray4 = new JSONArray();
                    while (i < jSONArray3.length()) {
                        jSONArray4.put(i, jSONArray3.getJSONObject(i).getString("pic_url"));
                        i++;
                    }
                    this.f24000b.m209b("path", (Object) jSONArray4.toString());
                } else {
                    JSONArray jSONArray5 = new JSONArray(this.f24000b.m211b());
                    JSONArray jSONArray6 = new JSONArray();
                    while (i < jSONArray5.length()) {
                        jSONArray6.put(i, jSONArray5.getJSONObject(i).getString("pic_url"));
                        i++;
                    }
                    this.f24000b.m209b("path", (Object) jSONArray6.toString());
                }
                m263d(this.f24000b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
