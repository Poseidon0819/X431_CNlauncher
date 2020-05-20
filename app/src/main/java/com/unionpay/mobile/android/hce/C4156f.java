package com.unionpay.mobile.android.hce;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.hce.service.InterfaceC4163a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.hce.f */
/* loaded from: classes2.dex */
public class C4156f {

    /* renamed from: w */
    private static final Object f22180w = new Object();

    /* renamed from: a */
    private Context f22181a;

    /* renamed from: b */
    private InterfaceC4148a f22182b;

    /* renamed from: c */
    private Handler f22183c;

    /* renamed from: d */
    private String f22184d;

    /* renamed from: e */
    private String f22185e;

    /* renamed from: f */
    private int f22186f = 0;

    /* renamed from: g */
    private int f22187g = 0;

    /* renamed from: h */
    private int f22188h = 10;

    /* renamed from: i */
    private int f22189i = 1000;

    /* renamed from: j */
    private String f22190j = "hce";

    /* renamed from: k */
    private String f22191k = "";

    /* renamed from: m */
    private String f22193m = "";

    /* renamed from: n */
    private HashMap<String, C4161k> f22194n = new HashMap<>(0);

    /* renamed from: o */
    private List<C4161k> f22195o = new ArrayList(0);

    /* renamed from: p */
    private HashMap<Integer, C4161k> f22196p = new HashMap<>(0);

    /* renamed from: q */
    private int f22197q = 0;

    /* renamed from: r */
    private int f22198r = 1;

    /* renamed from: s */
    private int f22199s = 0;

    /* renamed from: t */
    private int f22200t = 5;

    /* renamed from: u */
    private ConcurrentHashMap<String, C4154d> f22201u = new ConcurrentHashMap<>(0);

    /* renamed from: v */
    private ConcurrentHashMap<String, C4162l> f22202v = new ConcurrentHashMap<>(0);

    /* renamed from: x */
    private final Handler.Callback f22203x = new C4157g(this);

    /* renamed from: y */
    private Handler f22204y = new Handler(this.f22203x);

    /* renamed from: l */
    private String f22192l = "20150801000000000000";

    public C4156f(Context context) {
        this.f22181a = context;
        this.f22182b = (InterfaceC4148a) ((BaseActivity) context).mo476a(UPPayEngine.class.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1588a(C4156f c4156f) {
        for (Map.Entry<String, C4161k> entry : c4156f.f22194n.entrySet()) {
            C4161k value = entry.getValue();
            if (!value.m1565a()) {
                String m1564b = value.m1564b();
                String m1561e = value.m1561e();
                if (C4382c.m886a(c4156f.f22181a, m1564b) && m1561e.equalsIgnoreCase(C4382c.m882b(c4156f.f22181a, m1564b))) {
                    c4156f.f22197q++;
                    c4156f.f22196p.put(Integer.valueOf(c4156f.f22197q), value);
                    c4156f.f22202v.put(m1564b, new C4162l(m1564b));
                    c4156f.f22201u.put(m1564b, new C4154d(m1564b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1587a(C4156f c4156f, String str) {
        C4154d c4154d = c4156f.f22201u.get(str);
        C4162l c4162l = c4156f.f22202v.get(str);
        if (c4154d.m1601a() && c4162l.m1559a()) {
            c4156f.f22204y.removeMessages(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, str);
            String m1555c = c4162l.m1555c();
            InterfaceC4163a m1556b = c4162l.m1556b();
            String m1596c = c4154d.m1596c();
            ServiceConnection m1595d = c4154d.m1595d();
            if (m1555c != null && !TextUtils.isEmpty(m1555c) && m1596c != null && !TextUtils.isEmpty(m1596c)) {
                String m1607a = C4151a.m1607a(m1596c, m1555c);
                C4390k.m836c("uppay-hce", str + " card after: " + m1607a);
                try {
                    JSONArray jSONArray = new JSONArray(m1607a);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        Object obj = jSONArray.get(i);
                        if (obj != null) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (C4173b.f22370bb == null) {
                                C4173b.f22370bb = new ArrayList(1);
                            }
                            C4153c c4153c = new C4153c(jSONObject, m1555c, m1556b, m1595d);
                            boolean z = false;
                            for (int i2 = 0; C4173b.f22370bb != null && i2 < C4173b.f22370bb.size(); i2++) {
                                if (!TextUtils.isEmpty(c4153c.mo1538a()) && c4153c.mo1538a().equalsIgnoreCase(C4173b.f22370bb.get(i2).mo1538a())) {
                                    z = true;
                                }
                            }
                            if (!z) {
                                C4173b.f22370bb.add(c4153c);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c4154d.m1593f();
            c4156f.f22201u.put(str, c4154d);
            c4162l.m1553e();
            c4156f.f22202v.put(str, c4162l);
            synchronized (f22180w) {
                c4156f.f22199s--;
            }
            c4156f.m1583b();
        }
        for (Map.Entry<String, C4154d> entry : c4156f.f22201u.entrySet()) {
            if (!entry.getValue().m1598b()) {
                return;
            }
        }
        C4390k.m836c("uppay", "hce finished !!!!!!!!!!!!");
        C4173b.f22371bl = true;
        Handler handler = c4156f.f22183c;
        if (handler != null) {
            c4156f.f22183c.sendMessage(handler.obtainMessage(0));
        }
    }

    /* renamed from: a */
    private boolean m1590a(Bundle bundle) {
        String string = bundle.getString("action_resp_code");
        String string2 = bundle.getString("action_resp_message");
        if ("0000".equalsIgnoreCase(string) && string2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                String m846a = C4389j.m846a(jSONObject, "resp");
                C4389j.m846a(jSONObject, "msg");
                JSONObject m843c = C4389j.m843c(jSONObject, Constant.KEY_PARAMS);
                if (m846a.equalsIgnoreCase("00")) {
                    this.f22184d = C4389j.m843c(m843c, "signature").toString();
                    JSONArray m842d = C4389j.m842d(m843c, "configs");
                    if (m842d != null) {
                        for (int i = 0; i < m842d.length(); i++) {
                            this.f22195o.add(new C4161k(m842d.getJSONObject(i)));
                            this.f22193m = C4389j.m846a(m843c, "version");
                        }
                    }
                    int intValue = Integer.decode(C4389j.m846a(m843c, "total_count")).intValue();
                    if (intValue > this.f22188h) {
                        this.f22187g = intValue / this.f22188h;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1584a(String str, String str2) {
        ServiceConnectionC4159i serviceConnectionC4159i = new ServiceConnectionC4159i(this, str, str2);
        C4154d c4154d = new C4154d(str);
        c4154d.m1600a(serviceConnectionC4159i);
        this.f22201u.put(str, c4154d);
        try {
            Intent intent = new Intent();
            intent.setAction("com.unionpay.uppay.action.HCE");
            intent.setPackage(str);
            this.f22181a.startService(intent);
            return this.f22181a.bindService(intent, serviceConnectionC4159i, 1);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Bundle m1573d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", "1.9");
            jSONObject.put("cmd", this.f22190j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("base_version", str);
            bundle.putString("action_resp_message", this.f22182b.mo833a(jSONObject.toString()));
            m1590a(bundle);
            this.f22186f++;
            if (this.f22186f <= this.f22187g) {
                m1573d(this.f22192l);
            }
            return bundle;
        } catch (JSONException unused) {
            bundle.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ void m1566k(C4156f c4156f) {
        HashMap<String, C4161k> hashMap;
        if (!TextUtils.isEmpty(c4156f.f22193m)) {
            for (C4161k c4161k : c4156f.f22195o) {
                c4156f.f22194n.put(c4161k.m1564b(), c4161k);
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, C4161k> entry : c4156f.f22194n.entrySet()) {
                jSONArray.put(entry.getValue().m1560f());
            }
            PreferenceUtils.m903a(c4156f.f22181a, c4156f.f22193m, "hce_version");
            PreferenceUtils.m903a(c4156f.f22181a, jSONArray.toString(), "hce_info");
        }
        if (TextUtils.isEmpty(c4156f.f22191k) || (hashMap = c4156f.f22194n) == null || hashMap.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<String, C4161k>> it = c4156f.f22194n.entrySet().iterator();
        while (it.hasNext()) {
            if (!c4156f.f22191k.equals(it.next().getValue().m1563c())) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public final void m1592a() {
        this.f22186f = 1;
    }

    /* renamed from: a */
    public final void m1591a(int i) {
        this.f22188h = i;
    }

    /* renamed from: a */
    public final void m1589a(Handler handler) {
        this.f22183c = handler;
    }

    /* renamed from: a */
    public final void m1585a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22190j = str;
    }

    /* renamed from: b */
    public final void m1583b() {
        if (this.f22197q == 0) {
            C4173b.f22371bl = true;
            Handler handler = this.f22183c;
            if (handler != null) {
                this.f22183c.sendMessage(handler.obtainMessage(0));
                return;
            }
            return;
        }
        synchronized (f22180w) {
            for (int i = this.f22198r; i <= this.f22197q && this.f22199s < this.f22200t; i++) {
                C4161k c4161k = this.f22196p.get(Integer.valueOf(i));
                String m1564b = c4161k.m1564b();
                String m1562d = c4161k.m1562d();
                this.f22199s++;
                new C4158h(this, m1564b, m1562d).start();
                this.f22198r++;
            }
        }
    }

    /* renamed from: b */
    public final void m1582b(int i) {
        if (i > 0) {
            this.f22189i = i;
        }
    }

    /* renamed from: b */
    public final void m1579b(String str) {
        this.f22185e = str;
    }

    /* renamed from: c */
    public final void m1578c() {
        if (C4173b.f22370bb != null) {
            C4173b.f22370bb.clear();
            C4173b.f22370bb = null;
        }
        String m904a = PreferenceUtils.m904a(this.f22181a, "hce_version");
        if (!TextUtils.isEmpty(m904a)) {
            this.f22192l = m904a;
        }
        String m904a2 = PreferenceUtils.m904a(this.f22181a, "hce_info");
        if (TextUtils.isEmpty(m904a2)) {
            m904a2 = "[{\"package\":\"com.yitong.mbank0408\",\"issuer\":\"64083300\",\"syn_key\":\"0123456789ABCDEF1010101010101010\",\"pub_key\":\"268576AF6F50DA40196E18D6E059D2A721373638\",\"status\":\"I\",\"priority\":\"1\"}]";
        }
        try {
            JSONArray jSONArray = new JSONArray(m904a2);
            for (int i = 0; i < jSONArray.length(); i++) {
                C4161k c4161k = new C4161k(jSONArray.getJSONObject(i));
                this.f22194n.put(c4161k.m1564b(), c4161k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new RunnableC4160j(this)).start();
    }

    /* renamed from: c */
    public final void m1577c(int i) {
        if (i > 0) {
            this.f22200t = i;
        }
    }

    /* renamed from: c */
    public final void m1575c(String str) {
        this.f22191k = str;
    }
}
