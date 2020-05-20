package com.alipay.sdk.p070a;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.a.e */
/* loaded from: classes.dex */
final class C0725e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C0720a f3491a;

    /* renamed from: b */
    final /* synthetic */ C0723c f3492b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0725e(C0723c c0723c, C0720a c0720a) {
        this.f3492b = c0723c;
        this.f3491a = c0720a;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", PdfBoolean.TRUE);
        } catch (JSONException unused) {
        }
        C0720a c0720a = new C0720a("callback");
        c0720a.f3480a = this.f3491a.f3480a;
        c0720a.f3484e = jSONObject;
        this.f3492b.f3487a.mo12532a(c0720a);
    }
}
