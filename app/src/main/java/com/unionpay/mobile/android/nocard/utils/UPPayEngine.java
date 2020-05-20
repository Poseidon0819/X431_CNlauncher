package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.net.C4180c;
import com.unionpay.mobile.android.net.C4181d;
import com.unionpay.mobile.android.nocard.views.C4228bh;
import com.unionpay.mobile.android.utils.C4385f;
import com.unionpay.mobile.android.utils.C4390k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UPPayEngine implements Handler.Callback, InterfaceC4148a, Runnable {

    /* renamed from: e */
    private Context f22513e;

    /* renamed from: f */
    private Handler f22514f;

    /* renamed from: b */
    private C4181d f22510b = null;

    /* renamed from: c */
    private String f22511c = null;

    /* renamed from: d */
    private String f22512d = null;

    /* renamed from: g */
    private InterfaceC4183a f22515g = null;

    /* renamed from: h */
    private C4173b f22516h = null;

    /* renamed from: a */
    protected C4180c f22509a = null;

    /* renamed from: i */
    private long f22517i = 0;

    /* renamed from: com.unionpay.mobile.android.nocard.utils.UPPayEngine$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4183a {
        /* renamed from: a */
        void mo1426a(int i, String str);
    }

    /* renamed from: com.unionpay.mobile.android.nocard.utils.UPPayEngine$b */
    /* loaded from: classes2.dex */
    class C4184b {

        /* renamed from: a */
        public int f22518a;

        /* renamed from: b */
        public String f22519b;

        public C4184b(int i, String str) {
            this.f22518a = i;
            this.f22519b = str;
        }
    }

    public UPPayEngine(Context context) {
        this.f22513e = null;
        this.f22514f = null;
        this.f22513e = context;
        this.f22514f = new Handler(this);
    }

    private native String commonMessage(long j, String str, String str2, String str3);

    private native String decryptResponse(long j, String str);

    private native String desEncryptMessage(long j, String str, String str2);

    private native String encryptMessage(long j, String str);

    private native String followRulesMessage(long j, String str, String str2);

    private native String getServerUrl(int i, int i2, int i3);

    private native String getUserInfo(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public static String m1495i() {
        return new SimpleDateFormat("yyyyMMddhhmmss").format((Date) new java.sql.Date(System.currentTimeMillis()));
    }

    private native String initMessage(long j, String str, String str2);

    /* renamed from: n */
    private void m1489n(String str) {
        new Thread(this, str).start();
    }

    private native String openupgradeMessage(long j, String str, String str2);

    private native String payingMessage(long j, String str, String str2, String str3, String str4, String str5);

    private native String retrieveInitializeKey(long j);

    private native String rsaEncryptMessageForHFT(long j, String str);

    private native String rsaPrivateEncryptMessage(long j, String str);

    private native String ruleMessage(long j, String str, String str2);

    private native void setSessionKey(long j, String str);

    private native String unBoundMessage(long j, String str, String str2);

    @Override // com.unionpay.mobile.android.fully.InterfaceC4148a
    /* renamed from: a */
    public String mo833a(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("reqtm", m1495i());
            str2 = jSONObject.toString();
        } catch (JSONException unused) {
            str2 = str;
        }
        C4390k.m836c("uppay", "post message = ".concat(String.valueOf(str)));
        this.f22510b.m1524a(encryptMessage(this.f22517i, str2));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1499g();
        if (this.f22509a == null) {
            this.f22509a = new C4180c(this.f22510b, this.f22513e);
        }
        int m1529a = this.f22509a.m1529a();
        String m1527c = this.f22509a.m1527c();
        if (m1529a == 0) {
            String decryptResponse = decryptResponse(this.f22517i, m1527c);
            C4390k.m838a("uppay", "[ response msg ] ".concat(String.valueOf(decryptResponse)));
            return decryptResponse;
        }
        Message obtainMessage = this.f22514f.obtainMessage(2);
        obtainMessage.arg1 = m1529a;
        this.f22514f.sendMessage(obtainMessage);
        return null;
    }

    /* renamed from: a */
    public final String m1514a(String str, String str2) {
        return desEncryptMessage(this.f22517i, str, str2);
    }

    /* renamed from: a */
    public final void m1518a() {
        String serverUrl;
        StringBuilder sb;
        String str;
        if (TextUtils.isEmpty(this.f22516h.f22461bk)) {
            int i = "01".equalsIgnoreCase(this.f22516h.f22383I.f22845c) ? 1 : "02".equalsIgnoreCase(this.f22516h.f22383I.f22845c) ? 2 : "98".equalsIgnoreCase(this.f22516h.f22383I.f22845c) ? 98 : "99".equalsIgnoreCase(this.f22516h.f22383I.f22845c) ? 99 : "95".equalsIgnoreCase(this.f22516h.f22383I.f22845c) ? 95 : 0;
            C4390k.m838a("uppay", "idx  is : " + i + ", isNewTypeTn :" + this.f22516h.f22467c);
            serverUrl = getServerUrl(this.f22516h.f22470f ? 2 : this.f22516h.f22467c ? 1 : 0, i, this.f22516h.f22414aO);
        } else {
            if (this.f22516h.f22470f) {
                sb = new StringBuilder();
                sb.append(this.f22516h.f22461bk);
                str = "/app/mobile/hft";
            } else if (this.f22516h.f22467c) {
                sb = new StringBuilder();
                sb.append(this.f22516h.f22461bk);
                str = "/app/mobile/json";
            } else {
                sb = new StringBuilder();
                sb.append(this.f22516h.f22461bk);
                str = "/gateway/mobile/json";
            }
            sb.append(str);
            serverUrl = sb.toString();
        }
        C4390k.m838a("uppay", "url  is : ".concat(String.valueOf(serverUrl)));
        this.f22510b = new C4181d(serverUrl);
    }

    /* renamed from: a */
    public final void m1517a(long j) {
        this.f22517i = j;
    }

    /* renamed from: a */
    public final void m1516a(C4173b c4173b) {
        C4173b c4173b2 = this.f22516h;
        if (c4173b2 == null || c4173b2 != c4173b) {
            this.f22516h = c4173b;
        }
    }

    /* renamed from: a */
    public final void m1515a(InterfaceC4183a interfaceC4183a) {
        this.f22515g = interfaceC4183a;
    }

    /* renamed from: a */
    public final void m1513a(String str, String str2, int i) {
        this.f22510b.m1524a(commonMessage(this.f22517i, str, str2, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        if (i <= 0) {
            m1489n(str);
            return;
        }
        this.f22514f.sendMessageDelayed(this.f22514f.obtainMessage(1, str), i * 1000);
    }

    /* renamed from: a */
    public final void m1512a(String str, String str2, String str3, String str4) {
        this.f22510b.m1524a(payingMessage(this.f22517i, str, str2, str3, str4, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("pay");
    }

    /* renamed from: b */
    public final String m1511b() {
        return this.f22512d;
    }

    /* renamed from: b */
    public final void m1510b(String str) {
        this.f22511c = str;
    }

    /* renamed from: b */
    public final void m1509b(String str, String str2) {
        this.f22510b.m1524a(initMessage(this.f22517i, this.f22516h.f22470f ? C4228bh.m1389b(this.f22513e, str, "android", this.f22516h.m1545a(), this.f22516h.f22471g, this.f22516h.f22468d) : C4228bh.m1394a(this.f22513e, str, "android", this.f22516h.m1545a(), this.f22516h.f22471g, str2), m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("secret", retrieveInitializeKey(this.f22517i));
        this.f22510b.m1523a(hashMap);
        m1489n("init");
    }

    /* renamed from: c */
    public final long m1508c() {
        return this.f22517i;
    }

    /* renamed from: c */
    public final void m1507c(String str) {
        this.f22512d = str;
    }

    /* renamed from: c */
    public final void m1506c(String str, String str2) {
        m1513a(str, str2, 0);
    }

    /* renamed from: d */
    public final C4181d m1505d() {
        return this.f22510b;
    }

    /* renamed from: d */
    public final boolean m1504d(String str) {
        setSessionKey(this.f22517i, str);
        return true;
    }

    /* renamed from: e */
    public final Handler m1503e() {
        return this.f22514f;
    }

    /* renamed from: e */
    public final String m1502e(String str) {
        return encryptMessage(this.f22517i, str);
    }

    /* renamed from: f */
    public final String m1501f() {
        return this.f22511c;
    }

    /* renamed from: f */
    public final String m1500f(String str) {
        return decryptResponse(this.f22517i, str);
    }

    /* renamed from: g */
    public final String m1498g(String str) {
        return rsaPrivateEncryptMessage(this.f22517i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m1499g() {
        String m1521c = this.f22510b.m1521c();
        if (TextUtils.isEmpty(m1521c)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(m1500f(m1521c));
            String string = jSONObject.getString("cmd");
            String string2 = jSONObject.getString("reqtm");
            C4181d c4181d = this.f22510b;
            Context context = this.f22513e;
            c4181d.m1525a(context, string, this.f22516h.f22452b + string2 + C4385f.m865d(this.f22513e));
        } catch (JSONException unused) {
            this.f22510b.m1525a(this.f22513e, "uppay", "1234567890");
        }
    }

    /* renamed from: h */
    public final String m1496h(String str) {
        return rsaEncryptMessageForHFT(this.f22517i, str);
    }

    /* renamed from: h */
    public final void m1497h() {
        this.f22513e = null;
        this.f22514f.removeCallbacksAndMessages(null);
        this.f22514f = null;
        this.f22510b = null;
        this.f22516h = null;
        this.f22509a = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message2) {
        InterfaceC4183a interfaceC4183a;
        String str = null;
        if (message2.what == 0) {
            C4184b c4184b = (C4184b) message2.obj;
            if (c4184b.f22518a == 0) {
                str = decryptResponse(this.f22517i, c4184b.f22519b);
                C4390k.m838a("uppay", "resp is:".concat(String.valueOf(str)));
            }
            InterfaceC4183a interfaceC4183a2 = this.f22515g;
            if (interfaceC4183a2 != null) {
                interfaceC4183a2.mo1426a(c4184b.f22518a, str);
                C4390k.m837b("uppayEx", "UPPayEngine:" + this.f22515g.toString());
            }
        } else if (message2.what == 1) {
            m1489n((String) message2.obj);
        } else if (message2.what == 2 && (interfaceC4183a = this.f22515g) != null) {
            interfaceC4183a.mo1426a(message2.arg1, null);
        }
        return true;
    }

    /* renamed from: i */
    public final void m1494i(String str) {
        this.f22510b.m1524a(ruleMessage(this.f22517i, str, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("rule");
    }

    public native long initJNIEnv(Activity activity, int i, int i2, boolean z, String str, int i3, String str2);

    /* renamed from: j */
    public final void m1493j(String str) {
        this.f22510b.m1524a(followRulesMessage(this.f22517i, str, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("followRule");
    }

    /* renamed from: k */
    public final void m1492k(String str) {
        this.f22510b.m1524a(openupgradeMessage(this.f22517i, str, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("openupgrade");
    }

    /* renamed from: l */
    public final void m1491l(String str) {
        this.f22510b.m1524a(unBoundMessage(this.f22517i, str, m1495i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("unbindcard");
    }

    /* renamed from: m */
    public final void m1490m(String str) {
        String userInfo = getUserInfo(this.f22517i, str, m1495i());
        C4390k.m838a("uppay", "actEntrust msg:".concat(String.valueOf(userInfo)));
        this.f22510b.m1524a(userInfo);
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f22511c);
        this.f22510b.m1523a(hashMap);
        m1489n("getuserinfo");
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> m1520d;
        String str;
        String str2;
        try {
            if (this.f22516h == null || this.f22516h.f22414aO <= 0 || this.f22516h.f22414aO > 5) {
                m1520d = this.f22510b.m1520d();
                str = "magic_number";
                str2 = "20131120";
            } else {
                m1520d = this.f22510b.m1520d();
                str = "magic_number";
                str2 = "20150423";
            }
            m1520d.put(str, str2);
            m1499g();
            if (this.f22509a == null) {
                this.f22509a = new C4180c(this.f22510b, this.f22513e);
            }
            C4184b c4184b = new C4184b(this.f22509a.m1529a(), this.f22509a.m1527c());
            if (this.f22514f != null) {
                Message obtainMessage = this.f22514f.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.obj = c4184b;
                this.f22514f.sendMessage(obtainMessage);
            }
        } catch (NullPointerException | Exception unused) {
        }
    }
}
