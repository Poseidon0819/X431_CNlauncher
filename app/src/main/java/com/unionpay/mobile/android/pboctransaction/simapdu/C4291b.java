package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.pboctransaction.simapdu.C4289a;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4391l;
import com.unionpay.tsmservice.data.AppStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;

/* renamed from: com.unionpay.mobile.android.pboctransaction.simapdu.b */
/* loaded from: classes2.dex */
public final class C4291b implements InterfaceC4262c {

    /* renamed from: d */
    private static C4291b f22826d = new C4291b();

    /* renamed from: c */
    private InterfaceC4261b f22829c;

    /* renamed from: a */
    private SEService f22827a = null;

    /* renamed from: b */
    private Channel[] f22828b = new Channel[3];

    /* renamed from: e */
    private Handler.Callback f22830e = new C4292c(this);

    /* renamed from: f */
    private Handler f22831f = new Handler(this.f22830e);

    private C4291b() {
    }

    /* renamed from: a */
    private synchronized String m1235a(String str, int i) throws C4289a.C4290a {
        String str2 = null;
        if (str == null) {
            return null;
        }
        C4390k.m838a("plugin-sim", "====>".concat(String.valueOf(str)));
        String upperCase = str.toUpperCase(Locale.CHINA);
        boolean z = false;
        if (i > this.f22828b.length) {
            i = 0;
        }
        if ((upperCase.startsWith("00A40400") || upperCase.startsWith("01A40400") || upperCase.startsWith("02A40400")) ? true : true) {
            m1240a(i);
            String m1231b = m1231b(C4264e.m1305a(upperCase.substring(10, (((Integer.parseInt(upperCase.substring(8, 9), 16) * 16) + Integer.parseInt(upperCase.substring(9, 10), 16)) * 2) + 10)), i);
            if (TextUtils.isEmpty(m1231b)) {
                C4390k.m836c("plugin-sim", " writeApdu openchannel exception!!!");
                throw new C4289a.C4290a();
            }
            return m1231b;
        }
        try {
            try {
                byte[] m1305a = C4264e.m1305a(upperCase);
                if (m1305a != null) {
                    str2 = C4264e.m1302a(this.f22828b[i].transmit(m1305a));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            C4390k.m838a("plugin-sim", "<====".concat(String.valueOf(str2)));
            return str2;
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new C4289a.C4290a();
        }
    }

    /* renamed from: a */
    private void m1240a(int i) {
        C4390k.m838a("plugin-sim", "closeChannel(int) +++");
        Channel[] channelArr = this.f22828b;
        if (channelArr[i] != null && i <= channelArr.length) {
            try {
                channelArr[i].close();
            } catch (Exception e) {
                e.printStackTrace();
                C4390k.m838a("plugin-sim", " mChannel[channel].close() exception!!!");
            }
            this.f22828b[i] = null;
        }
        C4390k.m838a("plugin-sim", "closeChannel(int) ---");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ InterfaceC4261b m1232b(C4291b c4291b) {
        c4291b.f22829c = null;
        return null;
    }

    /* renamed from: b */
    private String m1231b(byte[] bArr, int i) {
        Channel openLogicalChannel;
        try {
            Reader[] readers = this.f22827a.getReaders();
            if (readers.length <= 0 || (openLogicalChannel = readers[0].openSession().openLogicalChannel(bArr)) == null) {
                return "";
            }
            this.f22828b[i] = openLogicalChannel;
            return C4264e.m1302a(openLogicalChannel.getSelectResponse());
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static synchronized C4291b m1228e() {
        C4291b c4291b;
        synchronized (C4291b.class) {
            c4291b = f22826d;
        }
        return c4291b;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        ArrayList arrayList;
        String m1326a;
        C4390k.m836c("plugin-sim", " SIMEngine.readList() +++");
        ArrayList<InterfaceC4174c> arrayList2 = null;
        try {
            arrayList = new ArrayList(1);
            m1326a = c4263d.m1326a("A0000003330101");
            C4390k.m836c("plugin-sim", "full AID:".concat(String.valueOf(m1326a)));
        } catch (Throwable th) {
            th = th;
        }
        if (m1326a != null && m1326a.length() >= 16) {
            arrayList.add(new AppIdentification(m1326a, null));
            if (arrayList.size() > 0) {
                ArrayList<InterfaceC4174c> arrayList3 = new ArrayList<>();
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AppIdentification appIdentification = (AppIdentification) it.next();
                        if (!AppStatus.APPLY.equalsIgnoreCase(appIdentification.m1334b())) {
                            String m1299c = C4264e.m1299c(c4263d.m1328a(appIdentification));
                            C4390k.m838a("nfcphone", " cardNumber=".concat(String.valueOf(m1299c)));
                            if (m1299c != null && m1299c.length() > 0) {
                                arrayList3.add(new C4172a(16, appIdentification.m1336a(), "", m1299c, 1));
                                C4390k.m838a("nfcphone", " valid Number= ".concat(String.valueOf(m1299c)));
                            }
                        }
                    }
                    arrayList2 = arrayList3;
                } catch (Throwable th2) {
                    th = th2;
                    arrayList2 = arrayList3;
                    Log.e("plugin-sim", " SimEngine Exception = " + th.getMessage());
                    C4390k.m836c("plugin-sim", " SIMEngine.readList() ---");
                    return arrayList2;
                }
            } else {
                Log.e("plugin-sim", " SIMEngine --- there has no PBOC aids!!!");
            }
            C4390k.m836c("plugin-sim", " SIMEngine.readList() ---");
            return arrayList2;
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
        C4390k.m836c("plugin-sim", "SIMEngine.destroy() +++ ");
        C4390k.m836c("plugin-sim", " mSEService = " + this.f22827a);
        mo1229d();
        SEService sEService = this.f22827a;
        if (sEService != null && sEService.isConnected()) {
            C4390k.m838a("TAG", " mSEService.isConnected() = " + this.f22827a.isConnected());
            C4390k.m836c("plugin-sim", " mSEService.shutdown() ");
            this.f22827a.shutdown();
        }
        C4390k.m836c("plugin-sim", "SIMEngine.destroy() --- ");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22829c = interfaceC4261b;
        try {
            new C4391l();
            if (C4391l.m835a() == null || !C4391l.m835a().isConnected()) {
                this.f22831f.sendEmptyMessage(2);
                return;
            }
            this.f22827a = C4391l.m835a();
            this.f22831f.sendEmptyMessage(1);
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e("plugin-sim", " service ERROR!!!");
            this.f22831f.sendEmptyMessage(2);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final byte[] mo1234a(byte[] bArr, int i) {
        byte[] bArr2;
        C4390k.m836c("plugin-sim", " SIMEngine.sendApdu() +++");
        try {
            bArr2 = C4264e.m1305a(m1235a(C4264e.m1302a(bArr), i));
        } catch (C4289a.C4290a e) {
            e.printStackTrace();
            C4390k.m836c("plugin-sim", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e.getMessage());
            bArr2 = null;
        }
        C4390k.m836c("plugin-sim", " SIMEngine.sendApdu() ---");
        return bArr2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
        mo1229d();
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
        C4390k.m838a("plugin-sim", "closeChannels() +++");
        for (int i = 0; i < this.f22828b.length; i++) {
            m1240a(i);
        }
        C4390k.m838a("plugin-sim", "closeChannels() ---");
    }
}
