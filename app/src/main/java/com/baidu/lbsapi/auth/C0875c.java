package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.c */
/* loaded from: classes.dex */
class C0875c {

    /* renamed from: a */
    private Context f3745a;

    /* renamed from: b */
    private HashMap<String, String> f3746b = null;

    /* renamed from: c */
    private InterfaceC0877a<String> f3747c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lbsapi.auth.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0877a<Result> {
        /* renamed from: a */
        void mo12349a(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0875c(Context context) {
        this.f3745a = context;
    }

    /* renamed from: a */
    private HashMap<String, String> m12352a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12353a(String str) {
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
        InterfaceC0877a<String> interfaceC0877a = this.f3747c;
        if (interfaceC0877a != null) {
            interfaceC0877a.mo12349a(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12351a(HashMap<String, String> hashMap, InterfaceC0877a<String> interfaceC0877a) {
        this.f3746b = m12352a(hashMap);
        this.f3747c = interfaceC0877a;
        new Thread(new Runnable() { // from class: com.baidu.lbsapi.auth.c.1
            @Override // java.lang.Runnable
            public void run() {
                C0872a.m12369a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
                C0875c.this.m12353a(new C0881e(C0875c.this.f3745a).m12339a(C0875c.this.f3746b));
            }
        }).start();
    }
}
