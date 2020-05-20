package message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: message.a */
/* loaded from: classes2.dex */
public class XConnectionHelper {

    /* renamed from: b */
    private static XConnectionHelper f23931b;

    /* renamed from: a */
    public ExecutorService f23932a = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public static XConnectionHelper m313a() {
        if (f23931b == null) {
            synchronized (XConnectionHelper.class) {
                if (f23931b == null) {
                    f23931b = new XConnectionHelper();
                }
            }
        }
        return f23931b;
    }

    private XConnectionHelper() {
    }

    /* renamed from: b */
    public final void m312b() {
        this.f23932a.execute(new RunnableC4722b(this));
    }

    /* renamed from: c */
    public static void m311c() {
        XConnectionHelper xConnectionHelper = f23931b;
        if (xConnectionHelper != null) {
            xConnectionHelper.f23932a.shutdown();
            f23931b.f23932a = null;
            f23931b = null;
        }
    }
}
