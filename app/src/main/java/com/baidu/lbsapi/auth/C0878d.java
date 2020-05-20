package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.d */
/* loaded from: classes.dex */
class C0878d {

    /* renamed from: a */
    private Context f3749a;

    /* renamed from: b */
    private List<HashMap<String, String>> f3750b = null;

    /* renamed from: c */
    private InterfaceC0880a<String> f3751c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lbsapi.auth.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0880a<Result> {
        /* renamed from: a */
        void mo12342a(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0878d(Context context) {
        this.f3749a = context;
    }

    /* renamed from: a */
    private List<HashMap<String, String>> m12345a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                String str2 = str.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            arrayList.add(hashMap2);
        } else {
            for (String str3 : strArr) {
                HashMap hashMap3 = new HashMap();
                for (String str4 : hashMap.keySet()) {
                    String str5 = str4.toString();
                    hashMap3.put(str5, hashMap.get(str5));
                }
                hashMap3.put("mcode", str3);
                arrayList.add(hashMap3);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m12346a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        InterfaceC0880a<String> interfaceC0880a = this.f3751c;
        if (interfaceC0880a != null) {
            interfaceC0880a.mo12342a(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12343a(List<HashMap<String, String>> list) {
        int i;
        C0872a.m12369a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            C0872a.m12367c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            C0872a.m12369a("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            C0881e c0881e = new C0881e(this.f3749a);
            if (c0881e.m12341a()) {
                String m12339a = c0881e.m12339a(hashMap);
                if (m12339a == null) {
                    m12339a = "";
                }
                C0872a.m12369a("syncConnect resuest " + i2 + "  result:" + m12339a);
                arrayList.add(m12339a);
                try {
                    JSONObject jSONObject = new JSONObject(m12339a);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        C0872a.m12369a("auth end and break");
                        m12346a(m12339a);
                        return;
                    }
                } catch (JSONException unused) {
                    C0872a.m12369a("continue-------------------------------");
                }
            } else {
                C0872a.m12369a("Current network is not available.");
                arrayList.add(ErrorMessage.m12391a("Current network is not available."));
            }
            C0872a.m12369a("syncConnect end");
            i2++;
        }
        C0872a.m12369a("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                return;
            }
            C0872a.m12369a("i-1 result is not 0,return first result");
            m12346a((String) arrayList.get(0));
        } catch (JSONException e) {
            m12346a(ErrorMessage.m12391a("JSONException:" + e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12344a(HashMap<String, String> hashMap, String[] strArr, InterfaceC0880a<String> interfaceC0880a) {
        this.f3750b = m12345a(hashMap, strArr);
        this.f3751c = interfaceC0880a;
        new Thread(new Runnable() { // from class: com.baidu.lbsapi.auth.d.1
            @Override // java.lang.Runnable
            public void run() {
                C0878d c0878d = C0878d.this;
                c0878d.m12343a(c0878d.f3750b);
            }
        }).start();
    }
}
