package com.baidu.mapsdkplatform.comapi.synchronization.p090c;

import android.os.Build;
import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.a */
/* loaded from: classes.dex */
public class C1247a {

    /* renamed from: a */
    private int f6185a = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: b */
    private int f6186b = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: c */
    private ExecutorService f6187c = Executors.newCachedThreadPool();

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.a$a */
    /* loaded from: classes.dex */
    static abstract class AbstractRunnableC1249a implements Runnable {
        private AbstractRunnableC1249a() {
        }

        /* renamed from: a */
        public abstract void mo10475a();

        @Override // java.lang.Runnable
        public void run() {
            mo10475a();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", PdfBoolean.FALSE);
        }
    }

    /* renamed from: a */
    public void m10477a(final String str, final AbstractC1253c abstractC1253c) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Request URL cannot be null");
        }
        this.f6187c.submit(new AbstractRunnableC1249a() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.c.a.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1247a.AbstractRunnableC1249a
            /* renamed from: a */
            public void mo10475a() {
                C1250b c1250b = new C1250b("GET", abstractC1253c);
                c1250b.m10467b(C1247a.this.f6185a);
                c1250b.m10473a(C1247a.this.f6186b);
                c1250b.m10471a(str);
            }
        });
    }
}
