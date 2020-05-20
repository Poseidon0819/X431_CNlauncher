package com.cnlaunch.p120d.p125c.p127b;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.MatcoContants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.AsyncHttpClient;
import com.cnlaunch.p120d.p125c.p128c.AsyncHttpResponseHandler;
import com.cnlaunch.p120d.p125c.p128c.BreakpointHttpResponseHandler;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.jivesoftware.smackx.packet.MultipleAddresses;

/* renamed from: com.cnlaunch.d.c.b.b */
/* loaded from: classes.dex */
public class DownloadManager extends Thread {

    /* renamed from: e */
    private static volatile DownloadManager f7052e;

    /* renamed from: a */
    public DownLoadCallback f7053a;

    /* renamed from: b */
    public DownLoadCallback f7054b;

    /* renamed from: k */
    private AsyncHttpClient f7062k;

    /* renamed from: o */
    private boolean f7066o;

    /* renamed from: p */
    private boolean f7067p;

    /* renamed from: d */
    private int f7056d = 3;

    /* renamed from: f */
    private final String f7057f = DownloadManager.class.getSimpleName();

    /* renamed from: c */
    public Boolean f7055c = Boolean.FALSE;

    /* renamed from: m */
    private String f7064m = "";

    /* renamed from: n */
    private String f7065n = "";

    /* renamed from: q */
    private boolean f7068q = true;

    /* renamed from: r */
    private boolean f7069r = false;

    /* renamed from: s */
    private String f7070s = MatcoContants.f6995c;

    /* renamed from: t */
    private String f7071t = MatcoContants.f6999g;

    /* renamed from: u */
    private String f7072u = MatcoContants.f6997e;

    /* renamed from: g */
    private C1421a f7058g = new C1421a();

    /* renamed from: i */
    private List<AsyncHttpResponseHandler> f7060i = new ArrayList();

    /* renamed from: j */
    private List<AsyncHttpResponseHandler> f7061j = new ArrayList();

    /* renamed from: h */
    private List<DownloadParam> f7059h = new ArrayList();

    /* renamed from: l */
    private volatile ThreadPoolExecutor f7063l = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.f7056d);

    /* renamed from: a */
    public static DownloadManager m9565a() {
        if (f7052e == null) {
            synchronized (DownloadManager.class) {
                if (f7052e == null) {
                    f7052e = new DownloadManager();
                }
            }
        }
        return f7052e;
    }

    /* renamed from: d */
    private static synchronized void m9544d() {
        synchronized (DownloadManager.class) {
            f7052e = null;
        }
    }

    /* renamed from: a */
    private void m9564a(Context context) {
        String str;
        this.f7064m = PreferencesManager.m9595a(context).m9591a("htt_station_id");
        this.f7065n = PreferencesManager.m9595a(context).m9591a("htt_station_token");
        String str2 = this.f7064m;
        if (str2 == null || str2.isEmpty() || (str = this.f7065n) == null || str.isEmpty()) {
            this.f7064m = PreferencesManager.m9595a(context).m9591a("user_id");
            this.f7065n = PreferencesManager.m9595a(context).m9591a("token");
        }
    }

    /* renamed from: b */
    public final void m9556b() {
        if (isAlive()) {
            return;
        }
        this.f7055c = Boolean.TRUE;
        try {
            interrupt();
            start();
            if (this.f7053a != null) {
                this.f7053a.m9573a();
            }
            if (this.f7054b != null) {
                this.f7054b.m9573a();
            }
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m9549c() {
        this.f7055c = Boolean.FALSE;
        m9542e();
        DownLoadCallback downLoadCallback = this.f7053a;
        if (downLoadCallback != null) {
            downLoadCallback.m9570b();
        }
        DownLoadCallback downLoadCallback2 = this.f7054b;
        if (downLoadCallback2 != null) {
            downLoadCallback2.m9570b();
        }
        interrupt();
        m9544d();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.f7055c.booleanValue()) {
            synchronized (this.f7058g) {
                if (!this.f7058g.m9537c()) {
                    if (this.f7063l.getActiveCount() < this.f7056d) {
                        DownloadParam m9541a = this.f7058g.m9541a();
                        if (m9541a != null) {
                            BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) m9547c(m9541a);
                            if (this.f7066o && (this.f7070s.equals(breakpointHttpResponseHandler.f7114e) || this.f7071t.equals(breakpointHttpResponseHandler.f7114e) || this.f7072u.equals(breakpointHttpResponseHandler.f7114e))) {
                                m9551b(breakpointHttpResponseHandler);
                            } else {
                                m9559a(breakpointHttpResponseHandler);
                            }
                        }
                    } else {
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (this.f7060i.isEmpty()) {
                    this.f7055c = Boolean.FALSE;
                }
            }
        }
    }

    /* renamed from: a */
    private void m9559a(BreakpointHttpResponseHandler breakpointHttpResponseHandler) {
        NLog.m9456a("yhx", "addDownload enter, handler=".concat(String.valueOf(breakpointHttpResponseHandler)));
        if (breakpointHttpResponseHandler == null || m9557a(breakpointHttpResponseHandler.f7115f)) {
            return;
        }
        this.f7060i.add(breakpointHttpResponseHandler);
        breakpointHttpResponseHandler.f7119j = false;
        this.f7062k = new AsyncHttpClient();
        this.f7062k.m9533a(this.f7063l);
        if (breakpointHttpResponseHandler.f7120k != null && breakpointHttpResponseHandler.f7113d != null) {
            m9564a(breakpointHttpResponseHandler.f7113d);
            this.f7062k.m9534a("sign", MD5Utils.m9460a(breakpointHttpResponseHandler.f7120k.m9502c() + this.f7065n));
            this.f7062k.m9534a(MultipleAddresses.f24412CC, this.f7064m);
        }
        this.f7062k.m9536a(breakpointHttpResponseHandler.f7113d, breakpointHttpResponseHandler.f7114e, breakpointHttpResponseHandler.f7120k, breakpointHttpResponseHandler);
    }

    /* renamed from: a */
    private static String m9558a(BreakpointHttpResponseHandler breakpointHttpResponseHandler, String str, List<String> list, List<String> list2) throws C1425f {
        StringBuilder sb = new StringBuilder(breakpointHttpResponseHandler.f7114e);
        if (TextUtils.isEmpty(str)) {
            throw new C1425f("BaseManager getSignUrl method IllegalArgumentException.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list2.get(i));
            sb.append(list.get(i));
            sb.append("&");
            if (!PreferencesManager.m9595a(breakpointHttpResponseHandler.f7113d).m9591a("MATCO_APPID").equals(list.get(i)) && !"TOPDON_DP".equals(list.get(i))) {
                stringBuffer.append(list.get(i));
            }
        }
        stringBuffer.append(str);
        sb.append("sign=");
        sb.append(MD5Utils.m9460a(stringBuffer.toString()));
        return sb.toString();
    }

    /* renamed from: a */
    public final boolean m9557a(String str) {
        for (int i = 0; i < this.f7060i.size(); i++) {
            try {
                BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) this.f7060i.get(i);
                if (breakpointHttpResponseHandler != null && str != null) {
                    if (str.equals(breakpointHttpResponseHandler.f7115f)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i2 = 0; i2 < this.f7058g.m9538b(); i2++) {
            try {
                DownloadParam m9540a = this.f7058g.m9540a(i2);
                if (m9540a == null) {
                    return false;
                }
                if (str.equals(m9540a.f7080e)) {
                    return true;
                }
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m9550b(String str) {
        NLog.m9456a("yhx", "hasDownloadingHandler enter,downloadId=".concat(String.valueOf(str)));
        for (int i = 0; i < this.f7060i.size(); i++) {
            try {
                BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) this.f7060i.get(i);
                NLog.m9456a("yhx", "hasDownloadingHandler,handler=".concat(String.valueOf(breakpointHttpResponseHandler)));
                if (!TextUtils.isEmpty(str) && str.equals(breakpointHttpResponseHandler.f7122m)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i2 = 0; i2 < this.f7058g.m9538b(); i2++) {
            try {
                DownloadParam m9540a = this.f7058g.m9540a(i2);
                if (m9540a == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str) && str.equals(m9540a.f7085j)) {
                    return true;
                }
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final synchronized void m9545c(String str) {
        for (int i = 0; i < this.f7060i.size(); i++) {
            try {
                BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) this.f7060i.get(i);
                if (breakpointHttpResponseHandler != null && breakpointHttpResponseHandler.f7115f.equals(str)) {
                    File file = breakpointHttpResponseHandler.f7117h;
                    if (file.exists()) {
                        file.delete();
                    }
                    File file2 = breakpointHttpResponseHandler.f7116g;
                    if (file2.exists()) {
                        file2.delete();
                    }
                    breakpointHttpResponseHandler.f7119j = true;
                    m9546c(breakpointHttpResponseHandler);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        for (int i2 = 0; i2 < this.f7058g.m9538b(); i2++) {
            DownloadParam m9540a = this.f7058g.m9540a(i2);
            if (m9540a != null && m9540a.f7080e.equals(str)) {
                this.f7058g.m9539a(m9540a);
            }
        }
        for (int i3 = 0; i3 < this.f7061j.size(); i3++) {
            BreakpointHttpResponseHandler breakpointHttpResponseHandler2 = (BreakpointHttpResponseHandler) this.f7061j.get(i3);
            if (breakpointHttpResponseHandler2 != null && breakpointHttpResponseHandler2.f7115f.equals(str)) {
                this.f7061j.remove(breakpointHttpResponseHandler2);
            }
        }
    }

    /* renamed from: e */
    private synchronized void m9542e() {
        while (this.f7058g.m9538b() > 0) {
            try {
                this.f7058g.m9539a(this.f7058g.m9540a(0));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        for (int size = this.f7060i.size() - 1; size >= 0; size--) {
            AsyncHttpResponseHandler asyncHttpResponseHandler = this.f7060i.get(size);
            if (asyncHttpResponseHandler != null) {
                m9552b(asyncHttpResponseHandler);
            }
        }
        this.f7060i.clear();
        this.f7061j.clear();
        this.f7063l.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m9560a(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) asyncHttpResponseHandler;
        if (asyncHttpResponseHandler != null) {
            if (!this.f7069r) {
                breakpointHttpResponseHandler.f7119j = true;
            }
            this.f7060i.remove(asyncHttpResponseHandler);
            if (!this.f7069r) {
                this.f7061j.add(asyncHttpResponseHandler);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m9552b(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) asyncHttpResponseHandler;
        if (asyncHttpResponseHandler != null) {
            breakpointHttpResponseHandler.f7119j = true;
            this.f7060i.remove(asyncHttpResponseHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m9546c(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (this.f7060i.contains(asyncHttpResponseHandler)) {
            this.f7060i.remove(asyncHttpResponseHandler);
            if (this.f7053a != null) {
                this.f7053a.m9572a(((BreakpointHttpResponseHandler) asyncHttpResponseHandler).f7115f);
            }
            if (this.f7054b != null) {
                this.f7054b.m9572a(((BreakpointHttpResponseHandler) asyncHttpResponseHandler).f7115f);
            }
        }
    }

    /* renamed from: c */
    private AsyncHttpResponseHandler m9547c(DownloadParam downloadParam) {
        return new C1422c(this, downloadParam, downloadParam);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadManager.java */
    /* renamed from: com.cnlaunch.d.c.b.b$a */
    /* loaded from: classes.dex */
    public static class C1421a {

        /* renamed from: a */
        Queue<DownloadParam> f7073a = new LinkedList();

        /* renamed from: a */
        public final DownloadParam m9540a(int i) {
            if (i >= m9538b()) {
                return null;
            }
            return (DownloadParam) ((LinkedList) this.f7073a).get(i);
        }

        /* renamed from: a */
        public final DownloadParam m9541a() {
            try {
                return this.f7073a.poll();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: a */
        public final boolean m9539a(DownloadParam downloadParam) {
            if (m9537c()) {
                return false;
            }
            return this.f7073a.remove(downloadParam);
        }

        /* renamed from: b */
        public final int m9538b() {
            return this.f7073a.size();
        }

        /* renamed from: c */
        public final boolean m9537c() {
            return this.f7073a.isEmpty();
        }
    }

    /* renamed from: a */
    public final void m9561a(DownloadParam downloadParam) {
        if (m9557a(downloadParam.f7080e)) {
            return;
        }
        BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) m9547c(downloadParam);
        if (this.f7066o && (this.f7070s.equals(breakpointHttpResponseHandler.f7114e) || this.f7071t.equals(breakpointHttpResponseHandler.f7114e) || this.f7072u.equals(breakpointHttpResponseHandler.f7114e))) {
            m9551b(breakpointHttpResponseHandler);
        } else {
            m9559a(breakpointHttpResponseHandler);
        }
    }

    /* renamed from: b */
    private void m9551b(BreakpointHttpResponseHandler breakpointHttpResponseHandler) {
        if (breakpointHttpResponseHandler == null || m9557a(breakpointHttpResponseHandler.f7115f)) {
            return;
        }
        this.f7060i.add(breakpointHttpResponseHandler);
        breakpointHttpResponseHandler.f7119j = false;
        this.f7062k = new AsyncHttpClient();
        this.f7062k.m9533a(this.f7063l);
        if (breakpointHttpResponseHandler.f7120k == null || breakpointHttpResponseHandler.f7113d == null) {
            return;
        }
        Object m9510a = breakpointHttpResponseHandler.f7120k.m9510a("serialNo");
        if (m9510a == null) {
            m9510a = PreferencesManager.m9595a(breakpointHttpResponseHandler.f7113d).m9591a("savedUpgradeSerialNo");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(m9510a);
        PreferencesManager m9595a = PreferencesManager.m9595a(breakpointHttpResponseHandler.f7113d);
        String m9591a = m9595a.m9591a("MATCO_LICENSE" + ((String) m9510a));
        arrayList.add(breakpointHttpResponseHandler.f7120k.m9510a("versionDetailId"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("serialNo=");
        arrayList2.add("versionDetailId=");
        if (breakpointHttpResponseHandler.f7123n == 1 || breakpointHttpResponseHandler.f7123n == 2 || "0".equals(breakpointHttpResponseHandler.f7124o)) {
            if (this.f7067p) {
                m9591a = "cZlYAjMOMuNXOEZF9sqkA5lwv0Yu6hqu";
                arrayList.add("TOPDON_DP");
                arrayList2.add("app=");
            } else {
                m9591a = PreferencesManager.m9595a(breakpointHttpResponseHandler.f7113d).m9591a("LALSTOKEN");
                arrayList.add(PreferencesManager.m9595a(breakpointHttpResponseHandler.f7113d).m9591a("MATCO_APPID"));
                arrayList2.add("app=");
            }
        }
        try {
            this.f7062k.m9535a(breakpointHttpResponseHandler.f7113d, m9558a(breakpointHttpResponseHandler, m9591a, arrayList, arrayList2), breakpointHttpResponseHandler);
        } catch (C1425f e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m9553b(DownloadParam downloadParam) {
        String str = downloadParam.f7080e;
        if (TextUtils.isEmpty(downloadParam.f7079d) || TextUtils.isEmpty(str)) {
            NLog.m9451c(this.f7057f, "addHandler url or fileName is not null.");
        } else if (TextUtils.isEmpty(downloadParam.f7081f)) {
            NLog.m9451c(this.f7057f, "addHandler downPath is not null.");
        } else if (m9557a(str)) {
            String str2 = this.f7057f;
            NLog.m9451c(str2, "addHandler fileName: " + str + " is exist.");
        } else {
            DownLoadCallback downLoadCallback = this.f7053a;
            if (downLoadCallback != null) {
                downLoadCallback.sendMessage(downLoadCallback.obtainMessage(1, new Object[]{str, Boolean.FALSE}));
            }
            C1421a c1421a = this.f7058g;
            if (c1421a == null || c1421a.f7073a == null) {
                return;
            }
            c1421a.f7073a.offer(downloadParam);
        }
    }
}
