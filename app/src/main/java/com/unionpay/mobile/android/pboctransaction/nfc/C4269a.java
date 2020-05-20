package com.unionpay.mobile.android.pboctransaction.nfc;

import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.pdf.ByteBuffer;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.nfc.C4270b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.a */
/* loaded from: classes2.dex */
public final class C4269a {

    /* renamed from: d */
    protected static final byte[] f22750d = {50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, ByteBuffer.ZERO, 49};

    /* renamed from: a */
    protected String f22751a = "UnionPay Card";

    /* renamed from: b */
    InterfaceC4148a f22752b;

    /* renamed from: c */
    C4270b.C4272b f22753c;

    public C4269a(InterfaceC4148a interfaceC4148a, C4270b.C4272b c4272b) {
        this.f22752b = interfaceC4148a;
        this.f22753c = c4272b;
    }

    /* renamed from: a */
    private static String m1289a(String str, String str2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (str == null) {
            return null;
        }
        byte[] m1305a = C4264e.m1305a(str);
        int i11 = 0;
        while (i11 < m1305a.length) {
            int i12 = 1;
            int i13 = ((byte) (m1305a[i11] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i13];
            System.arraycopy(m1305a, i11, bArr, 0, i13);
            if (C4264e.m1301a(bArr, i13).compareToIgnoreCase(str2) == 0) {
                int i14 = i11 + i13;
                if (((byte) (m1305a[i14] & 128)) != Byte.MIN_VALUE) {
                    i4 = m1305a[i14];
                } else {
                    i12 = 1 + (m1305a[i14] & 127);
                    if (i12 != 2) {
                        if (i12 == 3) {
                            i2 = (m1305a[i14 + 1] & 255) << 8;
                            i3 = m1305a[i14 + 2];
                        } else if (i12 != 4) {
                            i = 0;
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(m1305a, i14 + i12, bArr2, 0, i);
                            return C4264e.m1301a(bArr2, i);
                        } else {
                            i2 = ((m1305a[i14 + 1] & 255) << 16) | ((m1305a[i14 + 2] & 255) << 8);
                            i3 = m1305a[i14 + 3];
                        }
                        i = i2 | (i3 & 255);
                        byte[] bArr22 = new byte[i];
                        System.arraycopy(m1305a, i14 + i12, bArr22, 0, i);
                        return C4264e.m1301a(bArr22, i);
                    }
                    i4 = m1305a[i14 + 1];
                }
                i = i4 & 255;
                byte[] bArr222 = new byte[i];
                System.arraycopy(m1305a, i14 + i12, bArr222, 0, i);
                return C4264e.m1301a(bArr222, i);
            }
            if ((m1305a[i11] & 32) == 32) {
                i5 = i11 + i13;
                if (i5 < m1305a.length && ((byte) (m1305a[i5] & 128)) == Byte.MIN_VALUE) {
                    i12 = 1 + (m1305a[i5] & 127);
                }
            } else {
                i5 = i11 + i13;
                if (i5 >= m1305a.length || ((byte) (m1305a[i5] & 128)) != 0) {
                    i12 = i5 < m1305a.length ? (m1305a[i5] & 127) + 1 : 0;
                    if (i12 != 2 || (i9 = i5 + 1) >= m1305a.length) {
                        i6 = (i12 != 3 || (i8 = i5 + 2) >= m1305a.length) ? (i12 != 4 || (i7 = i5 + 2) >= m1305a.length) ? 0 : ((m1305a[i7] & 255) << 8) | ((m1305a[i5 + 1] & 255) << 16) | (m1305a[i5 + 3] & 255) : (m1305a[i8] & 255) | ((m1305a[i5 + 1] & 255) << 8);
                        i12 += i6;
                    } else {
                        i10 = m1305a[i9];
                    }
                } else {
                    i10 = m1305a[i5];
                }
                i6 = i10 & 255;
                i12 += i6;
            }
            i11 = i5 + i12;
        }
        return null;
    }

    /* renamed from: a */
    private static List<String> m1290a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        byte[] m1305a = C4264e.m1305a(str);
        int i = 0;
        while (i < m1305a.length) {
            int i2 = 1;
            int i3 = ((byte) (m1305a[i] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i3];
            System.arraycopy(m1305a, i, bArr, 0, i3);
            arrayList.add(C4264e.m1301a(bArr, i3));
            int i4 = i + i3;
            if (i4 < m1305a.length && ((byte) (m1305a[i4] & 128)) == Byte.MIN_VALUE) {
                i2 = 1 + (m1305a[i4] & 127);
            }
            i = i4 + i2;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m1287b(String str, HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX);
        arrayList.add("9F36");
        arrayList.add("9F10");
        arrayList.add("9F26");
        arrayList.add("5F34");
        arrayList.add("57");
        arrayList.add("9F63");
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                String str2 = (String) arrayList.get(i);
                String m1289a = m1289a(str, str2);
                if (m1289a != null) {
                    hashMap.put(str2, m1289a);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(hashMap.get("5F34"));
        stringBuffer.insert(0, "0");
        hashMap.put("5F34", stringBuffer.toString());
        String str3 = hashMap.get("57");
        while (true) {
            if (!str3.substring(str3.length() - 1, str3.length()).equalsIgnoreCase("f") && !str3.substring(str3.length() - 1, str3.length()).equalsIgnoreCase("F")) {
                break;
            }
            str3 = str3.substring(0, str3.length() - 1);
        }
        hashMap.put("TD2", str3.toString());
        int indexOf = str3.indexOf("D");
        String substring = str3.substring(0, indexOf);
        if (substring.endsWith("F") || substring.endsWith("f")) {
            substring = substring.substring(0, substring.length() - 1);
        }
        hashMap.put("AN1", substring);
        hashMap.put("ED", str3.substring(indexOf + 1, indexOf + 5));
        hashMap.put("AMT", hashMap.get("9F02"));
        if (hashMap.containsKey("9F10") && ((byte) (C4264e.m1305a(hashMap.get("9F10"))[4] & ByteBuffer.ZERO)) == 32) {
            hashMap.put("9F27", DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE);
        }
    }

    /* renamed from: a */
    public final String m1291a() {
        C4270b.C4271a m1283a = this.f22753c.m1283a(f22750d);
        if (m1283a.m1285b()) {
            String m1289a = m1289a(m1283a.toString(), "4F");
            if (m1289a.startsWith("A000000333")) {
                C4270b.C4271a m1283a2 = this.f22753c.m1283a(C4264e.m1305a(m1289a));
                if (m1283a2.m1285b()) {
                    return m1283a2.toString();
                }
                return null;
            }
            return "noSupUnionpay";
        }
        return null;
    }

    /* renamed from: a */
    public final String m1288a(String str, HashMap<String, String> hashMap) {
        String m1289a = m1289a(str, "9F38");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : m1290a(m1289a)) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (str2.compareToIgnoreCase(next) == 0) {
                        stringBuffer.append(hashMap.get(next));
                        break;
                    }
                }
            }
        }
        C4270b.C4272b c4272b = this.f22753c;
        byte[] m1305a = C4264e.m1305a(stringBuffer.toString());
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(m1305a.length + 7);
        allocate.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) (m1305a.length + 2)).put((byte) -125).put((byte) m1305a.length).put(m1305a);
        Log.e("PBOC Transceive", C4270b.C4272b.m1281c(allocate.array()));
        C4270b.C4271a c4271a = new C4270b.C4271a(c4272b.m1282b(allocate.array()));
        Log.e("PBOC receive", C4270b.C4272b.m1281c(c4271a.mo1286a()));
        if (c4271a.m1285b()) {
            String m1289a2 = m1289a(c4271a.toString(), "9F10");
            if (TextUtils.isEmpty(m1289a2) || ((byte) (C4264e.m1305a(m1289a2)[4] & ByteBuffer.ZERO)) == 32) {
                return c4271a.toString();
            }
            return null;
        }
        return null;
    }
}
