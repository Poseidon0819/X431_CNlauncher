package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.p073c.C0748b;
import com.itextpdf.text.Annotation;

/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: a */
    private WebView f3493a;

    /* renamed from: b */
    private WebViewClient f3494b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(Annotation.URL);
            if (!C0748b.m12522a(string)) {
                finish();
                return;
            }
            String string2 = extras.getString("cookie");
            super.requestWindowFeature(1);
            this.f3493a = C0748b.m12526a(this, string, string2);
            this.f3494b = new C0729b(this);
            this.f3493a.setWebViewClient(this.f3494b);
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f3493a.canGoBack()) {
            C0734g.f3510a = C0734g.m12549a();
            finish();
        } else if (((C0729b) this.f3494b).f3499a) {
            EnumC0735h m12546a = EnumC0735h.m12546a(EnumC0735h.NETWORK_ERROR.m12547a());
            C0734g.f3510a = C0734g.m12548a(m12546a.m12547a(), m12546a.m12545b(), "");
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.f3493a;
        if (webView != null) {
            webView.removeAllViews();
            try {
                this.f3493a.destroy();
            } catch (Throwable unused) {
            }
            this.f3493a = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Object obj = C0726a.f3495a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
        super.finish();
    }
}
