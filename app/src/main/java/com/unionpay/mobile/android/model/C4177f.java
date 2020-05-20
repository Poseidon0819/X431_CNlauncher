package com.unionpay.mobile.android.model;

import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.model.f */
/* loaded from: classes2.dex */
public final class C4177f implements InterfaceC4176e {

    /* renamed from: a */
    private HashMap<String, Object> f22491a = new HashMap<>();

    /* renamed from: a */
    public final JSONObject m1533a(String str) {
        Object obj = this.f22491a.get(str);
        if (obj == null || !(obj instanceof JSONObject)) {
            return null;
        }
        return (JSONObject) obj;
    }

    /* renamed from: a */
    public final void m1532a(String str, Object obj) {
        this.f22491a.put(str, obj);
    }
}
