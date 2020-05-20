package com.unionpay.mobile.android.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.nocard.views.C4242l;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.widgets.C4471m;
import java.util.ArrayList;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes2.dex */
public abstract class BaseActivity extends Activity implements InterfaceC4294a, InterfaceC4295b {
    public static IntentFilter[] FILTERS;
    public static String[][] TECHLISTS;

    /* renamed from: f */
    private static int f22833f;

    /* renamed from: c */
    protected NfcAdapter f22836c;

    /* renamed from: g */
    private PendingIntent f22839g;

    /* renamed from: b */
    protected ArrayList<AbstractC4219b> f22835b = null;

    /* renamed from: a */
    private C4242l f22834a = null;

    /* renamed from: d */
    private C4293a f22837d = null;

    /* renamed from: e */
    private C4471m f22838e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.mobile.android.plugin.BaseActivity$a */
    /* loaded from: classes2.dex */
    public class C4293a {

        /* renamed from: a */
        public C4173b f22840a;

        /* renamed from: b */
        public UPPayEngine f22841b;

        public C4293a(UPPayEngine uPPayEngine) {
            this.f22840a = null;
            this.f22841b = null;
            this.f22840a = new C4173b();
            this.f22841b = uPPayEngine;
            this.f22841b.m1516a(this.f22840a);
        }
    }

    static {
        try {
            TECHLISTS = new String[][]{new String[]{IsoDep.class.getName()}, new String[]{NfcV.class.getName()}, new String[]{NfcF.class.getName()}};
            FILTERS = new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*")};
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public Object mo476a(String str) {
        if (str == null) {
            return this.f22837d.f22840a;
        }
        if (str.equalsIgnoreCase(UPPayEngine.class.toString())) {
            return this.f22837d.f22841b;
        }
        if (str.equalsIgnoreCase(C4471m.class.toString())) {
            return this.f22838e;
        }
        return null;
    }

    /* renamed from: a */
    public final void m1227a(int i) {
        ArrayList<AbstractC4219b> arrayList = this.f22835b;
        if (arrayList != null) {
            int size = arrayList.size() - 1;
            this.f22835b.get(size);
            while (size >= 0) {
                AbstractC4219b abstractC4219b = this.f22835b.get(size);
                if (abstractC4219b.m1409g() == i) {
                    setContentView(abstractC4219b);
                    return;
                } else {
                    this.f22835b.remove(size);
                    size--;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m1226a(AbstractC4219b abstractC4219b) {
        ArrayList<AbstractC4219b> arrayList = this.f22835b;
        if (arrayList != null) {
            int size = arrayList.size();
            if (size > 0) {
                this.f22835b.get(size - 1);
            }
            this.f22835b.add(abstractC4219b);
            setContentView(abstractC4219b);
        }
    }

    /* renamed from: a */
    public boolean mo478a() {
        return false;
    }

    /* renamed from: b */
    public final void m1225b() {
        int size;
        ArrayList<AbstractC4219b> arrayList;
        ArrayList<AbstractC4219b> arrayList2;
        ArrayList<AbstractC4219b> arrayList3 = this.f22835b;
        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
            return;
        }
        int i = size - 1;
        this.f22835b.get(i);
        this.f22835b.get(i);
        this.f22835b.remove(i);
        if (this.f22835b.size() != 0) {
            this.f22835b.get(arrayList.size() - 1);
            setContentView(this.f22835b.get(arrayList2.size() - 1));
        }
    }

    /* renamed from: c */
    public final String m1224c() {
        return this.f22837d.f22840a.f22401a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        try {
            Resources resources = super.getResources();
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return resources;
        } catch (Exception unused) {
            return super.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        C4242l c4242l = this.f22834a;
        if (c4242l != null) {
            c4242l.m1370u();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4390k.m838a("uppay", "PayActivityEx.onCreate() +++");
        C4171c.m1546a();
        C4149a.m1610a(this);
        this.f22835b = new ArrayList<>(1);
        this.f22837d = new C4293a(mo475d());
        this.f22838e = new C4471m(this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f22834a = (C4242l) mo477a(1, null);
        setContentView(this.f22834a);
        getWindow().addFlags(8192);
        f22833f++;
        C4390k.m838a("uppay", "PayActivityEx.onCreate() ---");
        if (mo478a()) {
            this.f22836c = NfcAdapter.getDefaultAdapter(this);
            this.f22839g = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(NTLMConstants.FLAG_NEGOTIATE_128_BIT_ENCRYPTION), 0);
            onNewIntent(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        ArrayList<AbstractC4219b> arrayList = this.f22835b;
        if (arrayList != null) {
            arrayList.clear();
        }
        C4242l c4242l = this.f22834a;
        if (c4242l != null) {
            c4242l.m1368x();
        }
        this.f22834a = null;
        C4173b.f22371bl = false;
        C4173b.f22370bb = null;
        C4173b.f22372bm = false;
        int i = f22833f - 1;
        f22833f = i;
        if (i == 0) {
            C4342c.m1036a(this).m1038a();
        }
        this.f22838e.m630c();
        this.f22838e = null;
        C4293a c4293a = this.f22837d;
        c4293a.f22841b = null;
        c4293a.f22840a = null;
        this.f22837d = null;
        ((ViewGroup) getWindow().getDecorView().findViewById(16908290)).removeAllViews();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ArrayList<AbstractC4219b> arrayList = this.f22835b;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<AbstractC4219b> arrayList2 = this.f22835b;
                arrayList2.get(arrayList2.size() - 1).mo1056k();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        NfcAdapter nfcAdapter;
        super.onPause();
        if (!mo478a() || (nfcAdapter = this.f22836c) == null) {
            return;
        }
        nfcAdapter.disableForegroundDispatch(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        NfcAdapter nfcAdapter;
        super.onResume();
        if (this.f22838e.m638a()) {
            this.f22838e.m631b();
        }
        if (!mo478a() || (nfcAdapter = this.f22836c) == null) {
            return;
        }
        nfcAdapter.enableForegroundDispatch(this, this.f22839g, FILTERS, TECHLISTS);
    }
}
