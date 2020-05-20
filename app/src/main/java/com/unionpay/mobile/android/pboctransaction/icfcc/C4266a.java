package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.p007a.p008a.InterfaceC0000a;

/* renamed from: com.unionpay.mobile.android.pboctransaction.icfcc.a */
/* loaded from: classes2.dex */
public final class C4266a implements InterfaceC4262c {

    /* renamed from: c */
    private InterfaceC0000a f22745c;

    /* renamed from: d */
    private InterfaceC4261b f22746d;

    /* renamed from: e */
    private Context f22747e;

    /* renamed from: a */
    private String f22743a = null;

    /* renamed from: b */
    private String f22744b = "A0000003334355502D4D4F42494C45";

    /* renamed from: f */
    private ServiceConnection f22748f = new ServiceConnectionC4267b(this);

    /* renamed from: a */
    private byte[] m1294a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            String m1302a = C4264e.m1302a(bArr);
            if (m1293b(m1302a)) {
                if (m1302a.contains(this.f22743a)) {
                    C4390k.m836c("icfcc", "pbocAID = " + this.f22743a);
                    bArr2 = this.f22745c.mo15304a(C4264e.m1305a(this.f22743a), "00");
                } else if (m1302a.contains(this.f22744b)) {
                    C4390k.m836c("icfcc", "upcardAID = " + this.f22744b);
                    bArr2 = this.f22745c.mo15304a(C4264e.m1305a(this.f22744b), "01");
                }
            }
        } catch (Exception unused) {
        }
        C4390k.m836c("icfcc", " openSEChannel result=" + C4264e.m1302a(bArr2));
        return bArr2;
    }

    /* renamed from: b */
    private static boolean m1293b(String str) {
        return str.startsWith("00A40400") || str.startsWith("01A40400") || str.startsWith("02A40400");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        if (this.f22745c == null) {
            return null;
        }
        ArrayList<InterfaceC4174c> arrayList = new ArrayList<>();
        try {
            try {
                String m1292a = C4268c.m1292a(C4264e.m1302a(this.f22745c.mo15304a(C4264e.m1305a("325041592e5359532e4444463031"), "00")), "4F");
                C4390k.m836c("icfcc", "aid =".concat(String.valueOf(m1292a)));
                if (m1292a != null) {
                    this.f22743a = m1292a;
                    AppIdentification appIdentification = new AppIdentification(m1292a, "");
                    String m1299c = C4264e.m1299c(c4263d.m1328a(appIdentification));
                    if (m1299c != null && m1299c.length() > 0) {
                        C4390k.m836c("icfcc", "  ".concat(String.valueOf(m1299c)));
                        arrayList.add(new C4172a(8, appIdentification.m1336a(), "", m1299c, 1));
                    }
                }
                try {
                    this.f22745c.mo15302b("00");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                return arrayList;
            } catch (Exception unused) {
                this.f22745c.mo15302b("00");
                return null;
            } catch (Throwable th) {
                try {
                    this.f22745c.mo15302b("00");
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (RemoteException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
        mo1229d();
        InterfaceC0000a interfaceC0000a = this.f22745c;
        if (interfaceC0000a != null) {
            try {
                interfaceC0000a.mo15308a();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
        if (this.f22747e != null) {
            new Intent("com.unionpay.mobile.tsm.PBOCService");
            this.f22747e.unbindService(this.f22748f);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22746d = interfaceC4261b;
        this.f22747e = context;
        try {
            Intent intent = new Intent("cn.gov.pbc.tsm.client.mobile.android.bank.service");
            intent.setPackage("cn.gov.pbc.tsm.client.mobile.andorid");
            context.startService(intent);
            if (context.bindService(intent, this.f22748f, 1) || interfaceC4261b == null) {
                return;
            }
            C4390k.m838a("icfcc", "startTSMService.initFailed()");
            interfaceC4261b.mo1205b();
        } catch (Exception unused) {
            if (interfaceC4261b != null) {
                C4390k.m838a("icfcc", "starticfccService exception");
                interfaceC4261b.mo1205b();
            }
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final byte[] mo1234a(byte[] bArr, int i) {
        String m1302a = C4264e.m1302a(bArr);
        C4390k.m836c("icfcc", "====>".concat(String.valueOf(m1302a)));
        byte[] bArr2 = null;
        if (this.f22745c == null) {
            return null;
        }
        if (m1293b(m1302a)) {
            return m1294a(bArr);
        }
        try {
            bArr2 = this.f22745c.mo15301b(bArr);
        } catch (RemoteException | Exception unused) {
        }
        C4390k.m836c("icfcc", "<====" + C4264e.m1302a(bArr2));
        return bArr2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
        InterfaceC0000a interfaceC0000a = this.f22745c;
        if (interfaceC0000a != null) {
            try {
                interfaceC0000a.mo15302b("00");
                this.f22745c.mo15302b("01");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
    }
}
