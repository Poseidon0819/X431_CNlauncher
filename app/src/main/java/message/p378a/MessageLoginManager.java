package message.p378a;

import message.model.MessageLoginEntity;
import message.p383f.SharePreferenceMsgUtils;

/* renamed from: message.a.b */
/* loaded from: classes2.dex */
public final class MessageLoginManager {
    /* renamed from: a */
    public static void m307a(String str) {
        SharePreferenceMsgUtils.m248a().m244a(new MessageLoginEntity(str));
    }

    /* renamed from: b */
    public static MessageLoginEntity m306b(String str) {
        if (SharePreferenceMsgUtils.m246a(str) != null) {
            return SharePreferenceMsgUtils.m246a(str).m242c();
        }
        return null;
    }
}
