package com.cnlaunch.diagnosemodule.utils;

import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ByteHexHelper {
    private static String[] hexStringTable = new String[256];
    private static byte[] charByteTable = new byte[127];

    public static int byteToInt(byte b) {
        return b & 255;
    }

    static {
        for (int i = 0; i < 256; i++) {
            String hexString = Integer.toHexString(i);
            if (hexString.length() < 2) {
                hexStringTable[i] = "0".concat(String.valueOf(hexString));
            } else {
                hexStringTable[i] = hexString;
            }
            if (i < 127) {
                charByteTable[i] = charToByte(i);
            }
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        return bytesToHexStringWithSearchTable(bArr);
    }

    public static String bytesToHexStringWithSearchTable(byte[] bArr) {
        return bArr == null ? "" : bytesToHexStringWithSearchTable(bArr, 0, bArr.length);
    }

    public static String bytesToHexStringWithSearchTable(byte[] bArr, int i, int i2) {
        int i3;
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0 || (i3 = i2 + i) > bArr.length) {
            return "";
        }
        while (i < i3) {
            sb.append(hexStringTable[bArr[i] & 255]);
            i++;
        }
        return sb.toString();
    }

    public static String byteToHexString(byte b) {
        StringBuilder sb = new StringBuilder("");
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() < 2) {
            sb.append(0);
        }
        sb.append(hexString);
        return sb.toString();
    }

    public static String intToHexBytes(String str) {
        return bytesToHexString(intToHexBytes(Integer.parseInt(str)));
    }

    public static byte[] intToHexBytes(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexStringToBytes(hexString);
    }

    public static String intToTwoHexBytes(String str) {
        return bytesToHexString(intToTwoHexBytes(Integer.parseInt(str)));
    }

    public static byte[] intToTwoHexBytes(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexStringToBytes(hexString);
    }

    public static String intToTwoHexString(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    public static byte[] intToThreeHexBytesLast(int i) {
        String bin2hex = bin2hex(String.valueOf(i));
        int length = bin2hex.length();
        while (length < 6) {
            bin2hex = bin2hex + "0";
            length = bin2hex.length();
        }
        return hexStringToBytes(bin2hex);
    }

    public static String intToFourHexBytes(String str) {
        return bytesToHexString(intToFourHexBytes(Integer.parseInt(str)));
    }

    public static byte[] intToFourHexBytes(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 8) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexStringToBytes(hexString);
    }

    public static byte[] intToFourHexBytesTwoBefor(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        if (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        while (length < 8) {
            hexString = hexString + "0";
            length = hexString.length();
        }
        return hexStringToBytes(hexString);
    }

    public static byte[] intToFourHexBytesTwo(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        if (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        if (length % 2 == 1) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        int i2 = length / 2;
        while (length < 8) {
            hexString = hexString + "0";
            length = hexString.length();
        }
        byte[] hexStringToBytes = hexStringToBytes(hexString);
        int i3 = 0;
        for (int i4 = i2 - 1; i3 < i4; i4--) {
            byte b = hexStringToBytes[i3];
            hexStringToBytes[i3] = hexStringToBytes[i4];
            hexStringToBytes[i4] = b;
            i3++;
        }
        return hexStringToBytes;
    }

    public static byte[] diyIntToBytes(String str, int i, boolean z, boolean z2) {
        return diyIntToBytes(Integer.parseInt(str), i, z, z2);
    }

    public static byte[] diyIntToBytes(int i, int i2, boolean z, boolean z2) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < i2 * 2) {
            hexString = !z ? hexString + "0" : "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        int i3 = length / 2;
        byte[] hexStringToBytes = hexStringToBytes(hexString);
        if (z2) {
            int i4 = 0;
            for (int i5 = i3 - 1; i4 < i5; i5--) {
                byte b = hexStringToBytes[i4];
                hexStringToBytes[i4] = hexStringToBytes[i5];
                hexStringToBytes[i5] = b;
                i4++;
            }
        }
        return hexStringToBytes;
    }

    public static byte intToHexByte(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexStringToByte(hexString);
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            byte[] bArr2 = charByteTable;
            bArr[i] = (byte) (bArr2[charArray[i2 + 1]] | (bArr2[charArray[i2]] << 4));
        }
        return bArr;
    }

    public static byte hexStringToByte(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr[0];
    }

    private static byte charToByte(int i) {
        int indexOf = "0123456789ABCDEF".indexOf(i);
        if (indexOf == -1) {
            indexOf = "0123456789abcdef".indexOf(i);
        }
        return (byte) indexOf;
    }

    public static String XOR(String str) {
        byte b;
        if (str.length() > 0) {
            b = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                b = (byte) (b ^ hexStringToByte(str.substring(i2, i2 + 2)));
            }
        } else {
            b = 0;
        }
        return bytesToHexString(new byte[]{b});
    }

    public static String currentData() {
        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        Calendar calendar = Calendar.getInstance();
        String format = decimalFormat.format(calendar.get(1));
        String format2 = decimalFormat.format(calendar.get(2) + 1);
        String format3 = decimalFormat.format(calendar.get(5));
        String format4 = decimalFormat.format(calendar.get(11));
        String format5 = decimalFormat.format(calendar.get(12));
        String format6 = decimalFormat.format(calendar.get(13));
        String format7 = decimalFormat.format(calendar.get(7) - 1);
        stringBuffer.append(format.substring(2, format.length()));
        stringBuffer.append(format2);
        stringBuffer.append(format3);
        stringBuffer.append(format4);
        stringBuffer.append(format5);
        stringBuffer.append(format6);
        stringBuffer.append(format7);
        return stringBuffer.toString();
    }

    public static String RandomMethod() {
        String hexString = Integer.toHexString((int) (Math.random() * 100.0d));
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    public static String packLength(String str) {
        String hexString = Integer.toHexString(str.length() / 2);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    public static String checkedSite(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    public static String packLength(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    public static int intPackLength(String str) {
        return Integer.valueOf(str, 16).intValue();
    }

    public static int intPackLength(byte[] bArr) {
        return Integer.valueOf(bytesToHexString(bArr), 16).intValue();
    }

    public static String packVerify(String str, String str2, String str3, String str4, String str5, String str6) {
        return XOR(str + str2 + str3 + str4 + str5 + str6);
    }

    public static String dpuString(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String bytesToHexString = bytesToHexString((str + "\u0000").getBytes());
        String str2 = packLength(bytesToHexString) + bytesToHexString;
        System.out.println("resultLength==".concat(String.valueOf(str2)));
        return str2;
    }

    public static String byteToWord(byte[] bArr) {
        if (bArr != null) {
            try {
                if (TextUtils.isEmpty(DiagnoseConstants.DIAGNOSE_LANGUAGE)) {
                    DiagnoseConstants.DIAGNOSE_LANGUAGE = DiagnoseBusiness.getMatchedLanguage();
                }
                switch (AndroidToLan.languages(DiagnoseConstants.LOCAL_LANGUAGE.getCountry())) {
                    case 0:
                        return new String(bArr, "GB2312");
                    case 1:
                        return new String(bArr, "GB2312");
                    case 2:
                        return new String(bArr, "EUC-JP");
                    case 3:
                        return new String(bArr, "ISO-8859-1");
                    case 4:
                        return new String(bArr, "BIG5");
                    case 5:
                        return new String(bArr, "ISO-8859-1");
                    case 6:
                        return new String(bArr, "ISO-8859-1");
                    case 7:
                        return new String(bArr, "ISO-8859-5");
                    case 8:
                        return new String(bArr, "ISO-8859-1");
                    case 9:
                        return new String(bArr, "ISO-8859-1");
                    case 10:
                        return new String(bArr, "ISO-8859-2");
                    case 11:
                        return new String(bArr, "ISO-8859-9");
                    case 12:
                        return new String(bArr, "ISO-8859-1");
                    case 13:
                        return new String(bArr, "ISO-8859-7");
                    case 14:
                        return new String(bArr, "ISO-8859-2");
                    case 15:
                        return new String(bArr, "ISO-8859-6");
                    case 16:
                        return new String(bArr, "ISO-8859-5");
                    case 17:
                        return new String(bArr, "ISO-8859-2");
                    case 18:
                        return new String(bArr, "ISO-8859-1");
                    case 19:
                        return new String(bArr, "windows-1256");
                    case 20:
                        return new String(bArr, "euc-kr");
                    case 21:
                        return new String(bArr, "ISO-8859-1");
                    case 22:
                        return new String(bArr, "ISO-8859-1");
                    case 23:
                        return new String(bArr, "ISO-8859-2");
                    default:
                        return new String(bArr, "GB2312");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String hexStringToWord(String str) {
        return byteToWord(hexStringToBytes(str));
    }

    public static byte[] binaryString2bytes(String str) {
        return hexStringToBytes(binaryString2hexString(str));
    }

    public static String binaryString2hexString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        if (str.length() % 8 != 0) {
            int length = 8 - (str.length() % 8);
            String str2 = str;
            for (int i = 0; i < length; i++) {
                str2 = str2 + "0";
            }
            str = str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2 += 4) {
            int i3 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = i2 + i4;
                i3 += Integer.parseInt(str.substring(i5, i5 + 1)) << ((4 - i4) - 1);
            }
            stringBuffer.append(Integer.toHexString(i3));
        }
        return stringBuffer.toString();
    }

    public static String hexString2binaryString(String str) {
        if (str == null || str.length() % 2 != 0) {
            return null;
        }
        String str2 = "";
        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder("0000");
            int i2 = i + 1;
            sb.append(Integer.toBinaryString(Integer.parseInt(str.substring(i, i2), 16)));
            String sb2 = sb.toString();
            str2 = str2 + sb2.substring(sb2.length() - 4);
            i = i2;
        }
        return str2;
    }

    public static String replaceBlank(String str) {
        return (str != null ? Pattern.compile("\t|\r|\n").matcher(str).replaceAll("") : "").trim();
    }

    public static String replaceBlank1(String str) {
        String replaceAll = str != null ? Pattern.compile("\t|\r|\n").matcher(str).replaceAll("") : "";
        if (replaceAll.length() > 6) {
            replaceAll = replaceAll.substring(0, 2) + "," + replaceAll.substring(2, 4) + "," + replaceAll.substring(4, 6) + "," + replaceAll.substring(6, replaceAll.length());
        }
        return replaceAll.trim();
    }

    public static ArrayList<String> toStringArray(byte[] bArr) {
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

    public static byte[] appendByteArray(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 0 && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        throw new IllegalArgumentException("字节数组参数错误");
    }

    public static String calculateSingleFileMD5sum(File file) throws Exception {
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

    private static String toHexUtil(int i) {
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

    public static String toHex(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i / 16;
        if (i2 == 0) {
            return toHexUtil(i);
        }
        sb.append(toHex(i2));
        sb.append(toHexUtil(i % 16));
        return sb.toString();
    }

    public static String parseAscii(String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes()) {
            sb.append(toHex(b));
        }
        return sb.toString();
    }

    public static byte[] byteMerger(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String stringToHex(String str) {
        try {
            return new String(str.getBytes(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] bin2hex2byte(String str) {
        return hexStringToBytes(bin2hex(str));
    }

    public static String bin2hex(String str) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuffer stringBuffer = new StringBuffer("");
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(charArray[(bytes[i] & 240) >> 4]);
            stringBuffer.append(charArray[bytes[i] & 15]);
        }
        return stringBuffer.toString();
    }

    public static byte[] hex2bin2byte(String str) {
        return hexStringToBytes(hex2bin(str));
    }

    public static String hex2bin(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i2]) * 16) + "0123456789ABCDEF".indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }

    public static String byte2hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toUpperCase();
    }

    public static byte[] hex2byte(byte[] bArr) {
        if (bArr.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] bArr2 = new byte[bArr.length / 2];
        for (int i = 0; i < bArr.length; i += 2) {
            bArr2[i / 2] = (byte) Integer.parseInt(new String(bArr, i, 2), 16);
        }
        return bArr2;
    }

    public static byte[] hexToMaskCheckCount(String str) {
        return binToMaskCheckCount(hexString2binaryString(str));
    }

    public static byte[] binToMaskCheckCount(String str) {
        return planningMask(str);
    }

    public static byte[] byteToMaskCheckCount(byte[] bArr) {
        return hexToMaskCheckCount(bytesToHexString(bArr));
    }

    private static byte[] planningMask(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            if (str.substring(i, i3).equals("1")) {
                i2++;
            }
            i = i3;
        }
        return intToTwoHexBytes(i2);
    }

    public static String hexToBinaryStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            String concat = "0000".concat(String.valueOf(Integer.toBinaryString(Integer.parseInt(str.substring(i, i2), 16))));
            stringBuffer.append(concat.substring(concat.length() - 4));
            i = i2;
        }
        return stringBuffer.toString();
    }

    public static String BinaryToTwoHex(String str) {
        return Integer.toHexString(Integer.parseInt(str, 2));
    }

    public static String tenToBinaryStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String concat = "00000000".concat(String.valueOf(Integer.toBinaryString(Integer.parseInt(str, 10))));
        stringBuffer.append(concat.substring(concat.length() - 8, concat.length()));
        return stringBuffer.toString();
    }
}
