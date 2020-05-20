package com.cnlaunch.p169im.p180j;

import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.io.File;
import message.model.ChatMessage;
import message.p384g.LogUtilMsg;

/* compiled from: ReceiveMessageTask.java */
/* renamed from: com.cnlaunch.im.j.c */
/* loaded from: classes.dex */
final class C1747c extends RequestCallBack<File> {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f9293a;

    /* renamed from: b */
    final /* synthetic */ File f9294b;

    /* renamed from: c */
    final /* synthetic */ HandlerC1746b f9295c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1747c(HandlerC1746b handlerC1746b, ChatMessage chatMessage, File file) {
        this.f9295c = handlerC1746b;
        this.f9293a = chatMessage;
        this.f9294b = file;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<File> responseInfo) {
        try {
            this.f9293a.m209b("thumbPath", (Object) this.f9294b.getPath());
            this.f9295c.f9292a.m263d(this.f9293a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtilMsg.m227a("onSuccess", "onSuccess");
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", "onFailure");
        this.f9295c.f9292a.mo265c(this.f9293a);
    }
}
