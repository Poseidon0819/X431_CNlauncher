package com.cnlaunch.p169im.p179i;

import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import java.util.ArrayList;
import message.p380c.MessageDealHandler;

/* renamed from: com.cnlaunch.im.i.a */
/* loaded from: classes.dex */
public final class MessageListenerProvider {

    /* renamed from: a */
    private static ArrayList<MessageDealHandlerCustom> f9284a = new ArrayList<>();

    /* renamed from: b */
    private static ArrayList<Object> f9285b = new ArrayList<>();

    /* renamed from: c */
    private static ArrayList<Object> f9286c = new ArrayList<>();

    /* renamed from: a */
    public static ArrayList<MessageDealHandlerCustom> m8715a() {
        return f9284a;
    }

    /* renamed from: a */
    public static void m8714a(MessageDealHandlerCustom messageDealHandlerCustom) {
        f9284a.add(messageDealHandlerCustom);
    }

    /* renamed from: a */
    public static void m8713a(MessageDealHandler messageDealHandler) {
        f9284a.remove(messageDealHandler);
    }
}
