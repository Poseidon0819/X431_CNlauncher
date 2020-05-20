package com.thoughtworks.xstream.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes2.dex */
public class Base64Encoder {
    private static final char[] SIXTY_FOUR_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] REVERSE_MAPPING = new int[123];

    static {
        int i = 0;
        while (true) {
            char[] cArr = SIXTY_FOUR_CHARS;
            if (i >= cArr.length) {
                return;
            }
            int[] iArr = REVERSE_MAPPING;
            char c = cArr[i];
            i++;
            iArr[c] = i;
        }
    }

    public String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2 += 3) {
            int min = Math.min(3, bArr.length - i2);
            int i3 = ((bArr[i2] & 255) << 16) | ((min <= 1 ? 0 : bArr[i2 + 1] & 255) << 8) | (min <= 2 ? 0 : bArr[i2 + 2] & 255);
            int i4 = 0;
            while (i4 < 4) {
                stringBuffer.append(min + 1 > i4 ? SIXTY_FOUR_CHARS[(i3 >> ((3 - i4) * 6)) & 63] : SignatureVisitor.INSTANCEOF);
                i4++;
            }
            i += 4;
            if (i % 76 == 0) {
                stringBuffer.append('\n');
            }
        }
        return stringBuffer.toString();
    }

    public byte[] decode(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StringReader stringReader = new StringReader(str);
            for (int i = 0; i < str.length(); i += 4) {
                int[] iArr = {mapCharToInt(stringReader), mapCharToInt(stringReader), mapCharToInt(stringReader), mapCharToInt(stringReader)};
                int i2 = ((iArr[0] & 63) << 18) | ((iArr[1] & 63) << 12) | ((iArr[2] & 63) << 6) | (iArr[3] & 63);
                int i3 = 0;
                while (i3 < 3) {
                    int i4 = i3 + 1;
                    if (iArr[i4] >= 0) {
                        byteArrayOutputStream.write((i2 >> ((2 - i3) * 8)) & 255);
                    }
                    i3 = i4;
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new Error(e + ": " + e.getMessage());
        }
    }

    private int mapCharToInt(Reader reader) throws IOException {
        int read;
        do {
            read = reader.read();
            if (read == -1) {
                return -1;
            }
            int i = REVERSE_MAPPING[read];
            if (i != 0) {
                return i - 1;
            }
        } while (read != 61);
        return -1;
    }
}
