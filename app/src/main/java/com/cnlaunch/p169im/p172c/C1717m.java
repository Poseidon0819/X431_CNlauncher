package com.cnlaunch.p169im.p172c;

import android.os.Looper;
import android.text.TextUtils;
import com.cnlaunch.p169im.p170a.ChatMessageAdapter;
import com.cnlaunch.p169im.p171b.MessageComparator;
import com.cnlaunch.p169im.p173d.AutoVoiceHandler;
import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import java.util.ArrayList;
import java.util.Collections;
import message.model.ChatMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.m */
/* loaded from: classes.dex */
public final class C1717m extends MessageDealHandlerCustom {

    /* renamed from: a */
    final /* synthetic */ ProMessageFragment f9148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1717m(ProMessageFragment proMessageFragment, Looper looper) {
        super(looper);
        this.f9148a = proMessageFragment;
    }

    @Override // com.cnlaunch.p169im.p173d.MessageDealHandlerCustom, message.p380c.MessageDealHandler
    /* renamed from: a */
    public final void mo299a(ChatMessage chatMessage) {
        if (chatMessage == null || this.f9148a.f9122e == null || TextUtils.isEmpty(chatMessage.f24057b) || TextUtils.isEmpty(this.f9148a.f9122e.f24076a)) {
            return;
        }
        try {
            if (chatMessage.f24057b.equals(this.f9148a.f9122e.f24076a)) {
                ChatMessageAdapter chatMessageAdapter = this.f9148a.f9124g;
                if (chatMessageAdapter.f8918a == null) {
                    chatMessageAdapter.f8918a = new ArrayList<>();
                }
                chatMessageAdapter.f8918a.add(chatMessage);
                Collections.sort(chatMessageAdapter.f8918a, new MessageComparator());
                chatMessageAdapter.notifyDataSetChanged();
                if (chatMessage.f24057b.equalsIgnoreCase(chatMessage.f24060e) && chatMessage.m218a() == 2 && this.f9148a.f9096C.f12677a == 2 && AutoVoiceHandler.f9188c) {
                    AutoVoiceHandler m8789a = AutoVoiceHandler.m8789a(this.f9148a.getActivity());
                    m8789a.f9191b.add(chatMessage);
                    m8789a.obtainMessage(102).sendToTarget();
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.p169im.p173d.MessageDealHandlerCustom, message.p380c.MessageDealHandler
    /* renamed from: b */
    public final void mo298b(ChatMessage chatMessage) {
        if (chatMessage != null) {
            try {
                if (chatMessage.f24057b.equals(this.f9148a.f9122e.f24076a)) {
                    for (int i = 0; i < this.f9148a.f9124g.getCount(); i++) {
                        if (this.f9148a.f9124g.getItem(i).f24056a == chatMessage.f24056a) {
                            ChatMessageAdapter chatMessageAdapter = this.f9148a.f9124g;
                            try {
                                chatMessageAdapter.f8918a.set(i, chatMessage);
                                chatMessageAdapter.notifyDataSetChanged();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
