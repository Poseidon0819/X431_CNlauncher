package com.cnlaunch.diagnosemodule.utils;

import com.cnlaunch.physics.p205k.C1856n;

/* loaded from: classes.dex */
public class OrderMontage {
    private static final byte SOURCE_ADDR = -8;
    private static final String TAG = "OrderMontage";
    private static final byte TARGET_ADDR = -16;
    private static final String source = "F8";
    private static final String startCode = "55aa";
    private static final String target = "F0";
    private static final byte[] START_CODE = {85, -86};
    private static byte packageCounter = 0;
    private static String counter = "";
    private static String packLengths = "";
    private static String commandWord = "";
    private static String dataArea = "";
    private static String packVerify = "";

    public static byte[] smartBox2701(byte[] bArr, String str) {
        String RandomMethod = ByteHexHelper.RandomMethod();
        while (RandomMethod.equalsIgnoreCase(counter)) {
            RandomMethod = ByteHexHelper.RandomMethod();
        }
        counter = RandomMethod;
        commandWord = str;
        dataArea = ByteHexHelper.bytesToHexString(bArr);
        packLengths = ByteHexHelper.packLength(counter + commandWord + dataArea);
        packVerify = ByteHexHelper.packVerify(target, source, packLengths, counter, commandWord, dataArea);
        return ByteHexHelper.hexStringToBytes("55aaF0F8" + packLengths + counter + commandWord + dataArea + packVerify);
    }

    public static byte[] smartBox2701ForHeavyduty(byte[] bArr) {
        dataArea = ByteHexHelper.bytesToHexString(bArr);
        int length = ((dataArea.getBytes().length + 1) / 2) + 4 + 1;
        int i = length & 255;
        int i2 = (length >> 8) & 255;
        packLengths = matchLen(Integer.toHexString(i2)) + matchLen(Integer.toHexString(i)) + matchLen(Integer.toHexString((i2 ^ (-1)) & 255)) + matchLen(Integer.toHexString((i ^ (-1)) & 255));
        packVerify = ByteHexHelper.XOR(packLengths + dataArea);
        String str = startCode + packLengths + dataArea + packVerify;
        byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(str);
        C1856n.m8130a(TAG, "order=".concat(String.valueOf(str)));
        return hexStringToBytes;
    }

    public static String matchLen(String str) {
        while (str.length() < 2) {
            str = "0".concat(String.valueOf(str));
        }
        return str;
    }

    public static byte[] packingFullCommand(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null || bArr2 == null) {
            return null;
        }
        if (bArr2 == null || bArr2.length == 0) {
            length = bArr.length + 1;
        } else {
            length = bArr2.length + 1 + bArr.length;
        }
        byte[] bArr3 = START_CODE;
        byte[] bArr4 = new byte[bArr3.length + 1 + 1 + 2 + length + 1];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int length2 = START_CODE.length + 0;
        bArr4[length2] = TARGET_ADDR;
        int i = length2 + 1;
        bArr4[i] = -8;
        int i2 = i + 1;
        bArr4[i2] = (byte) ((length >> 8) & 255);
        int i3 = i2 + 1;
        bArr4[i3] = (byte) (length & 255);
        int i4 = i3 + 1;
        bArr4[i4] = packageCounter;
        int i5 = i4 + 1;
        if (bArr2 != null && bArr2.length != 0) {
            System.arraycopy(bArr2, 0, bArr4, i5, bArr2.length);
            i5 += bArr2.length;
        }
        System.arraycopy(bArr, 0, bArr4, i5, bArr.length);
        byte[] bArr5 = START_CODE;
        byte b = bArr4[bArr5.length];
        int length3 = bArr5.length;
        while (true) {
            length3++;
            if (length3 < bArr4.length - 1) {
                b = (byte) (b ^ bArr4[length3]);
            } else {
                bArr4[bArr4.length - 1] = b;
                packageCounter = (byte) (packageCounter + 1);
                return bArr4;
            }
        }
    }

    public static void resumeLasttimeCounter() {
        packageCounter = (byte) (packageCounter - 1);
    }

    public static byte getCounter() {
        return packageCounter;
    }
}
