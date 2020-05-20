package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.commons.codec.net.StringEncodings;

/* loaded from: classes.dex */
public class ICC_Profile {
    private static HashMap<String, Integer> cstags;
    protected byte[] data;
    protected int numComponents;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        cstags = hashMap;
        hashMap.put("XYZ ", 3);
        cstags.put("Lab ", 3);
        cstags.put("Luv ", 3);
        cstags.put("YCbr", 3);
        cstags.put("Yxy ", 3);
        cstags.put("RGB ", 3);
        cstags.put("GRAY", 1);
        cstags.put("HSV ", 3);
        cstags.put("HLS ", 3);
        cstags.put("CMYK", 4);
        cstags.put("CMY ", 3);
        cstags.put("2CLR", 2);
        cstags.put("3CLR", 3);
        cstags.put("4CLR", 4);
        cstags.put("5CLR", 5);
        cstags.put("6CLR", 6);
        cstags.put("7CLR", 7);
        cstags.put("8CLR", 8);
        cstags.put("9CLR", 9);
        cstags.put("ACLR", 10);
        cstags.put("BCLR", 11);
        cstags.put("CCLR", 12);
        cstags.put("DCLR", 13);
        cstags.put("ECLR", 14);
        cstags.put("FCLR", 15);
    }

    protected ICC_Profile() {
    }

    public static ICC_Profile getInstance(byte[] bArr, int i) {
        int i2 = 0;
        if (bArr.length < 128 || bArr[36] != 97 || bArr[37] != 99 || bArr[38] != 115 || bArr[39] != 112) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
        }
        try {
            ICC_Profile iCC_Profile = new ICC_Profile();
            iCC_Profile.data = bArr;
            Integer num = cstags.get(new String(bArr, 16, 4, StringEncodings.US_ASCII));
            if (num != null) {
                i2 = num.intValue();
            }
            iCC_Profile.numComponents = i2;
            if (i2 == i) {
                return iCC_Profile;
            }
            throw new IllegalArgumentException("ICC profile contains " + i2 + " component(s), the image data contains " + i + " component(s)");
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ICC_Profile getInstance(byte[] bArr) {
        try {
            Integer num = cstags.get(new String(bArr, 16, 4, StringEncodings.US_ASCII));
            return getInstance(bArr, num == null ? 0 : num.intValue());
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ICC_Profile getInstance(InputStream inputStream) {
        int i = 128;
        try {
            byte[] bArr = new byte[128];
            int i2 = 128;
            int i3 = 0;
            while (i2 > 0) {
                int read = inputStream.read(bArr, i3, i2);
                if (read < 0) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
                }
                i2 -= read;
                i3 += read;
            }
            if (bArr[36] != 97 || bArr[37] != 99 || bArr[38] != 115 || bArr[39] != 112) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
            }
            int i4 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, 128);
            int i5 = i4 - 128;
            while (i5 > 0) {
                int read2 = inputStream.read(bArr2, i, i5);
                if (read2 < 0) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
                }
                i5 -= read2;
                i += read2;
            }
            return getInstance(bArr2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ICC_Profile GetInstance(String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    ICC_Profile iCC_Profile = getInstance(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return iCC_Profile;
                } catch (Exception e) {
                    e = e;
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getNumComponents() {
        return this.numComponents;
    }
}
