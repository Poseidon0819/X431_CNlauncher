package message.p384g;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: message.g.h */
/* loaded from: classes2.dex */
public final class TimeRender {

    /* renamed from: a */
    private static SimpleDateFormat f24055a = new SimpleDateFormat("MM-dd  HH:mm:ss");

    /* renamed from: a */
    public static String m219a() {
        return f24055a.format(new Date());
    }
}
