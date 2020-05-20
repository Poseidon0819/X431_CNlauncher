package com.unionpay.mobile.android.pboctransaction;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.unionpay.mobile.android.pboctransaction.e */
/* loaded from: classes2.dex */
public final class C4264e {

    /* renamed from: a */
    static HashMap<String, String> f22742a = new C4265f();

    /* renamed from: a */
    private static String m1304a(String str, String str2) {
        if (str != null && str.length() > str2.length()) {
            while (str.substring(str.length() - str2.length(), str.length()).equalsIgnoreCase(str2)) {
                str = str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    /* renamed from: a */
    public static final String m1302a(byte[] bArr) {
        return m1301a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static final String m1301a(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || i <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: a */
    private static boolean m1303a(ArrayList<AppIdentification> arrayList, String str) {
        if (str == null) {
            return false;
        }
        Iterator<AppIdentification> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().m1336a().equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static final byte[] m1305a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }

    /* renamed from: b */
    public static final ArrayList<AppIdentification> m1300b(String str) {
        if (str == null || str.length() <= 4) {
            return null;
        }
        ArrayList<AppIdentification> arrayList = new ArrayList<>();
        String substring = str.substring(str.length() - 4);
        if (substring != null && substring.equalsIgnoreCase("9000")) {
            int i = 0;
            String substring2 = str.substring(0, str.length() - 4);
            while (substring2 != null && substring2.length() > 0 && i != -1) {
                int indexOf = substring2.indexOf(DiagnoseConstants.FEEDBACK_PARALLEL_DATASTREAM, i);
                if (indexOf == -1) {
                    break;
                }
                int i2 = indexOf + 2;
                int i3 = indexOf + 4;
                String substring3 = substring2.substring(i2, i3);
                int i4 = indexOf + 6;
                String substring4 = substring2.substring(i3, i4);
                String substring5 = (Integer.parseInt(substring4, 16) * 2) + i4 < substring2.length() ? substring2.substring(i4, (Integer.parseInt(substring4, 16) * 2) + i4) : "";
                i = (Integer.parseInt(substring3, 16) * 2) + i2;
                if (i > substring2.length()) {
                    i = i2;
                }
                String trim = substring5.trim();
                if (trim.length() > 8 && !trim.equalsIgnoreCase("A0000003334355502D4D4F42494C45") && m1303a(arrayList, trim)) {
                    arrayList.add(new AppIdentification(trim, null));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static String m1299c(String str) {
        return m1304a(str, "F");
    }

    /* renamed from: d */
    public static String m1298d(String str) {
        return m1304a(str, "00");
    }

    /* renamed from: e */
    public static String m1297e(String str) {
        return f22742a.containsKey(str) ? f22742a.get(str) : "";
    }
}
