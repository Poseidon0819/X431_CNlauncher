package com.baidu.location.p078a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1016g;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.baidu.location.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC0907g {

    /* renamed from: c */
    public static String f3979c;

    /* renamed from: a */
    public C0997e f3980a = null;

    /* renamed from: b */
    public C0986a f3981b = null;

    /* renamed from: e */
    private boolean f3983e = true;

    /* renamed from: f */
    private boolean f3984f = true;

    /* renamed from: g */
    private boolean f3985g = false;

    /* renamed from: d */
    final Handler f3982d = new HandlerC0908a();

    /* renamed from: h */
    private String f3986h = null;

    /* renamed from: i */
    private String f3987i = null;

    /* renamed from: com.baidu.location.a.g$a */
    /* loaded from: classes.dex */
    public class HandlerC0908a extends Handler {
        public HandlerC0908a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            if (ServiceC1002f.isServing) {
                int i = message2.what;
                if (i == 21) {
                    AbstractC0907g.this.mo12118a(message2);
                    return;
                }
                switch (i) {
                    case 62:
                    case 63:
                        AbstractC0907g.this.mo12119a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.g$b */
    /* loaded from: classes.dex */
    public class C0909b extends AbstractC1011e {

        /* renamed from: a */
        String f3989a = null;

        /* renamed from: b */
        String f3990b = null;

        public C0909b() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4522h = C1016g.m11557c();
            if ((C1016g.f4598h || C1016g.f4599i) && AbstractC0907g.this.f3986h != null && AbstractC0907g.this.f3987i != null) {
                this.f3990b += String.format(Locale.CHINA, "&ki=%s&sn=%s", AbstractC0907g.this.f3986h, AbstractC0907g.this.f3987i);
            }
            String encodeTp4 = Jni.encodeTp4(this.f3990b);
            this.f3990b = null;
            if (this.f3989a == null) {
                this.f3989a = C0932p.m12037b();
            }
            this.f4525k.put("bloc", encodeTp4);
            if (this.f3989a != null) {
                this.f4525k.put("up", this.f3989a);
            }
            this.f4525k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        /* renamed from: a */
        public void m12150a(String str) {
            this.f3990b = str;
            m11575c(C1016g.f4596f);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo11388a(boolean r7) {
            /*
                r6 = this;
                r0 = 63
                if (r7 == 0) goto L80
                java.lang.String r7 = r6.f4524j
                if (r7 == 0) goto L80
                java.lang.String r7 = r6.f4524j     // Catch: java.lang.Exception -> L80
                com.baidu.location.p078a.AbstractC0907g.f3979c = r7     // Catch: java.lang.Exception -> L80
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L41
                r1.<init>(r7)     // Catch: java.lang.Exception -> L41
                int r2 = r1.getLocType()     // Catch: java.lang.Exception -> L41
                r3 = 161(0xa1, float:2.26E-43)
                if (r2 != r3) goto L20
                com.baidu.location.a.f r2 = com.baidu.location.p078a.C0905f.m12169a()     // Catch: java.lang.Exception -> L41
                r2.m12164a(r7)     // Catch: java.lang.Exception -> L41
            L20:
                com.baidu.location.e.b r7 = com.baidu.location.p082e.C0987b.m11732a()     // Catch: java.lang.Exception -> L41
                int r7 = r7.m11713h()     // Catch: java.lang.Exception -> L41
                r1.setOperators(r7)     // Catch: java.lang.Exception -> L41
                com.baidu.location.a.l r7 = com.baidu.location.p078a.C0924l.m12078a()     // Catch: java.lang.Exception -> L41
                boolean r7 = r7.m12073d()     // Catch: java.lang.Exception -> L41
                if (r7 == 0) goto L4a
                com.baidu.location.a.l r7 = com.baidu.location.p078a.C0924l.m12078a()     // Catch: java.lang.Exception -> L41
                float r7 = r7.m12072e()     // Catch: java.lang.Exception -> L41
                r1.setDirection(r7)     // Catch: java.lang.Exception -> L41
                goto L4a
            L41:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L80
                r1.<init>()     // Catch: java.lang.Exception -> L80
                r7 = 0
                r1.setLocType(r7)     // Catch: java.lang.Exception -> L80
            L4a:
                r7 = 0
                r6.f3989a = r7     // Catch: java.lang.Exception -> L80
                int r7 = r1.getLocType()     // Catch: java.lang.Exception -> L80
                if (r7 != 0) goto L75
                double r2 = r1.getLatitude()     // Catch: java.lang.Exception -> L80
                r4 = 1
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 != 0) goto L75
                double r2 = r1.getLongitude()     // Catch: java.lang.Exception -> L80
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 != 0) goto L75
                com.baidu.location.a.g r7 = com.baidu.location.p078a.AbstractC0907g.this     // Catch: java.lang.Exception -> L80
                android.os.Handler r7 = r7.f3982d     // Catch: java.lang.Exception -> L80
                android.os.Message r7 = r7.obtainMessage(r0)     // Catch: java.lang.Exception -> L80
                java.lang.String r1 = "HttpStatus error"
            L6f:
                r7.obj = r1     // Catch: java.lang.Exception -> L80
                r7.sendToTarget()     // Catch: java.lang.Exception -> L80
                goto L8f
            L75:
                com.baidu.location.a.g r7 = com.baidu.location.p078a.AbstractC0907g.this     // Catch: java.lang.Exception -> L80
                android.os.Handler r7 = r7.f3982d     // Catch: java.lang.Exception -> L80
                r2 = 21
                android.os.Message r7 = r7.obtainMessage(r2)     // Catch: java.lang.Exception -> L80
                goto L6f
            L80:
                com.baidu.location.a.g r7 = com.baidu.location.p078a.AbstractC0907g.this
                android.os.Handler r7 = r7.f3982d
                android.os.Message r7 = r7.obtainMessage(r0)
                java.lang.String r0 = "HttpStatus error"
                r7.obj = r0
                r7.sendToTarget()
            L8f:
                java.util.Map<java.lang.String, java.lang.Object> r7 = r6.f4525k
                if (r7 == 0) goto L98
                java.util.Map<java.lang.String, java.lang.Object> r7 = r6.f4525k
                r7.clear()
            L98:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.AbstractC0907g.C0909b.mo11388a(boolean):void");
        }
    }

    /* renamed from: a */
    public String m12153a(String str) {
        C0997e c0997e;
        String m11623m;
        if (this.f3986h == null) {
            this.f3986h = C0910h.m12146b(ServiceC1002f.getServiceContext());
        }
        if (this.f3987i == null) {
            this.f3987i = C0910h.m12145c(ServiceC1002f.getServiceContext());
        }
        C0986a c0986a = this.f3981b;
        if (c0986a == null || !c0986a.m11742a()) {
            this.f3981b = C0987b.m11732a().m11715f();
        }
        C0997e c0997e2 = this.f3980a;
        if (c0997e2 == null || !c0997e2.m11644j()) {
            this.f3980a = C0998f.m11640a().m11620p();
        }
        Location m11668h = C0991d.m11704a().m11666j() ? C0991d.m11704a().m11668h() : null;
        C0986a c0986a2 = this.f3981b;
        if ((c0986a2 == null || c0986a2.m11738d() || this.f3981b.m11739c()) && (((c0997e = this.f3980a) == null || c0997e.m11664a() == 0) && m11668h == null)) {
            return null;
        }
        String m12152b = m12152b();
        if (C0905f.m12169a().m12158d() == -2) {
            m12152b = m12152b + "&imo=1";
        }
        int m11556c = C1016g.m11556c(ServiceC1002f.getServiceContext());
        if (m11556c >= 0) {
            m12152b = m12152b + "&lmd=" + m11556c;
        }
        C0997e c0997e3 = this.f3980a;
        if ((c0997e3 == null || c0997e3.m11664a() == 0) && (m11623m = C0998f.m11640a().m11623m()) != null) {
            m12152b = m11623m + m12152b;
        }
        String str2 = m12152b;
        if (this.f3984f) {
            this.f3984f = false;
            return C1016g.m11567a(this.f3981b, this.f3980a, m11668h, str2, 0, true);
        }
        return C1016g.m11568a(this.f3981b, this.f3980a, m11668h, str2, 0);
    }

    /* renamed from: a */
    public abstract void mo12119a();

    /* renamed from: a */
    public abstract void mo12118a(Message message2);

    /* renamed from: b */
    public String m12152b() {
        String m12242f = C0892a.m12261a().m12242f();
        String format = C0998f.m11626j() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(C0987b.m11732a().m11716e()));
        if (this.f3983e) {
            this.f3983e = false;
            String m11617s = C0998f.m11640a().m11617s();
            if (!TextUtils.isEmpty(m11617s) && !m11617s.equals("02:00:00:00:00:00")) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, m11617s.replace(":", ""));
            }
            int i = Build.VERSION.SDK_INT;
        } else if (!this.f3985g) {
            String m12029f = C0932p.m12029f();
            if (m12029f != null) {
                format = format + m12029f;
            }
            this.f3985g = true;
        }
        return format + m12242f;
    }
}
