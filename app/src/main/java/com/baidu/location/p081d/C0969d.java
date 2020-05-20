package com.baidu.location.p081d;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p084g.C1005a;
import com.baidu.location.p084g.C1006b;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.baidu.location.d.d */
/* loaded from: classes.dex */
public final class C0969d {

    /* renamed from: a */
    public static final String f4309a = C1005a.f4481a;

    /* renamed from: b */
    static final String f4310b = "http://ofloc.map.baidu.com/offline_loc";

    /* renamed from: c */
    private static Context f4311c;

    /* renamed from: d */
    private static volatile C0969d f4312d;

    /* renamed from: e */
    private final File f4313e;

    /* renamed from: f */
    private final C0976f f4314f;

    /* renamed from: g */
    private final C0960b f4315g;

    /* renamed from: h */
    private final C0978g f4316h;

    /* renamed from: i */
    private final C0966c f4317i;

    /* renamed from: com.baidu.location.d.d$a */
    /* loaded from: classes.dex */
    public enum EnumC0971a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    /* renamed from: com.baidu.location.d.d$b */
    /* loaded from: classes.dex */
    public enum EnumC0972b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.d$c */
    /* loaded from: classes.dex */
    public enum EnumC0973c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private C0969d() {
        File file;
        try {
            file = new File(f4311c.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            file = null;
        }
        this.f4313e = file;
        this.f4315g = new C0960b(this);
        this.f4314f = new C0976f(this.f4315g.m11914a());
        this.f4317i = new C0966c(this, this.f4315g.m11914a());
        this.f4316h = new C0978g(this, this.f4315g.m11914a(), this.f4317i.m11826n());
    }

    /* renamed from: a */
    private BDLocation m11805a(final String[] strArr) {
        new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = (FutureTask) newSingleThreadExecutor.submit(new Callable<BDLocation>() { // from class: com.baidu.location.d.d.1
            /* JADX WARN: Can't wrap try/catch for region: R(8:3|(4:6|7|(1:9)(1:10)|4)|68|(4:47|48|49|50)(8:12|13|14|15|16|(2:23|24)|18|(1:22))|31|32|30|(2:20|22)) */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
                if (r0 != null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
                if (r0 == null) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
                if (r0 == null) goto L30;
             */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.baidu.location.BDLocation call() {
                /*
                    r11 = this;
                    com.baidu.location.BDLocation r0 = new com.baidu.location.BDLocation
                    r0.<init>()
                    java.lang.String[] r1 = r2
                    int r1 = r1.length
                    if (r1 <= 0) goto L9a
                    com.baidu.location.d.d r0 = com.baidu.location.p081d.C0969d.this
                    com.baidu.location.d.c r0 = com.baidu.location.p081d.C0969d.m11808a(r0)
                    java.lang.String[] r0 = r0.m11824o()
                    r1 = 0
                    r2 = 0
                    r4 = r2
                    r3 = 0
                L18:
                    int r5 = r0.length
                    if (r3 >= r5) goto L30
                    android.content.Context r4 = com.baidu.location.p081d.C0969d.m11787p()     // Catch: java.lang.Exception -> L2a
                    android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Exception -> L2a
                    r5 = r0[r3]     // Catch: java.lang.Exception -> L2a
                    android.content.pm.ProviderInfo r4 = r4.resolveContentProvider(r5, r1)     // Catch: java.lang.Exception -> L2a
                    goto L2b
                L2a:
                    r4 = r2
                L2b:
                    if (r4 != 0) goto L30
                    int r3 = r3 + 1
                    goto L18
                L30:
                    if (r4 == 0) goto L5e
                    android.content.Context r0 = com.baidu.location.p081d.C0969d.m11787p()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    android.content.ContentResolver r5 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    java.lang.String r0 = r4.authority     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    android.net.Uri r6 = com.baidu.location.p081d.C0969d.m11802b(r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    java.lang.String[] r7 = r2     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    android.database.Cursor r0 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L5a
                    com.baidu.location.BDLocation r2 = com.baidu.location.p081d.C0974e.m11783a(r0)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L5b
                    if (r0 == 0) goto L8a
                    goto L87
                L50:
                    r1 = move-exception
                    r2 = r0
                    goto L54
                L53:
                    r1 = move-exception
                L54:
                    if (r2 == 0) goto L59
                    r2.close()     // Catch: java.lang.Exception -> L59
                L59:
                    throw r1
                L5a:
                    r0 = r2
                L5b:
                    if (r0 == 0) goto L8a
                    goto L87
                L5e:
                    com.baidu.location.d.e$a r0 = new com.baidu.location.d.e$a
                    java.lang.String[] r1 = r2
                    r0.<init>(r1)
                    com.baidu.location.d.d r1 = com.baidu.location.p081d.C0969d.this     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L84
                    com.baidu.location.d.b r1 = com.baidu.location.p081d.C0969d.m11803b(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L84
                    android.database.Cursor r0 = r1.m11904a(r0)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L84
                    com.baidu.location.BDLocation r1 = com.baidu.location.p081d.C0974e.m11783a(r0)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85
                    if (r0 == 0) goto L78
                    r0.close()     // Catch: java.lang.Exception -> L78
                L78:
                    r0 = r1
                    goto L8b
                L7a:
                    r1 = move-exception
                    r2 = r0
                    goto L7e
                L7d:
                    r1 = move-exception
                L7e:
                    if (r2 == 0) goto L83
                    r2.close()     // Catch: java.lang.Exception -> L83
                L83:
                    throw r1
                L84:
                    r0 = r2
                L85:
                    if (r0 == 0) goto L8a
                L87:
                    r0.close()     // Catch: java.lang.Exception -> L8a
                L8a:
                    r0 = r2
                L8b:
                    if (r0 == 0) goto L9a
                    int r1 = r0.getLocType()
                    r2 = 67
                    if (r1 == r2) goto L9a
                    r1 = 66
                    r0.setLocType(r1)
                L9a:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0969d.CallableC09701.call():com.baidu.location.BDLocation");
            }
        });
        try {
            return (BDLocation) futureTask.get(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            futureTask.cancel(true);
            return null;
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    /* renamed from: a */
    public static C0969d m11810a() {
        if (f4312d == null) {
            synchronized (C0969d.class) {
                if (f4312d == null) {
                    if (f4311c == null) {
                        m11809a(ServiceC1002f.getServiceContext());
                    }
                    f4312d = new C0969d();
                }
            }
        }
        f4312d.m11786q();
        return f4312d;
    }

    /* renamed from: a */
    public static void m11809a(Context context) {
        if (f4311c == null) {
            f4311c = context;
            C1006b.m11603a().m11602a(f4311c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final Uri m11800c(String str) {
        return Uri.parse(String.format("content://%s/", str));
    }

    /* renamed from: q */
    private void m11786q() {
        this.f4317i.m11841g();
    }

    /* renamed from: r */
    private boolean m11785r() {
        String packageName = f4311c.getPackageName();
        ProviderInfo providerInfo = null;
        for (String str : this.f4317i.m11824o()) {
            try {
                providerInfo = f4311c.getPackageManager().resolveContentProvider(str, 0);
            } catch (Exception unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                break;
            }
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    /* renamed from: a */
    public final long m11806a(String str) {
        return this.f4317i.m11869a(str);
    }

    /* renamed from: a */
    public final BDLocation m11807a(C0986a c0986a, C0997e c0997e, BDLocation bDLocation, EnumC0972b enumC0972b, EnumC0971a enumC0971a) {
        String m11595e;
        int i;
        if (enumC0972b == EnumC0972b.IS_MIX_MODE) {
            i = this.f4317i.m11876a();
            m11595e = C1006b.m11603a().m11595e() + "&mixMode=1";
        } else {
            m11595e = C1006b.m11603a().m11595e();
            i = 0;
        }
        String[] m11779a = C0974e.m11779a(c0986a, c0997e, bDLocation, m11595e, (enumC0971a == EnumC0971a.NEED_TO_LOG ? Boolean.TRUE : Boolean.FALSE).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (m11779a.length > 0 && (bDLocation2 = m11805a(m11779a)) != null) {
            bDLocation2.getLocType();
        }
        return bDLocation2;
    }

    /* renamed from: b */
    public final Context m11804b() {
        return f4311c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final File m11801c() {
        return this.f4313e;
    }

    /* renamed from: d */
    public final boolean m11799d() {
        return this.f4317i.m11838h();
    }

    /* renamed from: e */
    public final boolean m11798e() {
        return this.f4317i.m11836i();
    }

    /* renamed from: f */
    public final boolean m11797f() {
        return this.f4317i.m11834j();
    }

    /* renamed from: g */
    public final boolean m11796g() {
        return this.f4317i.m11832k();
    }

    /* renamed from: h */
    public final boolean m11795h() {
        return this.f4317i.m11828m();
    }

    /* renamed from: i */
    public final void m11794i() {
        this.f4314f.m11778a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final C0976f m11793j() {
        return this.f4314f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final C0978g m11792k() {
        return this.f4316h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final C0966c m11791l() {
        return this.f4317i;
    }

    /* renamed from: m */
    public final void m11790m() {
        if (m11785r()) {
            this.f4315g.m11896b();
        }
    }

    /* renamed from: n */
    public final void m11789n() {
    }

    /* renamed from: o */
    public final double m11788o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f4311c.getSystemService("connectivity")).getActiveNetworkInfo();
        EnumC0973c enumC0973c = EnumC0973c.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                enumC0973c = EnumC0973c.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    enumC0973c = EnumC0973c.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    enumC0973c = EnumC0973c.NETWORK_3G;
                } else if (subtype == 13) {
                    enumC0973c = EnumC0973c.NETWORK_4G;
                }
            }
        }
        if (enumC0973c == EnumC0973c.NETWORK_UNKNOWN) {
            return this.f4317i.m11867b();
        }
        if (enumC0973c == EnumC0973c.NETWORK_WIFI) {
            return this.f4317i.m11861c();
        }
        if (enumC0973c == EnumC0973c.NETWORK_2G) {
            return this.f4317i.m11855d();
        }
        if (enumC0973c == EnumC0973c.NETWORK_3G) {
            return this.f4317i.m11849e();
        }
        if (enumC0973c == EnumC0973c.NETWORK_4G) {
            return this.f4317i.m11844f();
        }
        return 0.0d;
    }
}
