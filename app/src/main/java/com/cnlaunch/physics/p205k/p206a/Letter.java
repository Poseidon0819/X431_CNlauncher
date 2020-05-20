package com.cnlaunch.physics.p205k.p206a;

import com.cnlaunch.physics.p205k.C1856n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.physics.k.a.c */
/* loaded from: classes.dex */
public final class Letter implements ILetter {

    /* renamed from: a */
    private String f10047a;

    /* renamed from: b */
    private String f10048b;

    /* renamed from: c */
    private String f10049c;

    public Letter() {
        this.f10048b = "";
        this.f10049c = "";
        this.f10047a = null;
    }

    public Letter(String str) {
        this();
        this.f10047a = str;
    }

    @Override // com.cnlaunch.physics.p205k.p206a.ILetter
    /* renamed from: a */
    public final String mo8211a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("receiver", this.f10048b);
            jSONObject.put("sender", this.f10049c);
            jSONObject.put("content", this.f10047a);
            if (C1856n.f10135a) {
                C1856n.m8130a("Letter", "this.content=" + this.f10047a);
                C1856n.m8130a("Letter", "json.toString()=" + jSONObject.toString());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            C1856n.m8130a("Letter", "信件序列化失败");
            return "";
        }
    }
}
