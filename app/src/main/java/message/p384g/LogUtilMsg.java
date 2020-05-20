package message.p384g;

import android.content.Context;
import android.util.Log;

/* renamed from: message.g.d */
/* loaded from: classes2.dex */
public final class LogUtilMsg {

    /* renamed from: a */
    private static int f24046a;

    /* renamed from: b */
    private static Context f24047b;

    /* renamed from: a */
    public static void m227a(String str, String str2) {
        if (4 >= f24046a) {
            if (str2 != null) {
                Log.e(str, str2);
            } else {
                Log.e("Golo3.0Client", "info null");
            }
        }
    }
}
