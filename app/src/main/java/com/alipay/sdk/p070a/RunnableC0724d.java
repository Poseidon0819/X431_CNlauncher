package com.alipay.sdk.p070a;

import android.widget.Toast;
import com.alipay.sdk.p070a.C0720a;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.a.d */
/* loaded from: classes.dex */
public final class RunnableC0724d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0720a f3489a;

    /* renamed from: b */
    final /* synthetic */ C0723c f3490b;

    public RunnableC0724d(C0723c c0723c, C0720a c0720a) {
        this.f3490b = c0723c;
        this.f3489a = c0720a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0723c c0723c = this.f3490b;
        C0720a c0720a = this.f3489a;
        if (c0720a != null && "toast".equals(c0720a.f3482c)) {
            JSONObject jSONObject = c0720a.f3484e;
            String optString = jSONObject.optString("content");
            int i = jSONObject.optInt(VastIconXmlManager.DURATION) < 2500 ? 0 : 1;
            Toast.makeText(c0723c.f3488b, optString, i).show();
            new Timer().schedule(new C0725e(c0723c, c0720a), i);
        }
        int i2 = C0720a.EnumC0721a.a$15e826fb;
        if (i2 != C0720a.EnumC0721a.a$15e826fb) {
            try {
                this.f3490b.m12557a(this.f3489a.f3480a, i2);
            } catch (JSONException unused) {
            }
        }
    }
}
