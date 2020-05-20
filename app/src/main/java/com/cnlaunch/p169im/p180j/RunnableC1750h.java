package com.cnlaunch.p169im.p180j;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.itextpdf.text.Annotation;
import java.io.IOException;
import java.util.List;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p383f.SendTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SendMessageTask.java */
/* renamed from: com.cnlaunch.im.j.h */
/* loaded from: classes.dex */
public final class RunnableC1750h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f9300a;

    /* renamed from: b */
    final /* synthetic */ MessageParameters.EnumC4721a f9301b;

    /* renamed from: c */
    final /* synthetic */ String f9302c;

    /* renamed from: d */
    final /* synthetic */ String f9303d;

    /* renamed from: e */
    final /* synthetic */ String f9304e;

    /* renamed from: f */
    final /* synthetic */ SendTask.InterfaceC4739a f9305f;

    /* renamed from: g */
    final /* synthetic */ SendMessageTask f9306g;

    public RunnableC1750h(SendMessageTask sendMessageTask, List list, MessageParameters.EnumC4721a enumC4721a, String str, String str2, String str3, SendTask.InterfaceC4739a interfaceC4739a) {
        this.f9306g = sendMessageTask;
        this.f9300a = list;
        this.f9301b = enumC4721a;
        this.f9302c = str;
        this.f9303d = str2;
        this.f9304e = str3;
        this.f9305f = interfaceC4739a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            for (String str : this.f9300a) {
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.f24058c = this.f9301b.name();
                chatMessage.f24060e = ApplicationConfig.m9181a();
                chatMessage.f24061f = ChatMessage.EnumC4748b.init.name();
                chatMessage.f24059d = ChatMessage.EnumC4747a.read.name();
                chatMessage.m217a(1);
                chatMessage.m214a("text", (Object) this.f9302c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Annotation.URL, this.f9303d);
                jSONObject.put("title_name", this.f9304e);
                chatMessage.m214a("check_report", jSONObject);
                chatMessage.f24057b = str;
                chatMessage.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
                this.f9306g.m255f(chatMessage);
                this.f9306g.m259b(chatMessage, this.f9305f);
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.f9305f.mo253b();
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f9305f.mo253b();
        }
    }
}
