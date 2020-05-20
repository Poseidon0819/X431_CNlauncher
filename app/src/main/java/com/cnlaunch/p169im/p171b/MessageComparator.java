package com.cnlaunch.p169im.p171b;

import android.util.Log;
import java.util.Comparator;
import java.util.Date;
import message.model.ChatMessage;

/* renamed from: com.cnlaunch.im.b.a */
/* loaded from: classes.dex */
public final class MessageComparator implements Comparator<ChatMessage> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
        return m8878a(chatMessage, chatMessage2);
    }

    /* renamed from: a */
    private static int m8878a(ChatMessage chatMessage, ChatMessage chatMessage2) {
        try {
            return new Date(chatMessage.f24062g.longValue()).before(new Date(chatMessage2.f24062g.longValue())) ? -1 : 1;
        } catch (Exception e) {
            Log.e("Sanda", "MessageComparator Exception e:" + e.getMessage());
            return 1;
        }
    }
}
