package message.p384g;

import com.cnlaunch.golo3.p165g.NewThreadExecutors;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: message.g.e */
/* loaded from: classes2.dex */
public class MessageThreadPoolManager {

    /* renamed from: d */
    private static MessageThreadPoolManager f24048d;

    /* renamed from: a */
    private ThreadPoolExecutor f24049a = (ThreadPoolExecutor) NewThreadExecutors.m9127a();

    /* renamed from: b */
    private Map<String, List<WeakReference<Future<?>>>> f24050b = new WeakHashMap();

    /* renamed from: c */
    private String f24051c;

    private MessageThreadPoolManager(String str) {
        this.f24051c = str;
    }

    /* renamed from: a */
    public static MessageThreadPoolManager m225a(String str) {
        if (f24048d == null) {
            synchronized (MessageThreadPoolManager.class) {
                if (f24048d == null) {
                    f24048d = new MessageThreadPoolManager(str);
                }
            }
        }
        MessageThreadPoolManager messageThreadPoolManager = f24048d;
        messageThreadPoolManager.f24051c = str;
        return messageThreadPoolManager;
    }

    /* renamed from: a */
    public final void m226a(Runnable runnable) {
        m224a(this.f24049a.submit(runnable));
    }

    /* renamed from: a */
    private void m224a(Future<?> future) {
        synchronized (MessageThreadPoolManager.class) {
            if (this.f24051c != null) {
                List<WeakReference<Future<?>>> list = this.f24050b.get(this.f24051c);
                if (list == null) {
                    list = new LinkedList<>();
                    this.f24050b.put(this.f24051c, list);
                }
                list.add(new WeakReference<>(future));
            }
        }
    }
}
