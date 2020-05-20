package com.unionpay.uppay;

import android.content.Intent;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.hce.C4156f;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.pboctransaction.nfc.C4269a;
import com.unionpay.mobile.android.pboctransaction.nfc.C4270b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.mobile.android.pro.views.C4307a;
import com.unionpay.mobile.android.pro.views.C4323j;
import com.unionpay.mobile.android.pro.views.C4324k;
import com.unionpay.mobile.android.pro.views.C4335v;
import com.unionpay.mobile.android.pro.views.C4337x;
import com.unionpay.mobile.android.utils.C4385f;
import com.unionpay.mobile.android.utils.C4393n;

/* loaded from: classes2.dex */
public final class PayActivity extends BaseActivity {

    /* renamed from: a */
    public static String f23751a;

    /* renamed from: f */
    private C4393n f23754f;

    /* renamed from: d */
    private C4298b f23752d = null;

    /* renamed from: e */
    private C4156f f23753e = null;

    /* renamed from: g */
    private C4324k f23755g = null;

    static {
        System.loadLibrary("entryexpro");
        f23751a = "";
    }

    @Override // com.unionpay.mobile.android.plugin.InterfaceC4294a
    /* renamed from: a */
    public final AbstractC4219b mo477a(int i, InterfaceC4176e interfaceC4176e) {
        switch (i) {
            case 1:
                C4323j c4323j = new C4323j(this);
                c4323j.m1377a(mo478a());
                return c4323j;
            case 2:
                return new C4335v(this, interfaceC4176e);
            case 6:
                return new C4337x(this, interfaceC4176e);
            case 17:
                C4324k c4324k = new C4324k(this, interfaceC4176e, (UPPayEngine) mo476a(UPPayEngine.class.toString()));
                this.f23755g = c4324k;
                this.f23755g.f22965r = m1224c();
                this.f23755g.m1146a(this.f22836c);
                return c4324k;
            case 18:
                return new C4307a(this, interfaceC4176e, (UPPayEngine) mo476a(UPPayEngine.class.toString()));
            default:
                return null;
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity
    /* renamed from: a */
    public final Object mo476a(String str) {
        if (C4298b.class.toString().equalsIgnoreCase(str)) {
            if (this.f23752d == null) {
                this.f23752d = new C4298b(this, m1224c());
            }
            return this.f23752d;
        } else if (C4156f.class.toString().equalsIgnoreCase(str)) {
            if (this.f23753e == null) {
                this.f23753e = new C4156f(this);
            }
            return this.f23753e;
        } else {
            return super.mo476a(str);
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity
    /* renamed from: a */
    public final boolean mo478a() {
        if (Build.VERSION.SDK_INT < 10) {
            return false;
        }
        return (getPackageManager().checkPermission("android.permission.NFC", C4385f.m869b(this)) == 0) && ((NfcManager) getSystemService("nfc")).getDefaultAdapter() != null;
    }

    @Override // com.unionpay.mobile.android.plugin.InterfaceC4295b
    /* renamed from: d */
    public final UPPayEngine mo475d() {
        this.f23754f = new C4393n(this);
        return this.f23754f;
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C4324k c4324k = this.f23755g;
        if (c4324k == null || c4324k.getParent() == null) {
            return;
        }
        this.f23755g.m1146a(this.f22836c);
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        C4298b c4298b = this.f23752d;
        if (c4298b != null) {
            c4298b.m1223a();
            this.f23752d = null;
        }
        this.f23754f.m1497h();
        this.f23754f = null;
        this.f23755g = null;
        f23751a = "";
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra != null) {
            Log.d("NFCTAG", intent.getAction());
            C4270b.C4272b c4272b = new C4270b.C4272b(IsoDep.get((Tag) parcelableExtra));
            c4272b.m1284a();
            C4269a c4269a = new C4269a((InterfaceC4148a) mo476a(UPPayEngine.class.toString()), c4272b);
            C4324k c4324k = this.f23755g;
            if (c4324k == null || c4324k.getParent() == null) {
                return;
            }
            this.f23755g.m1145a(c4269a);
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        C4324k c4324k = this.f23755g;
        if (c4324k == null || c4324k.getParent() == null) {
            return;
        }
        this.f23755g.m1146a(this.f22836c);
    }
}
