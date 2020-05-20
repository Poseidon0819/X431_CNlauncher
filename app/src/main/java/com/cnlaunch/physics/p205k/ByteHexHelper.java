package com.cnlaunch.physics.p205k;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.cnlaunch.physics.k.d */
/* loaded from: classes.dex */
public final class ByteHexHelper {

    /* renamed from: a */
    private static String[] f10096a = new String[256];

    /* renamed from: b */
    private static byte[] f10097b = new byte[127];

    /* renamed from: b */
    public static int m8176b(byte b) {
        return b & 255;
    }

    static {
        for (int i = 0; i < 256; i++) {
            String hexString = Integer.toHexString(i);
            if (hexString.length() < 2) {
                f10096a[i] = "0".concat(String.valueOf(hexString));
            } else {
                f10096a[i] = hexString;
            }
            if (i < 127) {
                f10097b[i] = m8172c(i);
            }
        }
    }

    /* renamed from: a */
    public static String m8180a(byte[] bArr) {
        return m8173b(bArr);
    }

    /* renamed from: b */
    public static String m8173b(byte[] bArr) {
        return bArr == null ? "" : m8179a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static String m8179a(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        int i2 = i + 0;
        if (i2 > bArr.length) {
            return "";
        }
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(f10096a[bArr[i3] & 255]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m8183a(String str) {
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            byte[] bArr2 = f10097b;
            bArr[i] = (byte) (bArr2[charArray[i2 + 1]] | (bArr2[charArray[i2]] << 4));
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m8186a(byte b) {
        StringBuilder sb = new StringBuilder("");
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() < 2) {
            sb.append(0);
        }
        sb.append(hexString);
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m8185a(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 8) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return m8183a(hexString);
    }

    /* renamed from: c */
    private static byte m8172c(int i) {
        int indexOf = "0123456789ABCDEF".indexOf(i);
        if (indexOf == -1) {
            indexOf = "0123456789abcdef".indexOf(i);
        }
        return (byte) indexOf;
    }

    /* renamed from: b */
    public static String m8174b(String str) {
        byte b;
        if (str.length() > 0) {
            b = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                String upperCase = str.substring(i2, i2 + 2).toUpperCase(Locale.ENGLISH);
                int length = upperCase.length() / 2;
                char[] charArray = upperCase.toCharArray();
                byte[] bArr = new byte[length];
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i3 * 2;
                    bArr[i3] = (byte) (m8172c(charArray[i4 + 1]) | (m8172c(charArray[i4]) << 4));
                }
                b = (byte) (b ^ bArr[0]);
            }
        } else {
            b = 0;
        }
        return m8173b(new byte[]{b});
    }

    /* renamed from: a */
    public static String m8187a() {
        int random = (int) (Math.random() * 100.0d);
        if (random == 0) {
            random = 100;
        }
        String hexString = Integer.toHexString(random);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: c */
    public static String m8171c(String str) {
        String hexString = Integer.toHexString(str.length() / 2);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: d */
    public static int m8168d(String str) {
        return Integer.valueOf(str, 16).intValue();
    }

    /* renamed from: a */
    public static String m8181a(String str, String str2, String str3, String str4, String str5, String str6) {
        return m8174b(str + str2 + str3 + str4 + str5 + str6);
    }

    /* renamed from: d */
    public static ArrayList<String> m8167d(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) < 3) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (i < length - 1) {
            int i2 = (bArr[i] << 8) | bArr[i + 1];
            int i3 = i2 - 1;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i + 2, bArr2, 0, i3);
            arrayList.add(new String(bArr2));
            i += i2 + 2;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static byte[] m8178a(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 0 && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        throw new IllegalArgumentException("字节数组参数错误");
    }

    /* renamed from: a */
    public static String m8184a(File file) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[256];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            messageDigest.update(bArr, 0, read);
        }
        fileInputStream.close();
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            sb.append(new Formatter().format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    /* renamed from: d */
    private static String m8169d(int i) {
        switch (i) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return "" + i;
        }
    }

    /* renamed from: e */
    private static String m8166e(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i / 16;
        if (i2 == 0) {
            return m8169d(i);
        }
        sb.append(m8166e(i2));
        sb.append(m8169d(i % 16));
        return sb.toString();
    }

    /* renamed from: e */
    public static String m8165e(String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes()) {
            sb.append(m8166e(b));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m8182a(String str, String str2) {
        return m8174b(str + str2);
    }

    /* renamed from: a */
    public static int m8177a(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3;
        if (bArr == null || (i3 = i2 + i) > bArr.length || bArr2 == null) {
            return -1;
        }
        int length = bArr2.length;
        while (i < i3 && i + length <= i3) {
            int i4 = i;
            for (int i5 = 0; i5 < length && bArr[i4] == bArr2[i5]; i5++) {
                if (i5 == length - 1) {
                    return i;
                }
                i4++;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: b */
    public static byte[] m8175b(int i) {
        byte[] bArr = new byte[2];
        if (i < 65535) {
            bArr[1] = (byte) (i & 255);
            bArr[0] = (byte) (i >> 8);
        } else {
            bArr[1] = 0;
            bArr[0] = 0;
        }
        return bArr;
    }

    /* renamed from: c */
    public static int m8170c(byte[] bArr) {
        return Integer.valueOf(m8173b(bArr), 16).intValue();
    }
}
