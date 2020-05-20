package com.unionpay.mobile.android.pboctransaction.sdapdu;

import android.content.Context;
import android.util.Log;
import com.mopub.volley.BuildConfig;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4390k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.unionpay.mobile.android.pboctransaction.sdapdu.a */
/* loaded from: classes2.dex */
public final class C4287a implements InterfaceC4262c {

    /* renamed from: b */
    private Context f22821b = null;

    /* renamed from: a */
    NativeSDWriter f22820a = null;

    /* renamed from: c */
    private boolean f22822c = false;

    /* renamed from: b */
    private static ArrayList<InterfaceC4174c> m1244b(C4263d c4263d) {
        String m1330a;
        String str;
        String str2;
        String str3;
        if (c4263d.m1331a() == null) {
            str2 = "uppay";
            str3 = " select UPCard failed!!!!";
        } else {
            String m1317c = c4263d.m1317c();
            if (m1317c != null) {
                byte[] m1305a = C4264e.m1305a(m1317c);
                int i = 1;
                int i2 = ((m1305a[0] & 255) << 24) | ((m1305a[1] & 255) << 16);
                int i3 = 0;
                int i4 = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
                for (int i5 = 0; i5 < 10; i5++) {
                    if ((i4 & i2) == 0) {
                        i3++;
                    }
                    i4 >>>= 1;
                }
                if (i3 <= 0) {
                    return null;
                }
                ArrayList<InterfaceC4174c> arrayList = new ArrayList<>(i3);
                int i6 = NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION;
                while (i <= i3 && i < 11) {
                    if ((i2 & i6) == 0 && (m1330a = c4263d.m1330a(i, C4382c.m888a())) != null && m1330a.length() > 0) {
                        String m1298d = C4264e.m1298d(m1330a.substring(0, 40));
                        try {
                            str = new String(C4264e.m1305a(m1298d), "gbk");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            str = m1298d;
                        }
                        String substring = m1330a.substring(40, 60);
                        arrayList.add(new C4172a(8, Integer.toString(i), str, C4264e.m1299c(substring), 2));
                        C4390k.m836c("uppay", i + "----" + substring);
                    }
                    i++;
                    i6 >>>= 1;
                }
                return arrayList;
            }
            str2 = "uppay";
            str3 = " getBankCardFileEntry failed!!!!";
        }
        Log.e(str2, str3);
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        C4390k.m836c("uppay", "SDEngine.readList() +++");
        ArrayList arrayList = null;
        if (this.f22822c) {
            ArrayList<InterfaceC4174c> arrayList2 = new ArrayList<>();
            String m1328a = c4263d.m1328a(new AppIdentification("A0000003330101", BuildConfig.VERSION_NAME));
            if (m1328a != null && m1328a.length() > 0) {
                arrayList = new ArrayList(1);
                arrayList.add(new C4172a(8, "A0000003330101", "", C4264e.m1299c(m1328a), 1));
                C4390k.m836c("uppay", "A0000003330101----" + m1328a);
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayList2.addAll(arrayList);
            }
            ArrayList<InterfaceC4174c> m1244b = m1244b(c4263d);
            if (m1244b != null && m1244b.size() > 0) {
                arrayList2.addAll(m1244b);
            }
            C4390k.m836c("uppay", "SDEngine.readList() ---");
            return arrayList2;
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22821b = context;
        if (interfaceC4261b != null) {
            interfaceC4261b.mo1206a();
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final byte[] mo1234a(byte[] bArr, int i) {
        NativeSDWriter nativeSDWriter = this.f22820a;
        return C4264e.m1305a(nativeSDWriter != null ? nativeSDWriter.m1246a(C4264e.m1302a(bArr)) : "");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
        this.f22820a = new NativeSDWriter();
        C4288b.m1243a();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : C4288b.f22823a) {
            arrayList.add(str);
        }
        this.f22822c = this.f22820a.m1245a(arrayList);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
        NativeSDWriter nativeSDWriter = this.f22820a;
        if (nativeSDWriter != null) {
            nativeSDWriter.m1247a();
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
    }
}
