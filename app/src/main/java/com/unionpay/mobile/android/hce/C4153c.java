package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.hce.service.InterfaceC4163a;
import com.unionpay.mobile.android.model.InterfaceC4175d;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.hce.c */
/* loaded from: classes2.dex */
public final class C4153c implements InterfaceC4175d {

    /* renamed from: a */
    private String f22158a;

    /* renamed from: b */
    private String f22159b;

    /* renamed from: c */
    private String f22160c;

    /* renamed from: d */
    private String f22161d;

    /* renamed from: e */
    private String f22162e;

    /* renamed from: f */
    private String f22163f;

    /* renamed from: g */
    private InterfaceC4163a f22164g;

    /* renamed from: h */
    private ServiceConnection f22165h;

    public C4153c(JSONObject jSONObject, String str, InterfaceC4163a interfaceC4163a, ServiceConnection serviceConnection) {
        this.f22158a = C4389j.m846a(jSONObject, "num");
        this.f22159b = C4389j.m846a(jSONObject, "name");
        this.f22161d = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
        String m846a = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
        this.f22160c = C4155e.f22172a.equals(m846a) ? C4155e.f22176e : C4155e.f22173b.equals(m846a) ? C4155e.f22177f : C4155e.f22174c.equals(m846a) ? C4155e.f22178g : C4155e.f22175d.equals(m846a) ? C4155e.f22179h : "";
        this.f22162e = C4389j.m846a(jSONObject, "instNum");
        this.f22163f = str;
        this.f22164g = interfaceC4163a;
        this.f22165h = serviceConnection;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4175d
    /* renamed from: a */
    public final String mo1538a() {
        return this.f22158a;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4175d
    /* renamed from: b */
    public final String mo1537b() {
        return this.f22159b;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4175d
    /* renamed from: c */
    public final String mo1536c() {
        return this.f22160c;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4175d
    /* renamed from: d */
    public final String mo1535d() {
        return this.f22161d;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4175d
    /* renamed from: e */
    public final String mo1534e() {
        return this.f22162e;
    }

    /* renamed from: f */
    public final String m1604f() {
        return this.f22163f;
    }

    /* renamed from: g */
    public final InterfaceC4163a m1603g() {
        return this.f22164g;
    }

    /* renamed from: h */
    public final ServiceConnection m1602h() {
        return this.f22165h;
    }
}
