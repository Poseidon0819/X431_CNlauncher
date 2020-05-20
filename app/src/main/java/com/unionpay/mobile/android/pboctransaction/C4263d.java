package com.unionpay.mobile.android.pboctransaction;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.unionpay.mobile.android.fully.InterfaceC4148a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.samsung.C4283f;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.pboctransaction.d */
/* loaded from: classes2.dex */
public final class C4263d {

    /* renamed from: c */
    InterfaceC4262c f22729c;

    /* renamed from: d */
    InterfaceC4148a f22730d;

    /* renamed from: f */
    private String f22732f;

    /* renamed from: l */
    private static Date f22725l = new Date(System.currentTimeMillis());

    /* renamed from: m */
    private static String f22726m = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) f22725l);

    /* renamed from: o */
    private static HashMap<String, String> f22727o = new HashMap<>();

    /* renamed from: a */
    public static String f22723a = "A0000003330101010000000000010000";

    /* renamed from: b */
    public static String f22724b = "A0000003330101020001050001000000";

    /* renamed from: s */
    private static C4263d f22728s = null;

    /* renamed from: g */
    private byte f22733g = 0;

    /* renamed from: h */
    private byte f22734h = 0;

    /* renamed from: i */
    private byte f22735i = 1;

    /* renamed from: j */
    private boolean f22736j = true;

    /* renamed from: k */
    private boolean f22737k = true;

    /* renamed from: n */
    private String f22738n = null;

    /* renamed from: p */
    private final String f22739p = "A0000003334355502D4D4F42494C45";

    /* renamed from: q */
    private boolean f22740q = false;

    /* renamed from: e */
    public boolean f22731e = false;

    /* renamed from: r */
    private String f22741r = "";

    public C4263d(InterfaceC4262c interfaceC4262c, InterfaceC4148a interfaceC4148a, String str) {
        this.f22732f = "1.4";
        this.f22732f = str;
        this.f22729c = interfaceC4262c;
        this.f22730d = interfaceC4148a;
    }

    /* renamed from: a */
    private static String m1325a(String str, String str2) {
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
    private static String m1323a(String str, boolean z) {
        int i;
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.toUpperCase().getBytes();
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bytes[i2])));
        }
        int length2 = (stringBuffer.length() / 2) + (stringBuffer.length() % 2);
        if (z) {
            i = length2 + 1;
            int i3 = i % 8;
            if (i3 != 0) {
                i += 8 - i3;
            }
            bArr = new byte[i];
            System.arraycopy(C4264e.m1305a(stringBuffer.toString()), 0, bArr, 0, length2);
            bArr[length2] = Byte.MIN_VALUE;
        } else {
            int i4 = length2 % 8;
            i = i4 != 0 ? (8 - i4) + length2 : length2;
            bArr = new byte[i];
            System.arraycopy(C4264e.m1305a(stringBuffer.toString()), 0, bArr, 0, length2);
        }
        return C4264e.m1301a(bArr, i);
    }

    /* renamed from: a */
    private String m1322a(byte[] bArr) {
        byte b = bArr[0];
        byte b2 = this.f22733g;
        bArr[0] = (byte) (b | b2);
        byte[] mo1234a = this.f22729c.mo1234a(bArr, b2);
        int length = mo1234a != null ? mo1234a.length : 0;
        if (length >= 2 && mo1234a[length - 2] == 97) {
            byte b3 = mo1234a[length - 1];
            byte b4 = this.f22733g;
            mo1234a = this.f22729c.mo1234a(new byte[]{b4, -64, 0, 0, b3}, b4);
            length = mo1234a != null ? mo1234a.length : 0;
        }
        if (length >= 2 && mo1234a[length - 2] == 108) {
            bArr[bArr.length - 1] = mo1234a[length - 1];
            mo1234a = this.f22729c.mo1234a(bArr, this.f22733g);
            length = mo1234a != null ? mo1234a.length : 0;
        }
        if (length > 2) {
            int i = length - 2;
            if (mo1234a[i] == -112 && mo1234a[length - 1] == 0) {
                return C4264e.m1301a(mo1234a, i);
            }
        }
        if (length == 2 && mo1234a[length - 2] == -112 && mo1234a[length - 1] == 0) {
            return C4264e.m1301a(mo1234a, 2);
        }
        return null;
    }

    /* renamed from: a */
    private String m1321a(byte[] bArr, String str) {
        bArr[4] = (byte) (str.length() / 2);
        byte[] bArr2 = new byte[(str.length() / 2) + 5];
        System.arraycopy(bArr, 0, bArr2, 0, 5);
        System.arraycopy(C4264e.m1305a(str), 0, bArr2, 5, str.length() / 2);
        return m1322a(bArr2);
    }

    /* renamed from: a */
    private static void m1324a(String str, StringBuffer stringBuffer) {
        String str2 = f22727o.get(str);
        String m1301a = C4264e.m1301a(new byte[]{(byte) (str2.length() / 2)}, 1);
        stringBuffer.append(str);
        stringBuffer.append(m1301a);
        stringBuffer.append(str2);
    }

    /* renamed from: b */
    private String m1319b(String str) {
        InterfaceC4262c interfaceC4262c = this.f22729c;
        if (interfaceC4262c instanceof C4283f) {
            return interfaceC4262c.mo1236a(str);
        }
        this.f22733g = this.f22734h;
        if (str != null) {
            String m1302a = C4264e.m1302a(new byte[]{Integer.valueOf(str.length() / 2).byteValue()});
            return m1322a(C4264e.m1305a("00a40400" + m1302a + str));
        }
        return null;
    }

    /* renamed from: b */
    private void m1318b(byte[] bArr) {
        int length = (f22726m.length() / 2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(C4264e.m1305a(f22726m), 0, bArr2, 0, f22726m.length() / 2);
        bArr2[length - 1] = Byte.MIN_VALUE;
        bArr[4] = (byte) bArr2.length;
        byte[] bArr3 = new byte[bArr2.length + 5];
        System.arraycopy(bArr, 0, bArr3, 0, 5);
        System.arraycopy(bArr2, 0, bArr3, 5, bArr2.length);
        m1322a(bArr3);
    }

    /* renamed from: c */
    private String m1316c(String str) {
        byte[] m1305a;
        if (str == null || "9000".equals(str)) {
            StringBuffer stringBuffer = new StringBuffer("80A800000b8309");
            for (String str2 : m1306i("9F7A019F02065F2A02")) {
                Iterator<String> it = f22727o.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (str2.compareToIgnoreCase(next) == 0) {
                            stringBuffer.append(f22727o.get(next));
                            break;
                        }
                    }
                }
            }
            m1305a = C4264e.m1305a(stringBuffer.toString());
        } else {
            C4390k.m836c("uppay", "test for gongshang version 2");
            StringBuffer stringBuffer2 = new StringBuffer("");
            String m1325a = m1325a(str, "9F38");
            if (TextUtils.isEmpty(m1325a)) {
                ByteBuffer allocate = ByteBuffer.allocate(7);
                allocate.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) 2).put((byte) -125).put((byte) 0);
                m1305a = allocate.array();
            } else {
                for (String str3 : m1306i(m1325a)) {
                    Iterator<String> it2 = f22727o.keySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (str3.compareToIgnoreCase(next2) == 0) {
                                stringBuffer2.append(f22727o.get(next2));
                                break;
                            }
                        }
                    }
                }
                byte[] m1305a2 = C4264e.m1305a(stringBuffer2.toString());
                ByteBuffer allocate2 = ByteBuffer.allocate(m1305a2.length + 7);
                allocate2.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) (m1305a2.length + 2)).put((byte) -125).put((byte) m1305a2.length).put(m1305a2);
                m1305a = allocate2.array();
            }
        }
        return m1322a(m1305a);
    }

    /* renamed from: d */
    private String m1314d(String str) {
        String m1325a = m1325a(str, DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE);
        if (m1325a == null) {
            return null;
        }
        int i = 4;
        f22727o.put(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, m1325a.substring(0, 4));
        byte[] m1305a = C4264e.m1305a(m1325a.substring(4));
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("5A");
        arrayList.add("5F34");
        arrayList.add("9F1F");
        arrayList.add("57");
        arrayList.add("5F24");
        arrayList.add("9F10");
        arrayList.add("8C");
        arrayList.add("8D");
        int i2 = 0;
        while (i2 < m1305a.length) {
            try {
                byte[] bArr = new byte[5];
                bArr[0] = 0;
                bArr[1] = -78;
                bArr[2] = 0;
                bArr[3] = 0;
                bArr[i] = 0;
                byte[] bArr2 = new byte[i];
                System.arraycopy(m1305a, i2, bArr2, 0, i);
                i2 += 4;
                byte b = bArr2[1];
                while (b <= bArr2[2]) {
                    bArr[i] = 0;
                    bArr[3] = (byte) ((bArr2[0] & (-8)) | i);
                    bArr[2] = b;
                    b = (byte) (b + 1);
                    try {
                        String m1322a = m1322a(bArr);
                        if (m1322a != null) {
                            for (String str2 : arrayList) {
                                String m1325a2 = m1325a(m1322a, str2);
                                if (m1325a2 != null) {
                                    f22727o.put(str2, m1325a2);
                                }
                            }
                        }
                        i = 4;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return f22727o.get("8C");
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(f22727o.get("5F34"));
        stringBuffer.insert(0, "0");
        f22727o.put("5F34", stringBuffer.toString());
        return f22727o.get("8C");
    }

    /* renamed from: d */
    private static void m1315d() {
        String substring = f22726m.substring(2, 8);
        long time = new Date(System.currentTimeMillis()).getTime();
        String valueOf = String.valueOf(time);
        String format = valueOf.length() < 8 ? String.format("%08d", Long.valueOf(time)) : valueOf.substring(valueOf.length() - 8, valueOf.length());
        f22727o.put("9F26", "");
        f22727o.put("9F27", DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE);
        f22727o.put("9F10", "");
        f22727o.put("9F37", format);
        f22727o.put("9F36", "");
        f22727o.put("95", "0000000800");
        f22727o.put("9A", substring);
        f22727o.put("9C", "45");
        f22727o.put("9F02", Constant.DEFAULT_BALANCE);
        f22727o.put("5F2A", "0156");
        f22727o.put(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "");
        f22727o.put("9F1A", "0156");
        f22727o.put("9F03", Constant.DEFAULT_BALANCE);
        f22727o.put("9F33", "A04000");
        f22727o.put("9F34", "420300");
        f22727o.put("9F35", DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE);
        f22727o.put("9F1E", "3030303030303030");
        f22727o.put(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW, "");
        f22727o.put("9F09", "0001");
        f22727o.put("9F74", "");
        f22727o.put("9F63", "");
        f22727o.put("9F7A", "01");
        f22727o.put("9F21", f22726m.substring(8));
        f22727o.put("9F4E", "0000000000000000000000000000000000000000");
        f22727o.put("DF31", "0100000000");
        f22727o.put("9F66", "36800000");
        f22727o.put("DF60", "00");
    }

    /* renamed from: e */
    private String m1312e(String str) {
        StringBuffer stringBuffer = new StringBuffer("80AE800034");
        for (String str2 : m1306i(str)) {
            Iterator<String> it = f22727o.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (str2.compareToIgnoreCase(next) == 0) {
                        stringBuffer.append(f22727o.get(next));
                        break;
                    }
                }
            }
        }
        String m1322a = m1322a(C4264e.m1305a(stringBuffer.toString()));
        if (m1322a != null) {
            f22727o.put("9F27", m1322a.substring(4, 6));
            f22727o.put("9F36", m1322a.substring(6, 10));
            f22727o.put("9F26", m1322a.substring(10, 26));
            f22727o.put("9F10", m1322a.substring(26));
        }
        return m1322a;
    }

    /* renamed from: e */
    private boolean m1313e() {
        String str = f22727o.get("5A");
        while (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f")) {
            str = str.substring(0, str.length() - 1);
        }
        String m1310f = m1310f(str);
        if (m1310f != null && m1310f.length() != 0) {
            f22727o.put("AN1", m1310f);
            String m1310f2 = m1310f("00000001");
            if (m1310f2 != null && m1310f2.length() != 0) {
                f22727o.put("TID", m1310f2);
                String m1310f3 = m1310f(f22727o.get("9F02"));
                if (m1310f3 != null && m1310f3.length() != 0) {
                    f22727o.put("AMT", m1310f3);
                    String m1310f4 = m1310f("156");
                    if (m1310f4 != null && m1310f4.length() != 0) {
                        f22727o.put("CUR", m1310f4);
                        String str2 = f22727o.get("57");
                        while (true) {
                            if (!str2.substring(str2.length() - 1, str2.length()).equalsIgnoreCase("f") && !str2.substring(str2.length() - 1, str2.length()).equalsIgnoreCase("F")) {
                                break;
                            }
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String m1310f5 = m1310f(str2);
                        if (m1310f5 == null || m1310f5.length() == 0) {
                            return false;
                        }
                        f22727o.put("TD2", m1310f5);
                        if (f22727o.get("5F24") != null && f22727o.get("5F24").length() == 6) {
                            String m1310f6 = m1310f(f22727o.get("5F24").substring(0, 4));
                            if (m1310f6 == null || m1310f6.length() == 0) {
                                return false;
                            }
                            f22727o.put("ED", m1310f6);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    private String m1311f() {
        this.f22733g = this.f22735i;
        String m1322a = m1322a(new byte[]{0, -80, -126, 0, 10});
        if (m1322a != null && m1322a.length() != 0) {
            f22727o.put("CSN", m1322a);
        }
        this.f22733g = this.f22734h;
        return m1322a;
    }

    /* renamed from: f */
    private String m1310f(String str) {
        this.f22733g = this.f22735i;
        String m1323a = m1323a(str, false);
        m1318b(new byte[]{Byte.MIN_VALUE, 26, 19, 1, 0});
        String m1321a = m1321a(new byte[]{Byte.MIN_VALUE, -6, 0, 0, 0}, m1323a);
        this.f22733g = this.f22734h;
        return m1321a;
    }

    /* renamed from: g */
    private static Bundle m1309g() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    /* renamed from: g */
    private String m1308g(String str) {
        this.f22733g = this.f22735i;
        byte[] bArr = {Byte.MIN_VALUE, 26, 20, 1, 0};
        byte[] bArr2 = {Byte.MIN_VALUE, -6, 0, 0, 0};
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", Integer.valueOf(str.length())));
        sb.append(str);
        String sb2 = sb.toString();
        StringBuffer stringBuffer = new StringBuffer(sb2);
        for (int i = 0; i < 16 - sb2.length(); i++) {
            stringBuffer.append("F");
        }
        m1318b(bArr);
        String m1321a = m1321a(bArr2, stringBuffer.toString());
        if (m1321a != null) {
            f22727o.put("PIN", m1321a);
        }
        this.f22733g = this.f22734h;
        return m1321a;
    }

    /* renamed from: h */
    private String m1307h(String str) {
        this.f22733g = this.f22735i;
        byte[] bArr = {Byte.MIN_VALUE, -6, 1, 0, 0};
        String m1323a = m1323a(str, true);
        m1318b(new byte[]{Byte.MIN_VALUE, 26, 21, 1, 8});
        while (m1323a.length() > 448) {
            bArr[2] = 3;
            m1321a(bArr, m1323a.substring(0, 448).toUpperCase());
            m1323a = m1323a.substring(448);
        }
        bArr[2] = 1;
        if (Build.VERSION.SDK_INT <= 10) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String m1321a = m1321a(bArr, m1323a);
        C4390k.m836c("uppay", "encryptMac in resp".concat(String.valueOf(m1321a)));
        if (m1321a != null) {
            f22727o.put("MAC", m1321a.toUpperCase());
        }
        this.f22733g = this.f22734h;
        return m1321a != null ? m1321a.toUpperCase() : m1321a;
    }

    /* renamed from: i */
    private static List<String> m1306i(String str) {
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

    /* renamed from: a */
    public final synchronized Bundle m1329a(int i, String str, HashMap<String, String> hashMap, String str2) {
        C4390k.m836c("uppay", "startUPCardPurchase() +++");
        Bundle m1309g = m1309g();
        String str3 = "";
        this.f22729c.mo1233b();
        String m1331a = m1331a();
        if (m1331a != null && m1331a.length() != 0) {
            C4390k.m836c("uppay", " ************T1=" + f22726m);
            f22727o.put("PIN", str);
            String m1308g = m1308g(PreferenceUtils.decPrefData(f22727o.get("PIN"), str2));
            if (m1308g != null && m1308g.length() != 0) {
                C4390k.m836c("uppay", " ************T2=" + f22726m);
                String m1330a = m1330a(i, f22726m);
                if (m1330a != null && m1330a.length() != 0) {
                    String m1311f = m1311f();
                    if (m1311f != null && m1311f.length() != 0) {
                        String m1299c = C4264e.m1299c(m1330a.substring(40, 60));
                        String substring = m1330a.substring(60, 100);
                        String substring2 = m1330a.substring(100, 208);
                        String substring3 = m1330a.substring(216, SmileConstants.TOKEN_MISC_BINARY_7BIT);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("v", this.f22732f);
                            jSONObject.put("cmd", "pay");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
                            jSONObject2.put("pay_type", "2");
                            jSONObject2.put("pay_mode", "1");
                            jSONObject2.put("bind", "no");
                            jSONObject2.put("carrier_tp", "1");
                            jSONObject2.put("track2_data", substring);
                            jSONObject2.put("track3_data", substring2);
                            jSONObject2.put("csn", f22727o.get("CSN"));
                            jSONObject2.put("submit_time", f22726m);
                            jSONObject2.put("sp_id", "8889");
                            jSONObject2.put(Constant.KEY_PIN, f22727o.get("PIN"));
                            jSONObject2.put(Constant.KEY_PAN, m1299c);
                            jSONObject2.put("dynamic_key_data", substring3);
                            jSONObject2.put("carrier_app_tp", "1");
                            if (hashMap != null && hashMap.keySet() != null && hashMap.keySet().size() > 0) {
                                hashMap.remove(Constant.KEY_PAN);
                                hashMap.remove(Constant.KEY_PIN);
                                for (String str4 : hashMap.keySet()) {
                                    jSONObject2.put(str4, hashMap.get(str4));
                                }
                            }
                            str3 = jSONObject.toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        C4390k.m836c("uppay", " ************T3=" + f22726m);
                        m1309g.putString("action_resp_message", this.f22730d.mo833a(str3));
                        this.f22729c.mo1230c();
                        m1315d();
                        return m1309g;
                    }
                    this.f22729c.mo1230c();
                    m1309g.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                    return m1309g;
                }
                this.f22729c.mo1230c();
                m1309g.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                return m1309g;
            }
            this.f22729c.mo1230c();
            m1309g.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return m1309g;
        }
        this.f22729c.mo1230c();
        m1309g.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
        return m1309g;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0190 A[Catch: all -> 0x0509, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0058, B:8:0x006a, B:10:0x00ad, B:13:0x00b5, B:15:0x00d1, B:18:0x00d9, B:20:0x00f5, B:23:0x00fd, B:25:0x0119, B:28:0x0120, B:30:0x013c, B:33:0x0143, B:35:0x015f, B:44:0x0186, B:46:0x0190, B:49:0x0197, B:51:0x01c1, B:54:0x01c9, B:56:0x01d6, B:59:0x01eb, B:61:0x0261, B:63:0x026b, B:65:0x0275, B:67:0x027f, B:69:0x0289, B:72:0x0295, B:74:0x02a9, B:75:0x02b4, B:77:0x02be, B:78:0x02c9, B:80:0x02d3, B:81:0x02de, B:83:0x02e8, B:84:0x02f3, B:86:0x0312, B:87:0x031d, B:89:0x0321, B:91:0x032b, B:92:0x0336, B:94:0x0340, B:95:0x034b, B:97:0x0355, B:98:0x0360, B:99:0x0366, B:101:0x036c, B:103:0x0374, B:104:0x0389, B:106:0x03a9, B:109:0x03b1, B:111:0x040e, B:113:0x041b, B:115:0x0457, B:116:0x0464, B:118:0x046e, B:120:0x047d, B:122:0x0483, B:124:0x048d, B:125:0x049f, B:127:0x04a5, B:128:0x04b3, B:129:0x04b7, B:132:0x04d1, B:135:0x04df, B:138:0x04ed, B:141:0x04fb, B:38:0x0169), top: B:150:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0197 A[Catch: all -> 0x0509, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0058, B:8:0x006a, B:10:0x00ad, B:13:0x00b5, B:15:0x00d1, B:18:0x00d9, B:20:0x00f5, B:23:0x00fd, B:25:0x0119, B:28:0x0120, B:30:0x013c, B:33:0x0143, B:35:0x015f, B:44:0x0186, B:46:0x0190, B:49:0x0197, B:51:0x01c1, B:54:0x01c9, B:56:0x01d6, B:59:0x01eb, B:61:0x0261, B:63:0x026b, B:65:0x0275, B:67:0x027f, B:69:0x0289, B:72:0x0295, B:74:0x02a9, B:75:0x02b4, B:77:0x02be, B:78:0x02c9, B:80:0x02d3, B:81:0x02de, B:83:0x02e8, B:84:0x02f3, B:86:0x0312, B:87:0x031d, B:89:0x0321, B:91:0x032b, B:92:0x0336, B:94:0x0340, B:95:0x034b, B:97:0x0355, B:98:0x0360, B:99:0x0366, B:101:0x036c, B:103:0x0374, B:104:0x0389, B:106:0x03a9, B:109:0x03b1, B:111:0x040e, B:113:0x041b, B:115:0x0457, B:116:0x0464, B:118:0x046e, B:120:0x047d, B:122:0x0483, B:124:0x048d, B:125:0x049f, B:127:0x04a5, B:128:0x04b3, B:129:0x04b7, B:132:0x04d1, B:135:0x04df, B:138:0x04ed, B:141:0x04fb, B:38:0x0169), top: B:150:0x0001, inners: #0 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.os.Bundle m1327a(com.unionpay.mobile.android.pboctransaction.AppIdentification r4, java.lang.String r5, java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.String> r7, java.util.HashMap<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 1293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.pboctransaction.C4263d.m1327a(com.unionpay.mobile.android.pboctransaction.AppIdentification, java.lang.String, java.lang.String, java.util.HashMap, java.util.HashMap, java.lang.String):android.os.Bundle");
    }

    /* renamed from: a */
    public final String m1331a() {
        InterfaceC4262c interfaceC4262c = this.f22729c;
        if (interfaceC4262c instanceof C4283f) {
            return interfaceC4262c.mo1236a("A0000003334355502D4D4F42494C45");
        }
        this.f22733g = this.f22735i;
        return m1322a(new byte[]{0, -92, 4, 0, 15, -96, 0, 0, 3, 51, 67, 85, 80, 45, 77, 79, 66, 73, 76, 69});
    }

    /* renamed from: a */
    public final String m1330a(int i, String str) {
        String hexString;
        this.f22733g = this.f22735i;
        if (Integer.toHexString(i).length() == 1) {
            hexString = "0" + Integer.toHexString(i);
        } else {
            hexString = Integer.toHexString(i);
        }
        return m1322a(C4264e.m1305a("80F802" + hexString + "08" + str + DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE));
    }

    /* renamed from: a */
    public final synchronized String m1328a(AppIdentification appIdentification) {
        String m1336a = appIdentification.m1336a();
        m1315d();
        m1319b(m1336a);
        String m1316c = m1316c(null);
        if (m1316c != null && m1316c.length() != 0) {
            String m1314d = m1314d(m1316c);
            if (m1314d != null && m1314d.length() != 0) {
                return f22727o.get("5A");
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public final String m1326a(String str) {
        this.f22729c.mo1229d();
        String m1319b = m1319b(str);
        this.f22729c.mo1229d();
        return m1325a(m1319b, DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW);
    }

    /* renamed from: b */
    public final ArrayList<InterfaceC4174c> m1320b() {
        this.f22729c.mo1229d();
        this.f22729c.mo1233b();
        ArrayList<InterfaceC4174c> mo1238a = this.f22729c.mo1238a(this);
        this.f22729c.mo1230c();
        return mo1238a;
    }

    /* renamed from: c */
    public final String m1317c() {
        this.f22733g = this.f22735i;
        return m1322a(C4264e.m1305a("80F2000102"));
    }
}
